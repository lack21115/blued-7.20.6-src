package com.youzan.spiderman.b;

import com.youzan.spiderman.utils.Logger;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/h.class */
public class h<K, V> {
    private static final String h = h.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f28040a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f28041c;
    private int d;
    private int e;
    private int f;
    private int g;

    public h(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f28041c = j;
        this.f28040a = new LinkedHashMap<>(0, 0.75f, true);
        this.b = 0L;
        String str = h;
        Logger.i(str, "size: " + String.valueOf(this.b / 1024), new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(long r8) {
        /*
            r7 = this;
        L0:
            r0 = r7
            monitor-enter(r0)
            r0 = r7
            long r0 = r0.b     // Catch: java.lang.Throwable -> Lb6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L8f
            r0 = r7
            java.util.LinkedHashMap<K, V> r0 = r0.f28040a     // Catch: java.lang.Throwable -> Lb6
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto L1e
            r0 = r7
            long r0 = r0.b     // Catch: java.lang.Throwable -> Lb6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L8f
        L1e:
            r0 = r7
            long r0 = r0.b     // Catch: java.lang.Throwable -> Lb6
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L8c
            r0 = r7
            java.util.LinkedHashMap<K, V> r0 = r0.f28040a     // Catch: java.lang.Throwable -> Lb6
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto L34
            goto L8c
        L34:
            r0 = r7
            java.util.LinkedHashMap<K, V> r0 = r0.f28040a     // Catch: java.lang.Throwable -> Lb6
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> Lb6
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lb6
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> Lb6
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> Lb6
            r11 = r0
            r0 = r11
            java.lang.Object r0 = r0.getKey()     // Catch: java.lang.Throwable -> Lb6
            r10 = r0
            r0 = r11
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> Lb6
            r11 = r0
            r0 = r7
            java.util.LinkedHashMap<K, V> r0 = r0.f28040a     // Catch: java.lang.Throwable -> Lb6
            r1 = r10
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> Lb6
            r0 = r7
            r1 = r7
            long r1 = r1.b     // Catch: java.lang.Throwable -> Lb6
            r2 = r7
            r3 = r10
            r4 = r11
            long r2 = r2.c(r3, r4)     // Catch: java.lang.Throwable -> Lb6
            long r1 = r1 - r2
            r0.b = r1     // Catch: java.lang.Throwable -> Lb6
            r0 = r7
            r1 = r7
            int r1 = r1.e     // Catch: java.lang.Throwable -> Lb6
            r2 = 1
            int r1 = r1 + r2
            r0.e = r1     // Catch: java.lang.Throwable -> Lb6
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb6
            r0 = r7
            r1 = 1
            r2 = r10
            r3 = r11
            r4 = 0
            r0.a(r1, r2, r3, r4)
            goto L0
        L8c:
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb6
            return
        L8f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lb6
            r10 = r0
            r0 = r10
            r1 = r7
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lb6
            r0 = r10
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lb6
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lb6
            r1 = r0
            r2 = r10
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb6
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb6
            throw r0     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r10 = move-exception
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb6
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.spiderman.b.h.a(long):void");
    }

    private long c(K k, V v) {
        long a2 = a(k, v);
        if (a2 >= 0) {
            return a2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected long a(K k, V v) {
        return 1L;
    }

    public final void a(LinkedHashMap<K, V> linkedHashMap) {
        if (linkedHashMap != null) {
            synchronized (this) {
                for (Map.Entry<K, V> entry : linkedHashMap.entrySet()) {
                    K key = entry.getKey();
                    V value = entry.getValue();
                    this.d++;
                    this.b += c(key, value);
                    V put = this.f28040a.put(key, value);
                    if (put != null) {
                        this.b -= c(key, put);
                    }
                }
            }
            a(this.f28041c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, K k, V v, V v2) {
    }

    public final boolean a(K k) {
        if (k != null) {
            return this.f28040a.containsKey(k);
        }
        throw new NullPointerException("key == null");
    }

    public final V b(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.f28040a.get(k);
                if (v != null) {
                    this.f++;
                    return v;
                }
                this.g++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V b(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.f28040a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.f28041c);
        Logger.i(h, "map size:" + this.f28040a.size(), new Object[0]);
        return put;
    }

    public final LinkedHashMap<K, V> b() {
        return this.f28040a;
    }

    public final String toString() {
        String format;
        synchronized (this) {
            int i = this.f + this.g;
            format = String.format("ZanLruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Long.valueOf(this.f28041c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i != 0 ? (this.f * 100) / i : 0));
        }
        return format;
    }
}
