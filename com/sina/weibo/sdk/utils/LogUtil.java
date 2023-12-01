package com.sina.weibo.sdk.utils;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/LogUtil.class */
public class LogUtil {
    public static boolean sIsLogEnable = false;

    public static void d(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(stackTraceElement.getFileName()) + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()));
            sb.append(": ");
            sb.append(str2);
            Log.d(str, sb.toString());
        }
    }

    public static void disableLog() {
        sIsLogEnable = false;
    }

    public static void e(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(stackTraceElement.getFileName()) + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()));
            sb.append(": ");
            sb.append(str2);
            Log.e(str, sb.toString());
        }
    }

    public static void enableLog() {
        sIsLogEnable = true;
    }

    public static String getStackTraceMsg() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        return String.valueOf(stackTraceElement.getFileName()) + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
    }

    public static void i(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(stackTraceElement.getFileName()) + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()));
            sb.append(": ");
            sb.append(str2);
            Log.i(str, sb.toString());
        }
    }

    public static void v(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(stackTraceElement.getFileName()) + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()));
            sb.append(": ");
            sb.append(str2);
            Log.v(str, sb.toString());
        }
    }

    public static void w(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(stackTraceElement.getFileName()) + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()));
            sb.append(": ");
            sb.append(str2);
            Log.w(str, sb.toString());
        }
    }
}
