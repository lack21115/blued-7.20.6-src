package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.amap.api.col.3sl.iu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/iu.class */
public final class iu {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    public static String e = "s";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";
    private static long l;
    private static Vector<ia> m = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ia> a() {
        Vector<ia> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return m;
        }
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - l < 60000) {
                return;
            }
            l = System.currentTimeMillis();
            lb.a().a(new lc() { // from class: com.amap.api.col.3sl.iu.1
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    try {
                        ix.b(context);
                        ix.d(context);
                        ix.c(context);
                        kk.a(context);
                        ki.a(context);
                    } catch (RejectedExecutionException e2) {
                    } catch (Throwable th) {
                        iw.c(th, "Lg", "proL");
                    }
                }
            });
        } catch (Throwable th) {
            iw.c(th, "Lg", "proL");
        }
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void a(ia iaVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (iaVar == null) {
                    return;
                }
                if (m.contains(iaVar)) {
                    return;
                }
                m.add(iaVar);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        r0 = r0.length;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r6 >= r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (b(r4, r0[r6].trim()) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
        r0 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String[] r4, java.lang.String r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L6f
            r0 = r5
            if (r0 != 0) goto La
            r0 = 0
            return r0
        La:
            r0 = r5
            java.lang.String r1 = "\n"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L6a
            r5 = r0
            r0 = r5
            int r0 = r0.length     // Catch: java.lang.Throwable -> L6a
            r8 = r0
            r0 = 0
            r6 = r0
        L17:
            r0 = 1
            r7 = r0
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L46
            r0 = r5
            r1 = r6
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L6a
            r10 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L71
            r0 = r10
            java.lang.String r1 = "at "
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L71
            r0 = r10
            java.lang.String r1 = "uncaughtException"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L71
            goto L73
        L46:
            r0 = r5
            int r0 = r0.length     // Catch: java.lang.Throwable -> L6a
            r7 = r0
            r0 = 0
            r6 = r0
        L4b:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L6f
            r0 = r4
            r1 = r5
            r2 = r6
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L6a
            boolean r0 = b(r0, r1)     // Catch: java.lang.Throwable -> L6a
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L63
            r0 = 1
            return r0
        L63:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L4b
        L6a:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L6f:
            r0 = 0
            return r0
        L71:
            r0 = 0
            r7 = r0
        L73:
            r0 = r7
            if (r0 == 0) goto L79
            r0 = 0
            return r0
        L79:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.iu.a(java.lang.String[], java.lang.String):boolean");
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                String str2 = strArr[i3];
                str = str.trim();
                if (str.startsWith("at ")) {
                    if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                        return true;
                    }
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }
}
