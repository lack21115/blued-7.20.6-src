package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.CountDownTimer;
import com.anythink.expressad.video.module.a.a.m;
import com.tencent.cloud.huiyansdkface.facelight.c.b.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.LiveStyleReq;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface.class */
public class YTAGReflectLiveCheckInterface {

    /* renamed from: a  reason: collision with root package name */
    public static com.tencent.cloud.huiyansdkface.facelight.process.c.a f26782a;
    private static b k;
    private static int l;
    private static CountDownTimer m;
    private static int p;
    private static Camera q;
    private static int r;
    private static String s;

    /* renamed from: c  reason: collision with root package name */
    private static final String f26783c = YTAGReflectLiveCheckInterface.class.getSimpleName();
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static int g = 3;
    private static int h = 4;
    private static int i = 0;
    private static Lock j = new ReentrantLock();
    public static String b = "";
    private static c n = null;
    private static a o = null;
    private static int t = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$a.class */
    public interface a {
        void a(int i, String str, String str2);

        void a(LiveStyleReq liveStyleReq);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$b.class */
    public interface b {
        float a();

        void a(int i, float f);

        void a(long j);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$c.class */
    public interface c {
        void a(int i, String str, String str2);

        void a(FullPack fullPack);
    }

    static /* synthetic */ int a() {
        int i2 = l;
        l = i2 + 1;
        return i2;
    }

    public static void cancel() {
        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[YTAGReflectLiveCheckInterface.cancel] --- ");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRRelease();
    }

    public static int getLiveCheckType(Context context, a aVar) {
        a aVar2;
        LiveStyleReq liveStyleReq;
        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
        int i2 = 1;
        if (aVar != null) {
            if (context == null) {
                aVar.a(1, "Input context is null.", "You can try to input getActivity().getApplicationContext() and test again.");
                i2 = 2;
            } else {
                if (o != null) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
                }
                o = aVar;
                l = 0;
                int a2 = com.tencent.cloud.huiyansdkface.facelight.c.b.c.a().a(context, new c.b() { // from class: com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.c.b
                    public void a(float f2) {
                        YTAGReflectLiveCheckInterface.a();
                        String str = YTAGReflectLiveCheckInterface.f26783c;
                        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + f2 + " mOnGetValueCount: " + YTAGReflectLiveCheckInterface.l);
                        if (YTAGReflectLiveCheckInterface.l > 1) {
                            String str2 = YTAGReflectLiveCheckInterface.f26783c;
                            YTAGReflectLiveCheckJNIInterface.nativeLog(str2, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onGetValue] get value: " + f2);
                            if (YTAGReflectLiveCheckInterface.m != null) {
                                YTAGReflectLiveCheckInterface.m.cancel();
                                CountDownTimer unused = YTAGReflectLiveCheckInterface.m = null;
                            }
                            if (YTAGReflectLiveCheckInterface.o != null) {
                                YTAGReflectLiveCheckInterface.o.a(new LiveStyleReq(f2, YTAGReflectLiveCheckInterface.b));
                                a unused2 = YTAGReflectLiveCheckInterface.o = null;
                            }
                            com.tencent.cloud.huiyansdkface.facelight.c.b.c.a().c();
                        }
                    }
                });
                if (a2 == 1) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
                    aVar2 = o;
                    if (aVar2 != null) {
                        liveStyleReq = new LiveStyleReq(-1.0f, b);
                        aVar2.a(liveStyleReq);
                        o = null;
                    }
                    i2 = 0;
                } else {
                    if (a2 != 0) {
                        aVar2 = o;
                        if (aVar2 != null) {
                            liveStyleReq = new LiveStyleReq(com.tencent.cloud.huiyansdkface.facelight.c.b.c.a().b(), b);
                            aVar2.a(liveStyleReq);
                            o = null;
                        }
                    } else {
                        CountDownTimer countDownTimer = new CountDownTimer(m.ag, m.ag) { // from class: com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.2
                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.f26783c, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
                                if (YTAGReflectLiveCheckInterface.o != null) {
                                    YTAGReflectLiveCheckInterface.o.a(new LiveStyleReq(-2.0f, YTAGReflectLiveCheckInterface.b));
                                    a unused = YTAGReflectLiveCheckInterface.o = null;
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onTick(long j2) {
                                YTAGReflectLiveCheckJNIInterface.nativeLog(YTAGReflectLiveCheckInterface.f26783c, "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
                            }
                        };
                        m = countDownTimer;
                        countDownTimer.start();
                    }
                    i2 = 0;
                }
            }
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: " + i2);
        return i2;
    }

