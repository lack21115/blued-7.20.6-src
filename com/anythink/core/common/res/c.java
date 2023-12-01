package com.anythink.core.common.res;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/c.class */
public class c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f6905a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f6906c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f6906c = i;
        this.f6905a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private void a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f6906c = i;
        }
        b(i);
    }

    private static V b() {
        return null;
    }

    private V b(K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                remove = this.f6905a.remove(k);
                if (remove != null) {
                    this.b -= c(k, remove);
                }
            }
            if (remove != null) {
                a(false, k, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    private void b(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.b < 0 || (this.f6905a.isEmpty() && this.b != 0)) {
                        break;
                    } else if (this.b <= i) {
                        return;
                    } else {
                        Map.Entry<K, V> next = this.f6905a.entrySet().size() > 0 ? this.f6905a.entrySet().iterator().next() : null;
                        if (next == null) {
                            return;
                        }
                        key = next.getKey();
                        value = next.getValue();
                        this.f6905a.remove(key);
                        this.b -= c(key, value);
                        this.f++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            a(true, key, value, null);
        }
        this.b = 0;
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results! --> size: " + this.b + ", map.isEmpty(): " + this.f6905a.isEmpty());
    }

    private int c() {
        int i;
        synchronized (this) {
            i = this.b;
        }
        return i;
    }

    private int c(K k, V v) {
        int a2 = a(k, v);
        if (a2 >= 0) {
            return a2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    private int d() {
        int i;
        synchronized (this) {
            i = this.f6906c;
        }
        return i;
    }

    private int e() {
        int i;
        synchronized (this) {
            i = this.g;
        }
        return i;
    }

    private int f() {
        int i;
        synchronized (this) {
            i = this.h;
        }
        return i;
    }

    private int g() {
        int i;
        synchronized (this) {
            i = this.e;
        }
        return i;
    }

    private int h() {
        int i;
        synchronized (this) {
            i = this.d;
        }
        return i;
    }

    private int i() {
        int i;
        synchronized (this) {
            i = this.f;
        }
        return i;
    }

    private Map<K, V> j() {
        LinkedHashMap linkedHashMap;
        synchronized (this) {
            linkedHashMap = new LinkedHashMap(this.f6905a);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
        r6.f6905a.clear();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.res.c.k():void");
    }

    protected int a(K k, V v) {
        return 1;
    }

    public final V a(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.f6905a.get(k);
                if (v != null) {
                    this.g++;
                    return v;
                }
                this.h++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final void a() {
        b(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, K k, V v, V v2) {
    }

    public final V b(K k, V v) {
        V put;
        if (k != null) {
            synchronized (this) {
                this.d++;
                this.b += c(k, v);
                put = this.f6905a.put(k, v);
                if (put != null) {
                    this.b -= c(k, put);
                }
            }
            if (put != null) {
                a(false, k, put, v);
            }
            b(this.f6906c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final String toString() {
        String format;
        synchronized (this) {
            int i = this.g + this.h;
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f6906c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
        }
        return format;
    }
}
