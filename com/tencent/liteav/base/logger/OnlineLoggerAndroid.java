package com.tencent.liteav.base.logger;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/logger/OnlineLoggerAndroid.class */
public class OnlineLoggerAndroid {
    private static final int INVALID_INSTANCE = -1;
    private long mNativeOnlineLoggerAndroid;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/logger/OnlineLoggerAndroid$a.class */
    public enum a {
        kApi(1),
        kInfo(2),
        kWarning(3),
        kError(4);
        
        int level;

        a(int i) {
            this.level = i;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/logger/OnlineLoggerAndroid$b.class */
    public enum b {
        kTRTC,
        kLive
    }

    public OnlineLoggerAndroid(b bVar, int i, String str, String str2) {
        this.mNativeOnlineLoggerAndroid = -1L;
        this.mNativeOnlineLoggerAndroid = nativeCreate(bVar.ordinal(), i, str, str2);
    }

    private static native long nativeCreate(int i, int i2, String str, String str2);

    private static native void nativeDestroy(long j);

    private static native void nativeLog(long j, int i, String str);

    public void destroy() {
        synchronized (this) {
            if (this.mNativeOnlineLoggerAndroid == -1) {
                return;
            }
            nativeDestroy(this.mNativeOnlineLoggerAndroid);
            this.mNativeOnlineLoggerAndroid = -1L;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public void log(a aVar, String str) {
        synchronized (this) {
            if (this.mNativeOnlineLoggerAndroid == -1) {
                return;
            }
            nativeLog(this.mNativeOnlineLoggerAndroid, aVar.level, str);
        }
    }
}
