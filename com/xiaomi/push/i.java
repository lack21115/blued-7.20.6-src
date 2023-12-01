package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f41505a;

    /* renamed from: a  reason: collision with other field name */
    private static final Set<String> f678a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f679a = false;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f680a = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f41506c = "";
    private static String d;
    private static String e;
    private static final String f = "\u0002";

    static {
        HashSet hashSet = new HashSet();
        f678a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        f678a.add("com.xiaomi.finddevice");
        f678a.add("com.miui.securitycenter");
        f679a = true;
    }

    private static double a(double d2) {
        int i = 1;
        while (true) {
            int i2 = i;
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i = i2 << 1;
        }
    }

    private static float a(int i) {
        float f2 = ((((((i + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        if (d2 > 0.5d) {
            f2 = (float) Math.ceil(d2);
        }
        return f2;
    }

    public static int a() {
        Object a2 = bi.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(a2)).intValue();
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m11926a() {
        return a(b()) + "GB";
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m11927a(int i) {
        if (i > 0) {
            String[] strArr = f680a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f680a[0];
    }

    @Deprecated
    public static String a(Context context) {
        return null;
    }

    public static String a(Context context, boolean z) {
        String str;
        int i;
        if (d == null) {
            String b2 = b(context);
            String c2 = !j.m12053d() ? z ? c(context) : j(context) : "";
            String a2 = a(context);
            if (!(Build.VERSION.SDK_INT < 26) && b(c2) && b(a2)) {
                String b3 = ay.a(context).b();
                if (TextUtils.isEmpty(b3)) {
                    str = ay.a(context).mo11508a();
                    if (TextUtils.isEmpty(str) || str.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i = 5;
                        str = b2;
                    } else {
                        i = 4;
                    }
                } else {
                    str = b3 + b2;
                    i = 2;
                }
            } else {
                str = c2 + b2 + a2;
                i = 1;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:".concat(String.valueOf(i)));
            if (i == 3) {
                d = str;
            } else {
                d = m11927a(i) + bn.b(str);
            }
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r0 == 5) goto L7;
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11928a(android.content.Context r6) {
        /*
            r0 = r6
            r1 = 0
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r3 = r2
            java.lang.String r4 = "android.intent.action.BATTERY_CHANGED"
            r3.<init>(r4)
            android.content.Intent r0 = r0.registerReceiver(r1, r2)
            r6 = r0
            r0 = 0
            r9 = r0
            r0 = r9
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L2d
            r0 = r6
            java.lang.String r1 = "status"
            r2 = -1
            int r0 = r0.getIntExtra(r1, r2)
            r7 = r0
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L2b
            r0 = r9
            r8 = r0
            r0 = r7
            r1 = 5
            if (r0 != r1) goto L2d
        L2b:
            r0 = 1
            r8 = r0
        L2d:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.i.m11928a(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0053, code lost:
        if ((r0.applicationInfo.flags & 8388608) != 8388608) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = r7
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r7 = r0
            r0 = 0
            r10 = r0
            r0 = r7
            java.lang.String r1 = "getPackageInfoAsUser"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 2
            r5 = 999(0x3e7, float:1.4E-42)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            java.lang.Object r0 = com.xiaomi.push.bi.a(r0, r1, r2)
            android.content.pm.PackageInfo r0 = (android.content.pm.PackageInfo) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L56
            r0 = r7
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            if (r0 == 0) goto L56
            r0 = r10
            r9 = r0
            r0 = r7
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            int r0 = r0.flags
            r1 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r1
            r1 = 2097152(0x200000, float:2.938736E-39)
            if (r0 != r1) goto L58
            r0 = r10
            r9 = r0
            r0 = r7
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            int r0 = r0.flags
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r1
            r1 = 8388608(0x800000, float:1.17549435E-38)
            if (r0 == r1) goto L58
        L56:
            r0 = 1
            r9 = r0
        L58:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.i.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = f680a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static int b() {
        BufferedReader bufferedReader;
        if (new File("/proc/meminfo").exists()) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception e2) {
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    int i = 0;
                    if (!TextUtils.isEmpty(readLine)) {
                        String[] split = readLine.split("\\s+");
                        i = 0;
                        if (split != null) {
                            i = 0;
                            if (split.length >= 2) {
                                i = 0;
                                if (TextUtils.isDigitsOnly(split[1])) {
                                    i = Integer.parseInt(split[1]);
                                }
                            }
                        }
                    }
                    int i2 = i;
                    bufferedReader.close();
                    return i;
                } catch (Exception e3) {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        return 0;
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m11929b() {
        double a2 = a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    public static String b(Context context) {
        if (b == null && f679a) {
            boolean m11931c = m11931c(context);
            f679a = m11931c;
            if (m11931c) {
                try {
                    b = Settings.Secure.getString(context.getContentResolver(), "android_id");
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a("failure to get androidId: ".concat(String.valueOf(th)));
                }
                return b;
            }
            return null;
        }
        return b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m11930b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(com.igexin.push.core.b.l) || trim.equalsIgnoreCase("unknown");
    }

    public static String c() {
        return b() + "KB";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m11931c(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
        intent.setComponent(componentName);
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo.metaData != null) {
                String string = serviceInfo.metaData.getString("supportGetAndroidID");
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                return Boolean.parseBoolean(string);
            }
            return true;
        } catch (Exception e2) {
            return true;
        }
    }

    public static String d() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return null;
    }

    @Deprecated
    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        synchronized (i.class) {
            try {
                if (e != null) {
                    return e;
                }
                String b2 = b(context);
                String a2 = a(context);
                String b3 = bn.b(b2 + a2);
                e = b3;
                return b3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String h(Context context) {
        String b2;
        synchronized (i.class) {
            try {
                String b3 = b(context);
                b2 = bn.b(b3 + ((String) null));
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    private static String j(Context context) {
        return "";
    }
}
