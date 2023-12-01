package com.opos.mobad.model.e;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/e/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.opos.cmn.an.d.d.a f26485a;
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Boolean> f26486c = new ConcurrentHashMap();

    private static com.opos.cmn.an.d.d.a a(Context context) {
        com.opos.cmn.an.d.d.a aVar;
        com.opos.cmn.an.d.d.a aVar2 = f26485a;
        if (aVar2 == null) {
            synchronized (b) {
                com.opos.cmn.an.d.d.a aVar3 = f26485a;
                aVar = aVar3;
                if (aVar3 == null) {
                    aVar = new com.opos.cmn.an.d.d.a(context, "mobad.record.show.prefs", 0);
                    f26485a = aVar;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    public static String a() {
        return "https://uapi.ads.heytapmobi.com/union/ads/v2/show";
    }

    public static void a(Context context, String str, boolean z) {
        try {
            com.opos.cmn.an.f.a.b("Utils", "updateRecordEvent posId=" + str + ",record=" + z);
            if (z != a(context, str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("really updateRecordEvent=");
                sb.append(str != null ? str : com.igexin.push.core.b.l);
                sb.append(",record=");
                sb.append(z);
                com.opos.cmn.an.f.a.b("Utils", sb.toString());
                f26486c.put(str, Boolean.valueOf(z));
                b(context, str, z);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
        }
    }

    public static boolean a(Context context, String str) {
        boolean z = false;
        if (context != null) {
            boolean z2 = false;
            z = false;
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    if (f26486c.containsKey(str)) {
                        z2 = false;
                        z = f26486c.get(str).booleanValue();
                    } else {
                        z = b(context, str);
                        z2 = z;
                        f26486c.put(str, Boolean.valueOf(z));
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
                z = z2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("recordShowEvent posId=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return z;
    }

    private static void b(Context context, String str, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("putRecordShowEvent posId=");
            sb.append(str != null ? str : com.igexin.push.core.b.l);
            sb.append(",record=");
            sb.append(z);
            com.opos.cmn.an.f.a.b("Utils", sb.toString());
            if (context == null || com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            a(context).a(str, Boolean.valueOf(z));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L21
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L18
            if (r0 != 0) goto L21
            r0 = r4
            com.opos.cmn.an.d.d.a r0 = a(r0)     // Catch: java.lang.Exception -> L18
            r1 = r5
            r2 = 1
            boolean r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L18
            r6 = r0
            goto L23
        L18:
            r4 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L21:
            r0 = 0
            r6 = r0
        L23:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "getRecordShowEvent posId="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L39
            goto L3c
        L39:
            java.lang.String r0 = "null"
            r5 = r0
        L3c:
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.e.d.b(android.content.Context, java.lang.String):boolean");
    }
}
