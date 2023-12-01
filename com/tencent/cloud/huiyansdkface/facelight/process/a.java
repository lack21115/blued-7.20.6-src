package com.tencent.cloud.huiyansdkface.facelight.process;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.FaceVerifyConfig;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.c.b.b;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.RotateSetting;
import com.tencent.cloud.huiyansdkface.facelight.process.b;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/a.class */
public class a {
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private long G;
    private long H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private CloudFaceCountDownTimer O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private long W;
    private b.a X;
    private com.tencent.cloud.huiyansdkface.facelight.b.a.b Z;

    /* renamed from: a  reason: collision with root package name */
    com.tencent.cloud.huiyansdkface.facelight.ui.a.c f35603a;
    private YTFaceTracker b;

    /* renamed from: c  reason: collision with root package name */
    private YTFaceTracker.TrackedFace[] f35604c;
    private volatile boolean e;
    private Context f;
    private FaceVerifyStatus h;
    private RectF i;
    private float j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private long o;
    private String p;
    private com.tencent.cloud.huiyansdkface.facelight.process.c.b q;
    private int r;
    private int s;
    private int t;
    private long u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;
    private byte[] d = null;
    private d g = d.z();
    private String Y = d.z().x().N();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.process.a$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/a$1.class */
    public class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        public void a() {
            WLogger.d("FaceDetect", "onCanReflect");
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        public void a(final int i) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.1.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x00fe  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0192  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 557
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.process.a.AnonymousClass1.RunnableC09101.run():void");
                }
            });
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        public void a(int i, String str, String str2) {
            WLogger.w("FaceDetect", "YTPoseDetectInterface.poseDetect.onFailed: " + i + ";" + str + ";" + str2);
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        public void a(byte[][] bArr, int i, int i2) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.1.2
                @Override // java.lang.Runnable
                public void run() {
                    WLogger.d("FaceDetect", "onRecordingDone");
                    if (!a.this.Y.contains("2")) {
                        if ("1".equals(a.this.Y)) {
                            WLogger.i("FaceDetect", "=================onRecordingDone，end silentCheck======================");
                            if (d.z().e().x()) {
                                if (!d.z().x().m() || a.this.h.g()) {
                                    a.this.h.j();
                                }
                            }
                        }
                    } else if (a.this.h.d() == 2) {
                        if (a.this.Q && !a.this.R) {
                            WLogger.i("FaceDetect", "first act onRecordingDone");
                            a.this.R = true;
                        } else if (a.this.P) {
                        } else {
                            WLogger.i("FaceDetect", "====================onRecordingDone end!==========================");
                            a.this.P = true;
                            if (a.this.O != null) {
                                WLogger.d("FaceDetect", "cancel record timeout cdt");
                                a.this.O.cancel();
                                a.this.O = null;
                            }
                            a.this.h.k();
                        }
                    }
                }
            });
        }
    }

    public a(Context context, YTFaceTracker yTFaceTracker, com.tencent.cloud.huiyansdkface.facelight.process.c.b bVar) {
        this.b = null;
        this.f = context;
        this.b = yTFaceTracker;
        this.q = bVar;
        WLogger.d("FaceDetect", "liveSequence=" + this.Y);
        c();
        d();
    }

    private Rect a(YTFaceTracker.TrackedFace trackedFace) {
        float f;
        int i = 0;
        float f2 = trackedFace.faceShape[0];
        float f3 = trackedFace.faceShape[0];
        float f4 = trackedFace.faceShape[1];
        float f5 = trackedFace.faceShape[1];
        while (i < 180) {
            f2 = Math.min(f2, trackedFace.faceShape[i]);
            f3 = Math.max(f3, trackedFace.faceShape[i]);
            int i2 = i + 1;
            f4 = Math.min(f4, trackedFace.faceShape[i2]);
            f5 = Math.max(f5, trackedFace.faceShape[i2]);
            i = i2 + 1;
        }
        int i3 = this.r;
        float f6 = (i3 - 1) - f2;
        float f7 = (float) (((i3 - 1) - f3) - (((f6 - f) * 0.1d) / 2.0d));
        float f8 = (float) (f6 + (((f6 - f7) * 0.1d) / 2.0d));
        float f9 = (float) (f4 - (((f5 - f4) * 0.1d) / 2.0d));
        float f10 = (float) (f5 + (((f5 - f9) * 0.1d) / 2.0d));
        float f11 = f8;
        float f12 = f9;
        float f13 = f10;
        float f14 = f7;
        if (this.t == 0) {
            float f15 = f7;
            if (f7 < 0.0f) {
                f15 = 0.0f;
            }
            float f16 = f8;
            if (f8 < 0.0f) {
                f16 = 0.0f;
            }
            int i4 = this.r;
            float f17 = f15;
            if (f15 > i4 - 1) {
                f17 = i4 - 1;
            }
            int i5 = this.r;
            float f18 = f16;
            if (f16 > i5 - 1) {
                f18 = i5 - 1;
            }
            float f19 = f9;
            if (f9 < 0.0f) {
                f19 = 0.0f;
            }
            float f20 = f10;
            if (f10 < 0.0f) {
                f20 = 0.0f;
            }
            int i6 = this.s;
            float f21 = f19;
            if (f19 > i6 - 1) {
                f21 = i6 - 1;
            }
            int i7 = this.s;
            f11 = f18;
            f12 = f21;
            f13 = f20;
            f14 = f17;
            if (f20 > i7 - 1) {
                f13 = i7 - 1;
                f14 = f17;
                f12 = f21;
                f11 = f18;
            }
        }
        Rect rect = new Rect();
        rect.left = (int) f14;
        rect.top = (int) f12;
        rect.right = (int) f11;
        rect.bottom = (int) f13;
        return rect;
    }

    private void a(int i) {
        if (i == 2) {
            WLogger.i("FaceDetect", "=================END FindFace======================");
            e();
            this.h.b(3);
        } else if (i == 3) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar) {
        com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar;
        int b = this.h.b();
        int d = this.h.d();
        int e = this.h.e();
        if (this.S || b == 1) {
            return;
        }
        if ((b == 4 && d == 3 && e > 1) || b == 6 || b == 8 || b == 7 || b == 9 || a(b, d)) {
            return;
        }
        final YTFaceTracker.TrackedFace[] trackedFaceArr = bVar.f35535a;
        if (trackedFaceArr == null) {
            WLogger.i("FaceDetect", "faceStatus null");
            if (this.T) {
                this.T = false;
                this.g.s();
                WLogger.d("FaceDetect", "noface after control count=" + this.g.r());
                if (this.g.r() > 9) {
                    WLogger.e("FaceDetect", "风险控制超过次数，错误退出！");
                    this.h.b(8);
                    return;
                }
            }
            if (b == 4) {
                WLogger.e("FaceDetect", "live check express detect red!");
                g();
                return;
            } else if (b != 5) {
                a(this.g.f().kyc_no_face);
                return;
            } else {
                int i = this.K + 1;
                this.K = i;
                if (i >= this.I) {
                    WLogger.e("FaceDetect", "will express detect red!" + this.K);
                    g();
                    return;
                }
                return;
            }
        }
        this.T = true;
        if (!this.U) {
            a("FaceDetect", "first has face");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f, "facepage_has_face", null, null);
            this.U = true;
        }
        Rect a2 = a(trackedFaceArr[0]);
        if (b != 2 && b != 3) {
            if (b == 4) {
                com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar2 = this.f35603a;
                if (cVar2 == null) {
                    WLogger.e("FaceDetect", "mFaceLiveView null");
                    return;
                } else if (!this.i.contains(cVar2.a(a2))) {
                    WLogger.e("FaceDetect", "活体检测过程中人脸偏移出框");
                    g();
                    return;
                } else if (d == 3 || !a(trackedFaceArr[0], false)) {
                    return;
                } else {
                    WLogger.e("FaceDetect", "活体检测过程中人脸被遮挡");
                    g();
                    return;
                }
            } else if (b == 5) {
                com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar3 = this.f35603a;
                if (cVar3 == null) {
                    WLogger.e("FaceDetect", "willExpress mFaceLiveView null");
                    return;
                } else if (!this.i.contains(cVar3.a(a2))) {
                    int i2 = this.L + 1;
                    this.L = i2;
                    if (i2 >= this.I) {
                        WLogger.e("FaceDetect", "will活体检测过程中人脸偏移出框:" + this.L);
                        g();
                        return;
                    }
                    return;
                } else if (trackedFaceArr[0].yaw < this.x || trackedFaceArr[0].yaw > this.y) {
                    WLogger.w("FaceDetect", "侧脸了 yaw=" + trackedFaceArr[0].yaw);
                    int i3 = this.M + 1;
                    this.M = i3;
                    if (i3 >= this.J) {
                        WLogger.e("FaceDetect", "will侧脸了:" + this.M);
                        g();
                        return;
                    }
                    return;
                } else if (!this.g.e().d() || !a(trackedFaceArr[0], false)) {
                    WLogger.d("FaceDetect", "will face ok.");
                    this.K = 0;
                    this.L = 0;
                    this.M = 0;
                    this.N = 0;
                    return;
                } else {
                    int i4 = this.N + 1;
                    this.N = i4;
                    if (i4 >= this.J) {
                        WLogger.e("FaceDetect", "will遮挡了:" + this.N);
                        g();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        }
        if (FaceVerifyConfig.getInstance().displayInfoInUI() && (cVar = this.f35603a) != null) {
            cVar.a("p|y|r=" + trackedFaceArr[0].pitch + "|" + trackedFaceArr[0].yaw + "|" + trackedFaceArr[0].roll);
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar4 = this.f35603a;
        if (cVar4 == null) {
            WLogger.e("FaceDetect", "mFaceLiveView null");
            return;
        }
        RectF a3 = cVar4.a(a2);
        this.f35603a.onUpdateRealFaceRect(a3);
        RectF r = this.f35603a.r();
        this.i = new RectF(r.left, r.top, r.right, r.bottom + 80.0f);
        this.j = r.width() * r.height();
        float width = a3.width() * a3.height();
        WLogger.d("FaceDetect", "faceArea=" + width);
        if (!this.i.contains(a3)) {
            if (width >= this.j) {
                WLogger.e("FaceDetect", "人脸大于框框！");
                a(this.g.f().kyc_fara_way);
                return;
            }
            WLogger.d("FaceDetect", "框框不包含人脸。");
            a(this.g.f().kyc_face_out);
            return;
        }
        WLogger.d("FaceDetect", "faceArea=" + width + "; faceBgArea=" + this.j);
        float f = width / this.j;
        StringBuilder sb = new StringBuilder();
        sb.append("人脸占人脸框的percent=");
        sb.append(f);
        WLogger.d("FaceDetect", sb.toString());
        if (FaceVerifyConfig.getInstance().displayInfoInUI()) {
            WLogger.d("FaceDetect", "displayInfoInUI");
            com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar5 = this.f35603a;
            if (cVar5 != null) {
                cVar5.b("percent=" + f);
            }
        }
        if (f < this.v) {
            WLogger.w("FaceDetect", "人脸太小！");
            a(this.g.f().kyc_get_closer);
        } else if (f > this.w) {
            WLogger.w("FaceDetect", "人脸太大！");
            a(this.g.f().kyc_fara_way);
        } else {
            WLogger.d("FaceDetect", "人脸大小合适！");
            if (a3.top < this.i.top + (this.i.height() / 8.0f)) {
                WLogger.w("FaceDetect", "人脸下移一点！");
                a(this.g.f().kyc_face_out);
            } else if (trackedFaceArr[0].yaw < this.x || trackedFaceArr[0].yaw > this.y) {
                WLogger.w("FaceDetect", "侧脸了 yaw=" + trackedFaceArr[0].yaw);
                a(this.g.f().kyc_turn_side);
            } else if (trackedFaceArr[0].pitch < this.z) {
                WLogger.w("FaceDetect", "仰头了 pitch=" + trackedFaceArr[0].pitch);
                a(this.g.f().kyc_look_up);
            } else if (trackedFaceArr[0].pitch > this.A) {
                WLogger.w("FaceDetect", "低头了 pitch=" + trackedFaceArr[0].pitch);
                a(this.g.f().kyc_look_down);
            } else if (trackedFaceArr[0].roll < this.B || trackedFaceArr[0].roll > this.C) {
                WLogger.w("FaceDetect", "歪头了 roll=" + trackedFaceArr[0].roll);
                a(this.g.f().kyc_turn_side);
            } else {
                WLogger.d("FaceDetect", "人脸端正！");
                if (a(trackedFaceArr[0], true)) {
                    return;
                }
                WLogger.d("FaceDetect", "人脸符合条件");
                if (this.g.e().C()) {
                    float a4 = com.tencent.cloud.huiyansdkface.facelight.c.b.a(trackedFaceArr[0].faceShape);
                    WLogger.d("FaceDetect", "eye score:" + a4);
                    if (a4 < this.F) {
                        WLogger.d("FaceDetect", "闭眼了");
                        a(this.g.f().kyc_open_eyes);
                        return;
                    }
                }
                com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        b.a(trackedFaceArr[0].faceShape, trackedFaceArr[0].faceVisible, 5, bVar.b, bVar.f35536c, bVar.d, trackedFaceArr[0].pitch, trackedFaceArr[0].yaw, trackedFaceArr[0].roll, a.this.X, 1, a.this.t);
                    }
                });
                if (!this.k) {
                    this.o = System.currentTimeMillis();
                    this.k = true;
                }
                if (this.l) {
                    this.m++;
                    WLogger.d("FaceDetect", "红想变蓝，blueCount=" + this.m);
                    if (this.m < 2) {
                        return;
                    }
                    WLogger.d("FaceDetect", "红变蓝成功！");
                    this.l = false;
                } else {
                    WLogger.d("FaceDetect", "一直蓝");
                }
                this.Z = bVar;
                a(b);
            }
        }
    }

    private void a(String str) {
        StringBuilder sb;
        if (this.S) {
            WLogger.d("FaceDetect", "isDestroying");
            return;
        }
        this.m = 0;
        String str2 = ";new=";
        if (!this.l || TextUtils.isEmpty(this.p)) {
            sb = new StringBuilder();
            sb.append("直接切换 蓝变红或者第一次变红 lastRedTip=");
            sb.append(this.p);
        } else if (this.n < 2) {
            WLogger.d("FaceDetect", "红色想要切换提示语，上一次=" + this.p + ";new=" + str);
            if (this.p.equals(str)) {
                this.n++;
                WLogger.d("FaceDetect", "sameCount+1, now samCount=" + this.n);
            } else {
                WLogger.d("FaceDetect", "不足三次，切换提示语失败");
                this.n = 0;
                this.p = str;
            }
            this.l = true;
            this.k = false;
        } else {
            sb = new StringBuilder();
            str2 = "已切换成提示语=";
        }
        sb.append(str2);
        sb.append(str);
        WLogger.d("FaceDetect", sb.toString());
        this.n = 0;
        this.p = str;
        b(str);
        this.l = true;
        this.k = false;
    }

    private void a(String str, String str2) {
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().b(str, str2);
    }

    private boolean a(int i, int i2) {
        if ((i == 4 && (i2 == 3 || i2 == 1)) || i == 5) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.h.a();
        WLogger.d("FaceDetect", "check timeout:" + currentTimeMillis);
        if (currentTimeMillis > this.u) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.9
                @Override // java.lang.Runnable
                public void run() {
                    WLogger.d("FaceDetect", "finish report out of time, set current Status OUTOFTIME");
                    a.this.h.b(7);
                }
            });
            return true;
        }
        return false;
    }

    private boolean a(YTFaceTracker.TrackedFace trackedFace, boolean z) {
        if (com.tencent.cloud.huiyansdkface.facelight.c.b.a(trackedFace, this.D, this.E)) {
            if (z) {
                a(this.g.f().kyc_cover_eyes);
                return true;
            }
            return true;
        } else if (com.tencent.cloud.huiyansdkface.facelight.c.b.b(trackedFace, this.D, this.E)) {
            if (z) {
                a(this.g.f().kyc_cover_nose);
                return true;
            }
            return true;
        } else if (com.tencent.cloud.huiyansdkface.facelight.c.b.c(trackedFace, this.D, this.E)) {
            if (z) {
                a(this.g.f().kyc_cover_mouse);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.cloud.huiyansdkface.facelight.b.a.b b(byte[] bArr, int i, int i2) {
        this.e = true;
        this.d = bArr;
        if (bArr == null) {
            WLogger.i("FrameData is null!");
        } else if (this.S || this.h.b() == 1 || this.h.b() == 6 || this.h.b() == 8 || this.h.b() == 7 || this.h.b() == 9) {
            WLogger.d("FaceDetect", "isFinishing true");
        } else {
            byte[] bArr2 = (byte[]) bArr.clone();
            if (this.h.d() == 3 && this.h.e() == 2) {
                WLogger.d("FaceDetect", "REFLECT DETECT_DELAY nowTime=" + System.currentTimeMillis());
                YTAGReflectLiveCheckInterface.pushImageData(bArr2, i, i2, System.currentTimeMillis(), 0, null, 0.0f, 0.0f, 0.0f);
            } else if (this.b != null) {
                if (!this.V) {
                    this.W = System.currentTimeMillis();
                }
                try {
                    this.f35604c = this.b.track(0, this.d, i, i2, RotateSetting.getRotate(), false, null);
                } catch (Exception e) {
                    e.printStackTrace();
                    WLogger.e("FaceDetect", e.toString());
                }
                if (!this.V) {
                    long currentTimeMillis = System.currentTimeMillis() - this.W;
                    com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().a("FaceDetect", "first track:" + currentTimeMillis);
                    this.V = true;
                    KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_first_yttrack", "track:" + currentTimeMillis, null);
                }
                YTFaceTracker.TrackedFace[] trackedFaceArr = this.f35604c;
                if (trackedFaceArr == null || trackedFaceArr.length == 0) {
                    WLogger.w("FaceDetect", "face status is null");
                    this.f35604c = null;
                }
                YTFaceTracker.TrackedFace[] trackedFaceArr2 = this.f35604c;
                if (trackedFaceArr2 != null) {
                    YTFaceTracker.TrackedFace[] a2 = com.tencent.cloud.huiyansdkface.facelight.c.b.a(trackedFaceArr2);
                    this.f35604c = a2;
                    if (a2.length > 1) {
                        int i3 = Integer.MIN_VALUE;
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            YTFaceTracker.TrackedFace[] trackedFaceArr3 = this.f35604c;
                            if (i4 >= trackedFaceArr3.length) {
                                break;
                            }
                            Rect a3 = a(trackedFaceArr3[i4]);
                            int width = a3.width() * a3.height();
                            int i6 = i3;
                            if (width >= i3) {
                                i5 = i4;
                                i6 = width;
                            }
                            i4++;
                            i3 = i6;
                        }
                        if (i5 != 0) {
                            WLogger.i("FaceDetect", "Found max face id:" + i5);
                            YTFaceTracker.TrackedFace[] trackedFaceArr4 = this.f35604c;
                            trackedFaceArr4[0] = trackedFaceArr4[i5];
                        }
                    }
                    if (this.h.b() == 4) {
                        if (this.h.d() == 1) {
                            b.a(this.f35604c[0].faceShape, this.f35604c[0].faceVisible, 5, bArr2, i, i2, this.f35604c[0].pitch, this.f35604c[0].yaw, this.f35604c[0].roll, this.X, 1, this.t);
                        }
                        if (this.h.d() == 2) {
                            int c2 = this.h.c();
                            if (c2 == 2) {
                                WLogger.d("FaceDetect", "blink nowTime=" + System.currentTimeMillis());
                                b.a(this.f35604c[0].faceShape, this.f35604c[0].faceVisible, 1, bArr2, i, i2, this.f35604c[0].pitch, this.f35604c[0].yaw, this.f35604c[0].roll, this.X, 1, this.t);
                            } else if (c2 == 3) {
                                WLogger.d("FaceDetect", "openMouth nowTime=" + System.currentTimeMillis());
                                b.a(this.f35604c[0].faceShape, this.f35604c[0].faceVisible, 2, bArr2, i, i2, this.f35604c[0].pitch, this.f35604c[0].yaw, this.f35604c[0].roll, this.X, 1, this.t);
                            } else if (c2 == 1) {
                                WLogger.d("FaceDetect", "shakeHead nowTime=" + System.currentTimeMillis());
                                b.a(this.f35604c[0].faceShape, this.f35604c[0].faceVisible, 4, bArr2, i, i2, this.f35604c[0].pitch, this.f35604c[0].yaw, this.f35604c[0].roll, this.X, 1, this.t);
                            }
                        }
                        if (this.h.d() == 3) {
                            if (this.h.e() == 1) {
                                WLogger.d("FaceDetect", "REFLECT nowTime=" + System.currentTimeMillis());
                                YTAGReflectLiveCheckInterface.pushImageData(bArr2, i, i2, System.currentTimeMillis(), RotateSetting.getRotate(), this.f35604c[0].faceShape, this.f35604c[0].pitch, this.f35604c[0].yaw, this.f35604c[0].roll);
                            }
                            if (this.g.e().x()) {
                                if (YTPoseDetectJNIInterface.isRecordingDone()) {
                                    WLogger.d("FaceDetect", "poseDetect while reflect finished.");
                                } else {
                                    WLogger.d("FaceDetect", "poseDetect while reflect.");
                                    b.a(this.f35604c[0].faceShape, this.f35604c[0].faceVisible, 5, bArr2, i, i2, this.f35604c[0].pitch, this.f35604c[0].yaw, this.f35604c[0].roll, this.X, 1, this.t);
                                }
                            }
                        }
                    }
                }
                com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar = new com.tencent.cloud.huiyansdkface.facelight.b.a.b();
                bVar.f35535a = this.f35604c;
                bVar.b = bArr2;
                bVar.f35536c = i;
                bVar.d = i2;
                this.e = false;
                return bVar;
            } else {
                WLogger.w("FaceDetect", "faceTracker is null");
            }
        }
        this.e = false;
        return null;
    }

    private void b(final String str) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar;
                Resources resources;
                int i;
                if (a.this.f35603a != null) {
                    if ("custom".equals(a.this.g.x().J())) {
                        a.this.f35603a.onUpdateTipTextColor(a.this.f.getResources().getColor(R.color.wbcf_custom_tips_text_error));
                        cVar = a.this.f35603a;
                        resources = a.this.f.getResources();
                        i = R.color.wbcf_custom_border_error;
                    } else if (WbCloudFaceContant.BLACK.equals(a.this.g.x().J())) {
                        a.this.f35603a.onUpdateTipTextColor(a.this.f.getResources().getColor(R.color.wbcf_red));
                        cVar = a.this.f35603a;
                        resources = a.this.f.getResources();
                        i = R.color.wbcf_red;
                    } else {
                        a.this.f35603a.onUpdateTipTextColor(a.this.f.getResources().getColor(R.color.wbcf_red_white));
                        cVar = a.this.f35603a;
                        resources = a.this.f.getResources();
                        i = R.color.wbcf_red_white;
                    }
                    cVar.onUpdateFaceBorder(resources.getColor(i));
                    a.this.f35603a.onUpdateTip(str);
                }
            }
        });
    }

    private void c() {
        int j = this.g.x().j();
        WLogger.d("FaceDetect", "blink safelevel=" + j);
        YTPoseDetectJNIInterface.updateParam("frame_num", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
        YTPoseDetectJNIInterface.updateParam("last_frame_num", "3");
        YTPoseDetectJNIInterface.updateParam("min_gray_val", "0");
        YTPoseDetectJNIInterface.updateParam("max_gray_val", "255");
        YTPoseDetectJNIInterface.setSafetyLevel(j);
        this.X = new AnonymousClass1();
    }

    private void d() {
        com.tencent.cloud.huiyansdkface.facelight.a.a.b e = this.g.e();
        this.u = e.U();
        this.v = e.J();
        this.w = e.K();
        this.x = e.L();
        this.y = e.M();
        this.z = e.N();
        this.A = e.O();
        this.B = e.P();
        this.C = e.Q();
        this.D = e.R();
        this.E = e.S();
        this.F = e.T();
        this.G = e.ab();
        this.H = e.ac();
        this.I = e.ah();
        this.J = e.ai();
        WLogger.d("FaceDetect", "outOfTime=" + this.u + "; lightFaceAreaMin=" + this.v + "; lightFaceAreaMax=" + this.w + "; lightFaceYawMin=" + this.x + "; lightFaceYawMax=" + this.y + "; lightFacePitchMin=" + this.z + "; lightFacePitchMax=" + this.A + "; lightFaceRollMin=" + this.B + "; lightFaceRollMax=" + this.C + "; lightPointsPercent=" + this.D + "; lightPointsVis=" + this.E + "; willFaceOutCount=" + this.I + "; willPoseCount=" + this.J);
    }

    private void e() {
        if (this.S) {
            WLogger.d("FaceDetect", "isDestroying");
        } else {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.7
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar;
                    Resources resources;
                    int i;
                    com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar2;
                    Resources resources2;
                    int i2;
                    if (a.this.f35603a != null) {
                        if (WbCloudFaceContant.BLACK.equals(a.this.g.x().J())) {
                            cVar2 = a.this.f35603a;
                            resources2 = a.this.f.getResources();
                            i2 = R.color.wbcf_white;
                        } else if (!WbCloudFaceContant.WHITE.equals(a.this.g.x().J())) {
                            if ("custom".equals(a.this.g.x().J())) {
                                a.this.f35603a.onUpdateTipTextColor(a.this.f.getResources().getColor(R.color.wbcf_custom_tips_text));
                                cVar = a.this.f35603a;
                                resources = a.this.f.getResources();
                                i = R.color.wbcf_custom_border;
                                cVar.onUpdateFaceBorder(resources.getColor(i));
                            }
                            return;
                        } else {
                            cVar2 = a.this.f35603a;
                            resources2 = a.this.f.getResources();
                            i2 = R.color.wbcf_black_text;
                        }
                        cVar2.onUpdateTipTextColor(resources2.getColor(i2));
                        cVar = a.this.f35603a;
                        resources = a.this.f.getResources();
                        i = R.color.wbcf_sdk_base_blue;
                        cVar.onUpdateFaceBorder(resources.getColor(i));
                    }
                }
            });
        }
    }

    private void f() {
        if (System.currentTimeMillis() - this.o > this.G) {
            WLogger.i("FaceDetect", "=================END PREPARE======================");
            this.h.b(4);
        }
    }

    private void g() {
        if (this.g.q()) {
            WLogger.d("FaceDetect", "already in reset");
            return;
        }
        b();
        this.q.a();
    }

    public void a() {
        WLogger.d("FaceDetect", "release");
        a("FaceDetect", "faceDetect release");
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.e()) {
                    b.d();
                }
                b.b();
                YTAGReflectLiveCheckInterface.cancel();
                YTAGReflectLiveCheckInterface.releaseModel();
                if (a.this.b != null) {
                    a.this.b = null;
                }
            }
        });
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_release", null, null);
    }

    public void a(int i, int i2, int i3) {
        this.r = i;
        this.s = i2;
        this.t = i3;
    }

    public void a(FaceVerifyStatus faceVerifyStatus) {
        this.h = faceVerifyStatus;
    }

    public void a(final com.tencent.cloud.huiyansdkface.facelight.process.c.d dVar) {
        WLogger.i("FaceDetect", "pushBackupData");
        final com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar = this.Z;
        if (bVar == null) {
            WLogger.w("FaceDetect", "backupData is null,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f, "faceservice_push_backup_data", "backupData is null!", null);
            dVar.a(null);
            return;
        }
        YTFaceTracker.TrackedFace[] trackedFaceArr = bVar.f35535a;
        if (trackedFaceArr == null || trackedFaceArr.length <= 0) {
            WLogger.w("FaceDetect", "backupData faces is null,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f, "faceservice_push_backup_data", "backupData faces is null!", null);
            dVar.a(null);
            return;
        }
        YTFaceTracker.TrackedFace trackedFace = trackedFaceArr[0];
        if (trackedFace == null) {
            WLogger.w("FaceDetect", "backupData face[0] is null,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f, "faceservice_push_backup_data", "backupData face[0] is null!", null);
            dVar.a(null);
            return;
        }
        float[] fArr = trackedFace.faceShape;
        if (fArr == null || fArr.length <= 0) {
            WLogger.w("FaceDetect", "backupData face[0] shape is null or empty,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f, "faceservice_push_backup_data", "backupData face[0] shape is null or empty!", null);
            dVar.a(null);
            return;
        }
        WLogger.d("FaceDetect", "backupData shape:" + fArr.length + "," + fArr[0] + "," + bVar.f35536c + "x" + bVar.d);
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        Context context = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append("backupData faces[0].faceShape.length=");
        sb.append(fArr.length);
        kycWaSDK.trackCustomKVEvent(context, "faceservice_push_backup_data", sb.toString(), null);
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public YTActRefData call() {
                WLogger.i("FaceDetect", "pushBackupData enter");
                YTFaceTracker.TrackedFace[] trackedFaceArr2 = bVar.f35535a;
                WLogger.d("FaceDetect", "data.faces=" + trackedFaceArr2[0].faceShape.length);
                YTActRefImage yTActRefImage = new YTActRefImage();
                yTActRefImage.checksum = "";
                yTActRefImage.xys = trackedFaceArr2[0].faceShape;
                yTActRefImage.image = RotateSetting.rawCamDataToJpg(RotateSetting.getRotate(), bVar.b, bVar.f35536c, bVar.d, false);
                YTActRefData yTActRefData = new YTActRefData();
                yTActRefData.best = yTActRefImage;
                yTActRefData.eye = yTActRefImage;
                yTActRefData.mouth = yTActRefImage;
                return yTActRefData;
            }
        }, new b.a<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(YTActRefData yTActRefData) {
                WLogger.i("FaceDetect", "pushBackupData success,get bestImages!");
                dVar.a(yTActRefData);
            }
        });
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar) {
        this.f35603a = cVar;
    }

    public void a(boolean z) {
        this.S = z;
    }

    public void a(final byte[] bArr, final int i, final int i2) {
        if (this.e || this.S || this.h.b() == 1 || this.h.b() == 6 || this.h.b() == 8 || this.h.b() == 7 || this.h.b() == 9) {
            return;
        }
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<com.tencent.cloud.huiyansdkface.facelight.b.a.b>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.4
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public com.tencent.cloud.huiyansdkface.facelight.b.a.b call() {
                return a.this.b(bArr, i, i2);
            }
        }, new b.a<com.tencent.cloud.huiyansdkface.facelight.b.a.b>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.5
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar) {
                a.this.a(bVar);
            }
        });
    }

    public void b() {
        WLogger.i("FaceDetect", "reset");
        this.g.d(true);
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.Z = null;
        if (this.O != null) {
            WLogger.d("FaceDetect", "reset cancel recordCdt!");
            this.O.cancel();
            this.O = null;
        }
        this.R = false;
        this.P = false;
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.11
            @Override // java.lang.Runnable
            public void run() {
                b.c();
                d.z().k();
                d.z().n();
                YTAGReflectLiveCheckInterface.cancel();
            }
        });
    }
}
