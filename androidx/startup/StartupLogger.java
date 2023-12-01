package androidx.startup;

import android.util.Log;

/* loaded from: source-8756600-dex2jar.jar:androidx/startup/StartupLogger.class */
public final class StartupLogger {
    private StartupLogger() {
    }

    public static void e(String str, Throwable th) {
        Log.e("StartupLogger", str, th);
    }

    public static void i(String str) {
        Log.i("StartupLogger", str);
    }
}
