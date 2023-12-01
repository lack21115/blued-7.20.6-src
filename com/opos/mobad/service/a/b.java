package com.opos.mobad.service.a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Long> f13594a = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L28
            if (r0 != 0) goto L33
            r0 = r4
            java.util.Map<java.lang.String, java.lang.Long> r0 = r0.f13594a     // Catch: java.lang.Exception -> L28
            r1 = r5
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Exception -> L28
            if (r0 == 0) goto L33
            r0 = r4
            java.util.Map<java.lang.String, java.lang.Long> r0 = r0.f13594a     // Catch: java.lang.Exception -> L28
            r1 = r5
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L28
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Exception -> L28
            long r0 = r0.longValue()     // Catch: java.lang.Exception -> L28
            r6 = r0
            goto L37
        L28:
            r8 = move-exception
            java.lang.String r0 = "CommonConfig"
            java.lang.String r1 = ""
            r2 = r8
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L33:
            r0 = 60000(0xea60, double:2.9644E-319)
            r6 = r0
        L37:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "getRefreshTime posId="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L4f
            goto L52
        L4f:
            java.lang.String r0 = "null"
            r5 = r0
        L52:
            r0 = r8
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "CommonConfig"
            r1 = r8
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.b.a(java.lang.String):long");
    }

    public void a(String str, int i) {
        try {
            if (!com.opos.cmn.an.c.a.a(str) && i > 0) {
                this.f13594a.put(str, Long.valueOf(i * 1000));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CommonConfig", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setRefreshTime posId=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",refreshTime=");
        sb.append(i);
        com.opos.cmn.an.f.a.b("CommonConfig", sb.toString());
    }
}
