package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.he;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.jd;
import com.huawei.hms.ads.kd;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.lj;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.utils.ba;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBaseView.class */
public abstract class PPSBaseView<P extends kd> extends RelativeLayout implements lj {
    protected P B;
    protected ih C;
    protected gz D;
    protected int F;
    protected AdContentData S;

    /* renamed from: a  reason: collision with root package name */
    private boolean f9407a;
    private Long b;

    /* renamed from: c  reason: collision with root package name */
    private View f9408c;
    private kt d;
    private int l;
    private int m;
    private int n;
    private int o;
    private m p;
    private he q;
    private View.OnTouchListener r;
    private View.OnTouchListener s;
    private View.OnTouchListener t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBaseView$a.class */
    public class a implements kt.a {
        private a() {
        }

        @Override // com.huawei.hms.ads.kt.a
        public void Code(float f, float f2, float f3) {
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (ge.Code()) {
                ge.Code("PPSBaseView", "accLimitNew: %s, xAcc: %s yAcc: %s zAcc: %s, sqrtAcc: %s", Integer.valueOf(PPSBaseView.this.n), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(sqrt));
            }
            if (PPSBaseView.this.b == null || sqrt < PPSBaseView.this.n) {
                return;
            }
            ge.V("PPSBaseView", "meet, accLimitNew: %s, sqrtAcc: %s", Integer.valueOf(PPSBaseView.this.n), Float.valueOf(sqrt));
            PPSBaseView.this.d.V();
            PPSBaseView.this.B.Code(0, 0, PPSBaseView.this.S, PPSBaseView.this.b, null, 19);
            PPSBaseView.this.C.Code(jd.CLICK);
        }
    }

