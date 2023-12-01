package com.sdk.tencent.b;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/b/b.class */
public class b<K, V> extends ConcurrentHashMap<K, Long> {
    public b(int i, float f) {
        super(i, f, 16);
    }

    public Long a(Object obj) {
        Long l;
        synchronized (this) {
            l = (Long) super.remove(obj);
        }
        return l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public Long put(K k, Long l) {
        Long l2;
        synchronized (this) {
            if (containsKey(k)) {
                synchronized (this) {
                    Long l3 = (Long) super.remove(k);
                }
            }
            l2 = (Long) super.put(k, l);
        }
        return l2;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        synchronized (this) {
            super.clear();
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        boolean z;
        synchronized (this) {
            z = false;
            Long l = (Long) super.get(obj);
            if (l == null || System.currentTimeMillis() >= l.longValue()) {
                synchronized (this) {
                    Long l2 = (Long) super.remove(obj);
                }
            } else {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Long l;
        synchronized (this) {
            l = containsKey(obj) ? (Long) super.get(obj) : null;
        }
        return l;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Long l;
        synchronized (this) {
            l = (Long) super.remove(obj);
        }
        return l;
    }
}
