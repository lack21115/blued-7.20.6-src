package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.beacon.a.d.a;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f34937a;
    public static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f34938c = "";
    public static boolean d = false;
    private static String e;
    private static boolean f = false;
    private static String g = "";
    private static boolean h = false;
    private static boolean i = false;
    private static int j = -2;
    private static boolean k = true;

    public static String a() {
        if (f34937a == null) {
            f34937a = e();
        }
        return f34937a;
    }

    public static String a(Context context) {
        String str;
        synchronized (b.class) {
            try {
                if (TextUtils.isEmpty(e)) {
                    String str2 = "on_app_first_install_time_" + c(context);
                    com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
                    long j2 = a2.getLong(str2, 0L);
                    long j3 = j2;
                    if (j2 == 0) {
                        j3 = new Date().getTime();
                        com.tencent.beacon.a.b.a.a().a(new a(a2, str2, j3));
                    }
                    String valueOf = String.valueOf(j3);
                    e = valueOf;
                    com.tencent.beacon.base.util.c.a("[appInfo] process: %s, getAppFirstInstallTime: %s", str2, valueOf);
                }
                com.tencent.beacon.base.util.c.a("[appInfo] getAppFirstInstallTime: %s", e);
                str = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.beacon.base.util.c.e("[appInfo] set qq is null !", new Object[0]);
            return;
        }
        try {
            if (Long.parseLong(str) > 10000) {
                g = str;
            }
        } catch (Exception e2) {
            com.tencent.beacon.base.util.c.e("[appInfo] set qq is not available !", new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x005d, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            boolean r0 = com.tencent.beacon.a.c.b.i
            if (r0 == 0) goto La
            boolean r0 = com.tencent.beacon.a.c.b.k
            return r0
        La:
            r0 = r6
            if (r0 == 0) goto Lbc
            r0 = r7
            if (r0 == 0) goto Lbc
            r0 = r7
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 > 0) goto L1e
            r0 = 0
            return r0
        L1e:
            com.tencent.beacon.e.b r0 = com.tencent.beacon.e.b.a()
            boolean r0 = r0.k()
            if (r0 != 0) goto L39
            java.lang.String r0 = "[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r2[r3] = r4
            com.tencent.beacon.base.util.c.a(r0, r1)
            r0 = 1
            return r0
        L39:
            r0 = r6
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            java.util.List r0 = r0.getRunningAppProcesses()
            r6 = r0
            r0 = r6
            if (r0 == 0) goto Lb3
            r0 = r6
            int r0 = r0.size()
            if (r0 != 0) goto L56
            goto Lb3
        L56:
            r0 = r6
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L5d:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto La9
            r0 = r6
            java.lang.Object r0 = r0.next()
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0
            r10 = r0
            r0 = r10
            int r0 = r0.importance
            r1 = 100
            if (r0 != r1) goto L5d
            r0 = r10
            java.lang.String[] r0 = r0.pkgList
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r8 = r0
        L88:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L5d
            r0 = r7
            r1 = r10
            r2 = r8
            r1 = r1[r2]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto La2
            r0 = 1
            com.tencent.beacon.a.c.b.k = r0
            r0 = 1
            com.tencent.beacon.a.c.b.i = r0
            r0 = 1
            return r0
        La2:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L88
        La9:
            r0 = 0
            com.tencent.beacon.a.c.b.k = r0
            r0 = 1
            com.tencent.beacon.a.c.b.i = r0
            r0 = 0
            return r0
        Lb3:
            java.lang.String r0 = "[appInfo] no running proc"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.tencent.beacon.base.util.c.e(r0, r1)
        Lbc:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.a.c.b.a(android.content.Context, java.lang.String):boolean");
    }

    public static int b(Context context) {
        if (h) {
            return j;
        }
        if (b == 0) {
            b = Process.myPid();
        }
        if (!com.tencent.beacon.e.b.a().k()) {
            com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", false);
            return -2;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == b) {
                    int i2 = runningAppProcessInfo.importance;
                    j = i2;
                    h = true;
                    return i2;
                }
            }
        }
        j = 0;
        h = true;
        return 0;
    }

    public static String b() {
        Context c2 = c.d().c();
        if (c2 == null) {
            return null;
        }
        String packageName = c2.getPackageName();
        String str = packageName;
        if (TextUtils.isEmpty(packageName)) {
            str = "";
        }
        return str;
    }

    public static String c() {
        return g;
    }

    public static String c(Context context) {
        return com.tencent.beacon.base.util.a.a();
    }

    public static String d() {
        if ("".equals(f34938c)) {
            if (b == 0) {
                b = Process.myPid();
            }
            f34938c += b + BridgeUtil.UNDERLINE_STR;
            String str = f34938c + new Date().getTime();
            f34938c = str;
            return str;
        }
        return f34938c;
    }

    public static boolean d(Context context) {
        boolean z = false;
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            com.tencent.beacon.base.util.c.a(e2);
            return false;
        }
    }

    public static String e() {
        int i2;
        synchronized (b.class) {
            try {
                String b2 = b();
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                PackageInfo packageInfo = c.d().c().getPackageManager().getPackageInfo(b2, 0);
                String str = packageInfo.versionName;
                int i3 = packageInfo.versionCode;
                if (str != null && str.trim().length() > 0) {
                    String replace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                    char[] charArray = replace.toCharArray();
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        i2 = i5;
                        if (i4 >= charArray.length) {
                            break;
                        }
                        int i6 = i2;
                        if (charArray[i4] == '.') {
                            i6 = i2 + 1;
                        }
                        i4++;
                        i5 = i6;
                    }
                    String str2 = replace;
                    if (i2 < 3) {
                        com.tencent.beacon.base.util.c.a("[appInfo] add versionCode: %s", Integer.valueOf(i3));
                        StringBuilder sb = new StringBuilder();
                        sb.append(replace);
                        sb.append(".");
                        sb.append(i3);
                        str2 = sb.toString();
                    }
                    com.tencent.beacon.base.util.c.a("[appInfo] final Version: %s", str2);
                    return str2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(i3);
                return sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean e(Context context) {
        synchronized (b.class) {
            boolean z = false;
            try {
                if (context == null) {
                    com.tencent.beacon.base.util.c.b("[appInfo] context is null", new Object[0]);
                    return false;
                }
                com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
                String string = a2.getString("APPVER_DENGTA", "");
                String a3 = a();
                if (string.isEmpty() || !string.equals(a3)) {
                    a.SharedPreferences$EditorC0895a edit = a2.edit();
                    z = true;
                    if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                        edit.putString("APPVER_DENGTA", a3);
                        z = true;
                    }
                }
                return z;
            } finally {
            }
        }
    }

    public static void f() {
        h();
    }

    public static boolean f(Context context) {
        return a(context, context.getPackageName());
    }

    public static boolean g() {
        boolean z;
        synchronized (b.class) {
            z = false;
            try {
                com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
                String string = a2.getString("APPKEY_DENGTA", "");
                String f2 = c.d().f();
                if (TextUtils.isEmpty(string) || !f2.equals(string)) {
                    a.SharedPreferences$EditorC0895a edit = a2.edit();
                    z = true;
                    if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                        edit.putString("APPKEY_DENGTA", f2);
                        z = true;
                    }
                }
            } finally {
            }
        }
        return z;
    }

    public static boolean g(Context context) {
        boolean z = true;
        if (context == null) {
            return true;
        }
        String c2 = c(context);
        if (!TextUtils.isEmpty(c2)) {
            if (c2.equals(context.getPackageName())) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private static void h() {
        try {
            com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
            String string = a2.getString("APPVER_DENGTA", "");
            String a3 = a();
            if (!TextUtils.isEmpty(string) && a3.equals(string)) {
                f = false;
                return;
            }
            f = true;
            a.SharedPreferences$EditorC0895a edit = a2.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("APPVER_DENGTA", a3);
            }
        } catch (Exception e2) {
            com.tencent.beacon.base.util.c.b("[core] app version check fail!", new Object[0]);
            com.tencent.beacon.base.util.c.a(e2);
        }
    }
}
