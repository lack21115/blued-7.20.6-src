package com.sobot.chat.notchlib.utils;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/utils/RomUtils.class */
public final class RomUtils {
    private static final String HUAWEI = "huawei";
    private static final String OPPO = "oppo";
    private static final String UNKNOWN = "unknown";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VIVO = "vivo";
    private static final String XIAOMI = "xiaomi";
    private static RomInfo bean;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/utils/RomUtils$RomInfo.class */
    public static class RomInfo {
        private String name;
        private String version;

        public String getName() {
            return this.name;
        }

        public String getVersion() {
            return this.version;
        }

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + i.d;
        }
    }

    private RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static String getBrand() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable th) {
            return "unknown";
        }
    }

    private static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable th) {
            return "unknown";
        }
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo = bean;
        if (romInfo != null) {
            return romInfo;
        }
        bean = new RomInfo();
        String brand = getBrand();
        String manufacturer = getManufacturer();
        if (isRightRom(brand, manufacturer, "huawei")) {
            bean.name = "huawei";
            String romVersion = getRomVersion(VERSION_PROPERTY_HUAWEI);
            String[] split = romVersion.split(BridgeUtil.UNDERLINE_STR);
            if (split.length > 1) {
                bean.version = split[1];
            } else {
                bean.version = romVersion;
            }
            return bean;
        } else if (isRightRom(brand, manufacturer, "vivo")) {
            bean.name = "vivo";
            bean.version = getRomVersion(VERSION_PROPERTY_VIVO);
            return bean;
        } else if (isRightRom(brand, manufacturer, "xiaomi")) {
            bean.name = "xiaomi";
            bean.version = getRomVersion(VERSION_PROPERTY_XIAOMI);
            return bean;
        } else if (isRightRom(brand, manufacturer, "oppo")) {
            bean.name = "oppo";
            bean.version = getRomVersion(VERSION_PROPERTY_OPPO);
            return bean;
        } else {
            bean.name = manufacturer;
            bean.version = getRomVersion("");
            return bean;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r3.equals("unknown") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getRomVersion(java.lang.String r3) {
        /*
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lf
            r0 = r3
            java.lang.String r0 = getSystemProperty(r0)
            r3 = r0
            goto L12
        Lf:
            java.lang.String r0 = ""
            r3 = r0
        L12:
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L24
            r0 = r3
            r4 = r0
            r0 = r3
            java.lang.String r1 = "unknown"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L39
        L24:
            java.lang.String r0 = android.os.Build.DISPLAY     // Catch: java.lang.Throwable -> L45
            r5 = r0
            r0 = r3
            r4 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L45
            if (r0 != 0) goto L39
            r0 = r5
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Throwable -> L45
            r4 = r0
            goto L39
        L39:
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L43
            java.lang.String r0 = "unknown"
            return r0
        L43:
            r0 = r4
            return r0
        L45:
            r4 = move-exception
            r0 = r3
            r4 = r0
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.notchlib.utils.RomUtils.getRomVersion(java.lang.String):java.lang.String");
    }

    private static String getSystemProperty(String str) {
        String systemPropertyByShell = getSystemPropertyByShell(str);
        if (TextUtils.isEmpty(systemPropertyByShell)) {
            String systemPropertyByStream = getSystemPropertyByStream(str);
            if (TextUtils.isEmpty(systemPropertyByStream) && Build.VERSION.SDK_INT < 28) {
                return getSystemPropertyByReflect(str);
            }
            return systemPropertyByStream;
        }
        return systemPropertyByShell;
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "");
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSystemPropertyByShell(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e2) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    return "";
                }
                return "";
            } catch (Throwable th2) {
                bufferedReader2 = bufferedReader;
                th = th2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
            if (readLine == null) {
                bufferedReader.close();
                return "";
            }
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e4) {
                return readLine;
            }
        } catch (IOException e5) {
            return "";
        }
    }

    private static String getSystemPropertyByStream(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean isHuawei() {
        return "huawei".equals(getRomInfo().name);
    }

    public static boolean isOppo() {
        return "oppo".equals(getRomInfo().name);
    }

    private static boolean isRightRom(String str, String str2, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String str3 = strArr[i2];
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isVivo() {
        return "vivo".equals(getRomInfo().name);
    }

    public static boolean isXiaomi() {
        return "xiaomi".equals(getRomInfo().name);
    }
}
