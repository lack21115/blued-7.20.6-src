package com.tencent.qimei.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f24625a;
    public static String b;

    static {
        new HashMap();
    }

    public static String a() {
        if (f24625a == null) {
            f24625a = e();
        }
        return f24625a;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f24625a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0038, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r4) {
        /*
            r0 = r4
            java.lang.String r0 = r0.getPackageName()
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L7c
            r0 = r7
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 > 0) goto L15
            r0 = 0
            return r0
        L15:
            r0 = r4
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            java.util.List r0 = r0.getRunningAppProcesses()
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L7c
            r0 = r4
            int r0 = r0.size()
            if (r0 != 0) goto L31
            r0 = 0
            return r0
        L31:
            r0 = r4
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
        L38:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L7c
            r0 = r4
            java.lang.Object r0 = r0.next()
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0
            r8 = r0
            r0 = r8
            int r0 = r0.importance
            r1 = 100
            if (r0 != r1) goto L38
            r0 = r8
            java.lang.String[] r0 = r0.pkgList
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r6 = r0
            r0 = 0
            r5 = r0
        L63:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L38
            r0 = r7
            r1 = r8
            r2 = r5
            r1 = r1[r2]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L75
            r0 = 1
            return r0
        L75:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L63
        L7c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.c.a.a(android.content.Context):boolean");
    }

    public static String b() {
        String str = b;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
            b = str2;
            return str2;
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
            return "";
        }
    }

    public static long c() {
        Context J = com.tencent.qimei.u.d.b().J();
        if (J == null) {
            return 0L;
        }
        try {
            return J.getPackageManager().getPackageInfo(J.getPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String d() {
        Context J = com.tencent.qimei.u.d.b().J();
        String packageName = J != null ? J.getPackageName() : null;
        String str = packageName;
        if (TextUtils.isEmpty(packageName)) {
            str = "";
        }
        return str;
    }

    public static String e() {
        int i;
        synchronized (a.class) {
            try {
                String d = d();
                if (TextUtils.isEmpty(d)) {
                    return "";
                }
                int i2 = 0;
                PackageInfo packageInfo = com.tencent.qimei.u.d.b().J().getPackageManager().getPackageInfo(d, 0);
                String str = packageInfo.versionName;
                int i3 = packageInfo.versionCode;
                if (str != null && str.trim().length() > 0) {
                    String replace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                    char[] charArray = replace.toCharArray();
                    int i4 = 0;
                    while (true) {
                        i = i4;
                        if (i2 >= charArray.length) {
                            break;
                        }
                        int i5 = i;
                        if (charArray[i2] == '.') {
                            i5 = i + 1;
                        }
                        i2++;
                        i4 = i5;
                    }
                    String str2 = replace;
                    if (i < 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(replace);
                        sb.append(".");
                        sb.append(i3);
                        str2 = sb.toString();
                    }
                    return str2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(i3);
                return sb2.toString();
            } catch (Exception e) {
                com.tencent.qimei.k.a.a(e);
                e.toString();
                return "";
            } finally {
            }
        }
    }

    public static String f() {
        Context J = com.tencent.qimei.u.d.b().J();
        return J == null ? "" : (String) com.tencent.qimei.a.a.a(ApplicationInfo.class.getName(), J.getApplicationInfo(), "nativeLibraryDir");
    }

    public static String g() {
        Context J = com.tencent.qimei.u.d.b().J();
        return J == null ? "" : (String) com.tencent.qimei.a.a.a(ApplicationInfo.class.getName(), J.getApplicationInfo(), "primaryCpuAbi");
    }

    public static void h() {
        com.tencent.qimei.k.a.b("SDK_INIT ｜ AppInfo", " 初始化完成 ", new Object[0]);
    }

    public static boolean i() {
        Context J = com.tencent.qimei.u.d.b().J();
        if (J == null) {
            return false;
        }
        String b2 = b();
        return TextUtils.isEmpty(b2) || b2.equals(J.getPackageName());
    }

    public static boolean j() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
