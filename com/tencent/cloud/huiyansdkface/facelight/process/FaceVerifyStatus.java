package com.tencent.cloud.huiyansdkface.facelight.process;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/FaceVerifyStatus.class */
public class FaceVerifyStatus {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21908a = true;
    private com.tencent.cloud.huiyansdkface.facelight.process.b.d b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f21909c;
    private long d;
    private String e;
    private volatile int f;
    private com.tencent.cloud.huiyansdkface.facelight.process.b.b g;
    private int h;
    private int i;
    private String j;
    private volatile int k;
    private com.tencent.cloud.huiyansdkface.facelight.process.b.a l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private volatile boolean q;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/FaceVerifyStatus$Mode.class */
    public enum Mode {
        GRADE
    }

    public FaceVerifyStatus(com.tencent.cloud.huiyansdkface.facelight.process.b.c cVar, com.tencent.cloud.huiyansdkface.facelight.process.b.b bVar, com.tencent.cloud.huiyansdkface.facelight.process.b.a aVar) {
        com.tencent.cloud.huiyansdkface.facelight.process.b.d dVar = new com.tencent.cloud.huiyansdkface.facelight.process.b.d();
        this.b = dVar;
        this.h = 0;
        this.m = 0;
        dVar.a(cVar);
        this.g = bVar;
        this.l = aVar;
    }

    static /* synthetic */ int d(FaceVerifyStatus faceVerifyStatus) {
        int i = faceVerifyStatus.h;
        faceVerifyStatus.h = i + 1;
        return i;
    }

    private void d(int i) {
        if (this.l == null) {
            WLogger.d("FaceVerifyStatus", "setCurrentType mActiveDetectInterface == null error!");
        } else if (this.f21909c > 4) {
            WLogger.e("FaceVerifyStatus", "curStatus=" + this.f21909c + ",no need to update act.");
        } else {
            this.k = i;
            if (i == 1) {
                this.l.b();
            } else if (i == 2) {
                this.l.c();
            } else if (i == 3) {
                this.l.a();
            } else if (i != 4) {
            } else {
                this.l.d();
            }
        }
    }

