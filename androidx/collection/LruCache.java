package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/LruCache.class */
public class LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f1903a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f1904c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1904c = i;
        this.f1903a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int b(K k, V v) {
        int a2 = a(k, v);
        if (a2 >= 0) {
            return a2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int a(K k, V v) {
        return 1;
    }

    protected V a(K k) {
        return null;
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    public final int createCount() {
        int i;
        synchronized (this) {
            i = this.e;
        }
        return i;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this) {
            i = this.f;
        }
        return i;
    }

    public final V get(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                V v = this.f1903a.get(k);
                if (v != null) {
                    this.g++;
                    return v;
                }
                this.h++;
                V a2 = a(k);
                if (a2 == null) {
                    return null;
                }
                synchronized (this) {
                    this.e++;
                    put = this.f1903a.put(k, a2);
                    if (put != null) {
                        this.f1903a.put(k, put);
                    } else {
                        this.b += b(k, a2);
                    }
                }
                if (put != null) {
                    a(false, k, a2, put);
                    return put;
                }
                trimToSize(this.f1904c);
                return a2;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final int hitCount() {
        int i;
        synchronized (this) {
            i = this.g;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this) {
            i = this.f1904c;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this) {
            i = this.h;
        }
        return i;
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += b(k, v);
            put = this.f1903a.put(k, v);
            if (put != null) {
                this.b -= b(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        trimToSize(this.f1904c);
        return put;
    }

    public final int putCount() {
        int i;
        synchronized (this) {
            i = this.d;
        }
        return i;
    }

    public final V remove(K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                remove = this.f1903a.remove(k);
                if (remove != null) {
                    this.b -= b(k, remove);
                }
            }
            if (remove != null) {
                a(false, k, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f1904c = i;
        }
        trimToSize(i);
    }

    public final int size() {
        int i;
        synchronized (this) {
            i = this.b;
        }
        return i;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this) {
            linkedHashMap = new LinkedHashMap(this.f1903a);
        }
        return linkedHashMap;
    }

    public final String toString() {
        String format;
        synchronized (this) {
            int i = this.g + this.h;
            format = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f1904c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
        }
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00aa, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trimToSize(int r7) {
        /*
            r6 = this;
        L0:
            r0 = r6
            monitor-enter(r0)
            r0 = r6
            int r0 = r0.b     // Catch: java.lang.Throwable -> Lab
            if (r0 < 0) goto L84
            r0 = r6
            java.util.LinkedHashMap<K, V> r0 = r0.f1903a     // Catch: java.lang.Throwable -> Lab
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L1a
            r0 = r6
            int r0 = r0.b     // Catch: java.lang.Throwable -> Lab
            if (r0 != 0) goto L84
        L1a:
            r0 = r6
            int r0 = r0.b     // Catch: java.lang.Throwable -> Lab
            r1 = r7
            if (r0 <= r1) goto L81
            r0 = r6
            java.util.LinkedHashMap<K, V> r0 = r0.f1903a     // Catch: java.lang.Throwable -> Lab
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L2f
            goto L81
        L2f:
            r0 = r6
            java.util.LinkedHashMap<K, V> r0 = r0.f1903a     // Catch: java.lang.Throwable -> Lab
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> Lab
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lab
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> Lab
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> Lab
            r9 = r0
            r0 = r9
            java.lang.Object r0 = r0.getKey()     // Catch: java.lang.Throwable -> Lab
            r8 = r0
            r0 = r9
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> Lab
            r9 = r0
            r0 = r6
            java.util.LinkedHashMap<K, V> r0 = r0.f1903a     // Catch: java.lang.Throwable -> Lab
            r1 = r8
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> Lab
            r0 = r6
            r1 = r6
            int r1 = r1.b     // Catch: java.lang.Throwable -> Lab
            r2 = r6
            r3 = r8
            r4 = r9
            int r2 = r2.b(r3, r4)     // Catch: java.lang.Throwable -> Lab
            int r1 = r1 - r2
            r0.b = r1     // Catch: java.lang.Throwable -> Lab
            r0 = r6
            r1 = r6
            int r1 = r1.f     // Catch: java.lang.Throwable -> Lab
            r2 = 1
            int r1 = r1 + r2
            r0.f = r1     // Catch: java.lang.Throwable -> Lab
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lab
            r0 = r6
            r1 = 1
            r2 = r8
            r3 = r9
            r4 = 0
            r0.a(r1, r2, r3, r4)
            goto L0
        L81:
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lab
            return
        L84:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lab
            r8 = r0
            r0 = r8
            r1 = r6
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> Lab
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lab
            r0 = r8
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lab
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lab
            r1 = r0
            r2 = r8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lab
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lab
            throw r0     // Catch: java.lang.Throwable -> Lab
        Lab:
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lab
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
