package com.tencent.cloud.huiyansdkface.facelight.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.expressad.video.module.a.a.m;
import com.baidu.mobads.sdk.internal.bw;
import com.sobot.chat.core.channel.Const;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.a.c.a.i;
import com.tencent.cloud.huiyansdkface.a.d.a;
import com.tencent.cloud.huiyansdkface.a.f;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbCusFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceWillModeResult;
import com.tencent.cloud.huiyansdkface.facelight.c.a.e;
import com.tencent.cloud.huiyansdkface.facelight.c.a.g;
import com.tencent.cloud.huiyansdkface.facelight.c.a.h;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.RotateSetting;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WbThreadFactory;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillContent;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CusRequestBody;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.b;
import com.tencent.cloud.huiyansdkface.facelight.process.b.c;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbWillVideoEncodeFinishCallback;
import com.tencent.cloud.huiyansdkface.facelight.ui.a.b;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.PreviewFrameLayout;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.PreviewMask;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.a;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.b;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.VideoEncoder;
import com.tencent.cloud.huiyansdkface.record.WbRecordFinishListener;
import com.tencent.cloud.huiyansdkface.record.WeMediaManager;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.open.SocialConstants;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/b/a.class */
public class a extends b implements com.tencent.cloud.huiyansdkface.facelight.process.b.a, com.tencent.cloud.huiyansdkface.facelight.process.b.b, c, com.tencent.cloud.huiyansdkface.facelight.ui.a.c, com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35687a = a.class.getSimpleName();
    private RelativeLayout A;
    private TextView B;
    private PreviewFrameLayout C;
    private HeadBorderView D;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a E;
    private boolean F;
    private boolean G;
    private File N;
    private String O;
    private String P;
    private int R;
    private com.tencent.cloud.huiyansdkface.a.g.c U;
    private com.tencent.cloud.huiyansdkface.a.c V;
    private f W;
    private com.tencent.cloud.huiyansdkface.a.a Y;
    private int Z;
    private SensorManager aB;
    private Sensor aC;
    private String aD;
    private int aE;
    private PreviewMask aF;
    private SelectData aG;
    private ReflectColorData aH;
    private Camera aI;
    private boolean aJ;
    private boolean aL;
    private boolean aM;
    private ByteArrayOutputStream aN;
    private VideoEncoder aO;
    private byte[][] aT;
    private float aU;
    private Context aV;
    private WbWillVideoEncodeFinishCallback aW;
    private float aZ;
    private int aa;
    private int ab;
    private int ac;
    private com.tencent.cloud.huiyansdkface.facelight.c.d.c ad;
    private e ae;
    private com.tencent.cloud.huiyansdkface.facelight.c.a.b af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private TextView aj;
    private TextView ak;
    private YTImageInfo am;
    private YTImageInfo an;
    private YTImageInfo ao;
    private ImageView ap;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aq;

    /* renamed from: ar  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a f35688ar;
    private CloudFaceCountDownTimer as;
    private CloudFaceCountDownTimer at;
    private CloudFaceCountDownTimer au;
    private CloudFaceCountDownTimer av;
    private CloudFaceCountDownTimer aw;
    private CloudFaceCountDownTimer ax;
    private CloudFaceCountDownTimer ay;
    private CloudFaceCountDownTimer az;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.c f35689c;
    private d d;
    private com.tencent.cloud.huiyansdkface.facelight.a.b.a e;
    private FaceVerifyStatus g;
    private com.tencent.cloud.huiyansdkface.facelight.process.e.a h;
    private com.tencent.cloud.huiyansdkface.facelight.process.a.a i;
    private com.tencent.cloud.huiyansdkface.facelight.process.a j;
    private com.tencent.cloud.huiyansdkface.facelight.c.d k;
    private boolean m;
    private SoundPool n;
    private int o;
    private View p;
    private View q;
    private View r;
    private TextView s;
    private TextView t;
    private TextView u;
    private RelativeLayout v;
    private TextView w;
    private ImageView x;
    private TextView y;
    private TextView z;
    private com.tencent.cloud.huiyansdkface.facelight.c.b.e b = new com.tencent.cloud.huiyansdkface.facelight.c.b.e(Const.SOCKET_CHECK_CHANNEL);
    private String f = "";
    private YTFaceTracker l = null;
    private String H = "";
    private String I = "";
    private String J = "";
    private String K = "";
    private String L = "";
    private String M = "";
    private String Q = "";
    private boolean S = false;
    private com.tencent.cloud.huiyansdkface.facelight.b.b T = new com.tencent.cloud.huiyansdkface.facelight.b.b();
    private int X = 0;
    private Properties al = new Properties();
    private boolean aA = false;
    private int aK = 0;
    private int aP = 0;
    private int aQ = 2097152;
    private int aR = 30;
    private int aS = 1;
    private ExecutorService aX = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfYtEncode"));
    private ExecutorService aY = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfWbRecord"));
    private SensorEventListener ba = new SensorEventListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.41
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str;
            String str2;
            if (sensorEvent == null) {
                str = a.f35687a;
                str2 = "light event is null";
            } else if (sensorEvent.sensor != null) {
                if (sensorEvent.sensor.getType() != 5) {
                    return;
                }
                float f = sensorEvent.values[0];
                float f2 = f;
                if (f > 100000.0f) {
                    f2 = 100000.0f;
                }
                a.this.aD = String.valueOf((int) f2);
                return;
            } else {
                str = a.f35687a;
                str2 = "light event.sensor is null";
            }
            WLogger.e(str, str2);
        }
    };

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.ui.b.a$22  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/b/a$22.class */
    class AnonymousClass22 extends CloudFaceCountDownTimer {
        AnonymousClass22(long j, long j2) {
            super(j, j2);
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
        public void onFinish() {
            WLogger.d(a.f35687a, "findface timeoutCdt end!");
            a.this.g.b(7);
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
        public void onTick(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.ui.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/b/a$a.class */
    public static final class C0915a implements SoundPool.OnLoadCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        private int f35769a;

        public C0915a(int i) {
            this.f35769a = i;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            WLogger.d(a.f35687a, "PlayVoice BEGIN");
            soundPool.play(this.f35769a, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    private boolean A() {
        WLogger.d(f35687a, "initYoutuTracker");
        String str = f35687a;
        WLogger.i(str, "YT Detect version:" + YTFaceTracker.getVersion());
        String str2 = f35687a;
        a(str2, "YT Detect version:" + YTFaceTracker.getVersion());
        YTFaceTracker.setLoggerLevel(2);
        YTFaceTracker.setLoggerListener(new YTFaceTracker.IYtLoggerListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.12
            @Override // com.tencent.youtu.liveness.YTFaceTracker.IYtLoggerListener
            public void log(String str3, String str4) {
                WLogger.d("sunny------", "tag-tracker--" + str4);
                a aVar = a.this;
                aVar.a("sunny------", "tag-tracker--" + str4);
            }
        });
        String t = this.e.t();
        try {
            if (TextUtils.isEmpty(t)) {
                WLogger.d(f35687a, "init from asset");
                a(f35687a, "init tracker from asset");
                this.l = new YTFaceTracker(this.aV.getAssets(), "models/face-tracker-v001", "yt_model_config.ini");
                return true;
            }
            String str3 = f35687a;
            WLogger.d(str3, "init from filesystem,YTModelLoc=" + t);
            String str4 = f35687a;
            a(str4, "init tracker from filesystem,YTModelLoc=" + t);
            this.l = new YTFaceTracker(t, "yt_model_config.ini");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            String str5 = f35687a;
            WLogger.e(str5, "initYoutu exception:" + e.toString());
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            Activity activity = getActivity();
            kycWaSDK.trackCustomKVEvent(activity, "facepage_model_init_failed", "YTFaceTracker exception:" + e.toString(), null);
            return false;
        }
    }

    private boolean B() {
        WLogger.d(f35687a, "initYoutuActionLiveness");
        int a2 = com.tencent.cloud.huiyansdkface.facelight.process.b.a();
        if (a2 != 0) {
            String str = f35687a;
            WLogger.e(str, "initYoutu ACTION exception:" + a2);
            return false;
        }
        YTPoseDetectJNIInterface.configNativeLog(this.e.O());
        YTPoseDetectJNIInterface.updateParam("log_level", "3");
        YTPoseDetectJNIInterface.setLoggerListener(new YTPoseDetectJNIInterface.IYtLoggerListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.23
            @Override // com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener
            public void log(String str2, String str3) {
                WLogger.d(str2, str3);
                a.this.a(str2, str3);
            }
        });
        String version = YTPoseDetectJNIInterface.getVersion();
        String str2 = f35687a;
        WLogger.i(str2, "YTPose Version: " + version);
        String str3 = f35687a;
        a(str3, "YTPose Version: " + version);
        return true;
    }

    private void C() {
        if (this.f.contains("3")) {
            WLogger.d(f35687a, "light live init");
            I();
            H();
        }
        if (this.e.S()) {
            return;
        }
        P();
    }

    private void D() {
        E();
        F();
        G();
        a(com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT);
        this.W = new f(com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT, this.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0362  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E() {
        /*
            Method dump skipped, instructions count: 912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.E():void");
    }

    private void F() {
        WLogger.d(f35687a, "init FaceDetect!");
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = new com.tencent.cloud.huiyansdkface.facelight.process.a(this.aV, this.l, new com.tencent.cloud.huiyansdkface.facelight.process.c.b() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.b
            public void a() {
                String str;
                String str2;
                if (a.this.g == null) {
                    str = a.f35687a;
                    str2 = "mFaceVerifyStatus is null,return";
                } else if (a.this.g.b() >= 6) {
                    str = a.f35687a;
                    str2 = "already in upload,no need reset";
                } else if (a.this.g.b() != 4 || a.this.g.d() != 3 || a.this.aE <= 1) {
                    WLogger.d(a.f35687a, "onDetectNoFace");
                    if (a.this.g.b() == 5) {
                        KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "willpage_detect_intermediate", null, null);
                        a.this.u.setVisibility(8);
                        a.this.t.setVisibility(0);
                        if (a.this.G) {
                            a.this.v.setVisibility(0);
                            a.this.w.setVisibility(0);
                        }
                        if (a.this.aW != null) {
                            a.this.aW = null;
                        }
                        WbFaceModeProviders.faceMode().stopWill(a.this.getChildFragmentManager());
                        a.this.d.b(false);
                    } else {
                        KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_detect_intermediate", null, null);
                    }
                    a.this.S();
                    a.this.g.b(2);
                    if (a.this.f.contains("3")) {
                        a.this.aF.b();
                        a.this.aF.setVisibility(8);
                        a.this.h(0);
                        a.this.ab();
                        if (WbCloudFaceContant.BLACK.equals(a.this.e.J()) && a.this.G) {
                            a.this.v.setBackgroundResource(R.drawable.wbcf_customer_long_tip_bg);
                            a.this.w.setTextColor(a.this.c(R.color.wbcf_guide_text_black));
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    str = a.f35687a;
                    str2 = "mState=" + a.this.aE + ",no need reset";
                }
                WLogger.d(str, str2);
            }
        });
        this.j = aVar;
        aVar.a(this.g);
        this.j.a(this);
    }

    private void G() {
        KycWaSDK kycWaSDK;
        Activity activity;
        String str;
        WLogger.d(f35687a, "初始化相机配置");
        if (this.d.e().B()) {
            WLogger.i(f35687a, "init turing preview");
            com.tencent.cloud.huiyansdkface.facelight.c.d.c a2 = com.tencent.cloud.huiyansdkface.facelight.c.d.d.a();
            this.ad = a2;
            e a3 = a2.a();
            this.ae = a3;
            if (a3 != null) {
                a3.a(this.ad);
            }
            this.U.a(this.ae);
            kycWaSDK = KycWaSDK.getInstance();
            activity = getActivity();
            str = "facepage_turing_preview";
        } else {
            WLogger.i(f35687a, "init system preview");
            this.U.a((com.tencent.cloud.huiyansdkface.a.g.a) null);
            kycWaSDK = KycWaSDK.getInstance();
            activity = getActivity();
            str = "facepage_system_preview";
        }
        kycWaSDK.trackCustomKVEvent(activity, str, null, null);
    }

    private void H() {
        boolean z;
        SensorManager sensorManager = (SensorManager) this.aV.getSystemService("sensor");
        this.aB = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.aC = defaultSensor;
        if (defaultSensor == null) {
            WLogger.e(f35687a, "this phone does not have light sensor!");
            z = false;
        } else {
            WLogger.d(f35687a, "this phone has light sensor!");
            z = true;
        }
        this.aA = z;
    }

    private void I() {
        WLogger.d(f35687a, "initFaceLive");
        YTAGReflectLiveCheckInterface.setReflectNotice(new com.tencent.cloud.huiyansdkface.facelight.process.c.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.11
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.a
            public void a() {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WLogger.d(a.f35687a, "onDelayCalc");
                        if (a.this.aE == 1) {
                            a.this.h(2);
                            a.this.ab();
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_reflect_delaycal", null, null);
                            return;
                        }
                        String str = a.f35687a;
                        WLogger.w(str, "curLightState：" + a.this.aE + ",cant switch to STATE_DETECT_DELAY");
                    }
                });
            }
        });
        YTAGReflectLiveCheckInterface.setReflectListener(new YTAGReflectLiveCheckInterface.b() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.13
            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.b
            public float a() {
                return a.this.R();
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.b
            public void a(final int i, float f) {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aF.setReflectColor(i);
                    }
                });
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.b
            public void a(long j) {
                String str = a.f35687a;
                WLogger.d(str, "on reflection start " + j);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_reflect_start", null, null);
            }
        });
        YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
        YTAGReflectLiveCheckJNIInterface.updateParam("log_level", "3");
        YTAGReflectLiveCheckJNIInterface.setLoggerListener(new YTAGReflectLiveCheckJNIInterface.IYtLoggerListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.14
            @Override // com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface.IYtLoggerListener
            public void log(String str, String str2) {
                WLogger.d("sunny------", "tag-AGReflect--" + str2);
                a aVar = a.this;
                aVar.a("sunny------", "tag-AGReflect--" + str2);
            }
        });
    }

    private void J() {
        h(1);
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.15
            @Override // java.lang.Runnable
            public void run() {
                a.this.K();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        String str = f35687a;
        WLogger.d(str, "startReflect：" + Thread.currentThread().getName());
        YTAGReflectLiveCheckInterface.cancel();
        j(-1);
        String M = this.e.M();
        String str2 = f35687a;
        WLogger.d(str2, "colorData=" + M);
        int i = this.d.i();
        String str3 = f35687a;
        WLogger.w(str3, "start count=" + i);
        if (i > 0) {
            String str4 = f35687a;
            WLogger.w(str4, "多次start:" + i);
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            Activity activity = getActivity();
            kycWaSDK.trackCustomKVEvent(activity, "facepage_reflect_duplicate_start", "count=" + i + ",record=" + this.d.m(), null);
            YTAGReflectLiveCheckInterface.cancel();
            this.d.l();
            this.d.p();
        }
        this.d.j();
        this.d.o();
        YTAGReflectLiveCheckInterface.start(getActivity(), this.aI, RotateSetting.getRotate(), M, new YTAGReflectLiveCheckInterface.c() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.16
            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.c
            public void a(int i2, String str5, String str6) {
                String str7 = a.f35687a;
                WLogger.w(str7, "YTAGReflectLiveCheckInterface onFailed!result=" + i2 + ",message=" + str5 + ",tips=" + str6);
                a.this.aH = null;
                KycWaSDK kycWaSDK2 = KycWaSDK.getInstance();
                Activity activity2 = a.this.getActivity();
                kycWaSDK2.trackCustomKVEvent(activity2, "facepage_light_error", i2 + ";" + str5, null);
                a.this.a(false, i2);
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.c
            public void a(FullPack fullPack) {
                WLogger.i(a.f35687a, "YTAGReflectLiveCheckInterface onSuccess!");
                a.this.aH = com.tencent.cloud.huiyansdkface.facelight.c.b.a(fullPack.AGin);
                a.this.a(true, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        WLogger.d(f35687a, "checkRecordFile");
        YTImageInfo yTImageInfo = this.am;
        if (yTImageInfo == null || TextUtils.isEmpty(yTImageInfo.image)) {
            WLogger.e(f35687a, "best image is null!");
            b(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeNoBestPic, d(R.string.wbcf_light_get_pic_failed), "PIC_FILE_IO_FAILED,best image is null!"));
            return;
        }
        WLogger.d(f35687a, "has liveImage");
        if (this.aL && this.aM) {
            byte[] videoByte = WeMediaManager.getInstance().getVideoByte();
            if (videoByte != null && videoByte.length != 0) {
                String str = f35687a;
                WLogger.d(str, "checkRecordFile wbVideoSize=" + (videoByte.length / 1024));
                if (videoByte.length < 50000) {
                    WLogger.e(f35687a, "wbVideo is too small! ");
                    if (!this.e.s()) {
                        d(true);
                        return;
                    }
                    b(-10, "wbVideo is too small!" + videoByte.length);
                    return;
                } else if (videoByte.length <= 3000000) {
                    d(false);
                    return;
                } else {
                    WLogger.e(f35687a, "REFLECTION MODE:The Record File Size is too big! ");
                    if (!this.e.s()) {
                        d(true);
                        return;
                    }
                    b(-10, "wbVideo is too big!" + videoByte.length);
                    return;
                }
            }
            WLogger.e(f35687a, "mCamera.getMediaFile is null!");
            if (this.e.s()) {
                b(-10, "wbVideo Path is null!");
                return;
            }
            WLogger.e(f35687a, "wbVideo is null, upload a null file");
        } else {
            WLogger.d(f35687a, "no need to upload wbVideo");
            if (this.aL) {
                WeMediaManager.getInstance().resetVideoByte();
            }
        }
        d(true);
    }

    private void M() {
        synchronized (this) {
            if (this.n != null && this.o > 0) {
                this.n.stop(this.o);
                this.n.release();
                this.n.setOnLoadCompleteListener(null);
                this.n = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        WLogger.d(f35687a, "showWillRetryTip");
        long as = this.d.e().as();
        if (this.az == null) {
            this.az = new CloudFaceCountDownTimer(as, as / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.26
                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onFinish() {
                    a.this.A.setVisibility(8);
                    a.this.B.setVisibility(8);
                    a.this.c(false);
                    a.this.g.b(2);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onTick(long j) {
                }
            };
            if (this.B.getVisibility() != 0) {
                WLogger.d(f35687a, "show willAnswerRetryTip.");
                this.A.setVisibility(0);
                this.B.setVisibility(0);
                this.az.start();
            }
        }
    }

    private void O() {
        if (this.aL) {
            String str = f35687a;
            WLogger.d(str, "start wbRecord:" + Thread.currentThread().getName());
            if (getActivity() != null) {
                if (WeMediaManager.getInstance().createMediaCodec(this.aV, this.X, u(), v())) {
                    WeMediaManager.getInstance().start(new WbRecordFinishListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.31
                        @Override // com.tencent.cloud.huiyansdkface.record.WbRecordFinishListener
                        public void onRecordFinish() {
                            String str2;
                            String str3;
                            WLogger.d(a.f35687a, "onWbRecordFinish");
                            a.this.g.c(true);
                            int d = a.this.g.d();
                            String str4 = a.f35687a;
                            WLogger.d(str4, "curLiveCheck=" + d);
                            if (a.this.f.equals("1") && d == 1) {
                                str3 = "=================end silentCheck======================";
                                if (a.this.d.e().x() && !YTPoseDetectJNIInterface.isRecordingDone()) {
                                    return;
                                }
                                str2 = a.f35687a;
                            } else if (!a.this.f.equals("2") || d != 2 || !a.this.g.i()) {
                                return;
                            } else {
                                str2 = a.f35687a;
                                str3 = "=================end actCheck======================";
                            }
                            WLogger.i(str2, str3);
                            a.this.g.j();
                        }
                    });
                } else {
                    WLogger.e(f35687a, "createMediaCodec failed, not record");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.h.a(this.F, aa(), new ProcessCallback<WbFaceWillRes>() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.32
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a */
            public void onSuccess(WbFaceWillRes wbFaceWillRes) {
                if (!WbFaceModeProviders.isUseWillSdk() || wbFaceWillRes == null) {
                    return;
                }
                a.this.H = wbFaceWillRes.willType;
                WbFaceWillContent wbFaceWillContent = wbFaceWillRes.content;
                a.this.I = wbFaceWillContent.question;
                a.this.J = wbFaceWillContent.answer;
                a.this.K = wbFaceWillContent.questionAudio;
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                a.this.a(wbFaceInnerError.desc, wbFaceInnerError.domain, wbFaceInnerError.code, wbFaceInnerError.reason);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        WLogger.d(f35687a, "finishActivity");
        if (getActivity() == null || getActivity().isFinishing()) {
            String str = f35687a;
            WLogger.d(str, "finishActivity:" + getActivity());
            return;
        }
        String str2 = f35687a;
        WLogger.d(str2, "finish activity StackTrace");
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float R() {
        if (getActivity() != null) {
            return getActivity().getWindow().getAttributes().screenBrightness;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        WLogger.d(f35687a, "clearState");
        T();
        if (this.z.getVisibility() != 8) {
            this.z.setVisibility(8);
        }
        if (this.A.getVisibility() != 8) {
            this.A.setVisibility(8);
        }
        if (this.B.getVisibility() != 8) {
            this.B.setVisibility(8);
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.ay;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.az;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.az = null;
        }
        M();
        if (this.aL) {
            WLogger.i(f35687a, "=================no face end record======================");
            WeMediaManager.getInstance().stop(false);
            WeMediaManager.getInstance().resetVideoByte();
        }
    }

    static /* synthetic */ int T(a aVar) {
        int i = aVar.R;
        aVar.R = i + 1;
        return i;
    }

    private void T() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.av;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.av = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.au;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.au = null;
        }
    }

    private void U() {
        if (this.aA) {
            WLogger.d(f35687a, "unregister light listener");
            try {
                this.aB.unregisterListener(this.ba);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void V() {
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.42
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i == 4) {
                    a.this.d("返回键：用户验证中取消");
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        WLogger.i(f35687a, "getBestPicAndVideo");
        com.tencent.cloud.huiyansdkface.facelight.process.b.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.e() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.43
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.e
            public void a(byte[][] bArr) {
                WLogger.d(a.f35687a, "onReceiveVideoDatas");
                a.this.aT = bArr;
                if (a.this.aT == null || a.this.aT.length == 0) {
                    WLogger.e(a.f35687a, "videoDatas is null!need Push backup data!");
                    a.this.j.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.d() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.43.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.d
                        public void a(YTActRefData yTActRefData) {
                            Param.appendBestImgInfo("1");
                            a.this.a(yTActRefData);
                        }
                    });
                    return;
                }
                String str = a.f35687a;
                WLogger.d(str, "list num: " + a.this.aT.length);
                Param.appendBestImgInfo("0");
                a.this.X();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        WLogger.i(f35687a, "getActReflectData");
        com.tencent.cloud.huiyansdkface.facelight.process.b.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.d() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.44
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.d
            public void a(YTActRefData yTActRefData) {
                WLogger.d(a.f35687a, "onReceiveBestImg");
                a.this.a(yTActRefData);
            }
        });
    }

    private void Y() {
        String str;
        String str2;
        WLogger.i(f35687a, "checkPicsAndVideos");
        if (!this.d.u()) {
            WLogger.d(f35687a, "not record ytVideo,upload wbVideo");
            this.aM = true;
            L();
            return;
        }
        byte[][] bArr = this.aT;
        if (bArr == null) {
            str = f35687a;
            str2 = "ytVideo is null,upload wbVideo";
        } else if (bArr == null || i(bArr.length)) {
            this.aX.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.46
                @Override // java.lang.Runnable
                public void run() {
                    WLogger.d(a.f35687a, "start encode");
                    a.this.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.c() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.46.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.c
                        public void a() {
                            WLogger.d(a.f35687a, "onEncodeFinish");
                            a.this.b(false);
                        }
                    });
                }
            });
            WLogger.d(f35687a, "start encode ctd");
            long Z = d.z().e().Z();
            String str3 = f35687a;
            WLogger.d(str3, "encodeTime=" + Z);
            this.ax = new CloudFaceCountDownTimer(Z, Z / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.47
                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onFinish() {
                    WLogger.d(a.f35687a, "upload cdt onFinish!");
                    a.this.b(true);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onTick(long j) {
                }
            }.start();
            return;
        } else {
            str = f35687a;
            str2 = "ytVideo not satisfied,upload wbVideo";
        }
        WLogger.d(str, str2);
        this.aM = true;
        L();
    }

    private void Z() {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.50
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT);
                a.this.W.a(a.this.V, new f.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.50.1
                    @Override // com.tencent.cloud.huiyansdkface.a.f.a
                    public void a() {
                        WLogger.i(a.f35687a, "switchCamera onFinish");
                        KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "camera_switch_finished", null, null);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String str2 = f35687a;
        WLogger.i(str2, "checkIsNeedRetryCam：" + i + "," + str);
        if (this.d.e().E()) {
            WLogger.i(f35687a, "Need Retry Cam");
            if (!this.aJ) {
                WLogger.i(f35687a, "first Retry Cam");
                this.aJ = true;
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_has_retry", null, null);
                Z();
                return;
            }
            WLogger.i(f35687a, "Already Retried!");
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_retry_failed", null, null);
        } else {
            WLogger.i(f35687a, "No Need to Retry Cam");
        }
        b(i, str);
    }

    private void a(int i, String str, String str2, String str3) {
        if (i > 1) {
            String str4 = f35687a;
            WLogger.e(str4, "encry Exception count=" + i + ",too many times，need alert");
            c(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, str, str2, str3));
            return;
        }
        String str5 = f35687a;
        WLogger.d(str5, "encry Exception count=" + i + ",try again");
        g(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera camera, int i) {
        this.aI = camera;
        if ("M5".equals(Param.getDeviceModel())) {
            int rotation = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
            int i2 = 0;
            if (rotation != 0) {
                i2 = rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90;
            }
            this.ab = 1;
            camera.setDisplayOrientation((360 - ((i + i2) % 360)) % 360);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        String str = f35687a;
        WLogger.d(str, "initCamera：" + aVar);
        com.tencent.cloud.huiyansdkface.a.e.d dVar = new com.tencent.cloud.huiyansdkface.a.e.d() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.4
            @Override // com.tencent.cloud.huiyansdkface.a.e.d
            public void a(final com.tencent.cloud.huiyansdkface.a.e.a aVar2) {
                aVar2.a();
                a.this.a(aVar2);
                if (a.this.aL) {
                    a.this.aY.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WeMediaManager.getInstance().onPreviewFrame(aVar2.c());
                        }
                    });
                }
                if (a.this.d.e().B() && a.this.ad.b()) {
                    a.this.ad.a(aVar2.c());
                }
            }
        };
        WLogger.d(f35687a, "init CameraErrorCallback");
        com.tencent.cloud.huiyansdkface.a.d a2 = new com.tencent.cloud.huiyansdkface.a.d(this.aV).a(aVar).a(this.U).a(new com.tencent.cloud.huiyansdkface.facelight.c.a.a().a()).a(com.tencent.cloud.huiyansdkface.facelight.b.a.f35532a).a(new com.tencent.cloud.huiyansdkface.a.b.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.5
            @Override // com.tencent.cloud.huiyansdkface.a.b.a
            public void a(com.tencent.cloud.huiyansdkface.a.b.c cVar) {
                a aVar2;
                int i;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("code=");
                stringBuffer.append(cVar.b());
                stringBuffer.append(";msg=");
                stringBuffer.append(cVar.d());
                stringBuffer.append(";cause=");
                stringBuffer.append(cVar.getCause());
                stringBuffer.append(";trace=");
                stringBuffer.append(com.tencent.cloud.huiyansdkface.facelight.c.f.a(cVar));
                int b = cVar.b();
                if (b != 1) {
                    if (b == 3) {
                        aVar2 = a.this;
                        i = -2;
                        aVar2.a(i, stringBuffer.toString());
                    } else if (b != 11 && b != 21) {
                        cVar.printStackTrace();
                        KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "camera_sdk_exception", stringBuffer.toString(), null);
                        return;
                    }
                }
                aVar2 = a.this;
                i = -1;
                aVar2.a(i, stringBuffer.toString());
            }
        }).a(com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_CENTER).b(com.tencent.cloud.huiyansdkface.a.a.b.b.a(new h(), new com.tencent.cloud.huiyansdkface.facelight.c.a.d())).c(com.tencent.cloud.huiyansdkface.a.a.b.b.a(new g(), new com.tencent.cloud.huiyansdkface.facelight.c.a.f())).a(com.tencent.cloud.huiyansdkface.a.a.b.b.a(new com.tencent.cloud.huiyansdkface.facelight.c.a.c(getActivity()), com.tencent.cloud.huiyansdkface.a.a.b.c.e())).a(dVar).a(new i() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.6
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, com.tencent.cloud.huiyansdkface.a.c.a.a aVar2) {
                parameters.setPreviewFormat(17);
            }
        });
        if (Build.VERSION.SDK_INT < 21) {
            WLogger.d(f35687a, "cam use main handler");
            a2.a(true);
        }
        this.V = a2.a();
        WLogger.d(f35687a, "初始化并注册相机适配器");
        this.Y = new com.tencent.cloud.huiyansdkface.a.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.7
            private Camera b;

            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a() {
                super.a();
                WLogger.d(a.f35687a, "camera closed!");
            }

            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2) {
                super.a(aVar2);
                WLogger.i(a.f35687a, "cam start preview");
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.d.e().v()) {
                            WLogger.i(a.f35687a, "setCurrentStep(FaceVerifyStatus.Status.FINDFACE)");
                            a.this.g.b(2);
                        }
                        a.this.s.setVisibility(0);
                        a.this.t.setVisibility(0);
                        a.this.y();
                    }
                });
                a.this.T.a(0);
                a.this.T.a(bw.o);
                a aVar3 = a.this;
                aVar3.a(aVar3.T);
                if (a.this.d.e().B()) {
                    com.tencent.cloud.huiyansdkface.facelight.c.d.c cVar = a.this.ad;
                    Camera camera = this.b;
                    cVar.a(camera, Param.getAppId() + Param.getOrderNo());
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2, com.tencent.cloud.huiyansdkface.a.c.d dVar2, com.tencent.cloud.huiyansdkface.a.a.a aVar3) {
                super.a(aVar2, dVar2, aVar3);
                String str2 = a.f35687a;
                WLogger.d(str2, "cameraOpened ,previewSize=" + aVar3.a().toString());
                a.this.Z = aVar3.a().a();
                a.this.aa = aVar3.a().b();
                com.tencent.cloud.huiyansdkface.a.c.a.a aVar4 = (com.tencent.cloud.huiyansdkface.a.c.a.a) dVar2;
                this.b = aVar4.a();
                a.this.X = aVar4.f();
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(a.this.X, cameraInfo);
                a.this.ab = cameraInfo.facing;
                a.this.ac = cameraInfo.orientation;
                String str3 = a.f35687a;
                WLogger.d(str3, "cameraInfo.orientation =" + cameraInfo.orientation);
                a.this.a(aVar4.a(), a.this.ac);
                RotateSetting.calRotateTag(a.this.aV, a.this.X, cameraInfo.facing);
                int rotate = RotateSetting.getRotate();
                String str4 = a.f35687a;
                WLogger.d(str4, "cameraOpened ,rotate=" + rotate);
                RotateSetting.setRotateInfo(rotate);
                a.this.f(rotate);
                if (a.this.d.u()) {
                    WLogger.i(a.f35687a, "upload ytVideo");
                    a.this.a(RotateSetting.getRotate(), a.this.Z, a.this.aa, 1);
                } else {
                    WLogger.d(a.f35687a, "cdn set no ytVideo,need wbVideo");
                    a.this.aM = true;
                }
                a.this.af.a(a.this.Z, a.this.aa, RotateSetting.getRotate());
                WLogger.d(a.f35687a, "start set previewSize");
                if (rotate >= 5) {
                    a.this.j.a(a.this.aa, a.this.Z, 0);
                } else {
                    a.this.j.a(a.this.Z, a.this.aa, 1);
                }
                a.this.s();
            }
        };
        WLogger.d(f35687a, " mWeCamera.registerCameraListener");
        this.V.a((com.tencent.cloud.huiyansdkface.a.b) this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.cloud.huiyansdkface.a.e.a aVar) {
        if (this.g.b() < 6) {
            this.af.a(aVar);
        }
        if (this.g.b() == 0) {
            WLogger.e(f35687a, "faceVerifyStatus current status not init!");
            return;
        }
        if (this.g.b() == 2 || this.g.b() == 3 || this.g.b() == 4 || this.g.b() == 5) {
            if (this.g.b() == 5) {
                WbFaceModeProviders.faceMode().onPreviewFrame(aVar.c());
            }
            if (this.g.b() == 4 && this.g.d() == 3 && this.g.e() > 1) {
                return;
            }
            this.j.a(aVar.c(), u(), v());
        }
        if (this.g.b() == 6 || (this.aE == 2 && !WbFaceModeProviders.isUseWillSdk())) {
            a(aVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceWillResult faceWillResult) {
        if (this.d.t()) {
            return;
        }
        WLogger.d(f35687a, "successToResultPage");
        WbFaceWillModeResult wbFaceWillModeResult = null;
        this.d.a(getActivity(), "0", (Properties) null);
        boolean z = getActivity() == null || getActivity().isFinishing();
        WLogger.d(f35687a, "successToResultPage Activity is die?" + z);
        this.d.e(true);
        if (this.d.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(true);
            wbFaceVerifyResult.setOrderNo(this.d.w());
            wbFaceVerifyResult.setSign(faceWillResult.sign);
            wbFaceVerifyResult.setRiskInfo(faceWillResult.riskInfo);
            wbFaceVerifyResult.setLiveRate(faceWillResult.liveRate);
            wbFaceVerifyResult.setSimilarity(faceWillResult.similarity);
            if (this.d.e().w()) {
                wbFaceVerifyResult.setUserImageString(this.am.image);
            }
            wbFaceVerifyResult.setError(null);
            if (WbFaceModeProviders.isUseWillSdk()) {
                WbFaceWillModeResult wbFaceWillModeResult2 = faceWillResult.toWbFaceWillModeResult();
                wbFaceWillModeResult = wbFaceWillModeResult2;
                if (this.e.o()) {
                    wbFaceWillModeResult2.setVideoPath(this.Q);
                    wbFaceWillModeResult = wbFaceWillModeResult2;
                }
            }
            wbFaceVerifyResult.setWillResult(wbFaceWillModeResult);
            this.d.y().onFinish(wbFaceVerifyResult);
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final WbFaceInnerError wbFaceInnerError) {
        com.tencent.cloud.huiyansdkface.facelight.a.a.b e = this.d.e();
        String b = WbFaceError.WBFaceErrorCodeWillNoVoiceError.equals(wbFaceInnerError.code) ? e.b() : WbFaceError.WBFaceErrorCodeWillLowPlayVolumeError.equals(wbFaceInnerError.code) ? e.a() : "";
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.E;
        if (aVar != null) {
            aVar.dismiss();
            this.E = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.aq;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.aq = null;
        }
        if (this.f35688ar == null) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(getActivity()).a(b).c(this.d.f().kyc_try_again).d(this.d.f().kyc_cancel);
            this.f35688ar = d;
            d.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
            this.f35688ar.a(new a.InterfaceC0916a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.27
                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0916a
                public void a() {
                    WLogger.d(a.f35687a, "restart will");
                    a.this.g.b(2);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0916a
                public void b() {
                    a.this.c(wbFaceInnerError);
                }
            });
        }
        this.f35688ar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YTActRefData yTActRefData) {
        WLogger.i(f35687a, "getBestPics");
        if (yTActRefData == null || yTActRefData.isEmpty()) {
            WLogger.e(f35687a, "return ActReflectData is null empty!");
        } else {
            WLogger.d(f35687a, "getActReflectData!");
            com.tencent.cloud.huiyansdkface.facelight.b.a.a aVar = new com.tencent.cloud.huiyansdkface.facelight.b.a.a(yTActRefData.best.image, yTActRefData.best.xys, yTActRefData.best.checksum);
            com.tencent.cloud.huiyansdkface.facelight.b.a.a aVar2 = new com.tencent.cloud.huiyansdkface.facelight.b.a.a(yTActRefData.eye.image, yTActRefData.eye.xys, yTActRefData.eye.checksum);
            com.tencent.cloud.huiyansdkface.facelight.b.a.a aVar3 = new com.tencent.cloud.huiyansdkface.facelight.b.a.a(yTActRefData.mouth.image, yTActRefData.mouth.xys, yTActRefData.mouth.checksum);
            this.am = new YTImageInfo(aVar);
            this.an = new YTImageInfo(aVar2);
            this.ao = new YTImageInfo(aVar3);
        }
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().b(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3, final String str4) {
        this.g.b(9);
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.37
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.getActivity() == null) {
                    return;
                }
                if (a.this.aq == null) {
                    if (a.this.E != null) {
                        a.this.E.dismiss();
                        a.this.E = null;
                    }
                    if (a.this.f35688ar != null) {
                        a.this.f35688ar.dismiss();
                        a.this.f35688ar = null;
                    }
                    a.this.aq = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(a.this.getActivity()).a(a.this.d.f().kyc_internet_error).b(str).c(a.this.d.f().kyc_try_again).d(a.this.d.f().kyc_no_more);
                    a.this.aq.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
                    a.this.aq.a(new a.InterfaceC0916a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.37.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0916a
                        public void a() {
                            WLogger.d(a.f35687a, "click try again");
                            if (a.this.aq != null) {
                                a.this.aq.dismiss();
                            }
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_get_flash_res_retry", null, null);
                            a.this.F = true;
                            a.this.g.b(2);
                            a.this.P();
                        }

                        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0916a
                        public void b() {
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_get_flash_res_quit", null, null);
                            a.this.b(str2, str3, str, str4);
                        }
                    });
                }
                if (a.this.getActivity() == null || a.this.getActivity().isFinishing()) {
                    return;
                }
                WLogger.d(a.f35687a, "mDialog.show()");
                a.this.aq.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final int i) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.17
            @Override // java.lang.Runnable
            public void run() {
                WLogger.i(a.f35687a, "onReflectEnd");
                a.this.h(3);
                a.this.aF.setVisibility(8);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_reflect_end", null, null);
                if (!z) {
                    Param.appendLightLocalInfo(i);
                }
                WLogger.d(a.f35687a, "onReflectEnd go to upload");
                a.this.g.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final FaceWillResult faceWillResult, final WbFaceInnerError wbFaceInnerError) {
        String str = f35687a;
        WLogger.d(str, "endLoading:" + z);
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.E;
        if (aVar != null) {
            aVar.dismiss();
            this.E = null;
        }
        this.y.setVisibility(8);
        this.C.b().a(50, new b.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.39
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.a
            public void a() {
                if (z) {
                    a.this.a(faceWillResult);
                } else {
                    a.this.c(wbFaceInnerError);
                }
            }
        });
    }

    private void a(byte[] bArr) {
        if (this.ag) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            b(bArr);
        } else {
            WLogger.e(f35687a, "android version is below 17! CANT BLUR!");
        }
        this.ag = true;
    }

    private String aa() {
        if (TextUtils.isEmpty(this.aD) || this.aD.equals("0")) {
            WLogger.w(f35687a, "lightDiffLux is null/zero! set default value!");
            return String.valueOf(this.d.e().I());
        }
        return this.aD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        TextView textView;
        int i;
        if (WbCloudFaceContant.BLACK.equals(this.e.J())) {
            this.s.setTextColor(c(R.color.wbcf_white));
            textView = this.t;
            i = R.color.wbcf_guide_text_black;
        } else if (WbCloudFaceContant.WHITE.equals(this.e.J())) {
            this.s.setTextColor(c(R.color.wbcf_black_text));
            textView = this.t;
            i = R.color.wbcf_guide_text;
        } else if (!"custom".equals(this.e.J())) {
            return;
        } else {
            this.s.setTextColor(c(R.color.wbcf_custom_tips_text));
            textView = this.t;
            i = R.color.wbcf_custom_customer_tip_text;
        }
        textView.setTextColor(c(i));
    }

    private void ac() {
        if (this.aL) {
            WeMediaManager.getInstance().stop(true);
        }
        T();
        M();
        if (this.f.contains("3")) {
            this.aF.setVisibility(8);
        }
        this.t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad() {
        this.u.setVisibility(8);
        onUpdateLongTipVisibility(0);
        this.t.setVisibility(0);
        this.t.setText(d.z().x().v());
    }

    private void ae() {
        this.aW = (WbFaceModeProviders.isUseWillSdk() && this.e.o()) ? new WbWillVideoEncodeFinishCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.51
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillVideoEncodeFinishCallback
            public void onEncodingComplete(final File file) {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.51.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.g.b() == 9) {
                            WLogger.d(a.f35687a, "already finished!return!");
                            return;
                        }
                        a.this.N = file;
                        WLogger.d(a.f35687a, "willVideo encode Ready to NEXT");
                        a.this.ag();
                    }
                });
            }
        } : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af() {
        String str;
        boolean z;
        WLogger.i(f35687a, WbCloudFaceContant.CHECK_WILL_VIDEO);
        if (this.N == null) {
            WLogger.d(f35687a, "will video is null！");
            if (WbFaceModeProviders.isUseWillSdk() && this.e.o() && this.e.p()) {
                str = "willVideo is null!";
                b(-10, str);
            }
            W();
        } else if (this.e.p() && this.N.length() < 50000) {
            WLogger.e(f35687a, "willVideo is too small! ");
            str = "willVideo is too small!" + this.N.length();
            b(-10, str);
        } else {
            if (this.e.r()) {
                this.Q = this.N.getAbsolutePath();
                WLogger.i(f35687a, "willVideoPath=" + this.Q);
                WLogger.d(f35687a, "upload will video!");
                z = true;
            } else if (!this.e.d()) {
                this.Q = this.N.getAbsolutePath();
                WLogger.i(f35687a, "willVideoPath=" + this.Q);
                W();
            } else {
                WLogger.d(f35687a, "just upload will video!");
                z = false;
            }
            h(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag() {
        if (this.k == null) {
            return;
        }
        String str = f35687a;
        WLogger.d(str, "readyToNext:" + this.k.a());
        this.k.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.53
            @Override // java.lang.Runnable
            public void run() {
                WLogger.d(a.f35687a, "Ready Go！");
                a.this.af();
            }
        });
    }

    private void b(float f) {
        WLogger.d(f35687a, "setAppBrightness brightness=" + f);
        if (getActivity() != null) {
            Window window = getActivity().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (f == -1.0f) {
                attributes.screenBrightness = -1.0f;
            } else {
                float f2 = f;
                if (f <= 0.0f) {
                    f2 = 1.0f;
                }
                attributes.screenBrightness = f2 / 255.0f;
            }
            window.setAttributes(attributes);
        }
    }

    private void b(int i, String str) {
        WLogger.i(f35687a, "processErrorMessage");
        this.T.a(i);
        this.T.a(str);
        WLogger.e(f35687a, str);
        a(this.T);
    }

    private void b(final WbFaceInnerError wbFaceInnerError) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.38
            @Override // java.lang.Runnable
            public void run() {
                a.this.g.b(9);
                WLogger.d(a.f35687a, "camera fail, need trans thread");
                a.this.c(wbFaceInnerError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        String str5 = f35687a;
        WLogger.d(str5, "setCallbackAndFinished:" + str2 + "," + str4);
        this.g.b(9);
        this.d.e(true);
        if (this.d.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.d.w());
            wbFaceVerifyResult.setSign(null);
            wbFaceVerifyResult.setRiskInfo(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(str);
            wbFaceError.setCode(str2);
            wbFaceError.setDesc(str3);
            wbFaceError.setReason(str4);
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.d.a(getActivity(), str2, properties);
            this.d.y().onFinish(wbFaceVerifyResult);
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.aq;
        if (aVar != null) {
            aVar.dismiss();
            this.aq = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.E = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar3 = this.f35688ar;
        if (aVar3 != null) {
            aVar3.dismiss();
            this.f35688ar = null;
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z) {
        WLogger.d(f35687a, "checkEncodeFinished");
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.20
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (a.this.ah) {
                    return;
                }
                if (a.this.g == null || a.this.g.b() != 6) {
                    if (a.this.g == null) {
                        str = "mFaceVerifyStatus is NULL!";
                    } else {
                        str = "mFaceVerifyStatus.getCurStatus()=" + a.this.g.b();
                    }
                    WLogger.w(a.f35687a, str);
                    return;
                }
                WLogger.d(a.f35687a, "mFaceVerifyStatus.getCurStatus()=" + a.this.g.b());
                if (z) {
                    WLogger.d(a.f35687a, "onEncodeFinish timeout!");
                    a aVar = a.this;
                    if (!aVar.i(aVar.aP)) {
                        a.this.a(false);
                        a.this.ah = true;
                        a.this.L();
                    }
                }
                a.this.a(true);
                a.this.ah = true;
                a.this.L();
            }
        });
    }

    private void b(byte[] bArr) {
        String str;
        String str2;
        WLogger.d(f35687a, "showLastPic");
        byte[] rawCamDataToJpg = RotateSetting.rawCamDataToJpg(RotateSetting.getRotate(), bArr, this.Z, this.aa, true);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(rawCamDataToJpg, 0, rawCamDataToJpg.length);
        if (decodeByteArray != null) {
            Bitmap a2 = com.tencent.cloud.huiyansdkface.facelight.c.b.a.a(getActivity(), decodeByteArray);
            if (a2 != null) {
                a(a2);
                return;
            } else {
                str = f35687a;
                str2 = "showLastPic blur is null";
            }
        } else {
            str = f35687a;
            str2 = "onPreviewFrame bitmap is null";
        }
        WLogger.e(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(WbFaceInnerError wbFaceInnerError) {
        if (this.d.t()) {
            return;
        }
        WLogger.d(f35687a, "failToResultPage goToResultPage");
        this.g.b(9);
        Properties properties = new Properties();
        properties.setProperty("errorDesc", wbFaceInnerError.toString());
        this.d.a(getActivity(), wbFaceInnerError.code, properties);
        boolean z = false;
        if (this.e.l()) {
            this.d.e(true);
            if (this.d.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setError(wbFaceInnerError.toWbFaceError());
                this.d.y().onFinish(wbFaceVerifyResult);
            }
        } else {
            if (getActivity() == null || getActivity().isFinishing()) {
                z = true;
            }
            WLogger.d(f35687a, "failToResultPage Activity is die?" + z);
            this.d.e(true);
            if (this.d.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult2 = wbFaceInnerError.toWbFaceVerifyResult();
                wbFaceVerifyResult2.setOrderNo(this.d.w());
                WbFaceWillModeResult wbFaceWillModeResult = null;
                if (WbFaceModeProviders.isUseWillSdk()) {
                    WbFaceWillModeResult willResult = wbFaceVerifyResult2.getWillResult();
                    wbFaceWillModeResult = willResult;
                    if (this.e.o()) {
                        willResult.setVideoPath(this.Q);
                        wbFaceWillModeResult = willResult;
                    }
                }
                wbFaceVerifyResult2.setWillResult(wbFaceWillModeResult);
                this.d.y().onFinish(wbFaceVerifyResult2);
            }
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.aW != null) {
            this.aW = null;
        }
        WbFaceModeProviders.faceMode().stopWill(getChildFragmentManager());
        this.d.b(false);
        ad();
        S();
        if (z) {
            this.g.b(9);
        }
    }

    private boolean c(String str) {
        String str2 = f35687a;
        WLogger.d(str2, "initYoutuReflectLiveness:" + YTAGReflectLiveCheckJNIInterface.FRVersion());
        int initModel = YTAGReflectLiveCheckInterface.initModel(str);
        if (initModel != 0) {
            String str3 = f35687a;
            WLogger.e(str3, "failed to init reflect sdk " + initModel);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        KycWaSDK kycWaSDK;
        Activity activity;
        String str2;
        if (getActivity() != null) {
            if (this.E == null) {
                String A = this.e.A();
                String B = this.e.B();
                String C = this.e.C();
                String D = this.e.D();
                String str3 = A;
                if (TextUtils.isEmpty(A)) {
                    String l = this.d.e().l();
                    str3 = l;
                    if (l == null) {
                        str3 = this.d.f().kyc_confirm_exit;
                    }
                }
                String str4 = B;
                if (TextUtils.isEmpty(B)) {
                    String m = this.d.e().m();
                    str4 = m;
                    if (m == null) {
                        str4 = this.d.f().kyc_waiting;
                    }
                }
                String str5 = C;
                if (TextUtils.isEmpty(C)) {
                    String n = this.d.e().n();
                    str5 = n;
                    if (n == null) {
                        str5 = this.d.f().kyc_make_sure;
                    }
                }
                String str6 = D;
                if (TextUtils.isEmpty(D)) {
                    String o = this.d.e().o();
                    str6 = o;
                    if (o == null) {
                        str6 = this.d.f().kyc_cancel;
                    }
                }
                com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(getActivity(), d.z().e().u()).a(str3).b(str4).c(str5).d(str6);
                this.E = d;
                d.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
            }
            this.E.a(new a.InterfaceC0916a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.40
                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0916a
                public void a() {
                    KycWaSDK kycWaSDK2;
                    Activity activity2;
                    String str7;
                    String str8;
                    if (a.this.f.contains("3")) {
                        a.this.aF.b();
                    }
                    if (a.this.g.b() == 6) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str7 = str;
                        str8 = "uploadpage_exit_self";
                    } else if (a.this.g.b() != 5) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str7 = str;
                        str8 = "facepage_exit_self";
                    } else if (a.this.d.d()) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str7 = str;
                        str8 = "willpage_answer_exit_self";
                    } else {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str7 = str;
                        str8 = "willpage_exit_self";
                    }
                    kycWaSDK2.trackCustomKVEvent(activity2, str8, str7, null);
                    a.this.b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeUserCancle, "用户取消", str);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0916a
                public void b() {
                    KycWaSDK kycWaSDK2;
                    Activity activity2;
                    String str7;
                    if (a.this.g.b() == 5) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str7 = "willpage_exit_comfirm_cancel";
                    } else {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str7 = "facepage_exit_comfirm_cancel";
                    }
                    kycWaSDK2.trackCustomKVEvent(activity2, str7, null, null);
                    if (a.this.E != null) {
                        a.this.E.dismiss();
                    }
                }
            });
            if (getActivity() == null || getActivity().isFinishing()) {
                return;
            }
            this.E.show();
            if (this.g.b() == 5) {
                kycWaSDK = KycWaSDK.getInstance();
                activity = getActivity();
                str2 = "willpage_exit_comfirm_show";
            } else {
                kycWaSDK = KycWaSDK.getInstance();
                activity = getActivity();
                str2 = "facepage_exit_comfirm_show";
            }
            kycWaSDK.trackCustomKVEvent(activity, str2, null, null);
        }
    }

    private void d(boolean z) {
        if (this.g.b() == 9) {
            WLogger.d(f35687a, "On finish Step,No more works!");
            return;
        }
        WLogger.d(f35687a, "startFaceUpload!");
        this.d.a(true);
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "uploadpage_enter", null, null);
        if (this.e.l()) {
            WLogger.d(f35687a, "simple sdk mode wrap");
            g(z);
        } else if (!this.e.S()) {
            f(z);
        } else {
            WLogger.d(f35687a, "cus sdk mode wrap");
            e(z);
        }
    }

    private void e(String str) {
        ab();
        this.s.setText(str);
    }

    private void e(boolean z) {
        String str;
        WLogger.d(f35687a, "startCusEncryAndReturn");
        String t = this.d.e().t();
        this.aG = new SelectData(Float.valueOf(aa()).floatValue());
        String str2 = f35687a;
        WLogger.d(str2, "selectData=" + this.aG.toString());
        FlashReq flashReq = new FlashReq();
        flashReq.colorData = this.e.M();
        flashReq.liveSelectData = this.aG;
        flashReq.reflectData = this.aH;
        flashReq.liveImage = this.am;
        flashReq.eyeImage = this.an;
        flashReq.mouthImage = this.ao;
        CusRequestBody cusRequestBody = new CusRequestBody();
        String str3 = f35687a;
        WLogger.d(str3, "deviceInfo=" + cusRequestBody.deviceInfo);
        if ("1".equals(this.d.x().a())) {
            cusRequestBody.showAuth = "1";
        }
        cusRequestBody.activeType = this.e.R();
        cusRequestBody.luxJudge = t;
        cusRequestBody.flashReqDTO = flashReq;
        cusRequestBody.transSwitch = "1";
        byte[] byteArray = this.aN.toByteArray();
        byte[] videoByte = WeMediaManager.getInstance().getVideoByte();
        String str4 = f35687a;
        StringBuilder sb = new StringBuilder();
        sb.append("ytVieo.len=");
        sb.append(byteArray == null ? com.igexin.push.core.b.l : Integer.valueOf(byteArray.length));
        WLogger.d(str4, sb.toString());
        String str5 = f35687a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("wbVieo.len=");
        sb2.append(videoByte == null ? com.igexin.push.core.b.l : Integer.valueOf(videoByte.length));
        WLogger.d(str5, sb2.toString());
        try {
            cusRequestBody.userVideoStr = Base64.encodeToString(byteArray, 0);
        } catch (Exception e) {
            e.printStackTrace();
            String str6 = f35687a;
            WLogger.w(str6, "返回base64 string exception：" + e.toString());
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            Activity activity = getActivity();
            kycWaSDK.trackCustomKVEvent(activity, "facepage_encrypt_error", "视频编码失败,返回base64 string exception：" + e.toString(), null);
        }
        if (!z && videoByte != null && videoByte.length != 0) {
            try {
                cusRequestBody.wbVideoStr = Base64.encodeToString(videoByte, 0);
                cusRequestBody.rotate = Param.getRolateInfo();
            } catch (Exception e2) {
                e2.printStackTrace();
                String str7 = f35687a;
                WLogger.w(str7, "返回base64 string exception：" + e2.toString());
                KycWaSDK kycWaSDK2 = KycWaSDK.getInstance();
                Activity activity2 = getActivity();
                kycWaSDK2.trackCustomKVEvent(activity2, "facepage_encrypt_error", "视频编码失败,返回base64 string exception：" + e2.toString(), null);
            }
        }
        String str8 = f35687a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("param.userVideoStr=");
        sb3.append(cusRequestBody.userVideoStr == null ? com.igexin.push.core.b.l : Integer.valueOf(cusRequestBody.userVideoStr.length()));
        WLogger.d(str8, sb3.toString());
        String str9 = f35687a;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("param.wbVideoStr=");
        sb4.append(cusRequestBody.wbVideoStr == null ? com.igexin.push.core.b.l : Integer.valueOf(cusRequestBody.wbVideoStr.length()));
        WLogger.d(str9, sb4.toString());
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(false, generateAESKey, "cus faceCompare:");
        try {
            str = WbCloudNetSecurityManger.base64Encry(false, new WeJson().toJson(cusRequestBody), generateAESKey);
        } catch (Exception e3) {
            e3.printStackTrace();
            String str10 = f35687a;
            WLogger.w(str10, "encry request failed:" + e3.toString());
            KycWaSDK kycWaSDK3 = KycWaSDK.getInstance();
            kycWaSDK3.trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry GetFaceResult failed!" + e3.toString(), null);
            str = null;
        }
        final WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
        wbFaceVerifyResult.setIsSuccess(true);
        if (this.d.e().w()) {
            wbFaceVerifyResult.setUserImageString(this.am.image);
        }
        WbCusFaceVerifyResult wbCusFaceVerifyResult = new WbCusFaceVerifyResult();
        wbCusFaceVerifyResult.setEncryptAESKey(encryptAESKey);
        wbCusFaceVerifyResult.setIdentityStr(str);
        wbFaceVerifyResult.setCusResult(wbCusFaceVerifyResult);
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.33
            @Override // java.lang.Runnable
            public void run() {
                a.this.C.b().a(50, new b.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.33.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.a
                    public void a() {
                        a.this.d.e(true);
                        if (a.this.d.y() != null) {
                            a.this.d.a(a.this.getActivity(), "0", (Properties) null);
                            a.this.d.y().onFinish(wbFaceVerifyResult);
                        }
                        a.this.Q();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        com.tencent.cloud.huiyansdkface.facelight.process.b.a(i, new b.InterfaceC0912b() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.10
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0912b
            public void a() {
                WLogger.d(a.f35687a, "start success!");
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0912b
            public void a(int i2, String str, String str2) {
            }
        });
    }

    private void f(boolean z) {
        if (this.g.b() == 9) {
            WLogger.d(f35687a, "On finish Step,No more startNetworkUpload!");
            return;
        }
        WLogger.d(f35687a, "startNetworkUpload");
        this.i.a(z, aa(), this.aN.toByteArray(), this.aH, this.am, this.an, this.ao, this.H, this.O, this.P, this.L, this.M, new ProcessCallback<FaceWillResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.35
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a */
            public void onSuccess(FaceWillResult faceWillResult) {
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.aV, "facepage_upload_result", "0", null);
                a.this.a(true, faceWillResult, (WbFaceInnerError) null);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                Properties properties = new Properties();
                properties.setProperty("msg", wbFaceInnerError.reason);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.aV, "facepage_upload_result", wbFaceInnerError.code, properties);
                a.this.a(false, (FaceWillResult) null, wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
                if (a.this.y.getVisibility() != 0) {
                    WLogger.d(a.f35687a, "show network bad tips.");
                    a.this.y.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        if (!this.d.v()) {
            WLogger.d(f35687a, "DONT playActTipVoice");
            return;
        }
        WLogger.d(f35687a, "playActTipVoice");
        e(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(boolean r7) {
        /*
            Method dump skipped, instructions count: 1779
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.g(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        String str = f35687a;
        WLogger.d(str, "updataLightState:cur=" + this.aE + ",update:" + i);
        this.aE = i;
        FaceVerifyStatus faceVerifyStatus = this.g;
        if (faceVerifyStatus != null) {
            faceVerifyStatus.a(i);
        }
    }

    private void h(boolean z) {
        this.i.a(this.aV, z, this.N, new ProcessCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.52
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                a.this.a(false, (FaceWillResult) null, wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onSuccess(Object obj) {
                a.this.W();
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(int i) {
        int ad = this.d.e().ad();
        String str = f35687a;
        WLogger.d(str, "action framesize:" + i + ",request num:" + ad);
        if (i < ad) {
            WLogger.w(f35687a, "frame size < request,dont encode!");
            return false;
        }
        return true;
    }

    private void j(int i) {
        YTFaceTracker yTFaceTracker = this.l;
        if (yTFaceTracker == null) {
            return;
        }
        YTFaceTracker.Param param = yTFaceTracker.getParam();
        param.detInterval = i;
        this.l.setParam(param);
    }

    private int u() {
        return this.Z;
    }

    private int v() {
        return this.aa;
    }

    private void w() {
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.c cVar = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.c(this.aV);
        this.f35689c = cVar;
        cVar.a(new com.tencent.cloud.huiyansdkface.facelight.c.b.f(this.d, getActivity(), this.g));
    }

    private void x() {
        String str;
        String str2;
        WLogger.d(f35687a, "initUploadPrepare");
        if (WbFaceModeProviders.isUseWillSdk() && this.e.o()) {
            this.k = new com.tencent.cloud.huiyansdkface.facelight.c.d(2);
            str = f35687a;
            str2 = "uploadPrepare need 2 prepare";
        } else {
            this.k = new com.tencent.cloud.huiyansdkface.facelight.c.d(1);
            str = f35687a;
            str2 = "uploadPrepare need 1 prepare";
        }
        WLogger.d(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        WLogger.d(f35687a, "initWbVideoRecord");
        this.aL = false;
        int i = 25;
        if (this.e.m()) {
            WLogger.d(f35687a, "record wbVideo");
            this.aL = true;
            long W = this.d.e().W();
            WLogger.i(f35687a, "record time=" + W);
            if (W > 1000) {
                WLogger.d(f35687a, "upload longer wbVideo!");
                this.aM = true;
            }
            float f = ((float) W) / 1000.0f;
            i = (int) (25 * f);
            WLogger.d(f35687a, "num=" + f + ",maxFameNum=" + i);
        } else {
            WLogger.i(f35687a, "not record wbVideo");
        }
        if (this.aL) {
            WeMediaManager.getInstance().init(i);
        }
    }

    private boolean z() {
        String str = this.f;
        return (str == null || !str.contains("3")) ? A() && B() : A() && B() && c("youtu_ios_0823");
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public RectF a(Rect rect) {
        return this.C.a(rect);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b
    public void a(float f) {
        WLogger.d(f35687a, "onFinishPath");
        this.aZ = f;
        String str = f35687a;
        WLogger.d(str, "totalScale=" + f + "," + this.aZ);
        float width = this.D.getBorderRect().width();
        String str2 = f35687a;
        WLogger.d(str2, "w=" + width);
        this.C.setCamViewWidth(width);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
        int left = this.p.getLeft();
        int i = (int) this.D.getBorderRect().top;
        layoutParams.setMargins(left, i, this.p.getRight(), this.p.getBottom());
        this.p.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        int left2 = this.q.getLeft();
        int i2 = (int) this.D.getBorderRect().bottom;
        layoutParams2.setMargins(left2, i2, this.q.getRight(), this.q.getBottom());
        this.q.setLayoutParams(layoutParams2);
        if (this.ai) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams3.height = i2 - i;
        this.r.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams4.setMargins(this.r.getLeft(), i, this.r.getRight(), this.r.getBottom());
        this.r.setLayoutParams(layoutParams4);
        this.ai = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r8 == 8) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.a(int, int, int, int):void");
    }

    public void a(final Bitmap bitmap) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.9
            @Override // java.lang.Runnable
            public void run() {
                a.this.C.setBlurImageView(bitmap);
                a.this.C.c();
            }
        });
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.b.b bVar) {
        WbFaceInnerError create;
        String d;
        StringBuilder sb;
        String str;
        if (getActivity() == null) {
            return;
        }
        int b = bVar.b();
        if (b == -10) {
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            Activity activity = getActivity();
            kycWaSDK.trackCustomKVEvent(activity, "camera_file_size_error", "视频大小不满足要求：" + bVar.c(), null);
            String str2 = f35687a;
            WLogger.e(str2, "FILE_SIZE_ERROR," + bVar.c());
            create = WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeMediaFileError, "视频大小不满足要求，请清理内存或重启设备后重试。", "FILE_SIZE_ERROR," + bVar.c());
        } else if (b != -2 && b != -1) {
            this.S = true;
            return;
        } else {
            if (this.S) {
                String str3 = f35687a;
                WLogger.w(str3, "restart camera error:" + bVar.c());
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_restart_error", bVar.c(), null);
                d = d(R.string.wbcf_open_camera_permission);
                sb = new StringBuilder();
                str = "restart camera error,";
            } else {
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_init_failed", bVar.c(), null);
                String str4 = f35687a;
                StringBuilder sb2 = new StringBuilder();
                str = "open/preview failed,";
                sb2.append("open/preview failed,");
                sb2.append(bVar.c());
                WLogger.e(str4, sb2.toString());
                d = d(R.string.wbcf_open_camera_permission);
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(bVar.c());
            create = WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeCameraException, d, sb.toString());
        }
        b(create);
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.process.c.c cVar) {
        WLogger.i(f35687a, "encodeVideo");
        long currentTimeMillis = System.currentTimeMillis();
        int rotate = RotateSetting.getRotate();
        int u = u();
        int v = v();
        if (rotate == 5 || rotate == 6 || rotate == 7 || rotate == 8) {
            u = v();
            v = u();
        }
        WLogger.d(f35687a, "收到视频上传通知，每帧width：" + u + " 每帧height: " + v);
        this.aP = 0;
        for (int i = 0; i < this.aT.length; i++) {
            this.aO.queueFrameH264(new YuvImage(this.aT[i], 17, u, v, null));
            this.aO.encodeH264();
            this.aP++;
        }
        WLogger.d(f35687a, "encode finish");
        cVar.a();
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_ytvideo_encoder_finish", (System.currentTimeMillis() - currentTimeMillis) + "ms", null);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public void a(String str) {
        this.aj.setText(str);
    }

    public void a(final boolean z) {
        String str = f35687a;
        WLogger.d(str, "stopEncode:" + Thread.currentThread());
        long currentTimeMillis = System.currentTimeMillis();
        this.aX.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.49
            @Override // java.lang.Runnable
            public void run() {
                a.this.aO.stopEncodingH264();
                if (z) {
                    return;
                }
                WLogger.d(a.f35687a, "dont output,delete origin!");
                a.this.aN.reset();
            }
        });
        if (!z) {
            this.aM = true;
        }
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        kycWaSDK.trackCustomKVEvent(null, "facepage_ytvideo_output", (System.currentTimeMillis() - currentTimeMillis) + "ms", null);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean a() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.av;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.av = null;
        }
        WLogger.i(f35687a, "openMouth");
        e(this.d.f().kyc_open_mouth);
        this.au = new CloudFaceCountDownTimer(15000L, m.ag) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.28
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j) {
                a.this.g(R.raw.wbcf_open_mouth);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_action_tips", "openMouth", null);
            }
        }.start();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public void b(final String str) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.34
            @Override // java.lang.Runnable
            public void run() {
                a.this.ak.setText(str);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean b() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.au;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.au = null;
        }
        WLogger.i(f35687a, "shakeHead");
        e(this.d.f().kyc_shake_head);
        this.av = new CloudFaceCountDownTimer(15000L, m.ag) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.29
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j) {
                a.this.g(R.raw.wbcf_shake_head);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_action_tips", "shakeHead", null);
            }
        }.start();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean c() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.av;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.av = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.au;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.au = null;
        }
        WLogger.i(f35687a, "wbcf_blinking");
        e(this.d.f().kyc_blink);
        this.at = new CloudFaceCountDownTimer(15000L, m.ag) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.30
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j) {
                a.this.g(R.raw.wbcf_blinking);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_action_tips", "blink", null);
            }
        }.start();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean d() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.av;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.av = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.au;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.au = null;
        }
        WLogger.i(f35687a, "actWaitRecordEnd");
        e(this.d.f().kyc_confirming);
        return false;
    }

    public void e(int i) {
        if (getActivity() == null) {
            return;
        }
        WLogger.d(f35687a, "PlayVoice IN");
        try {
            SoundPool soundPool = new SoundPool(1, 1, 1);
            this.n = soundPool;
            int load = soundPool.load(this.aV, i, 1);
            this.o = load;
            this.n.setOnLoadCompleteListener(new C0915a(load));
        } catch (Exception e) {
            e.printStackTrace();
            String str = f35687a;
            WLogger.w(str, "playVoice exception:" + e.toString());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.b
    public boolean e() {
        HeadBorderView headBorderView;
        int i;
        WLogger.i(f35687a, "=================start silentCheck======================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_live_type", "silent", null);
        M();
        if (this.e.J().equals("custom")) {
            headBorderView = this.D;
            i = R.color.wbcf_custom_border;
        } else {
            headBorderView = this.D;
            i = R.color.wbcf_sdk_base_blue;
        }
        headBorderView.a(c(i));
        if (this.e.m() || this.d.e().x()) {
            ab();
            this.s.setText(this.d.f().kyc_confirming);
            return false;
        }
        WLogger.i(f35687a, "=================end silentCheck======================");
        this.g.j();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.b
    public boolean f() {
        HeadBorderView headBorderView;
        int i;
        WLogger.i(f35687a, "=================start actDetect======================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_live_type", SocialConstants.PARAM_ACT, null);
        j(20);
        this.g.b(true);
        M();
        if (this.e.J().equals("custom")) {
            headBorderView = this.D;
            i = R.color.wbcf_custom_border;
        } else {
            headBorderView = this.D;
            i = R.color.wbcf_sdk_base_blue;
        }
        headBorderView.a(c(i));
        this.g.b(this.e.R());
        this.g.k();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.b
    public boolean g() {
        HeadBorderView a2;
        int i;
        WLogger.i(f35687a, "=================start faceLight======================");
        T();
        if (this.d.t()) {
            WLogger.w(f35687a, "before light,already finishVerify,RETURN");
            return false;
        }
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_live_type", "light", null);
        M();
        this.s.setText(this.d.f().kyc_dimmer);
        this.s.setTextColor(c(R.color.wbcf_white));
        this.t.setTextColor(c(R.color.wbcf_white));
        if (WbCloudFaceContant.BLACK.equals(this.e.J()) && this.G) {
            this.v.setBackgroundResource(R.drawable.wbcf_customer_long_tip_bg_white);
            this.w.setTextColor(c(R.color.wbcf_guide_text));
        }
        this.aF.setVisibility(0);
        if (this.e.J().equals("custom")) {
            a2 = this.aF.a();
            i = R.color.wbcf_custom_border;
        } else {
            a2 = this.aF.a();
            i = R.color.wbcf_sdk_base_blue;
        }
        a2.a(c(i));
        J();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void h() {
        WLogger.i(f35687a, "=================start preview======================");
        if (!this.d.e().v()) {
            e(R.raw.wbcf_keep_face_in);
            this.s.setText(this.d.f().kyc_aim);
        }
        ab();
        this.t.setText(this.e.v());
        long Y = d.z().e().Y();
        String str = f35687a;
        WLogger.d(str, "verify back showTime=" + Y);
        this.aw = new CloudFaceCountDownTimer(Y, Y) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.21
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
                WLogger.d(a.f35687a, "verify back show!");
                a.this.x.setVisibility(0);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void i() {
        WLogger.i(f35687a, "====================findFace====================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_predetect_enter", null, null);
        j(5);
        if (this.aL) {
            WeMediaManager.getInstance().stop(false);
        }
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = this.j;
        if (aVar != null) {
            aVar.a(false);
            if (!this.d.q()) {
                this.j.b();
            }
        }
        this.d.d(false);
        if (this.F) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.aq;
            if (aVar2 != null) {
                aVar2.dismiss();
                this.aq = null;
            }
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar3 = this.E;
            if (aVar3 != null) {
                aVar3.dismiss();
                this.E = null;
            }
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar4 = this.f35688ar;
            if (aVar4 != null) {
                aVar4.dismiss();
                this.f35688ar = null;
            }
            String str = this.f;
            if (str == null || !str.contains("3")) {
                return;
            }
            this.aF.setVisibility(8);
            h(0);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void j() {
        WLogger.i(f35687a, "====================Prepare start==========================");
        this.s.setText("");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_face_prepare", null, null);
        if (this.as != null) {
            WLogger.d(f35687a, "Prepare cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void k() {
        HeadBorderView headBorderView;
        int i;
        WLogger.i(f35687a, "=================start liveCheck======================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_detect_enter", null, this.al);
        if (this.as != null) {
            WLogger.d(f35687a, "liveCheck cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
        O();
        M();
        if (this.e.J().equals("custom")) {
            headBorderView = this.D;
            i = R.color.wbcf_custom_border;
        } else {
            headBorderView = this.D;
            i = R.color.wbcf_sdk_base_blue;
        }
        headBorderView.a(c(i));
        this.g.a(this.f);
        this.g.j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0084, code lost:
        if (r0 > 1.0f) goto L15;
     */
    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l() {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.l():void");
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void m() {
        WLogger.i(f35687a, "=================upload=================");
        b(this.aU);
        ac();
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.aw;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.aw = null;
        }
        this.x.setVisibility(8);
        this.s.setText(this.d.f().kyc_not_exit);
        this.t.setText(this.e.w());
        ab();
        String J = this.e.J();
        if (WbCloudFaceContant.BLACK.equals(J)) {
            this.D.a(c(R.color.wbcf_initial_border));
            if (this.G) {
                this.v.setBackgroundResource(R.drawable.wbcf_customer_long_tip_bg);
                this.w.setTextColor(c(R.color.wbcf_guide_text_black));
            }
        } else if (WbCloudFaceContant.WHITE.equals(J)) {
            this.D.a(c(R.color.wbcf_initial_border));
        } else if ("custom".equals(J)) {
            this.D.c(c(R.color.wbcf_custom_initial_border));
        }
        this.C.b().setVisibility(0);
        float top = this.C.getTop();
        float f = this.D.getBorderRect().bottom;
        float height = this.D.getBorderRect().height();
        float bottom = this.C.getBottom() - f;
        WLogger.d(f35687a, "top=" + top + ";bottom=" + f + ";height=" + height + ";init=" + bottom + ";end =" + height);
        this.C.b().setInitHeight(bottom);
        this.C.b().setEndHeight(height);
        com.tencent.cloud.huiyansdkface.facelight.c.d.c cVar = this.ad;
        int i = 1000;
        if (cVar != null) {
            i = 1000;
            if (cVar.b()) {
                WLogger.d(f35687a, "upload need wait camToken.");
                i = 1000 + this.d.e().F();
            }
        }
        WLogger.d(f35687a, "final loading time=" + i);
        this.C.b().a(i, 0.6f);
        Param.appendBlinkInfo(this.d.e().H());
        Param.appendGmInfo();
        WLogger.d(f35687a, "upload Ready to NEXT");
        ag();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void n() {
        String str = f35687a;
        WLogger.d(str, "outOfTime:" + this.al.toString());
        if (this.g.f()) {
            WLogger.d(f35687a, "ActiveDetect outOfTime");
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_exit_timeout", "动作检测超时", null);
            b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeActOutOfTime, "动作检测超时", "动作检测超时");
            return;
        }
        WLogger.d(f35687a, "FindFace outOfTime");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_exit_timeout", "预检测超时", this.al);
        b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeFindFaceOutOfTime, "人脸在框检测超时", "预检测人脸超时");
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void o() {
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_exit_timeout", WbFaceError.WBFaceErrorCodeOutOfControlNum, null);
        b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeOutOfControlNum, "风险控制超出次数", "风险控制超出次数");
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WLogger.i(f35687a, "onConfigurationChanged");
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.aq;
        if (aVar != null) {
            aVar.dismiss();
            this.aq = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.E = null;
        }
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_configuration_changed", null, null);
        Z();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        WLogger.d(f35687a, "onCreate");
        super.onCreate(bundle);
        Context applicationContext = getActivity().getApplicationContext();
        this.aV = applicationContext;
        this.af = new com.tencent.cloud.huiyansdkface.facelight.c.a.b(applicationContext);
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_enter", null, null);
        d z = d.z();
        this.d = z;
        if (this.F) {
            z.a(false);
        }
        this.e = this.d.x();
        FaceVerifyStatus faceVerifyStatus = new FaceVerifyStatus(this, this, this);
        this.g = faceVerifyStatus;
        faceVerifyStatus.a(new com.tencent.cloud.huiyansdkface.facelight.process.b.e() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.e
            public void a(int i) {
                WbFaceModeProviders.faceMode().onFaceStatusChanged(i);
            }
        });
        WbFaceModeProviders.faceMode().onEnterFaceLivePage(this.d.f());
        this.h = new com.tencent.cloud.huiyansdkface.facelight.process.e.a(this.d, this.g);
        this.i = new com.tencent.cloud.huiyansdkface.facelight.process.a.a(this.d, this.g);
        this.f = this.d.x().N();
        this.aU = R();
        String str = f35687a;
        WLogger.d(str, "sceen origin bright=" + this.aU + ",set full brightness");
        b(255.0f);
        w();
        this.aN = new ByteArrayOutputStream();
        this.aO = new VideoEncoder(null, true);
        x();
        boolean z2 = z();
        this.m = z2;
        if (!z2) {
            b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeInitModel, "初始化模型失败，请重试", "初始化模型失败");
            return;
        }
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_model_init", "initYoutu model success", null);
        C();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WLogger.i(f35687a, "onDestroy");
        M();
        WbFaceModeProviders.faceMode().onQuitFaceLivePage();
        YTFaceTracker.setLoggerListener(null);
        YTPoseDetectJNIInterface.setLoggerListener(null);
        YTAGReflectLiveCheckJNIInterface.setLoggerListener(null);
        if (this.j != null) {
            WLogger.d(f35687a, "onDestroy release FaceDetect.");
            this.j.a();
        }
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.19
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.l != null) {
                    WLogger.d(a.f35687a, "yttracker destroy");
                    a.this.a(a.f35687a, "yttracker destroy");
                    a.this.l.destroy();
                    a.this.l = null;
                }
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.b, android.app.Fragment
    public void onPause() {
        String str = f35687a;
        WLogger.d(str, "onPause:" + this.d.b());
        super.onPause();
        M();
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.c cVar = this.f35689c;
        if (cVar != null) {
            cVar.b();
        }
        this.b.a();
        U();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.b, android.app.Fragment
    public void onResume() {
        super.onResume();
        WLogger.d(f35687a, "onResume");
        V();
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.c cVar = this.f35689c;
        if (cVar != null) {
            cVar.a();
        }
        this.b.a(this.aV);
        if (this.aA) {
            WLogger.d(f35687a, "register light listener");
            try {
                this.aB.registerListener(this.ba, this.aC, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int b = this.g.b();
        String str = f35687a;
        WLogger.w(str, "status=" + b);
        if (b == 0) {
            WLogger.d(f35687a, "init status,go to PREVIEW");
            this.g.b(1);
            return;
        }
        String str2 = f35687a;
        WLogger.w(str2, "already status=" + b + ",NO RESET");
    }

    @Override // android.app.Fragment
    public void onStart() {
        WLogger.d(f35687a, "onStart()");
        super.onStart();
        int b = this.g.b();
        if (b != 0 && b == 9) {
            WLogger.e(f35687a, "already finished!");
            return;
        }
        com.tencent.cloud.huiyansdkface.a.c cVar = this.V;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        e eVar;
        String str = f35687a;
        WLogger.i(str, "onStop:" + this.d.b());
        super.onStop();
        if (this.V != null) {
            WLogger.d(f35687a, "stop mWeCamera");
            this.V.d();
            this.V.b(this.Y);
            this.V.f();
            this.V.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.18
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.cloud.huiyansdkface.a.b.b.a((com.tencent.cloud.huiyansdkface.a.b.a) null);
                    com.tencent.cloud.huiyansdkface.a.d.a.a((a.d) null);
                }
            });
        }
        if (this.d.e().B() && (eVar = this.ae) != null) {
            eVar.a();
        }
        this.g.b(9);
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = this.j;
        if (aVar != null) {
            aVar.a((com.tencent.cloud.huiyansdkface.facelight.ui.a.c) null);
        }
        if (this.aW != null) {
            this.aW = null;
        }
        T();
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.ay;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.az;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.ax;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.ax = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer4 = this.aw;
        if (cloudFaceCountDownTimer4 != null) {
            cloudFaceCountDownTimer4.cancel();
            this.aw = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.E = null;
        }
        M();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateErrorTip(String str) {
        this.u.setText(str);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateErrorTipTextColor(int i) {
        this.u.setTextColor(i);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateFaceBorder(final int i) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.55
            @Override // java.lang.Runnable
            public void run() {
                a.this.D.a(i);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateLongTipVisibility(int i) {
        if (this.G) {
            this.v.setVisibility(i);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateNetworkRetry() {
        long ap = this.d.e().ap();
        if (this.ay == null) {
            this.ay = new CloudFaceCountDownTimer(ap, ap / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.56
                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onFinish() {
                    a.this.z.setVisibility(8);
                    a.this.ay = null;
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onTick(long j) {
                }
            };
            if (this.z.getVisibility() != 0) {
                WLogger.d(f35687a, "show network bad tips.");
                this.z.setVisibility(0);
                this.ay.start();
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateRealFaceRect(RectF rectF) {
        this.D.a(rectF);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateTip(final String str) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.45
            @Override // java.lang.Runnable
            public void run() {
                a.this.s.setText(str);
                if (!a.this.al.containsKey(str)) {
                    a.this.al.put(str, 1);
                    return;
                }
                a.this.al.put(str, Integer.valueOf(((Integer) a.this.al.get(str)).intValue() + 1));
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateTipTextColor(final int i) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.54
            @Override // java.lang.Runnable
            public void run() {
                a.this.s.setTextColor(i);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void p() {
        WLogger.i(f35687a, "finished!");
        T();
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.ay;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.az;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.ay = null;
        }
        if (this.as != null) {
            WLogger.d(f35687a, "finished cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.ax;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.ax = null;
        }
        M();
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true);
        }
        if (this.aL) {
            WeMediaManager.getInstance().destroy();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.b
    public void q() {
        WLogger.d(f35687a, "setFragmentView");
        b(R.layout.wbcf_fragment_face_live);
        if (!this.m) {
            WLogger.e(f35687a, "init yt failed! finish!");
            return;
        }
        WLogger.d(f35687a, "init yt success,go to next!");
        D();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public RectF r() {
        return this.D.getBorderRect();
    }

    public void s() {
        String str = f35687a;
        WLogger.e(str, "setPreviewSize" + Thread.currentThread().getName());
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.C.a(a.this.Z, a.this.aa);
            }
        });
    }
}
