package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/LruCache.class */
public class LruCache<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f21104a = new LinkedHashMap(100, 0.75f, true);
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private long f21105c;
    private long d;

    public LruCache(long j) {
        this.b = j;
        this.f21105c = j;
    }

    private void d() {
        a(this.f21105c);
    }

    public int a(Y y) {
        return 1;
    }

    public long a() {
        long j;
        synchronized (this) {
            j = this.d;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j) {
        synchronized (this) {
            while (this.d > j) {
                Iterator<Map.Entry<T, Y>> it = this.f21104a.entrySet().iterator();
                Map.Entry<T, Y> next = it.next();
                Y value = next.getValue();
                this.d -= a((LruCache<T, Y>) value);
                T key = next.getKey();
                it.remove();
                a(key, value);
            }
        }
    }

    protected void a(T t, Y y) {
    }

    public long b() {
        long j;
        synchronized (this) {
            j = this.f21105c;
        }
        return j;
    }

    public Y b(T t) {
        Y y;
        synchronized (this) {
            y = this.f21104a.get(t);
        }
        return y;
    }

    public Y b(T t, Y y) {
        synchronized (this) {
            long a2 = a((LruCache<T, Y>) y);
            if (a2 >= this.f21105c) {
                a(t, y);
                return null;
            }
            if (y != null) {
                this.d += a2;
            }
            Y put = this.f21104a.put(t, y);
            if (put != null) {
                this.d -= a((LruCache<T, Y>) put);
                if (!put.equals(y)) {
                    a(t, put);
                }
            }
            d();
            return put;
        }
    }

    public Y c(T t) {
        Y remove;
        synchronized (this) {
            remove = this.f21104a.remove(t);
            if (remove != null) {
                this.d -= a((LruCache<T, Y>) remove);
            }
        }
        return remove;
    }

    public void c() {
        a(0L);
    }
}
