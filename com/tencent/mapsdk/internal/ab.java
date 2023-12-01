package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ab.class */
public final class ab<T, K> {
    private static final int d = 1024;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<T, K> f23604a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f23605c = 1024;

    public K a(T t) {
        synchronized (this) {
            HashMap<T, K> hashMap = this.f23604a;
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(t);
        }
    }

    public void a(int i) {
        this.f23605c = i;
    }

    public void a(T t, K k) {
        synchronized (this) {
            if (this.f23604a == null) {
                this.f23604a = new HashMap<>();
            }
            this.f23604a.put(t, k);
        }
    }

    public void b(T t) {
        synchronized (this) {
            HashMap<T, K> hashMap = this.f23604a;
            if (hashMap == null) {
                return;
            }
            hashMap.remove(t);
        }
    }
}
