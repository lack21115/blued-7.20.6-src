package com.youzan.spiderman.utils;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/Logger.class */
public class Logger {
    private static boolean mIsLogEnabled = false;
    private static final ThreadLocal<SimpleDateFormat> sDateFormatter = new ThreadLocal<SimpleDateFormat>() { // from class: com.youzan.spiderman.utils.Logger.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss.SSS");
        }
    };
    private static long sLastTimeStamp;

    public static int d(String str, String str2, Object... objArr) {
        if (isLogEnabled()) {
            return Log.d(getTag(str), getMessage(str2, objArr));
        }
        return 0;
    }

    public static int dc(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        String message = getMessage(str2, objArr);
        if (isLogEnabled()) {
            return Log.d(tag, message);
        }
        return 0;
    }

    public static int e(String str, String str2, Object... objArr) {
        if (isLogEnabled()) {
            return Log.e(getTag(str), getMessage(str2, objArr));
        }
        return 0;
    }

    public static int e(String str, Throwable th) {
        if (isLogEnabled()) {
            return Log.e(getTag(str), Log.getStackTraceString(th));
        }
        return 0;
    }

    public static int e(String str, Throwable th, String str2, Object... objArr) {
        if (isLogEnabled()) {
            String tag = getTag(str);
            return Log.e(tag, getMessage(str2, objArr) + "\n" + Log.getStackTraceString(th));
        }
        return 0;
    }

    private static String getMessage(String str, Object... objArr) {
        String str2 = str;
        if (objArr != null) {
            if (objArr.length == 0) {
                return str;
            }
            try {
                return String.format(str, objArr);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder(str);
                int length = objArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Object obj = objArr[i2];
                    sb.append(", ");
                    sb.append(obj);
                    i = i2 + 1;
                }
                sb.append("\n");
                sb.append(Log.getStackTraceString(th));
                str2 = sb.toString();
            }
        }
        return str2;
    }

    private static String getTag(String str) {
        return String.format(":Spider:%s:(%s):%s:", sDateFormatter.get().format((Date) new java.sql.Date(System.currentTimeMillis())), Thread.currentThread().getName(), str);
    }

    public static int i(String str, String str2, Object... objArr) {
        if (isLogEnabled()) {
            return Log.i(getTag(str), getMessage(str2, objArr));
        }
        return 0;
    }

    public static boolean isLogEnabled() {
        return mIsLogEnabled;
    }

    public static void printStackTrace(String str) {
        if (!isLogEnabled()) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        d(str, "\n---------------------", new Object[0]);
        int i = 3;
        while (true) {
            int i2 = i;
            if (i2 >= stackTrace.length) {
                d(str, "---------------------\n", new Object[0]);
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            d(str, "    " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")", new Object[0]);
            i = i2 + 1;
        }
    }

    public static void setLogEnabled(boolean z) {
        mIsLogEnabled = z;
    }

    public static int t(String str, String str2, Object... objArr) {
        String str3;
        if (isLogEnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = sLastTimeStamp;
            String tag = getTag(str);
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis);
            if (sLastTimeStamp > 0) {
                str3 = " (+" + (currentTimeMillis - j) + "ms) ";
            } else {
                str3 = " ";
            }
            sb.append(str3);
            sb.append(getMessage(str2, objArr));
            int d = Log.d(tag, sb.toString());
            sLastTimeStamp = currentTimeMillis;
            return d;
        }
        return 0;
    }

    public static int v(String str, String str2, Object... objArr) {
        if (isLogEnabled()) {
            return Log.v(getTag(str), getMessage(str2, objArr));
        }
        return 0;
    }

    public static int w(String str, String str2, Object... objArr) {
        if (isLogEnabled()) {
            return Log.w(getTag(str), getMessage(str2, objArr));
        }
        return 0;
    }
}
