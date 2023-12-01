package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.huawei.openalliance.ad.constant.bc;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.kuaishou.weapon.p0.an;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/common/info/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f21440a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    private static final String[] b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f21441c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (x.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static String a(Context context) {
        String str = bc.b.S;
        if (context == null) {
            return bc.b.S;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                return com.igexin.push.core.b.l;
            }
            str = string;
            return string.toLowerCase();
        } catch (Throwable th) {
            if (!x.a(th)) {
                x.a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r0.equals(com.huawei.openalliance.ad.constant.bc.b.S) != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, boolean r5) {
        /*
            r0 = 0
            r8 = r0
            r0 = r8
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L6e
            r0 = r4
            java.lang.String r1 = "ro.product.cpu.abilist"
            java.lang.String r0 = com.tencent.bugly.proguard.z.a(r0, r1)     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            r0 = r6
            boolean r0 = com.tencent.bugly.proguard.z.a(r0)     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L23
            r0 = r6
            r7 = r0
            r0 = r6
            java.lang.String r1 = "fail"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L2a
        L23:
            r0 = r4
            java.lang.String r1 = "ro.product.cpu.abi"
            java.lang.String r0 = com.tencent.bugly.proguard.z.a(r0, r1)     // Catch: java.lang.Throwable -> L9e
            r7 = r0
        L2a:
            r0 = r8
            r6 = r0
            r0 = r7
            boolean r0 = com.tencent.bugly.proguard.z.a(r0)     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L6e
            r0 = r7
            java.lang.String r1 = "fail"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L43
            r0 = r8
            r6 = r0
            goto L6e
        L43:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r1 = r0
            java.lang.String r2 = "ABI list: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9e
            r4 = r0
            r0 = r4
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r0 = com.tencent.bugly.crashreport.common.info.b.class
            r1 = r4
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9e
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L9e
            boolean r0 = com.tencent.bugly.proguard.x.b(r0, r1, r2)     // Catch: java.lang.Throwable -> L9e
            r0 = r7
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L9e
            r1 = 0
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            goto L6e
        L6e:
            r0 = r6
            r4 = r0
            r0 = r6
            if (r0 != 0) goto L7b
            java.lang.String r0 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L9e
            r4 = r0
        L7b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e java.lang.Throwable -> L9e
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            r0 = r6
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            r0 = r6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9e
            r4 = r0
            r0 = r4
            return r0
        L90:
            r0 = r4
            boolean r0 = com.tencent.bugly.proguard.x.a(r0)
            if (r0 != 0) goto L9b
            r0 = r4
            r0.printStackTrace()
        L9b:
            java.lang.String r0 = "fail"
            return r0
        L9e:
            r4 = move-exception
            goto L90
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.a(android.content.Context, boolean):java.lang.String");
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (x.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
        } catch (Exception e) {
            if (x.a(e)) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String c(Context context) {
        String a2 = z.a(context, XmSystemUtils.KEY_VERSION_MIUI);
        if (!z.a(a2) && !a2.equals(bc.b.S)) {
            return "XiaoMi/MIUI/" + a2;
        }
        String a3 = z.a(context, "ro.build.version.emui");
        if (!z.a(a3) && !a3.equals(bc.b.S)) {
            return "HuaWei/EMOTION/" + a3;
        }
        String a4 = z.a(context, "ro.lenovo.series");
        if (!z.a(a4) && !a4.equals(bc.b.S)) {
            String a5 = z.a(context, "ro.build.version.incremental");
            return "Lenovo/VIBE/" + a5;
        }
        String a6 = z.a(context, "ro.build.nubia.rom.name");
        if (!z.a(a6) && !a6.equals(bc.b.S)) {
            return "Zte/NUBIA/" + a6 + "_" + z.a(context, "ro.build.nubia.rom.code");
        }
        String a7 = z.a(context, "ro.meizu.product.model");
        if (!z.a(a7) && !a7.equals(bc.b.S)) {
            return "Meizu/FLYME/" + z.a(context, "ro.build.display.id");
        }
        String a8 = z.a(context, "ro.build.version.opporom");
        if (!z.a(a8) && !a8.equals(bc.b.S)) {
            return "Oppo/COLOROS/" + a8;
        }
        String a9 = z.a(context, "ro.vivo.os.build.display.id");
        if (!z.a(a9) && !a9.equals(bc.b.S)) {
            return "vivo/FUNTOUCH/" + a9;
        }
        String a10 = z.a(context, "ro.aa.romver");
        if (!z.a(a10) && !a10.equals(bc.b.S)) {
            return "htc/" + a10 + "/" + z.a(context, "ro.build.description");
        }
        String a11 = z.a(context, "ro.lewa.version");
        if (!z.a(a11) && !a11.equals(bc.b.S)) {
            return "tcl/" + a11 + "/" + z.a(context, "ro.build.display.id");
        }
        String a12 = z.a(context, "ro.gn.gnromvernumber");
        if (!z.a(a12) && !a12.equals(bc.b.S)) {
            return "amigo/" + a12 + "/" + z.a(context, "ro.build.display.id");
        }
        String a13 = z.a(context, "ro.build.tyd.kbstyle_version");
        if (!z.a(a13) && !a13.equals(bc.b.S)) {
            return "dido/" + a13;
        }
        return z.a(context, "ro.build.fingerprint") + "/" + z.a(context, "ro.build.rom.id");
    }

    public static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static String d(Context context) {
        return z.a(context, "ro.board.platform");
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static boolean e(Context context) {
        int i;
        if (g(context) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= f21441c.length) {
                    break;
                }
                String[] strArr = f21441c;
                if (i2 == 0) {
                    i = new File(strArr[i2]).exists() ? i2 + 1 : 0;
                    arrayList.add(Integer.valueOf(i2));
                } else {
                    if (!new File(strArr[i2]).exists()) {
                    }
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
        }
        return true;
    }

    public static long f() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return -1L;
                    } catch (IOException e2) {
                        if (x.a(e2)) {
                            return -1L;
                        }
                        e2.printStackTrace();
                        return -1L;
                    }
                }
                long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    if (!x.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return parseLong;
                } catch (IOException e4) {
                    if (!x.a(e4)) {
                        e4.printStackTrace();
                    }
                    return parseLong;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            if (!x.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e6) {
                            if (x.a(e6)) {
                                return -2L;
                            }
                            e6.printStackTrace();
                            return -2L;
                        }
                    }
                    return -2L;
                } catch (Throwable th3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            if (!x.a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e8) {
                            if (!x.a(e8)) {
                                e8.printStackTrace();
                            }
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static boolean f(Context context) {
        return (((h(context) | p()) | q()) | o()) > 0;
    }

    public static long g() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e2) {
                            if (x.a(e2)) {
                                return -1L;
                            }
                            e2.printStackTrace();
                            return -1L;
                        }
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            if (!x.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e4) {
                            if (x.a(e4)) {
                                return -1L;
                            }
                            e4.printStackTrace();
                            return -1L;
                        }
                    }
                    long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!x.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e6) {
                            if (x.a(e6)) {
                                return -1L;
                            }
                            e6.printStackTrace();
                            return -1L;
                        }
                    }
                    long parseLong3 = (parseLong << 10) + 0 + (parseLong2 << 10) + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        if (!x.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return parseLong3;
                    } catch (IOException e8) {
                        if (!x.a(e8)) {
                            e8.printStackTrace();
                        }
                        return parseLong3;
                    }
                } catch (Throwable th) {
                    bufferedReader = bufferedReader2;
                    th = th;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                if (!x.a(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e10) {
                                if (x.a(e10)) {
                                    return -2L;
                                }
                                e10.printStackTrace();
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                if (!x.a(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e12) {
                                if (!x.a(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    private static String g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = b;
            if (i2 >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i2], 1);
                arrayList.add(Integer.valueOf(i2));
            } catch (PackageManager.NameNotFoundException e) {
            }
            i = i2 + 1;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    private static int h(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception e) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception e2) {
            return i;
        }
    }

    public static long h() {
        if (n()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static long i() {
        if (n()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static String j() {
        return "";
    }

    public static String k() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (x.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static boolean l() {
        boolean z;
        String[] strArr = f21440a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                z = false;
                break;
            } else if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    public static boolean m() {
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() / 1048576.0d);
        float f = (float) (Runtime.getRuntime().totalMemory() / 1048576.0d);
        float f2 = maxMemory - f;
        x.c("maxMemory : %f", Float.valueOf(maxMemory));
        x.c("totalMemory : %f", Float.valueOf(f));
        x.c("freeMemory : %f", Float.valueOf(f2));
        return f2 < 10.0f;
    }

    private static boolean n() {
        try {
            return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Throwable th) {
            if (x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static int o() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception e) {
            return 256;
        }
    }

    private static int p() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i >= length) {
                    return i2;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                int i5 = i2;
                if (stackTraceElement.getClassName().equals(an.b)) {
                    i5 = i2;
                    if (stackTraceElement.getMethodName().equals("main")) {
                        i5 = i2 | 4;
                    }
                }
                int i6 = i5;
                if (stackTraceElement.getClassName().equals(an.b)) {
                    i6 = i5;
                    if (stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                        i6 = i5 | 8;
                    }
                }
                int i7 = i6;
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2")) {
                    i7 = i6;
                    if (stackTraceElement.getMethodName().equals("invoked")) {
                        i7 = i6 | 16;
                    }
                }
                i2 = i7;
                int i8 = i4;
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
                    int i9 = i4 + 1;
                    i2 = i7;
                    i8 = i9;
                    if (i9 == 2) {
                        i2 = i7 | 32;
                        i8 = i9;
                    }
                }
                i++;
                i3 = i8;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x01db: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:81:0x01db */
    private static int q() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Throwable th;
        BufferedReader bufferedReader3;
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                    while (true) {
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.endsWith(".so") || readLine.endsWith(ShareConstants.JAR_SUFFIX)) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            i = i3;
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                                return i3;
                            }
                            return i;
                        } catch (UnsupportedEncodingException e2) {
                            e = e2;
                            e.printStackTrace();
                            i = i4;
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                                i = i4;
                            }
                            return i;
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            i = i2;
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                                return i2;
                            }
                            return i;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (true) {
                        i2 = i5;
                        i3 = i5;
                        i4 = i5;
                        if (!it.hasNext()) {
                            bufferedReader3.close();
                            return i5;
                        }
                        int i6 = i5;
                        Object next = it.next();
                        int i7 = i5;
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i7 = i5 | 64;
                        }
                        i5 = i7;
                        if (((String) next).contains("com.saurik.substrate")) {
                            i5 = i7 | 128;
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedReader3 = null;
                } catch (UnsupportedEncodingException e5) {
                    e = e5;
                    bufferedReader3 = null;
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader3 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = null;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
                return 0;
            }
        } catch (Throwable th3) {
            bufferedReader2 = bufferedReader;
            th = th3;
        }
    }
}
