package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bun.miitmdid.core.Utils;
import com.huawei.openalliance.ad.constant.bc;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab.class */
public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<a> f35214a = new ArrayList<a>() { // from class: com.tencent.bugly.idasc.proguard.ab.1
        {
            add(new l((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
            add(new m((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new k((byte) 0));
            add(new e((byte) 0));
            add(new j((byte) 0));
            add(new b((byte) 0));
            add(new d((byte) 0));
            add(new c((byte) 0));
        }
    };
    private static final Map<Integer, String> b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.idasc.proguard.ab.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f35215c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$a.class */
    public static abstract class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public abstract String a();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$b.class */
    static final class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.gn.gnromvernumber");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "amigo/" + a2 + BridgeUtil.SPLIT_MARK + ap.a("ro.build.display.id");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$c.class */
    static final class c extends a {
        private c() {
            super((byte) 0);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            return ap.a("ro.build.fingerprint") + BridgeUtil.SPLIT_MARK + ap.a("ro.build.rom.id");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$d.class */
    static final class d extends a {
        private d() {
            super((byte) 0);
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.build.tyd.kbstyle_version");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "dido/".concat(String.valueOf(a2));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$e.class */
    static final class e extends a {
        private e() {
            super((byte) 0);
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.aa.romver");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "htc/" + a2 + BridgeUtil.SPLIT_MARK + ap.a("ro.build.description");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$f.class */
    static final class f extends a {
        private f() {
            super((byte) 0);
        }

        /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.build.version.emui");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "HuaWei/EMOTION/".concat(String.valueOf(a2));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$g.class */
    static final class g extends a {
        private g() {
            super((byte) 0);
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.lenovo.series");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "Lenovo/VIBE/".concat(String.valueOf(ap.a("ro.build.version.incremental")));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$h.class */
    static final class h extends a {
        private h() {
            super((byte) 0);
        }

        /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.meizu.product.model");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "Meizu/FLYME/" + ap.a("ro.build.display.id");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$i.class */
    static final class i extends a {
        private i() {
            super((byte) 0);
        }

        /* synthetic */ i(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.build.version.opporom");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "Oppo/COLOROS/".concat(String.valueOf(a2));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$j.class */
    static final class j extends a {
        private j() {
            super((byte) 0);
        }

        /* synthetic */ j(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.lewa.version");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "tcl/" + a2 + BridgeUtil.SPLIT_MARK + ap.a("ro.build.display.id");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$k.class */
    static final class k extends a {
        private k() {
            super((byte) 0);
        }

        /* synthetic */ k(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.vivo.os.build.display.id");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "vivo/FUNTOUCH/".concat(String.valueOf(a2));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$l.class */
    static final class l extends a {
        private l() {
            super((byte) 0);
        }

        /* synthetic */ l(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a(XmSystemUtils.KEY_VERSION_MIUI);
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "XiaoMi/MIUI/".concat(String.valueOf(a2));
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ab$m.class */
    static final class m extends a {
        private m() {
            super((byte) 0);
        }

        /* synthetic */ m(byte b) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.ab.a
        public final String a() {
            String a2 = ap.a("ro.build.nubia.rom.name");
            if (ap.b(a2) || a2.equals(bc.b.S)) {
                return null;
            }
            return "Zte/NUBIA/" + a2 + BridgeUtil.UNDERLINE_STR + ap.a("ro.build.nubia.rom.code");
        }
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (al.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static String a(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            return bc.b.S;
        }
        String str = context.getApplicationInfo().nativeLibraryDir;
        return TextUtils.isEmpty(str) ? bc.b.S : str.endsWith("arm") ? "armeabi-v7a" : str.endsWith("arm64") ? "arm64-v8a" : str.endsWith(Utils.CPU_ABI_X86) ? Utils.CPU_ABI_X86 : str.endsWith("x86_64") ? "x86_64" : bc.b.S;
    }

    public static long b(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Throwable th) {
            pss = Debug.getPss();
        }
        if (activityManager != null) {
            pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
            return pss * 1024;
        }
        return 0L;
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (al.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String c(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Exception e2) {
            e = e2;
            str = "unknown";
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        String str2 = "unknown";
        if (activeNetworkInfo.getType() == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str2 = "unknown";
            if (telephonyManager != null) {
                int networkType = telephonyManager.getNetworkType();
                str = b.get(Integer.valueOf(networkType));
                if (str == null) {
                    try {
                        str2 = "MOBILE(" + networkType + ")";
                    } catch (Exception e3) {
                        e = e3;
                        str2 = str;
                        if (!al.a(e)) {
                            e.printStackTrace();
                            str2 = str;
                        }
                        return str2;
                    }
                } else {
                    str2 = str;
                }
            }
        }
        return str2;
    }

    public static String d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (al.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
        r6 = java.lang.Long.parseLong(r0.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long g() {
        /*
            r0 = 0
            r8 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5a
            r1 = r0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5a
            r3 = r2
            java.lang.String r4 = "/proc/self/status"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5a
            r12 = r0
        L15:
            r0 = r12
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L55
            r13 = r0
            r0 = r8
            r6 = r0
            r0 = r13
            if (r0 == 0) goto L3d
            r0 = r13
            java.lang.String r1 = "VmSize"
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L15
            r0 = r13
            java.lang.String r1 = "[^\\d]"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replaceAll(r1, r2)     // Catch: java.lang.Throwable -> L55
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L55
            r6 = r0
        L3d:
            r0 = r6
            r10 = r0
            r0 = r12
            r0.close()     // Catch: java.lang.Throwable -> L48
            goto L76
        L48:
            r12 = move-exception
            r0 = r12
            r0.printStackTrace()
            r0 = r10
            r6 = r0
            goto L76
        L55:
            r13 = move-exception
            goto L5f
        L5a:
            r13 = move-exception
            r0 = 0
            r12 = r0
        L5f:
            r0 = r13
            boolean r0 = com.tencent.bugly.idasc.proguard.al.a(r0)     // Catch: java.lang.Throwable -> L7c
            r0 = r8
            r6 = r0
            r0 = r12
            if (r0 == 0) goto L76
            r0 = r8
            r10 = r0
            r0 = r12
            r0.close()     // Catch: java.lang.Throwable -> L48
            r0 = r8
            r6 = r0
        L76:
            r0 = r6
            r1 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r1
            return r0
        L7c:
            r13 = move-exception
            r0 = r12
            if (r0 == 0) goto L92
            r0 = r12
            r0.close()     // Catch: java.lang.Throwable -> L8b
            goto L92
        L8b:
            r12 = move-exception
            r0 = r12
            r0.printStackTrace()
        L92:
            r0 = r13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.ab.g():long");
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long i() {
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
                    } catch (IOException e2) {
                        if (!al.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return -1L;
                    } catch (IOException e3) {
                        if (al.a(e3)) {
                            return -1L;
                        }
                        e3.printStackTrace();
                        return -1L;
                    }
                }
                long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!al.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return parseLong;
                } catch (IOException e5) {
                    if (!al.a(e5)) {
                        e5.printStackTrace();
                    }
                    return parseLong;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            if (!al.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e7) {
                            if (al.a(e7)) {
                                return -2L;
                            }
                            e7.printStackTrace();
                            return -2L;
                        }
                    }
                    return -2L;
                } catch (Throwable th3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            if (!al.a(e8)) {
                                e8.printStackTrace();
                            }
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e9) {
                            if (!al.a(e9)) {
                                e9.printStackTrace();
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

    public static long j() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!al.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e3) {
                    if (al.a(e3)) {
                        return -1L;
                    }
                    e3.printStackTrace();
                    return -1L;
                }
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!al.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e5) {
                    if (al.a(e5)) {
                        return -1L;
                    }
                    e5.printStackTrace();
                    return -1L;
                }
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!al.a(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e7) {
                    if (al.a(e7)) {
                        return -1L;
                    }
                    e7.printStackTrace();
                    return -1L;
                }
            }
            long parseLong3 = (parseLong * 1024) + 0 + (parseLong2 * 1024) + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!al.a(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
                return parseLong3;
            } catch (IOException e9) {
                if (!al.a(e9)) {
                    e9.printStackTrace();
                }
                return parseLong3;
            }
        } catch (Throwable th3) {
            bufferedReader2 = bufferedReader;
            th = th3;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e10) {
                        if (!al.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e11) {
                        if (al.a(e11)) {
                            return -2L;
                        }
                        e11.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        if (!al.a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!al.a(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long k() {
        if (s()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (al.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static long l() {
        if (s()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (al.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static String m() {
        return "";
    }

    public static String n() {
        Iterator<a> it = f35214a.iterator();
        while (it.hasNext()) {
            String a2 = it.next().a();
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return null;
    }

    public static boolean o() {
        return !TextUtils.isEmpty(new i((byte) 0).a());
    }

    public static boolean p() {
        return !TextUtils.isEmpty(new k((byte) 0).a());
    }

    public static boolean q() {
        boolean z;
        String[] strArr = f35215c;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                z = false;
                break;
            } else if (new File(strArr[i3]).exists()) {
                z = true;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    public static boolean r() {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f2 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f3 = maxMemory - f2;
        al.c("maxMemory : %f", Float.valueOf(maxMemory));
        al.c("totalMemory : %f", Float.valueOf(f2));
        al.c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    private static boolean s() {
        try {
            return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}
