package com.tencent.liteav.base;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/Log.class */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";
    private static final boolean useChromiumLog = true;

    private Log() {
    }

    public static void d(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(3, str, formatLogWithStack(str2, getThrowableToLog(objArr), objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(6, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r6.length > 1) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String formatLog(java.lang.String r4, java.lang.Throwable r5, java.lang.Object... r6) {
        /*
            r0 = r4
            r7 = r0
            r0 = r6
            if (r0 == 0) goto L20
            r0 = r5
            if (r0 != 0) goto Lf
            r0 = r6
            int r0 = r0.length
            if (r0 > 0) goto L17
        Lf:
            r0 = r4
            r7 = r0
            r0 = r6
            int r0 = r0.length
            r1 = 1
            if (r0 <= r1) goto L20
        L17:
            java.util.Locale r0 = java.util.Locale.US
            r1 = r4
            r2 = r6
            java.lang.String r0 = java.lang.String.format(r0, r1, r2)
            r7 = r0
        L20:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.Log.formatLog(java.lang.String, java.lang.Throwable, java.lang.Object[]):java.lang.String");
    }

    private static String formatLogWithStack(String str, Throwable th, Object... objArr) {
        return "[" + getCallOrigin() + "] " + formatLog(str, th, objArr);
    }

    private static String getCallOrigin() {
        int i;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = i3;
            if (i3 >= stackTrace.length) {
                break;
            } else if (stackTrace[i3].getClassName().equals(name)) {
                i = i3 + 3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static void i(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(4, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    private static boolean isDebug() {
        return true;
    }

    public static boolean isLoggable(String str, int i) {
        if (isDebug() || i > 4) {
            return android.util.Log.isLoggable(str, i);
        }
        return false;
    }

    private static native void nativeWriteLogToNative(int i, String str, String str2);

    public static String normalizeTag(String str) {
        if (str.startsWith(sTagPrefix)) {
            return str;
        }
        int i = 0;
        if (str.startsWith(sDeprecatedTagPrefix)) {
            i = 3;
        }
        return sTagPrefix + str.substring(i, str.length());
    }

    public static void v(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(2, str, formatLogWithStack(str2, getThrowableToLog(objArr), objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(5, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    public static void wtf(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(7, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }
}
