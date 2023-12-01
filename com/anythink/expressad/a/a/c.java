package com.anythink.expressad.a.a;

import com.anythink.expressad.foundation.g.a.e;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a/c.class */
public final class c implements e<String, b> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, b> f6953a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f6954c;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f6953a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r5) {
        /*
            r4 = this;
        L0:
            r0 = r4
            monitor-enter(r0)
            r0 = r4
            int r0 = r0.f6954c     // Catch: java.lang.Throwable -> L9e
            if (r0 < 0) goto L77
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r0.f6953a     // Catch: java.lang.Throwable -> L9e
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L1a
            r0 = r4
            int r0 = r0.f6954c     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L77
        L1a:
            r0 = r4
            int r0 = r0.f6954c     // Catch: java.lang.Throwable -> L9e
            r1 = r5
            if (r0 <= r1) goto L74
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r0.f6953a     // Catch: java.lang.Throwable -> L9e
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L2f
            goto L74
        L2f:
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r0.f6953a     // Catch: java.lang.Throwable -> L9e
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L9e
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L9e
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L4b
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9e
            return
        L4b:
            r0 = r6
            java.lang.Object r0 = r0.getKey()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L9e
            r7 = r0
            r0 = r6
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L9e
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r0.f6953a     // Catch: java.lang.Throwable -> La3
            r1 = r7
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> La3
            r0 = r4
            r1 = r4
            int r1 = r1.f6954c     // Catch: java.lang.Throwable -> La3
            r2 = 1
            int r1 = r1 - r2
            r0.f6954c = r1     // Catch: java.lang.Throwable -> La3
        L6f:
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9e
            goto L0
        L74:
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9e
            return
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            r0 = r6
            r1 = r4
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            r0 = r6
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L9e
            r1 = r0
            r2 = r6
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L9e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9e
            throw r0     // Catch: java.lang.Throwable -> L9e
        L9e:
            r6 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r6
            throw r0
        La3:
            r6 = move-exception
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.c.a(int):void");
    }

    private static int c() {
        return 1;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final b b(String str) {
        if (str != null) {
            synchronized (this) {
                b bVar = this.f6953a.get(str);
                if (bVar != null) {
                    return bVar;
                }
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f6953a.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final boolean a(String str, b bVar) {
        if (str == null || bVar == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f6954c++;
            if (this.f6953a.put(str, bVar) != null) {
                this.f6954c--;
            }
        }
        a(this.b);
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final void b() {
        a(-1);
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.f6953a.remove(str) != null) {
                this.f6954c--;
            }
        }
    }

    public final String toString() {
        String format;
        synchronized (this) {
            format = String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
        }
        return format;
    }
}
