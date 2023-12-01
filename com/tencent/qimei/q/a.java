package com.tencent.qimei.q;

import com.tencent.qimei.sdk.Qimei;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/q/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38403a = "a";
    public static final Map<String, a> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public final String f38404c;
    public boolean d = false;
    public boolean e = false;
    public Qimei f;
    public boolean g;

    public a(String str) {
        this.f38404c = str;
    }

    public static a a(String str) {
        a aVar;
        synchronized (a.class) {
            try {
                a aVar2 = b.get(str);
                aVar = aVar2;
                if (aVar2 == null) {
                    aVar = new a(str);
                    b.put(str, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r5.e != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.g
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = r6
            if (r0 == 0) goto L13
            r0 = r5
            boolean r0 = r0.d
            r6 = r0
            goto L41
        L13:
            r0 = r5
            java.lang.String r0 = r0.f38404c
            com.tencent.qimei.i.f r0 = com.tencent.qimei.i.f.a(r0)
            java.lang.String r1 = "q_s_t"
            long r0 = r0.b(r1)
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L29
            goto L3f
        L29:
            long r0 = com.tencent.qimei.c.a.c()
            r10 = r0
            r0 = r5
            r1 = 1
            r0.g = r1
            r0 = r10
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L3f
            r0 = 1
            r6 = r0
            goto L41
        L3f:
            r0 = 0
            r6 = r0
        L41:
            r0 = r5
            r1 = r6
            r0.d = r1
            r0 = r6
            if (r0 != 0) goto L53
            r0 = r7
            r6 = r0
            r0 = r5
            boolean r0 = r0.e
            if (r0 == 0) goto L55
        L53:
            r0 = 1
            r6 = r0
        L55:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.q.a.a():boolean");
    }
}