    public static RawYuvData[] getRawYuvDatas() {
        return YTAGReflectLiveCheckJNIInterface.getInstance().FRGetRawYuvDatas();
    }

    public static b getReflectListener() {
        return k;
    }

    public static int initModel(String str) {
        int i2;
        synchronized (YTAGReflectLiveCheckInterface.class) {
            try {
                try {
                    j.lock();
                    if (i > 0) {
                        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "initModel repeated calls.");
                    } else {
                        b = str;
                        if (str == null) {
                            b = "";
                        }
                    }
                    i++;
                    j.unlock();
                    i2 = 0;
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception e2) {
                YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "initModel failed. message: " + e2.toString());
                e2.printStackTrace();
                KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_init_failed", "initYoutuReflectLiveness exception:" + e2.toString(), null);
                j.unlock();
                i2 = -1;
            }
        }
        return i2;
    }

    public static void onCameraChanged(int i2) {
        String str = f26783c;
        WLogger.d(str, "on Camera changed " + i2);
        try {
            Camera.Parameters parameters = q.getParameters();
            parameters.setExposureCompensation(i2);
            q.setParameters(parameters);
        } catch (Exception e2) {
            String str2 = f26783c;
            WLogger.e(str2, "on camera changed failed:" + e2.getLocalizedMessage());
        }
    }

    public static int[] onFetchCameraInfo() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Camera.Parameters parameters;
        try {
            try {
                parameters = q.getParameters();
                i2 = parameters.getExposureCompensation();
                try {
                    i4 = Integer.parseInt(parameters.get("iso"));
                    i2 = i4;
                } catch (Exception e2) {
                    String str = f26783c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("on fectch camera compoensation failed:");
                    sb.append(e2.getLocalizedMessage());
                    WLogger.e(str, sb.toString());
                }
                i4 = i2;
                i5 = parameters.getMinExposureCompensation();
            } catch (Exception e3) {
                e = e3;
                i2 = 0;
                i3 = 0;
                WLogger.e(f26783c, "on fectch camera info failed:" + e.getLocalizedMessage());
                i5 = i3;
                i6 = 0;
                WLogger.d(f26783c, "on fetch camera exp:" + i2 + " min:" + i5 + " max:" + i6);
                return new int[]{i2, i5, i6};
            }
            try {
                i6 = parameters.getMaxExposureCompensation();
            } catch (Exception e4) {
                e = e4;
                i3 = i5;
                WLogger.e(f26783c, "on fectch camera info failed:" + e.getLocalizedMessage());
                i5 = i3;
                i6 = 0;
                WLogger.d(f26783c, "on fetch camera exp:" + i2 + " min:" + i5 + " max:" + i6);
                return new int[]{i2, i5, i6};
            }
        } catch (Exception e5) {
            e = e5;
            i2 = i4;
            i3 = 0;
            WLogger.e(f26783c, "on fectch camera info failed:" + e.getLocalizedMessage());
            i5 = i3;
            i6 = 0;
            WLogger.d(f26783c, "on fetch camera exp:" + i2 + " min:" + i5 + " max:" + i6);
            return new int[]{i2, i5, i6};
        }
        WLogger.d(f26783c, "on fetch camera exp:" + i2 + " min:" + i5 + " max:" + i6);
        return new int[]{i2, i5, i6};
    }

