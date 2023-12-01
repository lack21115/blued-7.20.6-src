package com.sobot.network.http.log;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/log/SobotNetLogUtils.class */
public class SobotNetLogUtils {
    private static final int MAX_LENGTH = 3072;
    public static boolean allowD = false;
    public static boolean allowE = false;
    public static boolean allowI = false;
    public static boolean allowV = false;
    public static boolean allowW = false;
    public static boolean allowWtf = false;
    public static boolean isDebug = false;

    private SobotNetLogUtils() {
    }

    public static void d(String str) {
        if (isDebug && allowD) {
            Log.d(generateTag(), str);
        }
    }

    public static void d(String str, Throwable th) {
        if (isDebug && allowD) {
            Log.d(generateTag(), str, th);
        }
    }

    public static void e(String str) {
        if (isDebug && allowE) {
            Log.e(generateTag(), str);
        }
    }

    public static void e(String str, Throwable th) {
        if (isDebug && allowE) {
            Log.e(generateTag(), str, th);
        }
    }

    public static String generateTag() {
        return "sobot_log";
    }

    private static String getCurrentTime(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    public static void i(String str) {
        if (isDebug && allowI) {
            String generateTag = generateTag();
            if (str.length() <= MAX_LENGTH) {
                Log.i(generateTag, str);
                return;
            }
            String substring = str.substring(0, MAX_LENGTH);
            Log.i(generateTag + "分段打印开始", substring);
            String substring2 = str.substring(MAX_LENGTH, str.length());
            if (str.length() - MAX_LENGTH > MAX_LENGTH) {
                i(substring2);
                return;
            }
            Log.i(generateTag + "分段打印结束", substring2);
        }
    }

    public static void i(String str, Throwable th) {
        if (isDebug && allowI) {
            Log.i(generateTag(), str, th);
        }
    }

    public static void setShowDebug(Boolean bool) {
        if (bool.booleanValue()) {
            isDebug = true;
            allowI = true;
            allowE = true;
            allowD = true;
            return;
        }
        isDebug = false;
        allowI = false;
        allowE = false;
        allowD = true;
    }

    public static void v(String str) {
        if (isDebug && allowV) {
            Log.v(generateTag(), str);
        }
    }

    public static void v(String str, Throwable th) {
        if (isDebug && allowV) {
            Log.v(generateTag(), str, th);
        }
    }

    public static void w(String str) {
        if (isDebug && allowW) {
            Log.w(generateTag(), str);
        }
    }

    public static void w(String str, Throwable th) {
        if (isDebug && allowW) {
            Log.w(generateTag(), str, th);
        }
    }

    public static void w(Throwable th) {
        if (isDebug && allowW) {
            Log.w(generateTag(), th);
        }
    }

    public static void wtf(String str) {
        if (isDebug && allowWtf) {
            Log.wtf(generateTag(), str);
        }
    }

    public static void wtf(String str, Throwable th) {
        if (isDebug && allowWtf) {
            Log.wtf(generateTag(), str, th);
        }
    }

    public static void wtf(Throwable th) {
        if (isDebug && allowWtf) {
            Log.wtf(generateTag(), th);
        }
    }
}
