package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/Slog.class */
public final class Slog {
    private Slog() {
    }

    public static int d(String str, String str2) {
        return Log.println_native(3, 3, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return Log.println_native(3, 3, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int e(String str, String str2) {
        return Log.println_native(3, 6, str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return Log.println_native(3, 6, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int i(String str, String str2) {
        return Log.println_native(3, 4, str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        return Log.println_native(3, 4, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int println(int i, String str, String str2) {
        return Log.println_native(3, i, str, str2);
    }

    public static int v(String str, String str2) {
        return Log.println_native(3, 2, str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        return Log.println_native(3, 2, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int w(String str, String str2) {
        return Log.println_native(3, 5, str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        return Log.println_native(3, 5, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static int w(String str, Throwable th) {
        return Log.println_native(3, 5, str, Log.getStackTraceString(th));
    }

    public static int wtf(String str, String str2) {
        return Log.wtf(3, str, str2, null, false, true);
    }

    public static int wtf(String str, String str2, Throwable th) {
        return Log.wtf(3, str, str2, th, false, true);
    }

    public static int wtf(String str, Throwable th) {
        return Log.wtf(3, str, th.getMessage(), th, false, true);
    }

    public static void wtfQuiet(String str, String str2) {
        Log.wtfQuiet(3, str, str2, true);
    }

    public static int wtfStack(String str, String str2) {
        return Log.wtf(3, str, str2, null, true, true);
    }
}