    public PPSBaseView(Context context) {
        super(context);
        this.C = new hv();
        this.f9407a = false;
        this.b = null;
        this.q = new he(this) { // from class: com.huawei.openalliance.ad.views.PPSBaseView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                if (PPSBaseView.this.D != null) {
                    PPSBaseView.this.D.D();
                }
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i) {
                PPSBaseView.this.S();
                if (PPSBaseView.this.b == null) {
                    ge.I("PPSBaseView", "onViewShowEnd - no adShowStartTime");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = PPSBaseView.this.b.longValue();
                if (PPSBaseView.this.B != null) {
                    PPSBaseView.this.B.Code(PPSBaseView.this.S, currentTimeMillis - longValue, 100);
                    PPSBaseView.this.B.B();
                }
                PPSBaseView.this.b = null;
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSBaseView.this.C.I();
                    }
                }, 150L);
            }
        };
        this.r = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PPSBaseView.this.Code(view, motionEvent);
            }
        };
        this.s = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.3
            private float I;
            private float V;

            private boolean Code(float f, float f2) {
                if (PPSBaseView.this.o != 0 || f2 < PPSBaseView.this.l) {
                    return 1 == PPSBaseView.this.o && Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) PPSBaseView.this.l);
                }
                return true;
            }

            private boolean Code(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSBaseView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSBaseView pPSBaseView = PPSBaseView.this;
                    pPSBaseView.p = com.huawei.openalliance.ad.utils.i.Code(pPSBaseView, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSBaseView", " endX= %s, endY = %s, startX - endX= %s, startY - endY= %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        PPSBaseView.this.setOnTouchListener(null);
                        PPSBaseView.this.B.Code(0, 0, PPSBaseView.this.S, PPSBaseView.this.b, PPSBaseView.this.p, 18);
                        PPSBaseView.this.p = null;
                        PPSBaseView.this.C.Code(jd.CLICK);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return Code(motionEvent);
            }
        };
        this.t = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        setOnTouchListener(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            setOnTouchListener(null);
            view.setEnabled(false);
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (ge.Code()) {
                ge.Code("PPSBaseView", "touch down image x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
            }
            this.B.Code((int) rawX, (int) rawY, this.S, this.b, com.huawei.openalliance.ad.utils.i.Code(view, motionEvent), 2 == km.C(this.S.r()) ? 17 : 7);
            this.C.Code(jd.CLICK);
            return true;
        }
        return true;
    }

    private void L() {
        kt ktVar = new kt(getContext());
        this.d = ktVar;
        ktVar.Code(new a());
        this.d.Code();
    }

    @Override // com.huawei.hms.ads.lj
    public void B() {
        this.D.S();
    }

    @Override // com.huawei.hms.ads.lj
    public boolean C() {
        return false;
    }

    public void Code() {
        this.D.l();
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(int i) {
        this.D.V(i);
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(int i, int i2) {
        ge.V("PPSBaseView", "user click skip button");
        this.B.Code(i, i2, this.b);
        this.C.d();
        this.C.I();
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(View view, Integer num) {
        this.f9408c = view;
        if (view != null) {
            view.setOnTouchListener(this.r);
        }
        AdContentData adContentData = this.S;
        String r = adContentData == null ? null : adContentData.r();
        int C = km.C(r);
        if (ge.Code()) {
            ge.Code("PPSBaseView", "ctrlswitch:%s", r);
            ge.Code("PPSBaseView", "splashpro mode:%s, splashInteractCfg: %s", Integer.valueOf(C), num);
        }
        if (C == 2) {
            setOnTouchListener(null);
            if (num == null) {
                return;
            }
            if (1 == num.intValue() || 4 == num.intValue()) {
                setOnTouchListener(this.s);
                if (this.f9408c == null || 1 != num.intValue()) {
                    return;
                }
                this.f9408c.setOnTouchListener(null);
            } else if (2 == num.intValue() || 3 == num.intValue()) {
                setOnTouchListener(this.t);
                L();
                if (this.f9408c == null || 2 != num.intValue()) {
                    return;
                }
                this.f9408c.setOnTouchListener(null);
            }
        }
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(ih ihVar) {
        if (ihVar != null) {
            this.C = ihVar;
        }
    }

    @Override // com.huawei.hms.ads.lj
    public void D() {
        P p = this.B;
        if (p != null) {
            p.V(this.b);
        }
    }

    @Override // com.huawei.hms.ads.lj
    public void F() {
        P p = this.B;
        if (p != null) {
            p.Code(this.b);
        }
    }

    @Override // com.huawei.hms.ads.lj
    public void I(int i) {
        this.D.C(i);
    }

    protected void S() {
    }

    @Override // com.huawei.hms.ads.lj
    public void V() {
        ge.V("PPSBaseView", "show ad");
        this.B.Code(this.S);
    }

    public void V(int i) {
        this.D.I(i);
    }

    @Override // com.huawei.hms.ads.lj
    public void Z() {
        ge.V("PPSBaseView", "notifyAdLoaded");
        this.f9407a = true;
        this.b = Long.valueOf(System.currentTimeMillis());
        this.D.Code(this.S);
    }

    @Override // com.huawei.hms.ads.ls
    public void destroyView() {
        kt ktVar = this.d;
        if (ktVar != null) {
            ktVar.V();
        }
    }

    @Override // com.huawei.hms.ads.lj
    public gz getAdMediator() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        he heVar = this.q;
        if (heVar != null) {
            heVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ge.V("PPSBaseView", "detached from window");
        he heVar = this.q;
        if (heVar != null) {
            heVar.L();
        }
        this.C.I();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        he heVar = this.q;
        if (heVar != null) {
            heVar.a();
        }
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
    }

    @Override // com.huawei.hms.ads.lj
    public void setAdContent(AdContentData adContentData) {
        this.S = adContentData;
        if (adContentData.av() == null) {
            this.l = fk.Code(getContext()).A();
            this.n = fk.Code(getContext()).H();
            this.m = fk.Code(getContext()).G();
            return;
        }
        InteractCfg av = adContentData.av();
        this.l = (av.V() == null || av.V().intValue() <= 0) ? fk.Code(getContext()).A() : av.V().intValue();
        this.n = (av.I() == null || av.I().intValue() <= 0) ? fk.Code(getContext()).H() : av.I().intValue();
        this.m = (av.Z() == null || av.Z().intValue() <= 0) ? fk.Code(getContext()).G() : av.Z().intValue();
        this.o = av.C().intValue();
    }

    @Override // com.huawei.hms.ads.lj
    public void setAdMediator(gz gzVar) {
        this.D = gzVar;
    }

    @Override // com.huawei.hms.ads.lj
    public void setAudioFocusType(int i) {
    }

    @Override // com.huawei.hms.ads.lj
    public void setDisplayDuration(int i) {
        this.F = i;
    }
}
