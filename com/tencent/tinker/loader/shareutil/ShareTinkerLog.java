package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.Constructor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareTinkerLog.class */
public class ShareTinkerLog {
    public static final int FN_LOG_PRINT_PENDING_LOGS = 4002;
    public static final int FN_LOG_PRINT_STACKTRACE = 4001;
    private static final String TAG = "Tinker.ShareTinkerLog";
    private static final TinkerLogImp debugLog;
    private static final TinkerLogImp[] tinkerLogImpRef;
    private static final Handler[] tinkerLogInlineFenceRef = {null};

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareTinkerLog$TinkerLogImp.class */
    public interface TinkerLogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        TinkerLogImp tinkerLogImp = new TinkerLogImp() { // from class: com.tencent.tinker.loader.shareutil.ShareTinkerLog.1
            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public void d(String str, String str2, Object... objArr) {
                String str3 = str2;
                if (objArr != null) {
                    str3 = objArr.length == 0 ? str2 : String.format(str2, objArr);
                }
                Log.d(str, str3);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public void e(String str, String str2, Object... objArr) {
                String str3 = str2;
                if (objArr != null) {
                    str3 = objArr.length == 0 ? str2 : String.format(str2, objArr);
                }
                Log.e(str, str3);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public void i(String str, String str2, Object... objArr) {
                String str3 = str2;
                if (objArr != null) {
                    str3 = objArr.length == 0 ? str2 : String.format(str2, objArr);
                }
                Log.i(str, str3);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                String str3 = str2;
                if (objArr != null) {
                    str3 = objArr.length == 0 ? str2 : String.format(str2, objArr);
                }
                String str4 = str3;
                if (str3 == null) {
                    str4 = "";
                }
                Log.e(str, str4 + "  " + Log.getStackTraceString(th));
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public void v(String str, String str2, Object... objArr) {
                String str3 = str2;
                if (objArr != null) {
                    str3 = objArr.length == 0 ? str2 : String.format(str2, objArr);
                }
                Log.v(str, str3);
            }

            @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
            public void w(String str, String str2, Object... objArr) {
                String str3 = str2;
                if (objArr != null) {
                    str3 = objArr.length == 0 ? str2 : String.format(str2, objArr);
                }
                Log.w(str, str3);
            }
        };
        debugLog = tinkerLogImp;
        tinkerLogImpRef = new TinkerLogImp[]{tinkerLogImp};
        synchronized (tinkerLogInlineFenceRef) {
            try {
                Constructor<?> declaredConstructor = Class.forName("com.tencent.tinker.loader.shareutil.TinkerLogInlineFence").getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                tinkerLogInlineFenceRef[0] = (Handler) declaredConstructor.newInstance(new Object[0]);
            }
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        printLog(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        printLog(6, str, str2, objArr);
    }

    public static TinkerLogImp getDefaultImpl() {
        return debugLog;
    }

    public static TinkerLogImp getImpl() {
        TinkerLogImp tinkerLogImp;
        synchronized (tinkerLogImpRef) {
            tinkerLogImp = tinkerLogImpRef[0];
        }
        return tinkerLogImp;
    }

    private static Handler getInlineFence() {
        Handler handler;
        synchronized (tinkerLogInlineFenceRef) {
            handler = tinkerLogInlineFenceRef[0];
        }
        return handler;
    }

    public static void i(String str, String str2, Object... objArr) {
        printLog(4, str, str2, objArr);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        printLog(str, th, str2, objArr);
    }

    private static void printLog(int i, String str, String str2, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Handler inlineFence = getInlineFence();
        if (inlineFence != null) {
            Message obtain = Message.obtain(inlineFence, i, new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis), str, str2, objArr});
            inlineFence.handleMessage(obtain);
            obtain.recycle();
            return;
        }
        TinkerLogImp tinkerLogImp = debugLog;
        tinkerLogImp.e(str, "!! NO_LOG_IMPL !! Original Log: " + str2, objArr);
    }

    private static void printLog(String str, Throwable th, String str2, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Handler inlineFence = getInlineFence();
        if (inlineFence != null) {
            Message obtain = Message.obtain(inlineFence, 4001, new Object[]{4001, Long.valueOf(currentTimeMillis), str, th, str2, objArr});
            inlineFence.handleMessage(obtain);
            obtain.recycle();
            return;
        }
        TinkerLogImp tinkerLogImp = debugLog;
        tinkerLogImp.printErrStackTrace(str, th, "!! NO_LOG_IMPL !! Original Log: " + str2, objArr);
    }

    public static void printPendingLogs() {
        Handler inlineFence = getInlineFence();
        if (inlineFence != null) {
            Message obtain = Message.obtain(inlineFence, 4002);
            inlineFence.handleMessage(obtain);
            obtain.recycle();
        }
    }

    public static void setTinkerLogImp(TinkerLogImp tinkerLogImp) {
        synchronized (tinkerLogImpRef) {
            tinkerLogImpRef[0] = tinkerLogImp;
            if (tinkerLogImp != null && tinkerLogImp != debugLog) {
                printPendingLogs();
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        printLog(2, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        printLog(5, str, str2, objArr);
    }
}