    public static void onFinish() {
        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "on finished");
        int FRDoDetectionYuvs = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, r);
        String str = f26783c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "on finished " + FRDoDetectionYuvs);
        if (FRDoDetectionYuvs == 0) {
            n.a(YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin());
            return;
        }
        c cVar = n;
        cVar.a(FRDoDetectionYuvs, "JNI return failed", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + FRDoDetectionYuvs);
    }

    public static void onScreenChanged(int i2, int i3, int i4, int i5, float f2) {
        int argb = Color.argb(i2, i3, i4, i5);
        b bVar = k;
        if (bVar == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "On reflection screen change failed:mReflectListener is null");
        } else {
            bVar.a(argb, f2);
        }
    }

    public static void onStateChanged(int i2) {
        p = i2;
        String str = f26783c;
        WLogger.d(str, "on state changed call " + p);
        try {
            if (i2 == 0) {
                WLogger.d(f26783c, "onStateChanged:0 ");
                Camera.Parameters parameters = q.getParameters();
                parameters.setAutoWhiteBalanceLock(true);
                q.setParameters(parameters);
            } else if (i2 == 1) {
                WLogger.d(f26783c, "onStateChanged:1 ");
                if (f26782a != null) {
                    f26782a.a();
                }
            } else if (i2 == 2) {
                WLogger.d(f26783c, "onStateChanged:2 ");
                try {
                    Camera.Parameters parameters2 = q.getParameters();
                    parameters2.setAutoWhiteBalanceLock(false);
                    q.setParameters(parameters2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "light_state_change_2_cam_exception", e2.toString(), null);
                }
                onFinish();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            String str2 = f26783c;
            WLogger.e(str2, "on state changed:" + i2 + ",failed:" + e3.getLocalizedMessage());
        }
    }

    public static void pushImageData(byte[] bArr, int i2, int i3, long j2, int i4, float[] fArr, float f2, float f3, float f4) {
        WLogger.d(f26783c, "Light pushImageData");
        int i5 = p;
        if (i5 != 0) {
            if (i5 == 1) {
                YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[ReflectController.onPreviewFrameReceived] record ios");
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(bArr, i2, i3);
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(com.tencent.cloud.huiyansdkface.facelight.c.b.a(j2));
                return;
            }
            return;
        }
        int FRGetConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
        int FRGetConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 4;
        int FRGetTriggerTime = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
        String str = f26783c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "onPreviewFrameReceived. beginFrame: " + FRGetConfigBegin + " endFrame: " + FRGetConfigEnd + " currentFrame: " + FRGetTriggerTime);
        if (FRGetTriggerTime <= FRGetConfigBegin || FRGetTriggerTime >= FRGetConfigEnd) {
            return;
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "onPreviewFrameReceived. insertYuv and time");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(bArr, i2, i3, j2, i4, fArr);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(com.tencent.cloud.huiyansdkface.facelight.c.b.a(j2));
    }

    public static void releaseModel() {
        synchronized (YTAGReflectLiveCheckInterface.class) {
            try {
                WLogger.d(f26783c, "releaseModel");
                j.lock();
                int i2 = i - 1;
                i = i2;
                if (i2 <= 0) {
                    i = 0;
                    f26782a = null;
                    k = null;
                    if (m != null) {
                        m.cancel();
                        m = null;
                    }
                    o = null;
                    n = null;
                    q = null;
                }
                j.unlock();
                YTAGReflectLiveCheckJNIInterface.clearInstance();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setReflectListener(b bVar) {
        k = bVar;
    }

    public static void setReflectNotice(com.tencent.cloud.huiyansdkface.facelight.process.c.a aVar) {
        f26782a = aVar;
    }

    public static void setSafetyLevel(int i2) {
        String str = f26783c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str, "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: " + i2);
    }

    public static void setupConfig(String str, String str2) {
        if (str == "overlay_alpha") {
            try {
                t = Integer.parseInt(str2);
            } catch (NumberFormatException e2) {
                t = 0;
            }
        }
    }

    public static void start(Context context, Camera camera, int i2, String str, c cVar) {
        YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "[YTAGReflectLiveCheckInterface.start] ---");
        if (cVar == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "On reflection start failed:checkResult is null");
            return;
        }
        n = cVar;
        if (i <= 0) {
            cVar.a(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
            return;
        }
        r = i2;
        s = str;
        q = camera;
        long[] jArr = new long[2];
        if (k == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(f26783c, "On reflection start failed:mReflectListener is null");
        }
        b bVar = k;
        YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, str, 0, jArr, bVar != null ? bVar.a() : -1.0f);
        String str2 = f26783c;
        YTAGReflectLiveCheckJNIInterface.nativeLog(str2, "output duration ms" + jArr[0] + " " + jArr[1]);
        b bVar2 = k;
        if (bVar2 != null) {
            bVar2.a(jArr[0]);
        }
    }
}
