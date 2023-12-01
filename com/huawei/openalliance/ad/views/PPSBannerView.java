package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.banner.R;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.he;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.ir;
import com.huawei.hms.ads.is;
import com.huawei.hms.ads.jh;
import com.huawei.hms.ads.jx;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.lc;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.t;
import com.huawei.openalliance.ad.inter.listeners.m;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBannerView.class */
public class PPSBannerView extends RelativeLayout implements hr, lc {
    private String A;
    private ImageView E;
    private final byte[] G;
    private boolean H;
    private String J;
    private b K;
    private a M;
    private int N;
    private List<String> O;
    private String P;
    private String Q;
    private RequestOptions R;
    private Location T;
    private t U;
    Handler V;
    private Integer W;
    private float aa;
    private RewardVerifyConfig ab;
    private he ac;
    private jx d;
    private long e;
    private long f;
    private String g;
    private com.huawei.openalliance.ad.inter.listeners.c h;
    private m i;
    private com.huawei.openalliance.ad.inter.data.b j;
    private PPSNativeView k;
    private PPSNativeView l;
    private ImageView m;
    private ImageView n;
    private ChoicesView o;
    private CusWhyThisAdView p;
    private ImageView q;
    private boolean r;
    private LinearLayout s;
    private PPSLabelView t;
    private TextView u;
    private AutoScaleSizeRelativeLayout v;
    private com.huawei.openalliance.ad.inter.data.g w;
    private com.huawei.openalliance.ad.inter.data.g x;
    private int y;
    private fk z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBannerView$a.class */
    public enum a {
        STARTED,
        PAUSED,
        RESUMED,
        DESTROYED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBannerView$b.class */
    public enum b {
        IDLE,
        LOADING
    }

