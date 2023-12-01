package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bd.class */
public final class bd {
    private static String aAT;
    private static String aAU = "";
    private static boolean aAV = false;
    private static String aAW = "";
    private static String aAX = "";
    private static int aAY = 0;
    private static boolean aAZ = false;
    private static int aBa = 0;
    private static boolean aBb = false;
    private static String aBg;
    private static String aBh;
    private static int aBp;
    private static long aBq;
    private static final String[] aBc = {"", ""};
    private static String aBd = "";
    private static String aBe = "";
    private static String aBf = "";
    private static int aBi = -1;
    private static boolean aBj = false;
    private static boolean aBk = false;
    private static boolean aBl = false;
    private static boolean aBm = false;
    private static boolean aBn = false;
    private static boolean aBo = false;
    private static String aBr = "";
    private static String aBs = "";
    private static final List<String> aBt = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long EA() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        String readLine;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        return 0L;
                    }
                } catch (Exception e) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
            return longValue << 10;
        } catch (Exception e2) {
            bufferedReader2 = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long EC() {
        return com.kwad.sdk.crash.utils.h.F(Environment.getDataDirectory());
    }

    public static long ED() {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.E(Environment.getDataDirectory());
    }

    public static int EE() {
        int i = aBp;
        if (i > 0) {
            return i;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aBp = availableProcessors;
        return availableProcessors;
    }

    public static String EF() {
        return Build.MODEL;
    }

    public static long EG() {
        long j;
        synchronized (bd.class) {
            long j2 = 0;
            try {
                if (at.DW()) {
                    if (TextUtils.isEmpty(at.DX())) {
                        j2 = 0;
                        if (at.DY() != null) {
                        }
                    }
                    j2 = 1;
                }
                long j3 = j2;
                if (at.DU()) {
                    j3 = j2;
                    if (at.DV() != null) {
                        j3 = j2 | 64;
                    }
                }
                long j4 = j3;
                if (at.DW()) {
                    j4 = j3;
                    if (!TextUtils.isEmpty(at.DZ())) {
                        j4 = j3 | 2;
                    }
                }
                long j5 = j4;
                if (at.Ea()) {
                    j5 = j4;
                    if (!TextUtils.isEmpty(at.Eb())) {
                        j5 = j4 | 4;
                    }
                }
                long j6 = j5;
                if (at.Ec()) {
                    j6 = j5;
                    if (!TextUtils.isEmpty(at.Ed())) {
                        j6 = j5 | 2048;
                    }
                }
                j = j6;
                if (at.Eg()) {
                    j = j6;
                    if (at.Eh() != null) {
                        j = j6 | 16;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public static String EH() {
        return Build.BRAND;
    }

    public static long EI() {
        long elapsedRealtime;
        synchronized (bd.class) {
            try {
                elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            } catch (Throwable th) {
                throw th;
            }
        }
        return elapsedRealtime;
    }

    public static long EJ() {
        long j;
        synchronized (bd.class) {
            try {
                j = Build.TIME;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public static String EK() {
        String str;
        synchronized (bd.class) {
            try {
                str = Build.FINGERPRINT;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static String EL() {
        synchronized (bd.class) {
            try {
                if (!TextUtils.isEmpty(aAT)) {
                    return aAT;
                }
                String radioVersion = Build.getRadioVersion();
                aAT = radioVersion;
                return radioVersion;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String EM() {
        String name;
        synchronized (bd.class) {
            try {
                name = as.getName();
            } catch (Throwable th) {
                throw th;
            }
        }
        return name;
    }

    public static String EN() {
        String version;
        synchronized (bd.class) {
            try {
                version = as.getVersion();
            } catch (Throwable th) {
                throw th;
            }
        }
        return version;
    }

    public static String EO() {
        return Build.MANUFACTURER;
    }

    public static int EP() {
        if (aBi == -1) {
            aBi = cZ(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) ? 4 : 3;
        }
        return aBi;
    }

    public static String EQ() {
        if (TextUtils.isEmpty(aBh)) {
            aBh = System.getProperty("os.arch");
        }
        return aBh;
    }

    public static int ER() {
        return Build.VERSION.SDK_INT;
    }

    public static String ES() {
        if (at.Ee() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(8L)) {
            return "";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    private static String ET() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable th) {
            return null;
        }
    }

    private static String EU() {
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
            return null;
        }
        String h = y.h("ksadsdk_pref", "android_id", (String) null);
        y.i(h, "ksadsdk_pref", "android_id");
        return h;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003f -> B:14:0x003b). Please submit an issue!!! */
    public static String EV() {
        if (TextUtils.isEmpty(aBr)) {
            try {
                String Q = q.Q(new File("/proc/sys/kernel/random/boot_id"));
                aBr = TextUtils.isEmpty(Q) ? "" : Q.substring(0, Q.indexOf("\n"));
            } catch (Throwable th) {
            }
            return aBr;
        }
        return aBr;
    }

    private static String a(String str, int i, char c2) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String bI(boolean z) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        String aR = com.kwad.sdk.core.e.a.aR(context);
        if (TextUtils.isEmpty(aR) && !z && TextUtils.isEmpty(cS(context))) {
            return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sC();
        }
        return aR;
    }

    public static long cP(Context context) {
        if (context == null || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static int cQ(Context context) {
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(512L)) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((BatteryManager) context.getApplicationContext().getSystemService(Context.BATTERY_SERVICE)).getIntProperty(4);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static long cR(Context context) {
        long j = aBq;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            long j3 = j2;
            if (j2 <= 0) {
                j3 = EA();
            }
            aBq = j3;
            return j3;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static String cS(Context context) {
        synchronized (bd.class) {
            try {
                if (at.DW() && !TextUtils.isEmpty(at.DX())) {
                    return at.DX();
                } else if (aBj) {
                    return aAW;
                } else if (!TextUtils.isEmpty(aAW) || context == null) {
                    return aAW;
                } else if (Build.VERSION.SDK_INT >= 29) {
                    return aAW;
                } else if (at.DW()) {
                    return aAW;
                } else if (!o.CZ()) {
                    return aAW;
                } else {
                    boolean z = false;
                    try {
                        boolean cO = SystemUtil.cO(context);
                        if (cO) {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            aAW = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                z = cO;
                                aBj = true;
                            }
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                        if (z) {
                            aBj = true;
                        }
                    }
                    return aAW;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String cT(android.content.Context r3) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.bd.cT(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d2, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.utils.bd.aBc[1]) != false) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] cU(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.bd.cU(android.content.Context):java.lang.String[]");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x005d -> B:16:0x0036). Please submit an issue!!! */
    public static int cV(Context context) {
        synchronized (bd.class) {
            try {
                if (aAZ || aAY > 0 || Build.VERSION.SDK_INT < 23 || context == null || at.DW()) {
                    return aAY;
                }
                try {
                    aAY = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                } catch (Exception e) {
                }
                aAZ = aAY == 0;
                return aAY;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int cW(Context context) {
        if (context == null || aBa > 0 || aBb || Build.VERSION.SDK_INT < 22 || !SystemUtil.cO(context) || at.DW()) {
            return aBa;
        }
        try {
            aBa = ((SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE)).getActiveSubscriptionInfoCount();
        } catch (Throwable th) {
        }
        aBb = aBa != 0;
        return aBa;
    }

    public static String cX(Context context) {
        if (!TextUtils.isEmpty(aBe) || context == null) {
            return aBe;
        }
        if (!aBl && !at.DW() && o.Db()) {
            try {
                if (SystemUtil.cO(context)) {
                    aBe = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
                aBe = null;
            }
            if (TextUtils.isEmpty(aBe)) {
                aBl = true;
            }
            String str = TextUtils.isEmpty(aBe) ? "" : aBe;
            aBe = str;
            return str;
        }
        return aBe;
    }

    public static int cY(Context context) {
        int ringerMode;
        synchronized (bd.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
            } catch (Throwable th) {
                throw th;
            }
        }
        return ringerMode;
    }

    private static boolean cZ(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static int checkSelfPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static String cm(Context context) {
        if (!TextUtils.isEmpty(aBf) || context == null || aBm) {
            return aBf;
        }
        if (at.DW()) {
            return at.DZ();
        }
        if (o.CU()) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                aBf = string;
                if (!eT(string)) {
                    aBf = "";
                }
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(aBf)) {
                aBm = true;
            }
            return aBf;
        }
        return aBf;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0062 -> B:18:0x0041). Please submit an issue!!! */
    public static String cq(Context context) {
        synchronized (bd.class) {
            if (context != null) {
                try {
                    if (!aBk && TextUtils.isEmpty(aBd) && SystemUtil.cO(context) && !at.DW() && o.Da()) {
                        try {
                            aBd = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                        } catch (Exception e) {
                        }
                        aBk = TextUtils.isEmpty(aBd);
                        return aBd;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aBd;
        }
    }

    public static String da(Context context) {
        synchronized (bd.class) {
            try {
                if (TextUtils.isEmpty(aAU) && context != null && !aAV) {
                    if (at.Ea()) {
                        String Eb = at.Eb();
                        aAU = Eb;
                        return Eb;
                    } else if (!o.CV()) {
                        return aAU;
                    } else {
                        try {
                            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                            if (connectionInfo != null) {
                                aAU = connectionInfo.getMacAddress();
                            }
                            if (eR(aAU)) {
                                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                                    if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                        if (hardwareAddress != null && hardwareAddress.length != 0) {
                                            StringBuilder sb = new StringBuilder();
                                            int length = hardwareAddress.length;
                                            int i = 0;
                                            while (true) {
                                                int i2 = i;
                                                if (i2 >= length) {
                                                    break;
                                                }
                                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                                                i = i2 + 1;
                                            }
                                            if (sb.length() > 0) {
                                                sb.deleteCharAt(sb.length() - 1);
                                            }
                                            aAU = sb.toString();
                                        }
                                    }
                                }
                            }
                            if (eR(aAU)) {
                                aAU = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                            }
                            if (!eR(aAU)) {
                                aAU = aAU.toUpperCase(Locale.US);
                            }
                        } catch (Exception e) {
                            aAV = true;
                        }
                        aAV = eR(aAU);
                        return aAU;
                    }
                }
                return aAU;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static List<String> db(Context context) {
        String[] list;
        if (!c.bw(context) && dc(context)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                String str = list[i2];
                if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                    arrayList.add(str);
                }
                i = i2 + 1;
            }
        }
        return new ArrayList();
    }

    public static boolean dc(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private static boolean eR(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean eS(String str) {
        return aBt.contains(str.toLowerCase(Locale.US));
    }

    private static boolean eT(String str) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= str.length()) {
                    return false;
                }
                if (str.charAt(i2) != '0') {
                    return true;
                }
                i = i2 + 1;
            } catch (Throwable th) {
                return false;
            }
        }
    }

    private static void eU(String str) {
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext() == null) {
            return;
        }
        y.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String eV(String str) {
        String valueOf;
        if (!TextUtils.isEmpty(aBs) || TextUtils.isEmpty(str)) {
            return aBs;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                StructStat stat = Os.stat(str);
                if (stat == null) {
                    return aBs;
                }
                String str2 = "";
                if (Build.VERSION.SDK_INT >= 27) {
                    if (stat.st_atim == null) {
                        valueOf = "";
                    } else {
                        str2 = String.valueOf(stat.st_atim.tv_sec);
                        valueOf = String.valueOf(stat.st_atim.tv_nsec);
                    }
                    aBs = str2 + "." + valueOf;
                } else {
                    if (stat.st_atime != 0) {
                        str2 = String.valueOf(stat.st_atime);
                    }
                    aBs = str2;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        return aBs;
    }

    public static String getDeviceId() {
        try {
            if (TextUtils.isEmpty(aBg)) {
                String EU = EU();
                if (!TextUtils.isEmpty(EU)) {
                    String str = "ANDROID_" + EU;
                    aBg = str;
                    return str;
                }
                String cm = cm(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
                if (!TextUtils.isEmpty(cm) && !eS(cm) && eT(cm)) {
                    String str2 = "ANDROID_" + cm;
                    aBg = str2;
                    return str2;
                }
                String ET = ET();
                if (TextUtils.isEmpty(ET)) {
                    return "ANDROID_";
                }
                aBg = "ANDROID_" + ET;
                eU(ET);
                return aBg;
            }
            return aBg;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return "ANDROID_";
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        Locale locale2 = locale;
        if (locale == null) {
            locale2 = Locale.CHINESE;
        }
        return String.valueOf(locale2);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String u(Context context, boolean z) {
        if (!at.DW() || TextUtils.isEmpty(at.DX())) {
            String cS = cS(context);
            if (TextUtils.isEmpty(cS) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.aR(context))) {
                return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sB();
            }
            return cS;
        }
        return at.DX();
    }
}
