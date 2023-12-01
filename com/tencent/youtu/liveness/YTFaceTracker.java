package com.tencent.youtu.liveness;

import android.content.res.AssetManager;
import android.graphics.Rect;
import com.tencent.cloud.huiyansdkface.facelight.c.c.b;
import com.tencent.cloud.huiyansdkface.facelight.c.c.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/liveness/YTFaceTracker.class */
public class YTFaceTracker {
    private static IYtLoggerListener loggerListener;
    private long nativePtr;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/liveness/YTFaceTracker$IYtLoggerListener.class */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/liveness/YTFaceTracker$Param.class */
    public static class Param {
        public int biggerFaceMode;
        public int detInterval;
        public int maxFaceSize;
        public int minFaceSize;
        public boolean nonSquareRect;
        public float threshold;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/liveness/YTFaceTracker$TrackedFace.class */
    public static class TrackedFace {
        public Rect faceRect;
        public float[] faceShape;
        public float[] faceVisible;
        public int frameId;
        public float pitch;
        public float roll;
        public int traceId;
        public float yaw;
    }

    static {
        System.loadLibrary("YTLiveness");
    }

    public YTFaceTracker(AssetManager assetManager, String str, String str2) throws Exception {
        c.a().a("YTFaceTracker", "asset start NativeConstructor");
        long currentTimeMillis = System.currentTimeMillis();
        int NativeConstructor = NativeConstructor(assetManager, str, str2);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        b a2 = c.a();
        a2.a("YTFaceTracker", "asset end NativeConstructor:" + currentTimeMillis2);
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        kycWaSDK.trackCustomKVEvent(null, "facepage_model_init_yttrack", "asset NativeConstructor:" + currentTimeMillis2 + ",code:" + NativeConstructor, null);
        if (NativeConstructor == 0) {
            return;
        }
        throw new IllegalAccessException("error model dirpath and config filaneme: " + NativeConstructor);
    }

    public YTFaceTracker(String str, String str2) throws Exception {
        c.a().a("YTFaceTracker", "start NativeConstructor");
        long currentTimeMillis = System.currentTimeMillis();
        int NativeConstructor = NativeConstructor(str, str2);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        b a2 = c.a();
        a2.a("YTFaceTracker", "end NativeConstructor:" + currentTimeMillis2);
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        kycWaSDK.trackCustomKVEvent(null, "facepage_model_init_yttrack", "file:" + str + ",code:" + NativeConstructor + ",NativeConstructor:" + currentTimeMillis2, null);
        if (NativeConstructor == 0) {
            return;
        }
        throw new IllegalAccessException("error model dirpath and config filaneme: " + NativeConstructor);
    }

    private native int NativeConstructor(AssetManager assetManager, String str, String str2);

    private native int NativeConstructor(String str, String str2);

    private native void NativeDestructor();

    public static native String getVersion();

    public static void nativeLog(int i, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTFaceTracker.nativeLog]", str);
        }
    }

    public static native void setLoggerLevel(int i);

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public void destroy() {
        c.a().a("YTFaceTracker", "start NativeDestructor");
        long currentTimeMillis = System.currentTimeMillis();
        NativeDestructor();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        b a2 = c.a();
        a2.a("YTFaceTracker", "end NativeDestructor:" + currentTimeMillis2);
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        kycWaSDK.trackCustomKVEvent(null, "facepage_model_release_yttrack", currentTimeMillis2 + "ms", null);
    }

    protected void finalize() {
        NativeDestructor();
    }

    public native Param getParam();

    public native void reset();

    public native void setParam(Param param);

    public native TrackedFace[] track(int i, byte[] bArr, int i2, int i3, int i4, boolean z, byte[] bArr2) throws Exception;
}
