package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.fl;
import com.huawei.hms.ads.fy;
import com.huawei.hms.ads.fz;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gm;
import com.huawei.hms.ads.gn;
import com.huawei.hms.ads.go;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.gr;
import com.huawei.hms.ads.gs;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.hc;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.jd;
import com.huawei.hms.ads.jp;
import com.huawei.hms.ads.kb;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.ku;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.le;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.inter.listeners.k;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView.class */
public class PPSLinkedView extends RelativeLayout implements hc.a, le {
    private static double F = 1.0E-7d;
    private List<View> A;
    private PPSSplashView E;
    private WindowManager G;
    private com.huawei.openalliance.ad.media.b H;
    private PPSSkipButton J;
    private ImageView K;
    private boolean M;
    private h N;
    private View O;
    private int P;
    private ViewStub Q;
    private View R;
    private View T;
    private int U;
    private boolean W;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private ValueAnimator aD;
    private boolean aE;
    private boolean aF;
    private int aG;
    private boolean aH;
    private Integer aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private int aN;
    private final String aO;
    private PPSSplashProView aP;
    private PPSSplashSwipeView aQ;
    private PPSSplashTwistView aR;
    private ku aS;
    private kt aT;
    private double aU;
    private double aV;
    private double aW;
    private float aX;
    private float aY;
    private long aZ;
    private long aa;
    private long ab;
    private long ac;
    private boolean ad;
    private boolean ae;
    private final String af;
    private int ag;
    private int ah;
    private float ai;
    private float aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private float ao;
    private float ap;
    private float aq;

    /* renamed from: ar  reason: collision with root package name */
    private int[] f23020ar;
    private boolean as;
    private boolean at;
    private k au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private boolean az;
    private int ba;
    private int bb;
    private int bc;
    private int bd;
    private WeakReference<Context> be;
    private int bf;
    private PPSSplashSwipeClickView bg;
    private PPSSplashTwistClickView bh;
    private boolean bi;
    private gt bj;
    private gr bk;
    private gp bl;
    private View.OnClickListener bm;
    private View.OnTouchListener bn;
    private View.OnTouchListener bo;
    private View.OnTouchListener bp;
    private View.OnTouchListener bq;
    private go br;
    private gs bs;
    private gn bt;
    private View.OnClickListener bu;

    /* renamed from: c  reason: collision with root package name */
    private ih f23021c;
    private m d;
    private PPSAdvertiserInfoDialog e;
    private Context f;
    private fk g;
    private PPSWLSView h;
    private PPSSplashAdSourceView i;
    private boolean j;
    private hc k;
    private l l;
    private gz m;
    private int n;
    private v o;
    private kb p;
    private g q;
    private e r;
    private f s;
    private gm t;
    private gs u;
    private SplashLinkedVideoView v;
    private com.huawei.openalliance.ad.views.d w;
    private LinkedSurfaceView x;
    private TextureGlVideoView y;
    private PPSDestView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$a.class */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSLinkedView> Code;
        private AdContentData V;

