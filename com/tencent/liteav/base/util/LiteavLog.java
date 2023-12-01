package com.tencent.liteav.base.util;

import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/LiteavLog.class */
public class LiteavLog {
    private static a sCallback;
    private static final boolean useChromiumBaseLog = true;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/LiteavLog$a.class */
    public interface a {
        void a(b bVar, String str, String str2);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/LiteavLog$b.class */
    public enum b {
        kAll(0),
        kInfo(1),
        kWarning(2),
        kError(3),
        kFatal(4),
        kNone(5);
        
        public int mNativeValue;

        b(int i) {
            this.mNativeValue = i;
        }

        public static final b a(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? kNone : kFatal : kError : kWarning : kInfo : kAll;
        }
    }

    static {
        o.a();
    }

    public static void d(String str, String str2) {
        Log.d(str, str2, new Object[0]);
    }

    public static void d(String str, String str2, Object... objArr) {
        d(str, String.format(str2, objArr));
    }

    public static void e(String str, String str2) {
        Log.e(str, str2, new Object[0]);
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, str2 + "\n" + android.util.Log.getStackTraceString(th));
    }

    public static void e(String str, String str2, Object... objArr) {
        e(str, String.format(str2, objArr));
    }

    public static int getLogLevel() {
        return nativeGetLogLevel();
    }

    public static void i(String str, String str2) {
        Log.i(str, str2, new Object[0]);
    }

    public static void i(String str, String str2, Object... objArr) {
        i(str, String.format(str2, objArr));
    }

    public static native int nativeGetLogLevel();

    public static native void nativeSetConsoleLogEnabled(boolean z);

    public static native void nativeSetLogCallbackEnabled(boolean z);

    public static native void nativeSetLogCompressEnabled(boolean z);

    public static native void nativeSetLogFilePath(String str);

    public static native void nativeSetLogLevel(int i);

    public static native void nativeSetLogToFileEnabled(boolean z);

    public static void onLog(int i, String str) {
        a aVar = sCallback;
        if (aVar != null) {
            aVar.a(b.a(i), "TXLiteAVSDK", str);
        }
    }

    public static void setCallback(a aVar) {
        sCallback = aVar;
    }

    public static void v(String str, String str2) {
        Log.v(str, str2, new Object[0]);
    }

    public static void v(String str, String str2, Object... objArr) {
        v(str, String.format(str2, objArr));
    }

    public static void w(String str, String str2) {
        Log.w(str, str2, new Object[0]);
    }

    public static void w(String str, String str2, Object... objArr) {
        w(str, String.format(str2, objArr));
    }
}
