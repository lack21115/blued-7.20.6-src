package com.android.internal.os;

import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.ApplicationErrorReport;
import android.ddm.DdmRegister;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.AndroidConfig;
import com.android.internal.os.ZygoteInit;
import com.android.server.NetworkManagementSocketTagger;
import dalvik.system.VMRuntime;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.TimeZone;
import java.util.logging.LogManager;
import org.apache.harmony.luni.internal.util.TimezoneGetter;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/RuntimeInit.class */
public class RuntimeInit {
    private static final boolean DEBUG = false;
    private static final String TAG = "AndroidRuntime";
    private static boolean initialized;
    private static IBinder mApplicationObject;
    private static volatile boolean mCrashing = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/RuntimeInit$Arguments.class */
    public static class Arguments {
        String[] startArgs;
        String startClass;

        Arguments(String[] strArr) throws IllegalArgumentException {
            parseArgs(strArr);
        }

        private void parseArgs(String[] strArr) throws IllegalArgumentException {
            int i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = i3;
                if (i3 >= strArr.length) {
                    break;
                }
                String str = strArr[i3];
                if (!str.equals("--")) {
                    i = i3;
                    if (!str.startsWith("--")) {
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    i = i3 + 1;
                    break;
                }
            }
            if (i == strArr.length) {
                throw new IllegalArgumentException("Missing classname argument to RuntimeInit!");
            }
            int i4 = i + 1;
            this.startClass = strArr[i];
            this.startArgs = new String[strArr.length - i4];
            System.arraycopy(strArr, i4, this.startArgs, 0, this.startArgs.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/RuntimeInit$UncaughtHandler.class */
    public static class UncaughtHandler implements Thread.UncaughtExceptionHandler {
        private UncaughtHandler() {
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d2 -> B:20:0x00b8). Please submit an issue!!! */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                if (RuntimeInit.mCrashing) {
                    Process.killProcess(Process.myPid());
                    System.exit(10);
                    return;
                }
                boolean unused = RuntimeInit.mCrashing = true;
                if (RuntimeInit.mApplicationObject == null) {
                    RuntimeInit.Clog_e(RuntimeInit.TAG, "*** FATAL EXCEPTION IN SYSTEM PROCESS: " + thread.getName(), th);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("FATAL EXCEPTION: ").append(thread.getName()).append("\n");
                    String currentProcessName = ActivityThread.currentProcessName();
                    if (currentProcessName != null) {
                        sb.append("Process: ").append(currentProcessName).append(", ");
                    }
                    sb.append("PID: ").append(Process.myPid());
                    RuntimeInit.Clog_e(RuntimeInit.TAG, sb.toString(), th);
                }
                ActivityManagerNative.getDefault().handleApplicationCrash(RuntimeInit.mApplicationObject, new ApplicationErrorReport.CrashInfo(th));
                Process.killProcess(Process.myPid());
                System.exit(10);
            } catch (Throwable th2) {
                try {
                    RuntimeInit.Clog_e(RuntimeInit.TAG, "Error reporting crash", th2);
                } catch (Throwable th3) {
                }
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        }
    }

    static {
        DdmRegister.registerHandlers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int Clog_e(String str, String str2, Throwable th) {
        return Log.println_native(4, 6, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    private static void applicationInit(int i, String[] strArr, ClassLoader classLoader) throws ZygoteInit.MethodAndArgsCaller {
        nativeSetExitWithoutCleanup(true);
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
        VMRuntime.getRuntime().setTargetSdkVersion(i);
        try {
            Arguments arguments = new Arguments(strArr);
            invokeStaticMain(arguments.startClass, arguments.startArgs, classLoader);
        } catch (IllegalArgumentException e) {
            Slog.e(TAG, e.getMessage());
        }
    }

    private static final void commonInit() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtHandler());
        TimezoneGetter.setInstance(new TimezoneGetter() { // from class: com.android.internal.os.RuntimeInit.1
            @Override // org.apache.harmony.luni.internal.util.TimezoneGetter
            public String getId() {
                return SystemProperties.get("persist.sys.timezone");
            }
        });
        TimeZone.setDefault(null);
        LogManager.getLogManager().reset();
        new AndroidConfig();
        System.setProperty("http.agent", getDefaultUserAgent());
        NetworkManagementSocketTagger.install();
        if (SystemProperties.get("ro.kernel.android.tracing").equals("1")) {
            Slog.i(TAG, "NOTE: emulator trace profiling enabled");
            Debug.enableEmulatorTraceOutput();
        }
        initialized = true;
    }

    public static final IBinder getApplicationObject() {
        return mApplicationObject;
    }

    private static String getDefaultUserAgent() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dalvik/");
        sb.append(System.getProperty("java.vm.version"));
        sb.append(" (Linux; U; Android ");
        String str = Build.VERSION.RELEASE;
        if (str.length() <= 0) {
            str = "1.0";
        }
        sb.append(str);
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                sb.append("; ");
                sb.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            sb.append(" Build/");
            sb.append(str3);
        }
        sb.append(")");
        return sb.toString();
    }

    private static void invokeStaticMain(String str, String[] strArr, ClassLoader classLoader) throws ZygoteInit.MethodAndArgsCaller {
        try {
            try {
                Method method = Class.forName(str, true, classLoader).getMethod("main", String[].class);
                int modifiers = method.getModifiers();
                if (!Modifier.isStatic(modifiers) || !Modifier.isPublic(modifiers)) {
                    throw new RuntimeException("Main method is not public and static on " + str);
                }
                throw new ZygoteInit.MethodAndArgsCaller(method, strArr);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Missing static main on " + str, e);
            } catch (SecurityException e2) {
                throw new RuntimeException("Problem getting static main on " + str, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Missing class when invoking static main " + str, e3);
        }
    }

    public static final void main(String[] strArr) {
        if (strArr.length == 2 && strArr[1].equals("application")) {
            redirectLogStreams();
        }
        commonInit();
        nativeFinishInit();
    }

    private static final native void nativeFinishInit();

    private static final native void nativeSetExitWithoutCleanup(boolean z);

    private static final native void nativeZygoteInit();

    public static void redirectLogStreams() {
        System.out.close();
        System.setOut(new AndroidPrintStream(4, "System.out"));
        System.err.close();
        System.setErr(new AndroidPrintStream(5, "System.err"));
    }

    public static final void setApplicationObject(IBinder iBinder) {
        mApplicationObject = iBinder;
    }

    public static void wrapperInit(int i, String[] strArr) throws ZygoteInit.MethodAndArgsCaller {
        applicationInit(i, strArr, null);
    }

    public static void wtf(String str, Throwable th, boolean z) {
        try {
            if (ActivityManagerNative.getDefault().handleApplicationWtf(mApplicationObject, str, z, new ApplicationErrorReport.CrashInfo(th))) {
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        } catch (Throwable th2) {
            Slog.e(TAG, "Error reporting WTF", th2);
            Slog.e(TAG, "Original WTF:", th);
        }
    }

    public static final void zygoteInit(int i, String[] strArr, ClassLoader classLoader) throws ZygoteInit.MethodAndArgsCaller {
        redirectLogStreams();
        commonInit();
        nativeZygoteInit();
        applicationInit(i, strArr, classLoader);
    }
}
