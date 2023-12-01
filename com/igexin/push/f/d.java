package com.igexin.push.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.core.ServiceManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10032a = "ro.miui.ui.version.name";
    private static final String b = "ro.miui.ui.version.code";

    /* renamed from: c  reason: collision with root package name */
    private static volatile Boolean f10033c;
    private static PackageInfo d;

    /* JADX WARN: Code restructure failed: missing block: B:262:0x0513, code lost:
        if (r10 == false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0518, code lost:
        r18.setAction(android.content.Intent.ACTION_MAIN);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0576, code lost:
        r0 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x06a6, code lost:
        if (r10 == false) goto L293;
     */
    /* JADX WARN: Removed duplicated region for block: B:289:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x06a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent a(java.lang.String r6) throws java.net.URISyntaxException {
        /*
            Method dump skipped, instructions count: 1715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.d.a(java.lang.String):android.content.Intent");
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        try {
            if (d == null) {
                int i = 4;
                if (Build.VERSION.SDK_INT >= 24) {
                    i = 516;
                }
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), i);
            }
            ServiceInfo[] serviceInfoArr = d.services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                int length = serviceInfoArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    ServiceInfo serviceInfo = serviceInfoArr[i3];
                    Class<?> cls2 = Class.forName(serviceInfo.name);
                    if (cls2 != cls && m.a(cls2, cls, 5)) {
                        return Pair.create(serviceInfo, cls2);
                    }
                    i2 = i3 + 1;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.c.a().a(" findGtImplClassInManifest error = " + th.toString());
        }
        return Pair.create(null, null);
    }

    private static String a(Context context) {
        try {
            Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            return (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) ? "" : launchIntentForPackage.getComponent().getClassName();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static String a(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(com.igexin.push.core.b.f9818a);
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(str + ".BuildConfig");
            return (String) cls.getField("GETUI_APPID").get(cls);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a("get cf error|" + e.toString(), new Object[0]);
            return "";
        }
    }

    private static boolean a() {
        boolean z;
        try {
            if (f10033c != null) {
                return f10033c.booleanValue();
            }
            String c2 = c("ro.miui.ui.version.name");
            String c3 = c("ro.miui.ui.version.code");
            if (!"Xiaomi".equalsIgnoreCase(com.igexin.push.core.e.G) && TextUtils.isEmpty(c2) && TextUtils.isEmpty(c3)) {
                z = false;
                Boolean valueOf = Boolean.valueOf(z);
                f10033c = valueOf;
                return valueOf.booleanValue();
            }
            z = true;
            Boolean valueOf2 = Boolean.valueOf(z);
            f10033c = valueOf2;
            return valueOf2.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(int i) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        try {
            if (Build.VERSION.SDK_INT < 26 || (runningServices = ((ActivityManager) ServiceManager.b.getSystemService("activity")).getRunningServices(5)) == null) {
                return false;
            }
            return runningServices.size() > i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean a(int i, boolean z) {
        synchronized (d.class) {
            try {
            } finally {
                try {
                    return false;
                } finally {
                }
            }
            if (com.igexin.push.core.e.l == null) {
                return false;
            }
            String str = com.igexin.push.core.e.G;
            if (AssistUtils.BRAND_HW.equalsIgnoreCase(str) || AssistUtils.BRAND_HON.equalsIgnoreCase(str)) {
                int intValue = ((Integer) o.b(com.igexin.push.core.e.l, o.h, 0)).intValue();
                if (!z) {
                    i += intValue;
                }
                o.a(com.igexin.push.core.e.l, o.h, Integer.valueOf(i));
                Bundle bundle = new Bundle();
                bundle.putString("package", com.igexin.push.core.e.g);
                bundle.putString("class", a(com.igexin.push.core.e.l));
                bundle.putInt("badgenumber", i);
                Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                Uri parse2 = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                Uri uri = parse;
                if (TextUtils.isEmpty(com.igexin.push.core.e.l.getContentResolver().getType(parse))) {
                    uri = parse2;
                }
                com.igexin.push.core.e.l.getContentResolver().call(uri, "change_badge", null, bundle);
                return true;
            }
            return false;
        }
    }

    public static boolean a(String... strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return false;
            }
            if (TextUtils.isEmpty(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static String b() {
        try {
            Field declaredField = Class.forName("com.getui.gtc.BuildConfig").getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            return ((String) declaredField.get(null)).substring(4);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static boolean b(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l != null && AssistUtils.BRAND_VIVO.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                Intent intent = new Intent();
                intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
                Intent launchIntentForPackage = com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(com.igexin.push.core.e.l.getPackageName());
                if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                    return false;
                }
                int intValue = ((Integer) o.b(com.igexin.push.core.e.l, o.i, 0)).intValue();
                if (!z) {
                    i += intValue;
                }
                o.a(com.igexin.push.core.e.l, o.i, Integer.valueOf(i));
                intent.putExtra("className", launchIntentForPackage.getComponent().getClassName());
                intent.putExtra("notificationNum", i);
                intent.addFlags(16777216);
                com.igexin.push.core.e.l.sendBroadcast(intent);
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            String b2 = b();
            com.igexin.c.a.c.a.b("", " gtcVersion = ".concat(String.valueOf(b2)));
            String[] split = b2.split("\\.");
            String[] split2 = str.split("\\.");
            if (split.length != 4 || split2.length != 4) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    return false;
                }
                int parseInt = Integer.parseInt(split2[i2]);
                int parseInt2 = Integer.parseInt(split[i2]);
                if (parseInt2 != parseInt) {
                    return parseInt2 < parseInt;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e2) {
                com.igexin.c.a.c.a.a(e2);
                return readLine;
            }
        } catch (Exception e3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e4) {
                    com.igexin.c.a.c.a.a(e4);
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            bufferedReader2 = bufferedReader;
            th = th2;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    com.igexin.c.a.c.a.a(e5);
                }
            }
            throw th;
        }
    }

    public static boolean c(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l != null && AssistUtils.BRAND_OPPO.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                int intValue = ((Integer) o.b(com.igexin.push.core.e.l, o.j, 0)).intValue();
                if (!z) {
                    i += intValue;
                }
                o.a(com.igexin.push.core.e.l, o.j, Integer.valueOf(i));
                Intent intent = new Intent("com.oppo.unsettledevent");
                intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
                intent.putExtra("number", i);
                intent.putExtra("upgradeNumber", i);
                List<ResolveInfo> queryBroadcastReceivers = com.igexin.push.core.e.l.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    com.igexin.push.core.e.l.sendBroadcast(intent);
                    return true;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("app_badge_count", i);
                com.igexin.push.core.e.l.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, bundle);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
        if (r0 > r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0209, code lost:
        if (r0 >= r0) goto L111;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent d(java.lang.String r8) throws java.net.URISyntaxException {
        /*
            Method dump skipped, instructions count: 939
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.d.d(java.lang.String):android.content.Intent");
    }
}
