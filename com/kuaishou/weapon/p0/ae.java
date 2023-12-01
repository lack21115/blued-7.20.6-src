package com.kuaishou.weapon.p0;

import android.content.Context;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ae.class */
public class ae {
    public static String a(Context context) {
        try {
            return f.b(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a("/data", true) ? 1 : 0);
            jSONObject.put("1", a("/system/bin", true) ? 1 : 0);
            jSONObject.put("2", a("/system/lib", true) ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean a(String str) {
        return new File(File.separator + "proc" + File.separator + str).canWrite();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r7 = r0
            r0 = r5
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L42
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L8c
            r7 = r0
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L8c
            r0 = r7
            java.lang.String r1 = "/-"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L8c
            r0 = r7
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L8c
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8c
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L8c
            r5 = r0
            r0 = r5
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L8c
            r0 = r5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8c
            r7 = r0
        L42:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L8c java.lang.Throwable -> L8c
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8c
            r8 = r0
            r0 = r8
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L8c
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8c
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8c
            r5 = r0
            r0 = r5
            r1 = r7
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L90
            r0.write(r1)     // Catch: java.lang.Throwable -> L90
            r0 = r5
            r0.flush()     // Catch: java.lang.Throwable -> L90
            r0 = r5
            r0.close()     // Catch: java.lang.Throwable -> L90
            r0 = r6
            if (r0 == 0) goto L77
            r0 = r8
            boolean r0 = r0.delete()     // Catch: java.lang.Throwable -> L90
        L77:
            r0 = r5
            r0.close()     // Catch: java.lang.Exception -> L94
        L7b:
            r0 = 1
            return r0
        L7d:
            goto L82
        L80:
            r0 = 0
            r5 = r0
        L82:
            r0 = r5
            if (r0 == 0) goto L8a
            r0 = r5
            r0.close()     // Catch: java.lang.Exception -> L98
        L8a:
            r0 = 0
            return r0
        L8c:
            r5 = move-exception
            goto L80
        L90:
            r7 = move-exception
            goto L7d
        L94:
            r5 = move-exception
            goto L7b
        L98:
            r5 = move-exception
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ae.a(java.lang.String, boolean):boolean");
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a("/sys", true) ? 1 : 0);
            jSONObject.put("1", a("/sbin", true) ? 1 : 0);
            jSONObject.put("2", a("/etc", true) ? 1 : 0);
            jSONObject.put("3", a("/dev", true) ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(String str) {
        return a(str, false);
    }
}