        public a(PPSLinkedView pPSLinkedView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSLinkedView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            final PPSLinkedView pPSLinkedView = this.Code.get();
            if (pPSLinkedView != null) {
                final int[] choiceViewLoc = pPSLinkedView.h.getChoiceViewLoc();
                final int[] choiceViewSize = pPSLinkedView.h.getChoiceViewSize();
                if (com.huawei.openalliance.ad.utils.v.Code(choiceViewLoc, 2) && com.huawei.openalliance.ad.utils.v.Code(choiceViewSize, 2)) {
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSLinkedView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$b.class */
    public static class b extends BroadcastReceiver {
        private WeakReference<PPSLinkedView> Code;

        public b(PPSLinkedView pPSLinkedView) {
            this.Code = new WeakReference<>(pPSLinkedView);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                PPSLinkedView pPSLinkedView = this.Code.get();
                if (pPSLinkedView == null) {
                    ge.I("PPSLinkedView", "view is null");
                    return;
                }
                v vVar = pPSLinkedView.o;
                l lVar = pPSLinkedView.l;
                k kVar = pPSLinkedView.au;
                if (!fz.Code.equals(intent.getAction())) {
                    if (!fz.V.equals(intent.getAction()) || vVar == null) {
                        return;
                    }
                    ge.V("PPSLinkedView", "LinkedSplashAdReceiver, progress resume %s  soundSwitch %s", Integer.valueOf(vVar.L()), vVar.a());
                    if (lVar != null) {
                        lVar.Code(vVar);
                    }
                    if (kVar != null) {
                        kVar.V(lVar);
                    }
                    fy.Code(context).V();
                    return;
                }
                int intExtra = intent.getIntExtra(fz.Z, 0);
                String stringExtra = intent.getStringExtra(fz.B);
                ge.V("PPSLinkedView", "LinkedSplashAdReceiver playProgress " + intExtra);
                if (vVar != null) {
                    vVar.Code(stringExtra);
                    vVar.Code(intExtra);
                }
            } catch (Throwable th) {
                ge.I("PPSLinkedView", "LinkedSplashAdReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$c.class */
    public class c implements kt.a {
        private c() {
        }

        private void Code(int i) {
            if (PPSLinkedView.this.aZ == 0) {
                PPSLinkedView.this.aZ = System.currentTimeMillis();
            } else if (PPSLinkedView.this.ba <= 2 || System.currentTimeMillis() - PPSLinkedView.this.aZ <= 1000) {
            } else {
                double d = i;
                if (PPSLinkedView.this.aU >= d || PPSLinkedView.this.aV >= d || PPSLinkedView.this.aW >= d) {
                    ge.V("PPSLinkedView", "limitDegree: %s X: %s Y: %s Z: %s", Integer.valueOf(i), Double.valueOf(PPSLinkedView.this.aU), Double.valueOf(PPSLinkedView.this.aV), Double.valueOf(PPSLinkedView.this.aW));
                    PPSLinkedView.this.aZ = System.currentTimeMillis();
                    PPSLinkedView.this.ba = 0;
                    PPSLinkedView.this.aT.V();
                    PPSLinkedView.this.aS.V();
                    PPSLinkedView.this.V(19);
                }
            }
        }

        @Override // com.huawei.hms.ads.kt.a
        public void Code(float f, float f2, float f3) {
            if (ge.Code()) {
                ge.Code("PPSLinkedView", "limitAcc: %s, xAcc: %s yAcc: %s zAcc: %s", Integer.valueOf(PPSLinkedView.this.bd), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            }
            if (Math.abs(f) >= PPSLinkedView.this.bd && PPSLinkedView.this.aX * f <= 0.0f) {
                PPSLinkedView.ae(PPSLinkedView.this);
                PPSLinkedView.this.aX = f;
            } else if (Math.abs(f2) >= PPSLinkedView.this.bd && PPSLinkedView.this.aY * f2 <= 0.0f) {
                PPSLinkedView.ae(PPSLinkedView.this);
                PPSLinkedView.this.aY = f2;
            }
            Code(PPSLinkedView.this.bc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$d.class */
    public class d implements ku.a {
        private int B;
        private int C;
        private Integer I;
        private int S;
        private Integer V;
        private Integer Z;

        private d() {
        }

        @Override // com.huawei.hms.ads.ku.a
        public void Code(double d, double d2, double d3) {
            ge.V("PPSLinkedView", "xDegree=%s, yDegree=%s, zDegree=%s", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
            if (this.V == null) {
                this.V = Integer.valueOf((int) d);
            }
            if (this.I == null) {
                this.I = Integer.valueOf((int) d2);
            }
            if (this.Z == null) {
                this.Z = Integer.valueOf((int) d3);
            }
            PPSLinkedView pPSLinkedView = PPSLinkedView.this;
            double abs = Math.abs(d - this.B);
            double abs2 = Math.abs(d - this.V.intValue());
            double d4 = abs2;
            if (abs > 180.0d) {
                d4 = 360.0d - abs2;
            }
            pPSLinkedView.aU = d4;
            PPSLinkedView.this.aV = Math.abs(d2 - ((double) this.C)) > 180.0d ? 360.0d - Math.abs(d2 - this.I.intValue()) : Math.abs(d - this.V.intValue());
            PPSLinkedView.this.aW = Math.abs(d3 - ((double) this.S)) > 180.0d ? 360.0d - Math.abs(d3 - this.Z.intValue()) : Math.abs(d - this.V.intValue());
            if (ge.Code()) {
                ge.Code("PPSLinkedView", "diffX: %s diffY: %s diffZ: %s", Double.valueOf(PPSLinkedView.this.aU), Double.valueOf(PPSLinkedView.this.aV), Double.valueOf(PPSLinkedView.this.aW));
            }
            this.B = (int) d;
            this.C = (int) d2;
            this.S = (int) d3;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$e.class */
    public interface e {
        void Code(int i);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$f.class */
    public interface f {
        void Code();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$g.class */
    public interface g {
        void Code(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLinkedView$h.class */
    public class h extends CountDownTimer {
        final /* synthetic */ PPSLinkedView Code;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ge.V("PPSLinkedView", "CountDownTimer onFinish");
            if (this.Code.am == 1) {
                this.Code.Code((Integer) 8, false);
                this.Code.aG = 2;
                ba.Code(this.Code.aO);
                if (this.Code.aB) {
                    return;
                }
                this.Code.t();
                this.Code.aB = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            ge.Code("PPSLinkedView", "onTick: %s", Long.valueOf(j));
        }
    }

    public PPSLinkedView(Context context) {
        super(context);
        this.f23021c = new hv();
        this.j = true;
        this.n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.ab = -1L;
        this.ad = false;
        this.ae = false;
        this.af = t.ah + hashCode();
        this.ag = 0;
        this.ah = 0;
        this.an = 3500;
        this.f23020ar = new int[2];
        this.as = false;
        this.at = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aE = false;
        this.aF = false;
        this.aH = true;
        this.aJ = true;
        this.aK = true;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = "skip_btn_delay_id_" + hashCode();
        this.bi = false;
        this.bj = new gt() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aL));
                if (PPSLinkedView.this.aL) {
                    return;
                }
                PPSLinkedView.this.aL = true;
                PPSLinkedView.this.v();
            }
        };
        this.bk = new gr() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
                if (i2 > 0 && !PPSLinkedView.this.aL) {
                    ge.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i2));
                    PPSLinkedView.this.aL = true;
                    PPSLinkedView.this.v();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.o.Code(i2);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i, i2);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.f23021c.Code(i);
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, i2, PPSLinkedView.this.o == null ? 0L : PPSLinkedView.this.o.I());
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ac = i;
                PPSLinkedView.this.aa = System.currentTimeMillis();
                if (!PPSLinkedView.this.bi) {
                    PPSLinkedView.this.p.Code(au.Code(Long.valueOf(PPSLinkedView.this.aa)));
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.aa);
                }
                if (PPSLinkedView.this.m != null) {
                    PPSLinkedView.this.m.Code(PPSLinkedView.this.aa);
                }
                if (i > 0) {
                    PPSLinkedView.this.p.S();
                    PPSLinkedView.this.f23021c.f();
                } else {
                    PPSLinkedView.this.p.C();
                    if (PPSLinkedView.this.f23021c != null && PPSLinkedView.this.o != null) {
                        ge.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f23021c.Code(PPSLinkedView.this.o.I(), true ^ "y".equals(PPSLinkedView.this.o.a()));
                    }
                }
                if (PPSLinkedView.this.l != null && PPSLinkedView.this.l.I()) {
                    eh.Code(PPSLinkedView.this.f, PPSLinkedView.this.l.m(), PPSLinkedView.this.l.D(), (System.currentTimeMillis() - PPSLinkedView.this.g.Q().longValue()) - PPSLinkedView.this.g.R(), PPSLinkedView.this.l.l(), "84");
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.I(i);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.V(i);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, true);
                PPSLinkedView.this.bi = true;
                if (PPSLinkedView.this.am == 2 && PPSLinkedView.this.k != null && PPSLinkedView.this.k.F()) {
                    ge.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.Code();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Z(i);
                }
                if (PPSLinkedView.this.p != null) {
                    long j = i;
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, j, j);
                }
            }
        };
        this.bl = new gp() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.hms.ads.gp
            public void Code(int i) {
                ge.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aF && PPSLinkedView.this.s != null) {
                    PPSLinkedView.this.aF = true;
                    PPSLinkedView.this.s.Code();
                }
                if (PPSLinkedView.this.aI == null) {
                    PPSLinkedView.this.aI = Integer.valueOf(i);
                    if (PPSLinkedView.this.l == null || PPSLinkedView.this.l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.l.C().V(i);
                }
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i) {
            }
        };
        this.bm = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                Tracker.onClick(view);
                if (PPSLinkedView.this.j) {
                    if (PPSLinkedView.this.am == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.j = false;
                    ge.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.am == 2) {
                        i = 10;
                    } else {
                        i = 2 == PPSLinkedView.this.aP.getMode() ? 17 : 9;
                        PPSLinkedView.this.l();
                    }
                    PPSLinkedView.this.V(i);
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bn = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            private float I;
            private float V;

            private boolean Code(float f2, float f3) {
                if (PPSLinkedView.this.bf != 0 || f3 < PPSLinkedView.this.bb) {
                    return 1 == PPSLinkedView.this.bf && Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) PPSLinkedView.this.bb);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.d = ky.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        PPSLinkedView.this.v.setOnTouchListener(null);
                        PPSLinkedView.this.V(18);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.bo = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.v.setOnTouchListener(null);
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = com.huawei.openalliance.ad.utils.i.Code(view, motionEvent);
                    PPSLinkedView.this.V(17);
                    return true;
                }
                return true;
            }
        };
        this.bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = ky.Code(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.br = new go() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                ge.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.as));
                PPSLinkedView.this.z();
                PPSLinkedView.this.A();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.t != null) {
                    ge.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.t.Code(i, i2, i3);
                }
            }
        };
        this.bs = new gs() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                ge.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.Code();
                }
                PPSLinkedView.this.f23021c.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                ge.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.V();
                }
                PPSLinkedView.this.f23021c.V(1.0f);
            }
        };
        this.bt = new gn() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                PPSLinkedView.this.f23021c.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PPSLinkedView.this.f23021c.c();
            }
        };
        this.bu = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23021c = new hv();
        this.j = true;
        this.n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.ab = -1L;
        this.ad = false;
        this.ae = false;
        this.af = t.ah + hashCode();
        this.ag = 0;
        this.ah = 0;
        this.an = 3500;
        this.f23020ar = new int[2];
        this.as = false;
        this.at = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aE = false;
        this.aF = false;
        this.aH = true;
        this.aJ = true;
        this.aK = true;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = "skip_btn_delay_id_" + hashCode();
        this.bi = false;
        this.bj = new gt() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aL));
                if (PPSLinkedView.this.aL) {
                    return;
                }
                PPSLinkedView.this.aL = true;
                PPSLinkedView.this.v();
            }
        };
        this.bk = new gr() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.hms.ads.gr
            public void Code(int i, int i2) {
                if (i2 > 0 && !PPSLinkedView.this.aL) {
                    ge.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i2));
                    PPSLinkedView.this.aL = true;
                    PPSLinkedView.this.v();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.o.Code(i2);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i, i2);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.f23021c.Code(i);
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, i2, PPSLinkedView.this.o == null ? 0L : PPSLinkedView.this.o.I());
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ac = i;
                PPSLinkedView.this.aa = System.currentTimeMillis();
                if (!PPSLinkedView.this.bi) {
                    PPSLinkedView.this.p.Code(au.Code(Long.valueOf(PPSLinkedView.this.aa)));
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.aa);
                }
                if (PPSLinkedView.this.m != null) {
                    PPSLinkedView.this.m.Code(PPSLinkedView.this.aa);
                }
                if (i > 0) {
                    PPSLinkedView.this.p.S();
                    PPSLinkedView.this.f23021c.f();
                } else {
                    PPSLinkedView.this.p.C();
                    if (PPSLinkedView.this.f23021c != null && PPSLinkedView.this.o != null) {
                        ge.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f23021c.Code(PPSLinkedView.this.o.I(), true ^ "y".equals(PPSLinkedView.this.o.a()));
                    }
                }
                if (PPSLinkedView.this.l != null && PPSLinkedView.this.l.I()) {
                    eh.Code(PPSLinkedView.this.f, PPSLinkedView.this.l.m(), PPSLinkedView.this.l.D(), (System.currentTimeMillis() - PPSLinkedView.this.g.Q().longValue()) - PPSLinkedView.this.g.R(), PPSLinkedView.this.l.l(), "84");
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.I(i);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.V(i);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i) {
                ge.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, true);
                PPSLinkedView.this.bi = true;
                if (PPSLinkedView.this.am == 2 && PPSLinkedView.this.k != null && PPSLinkedView.this.k.F()) {
                    ge.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.Code();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Z(i);
                }
                if (PPSLinkedView.this.p != null) {
                    long j = i;
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, j, j);
                }
            }
        };
        this.bl = new gp() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.hms.ads.gp
            public void Code(int i) {
                ge.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aF && PPSLinkedView.this.s != null) {
                    PPSLinkedView.this.aF = true;
                    PPSLinkedView.this.s.Code();
                }
                if (PPSLinkedView.this.aI == null) {
                    PPSLinkedView.this.aI = Integer.valueOf(i);
                    if (PPSLinkedView.this.l == null || PPSLinkedView.this.l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.l.C().V(i);
                }
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i) {
            }
        };
        this.bm = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                Tracker.onClick(view);
                if (PPSLinkedView.this.j) {
                    if (PPSLinkedView.this.am == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.j = false;
                    ge.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.am == 2) {
                        i = 10;
                    } else {
                        i = 2 == PPSLinkedView.this.aP.getMode() ? 17 : 9;
                        PPSLinkedView.this.l();
                    }
                    PPSLinkedView.this.V(i);
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bn = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            private float I;
            private float V;

            private boolean Code(float f2, float f3) {
                if (PPSLinkedView.this.bf != 0 || f3 < PPSLinkedView.this.bb) {
                    return 1 == PPSLinkedView.this.bf && Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) PPSLinkedView.this.bb);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.d = ky.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        PPSLinkedView.this.v.setOnTouchListener(null);
                        PPSLinkedView.this.V(18);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.bo = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.v.setOnTouchListener(null);
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = com.huawei.openalliance.ad.utils.i.Code(view, motionEvent);
                    PPSLinkedView.this.V(17);
                    return true;
                }
                return true;
            }
        };
        this.bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = ky.Code(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.br = new go() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i, int i2, int i3) {
                ge.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.as));
                PPSLinkedView.this.z();
                PPSLinkedView.this.A();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.t != null) {
                    ge.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.t.Code(i, i2, i3);
                }
            }
        };
        this.bs = new gs() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                ge.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.Code();
                }
                PPSLinkedView.this.f23021c.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                ge.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.V();
                }
                PPSLinkedView.this.f23021c.V(1.0f);
            }
        };
        this.bt = new gn() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                PPSLinkedView.this.f23021c.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PPSLinkedView.this.f23021c.c();
            }
        };
        this.bu = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23021c = new hv();
        this.j = true;
        this.n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.ab = -1L;
        this.ad = false;
        this.ae = false;
        this.af = t.ah + hashCode();
        this.ag = 0;
        this.ah = 0;
        this.an = 3500;
        this.f23020ar = new int[2];
        this.as = false;
        this.at = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aE = false;
        this.aF = false;
        this.aH = true;
        this.aJ = true;
        this.aK = true;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = "skip_btn_delay_id_" + hashCode();
        this.bi = false;
        this.bj = new gt() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // com.huawei.hms.ads.gt
            public void Code() {
                ge.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aL));
                if (PPSLinkedView.this.aL) {
                    return;
                }
                PPSLinkedView.this.aL = true;
                PPSLinkedView.this.v();
            }
        };
        this.bk = new gr() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.hms.ads.gr
            public void Code(int i2, int i22) {
                if (i22 > 0 && !PPSLinkedView.this.aL) {
                    ge.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i22));
                    PPSLinkedView.this.aL = true;
                    PPSLinkedView.this.v();
                }
                if (i22 > 0) {
                    PPSLinkedView.this.o.Code(i22);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i2, i22);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.f23021c.Code(i2);
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, i22, PPSLinkedView.this.o == null ? 0L : PPSLinkedView.this.o.I());
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i2));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ac = i2;
                PPSLinkedView.this.aa = System.currentTimeMillis();
                if (!PPSLinkedView.this.bi) {
                    PPSLinkedView.this.p.Code(au.Code(Long.valueOf(PPSLinkedView.this.aa)));
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.aa);
                }
                if (PPSLinkedView.this.m != null) {
                    PPSLinkedView.this.m.Code(PPSLinkedView.this.aa);
                }
                if (i2 > 0) {
                    PPSLinkedView.this.p.S();
                    PPSLinkedView.this.f23021c.f();
                } else {
                    PPSLinkedView.this.p.C();
                    if (PPSLinkedView.this.f23021c != null && PPSLinkedView.this.o != null) {
                        ge.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f23021c.Code(PPSLinkedView.this.o.I(), true ^ "y".equals(PPSLinkedView.this.o.a()));
                    }
                }
                if (PPSLinkedView.this.l != null && PPSLinkedView.this.l.I()) {
                    eh.Code(PPSLinkedView.this.f, PPSLinkedView.this.l.m(), PPSLinkedView.this.l.D(), (System.currentTimeMillis() - PPSLinkedView.this.g.Q().longValue()) - PPSLinkedView.this.g.R(), PPSLinkedView.this.l.l(), "84");
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i2);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void I(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.I(i2);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void V(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.V(i2);
                }
            }

            @Override // com.huawei.hms.ads.gr
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i2) {
                ge.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, true);
                PPSLinkedView.this.bi = true;
                if (PPSLinkedView.this.am == 2 && PPSLinkedView.this.k != null && PPSLinkedView.this.k.F()) {
                    ge.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.Code();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Z(i2);
                }
                if (PPSLinkedView.this.p != null) {
                    long j = i2;
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, j, j);
                }
            }
        };
        this.bl = new gp() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.hms.ads.gp
            public void Code(int i2) {
                ge.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aF && PPSLinkedView.this.s != null) {
                    PPSLinkedView.this.aF = true;
                    PPSLinkedView.this.s.Code();
                }
                if (PPSLinkedView.this.aI == null) {
                    PPSLinkedView.this.aI = Integer.valueOf(i2);
                    if (PPSLinkedView.this.l == null || PPSLinkedView.this.l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.l.C().V(i2);
                }
            }

            @Override // com.huawei.hms.ads.gp
            public void V(int i2) {
            }
        };
        this.bm = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2;
                Tracker.onClick(view);
                if (PPSLinkedView.this.j) {
                    if (PPSLinkedView.this.am == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.j = false;
                    ge.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.am == 2) {
                        i2 = 10;
                    } else {
                        i2 = 2 == PPSLinkedView.this.aP.getMode() ? 17 : 9;
                        PPSLinkedView.this.l();
                    }
                    PPSLinkedView.this.V(i2);
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bn = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            private float I;
            private float V;

            private boolean Code(float f2, float f3) {
                if (PPSLinkedView.this.bf != 0 || f3 < PPSLinkedView.this.bb) {
                    return 1 == PPSLinkedView.this.bf && Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) PPSLinkedView.this.bb);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.d = ky.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (ge.Code()) {
                        ge.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        PPSLinkedView.this.v.setOnTouchListener(null);
                        PPSLinkedView.this.V(18);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.bo = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.v.setOnTouchListener(null);
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = com.huawei.openalliance.ad.utils.i.Code(view, motionEvent);
                    PPSLinkedView.this.V(17);
                    return true;
                }
                return true;
            }
        };
        this.bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = ky.Code(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.br = new go() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // com.huawei.hms.ads.go
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i2, int i22, int i3) {
                ge.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.as));
                PPSLinkedView.this.z();
                PPSLinkedView.this.A();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.t != null) {
                    ge.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.t.Code(i2, i22, i3);
                }
            }
        };
        this.bs = new gs() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.hms.ads.gs
            public void Code() {
                ge.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.Code();
                }
                PPSLinkedView.this.f23021c.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gs
            public void V() {
                ge.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.V();
                }
                PPSLinkedView.this.f23021c.V(1.0f);
            }
        };
        this.bt = new gn() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.hms.ads.gn
            public void Code() {
                PPSLinkedView.this.f23021c.b();
            }

            @Override // com.huawei.hms.ads.gn
            public void Code(int i2) {
            }

            @Override // com.huawei.hms.ads.gn
            public void V() {
                PPSLinkedView.this.f23021c.c();
            }
        };
        this.bu = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        ge.V("PPSLinkedView", "reportDisplayError, adMediator: %s, linkedAdListener: %s", au.V(this.m), au.V(this.au));
        if (!this.aM && this.m != null) {
            ge.V("PPSLinkedView", "report display error. ");
            this.aM = true;
            this.m.I(-3);
            this.m.l();
        } else if (this.aM) {
        } else {
            ge.V("PPSLinkedView", "report fail to display. ");
            this.aM = true;
            I(-3);
        }
    }

    private String B(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private String C(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (3 == r10) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        if (4 == r11) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Integer Code(java.lang.Integer r8, int r9) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSLinkedView.Code(java.lang.Integer, int):java.lang.Integer");
    }

    private String Code(InteractCfg interactCfg) {
        return (interactCfg == null || interactCfg.a() == null) ? this.g.z() : interactCfg.a();
    }

    private void Code(int i) {
        int i2;
        if (i == 1) {
            i2 = 8;
        } else if (i != 2) {
            return;
        } else {
            i2 = 9;
        }
        Code(Integer.valueOf(i2), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        v vVar = this.o;
        if (vVar != null) {
            vVar.Code(z ? 0 : i);
        }
        if (this.W) {
            this.W = false;
            kb kbVar = this.p;
            long j = this.aa;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.ac;
            long j3 = i;
            if (z) {
                kbVar.Code(j, currentTimeMillis, j2, j3);
                this.f23021c.a();
            } else {
                kbVar.V(j, currentTimeMillis, j2, j3);
                this.f23021c.e();
            }
        }
        setPlaying(false);
    }

    private void Code(AdContentData adContentData) {
        if (adContentData.av() == null) {
            this.bb = fk.Code(getContext()).A();
            this.bd = fk.Code(getContext()).H();
            this.bc = fk.Code(getContext()).G();
            return;
        }
        InteractCfg av = adContentData.av();
        this.bb = (av.V() == null || av.V().intValue() <= 0) ? fk.Code(getContext()).A() : av.V().intValue();
        this.bd = (av.I() == null || av.I().intValue() <= 0) ? fk.Code(getContext()).H() : av.I().intValue();
        this.bc = (av.Z() == null || av.Z().intValue() <= 0) ? fk.Code(getContext()).G() : av.Z().intValue();
        this.bf = av.C().intValue();
    }

    private void Code(AdContentData adContentData, int i) {
        w();
        PPSSplashProView pPSSplashProView = this.aP;
        if (i == 0) {
            pPSSplashProView.setVisibility(4);
        } else {
            pPSSplashProView.setVisibility(0);
        }
        this.aP.setDesc(!TextUtils.isEmpty(this.g.x()) ? this.g.x() : adContentData.aq());
        this.aP.Code(false, i);
        this.v.setOnTouchListener(this.bq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (com.huawei.openalliance.ad.utils.v.Code(iArr, 2) && com.huawei.openalliance.ad.utils.v.Code(iArr2, 2) && adContentData != null) {
            if (ge.Code()) {
                ge.Code("PPSLinkedView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                ge.Code("PPSLinkedView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            this.e = pPSAdvertiserInfoDialog;
            this.v.addView(pPSAdvertiserInfoDialog, layoutParams);
            this.e.setScreenWidth(this.v.getMeasuredWidth());
            this.e.setScreenHeight(this.v.getMeasuredHeight());
            this.e.setAdContent(adContentData);
        }
    }

    private void Code(l lVar) {
        AdContentData ax;
        Integer I;
        if (this.aP == null || lVar == null || (ax = lVar.ax()) == null) {
            return;
        }
        int C = km.C(ax.r());
        int S = km.S(ax.r());
        ge.V("PPSLinkedView", "set splashpro mode:" + C);
        if (C == 0 || (I = I(ax)) == null) {
            this.aP.setVisibility(8);
        } else if (I.intValue() == 0) {
            Code(ax, S);
        } else {
            Code(ax);
            Code(false, I.intValue(), ax.av());
        }
        this.aP.setMode(C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        ge.Code("PPSLinkedView", "reportAdShowEvent. ");
        l lVar = this.l;
        if (lVar == null || lVar.ap()) {
            return;
        }
        if (!this.g.k()) {
            this.l.B(true);
            this.p.Code((Long) null, (Integer) null, num2, z);
        } else if (z || l.longValue() >= this.l.r()) {
            this.l.B(true);
            ge.Code("PPSLinkedView", "report imp. ");
            this.p.Code(l, num, num2, z);
        }
        this.f23021c.D();
    }

    private void Code(boolean z) {
        ge.V("PPSLinkedView", "moveLinkedView");
        if (o() && !this.as) {
            r();
            g gVar = this.q;
            if (gVar != null) {
                gVar.Code(this.aG);
            }
            if (z) {
                s();
            }
            this.as = true;
        }
    }

    private void Code(boolean z, int i, InteractCfg interactCfg) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        this.v.setOnClickListener(null);
        if (1 == i) {
            PPSSplashSwipeView pPSSplashSwipeView = this.aQ;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(0);
            this.aQ.Code(I(interactCfg), Code(interactCfg));
            this.aQ.setShowLogo(z);
            this.v.setOnTouchListener(this.bn);
        } else if (2 == i) {
            PPSSplashTwistView pPSSplashTwistView = this.aR;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(0);
            this.aR.Code(Z(interactCfg), V(interactCfg));
            this.aR.setShowLogo(z);
            this.v.setOnTouchListener(this.bo);
            x();
        } else if (3 != i) {
            if (4 != i || (pPSSplashSwipeClickView = this.bg) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(0);
            this.bg.Code(B(interactCfg), Code(interactCfg));
            this.bg.setShowLogo(z);
            this.v.setOnTouchListener(this.bn);
            this.bg.getClickAreaView().setOnTouchListener(this.bp);
        } else {
            PPSSplashTwistClickView pPSSplashTwistClickView = this.bh;
            if (pPSSplashTwistClickView == null) {
                return;
            }
            pPSSplashTwistClickView.setVisibility(0);
            this.bh.Code(C(interactCfg), V(interactCfg));
            this.bh.setShowLogo(z);
            this.v.setOnTouchListener(this.bo);
            this.bh.getClickAreaView().setOnTouchListener(this.bp);
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(m mVar) {
        PPSSplashProView pPSSplashProView = this.aP;
        if (pPSSplashProView == null || mVar == null) {
            return true;
        }
        int mode = pPSSplashProView.getMode();
        if (ge.Code()) {
            ge.Code("PPSLinkedView", "splashpro mode:" + mode);
        }
        if (1 == mode || mode == 0) {
            return true;
        }
        Rect rect = new Rect();
        this.aP.getHitRect(rect);
        boolean contains = rect.contains(mVar.Code().intValue(), mVar.V().intValue());
        ge.V("PPSLinkedView", "check result:" + contains);
        return contains;
    }

    private boolean Code(Long l) {
        if (l == null) {
            return false;
        }
        long ag = fk.Code(getContext()).ag();
        return ag == -1 || System.currentTimeMillis() < (ag * 86400000) + l.longValue();
    }

    private void E() {
        l lVar = this.l;
        if (lVar != null) {
            lVar.S(false);
        }
        this.l = null;
        this.E = null;
        this.O = null;
        this.T = null;
        LinkedSurfaceView linkedSurfaceView = this.x;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
        }
        TextureGlVideoView textureGlVideoView = this.y;
        if (textureGlVideoView != null) {
            textureGlVideoView.destroyView();
        }
        com.huawei.openalliance.ad.views.d dVar = this.w;
        if (dVar != null) {
            dVar.D();
        }
        setPlaying(false);
        J();
        ba.Code(this.aO);
        this.f23021c.I();
        com.huawei.openalliance.ad.inter.d.Code(this.f).Code(false);
    }

    private Integer I(AdContentData adContentData) {
        return Code(Integer.valueOf(V(adContentData)), km.C(adContentData.r()));
    }

    private String I(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.S();
        }
        return null;
    }

    private void I(int i) {
        k kVar = this.au;
        if (kVar != null) {
            kVar.Code(i);
        }
        Z(i);
    }

    private void J() {
        List<View> list = this.A;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.A) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void K() {
        if (this.M && this.K == null) {
            this.K = new ImageView(getContext());
            this.K.setImageResource(R.drawable.hiad_selector_ic_sound_check);
            ay.Code(this.K);
            Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_8_dp);
            this.K.setPadding(0, dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.hiad_page_margin_side), dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(21);
            layoutParams.rightMargin = resources.getDimensionPixelSize(R.dimen.haid_splash_sound_margin_right);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.haid_splash_sound_margin_bottom);
            layoutParams.bottomMargin += ay.I(getContext());
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(R.dimen.haid_splash_sound_margin_right));
            this.v.addView(this.K, layoutParams);
            this.K.bringToFront();
            this.K.setSelected(false);
            this.K.setOnClickListener(this.bu);
        }
    }

    private boolean M() {
        return this.aE;
    }

    private void N() {
        if (this.J != null) {
            ge.Code("PPSLinkedView", "%d delay, skip btn show", Integer.valueOf(this.aN));
            if (this.aN > 0) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSLinkedView.this.J != null) {
                            ge.Code("PPSLinkedView", "skip btn show");
                            PPSLinkedView.this.J.setVisibility(0);
                        }
                    }
                }, this.aO, this.aN);
                return;
            }
            ge.Code("PPSLinkedView", "skip btn show");
            this.J.setVisibility(0);
        }
    }

    private int V(AdContentData adContentData) {
        return (adContentData.av() == null || adContentData.av().Code() == null) ? this.g.w() : adContentData.av().Code().intValue();
    }

    private String V(InteractCfg interactCfg) {
        return (interactCfg == null || interactCfg.a() == null) ? this.g.E() : interactCfg.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i) {
        e eVar;
        fy.Code(getContext()).Code(new b(this));
        Code(this.am);
        if (this.p.Code(i, this.d)) {
            u();
            if (18 == i) {
                Context context = this.be.get();
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
                }
            }
        }
        this.d = null;
        this.f23021c.Code(jd.CLICK);
        int i2 = this.am;
        int i3 = 1;
        if (i2 == 1) {
            this.aG = 3;
            eVar = this.r;
            if (eVar == null) {
                return;
            }
        } else {
            i3 = 2;
            if (i2 != 2) {
                return;
            }
            this.aG = 4;
            eVar = this.r;
            if (eVar == null) {
                return;
            }
        }
        eVar.Code(i3);
    }

    private void V(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.g = fk.Code(applicationContext);
        this.p = new jp(this.f, this);
        this.G = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        this.aK = dt.Code(this.f).V();
    }

    private void V(l lVar) {
        ge.V("PPSLinkedView", "LinkedSplashAd:%s, isChinaRom:%s", lVar, Boolean.valueOf(this.aK));
        if (lVar != null) {
            Integer I = I(lVar.ax());
            InteractCfg av = lVar.ax().av();
            Integer B = av == null ? null : av.B();
            if (this.aK) {
                this.i.Code(I, B);
                this.i.setVisibility(0);
                this.i.Code(lVar.ax(), false, this.ag, 1, false);
                return;
            }
            this.h.setPpsLinkedView(this);
            this.h.Code(I, B);
            this.h.setVisibility(0);
            this.h.Code(lVar.ax(), false, this.ag, 1, false);
            if (aa.Code(lVar.aA())) {
                return;
            }
            this.h.setChoiceViewOnClickListener(new a(this, lVar.ax()));
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnClickListener(this.bm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z) {
        com.huawei.openalliance.ad.media.b bVar;
        v vVar;
        String str;
        ge.V("PPSLinkedView", "switchSound enableSound: " + z);
        if (this.x == null || (bVar = this.H) == null) {
            return;
        }
        if (z) {
            bVar.L();
            this.K.setSelected(true);
            vVar = this.o;
            if (vVar != null) {
                str = "y";
                vVar.Code(str);
            }
            this.p.Code(!z);
        }
        bVar.D();
        this.K.setSelected(false);
        vVar = this.o;
        if (vVar != null) {
            str = "n";
            vVar.Code(str);
        }
        this.p.Code(!z);
    }

    private String Z(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private void Z(int i) {
        String str;
        String str2;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        l lVar = this.l;
        if (lVar != null) {
            str = lVar.h_();
            str2 = this.l.m();
            AdContentData adContentData = new AdContentData();
            adContentData.Z(this.l.D());
            adContentData.F(this.l.h_());
            analysisEventReport.Code(adContentData);
        } else {
            str = null;
            str2 = null;
        }
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        com.huawei.openalliance.ad.ipc.g.V(this.f).Code("rptSplashFailedEvt", z.V(analysisEventReport), null, null);
    }

    static /* synthetic */ int ae(PPSLinkedView pPSLinkedView) {
        int i = pPSLinkedView.ba;
        pPSLinkedView.ba = i + 1;
        return i;
    }

    private void h() {
        ge.V("PPSLinkedView", "reportAdShowStartEvent");
        long j = this.aa;
        if (j <= 0) {
            j = com.huawei.openalliance.ad.utils.v.Code();
        }
        this.ae = false;
        String valueOf = String.valueOf(j);
        l lVar = this.l;
        if (lVar == null) {
            ge.I("PPSLinkedView", "linkedSplashAd is null! please register first");
            return;
        }
        lVar.m(valueOf);
        this.l.Code(j);
        this.l.B(false);
        this.l.S(true);
        if (!this.l.ak()) {
            this.l.Z(true);
        }
        this.p.Code(valueOf);
        this.p.Code(j);
        ge.Code("PPSLinkedView", "report showStart. ");
        this.p.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        ge.V("PPSLinkedView", "calculateScaleAndTrans");
        m();
        if (this.ai <= 0.0f || this.aj <= 0.0f) {
            ge.I("PPSLinkedView", "calculateScaleAndTrans, get screen size failed. ");
            A();
            D();
            return;
        }
        boolean F2 = ay.F(this.f);
        ge.V("PPSLinkedView", "calculateScaleAndTrans, MultiWindow:%s, screenHeight:%s,  screenWidth:%s", Boolean.valueOf(F2), Float.valueOf(this.ai), Float.valueOf(this.aj));
        this.z.getLocationOnScreen(this.f23020ar);
        this.ak = this.z.getHeight();
        this.al = this.z.getWidth();
        ge.V("PPSLinkedView", "calculateScaleAndTrans, destViewHeight:%s, destViewWidth:%s, locationX:%s, locationY:%s", Integer.valueOf(this.ak), Integer.valueOf(this.al), Integer.valueOf(this.f23020ar[0]), Integer.valueOf(this.f23020ar[1]));
        Point point = new Point();
        this.G.getDefaultDisplay().getRealSize(point);
        ge.Code("PPSLinkedView", "calculateScaleAndTrans, screenHeight:%s, point.y:%s", Float.valueOf(this.ai), Integer.valueOf(point.y));
        if (this.ag <= 0 && dt.Code(this.f).Code(this.f)) {
            this.ag = Math.max(this.ag, dt.Code(this.f).Code(this));
        }
        if ((point.y - this.ag) - this.ai > ay.C(this.f)) {
            this.ah = ay.S(getContext());
        } else {
            this.ah = 0;
        }
        ge.V("PPSLinkedView", "calculateScaleAndTrans, NotchEnable: %s, scrennHeight:%s, screenWidth:%s, navigationBarHeight:%s, notchHeight:%s", Boolean.valueOf(dt.Code(this.f).Code(this.f)), Float.valueOf(this.ai), Float.valueOf(this.aj), Integer.valueOf(this.ah), Integer.valueOf(this.ag));
        if (dt.Code(this.f).Code(this.f)) {
            int i = this.ak;
            if (F2) {
                float f7 = i;
                f5 = this.ai;
                int i2 = this.ag;
                this.ao = (f7 * 1.0f) / (i2 + f5);
                f4 = this.f23020ar[1] + ((i * 1.0f) / 2.0f);
                f6 = i2;
            } else {
                float f8 = i;
                float f9 = this.ai;
                int i3 = this.ag;
                float f10 = i3;
                int i4 = this.ah;
                this.ao = (f8 * 1.0f) / ((f10 + f9) + i4);
                f4 = this.f23020ar[1] + ((i * 1.0f) / 2.0f);
                f5 = f9 + i3;
                f6 = i4;
            }
            f3 = f4 - (((f5 + f6) * 1.0f) / 2.0f);
        } else {
            int i5 = this.ak;
            if (F2) {
                float f11 = i5;
                float f12 = this.ai;
                this.ao = (f11 * 1.0f) / f12;
                f2 = (this.f23020ar[1] + ((i5 * 1.0f) / 2.0f)) - ((f12 * 1.0f) / 2.0f);
            } else {
                float f13 = i5;
                int i6 = this.ah;
                float f14 = i6;
                float f15 = this.ai;
                this.ao = (f13 * 1.0f) / (f14 + f15);
                f2 = (this.f23020ar[1] + ((i5 * 1.0f) / 2.0f)) - (((f15 + i6) * 1.0f) / 2.0f);
            }
            f3 = f2 - this.ag;
        }
        this.ap = f3;
        this.aq = ((this.al * 1.0f) / this.aj) * 1.0f;
    }

    private void m() {
        DisplayMetrics displayMetrics = this.f.getResources().getDisplayMetrics();
        this.ai = displayMetrics.heightPixels;
        this.aj = displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ge.V("PPSLinkedView", "switchViewOnAnimationEnd. ");
        Code(this.aJ);
        if (ge.Code()) {
            ge.Code("PPSLinkedView", "isMoved: %s, linkedAdListener on switch: %s ", Boolean.valueOf(this.as), this.au);
        }
        if (this.au == null) {
            ge.I("PPSLinkedView", "linkedAdListener is null. ");
            return;
        }
        ge.Code("PPSLinkedView", "splash show end. ");
        this.au.V();
    }

    private boolean o() {
        boolean p = p();
        boolean q = q();
        if (p || q) {
            ge.I("PPSLinkedView", "checkDestView, destView change null, linkedAdListener: %s, isMoved:%s. ", au.V(this.au), Boolean.valueOf(this.as));
            ge.V("PPSLinkedView", "isDestViewNull:%s, isDestViewNotAvalible:%s", Boolean.valueOf(p), Boolean.valueOf(q));
            if (!this.aM) {
                this.aM = true;
                I(-5);
                k kVar = this.au;
                if (kVar != null) {
                    kVar.V();
                }
            }
            if (this.as) {
                return false;
            }
            this.as = true;
            this.am = 0;
            TextureGlVideoView textureGlVideoView = this.y;
            if (textureGlVideoView != null) {
                textureGlVideoView.L();
                this.y.destroyView();
            }
            setPlaying(false);
            r();
            J();
            g gVar = this.q;
            if (gVar != null) {
                gVar.Code(this.aG);
                return false;
            }
            return false;
        }
        return true;
    }

    private boolean p() {
        PPSDestView pPSDestView = this.z;
        return pPSDestView == null || pPSDestView.getHeight() == 0 || this.z.getWidth() == 0;
    }

    private boolean q() {
        TextureGlVideoView textureGlVideoView = this.y;
        return textureGlVideoView == null || !textureGlVideoView.h();
    }

    private void r() {
        ge.V("PPSLinkedView", "removeSplashView");
        SplashLinkedVideoView splashLinkedVideoView = this.v;
        if (splashLinkedVideoView != null) {
            splashLinkedVideoView.setVisibility(8);
            this.v.V();
        }
        LinkedSurfaceView linkedSurfaceView = this.x;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
            com.huawei.openalliance.ad.views.d dVar = this.w;
            if (dVar != null) {
                dVar.V(this.x);
            }
            this.x = null;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.17
            @Override // java.lang.Runnable
            public void run() {
                if (PPSLinkedView.this.v != null) {
                    if (PPSLinkedView.this.v.isAttachedToWindow()) {
                        PPSLinkedView.this.G.removeView(PPSLinkedView.this.v);
                    }
                    PPSLinkedView.this.v.I();
                    PPSLinkedView.this.v = null;
                }
            }
        }, 20L);
        PPSSplashProView pPSSplashProView = this.aP;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.aQ;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        ku kuVar = this.aS;
        if (kuVar != null) {
            kuVar.V();
        }
        kt ktVar = this.aT;
        if (ktVar != null) {
            ktVar.V();
        }
    }

    private void s() {
        ge.V("PPSLinkedView", "addMonitor");
        hc hcVar = new hc(this, this);
        this.k = hcVar;
        hcVar.D();
        l lVar = this.l;
        if (lVar != null) {
            this.k.V(lVar.r(), this.l.s());
        }
        this.k.Code(this.l);
    }

    private void setDestViewClickable(PPSDestView pPSDestView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pPSDestView);
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(boolean z) {
        this.aE = z;
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.am() <= 0) {
            return;
        }
        this.aN = adContentData.am();
    }

    private void setSplashViewClickable(SplashLinkedVideoView splashLinkedVideoView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(splashLinkedVideoView);
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ge.V("PPSLinkedView", "startScaleDown. ");
        u();
        if (!o()) {
            if (this.at || this.ab == -1) {
                return;
            }
            this.p.Code(System.currentTimeMillis() - this.ab, 100);
            this.ab = -1L;
            return;
        }
        this.aC = true;
        l();
        this.v.setClickable(false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aD = ofFloat;
        ofFloat.setInterpolator(new fl(0.4f, 0.0f, 0.2f, 1.0f));
        this.aD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float animatedFraction = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.ao - 1.0f)) + 1.0f;
                    float animatedFraction2 = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.aq - 1.0f)) + 1.0f;
                    PPSLinkedView.this.x.Code(animatedFraction, valueAnimator.getAnimatedFraction() * PPSLinkedView.this.ap, animatedFraction2, (int) (PPSLinkedView.this.aj * animatedFraction2), (int) (PPSLinkedView.this.ai * animatedFraction));
                } catch (Throwable th) {
                    ge.V("PPSLinkedView", "scaleAndTransAnimation err: %s", th.getClass().getSimpleName());
                }
            }
        });
        this.aD.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.19
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LinkedSurfaceView linkedSurfaceView;
                float floatValue;
                float f2;
                int i;
                int i2;
                ge.V("PPSLinkedView", "onAnimationEnd");
                try {
                    if (PPSLinkedView.this.ak > 0 && PPSLinkedView.this.o != null) {
                        if (PPSLinkedView.this.o.g().floatValue() < 1.0f) {
                            linkedSurfaceView = PPSLinkedView.this.x;
                            floatValue = (PPSLinkedView.this.al * 1.0f) / (PPSLinkedView.this.ak * 1.0f);
                            f2 = (PPSLinkedView.this.al * 1.0f) / (PPSLinkedView.this.ak * 1.0f);
                            i = PPSLinkedView.this.al;
                            i2 = PPSLinkedView.this.ak;
                        } else {
                            linkedSurfaceView = PPSLinkedView.this.x;
                            floatValue = PPSLinkedView.this.o.g().floatValue();
                            f2 = (PPSLinkedView.this.al * 1.0f) / (PPSLinkedView.this.ak * 1.0f);
                            i = PPSLinkedView.this.al;
                            i2 = PPSLinkedView.this.ak;
                        }
                        linkedSurfaceView.Code(floatValue, f2, i, i2);
                    }
                    PPSLinkedView.this.n();
                    PPSLinkedView.this.am = 2;
                } catch (Throwable th) {
                    ge.V("PPSLinkedView", "onAnimationEnd err: %s", th.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ge.V("PPSLinkedView", "onAnimationStart");
                if (PPSLinkedView.this.e != null) {
                    PPSLinkedView.this.e.setVisibility(8);
                }
                if (PPSLinkedView.this.K != null) {
                    PPSLinkedView.this.K.setVisibility(8);
                }
                if (PPSLinkedView.this.J != null) {
                    PPSLinkedView.this.J.setVisibility(8);
                }
                if (PPSLinkedView.this.i != null) {
                    PPSLinkedView.this.i.setVisibility(8);
                }
                if (PPSLinkedView.this.h != null) {
                    PPSLinkedView.this.h.setVisibility(8);
                }
                if (PPSLinkedView.this.R != null) {
                    PPSLinkedView.this.R.setVisibility(8);
                }
                if (PPSLinkedView.this.aP != null) {
                    PPSLinkedView.this.aP.setVisibility(8);
                    PPSLinkedView.this.aP.Code();
                }
                if (PPSLinkedView.this.aQ != null) {
                    PPSLinkedView.this.aQ.setVisibility(8);
                    PPSLinkedView.this.aQ.V();
                }
                if (PPSLinkedView.this.aR != null) {
                    PPSLinkedView.this.aR.setVisibility(8);
                }
                if (PPSLinkedView.this.bh != null) {
                    PPSLinkedView.this.bh.setVisibility(8);
                }
                if (PPSLinkedView.this.bg != null) {
                    PPSLinkedView.this.bg.setVisibility(8);
                }
                if (PPSLinkedView.this.v != null) {
                    PPSLinkedView.this.v.setOnTouchListener(null);
                }
                if (PPSLinkedView.this.aS != null) {
                    PPSLinkedView.this.aS.V();
                }
                if (PPSLinkedView.this.aT != null) {
                    PPSLinkedView.this.aT.V();
                }
            }
        });
        this.aD.setDuration(1000L).start();
    }

    private void u() {
        h hVar = this.N;
        if (hVar != null) {
            hVar.cancel();
            this.N = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (!this.ad) {
            this.ad = true;
            l lVar = this.l;
            if (lVar != null && lVar.I()) {
                com.huawei.openalliance.ad.ipc.d.Code(getContext()).Code("dismissSlogan", null, null, null);
            }
            this.ab = System.currentTimeMillis();
            h();
            if (!this.g.k()) {
                Code((Long) null, (Integer) null, (Integer) 8, false);
                this.at = true;
            }
            if (this.am == 1) {
                N();
                K();
                V(this.l);
                y();
                Code(this.l);
            }
        }
        View view = this.O;
        if (view != null) {
            view.setVisibility(8);
            this.O = null;
        }
        if (this.E != null) {
            ge.Code("PPSLinkedView", "PPSSplashView is not null. ");
            this.E.setVisibility(8);
            this.E = null;
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setVisibility(8);
            this.T = null;
        }
    }

    private void w() {
        int y = this.g.y();
        if (y > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aP.getLayoutParams();
            int V = com.huawei.openalliance.ad.utils.v.V(getContext(), y);
            this.aP.setPadding(V, V, V, V);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - V);
                layoutParams.setMarginEnd(layoutParams.rightMargin - V);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - V, layoutParams.topMargin, layoutParams.rightMargin - V, layoutParams.bottomMargin);
            }
            this.aP.setLayoutParams(layoutParams);
        }
    }

    private void x() {
        ku kuVar = new ku(getContext());
        this.aS = kuVar;
        kuVar.Code(new d());
        this.aS.Code();
        kt ktVar = new kt(getContext());
        this.aT = ktVar;
        ktVar.Code(new c());
        this.aT.Code();
    }

    private void y() {
        String str;
        try {
            if (this.R == null) {
                View inflate = this.Q.inflate();
                this.R = inflate;
                inflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (this.ag > 0) {
                ge.Code("PPSLinkedView", "left:%s, top:%s, right:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.ag, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.R.setLayoutParams(layoutParams);
            }
            ImageView imageView = (ImageView) this.R.findViewById(R.id.hiad_full_mode_logo);
            if (this.P > 0) {
                imageView.setImageResource(this.P);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) this.R.findViewById(R.id.hiad_media_name);
            if (this.U <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(this.U);
            textView.setVisibility(0);
        } catch (Resources.NotFoundException e2) {
            str = "showFullModeLogo res not found";
            ge.I("PPSLinkedView", str);
        } catch (Exception e3) {
            str = "showFullModeLogo " + e3.getClass().getSimpleName();
            ge.I("PPSLinkedView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.am != 1 || this.as) {
            return;
        }
        this.as = true;
        u();
        this.am = 0;
        TextureGlVideoView textureGlVideoView = this.y;
        if (textureGlVideoView != null) {
            textureGlVideoView.L();
            this.y.destroyView();
        }
        setPlaying(false);
        r();
        com.huawei.openalliance.ad.views.d dVar = this.w;
        if (dVar != null) {
            dVar.D();
        }
        this.E = null;
        this.O = null;
        this.T = null;
        J();
        PPSSplashProView pPSSplashProView = this.aP;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        if (this.at || !this.W) {
            return;
        }
        ge.Code("PPSLinkedView", "report imp and phyImp on splash. ");
        this.p.Code(System.currentTimeMillis() - this.aa, 100);
        Code((Integer) 8, false);
    }

    @Override // com.huawei.hms.ads.hc.a
    public void B() {
        ge.V("PPSLinkedView", "onViewShownBetweenFullAndPartial: ");
        if (this.y == null || this.H == null) {
            return;
        }
        ge.V("PPSLinkedView", "onViewShownBetweenFullAndPartial, start mute");
        this.H.D();
        this.H.e();
        v vVar = this.o;
        if (vVar != null) {
            vVar.Code("n");
        }
    }

    @Override // com.huawei.hms.ads.hc.a
    public void Code() {
        ge.V("PPSLinkedView", "onViewShowStartRecord");
        l lVar = this.l;
        if (lVar == null || !this.as) {
            return;
        }
        ge.Code("PPSLinkedView", "ad.getMinEffectiveShowTime: %s. ", Long.valueOf(lVar.r()));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSLinkedView pPSLinkedView;
                Long valueOf;
                Integer valueOf2;
                int i;
                l lVar2 = PPSLinkedView.this.l;
                if (lVar2 != null) {
                    if (PPSLinkedView.this.am == 2) {
                        pPSLinkedView = PPSLinkedView.this;
                        valueOf = Long.valueOf(lVar2.r());
                        valueOf2 = Integer.valueOf(PPSLinkedView.this.k.B());
                        i = 9;
                    } else {
                        pPSLinkedView = PPSLinkedView.this;
                        valueOf = Long.valueOf(lVar2.r());
                        valueOf2 = Integer.valueOf(PPSLinkedView.this.k.B());
                        i = 8;
                    }
                    pPSLinkedView.Code(valueOf, valueOf2, Integer.valueOf(i), false);
                }
            }
        }, this.af, lVar.r());
    }

    @Override // com.huawei.hms.ads.hc.a
    public void Code(long j, int i) {
        ge.V("PPSLinkedView", "onViewShowEndRecord");
        ba.Code(this.af);
        if (!this.k.Code(j) || this.ae) {
            return;
        }
        this.ae = true;
        Code(Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.am == 2 ? 9 : 8), false);
    }

    public void Code(Integer num, boolean z) {
        ge.Code("PPSLinkedView", "reportSplashAdShowEvent. ");
        Code(Long.valueOf(System.currentTimeMillis() - this.aa), (Integer) 100, num, z);
    }

    public void D() {
        ge.V("PPSLinkedView", "unregister. ");
        E();
    }

    @Override // com.huawei.hms.ads.hc.a
    public void I() {
        v vVar;
        com.huawei.openalliance.ad.media.b bVar;
        long j;
        ge.V("PPSLinkedView", "onViewFullShown: ");
        if (this.y == null || (vVar = this.o) == null || this.H == null) {
            return;
        }
        int L = vVar.L();
        if (M()) {
            return;
        }
        ge.V("PPSLinkedView", "onViewFullShown, start play, duration: %s, playProgress: %s", this.aI, Integer.valueOf(L));
        this.H.I(L);
        this.H.Code();
        setPlaying(true);
        Integer num = this.aI;
        if (num == null || Math.abs(num.intValue() - L) >= 1000) {
            bVar = this.H;
            j = L;
        } else {
            ge.V("PPSLinkedView", "onViewFullShown, seek to 0");
            bVar = this.H;
            j = 0;
        }
        bVar.Code(j, 3);
    }

    @Override // com.huawei.hms.ads.hc.a
    public void V() {
        l lVar;
        ge.V("PPSLinkedView", "onViewPhysicalShowStart");
        if (!this.as || (lVar = this.l) == null || lVar.av()) {
            return;
        }
        h();
    }

    @Override // com.huawei.hms.ads.hc.a
    public void V(long j, int i) {
        ge.V("PPSLinkedView", "onViewPhysicalShowEnd: ");
        ba.Code(this.af);
        l lVar = this.l;
        if (lVar != null) {
            lVar.S(false);
        }
        if (this.y != null) {
            ge.V("PPSLinkedView", "onViewPhysicalShowEnd, start pause. ");
            this.H.Z();
            this.H.e();
            setPlaying(false);
        }
        ge.Code("PPSLinkedView", "onViewPhysicalShowEnd, noPhyImp: %s. ", Boolean.valueOf(this.at));
        if (this.at || i <= 0) {
            return;
        }
        ge.Code("PPSLinkedView", "report phyImp. ");
        if (this.ab == -1) {
            this.p.Code(j, i);
            return;
        }
        this.p.Code(System.currentTimeMillis() - this.ab, i);
        this.ab = -1L;
    }

    @Override // com.huawei.hms.ads.hc.a
    public void Z() {
        ge.V("PPSLinkedView", "onViewPartialHidden: ");
        if (this.y == null || this.H == null) {
            return;
        }
        ge.V("PPSLinkedView", "onViewPartialHidden, start pause");
        this.H.D();
        v vVar = this.o;
        if (vVar != null) {
            vVar.Code("n");
        }
        this.H.Z();
        this.H.e();
        setPlaying(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (ky.Code(motionEvent) == 0) {
                this.d = ky.Code(this, motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            ge.I("PPSLinkedView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
            return false;
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        ge.V("PPSLinkedView", "onApplyWindowInsets, sdk: %s", Integer.valueOf(Build.VERSION.SDK_INT));
        if (ay.V() && windowInsets != null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                if (!aa.Code(boundingRects)) {
                    this.ag = boundingRects.get(0).height();
                }
            } else {
                ge.V("PPSLinkedView", "DisplayCutout is null");
            }
        }
        if (this.ag <= 0 && Build.VERSION.SDK_INT >= 26 && dt.Code(this.f).Code(getContext())) {
            this.ag = Math.max(this.ag, dt.Code(this.f).Code(this));
        }
        ge.V("PPSLinkedView", "notchHeight:" + this.ag);
        return super.onApplyWindowInsets(windowInsets);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ge.Code("PPSLinkedView", "onAttachedToWindow");
        hc hcVar = this.k;
        if (hcVar != null) {
            hcVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ge.Code("PPSLinkedView", "onDetechedFromWindow");
        hc hcVar = this.k;
        if (hcVar != null) {
            hcVar.L();
        }
        ba.Code(this.aO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ge.Code("PPSLinkedView", "onVisibilityChanged:");
        hc hcVar = this.k;
        if (hcVar != null) {
            hcVar.a();
        }
    }

    public void setLinkedAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        ge.V("PPSLinkedView", "setLinkedAdActionListener. ");
        kb kbVar = this.p;
        if (kbVar != null) {
            kbVar.Code(aVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z) {
        this.aH = z;
    }

    public void setOnLinkedAdClickListener(e eVar) {
        this.r = eVar;
    }

    public void setOnLinkedAdPreparedListener(f fVar) {
        this.s = fVar;
    }

    public void setOnLinkedAdSwitchListener(g gVar) {
        this.q = gVar;
    }
}
