package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bd.class */
public class bd implements as {

    /* renamed from: a  reason: collision with root package name */
    private static String f41274a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String b = f41274a + "OAID";

    /* renamed from: c  reason: collision with root package name */
    private static String f41275c = f41274a + "VAID_";
    private static String d = f41274a + "AAID_";
    private static String e = f41274a + "OAIDSTATUS";
    private static String f = "persist.sys.identifierid.supported";

    /* renamed from: a  reason: collision with other field name */
    private Context f215a;

    public bd(Context context) {
        this.f215a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        if (r9 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r11 = r0
            r0 = 0
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = r7
            android.content.Context r0 = r0.f215a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L72
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L72
            r1 = r8
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L72
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L72
            r9 = r0
            r0 = r12
            r8 = r0
            r0 = r9
            if (r0 == 0) goto L47
            r0 = r12
            r8 = r0
            r0 = r9
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L76
            if (r0 == 0) goto L47
            r0 = r9
            r1 = r9
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L76
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L76
            r8 = r0
            goto L47
        L40:
            r8 = move-exception
            goto L58
        L44:
            goto L66
        L47:
            r0 = r8
            r10 = r0
            r0 = r9
            if (r0 == 0) goto L70
        L4d:
            r0 = r9
            r0.close()
            r0 = r8
            return r0
        L55:
            r8 = move-exception
            r0 = 0
            r9 = r0
        L58:
            r0 = r9
            if (r0 == 0) goto L62
            r0 = r9
            r0.close()
        L62:
            r0 = r8
            throw r0
        L64:
            r0 = 0
            r9 = r0
        L66:
            r0 = r9
            if (r0 == 0) goto L70
            r0 = r11
            r8 = r0
            goto L4d
        L70:
            r0 = r10
            return r0
        L72:
            r8 = move-exception
            goto L64
        L76:
            r8 = move-exception
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bd.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f41274a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                return (resolveContentProvider.applicationInfo.flags & 1) != 0;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public String mo11508a() {
        return a(b);
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo11509a() {
        return "1".equals(q.a(f, "0"));
    }
}
