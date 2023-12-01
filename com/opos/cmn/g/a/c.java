package com.opos.cmn.g.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.baselib.utils.ClientIdUtils;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f11262a = "localId";
    private static volatile String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f11263c = false;
    private static final byte[] d = new byte[0];

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r8 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r7 = r0
            java.lang.String r0 = ""
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r7
            r1 = 29
            if (r0 >= r1) goto L42
            r0 = r6
            if (r0 == 0) goto L31
            com.heytap.baselib.utils.ClientIdUtils r0 = com.heytap.baselib.utils.ClientIdUtils.INSTANCE     // Catch: java.lang.Exception -> L28
            r1 = r6
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Exception -> L28
            java.lang.String r0 = r0.getClientId(r1)     // Catch: java.lang.Exception -> L28
            r6 = r0
            goto L34
        L28:
            r6 = move-exception
            java.lang.String r0 = "ImeiTool"
            java.lang.String r1 = "getImei"
            r2 = r6
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L31:
            java.lang.String r0 = ""
            r6 = r0
        L34:
            r0 = r6
            if (r0 != 0) goto L3f
            r0 = r11
            r10 = r0
            goto L42
        L3f:
            r0 = r6
            r10 = r0
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getImei result:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = " costTime:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            long r1 = java.lang.System.currentTimeMillis()
            r2 = r8
            long r1 = r1 - r2
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "ImeiTool"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.c.a(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r6) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r8 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r7 = r0
            java.lang.String r0 = ""
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r7
            r1 = 29
            if (r0 >= r1) goto L42
            r0 = r6
            if (r0 == 0) goto L31
            com.heytap.baselib.utils.ClientIdUtils r0 = com.heytap.baselib.utils.ClientIdUtils.INSTANCE     // Catch: java.lang.Exception -> L28
            r1 = r6
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Exception -> L28
            java.lang.String r0 = r0.refreshClientId(r1)     // Catch: java.lang.Exception -> L28
            r6 = r0
            goto L34
        L28:
            r6 = move-exception
            java.lang.String r0 = "ImeiTool"
            java.lang.String r1 = "refreshClientId"
            r2 = r6
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L31:
            java.lang.String r0 = ""
            r6 = r0
        L34:
            r0 = r6
            if (r0 != 0) goto L3f
            r0 = r11
            r10 = r0
            goto L42
        L3f:
            r0 = r6
            r10 = r0
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "refreshClientId result:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = " costTime:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            long r1 = java.lang.System.currentTimeMillis()
            r2 = r8
            long r1 = r1 - r2
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "ImeiTool"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.c.b(android.content.Context):java.lang.String");
    }

    public static String c(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 29) {
            if (context != null) {
                try {
                    final Context applicationContext = context.getApplicationContext();
                    if (TextUtils.isEmpty(b)) {
                        synchronized (d) {
                            if (TextUtils.isEmpty(b)) {
                                b = i.f(applicationContext);
                                if (!f11263c) {
                                    f11263c = true;
                                    new Thread(new Runnable() { // from class: com.opos.cmn.g.a.c.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Map<String, String> buildIdMap = ClientIdUtils.INSTANCE.buildIdMap(Context.this);
                                            if (buildIdMap != null) {
                                                String unused = c.b = buildIdMap.get(c.f11262a);
                                                i.e(Context.this, c.b);
                                            }
                                        }
                                    }).start();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("ImeiTool", "getLocalId", e);
                }
            }
            if (b == null) {
                b = "";
            }
        }
        com.opos.cmn.an.f.a.b("ImeiTool", "getLocalId result:" + b + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }
}
