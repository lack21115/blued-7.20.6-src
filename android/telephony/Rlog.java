package android.telephony;

import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/Rlog.class */
public final class Rlog {
    private Rlog() {
    }

    public static int d(String str, String str2) {
        return Log.println_native(1, 3, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return Log.println_native(1, 3, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int e(String str, String str2) {
        return Log.println_native(1, 6, str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return Log.println_native(1, 6, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int i(String str, String str2) {
        return Log.println_native(1, 4, str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        return Log.println_native(1, 4, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }

    public static int println(int i, String str, String str2) {
        return Log.println_native(1, i, str, str2);
    }

    public static int v(String str, String str2) {
        return Log.println_native(1, 2, str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        return Log.println_native(1, 2, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int w(String str, String str2) {
        return Log.println_native(1, 5, str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        return Log.println_native(1, 5, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int w(String str, Throwable th) {
        return Log.println_native(1, 5, str, Log.getStackTraceString(th));
    }
}