    public long a() {
        return this.d;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.process.b.c cVar) {
        this.b.a(cVar);
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(boolean z) {
        this.f21908a = z;
    }

    public int b() {
        return this.f21909c;
    }

    public void b(int i) {
        String str;
        if (this.b == null) {
            str = "setCurrentStep mInterface == null error!";
        } else if (i != 2 || this.f21908a) {
            this.f21909c = i;
            WLogger.d("FaceVerifyStatus", "setCurrentStep = " + i + ", curThread=" + Thread.currentThread().getName());
            switch (i) {
                case 1:
                    WLogger.i("FaceVerifyStatus", "Preview status start");
                    this.m = 0;
                    this.h = 0;
                    this.b.h();
                    if (d.z().e().v()) {
                        WLogger.d("FaceVerifyStatus", "skip wait guide voice");
                        return;
                    }
                    long aa = d.z().e().aa();
                    new CloudFaceCountDownTimer(aa, aa / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                        public void onFinish() {
                            String str2;
                            WLogger.d("FaceVerifyStatus", "preview CountDownTimer onFinish");
                            if (FaceVerifyStatus.this.b() == 9) {
                                str2 = "Already finished!";
                            } else {
                                FaceVerifyStatus.this.b(2);
                                str2 = "preview CountDownTimer onFinish setCurrentStep(FaceVerifyStatus.Status.FINDFACE)";
                            }
                            WLogger.d("FaceVerifyStatus", str2);
                        }

                        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                        public void onTick(long j) {
                        }
                    }.start();
                    return;
                case 2:
                    this.m = 0;
                    this.h = 0;
                    this.d = System.currentTimeMillis();
                    WLogger.i("FaceVerifyStatus", "FINDFACE start at " + this.d);
                    this.b.i();
                    return;
                case 3:
                    this.m = 0;
                    this.h = 0;
                    this.d = System.currentTimeMillis();
                    this.b.j();
                    return;
                case 4:
                    this.b.k();
                    return;
                case 5:
                    this.b.l();
                    return;
                case 6:
                    this.b.m();
                    return;
                case 7:
                    WLogger.i("FaceVerifyStatus", "called outOfTime！");
                    this.b.n();
                    return;
                case 8:
                    this.b.o();
                    return;
                case 9:
                    this.b.p();
                    return;
                default:
                    return;
            }
        } else {
            str = "no flash res,CANT go to find face.Plz wait flashRes.";
        }
        WLogger.e("FaceVerifyStatus", str);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public int c() {
        return this.k;
    }

    public void c(int i) {
        if (this.g == null) {
            WLogger.d("FaceVerifyStatus", "setCurrentLiveCheck liveCheckProcess is null");
        } else if (this.f21909c > 4) {
            WLogger.e("FaceVerifyStatus", "curStatus=" + this.f21909c + ",no need to update live.");
        } else {
            this.f = i;
            if (i == 1) {
                this.g.e();
            } else if (i == 2) {
                this.m = 0;
                this.g.f();
            } else if (i != 3) {
            } else {
                this.g.g();
            }
        }
    }

    public void c(boolean z) {
        this.q = z;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.i;
    }

    public boolean f() {
        return this.n;
    }

    public boolean g() {
        return this.q;
    }

    public boolean h() {
        return this.o;
    }

    public boolean i() {
        return this.p;
    }

    public void j() {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus.2
            @Override // java.lang.Runnable
            public void run() {
                int length;
                FaceVerifyStatus faceVerifyStatus;
                int i;
                WLogger.d("FaceVerifyStatus", "checkNextLiveCheck");
                if (FaceVerifyStatus.this.e == null || FaceVerifyStatus.this.f21909c != 4 || (length = FaceVerifyStatus.this.e.length()) == 0) {
                    return;
                }
                WLogger.i("FaceVerifyStatus", "liveIndex=" + FaceVerifyStatus.this.h + "; counts=" + length);
                if (FaceVerifyStatus.this.h < length) {
                    int parseInt = Integer.parseInt(String.valueOf(FaceVerifyStatus.this.e.charAt(FaceVerifyStatus.this.h)));
                    FaceVerifyStatus.d(FaceVerifyStatus.this);
                    if (length - FaceVerifyStatus.this.h == 0) {
                        WLogger.d("FaceVerifyStatus", "last live check BEGIN!");
                    }
                    FaceVerifyStatus.this.c(parseInt);
                    return;
                }
                if (WbFaceModeProviders.isUseWillSdk()) {
                    WLogger.d("FaceVerifyStatus", "need WillExpress,goToWillExpress");
                    faceVerifyStatus = FaceVerifyStatus.this;
                    i = 5;
                } else {
                    WLogger.d("FaceVerifyStatus", "already finish live check,goToUpload");
                    faceVerifyStatus = FaceVerifyStatus.this;
                    i = 6;
                }
                faceVerifyStatus.b(i);
            }
        });
    }

    public void k() {
        int length;
        String str = this.j;
        if (str == null || (length = str.length()) == 0) {
            return;
        }
        WLogger.i("FaceVerifyStatus", "typeOrder is " + this.m + "; typeNums is " + length);
        int i = this.m;
        if (i >= length) {
            WLogger.d("FaceVerifyStatus", "last act detect END!");
            this.p = true;
            if (TextUtils.isEmpty(this.e) || !"2".equals(this.e) || !d.z().x().m() || this.q) {
                j();
                return;
            } else {
                d(4);
                return;
            }
        }
        int parseInt = Integer.parseInt(String.valueOf(this.j.charAt(i)));
        this.d = System.currentTimeMillis();
        d(parseInt);
        int i2 = this.m + 1;
        this.m = i2;
        if (length - i2 != 0) {
            this.o = false;
            return;
        }
        WLogger.d("FaceVerifyStatus", "last act detect BEGIN!isLastAct=" + this.o);
        this.o = true;
    }

    public void l() {
        if (this.f21909c == 2 || !this.f21908a) {
            return;
        }
        b(2);
    }
}
