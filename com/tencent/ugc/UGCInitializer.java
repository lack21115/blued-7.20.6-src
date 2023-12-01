package com.tencent.ugc;

import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCInitializer.class */
public class UGCInitializer {
    private static final String TAG = "UGCInitializer";
    private static com.tencent.liteav.base.util.b sInitializerHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
    private static int sRefCount;

    public static void initialize() {
        synchronized (UGCInitializer.class) {
            try {
                if (sRefCount == 0) {
                    LiteavLog.i(TAG, "initialize ".concat(String.valueOf(runAndWaitDownOnInitialThread(ct.a()))));
                }
                sRefCount++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitialize();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUninitialize();

    private static boolean runAndWaitDownOnInitialThread(Runnable runnable) {
        if (Looper.myLooper() == sInitializerHandler.getLooper()) {
            runnable.run();
            return true;
        }
        return sInitializerHandler.a(runnable);
    }

    public static void uninitialize() {
        synchronized (UGCInitializer.class) {
            try {
                if (sRefCount == 1) {
                    LiteavLog.i(TAG, "uninitialize ".concat(String.valueOf(runAndWaitDownOnInitialThread(cu.a()))));
                }
                if (sRefCount > 0) {
                    sRefCount--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
