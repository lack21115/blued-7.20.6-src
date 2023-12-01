package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ab.class */
public final class ab<T, K> {
    private static final int d = 1024;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<T, K> f37295a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f37296c = 1024;

    public K a(T t) {
        synchronized (this) {
            HashMap<T, K> hashMap = this.f37295a;
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(t);
        }
    }

    public void a(int i) {
        this.f37296c = i;
    }

    public void a(T t, K k) {
        synchronized (this) {
            if (this.f37295a == null) {
                this.f37295a = new HashMap<>();
            }
            this.f37295a.put(t, k);
        }
    }

    public void b(T t) {
        synchronized (this) {
            HashMap<T, K> hashMap = this.f37295a;
            if (hashMap == null) {
                return;
            }
            hashMap.remove(t);
        }
    }
}
