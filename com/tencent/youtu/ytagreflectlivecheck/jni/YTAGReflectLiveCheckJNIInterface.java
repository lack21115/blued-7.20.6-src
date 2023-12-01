package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface.class */
public class YTAGReflectLiveCheckJNIInterface {
    public static int TIME_REGULATION_LOOSE = 1;
    public static int TIME_REGULATION_STRICT;
    private static YTAGReflectLiveCheckJNIInterface instance;
    private static Lock instanceLock = new ReentrantLock();
    private static IYtLoggerListener loggerListener;
    private long FRnativePtr;
    public Context context = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface$IYtLoggerListener.class */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    private YTAGReflectLiveCheckJNIInterface() {
        FRNativeConstructor();
    }

    public static native String Checksum(String str);

    public static native String FRGenConfigData(int i, String str);

    public static native String FRVersion();

    public static native void SetActStr(String str);

    public static native void SetPipelineVersion(String str);

    public static void clearInstance() {
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            try {
                synchronized (YTAGReflectLiveCheckJNIInterface.class) {
                    instanceLock.lock();
                    if (instance != null) {
                        instance.FRNativeDestructor();
                        instance = null;
                    }
                    instanceLock.unlock();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void compressTest(Bitmap bitmap, int i) {
        try {
            File file = new File("/sdcard/reflect/");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = "/sdcard/reflect/" + i + BridgeUtil.SPLIT_MARK;
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str, "mytestInJava_" + System.currentTimeMillis() + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static native void configNativeLog(boolean z);

    public static byte[] encodeJpeg(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] encodeJpeg(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static YTAGReflectLiveCheckJNIInterface getInstance() {
        YTAGReflectLiveCheckJNIInterface yTAGReflectLiveCheckJNIInterface;
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            try {
                synchronized (YTAGReflectLiveCheckJNIInterface.class) {
                    try {
                        instanceLock.lock();
                        if (instance == null) {
                            instance = new YTAGReflectLiveCheckJNIInterface();
                        }
                        instanceLock.unlock();
                        yTAGReflectLiveCheckJNIInterface = instance;
                    } catch (Throwable th) {
                        instanceLock.unlock();
                        throw th;
                    }
                }
                return yTAGReflectLiveCheckJNIInterface;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return yTAGReflectLiveCheckJNIInterface;
    }

    public static String modelVersion() {
        return "";
    }

    public static void nativeLog(int i, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTAGReflectLiveCheckJNIInterface.nativeLog]", str);
        }
    }

    public static void nativeLog(String str, String str2) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log(str, str2);
        }
    }

    public static String sdkVersion() {
        return "";
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static native int updateParam(String str, String str2);

    public native int FRDoDetectionYuvs(boolean z, int i);

    public native FullPack FRGetAGin();

    public native int FRGetChangePoint();

    public native int FRGetConfigBegin();

    public native int FRGetConfigEnd();

    public native int FRGetISOCaptureTimeVecSize();

    public native double FRGetISObackup();

    public native int FRGetISOchangeFrame();

    public native double FRGetISOmin();

    public native RawYuvData[] FRGetRawYuvDatas();

    public native int FRGetTriggerTime();

    public native int FRInit(boolean z, String str, int i, long[] jArr, float f);

    public native void FRNativeConstructor();

    public native void FRNativeDestructor();

    public native void FRPushCaptureTime(Timeval timeval);

    public native void FRPushISOCaptureTime(Timeval timeval);

    public native void FRPushISOImgYuv(byte[] bArr, int i, int i2);

    public native void FRPushYuv(byte[] bArr, int i, int i2, long j, int i3, float[] fArr);

    public native int FRRelease();

    public native void FRSetBegin(Timeval timeval);

    public native void FRSetChangePointTime(Timeval timeval);

    public native void FRSetDoingDelayCalc(boolean z);

    public native void FRSetEnd(Timeval timeval);

    public native void FRSetISObackup(double d);

    public native void FRSetISOchangeFrame(int i);

    public native void FRSetISOchangeTime(Timeval timeval);

    public native void FRSetSafetyLevel(int i);
}
