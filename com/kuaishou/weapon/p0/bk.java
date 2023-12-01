package com.kuaishou.weapon.p0;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.TelephonyProperties;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bk.class */
public class bk {
    public static String A() {
        try {
            String a2 = bg.a("persist.service.bdroid.bdaddr");
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String B() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, TelephonyProperties.PROPERTY_BASEBAND_VERSION);
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String C() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfCameras);
            return sb.toString();
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String D() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String E() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String F() {
        File externalStorageDirectory;
        try {
            return (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? bh.f23748a : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String G() {
        File externalStorageDirectory;
        try {
            return (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? bh.f23748a : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static long H() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Throwable th) {
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
                bufferedReader2 = bufferedReader;
                if (readLine != null) {
                }
            } catch (Throwable th2) {
                if (bufferedReader != null) {
                    bufferedReader2 = bufferedReader;
                    bufferedReader2.close();
                    return 0L;
                }
                return 0L;
            }
            try {
                bufferedReader2.close();
                return 0L;
            } catch (IOException e) {
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
        try {
            bufferedReader.close();
            return longValue;
        } catch (IOException e2) {
            return longValue;
        }
    }

    public static String I() {
        try {
            return f.a(new File("/system/bin/app_process"));
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String J() {
        try {
            File file = new File("/system/bin/servicemanager");
            return (file.exists() && file.canRead()) ? f.a(file) : bh.d;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String K() {
        try {
            File file = new File("/system/framework/framework.jar");
            return (file.exists() && file.canRead()) ? f.a(file) : bh.d;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String L() {
        if (Build.VERSION.SDK_INT >= 14) {
            return Build.getRadioVersion();
        }
        return null;
    }

    private static float a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.xdpi;
        } catch (Throwable th) {
            return 0.0f;
        }
    }

    public static int a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getPhoneType();
        } catch (Throwable th) {
            return -2;
        }
    }

    public static String a() {
        try {
            String str = Build.MANUFACTURER;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    private static float b(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.ydpi;
        } catch (Throwable th) {
            return 0.0f;
        }
    }

    public static String b() {
        try {
            String str = Build.BRAND;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L29
            r4 = r0
            r0 = r4
            r1 = 17
            if (r0 < r1) goto L12
            r0 = r3
            java.lang.String r0 = android.webkit.WebSettings.getDefaultUserAgent(r0)     // Catch: java.lang.Throwable -> L2d
            r3 = r0
            goto L18
        L12:
            java.lang.String r0 = "http.agent"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L29
            r3 = r0
        L18:
            r0 = r3
            r5 = r0
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L24
            java.lang.String r0 = "RISK_GET_FIELD_EMPTY"
            r5 = r0
        L24:
            r0 = r5
            return r0
        L26:
            java.lang.String r0 = "RISK_EXCEPTION_HAPPEN"
            return r0
        L29:
            r3 = move-exception
            goto L26
        L2d:
            r3 = move-exception
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bk.b(android.content.Context):java.lang.String");
    }

    public static String c() {
        try {
            String str = Build.MODEL;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String c(Context context) {
        int i;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i2 = maximumWindowMetrics.getBounds().width();
                i = maximumWindowMetrics.getBounds().height();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i2 = point.x;
                i = point.y;
            } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                i = 0;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            }
            float a2 = a(j(context));
            float b = b(j(context));
            if (a2 == 0.0f || b == 0.0f) {
                return "";
            }
            int round = Math.round((i2 / a2) * 2.54f) * 10;
            int round2 = Math.round((i / b) * 2.54f) * 10;
            if (round > round2) {
                return round2 + "mm * " + round + "mm";
            }
            return round + "mm * " + round2 + "mm";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String d() {
        try {
            String str = Build.HARDWARE;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String d(Context context) {
        int i;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i2 = maximumWindowMetrics.getBounds().width();
                i = maximumWindowMetrics.getBounds().height();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i2 = point.x;
                i = point.y;
            } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                i = 0;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            }
            if (i2 > i) {
                return i + PhoneConstants.APN_TYPE_ALL + i2;
            }
            return i2 + PhoneConstants.APN_TYPE_ALL + i;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String e() {
        try {
            String str = Build.PRODUCT;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String e(Context context) {
        DisplayMetrics j = j(context);
        if (j != null) {
            return Integer.toString(j.densityDpi);
        }
        return null;
    }

    public static String f() {
        try {
            String str = Build.DEVICE;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String f(Context context) {
        Process process;
        InputStream inputStream;
        Process exec;
        try {
            exec = Runtime.getRuntime().exec("cat /proc/version");
            try {
                inputStream = exec.getInputStream();
            } catch (Throwable th) {
                process = exec;
                inputStream = null;
            }
        } catch (Throwable th2) {
            process = null;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr);
            if (read <= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                    }
                }
                if (exec != null) {
                    exec.destroy();
                    return bh.f23749c;
                }
                return bh.f23749c;
            }
            byte[] bArr2 = new byte[read];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, read);
            String str = new String(bArr2, "utf-8");
            int indexOf = str.indexOf("version");
            String str2 = null;
            if (indexOf != -1) {
                String[] split = str.substring(indexOf).split(" ");
                str2 = null;
                if (1 < split.length) {
                    str2 = split[1];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th4) {
                    }
                }
                if (exec != null) {
                    exec.destroy();
                }
                return str2;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                }
            }
            if (exec != null) {
                exec.destroy();
                return bh.f23749c;
            }
            return bh.f23749c;
        } catch (Throwable th6) {
            process = exec;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th7) {
                }
            }
            if (process != null) {
                process.destroy();
                return bh.d;
            }
            return bh.d;
        }
    }

    public static int g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT);
        } catch (Exception e) {
            return -2;
        }
    }

    public static String g() {
        try {
            String str = Build.BOARD;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static int h(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getRingerMode();
        } catch (Exception e) {
            return -2;
        }
    }

    public static String h() {
        try {
            String str = Build.HOST;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static int i(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE), new Object[0])).booleanValue() ? 0 : 1;
        } catch (Throwable th) {
            return -2;
        }
    }

    public static String i() {
        try {
            String str = Build.USER;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    private static DisplayMetrics j(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String j() {
        try {
            String str = Build.TYPE;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String k() {
        try {
            String str = Build.TAGS;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String l() {
        try {
            String str = Build.BOOTLOADER;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String m() {
        try {
            String str = Build.ID;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String n() {
        try {
            String str = Build.DISPLAY;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String o() {
        try {
            String str = Build.VERSION.CODENAME;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String p() {
        try {
            String a2 = bg.a("rild.libpath");
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String q() {
        try {
            String str = Build.VERSION.RELEASE;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            return -2;
        }
    }

    public static String s() {
        try {
            String str = Build.FINGERPRINT;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String t() {
        try {
            String property = System.getProperty("http.agent");
            String str = property;
            if (TextUtils.isEmpty(property)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String u() {
        Process process;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                inputStream = process.waitFor() == 0 ? process.getInputStream() : process.getErrorStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                inputStream = null;
            }
        } catch (Throwable th3) {
            process = null;
            inputStream = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Throwable th4) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return readLine;
        } catch (Throwable th6) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable th7) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th8) {
                }
            }
            if (process != null) {
                process.destroy();
                return bh.d;
            }
            return bh.d;
        }
    }

    public static String v() {
        try {
            String str = Build.RADIO;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String w() {
        try {
            String a2 = bg.a("ro.build.description");
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String x() {
        try {
            String str = Build.VERSION.INCREMENTAL;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = bh.f23749c;
            }
            return str2;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String y() {
        try {
            String a2 = bg.a("ro.product.name");
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public static String z() {
        try {
            String a2 = bg.a("dalvik.vm.heapgrowthlimit");
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }
}
