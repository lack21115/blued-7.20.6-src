package com.umeng.commonsdk.debug;

import android.util.Log;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.commonsdk.UMConfigure;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/debug/UMRTLog.class */
public class UMRTLog {
    private static final String RTLOG_ENABLE = "1";
    private static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    public static void d(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.d(str, warpperMsg(str2, false));
        }
    }

    public static void e(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.e(str, warpperMsg(str2, false));
        }
    }

    public static void i(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.i(str, warpperMsg(str2, false));
        }
    }

    public static void sd(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.d(str, warpperMsg(str2, true));
        }
    }

    public static void se(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.e(str, warpperMsg(str2, true));
        }
    }

    public static void si(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.i(str, warpperMsg(str2, true));
        }
    }

    public static void sv(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.v(str, warpperMsg(str2, true));
        }
    }

    public static void sw(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.w(str, warpperMsg(str2, true));
        }
    }

    public static void v(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.v(str, warpperMsg(str2, false));
        }
    }

    public static void w(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.w(str, warpperMsg(str2, false));
        }
    }

    private static String warpperMsg(String str, boolean z) {
        if (z) {
            StringBuffer stringBuffer = null;
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace.length >= 3) {
                    String fileName = stackTrace[2].getFileName();
                    String methodName = stackTrace[2].getMethodName();
                    int lineNumber = stackTrace[2].getLineNumber();
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(SimpleComparison.LESS_THAN_OPERATION);
                    stringBuffer.append(fileName);
                    stringBuffer.append(":");
                    stringBuffer.append(methodName);
                    stringBuffer.append(":");
                    stringBuffer.append(lineNumber);
                    stringBuffer.append("> ");
                    stringBuffer.append(str);
                }
                return stringBuffer.toString();
            } catch (Throwable th) {
                return str;
            }
        }
        return str;
    }
}
