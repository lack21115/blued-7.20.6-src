package android.util;

import com.android.internal.os.RuntimeInit;
import com.android.internal.util.FastPrintWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: source-9557208-dex2jar.jar:android/util/Log.class */
public final class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int LOG_ID_CRASH = 4;
    public static final int LOG_ID_EVENTS = 2;
    public static final int LOG_ID_MAIN = 0;
    public static final int LOG_ID_RADIO = 1;
    public static final int LOG_ID_SYSTEM = 3;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler() { // from class: android.util.Log.1
        @Override // android.util.Log.TerribleFailureHandler
        public void onTerribleFailure(String str, TerribleFailure terribleFailure, boolean z) {
            RuntimeInit.wtf(str, terribleFailure, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/util/Log$TerribleFailure.class */
    public static class TerribleFailure extends Exception {
        TerribleFailure(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/util/Log$TerribleFailureHandler.class */
    public interface TerribleFailureHandler {
        void onTerribleFailure(String str, TerribleFailure terribleFailure, boolean z);
    }

    private Log() {
    }

    public static int d(String str, String str2) {
        return println_native(0, 3, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return println_native(0, 3, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int e(String str, String str2) {
        return println_native(0, 6, str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return println_native(0, 6, str, str2 + '\n' + getStackTraceString(th));
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        Throwable th2 = th;
        while (true) {
            Throwable th3 = th2;
            if (th3 == null) {
                StringWriter stringWriter = new StringWriter();
                FastPrintWriter fastPrintWriter = new FastPrintWriter(stringWriter, false, 256);
                th.printStackTrace((PrintWriter) fastPrintWriter);
                fastPrintWriter.flush();
                return stringWriter.toString();
            } else if (th3 instanceof UnknownHostException) {
                return "";
            } else {
                th2 = th3.getCause();
            }
        }
    }

    public static int i(String str, String str2) {
        return println_native(0, 4, str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        return println_native(0, 4, str, str2 + '\n' + getStackTraceString(th));
    }

    public static native boolean isLoggable(String str, int i);

    public static int println(int i, String str, String str2) {
        return println_native(0, i, str, str2);
    }

    public static native int println_native(int i, int i2, String str, String str2);

    public static TerribleFailureHandler setWtfHandler(TerribleFailureHandler terribleFailureHandler) {
        if (terribleFailureHandler == null) {
            throw new NullPointerException("handler == null");
        }
        TerribleFailureHandler terribleFailureHandler2 = sWtfHandler;
        sWtfHandler = terribleFailureHandler;
        return terribleFailureHandler2;
    }

    public static int v(String str, String str2) {
        return println_native(0, 2, str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        return println_native(0, 2, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, String str2) {
        return println_native(0, 5, str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        return println_native(0, 5, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, Throwable th) {
        return println_native(0, 5, str, getStackTraceString(th));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int wtf(int i, String str, String str2, Throwable th, boolean z, boolean z2) {
        TerribleFailure terribleFailure = new TerribleFailure(str2, th);
        StringBuilder append = new StringBuilder().append(str2).append('\n');
        TerribleFailure terribleFailure2 = th;
        if (z) {
            terribleFailure2 = terribleFailure;
        }
        int println_native = println_native(i, 7, str, append.append(getStackTraceString(terribleFailure2)).toString());
        sWtfHandler.onTerribleFailure(str, terribleFailure, z2);
        return println_native;
    }

    public static int wtf(String str, String str2) {
        return wtf(0, str, str2, null, false, false);
    }

    public static int wtf(String str, String str2, Throwable th) {
        return wtf(0, str, str2, th, false, false);
    }

    public static int wtf(String str, Throwable th) {
        return wtf(0, str, th.getMessage(), th, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void wtfQuiet(int i, String str, String str2, boolean z) {
        sWtfHandler.onTerribleFailure(str, new TerribleFailure(str2, null), z);
    }

    public static int wtfStack(String str, String str2) {
        return wtf(0, str, str2, null, true, false);
    }
}
