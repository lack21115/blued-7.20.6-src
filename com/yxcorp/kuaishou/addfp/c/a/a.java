package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/c/a/a.class */
public final class a {
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x041f: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:143:0x0418 */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0355 A[Catch: IOException -> 0x047e, TRY_ENTER, TryCatch #21 {IOException -> 0x047e, blocks: (B:109:0x0348, B:112:0x0355, B:115:0x035f), top: B:177:0x0348 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x035f A[Catch: IOException -> 0x047e, TRY_ENTER, TRY_LEAVE, TryCatch #21 {IOException -> 0x047e, blocks: (B:109:0x0348, B:112:0x0355, B:115:0x035f), top: B:177:0x0348 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03cf A[Catch: IOException -> 0x0483, TRY_ENTER, TryCatch #13 {IOException -> 0x0483, blocks: (B:127:0x03c2, B:130:0x03cf, B:133:0x03d9), top: B:174:0x03c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03d9 A[Catch: IOException -> 0x0483, TRY_ENTER, TRY_LEAVE, TryCatch #13 {IOException -> 0x0483, blocks: (B:127:0x03c2, B:130:0x03cf, B:133:0x03d9), top: B:174:0x03c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0452 A[Catch: IOException -> 0x0488, TRY_ENTER, TryCatch #12 {IOException -> 0x0488, blocks: (B:148:0x0445, B:151:0x0452, B:154:0x045c), top: B:172:0x0445 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x045c A[Catch: IOException -> 0x0488, TRY_ENTER, TRY_LEAVE, TryCatch #12 {IOException -> 0x0488, blocks: (B:148:0x0445, B:151:0x0452, B:154:0x045c), top: B:172:0x0445 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0445 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0348 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yxcorp.kuaishou.addfp.android.b.e a(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 1165
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(java.lang.String, boolean):com.yxcorp.kuaishou.addfp.android.b.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0156 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0159 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a():java.lang.String");
    }

    public static String a(int i, String str) {
        String str2;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        sb.append(split[1]);
        sb.append(split[2]);
        if (i == 0) {
            String a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[0], str);
            str2 = a2;
            if (TextUtils.isEmpty(a2)) {
                str2 = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            String a3 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[1], str);
            str2 = a3;
            if (TextUtils.isEmpty(a3)) {
                str2 = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            String a4 = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[2], str);
            str2 = a4;
            if (TextUtils.isEmpty(a4)) {
                str2 = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
        if (r0.size() == 0) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b A[Catch: all -> 0x0159, TRY_ENTER, TryCatch #1 {all -> 0x0159, blocks: (B:46:0x010b, B:48:0x011b), top: B:67:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f A[Catch: all -> 0x0149, TRY_LEAVE, TryCatch #2 {all -> 0x0149, blocks: (B:2:0x0000, B:5:0x0015, B:7:0x002a, B:21:0x0095, B:23:0x009d, B:27:0x00a8, B:30:0x00bc, B:36:0x00d3, B:40:0x00dd, B:42:0x00fb, B:51:0x0138, B:53:0x013f, B:33:0x00c5, B:13:0x005d, B:15:0x0072, B:17:0x0081, B:19:0x0089), top: B:69:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.c.a.a.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            str3 = null;
        }
        String str4 = str3;
        if (str3 == null) {
            str4 = "";
        }
        return str4;
    }
}
