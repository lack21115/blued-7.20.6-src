package com.anythink.expressad.foundation.g.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/a/d.class */
public final class d implements e<String, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private int f4991c;
    private final int b = 1000;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, JSONObject> f4990a = new LinkedHashMap<>(0, 0.75f, true);

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
            int r0 = r0.f4991c     // Catch: java.lang.Throwable -> L9e
            if (r0 < 0) goto L77
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r0.f4990a     // Catch: java.lang.Throwable -> L9e
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L1a
            r0 = r4
            int r0 = r0.f4991c     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L77
        L1a:
            r0 = r4
            int r0 = r0.f4991c     // Catch: java.lang.Throwable -> L9e
            r1 = r5
            if (r0 <= r1) goto L74
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r0.f4990a     // Catch: java.lang.Throwable -> L9e
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L2f
            goto L74
        L2f:
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r0.f4990a     // Catch: java.lang.Throwable -> L9e
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
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r0.f4990a     // Catch: java.lang.Throwable -> La3
            r1 = r7
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> La3
            r0 = r4
            r1 = r4
            int r1 = r1.f4991c     // Catch: java.lang.Throwable -> La3
            r2 = 1
            int r1 = r1 - r2
            r0.f4991c = r1     // Catch: java.lang.Throwable -> La3
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
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.a.d.a(int):void");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private void b2(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.f4990a.remove(str) != null) {
                this.f4991c--;
            }
        }
    }

    private static int c() {
        return 1;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f4990a.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final JSONObject b(String str) {
        JSONObject jSONObject;
        if (str != null) {
            synchronized (this) {
                jSONObject = this.f4990a.get(str);
            }
            return jSONObject;
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        if (str2 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.f4990a.remove(str2) != null) {
                this.f4991c--;
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final boolean a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f4991c++;
            if (this.f4990a.put(str, jSONObject) != null) {
                this.f4991c--;
            }
        }
        a(this.b);
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final void b() {
        a(-1);
    }

    public final String toString() {
        String format;
        synchronized (this) {
            format = String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
        }
        return format;
    }
}