    public PPSBannerView(Context context) {
        super(context);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.y = 0;
        this.G = new byte[0];
        this.H = true;
        this.K = b.IDLE;
        this.M = a.STARTED;
        this.N = 0;
        this.aa = 0.05f;
        this.ac = new he(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                ge.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.b();
                PPSBannerView.this.f();
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i) {
                ge.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.c();
                PPSBannerView.this.g();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    PPSBannerView.this.Code();
                } else if (i != 1001) {
                } else {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.w, (List<String>) null);
                }
            }
        };
        Code(context);
    }

    public PPSBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.y = 0;
        this.G = new byte[0];
        this.H = true;
        this.K = b.IDLE;
        this.M = a.STARTED;
        this.N = 0;
        this.aa = 0.05f;
        this.ac = new he(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                ge.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.b();
                PPSBannerView.this.f();
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i) {
                ge.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.c();
                PPSBannerView.this.g();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    PPSBannerView.this.Code();
                } else if (i != 1001) {
                } else {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.w, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    public PPSBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.r = true;
        this.y = 0;
        this.G = new byte[0];
        this.H = true;
        this.K = b.IDLE;
        this.M = a.STARTED;
        this.N = 0;
        this.aa = 0.05f;
        this.ac = new he(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                ge.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.b();
                PPSBannerView.this.f();
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i2) {
                ge.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.c();
                PPSBannerView.this.g();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    PPSBannerView.this.Code();
                } else if (i2 != 1001) {
                } else {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.w, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    private long Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        long j = 0;
        long j2 = 0;
        if (gVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long e = gVar.e();
            if (currentTimeMillis < e) {
                j = e - currentTimeMillis;
            }
            ge.Code("PPSBannerView", "calcAdLeftTime,currentTime:" + currentTimeMillis + ",expireTime:" + e + ",leftTime:" + j);
            j2 = j;
        }
        return j2;
    }

    private void Code(int i, int i2) {
        com.huawei.openalliance.ad.inter.listeners.c cVar = this.h;
        if (cVar == null) {
            return;
        }
        if (i == 0) {
            cVar.F();
        } else if (i == 1) {
            cVar.Code(i2);
        } else if (i != 2) {
        } else {
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        r5.Code(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Code(int r4, com.huawei.openalliance.ad.inter.data.g r5, java.util.List<java.lang.String> r6) {
        /*
            r3 = this;
            r0 = r3
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r0 = r0.v
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L73
            r0 = r4
            if (r0 == 0) goto L34
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L24
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L1c
            goto L59
        L1c:
            r0 = r3
            r1 = r5
            r0.I(r1)
            goto L59
        L24:
            r0 = r7
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L59
            r0 = r3
            r1 = r5
            r0.V(r1)
            goto L59
        L34:
            r0 = r3
            int r0 = r0.y
            r1 = 1
            int r0 = r0 - r1
            r1 = 2
            int r0 = r0 % r1
            if (r0 != 0) goto L4b
            r0 = r3
            com.huawei.openalliance.ad.views.PPSNativeView r0 = r0.k
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L59
            goto L54
        L4b:
            r0 = r3
            com.huawei.openalliance.ad.views.PPSNativeView r0 = r0.l
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L59
        L54:
            r0 = r5
            r1 = r6
            r0.Code(r1)
        L59:
            r0 = r3
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r0 = r0.v
            r1 = 8
            r0.setVisibility(r1)
            r0 = r3
            com.huawei.hms.ads.he r0 = r0.ac
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L6f
            r0 = r5
            r0.onGlobalLayout()
        L6f:
            r0 = r3
            r0.S()
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSBannerView.Code(int, com.huawei.openalliance.ad.inter.data.g, java.util.List):void");
    }

    private void Code(Context context) {
        this.d = new jh(context, this);
        fk Code = fk.Code(context);
        this.z = Code;
        this.aa = Code.s();
        V(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Code(android.graphics.drawable.Drawable r6) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSBannerView.Code(android.graphics.drawable.Drawable):void");
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        com.huawei.openalliance.ad.inter.data.b bVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PPSBannerView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    String string = obtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_adId);
                    if (string != null && !string.isEmpty()) {
                        this.g = string;
                    }
                    String string2 = obtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        if (string2.equals("BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.Code;
                        } else if (string2.equals("LARGE_BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.V;
                        }
                        this.j = bVar;
                    }
                } catch (RuntimeException e) {
                    str = "initDefAttr " + e.getClass().getSimpleName();
                    ge.I("PPSBannerView", str);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    str = "initDefAttr " + th.getClass().getSimpleName();
                    ge.I("PPSBannerView", str);
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void Code(final PPSNativeView pPSNativeView) {
        pPSNativeView.setOnNativeAdImpressionListener(new PPSNativeView.c() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.c
            public void Code() {
                pPSNativeView.setAdContainerSizeMatched(PPSBannerView.this.W == com.huawei.openalliance.ad.constant.t.aI ? PPSBannerView.this.H : PPSBannerView.this.d.Code(PPSBannerView.this.j, PPSBannerView.this.aa) ? "1" : "0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, int i, int i2) {
        ge.Code("PPSBannerView", "notifyResult isRefreshAd:%s,resultType:%s", Boolean.valueOf(z), Integer.valueOf(i));
        Code(i, i2);
        if (z) {
            return;
        }
        c();
    }

    private boolean Code(String str, List<String> list) {
        ge.Code("PPSBannerView", "invalidcontentIds is %s", list);
        ge.Code("PPSBannerView", "currentContentId is %s", str);
        return (TextUtils.isEmpty(str) || list == null || list.isEmpty() || !list.contains(str)) ? false : true;
    }

    private void D() {
        ge.Code("PPSBannerView", "initChoicesView start");
        if (this.o == null) {
            ChoicesView choicesView = new ChoicesView(getContext());
            this.o = choicesView;
            choicesView.setId(R.id.hiad_choice_view);
            this.v.addView(this.o);
        }
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (PPSBannerView.this.p != null) {
                    PPSBannerView.this.L();
                    PPSBannerView.this.p.V();
                } else if ((PPSBannerView.this.w instanceof n) && (PPSBannerView.this.w instanceof n)) {
                    n nVar = (n) PPSBannerView.this.w;
                    String h = nVar.h();
                    String str = h;
                    if (TextUtils.isEmpty(h)) {
                        str = nVar.g();
                    }
                    v.Code(PPSBannerView.this.getContext(), str);
                }
                PPSBannerView.this.o.setVisibility(8);
            }
        });
        if (com.huawei.openalliance.ad.inter.data.b.Code == getBannerSize()) {
            this.o.V();
            this.o.Code(R.dimen.hiad_banner_choice_view_size);
        }
    }

    private void F() {
        if (this.E == null) {
            return;
        }
        ge.V("PPSBannerView", "init compliance activity");
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (PPSBannerView.this.w == null || !(PPSBannerView.this.w instanceof n)) {
                    return;
                }
                ComplianceActivity.Code(PPSBannerView.this.getContext(), view, ((n) PPSBannerView.this.w).l(), false);
            }
        });
    }

    private void I(long j) {
        Handler handler = this.V;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.V.removeMessages(1000);
        }
        if (getBannerVisibility() == 4 || getBannerState() == a.PAUSED || getBannerState() == a.DESTROYED) {
            ge.V("PPSBannerView", "stopRefreshAd");
        } else if (0 != j) {
            ge.V("PPSBannerView", "start refreshAd ad will be refreshed in %s", Long.valueOf(j));
            this.V.sendEmptyMessageDelayed(1000, j * 1000);
        }
    }

    private void I(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.d == null || gVar == null) {
            return;
        }
        ge.Code("PPSBannerView", "reportAdCancelled");
        this.d.Code(com.huawei.openalliance.ad.beans.inner.a.V, gVar, 0L);
    }

    private void I(PPSNativeView pPSNativeView) {
        if (this.i == null) {
            return;
        }
        pPSNativeView.setOnNativeAdClickListener(new PPSNativeView.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.8
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
            public void Code(View view) {
                PPSBannerView.this.i.D();
            }
        });
        pPSNativeView.setOnNativeAdStatusTrackingListener(new PPSNativeView.e() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.9
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void B() {
                PPSBannerView.this.i.c();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void I() {
                PPSBannerView.this.i.a();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void V() {
                PPSBannerView.this.i.L();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void Z() {
                PPSBannerView.this.i.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        CusWhyThisAdView cusWhyThisAdView = this.p;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null && (viewGroup instanceof ViewGroup)) {
                setChildrenViewsInVisible(viewGroup);
            }
            this.p.setVisibility(0);
        }
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.v;
        if (autoScaleSizeRelativeLayout != null) {
            autoScaleSizeRelativeLayout.setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private long V(long j) {
        fk fkVar;
        if (0 == j || (fkVar = this.z) == null) {
            return 0L;
        }
        long n = fkVar.n();
        long p = this.z.p();
        if (ge.Code()) {
            ge.Code("PPSBannerView", "setBannerRefresh,minInterval:%s,maxInterval:%s", Long.valueOf(n), Long.valueOf(p));
        }
        if (n > p) {
            return 0L;
        }
        return j < n ? n : Math.min(j, p);
    }

    private void V(Context context) {
        inflate(context, R.layout.hiad_view_banner_ad, this);
        this.k = (PPSNativeView) findViewById(R.id.hiad_banner_layout_1);
        this.l = (PPSNativeView) findViewById(R.id.hiad_banner_layout_2);
        this.m = (ImageView) findViewById(R.id.hiad_banner_image_1);
        this.n = (ImageView) findViewById(R.id.hiad_banner_image_2);
        this.s = (LinearLayout) findViewById(R.id.custom_ad_bg_layout);
        this.t = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.u = (TextView) findViewById(R.id.hiad_ad_source);
        this.E = (ImageView) findViewById(R.id.compliance_icon_banner);
        this.v = (AutoScaleSizeRelativeLayout) findViewById(R.id.hiad_banner_ad);
        setAdViewParam(context);
        this.v.setVisibility(8);
        boolean V = dt.Code(context).V();
        this.r = V;
        ge.Code("PPSBannerView", "isChinaRom = %s", Boolean.valueOf(V));
        if (this.r) {
            ImageView imageView = (ImageView) findViewById(R.id.hiad_banner_close_button);
            this.q = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(0, pPSBannerView.w, (List<String>) null);
                    PPSBannerView pPSBannerView2 = PPSBannerView.this;
                    pPSBannerView2.Code(pPSBannerView2.d(), 2, 0);
                }
            });
        } else {
            a();
            D();
            F();
        }
        Code(this.k);
        Code(this.l);
    }

    private void V(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.d == null || gVar == null) {
            return;
        }
        ge.Code("PPSBannerView", "reportAdExpire");
        this.d.Code(com.huawei.openalliance.ad.beans.inner.a.Code, gVar, gVar.e());
    }

    private void V(PPSNativeView pPSNativeView) {
        is adSessionAgent = pPSNativeView.getAdSessionAgent();
        if (adSessionAgent != null) {
            adSessionAgent.Code(this.q, ir.CLOSE_AD, null);
            adSessionAgent.Code(this.t, ir.OTHER, null);
            adSessionAgent.Code(this.u, ir.OTHER, null);
            adSessionAgent.Code(this.o, ir.OTHER, null);
            adSessionAgent.Code(this.p, ir.OTHER, null);
        }
    }

    private void a() {
        if (this.p != null) {
            ge.Code("PPSBannerView", "SDK-banner cusWhyView is not null");
            return;
        }
        CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this.v);
        this.p = cusWhyThisAdView;
        cusWhyThisAdView.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.7
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                if (PPSBannerView.this.k != null) {
                    PPSBannerView.this.k.setVisibility(8);
                }
                if (PPSBannerView.this.l != null) {
                    PPSBannerView.this.l.setVisibility(8);
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                ArrayList arrayList;
                if (PPSBannerView.this.k != null) {
                    PPSBannerView.this.k.setVisibility(8);
                }
                if (PPSBannerView.this.l != null) {
                    PPSBannerView.this.l.setVisibility(8);
                }
                ArrayList arrayList2 = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList2.add(str);
                    arrayList = arrayList2;
                }
                PPSBannerView pPSBannerView = PPSBannerView.this;
                pPSBannerView.Code(0, pPSBannerView.w, arrayList);
                PPSBannerView pPSBannerView2 = PPSBannerView.this;
                pPSBannerView2.Code(pPSBannerView2.d(), 2, 0);
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSBannerView.this.w == null) {
                    return null;
                }
                return PPSBannerView.this.w.n();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSBannerView.this.w instanceof n) {
                    n nVar = (n) PPSBannerView.this.w;
                    String h = nVar.h();
                    String str = h;
                    if (TextUtils.isEmpty(h)) {
                        str = nVar.g();
                    }
                    v.Code(PPSBannerView.this.getContext(), str);
                }
            }
        });
        this.v.addView(this.p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.p.getLayoutParams());
        layoutParams.addRule(13);
        this.p.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        long j = this.e;
        if (j == 0) {
            j = this.f;
        }
        I(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1000)) {
            return;
        }
        ge.V("PPSBannerView", "stopRefreshAd");
        this.V.removeMessages(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.e > 0 || this.f > 0;
    }

    private void e() {
        ge.V("PPSBannerView", "hide activity");
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bb.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.V == null || this.w == null || d()) {
            return;
        }
        if (this.V.hasMessages(1001)) {
            this.V.removeMessages(1001);
        }
        ge.Code("PPSBannerView", "start closeAdWhenExpire");
        this.V.sendEmptyMessageDelayed(1001, Code(this.w));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1001)) {
            return;
        }
        ge.Code("PPSBannerView", "stopCloseAdWhenExpire");
        this.V.removeMessages(1001);
    }

    private b getAdLoadState() {
        b bVar;
        synchronized (this.G) {
            bVar = this.K;
        }
        return bVar;
    }

    private int getBannerVisibility() {
        int i;
        synchronized (this.G) {
            i = this.N;
        }
        return i;
    }

    private void setAdLoadState(b bVar) {
        synchronized (this.G) {
            this.K = bVar;
        }
    }

    private void setAdViewParam(Context context) {
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.v;
        if (autoScaleSizeRelativeLayout == null || this.j == null || context == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) autoScaleSizeRelativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.v.setLayoutParams(layoutParams);
        this.v.setRatio(Float.valueOf((this.j.Code() * 1.0f) / this.j.V()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBannerVisibility(int i) {
        synchronized (this.G) {
            this.N = i;
        }
    }

    private void setChildrenViewsInVisible(View view) {
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            viewGroup.getChildAt(i2).setVisibility(4);
            i = i2 + 1;
        }
    }

    private void setChoiceViewPosition(int i) {
        ge.Code("PPSBannerView", "bannerView option = %s", Integer.valueOf(i));
        if (this.o == null) {
            ge.Code("PPSBannerView", "choicesView is null, error");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.o.getLayoutParams());
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.hiad_banner_choice_custom_margin);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.hiad_banner_choice_custom_margin);
        if (i != 0) {
            if (i == 2) {
                layoutParams.addRule(12);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, 0, dimensionPixelOffset, dimensionPixelOffset2);
            } else if (i == 3) {
                layoutParams.addRule(12);
                layoutParams.addRule(20);
                layoutParams.setMargins(dimensionPixelOffset, 0, 0, dimensionPixelOffset2);
            } else if (i == 4) {
                this.o.setVisibility(8);
                this.o.setLayoutParams(layoutParams);
                this.o.bringToFront();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, dimensionPixelOffset2, dimensionPixelOffset, 0);
            }
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.o.setLayoutParams(layoutParams);
            this.o.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset2, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.o.setLayoutParams(layoutParams);
        this.o.bringToFront();
    }

    @Override // com.huawei.hms.ads.lc
    public void B() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.w;
        eh.Code(getContext(), gVar instanceof n ? ((n) gVar).h_() : "", this.g, 8, 499, "Fail to display ad because of missing presentation material");
    }

    public boolean C() {
        return getAdLoadState() == b.LOADING;
    }

    public void Code() {
        int i = 1;
        if (!this.d.B()) {
            Code(d(), 1, 1001);
        } else if (getAdLoadState() != b.IDLE) {
            ge.I("PPSBannerView", "ad is loading now!");
            Code(d(), 1, 701);
        } else {
            setAdLoadState(b.LOADING);
            ArrayList arrayList = new ArrayList();
            String str = this.P;
            if (str == null || str.isEmpty()) {
                arrayList = null;
            } else {
                arrayList.add(this.P);
            }
            this.d.Code(this.T);
            this.d.Code(this.R);
            this.d.Code(this.U);
            this.d.Code(this.W);
            this.d.V(Integer.valueOf(this.j.Code()));
            this.d.I(Integer.valueOf(this.j.V()));
            this.d.V(this.J);
            if (this.e == 0) {
                i = 0;
            }
            this.d.Code(this.g, 8, arrayList, i);
            b();
        }
    }

    @Override // com.huawei.hms.ads.lc
    public void Code(int i) {
        ge.Code("PPSBannerView", "onReqAdFail ");
        if (Code(this.P, this.O)) {
            Code(2, this.w, (List<String>) null);
            Code(false, 1, 705);
        } else {
            Code(d(), 1, i);
        }
        setAdLoadState(b.IDLE);
    }

    @Override // com.huawei.hms.ads.lc
    public void Code(long j) {
        this.f = V(j);
        b();
    }

    @Override // com.huawei.hms.ads.lc
    public void Code(Drawable drawable, com.huawei.openalliance.ad.inter.data.g gVar) {
        if (drawable == null || gVar == null) {
            Code(d(), 1, 499);
            ge.I("PPSBannerView", "onAdContentLoaded,content is null");
        } else {
            this.w = gVar;
            this.A = gVar.c();
            this.P = gVar.D();
            if (0 == Code(gVar)) {
                V(gVar);
                ge.Code("PPSBannerView", "do not show ad due to ad expired");
                Code(false, 1, 704);
                if (Code(this.Q, this.O)) {
                    Code(2, this.x, (List<String>) null);
                }
            } else if (Code(this.P, this.O)) {
                ge.Code("PPSBannerView", "do not show ad due to ad cancelled");
                I(gVar);
                Code(false, 1, 705);
            } else {
                e();
                Code(drawable);
                Code(d(), 0, 0);
                f();
            }
            this.Q = this.P;
            this.x = gVar;
        }
        setAdLoadState(b.IDLE);
    }

    @Override // com.huawei.hms.ads.lc
    public void Code(List<String> list) {
        this.O = list;
    }

    public void I() {
        if (getBannerState() == a.DESTROYED) {
            ge.V("PPSBannerView", "hasDestroyed");
            return;
        }
        ge.V("PPSBannerView", com.anythink.expressad.foundation.d.c.cb);
        setBannerState(a.PAUSED);
        c();
    }

    public void S() {
        PPSNativeView pPSNativeView = this.k;
        if (pPSNativeView != null) {
            pPSNativeView.S();
        }
        PPSNativeView pPSNativeView2 = this.l;
        if (pPSNativeView2 != null) {
            pPSNativeView2.S();
        }
    }

    public void V() {
        ge.V("PPSBannerView", "destroy");
        setBannerState(a.DESTROYED);
        c();
        g();
        this.V = null;
    }

    public void Z() {
        if (getBannerState() == a.DESTROYED) {
            ge.V("PPSBannerView", "hasDestroyed");
            return;
        }
        ge.V("PPSBannerView", "resume");
        setBannerState(a.RESUMED);
        b();
    }

    public String getAdId() {
        return this.g;
    }

    public long getBannerRefresh() {
        return this.e;
    }

    public com.huawei.openalliance.ad.inter.data.b getBannerSize() {
        return this.j;
    }

    public a getBannerState() {
        a aVar;
        synchronized (this.G) {
            aVar = this.M;
        }
        return aVar;
    }

    public Integer getIsSmart() {
        return this.W;
    }

    public Location getLocation() {
        return this.T;
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    public RequestOptions getRequestOptions() {
        return this.R;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        he heVar = this.ac;
        if (heVar != null) {
            heVar.D();
        }
        kl.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        he heVar = this.ac;
        if (heVar != null) {
            heVar.L();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        he heVar = this.ac;
        if (heVar != null) {
            heVar.a();
        }
    }

    public void setAdContainerSizeMatched(boolean z) {
        this.H = z;
    }

    public void setAdId(String str) {
        this.g = str;
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.c cVar) {
        this.h = cVar;
    }

    public void setBannerRefresh(long j) {
        long V = V(j);
        this.e = V;
        ge.V("PPSBannerView", "setBannerRefresh:%s", Long.valueOf(V));
    }

    public void setBannerSize(com.huawei.openalliance.ad.inter.data.b bVar) {
        this.j = bVar;
        setAdViewParam(getContext());
    }

    public void setBannerState(a aVar) {
        synchronized (this.G) {
            this.M = aVar;
        }
    }

    public void setContentBundle(String str) {
        this.J = str;
    }

    public void setIsSmart(Integer num) {
        this.W = num;
    }

    public void setLocation(Location location) {
        this.T = location;
    }

    public void setOnBannerAdStatusTrackingListener(m mVar) {
        this.i = mVar;
    }

    public void setRequestOptions(RequestOptions requestOptions) {
        this.R = requestOptions;
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.ab = rewardVerifyConfig;
    }

    public void setTargetingInfo(t tVar) {
        this.U = tVar;
    }
}
