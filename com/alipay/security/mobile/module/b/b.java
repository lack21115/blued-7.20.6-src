package com.alipay.security.mobile.module.b;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.SmsConstants;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.util.cm.QSConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.transform.OutputKeys;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/b/b.class */
public final class b {
    private static b a = new b();

    private b() {
    }

    public static b a() {
        return a;
    }

    public static String a(Context context) {
        if (a(context, com.anythink.china.common.d.a)) {
            return "";
        }
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
                str = null;
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Throwable th) {
                str = null;
            }
        }
        return str == null ? "" : str;
    }

    private static boolean a(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static String b() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r3) {
        /*
            r0 = r3
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto Lc
            java.lang.String r0 = ""
            return r0
        Lc:
            r0 = r3
            if (r0 == 0) goto L26
            r0 = r3
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L32
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Throwable -> L32
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L26
            r0 = r3
            java.lang.String r0 = r0.getSubscriberId()     // Catch: java.lang.Throwable -> L32
            r3 = r0
            goto L29
        L26:
            java.lang.String r0 = ""
            r3 = r0
        L29:
            r0 = r3
            if (r0 != 0) goto L30
            java.lang.String r0 = ""
            return r0
        L30:
            r0 = r3
            return r0
        L32:
            r3 = move-exception
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.b(android.content.Context):java.lang.String");
    }

    public static String c() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(com.alipay.security.mobile.module.a.a.a().getPath());
                j = statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
        } catch (Throwable th) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String c(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable th) {
        }
        return i == 1 ? "1" : "0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
        r8 = r0.substring(r0.indexOf(":") + 1, r0.length()).trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.d():java.lang.String");
    }

    public static String d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i));
            jSONObject.put("call", String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put("alarm", String.valueOf(streamVolume5));
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
        if ("null".equals(r4) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(android.content.Context r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L20
            r0 = r3
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L34
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Throwable -> L34
            r3 = r0
            r0 = r5
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L20
            r0 = r3
            java.lang.String r0 = r0.getNetworkOperatorName()     // Catch: java.lang.Throwable -> L34
            r4 = r0
            goto L20
        L20:
            r0 = r4
            if (r0 == 0) goto L2f
            r0 = r4
            r3 = r0
            java.lang.String r0 = "null"
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L32
        L2f:
            java.lang.String r0 = ""
            r3 = r0
        L32:
            r0 = r3
            return r0
        L34:
            r3 = move-exception
            r0 = r5
            r4 = r0
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.e(android.content.Context):java.lang.String");
    }

    public static String f() {
        String v = v();
        return !com.alipay.security.mobile.module.a.a.a(v) ? v : w();
    }

    public static String f(Context context) {
        String str = null;
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                str = null;
                if (sensorManager != null) {
                    List<Sensor> sensorList = sensorManager.getSensorList(-1);
                    str = null;
                    if (sensorList != null) {
                        str = null;
                        if (sensorList.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            for (Sensor sensor : sensorList) {
                                sb.append(sensor.getName());
                                sb.append(sensor.getVersion());
                                sb.append(sensor.getVendor());
                            }
                            str = com.alipay.security.mobile.module.a.a.e(sb.toString());
                        }
                    }
                }
            } catch (Throwable th) {
                str = null;
            }
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public static String g() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    if (split != null) {
                        if (split.length > 1) {
                            String str = split[1];
                            try {
                                fileReader.close();
                            } catch (Throwable th) {
                            }
                            try {
                                bufferedReader.close();
                                return str;
                            } catch (Throwable th2) {
                                return str;
                            }
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th5) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                    return "";
                }
            } catch (Throwable th6) {
                bufferedReader = null;
            }
        } catch (Throwable th7) {
            bufferedReader = null;
            fileReader = null;
        }
        try {
            bufferedReader.close();
            return "";
        } catch (Throwable th8) {
            return "";
        }
    }

    public static String g(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put(OutputKeys.VERSION, sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
        if (r10 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String h() {
        /*
            r0 = 0
            r10 = r0
            r0 = 0
            r6 = r0
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L7c
            r1 = r0
            java.lang.String r2 = "/proc/meminfo"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7c
            r11 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7c java.lang.Throwable -> L81
            r1 = r0
            r2 = r11
            r3 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L81
            r10 = r0
            r0 = r10
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L86
            r12 = r0
            r0 = r6
            r8 = r0
            r0 = r12
            if (r0 == 0) goto L3e
            r0 = r12
            java.lang.String r1 = "\\s+"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L86
            r1 = 1
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L86
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L86
            r5 = r0
            r0 = r5
            long r0 = (long) r0
            r8 = r0
        L3e:
            r0 = r11
            r0.close()     // Catch: java.lang.Throwable -> L8b
            r0 = r8
            r6 = r0
        L45:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> L92
            r0 = r6
            r8 = r0
            goto L77
        L4f:
            r0 = 0
            r10 = r0
        L52:
            goto L60
        L55:
            r0 = 0
            r12 = r0
            r0 = r10
            r11 = r0
            r0 = r12
            r10 = r0
        L60:
            r0 = r11
            if (r0 == 0) goto L6d
            r0 = r11
            r0.close()     // Catch: java.lang.Throwable -> L99
            goto L6d
        L6d:
            r0 = r6
            r8 = r0
            r0 = r10
            if (r0 == 0) goto L77
            goto L45
        L77:
            r0 = r8
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L7c:
            r11 = move-exception
            goto L55
        L81:
            r10 = move-exception
            goto L4f
        L86:
            r12 = move-exception
            goto L52
        L8b:
            r11 = move-exception
            r0 = r8
            r6 = r0
            goto L45
        L92:
            r10 = move-exception
            r0 = r6
            r8 = r0
            goto L77
        L99:
            r11 = move-exception
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.h():java.lang.String");
    }

    public static String h(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + PhoneConstants.APN_TYPE_ALL + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String i() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String i(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String j() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = statFs.getBlockSize() * statFs.getBlockCount();
            }
        } catch (Throwable th) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String k() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), TelephonyProperties.PROPERTY_BASEBAND_VERSION, "no message");
        } catch (Throwable th) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String k(Context context) {
        String str = "";
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            String macAddress = ((WifiManager) context.getSystemService(QSConstants.TILE_WIFI)).getConnectionInfo().getMacAddress();
            if (macAddress == null || macAddress.length() == 0 || "02:00:00:00:00:00".equals(macAddress)) {
                str = macAddress;
                return u();
            }
            return macAddress;
        } catch (Throwable th) {
            return str;
        }
    }

    public static String l() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable th) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String l(Context context) {
        if (a(context, com.anythink.china.common.d.a)) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY)).getSimSerialNumber();
            String str = "";
            if (simSerialNumber != null) {
                if (simSerialNumber != null) {
                    try {
                        if (simSerialNumber.length() == 0) {
                            return "";
                        }
                    } catch (Throwable th) {
                    }
                }
                str = simSerialNumber;
            }
            return str;
        } catch (Throwable th2) {
            return "";
        }
    }

    public static String m() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String m(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String n() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String n(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String o() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String o(android.content.Context r3) {
        /*
            r0 = r3
            java.lang.String r1 = "android.permission.ACCESS_WIFI_STATE"
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            r0 = r3
            java.lang.String r1 = "wifi"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L36
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0     // Catch: java.lang.Throwable -> L36
            r3 = r0
            r0 = r3
            boolean r0 = r0.isWifiEnabled()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L2a
            r0 = r3
            android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()     // Catch: java.lang.Throwable -> L36
            java.lang.String r0 = r0.getBSSID()     // Catch: java.lang.Throwable -> L36
            r3 = r0
            goto L2d
        L2a:
            java.lang.String r0 = ""
            r3 = r0
        L2d:
            r0 = r3
            if (r0 != 0) goto L34
            java.lang.String r0 = ""
            return r0
        L34:
            r0 = r3
            return r0
        L36:
            r3 = move-exception
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.o(android.content.Context):java.lang.String");
    }

    public static String p() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("00:");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 7) {
                    return sb.toString();
                }
                sb.append(new File(new String[]{"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"}[i2]).exists() ? "1" : "0");
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003b -> B:13:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String p(android.content.Context r3) {
        /*
            r0 = r3
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.targetSdkVersion
            r4 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3b
            r1 = 29
            if (r0 < r1) goto L13
            goto L2f
        L13:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3b
            r1 = 26
            if (r0 < r1) goto L28
            r0 = r4
            r1 = 28
            if (r0 < r1) goto L28
            java.lang.String r0 = android.os.Build.getSerial()     // Catch: java.lang.Throwable -> L3b
            r3 = r0
            goto L32
        L28:
            java.lang.String r0 = android.os.Build.SERIAL     // Catch: java.lang.Throwable -> L3b
            r3 = r0
            goto L32
        L2f:
            java.lang.String r0 = ""
            r3 = r0
        L32:
            r0 = r3
            if (r0 != 0) goto L39
            java.lang.String r0 = ""
            return r0
        L39:
            r0 = r3
            return r0
        L3b:
            r3 = move-exception
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.p(android.content.Context):java.lang.String");
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 0) {
                return sb.toString();
            }
            try {
                Class.forName(new String[]{"dalvik.system.Taint"}[0]);
                sb.append("1");
            } catch (Throwable th) {
                sb.append("0");
            }
            i = i2 + 1;
        }
    }

    public static String q(Context context) {
        try {
            String t = t(context);
            String x = x();
            String str = "";
            if (com.alipay.security.mobile.module.a.a.b(t)) {
                str = "";
                if (com.alipay.security.mobile.module.a.a.b(x)) {
                    str = t + ":" + x();
                }
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String r() {
        LineNumberReader lineNumberReader;
        char c;
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00:");
        for (String str : linkedHashMap.keySet()) {
            try {
                lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader.readLine();
                        c = '0';
                        if (readLine == null) {
                            break;
                        } else if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c = '1';
                            break;
                        }
                    } catch (Throwable th) {
                        sb.append('0');
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                }
                sb.append(c);
                try {
                    lineNumberReader.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                lineNumberReader = null;
            }
        }
        return sb.toString();
    }

    public static String r(Context context) {
        try {
            long j = 0;
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 5) {
                    return "1:" + j;
                }
                long j2 = -1;
                try {
                    j2 = new File(new String[]{"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"}[i2]).lastModified();
                } catch (Throwable th) {
                }
                j = Math.max(j2, j);
                i = i2 + 1;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    public static String s() {
        char c;
        StringBuilder sb = new StringBuilder();
        sb.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", SmsConstants.FORMAT_UNKNOWN);
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            try {
                String str2 = (String) Build.class.getField(str).get(null);
                String str3 = (String) linkedHashMap.get(str);
                String lowerCase = str2 != null ? str2.toLowerCase() : null;
                c = '0';
                if (lowerCase != null) {
                    c = '0';
                    if (lowerCase.contains(str3)) {
                        c = '1';
                    }
                }
            } catch (Throwable th) {
                c = '0';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String s(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra2 == 2 || intExtra2 == 5;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(":");
            sb.append(intExtra);
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String t() {
        StringBuilder sb = new StringBuilder();
        sb.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            String str2 = (String) linkedHashMap.get(str);
            String b = com.alipay.security.mobile.module.a.a.b(str, "");
            char c = '0';
            if (b != null) {
                c = '0';
                if (b.contains(str2)) {
                    c = '1';
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static String t(Context context) {
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            String str = null;
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 4 && subtype != 1 && subtype != 2 && subtype != 7 && subtype != 11) {
                    return (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
                }
                str = "2G";
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        r0 = r0.getHardwareAddress();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        return "02:00:00:00:00:00";
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        r0 = new java.lang.StringBuilder();
        r0 = r0.length;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
        if (r8 >= r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
        r0.append(java.lang.String.format("%02X:", java.lang.Integer.valueOf(r0[r8] & 255)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        r0 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
        if (r0.length() <= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
        r0.deleteCharAt(r0.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        r10 = r0.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String u() {
        /*
            java.lang.String r0 = "02:00:00:00:00:00"
            r11 = r0
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Throwable -> La6
            java.util.ArrayList r0 = java.util.Collections.list(r0)     // Catch: java.lang.Throwable -> La6
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r12
            if (r0 == 0) goto La4
            r0 = r12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> La6
            r12 = r0
        L1c:
            r0 = r11
            r10 = r0
            r0 = r12
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto La4
            r0 = r12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> La6
            java.net.NetworkInterface r0 = (java.net.NetworkInterface) r0     // Catch: java.lang.Throwable -> La6
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L1c
            r0 = r10
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L1c
            r0 = r10
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = "wlan0"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L1c
            r0 = r10
            byte[] r0 = r0.getHardwareAddress()     // Catch: java.lang.Throwable -> La6
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L58
            java.lang.String r0 = "02:00:00:00:00:00"
            return r0
        L58:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> La6
            r11 = r0
            r0 = r10
            int r0 = r0.length     // Catch: java.lang.Throwable -> La6
            r9 = r0
            r0 = 0
            r8 = r0
        L65:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L8d
            r0 = r11
            java.lang.String r1 = "%02X:"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La6
            r3 = r2
            r4 = 0
            r5 = r10
            r6 = r8
            r5 = r5[r6]     // Catch: java.lang.Throwable -> La6
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> La6
            r3[r4] = r5     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La6
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L65
        L8d:
            r0 = r11
            int r0 = r0.length()     // Catch: java.lang.Throwable -> La6
            if (r0 <= 0) goto L9f
            r0 = r11
            r1 = r11
            int r1 = r1.length()     // Catch: java.lang.Throwable -> La6
            r2 = 1
            int r1 = r1 - r2
            java.lang.StringBuilder r0 = r0.deleteCharAt(r1)     // Catch: java.lang.Throwable -> La6
        L9f:
            r0 = r11
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La6
            r10 = r0
        La4:
            r0 = r10
            return r0
        La6:
            r10 = move-exception
            java.lang.String r0 = "02:00:00:00:00:00"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.u():java.lang.String");
    }

    private static String v() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            fileReader = null;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (Throwable th3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable th4) {
                }
            }
            if (fileReader == null) {
                return "";
            }
            try {
                fileReader.close();
                return "";
            } catch (Throwable th5) {
                return "";
            }
        }
        if (com.alipay.security.mobile.module.a.a.a(readLine)) {
            try {
                bufferedReader.close();
            } catch (Throwable th6) {
            }
            fileReader.close();
            return "";
        }
        String trim = readLine.trim();
        try {
            bufferedReader.close();
        } catch (Throwable th7) {
        }
        try {
            fileReader.close();
            return trim;
        } catch (Throwable th8) {
            return trim;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        r5 = r0[1].trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String w() {
        /*
            java.lang.String r0 = ""
            r6 = r0
            r0 = 0
            r7 = r0
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L81
            r1 = r0
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L81
            r8 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L81 java.lang.Throwable -> L85
            r1 = r0
            r2 = r8
            r3 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L85
            r7 = r0
        L1b:
            r0 = r7
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L89
            r9 = r0
            r0 = r6
            r5 = r0
            r0 = r9
            if (r0 == 0) goto L55
            r0 = r9
            boolean r0 = com.alipay.security.mobile.module.a.a.a(r0)     // Catch: java.lang.Throwable -> L89
            if (r0 != 0) goto L1b
            r0 = r9
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L89
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L1b
            r0 = r5
            int r0 = r0.length     // Catch: java.lang.Throwable -> L89
            r1 = 1
            if (r0 <= r1) goto L1b
            r0 = r5
            r1 = 0
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = "BogoMIPS"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L1b
            r0 = r5
            r1 = 1
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L89
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L89
            r5 = r0
        L55:
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> L8f
        L59:
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L93
            r0 = r5
            return r0
        L5f:
            r0 = 0
            r5 = r0
        L61:
            r0 = r8
            r7 = r0
            goto L68
        L66:
            r0 = 0
            r5 = r0
        L68:
            r0 = r7
            if (r0 == 0) goto L73
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L96
            goto L73
        L73:
            r0 = r5
            if (r0 == 0) goto L7e
            r0 = r5
            r7 = r0
            r0 = r6
            r5 = r0
            goto L59
        L7e:
            java.lang.String r0 = ""
            return r0
        L81:
            r5 = move-exception
            goto L66
        L85:
            r5 = move-exception
            goto L5f
        L89:
            r5 = move-exception
            r0 = r7
            r5 = r0
            goto L61
        L8f:
            r6 = move-exception
            goto L59
        L93:
            r6 = move-exception
            r0 = r5
            return r0
        L96:
            r7 = move-exception
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.security.mobile.module.b.b.w():java.lang.String");
    }

    private static String x() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public final String e() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable th) {
            return "1";
        }
    }
}
