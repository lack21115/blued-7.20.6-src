package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.dn;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ep;
import com.huawei.hms.ads.fy;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.hv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.ir;
import com.huawei.hms.ads.is;
import com.huawei.hms.ads.jd;
import com.huawei.hms.ads.jl;
import com.huawei.hms.ads.jy;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.kz;
import com.huawei.hms.ads.la;
import com.huawei.hms.ads.lb;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.lt;
import com.huawei.hms.ads.nativead.DislikeAdListener;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.activity.FeedbackActivity;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSNativeView.class */
public class PPSNativeView extends RelativeLayout implements ha, hr, lf {
    private jy B;
    private hb C;
    protected ih Code;
    private ChoicesView D;
    private View F;
    private boolean I;
    private int L;
    private n S;

    /* renamed from: a  reason: collision with root package name */
    private CusWhyThisAdView f9414a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private b f9415c;
    private d d;
    private e e;
    private c f;
    private la g;
    private lb h;
    private kz i;
    private List<View> j;
    private boolean k;
    private final String l;
    private boolean m;
    private boolean n;
    private DislikeAdListener o;
    private String p;
    private String q;
    private m r;
    private CusWhyThisAdView.a s;
    private is t;
    private AdFeedbackListener u;
    private IRemoteCreator v;
    private dn w;
    private View x;
    private ImageView y;
    private View.OnClickListener z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSNativeView$a.class */
    public static class a implements AdFeedbackListener {
        private final WeakReference<PPSNativeView> Code;

        public a(PPSNativeView pPSNativeView) {
            this.Code = new WeakReference<>(pPSNativeView);
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            PPSNativeView pPSNativeView = this.Code.get();
            if (pPSNativeView != null) {
                pPSNativeView.o();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSNativeView$b.class */
    public interface b {
        void Code(View view);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSNativeView$c.class */
    public interface c {
        void Code();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSNativeView$d.class */
    public interface d {
        void Code();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSNativeView$e.class */
    public interface e {
        void B();

        void I();

        void V();

        void Z();
    }

    public PPSNativeView(Context context) {
        super(context);
        this.I = true;
        this.Code = new hv();
        this.k = false;
        this.l = t.ah + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSNativeView.this.Code(view, 7);
            }
        };
        Code(context);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = true;
        this.Code = new hv();
        this.k = false;
        this.l = t.ah + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSNativeView.this.Code(view, 7);
            }
        };
        Code(context);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = true;
        this.Code = new hv();
        this.k = false;
        this.l = t.ah + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSNativeView.this.Code(view, 7);
            }
        };
        Code(context);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = true;
        this.Code = new hv();
        this.k = false;
        this.l = t.ah + hashCode();
        this.m = false;
        this.s = CusWhyThisAdView.a.NONE;
        this.z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PPSNativeView.this.Code(view, 7);
            }
        };
    }

    private void Code(Context context) {
        this.B = new jl(context, this);
        this.C = new hb(this, this);
        boolean V = dt.Code(context).V();
        this.b = V;
        if (V) {
            return;
        }
        L();
    }

    private void Code(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null || !(viewGroup instanceof ViewGroup)) {
            return;
        }
        viewGroup.removeView(view);
    }

    private void Code(ih ihVar, n nVar) {
        la laVar = this.g;
        if (laVar instanceof NativeVideoView) {
            ((NativeVideoView) laVar).Code(ihVar, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        n nVar = this.S;
        if (nVar == null || nVar.R()) {
            return;
        }
        e eVar = this.e;
        if (eVar != null) {
            eVar.B();
        }
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.D();
        }
        c cVar = this.f;
        if (cVar != null) {
            cVar.Code();
        }
        this.S.Z(true);
        this.B.Code(l, num, num2, z);
    }

    private void L() {
        ge.Code("PPSNativeView", "initChoicesView start");
        if (this.D == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_choices_wrapper, (ViewGroup) null);
            this.F = inflate;
            this.D = (ChoicesView) inflate.findViewById(R.id.hiad_choices_icon);
            this.y = (ImageView) this.F.findViewById(R.id.compliance_icon);
            addView(this.F);
            View view = this.F;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        setChoiceViewPosition(1);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (PPSNativeView.this.Code() || PPSNativeView.this.S == null) {
                    return;
                }
                if (PPSNativeView.this.S.l() == null) {
                    ge.V("PPSNativeView", "adInfo is null");
                } else if (aa.Code(PPSNativeView.this.S.l().aG())) {
                    com.huawei.openalliance.ad.utils.c.Code(PPSNativeView.this.getContext(), PPSNativeView.this.S);
                } else {
                    ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.S.l(), true);
                }
            }
        });
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (PPSNativeView.this.n || PPSNativeView.this.S == null) {
                    return;
                }
                ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.S.l(), false);
            }
        });
    }

    private void V(Context context) {
        ge.V("PPSNativeView", "showV3Ad");
        IRemoteCreator Code = com.huawei.hms.ads.f.Code(getContext().getApplicationContext());
        this.v = Code;
        if (Code == null) {
            ge.V("PPSNativeView", "Creator is null");
            return;
        }
        this.w = new dn(context, this, this.S);
        String V = z.V(this.S.l());
        Bundle bundle = new Bundle();
        bundle.putBinder("context", (IBinder) ObjectWrapper.wrap(getContext()));
        bundle.putString("content", V);
        try {
            View view = (View) ObjectWrapper.unwrap(this.v.newNativeTemplateView(bundle, this.w));
            this.x = view;
            if (view == null) {
                ge.I("PPSNativeView", "templateView is null");
                return;
            }
            this.Code = null;
            removeAllViews();
            addView(this.x);
            this.v.bindData(ObjectWrapper.wrap(this.x), V);
        } catch (Throwable th) {
            ge.I("PPSNativeView", "create newNativeTemplateView err: %s", th.getClass().getSimpleName());
        }
    }

    private void V(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.bringToFront();
    }

    private void V(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= viewGroup.getChildCount()) {
                return;
            }
            viewGroup.getChildAt(i3).setVisibility(i);
            i2 = i3 + 1;
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof NativeVideoView) {
                ((NativeVideoView) view).setCoverClickListener(this.z);
            } else if (view != null) {
                view.setOnClickListener(this.z);
            }
        }
    }

    private void a() {
        ge.Code("PPSNativeView", "update choiceView start.");
        if (this.D == null) {
            ge.Code("PPSNativeView", "do not need update choiceView");
            return;
        }
        if (this.f9414a == null) {
            Z();
        }
        if (!this.n && this.f9414a != null) {
            ge.Code("PPSNativeView", "cusWhyView is not null, set choiceView as close.");
            this.D.V();
        } else if (TextUtils.isEmpty(this.p)) {
        } else {
            ge.Code("PPSNativeView", "update choiceView.");
            if (TextUtils.isEmpty(this.q)) {
                this.D.I();
            } else {
                this.D.setAdChoiceIcon(this.q);
            }
        }
    }

    private boolean b() {
        if (this.S.ai() == null || 3 != this.S.ai().intValue()) {
            return false;
        }
        V(getContext().getApplicationContext());
        return true;
    }

    private boolean c() {
        if (this.y == null || this.n) {
            return false;
        }
        n nVar = this.S;
        boolean z = false;
        if (nVar != null) {
            z = false;
            if (nVar.l() != null) {
                z = false;
                if (!aa.Code(this.S.l().aG())) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CusWhyThisAdView cusWhyThisAdView = this.f9414a;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null && (viewGroup instanceof ViewGroup)) {
                V(viewGroup, 4);
            }
            this.f9414a.setVisibility(0);
            setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private void e() {
        Code(this.L);
        V(this.D);
        if (this.b || !f()) {
            return;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.NONE);
        this.I = true;
        V(this, 0);
    }

    private boolean f() {
        return getWhyAdViewStatus() != CusWhyThisAdView.a.NONE && getWhyAdViewStatus() == CusWhyThisAdView.a.INIT;
    }

    private void g() {
        View view;
        IRemoteCreator iRemoteCreator = this.v;
        if (iRemoteCreator != null && (view = this.x) != null) {
            try {
                iRemoteCreator.destroyView(ObjectWrapper.wrap(view));
            } catch (Throwable th) {
                ge.V("PPSNativeView", "destory remote view err: %s", th.getClass().getSimpleName());
            }
        }
        this.v = null;
        this.x = null;
        this.w = null;
    }

    private CusWhyThisAdView.a getWhyAdViewStatus() {
        return this.s;
    }

    private void h() {
        fy.Code(getContext()).V();
        this.C.V();
        la laVar = this.g;
        if (laVar != null) {
            laVar.S();
            this.g.setPpsNativeView(null);
        }
        this.g = null;
        this.o = null;
        this.u = null;
        k();
    }

    public static void hideFeedback(Context context) {
        if (context != null) {
            com.huawei.openalliance.ad.msgnotify.b.Code(context, bb.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
        }
    }

    private void i() {
        kz kzVar = this.i;
        if (kzVar != null) {
            kzVar.setClickActionListener(new lt() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.5
                @Override // com.huawei.hms.ads.lt
                public void Code(AppDownloadButton appDownloadButton) {
                    PPSNativeView.this.B.Code((m) null, (Integer) null);
                }

                @Override // com.huawei.hms.ads.lt
                public void I(AppDownloadButton appDownloadButton) {
                    if (PPSNativeView.this.e != null) {
                        PPSNativeView.this.e.V();
                        PPSNativeView.this.e.I();
                    }
                }

                @Override // com.huawei.hms.ads.lt
                public void V(AppDownloadButton appDownloadButton) {
                }
            });
        }
    }

    private void j() {
        n nVar;
        if (!C() || (nVar = this.S) == null || nVar.T()) {
            return;
        }
        ge.V("PPSNativeView", " maybe report show start.");
        I();
    }

    private void k() {
        List<View> list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.j) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.j = arrayList;
        V(arrayList);
    }

    private void m() {
        n();
        Code((Integer) 3, false);
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.d();
            this.Code.I();
        }
        la laVar = this.g;
        if (laVar != null) {
            laVar.S();
        }
        DislikeAdListener dislikeAdListener = this.o;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        h();
    }

    private void n() {
        if (this.i != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.9
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.i.cancel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        n();
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.d();
            this.Code.I();
        }
        la laVar = this.g;
        if (laVar != null) {
            laVar.S();
        }
        DislikeAdListener dislikeAdListener = this.o;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        h();
    }

    private void setNativeVideoViewClickable(la laVar) {
        if (laVar instanceof NativeVideoView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeVideoView) laVar);
            V(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhyAdViewStatus(CusWhyThisAdView.a aVar) {
        this.s = aVar;
    }

    private void setWindowImageViewClickable(lb lbVar) {
        if (lbVar instanceof NativeWindowImageView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeWindowImageView) lbVar);
            V(arrayList);
        }
    }

    public void B() {
        h();
        fy.Code(getContext()).V();
        if (!this.b) {
            Code(this.F);
            this.F = null;
            this.D = null;
            Code(this.f9414a);
            this.f9414a = null;
        }
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.I();
        }
        g();
    }

    public boolean C() {
        hb hbVar = this.C;
        if (hbVar != null) {
            return hbVar.d();
        }
        return false;
    }

    public void Code(int i) {
        ge.Code("PPSNativeView", "changeChoiceViewPosition option = " + i);
        if (this.b) {
            ge.I("PPSNativeView", "china rom should not call this method");
        } else if (this.F == null) {
            ge.Code("PPSNativeView", "choicesView is null, error");
        } else {
            if (c()) {
                this.y.setVisibility(0);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.F.getLayoutParams());
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.hiad_10_dp);
            if (i != 0) {
                if (i == 2) {
                    layoutParams.addRule(12);
                } else if (i == 3) {
                    layoutParams.addRule(12);
                } else if (i == 4) {
                    if (this.n) {
                        ge.Code("PPSNativeView", "ADCHOICES_INVISIBLE is called and not default feedback!");
                        V(this.F, 8);
                        return;
                    }
                    this.F.setVisibility(0);
                    this.F.setLayoutParams(layoutParams);
                    this.F.bringToFront();
                } else {
                    layoutParams.addRule(10);
                }
                layoutParams.addRule(21);
                layoutParams.setMargins(0, 0, dimensionPixelOffset, 0);
                layoutParams.setMarginEnd(dimensionPixelOffset);
                this.F.setVisibility(0);
                this.F.setLayoutParams(layoutParams);
                this.F.bringToFront();
            }
            layoutParams.addRule(10);
            layoutParams.addRule(20);
            layoutParams.setMargins(dimensionPixelOffset, 0, 0, 0);
            layoutParams.setMarginStart(dimensionPixelOffset);
            this.F.setScaleX(-1.0f);
            this.D.setScaleX(-1.0f);
            this.F.setVisibility(0);
            this.F.setLayoutParams(layoutParams);
            this.F.bringToFront();
        }
    }

    @Override // com.huawei.hms.ads.ha
    public void Code(long j, int i) {
        ba.Code(this.l);
        if (!this.C.Code(j) || this.k) {
            return;
        }
        this.k = true;
        Code(Long.valueOf(j), Integer.valueOf(i), null, false);
    }

    public void Code(View view, int i) {
        n nVar;
        if (this.I) {
            this.I = false;
            ge.V("PPSNativeView", "onClick");
            this.m = true;
            b bVar = this.f9415c;
            if (bVar != null) {
                bVar.Code(view);
            }
            fy.Code(getContext()).Code();
            Code((Integer) 1, true);
            o.V();
            if (this.B.Code(this.r, Integer.valueOf(i))) {
                ih ihVar = this.Code;
                if (ihVar != null) {
                    ihVar.Code(jd.CLICK);
                }
            } else {
                kz kzVar = this.i;
                if (kzVar instanceof AppDownloadButton) {
                    if (k.DOWNLOAD == ((AppDownloadButton) kzVar).getStatus() && (nVar = this.S) != null && nVar.l_() && km.I(this.S.z())) {
                        ge.V("PPSNativeView", "download app directly");
                        ((AppDownloadButton) this.i).performClick();
                    }
                }
            }
            this.r = null;
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.8
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.I = true;
                }
            }, 500L);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        ih ihVar;
        if (dVar instanceof n) {
            n nVar = (n) dVar;
            AdContentData l = nVar.l();
            if (l.aA() == 3 || (ihVar = this.Code) == null) {
                return;
            }
            ihVar.Code(getContext(), l, this, true);
            this.Code.Code(false);
            this.Code.Z();
            is V = this.Code.V();
            this.t = V;
            if (V != null) {
                V.Code(this.D, ir.OTHER, null);
                this.t.Code(this.f9414a, ir.OTHER, null);
                this.t.Code(this.F, ir.OTHER, null);
            }
            Code(this.Code, nVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.I = true;
        if (gVar == null) {
            return;
        }
        ge.Code("PPSNativeView", "register nativeAd");
        this.S = (n) gVar;
        e();
        if (!b()) {
            this.p = gVar.h();
            this.q = gVar.i();
            a();
        }
        this.C.V(this.S.r(), this.S.s());
        this.B.Code(this.S);
        this.B.V();
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
        j();
        l();
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list) {
        this.I = true;
        if (gVar == null) {
            return;
        }
        ge.Code("PPSNativeView", "register nativeAd");
        this.S = (n) gVar;
        e();
        if (!b()) {
            this.p = gVar.h();
            this.q = gVar.i();
            a();
        }
        this.C.V(this.S.r(), this.S.s());
        this.B.Code(this.S);
        this.B.V();
        j();
        this.j = list;
        V(list);
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, la laVar) {
        this.g = laVar;
        Code(gVar);
        if (laVar != null) {
            laVar.setPpsNativeView(this);
            laVar.setNativeAd(gVar);
            setNativeVideoViewClickable(laVar);
        }
        this.j = list;
        V(list);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, lb lbVar) {
        Code(gVar);
        this.h = lbVar;
        if (lbVar != null) {
            lbVar.setNativeAd(gVar);
            setWindowImageViewClickable(this.h);
        }
        this.j = list;
        V(list);
    }

    @Override // com.huawei.hms.ads.lf
    public void Code(Integer num, boolean z) {
        Code(Long.valueOf(System.currentTimeMillis() - this.C.Z()), Integer.valueOf(this.C.I()), num, z);
    }

    public void Code(List<String> list) {
        ge.V("PPSNativeView", "onClose keyWords");
        this.B.Code(list);
        m();
    }

    public boolean Code() {
        if (this.n || this.f9414a == null) {
            return false;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.SHOWN);
        d();
        this.f9414a.V();
        k();
        this.I = false;
        return true;
    }

    public boolean Code(kz kzVar) {
        if (this.S != null) {
            boolean z = false;
            this.i = kzVar;
            if (kzVar != null) {
                kzVar.setPpsNativeView(this);
                z = kzVar.Code(this.S);
                i();
            }
            if (ge.Code()) {
                ge.Code("PPSNativeView", "register downloadbutton, succ:" + z);
            }
            return z;
        }
        throw new IllegalStateException("Register INativeAd first");
    }

    @Override // com.huawei.hms.ads.lf
    public void D() {
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.Code(jd.CLICK);
        }
    }

    public void F() {
        ge.V("PPSNativeView", "onClose");
        Code((List<String>) null);
    }

    @Override // com.huawei.hms.ads.ha
    public void I() {
        e eVar;
        this.k = false;
        long Code = v.Code();
        String valueOf = String.valueOf(Code);
        n nVar = this.S;
        if (nVar == null) {
            ge.V("PPSNativeView", "nativeAd is null, please register first");
            return;
        }
        nVar.Z(false);
        this.S.B(true);
        this.S.B(valueOf);
        this.S.V(Code);
        if (this.m && (eVar = this.e) != null) {
            this.m = false;
            eVar.Z();
        }
        if (!this.S.Q()) {
            this.S.V(true);
            if (this.d != null) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSNativeView.this.d != null) {
                            PPSNativeView.this.d.Code();
                        }
                    }
                });
            }
        }
        this.B.Code(valueOf);
        this.B.Code(Code);
        la laVar = this.g;
        if (laVar != null) {
            laVar.Code(valueOf);
            this.g.Code(Code);
        }
        kz kzVar = this.i;
        if (kzVar != null) {
            kzVar.Z(valueOf);
            this.i.Code(Code);
        }
        dn dnVar = this.w;
        if (dnVar != null) {
            dnVar.Code(valueOf);
            this.w.Code(Code);
        }
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.L();
        }
        this.B.Code();
    }

    public void S() {
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.I();
        }
    }

    @Override // com.huawei.hms.ads.ha
    public void V(long j, int i) {
        ba.Code(this.l);
        n nVar = this.S;
        if (nVar != null) {
            nVar.B(false);
        }
        this.B.Code(j, i);
    }

    public void V(kz kzVar) {
        kz kzVar2;
        if (kzVar == null || kzVar != (kzVar2 = this.i)) {
            return;
        }
        kzVar2.setPpsNativeView(null);
        this.i.Code((com.huawei.openalliance.ad.inter.data.g) null);
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        if (this.f9414a == null || getWhyAdViewStatus() != CusWhyThisAdView.a.INIT) {
            View view = this.f9414a;
            if (view != null) {
                Code(view);
                this.f9414a = null;
            }
            setWhyAdViewStatus(CusWhyThisAdView.a.INIT);
            CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this);
            this.f9414a = cusWhyThisAdView;
            addView(cusWhyThisAdView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f9414a.getLayoutParams());
            layoutParams.addRule(13);
            this.f9414a.setLayoutParams(layoutParams);
        }
        this.f9414a.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.3
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                PPSNativeView.this.d();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                ArrayList arrayList;
                PPSNativeView.this.d();
                ArrayList arrayList2 = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList2.add(str);
                    arrayList = arrayList2;
                }
                PPSNativeView.this.setWhyAdViewStatus(CusWhyThisAdView.a.DISLIKED);
                PPSNativeView.this.Code(arrayList);
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSNativeView.this.S == null) {
                    ge.I("PPSNativeView", "getKeyWords nativaAd is null");
                    return null;
                }
                return PPSNativeView.this.S.n();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSNativeView.this.S != null) {
                    com.huawei.openalliance.ad.utils.c.Code(PPSNativeView.this.getContext(), PPSNativeView.this.S);
                } else {
                    ge.I("PPSNativeView", "processWhyThisAdEvent nativaAd is null");
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.ha
    public void a_() {
        n nVar = this.S;
        if (nVar != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.4
                @Override // java.lang.Runnable
                public void run() {
                    n nVar2 = PPSNativeView.this.S;
                    if (nVar2 != null) {
                        PPSNativeView.this.Code(Long.valueOf(nVar2.r()), Integer.valueOf(PPSNativeView.this.C.I()), null, false);
                    }
                }
            }, this.l, nVar.r());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (ky.Code(motionEvent) == 0) {
                m Code = ky.Code(this, motionEvent);
                this.r = Code;
                if (this.i != null) {
                    ((AppDownloadButton) this.i).setClickInfo(Code);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            ge.I("PPSNativeView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public is getAdSessionAgent() {
        return this.t;
    }

    public View getFeedBackView() {
        try {
            com.huawei.hms.ads.uiengine.b V = com.huawei.hms.ads.f.V();
            if (this.x == null || V == null) {
                return null;
            }
            return (View) ObjectWrapper.unwrap(V.Code(ObjectWrapper.wrap(this.x)));
        } catch (Throwable th) {
            ge.I("PPSNativeView", "get anchor view err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public n getNativeAd() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    public void gotoWhyThisAdPage() {
        if (this.b) {
            ge.I("PPSNativeView", "china rom should not call gotoWhyThisAdPage method");
        } else if (this.S != null) {
            com.huawei.openalliance.ad.utils.c.Code(getContext(), this.S);
        } else {
            ge.I("PPSNativeView", "skipWhyThisAdPage nativaAd is null");
        }
    }

    public void hideAdvertiserInfoDialog() {
        hideFeedback(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hb hbVar = this.C;
        if (hbVar != null) {
            hbVar.D();
        }
        n nVar = this.S;
        if (nVar != null) {
            Code((com.huawei.openalliance.ad.inter.data.d) nVar);
        }
        kl.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ge.V("PPSNativeView", "onDetechedFromWindow");
        hb hbVar = this.C;
        if (hbVar != null) {
            hbVar.L();
        }
        ih ihVar = this.Code;
        if (ihVar != null) {
            ihVar.I();
        }
    }

    public void onViewUpdate() {
        if (ge.Code()) {
            ge.Code("PPSNativeView", "manual updateView");
        }
        this.C.onGlobalLayout();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        hb hbVar = this.C;
        if (hbVar != null) {
            hbVar.a();
        }
    }

    public void pause() {
        try {
            com.huawei.hms.ads.uiengine.b V = com.huawei.hms.ads.f.V();
            if (this.x == null || V == null) {
                return;
            }
            V.Code(ObjectWrapper.wrap(this.x), (Bundle) null);
        } catch (Throwable th) {
            ge.I("PPSNativeView", "pauseVideo err: %s", th.getClass().getSimpleName());
        }
    }

    public void resume() {
        try {
            com.huawei.hms.ads.uiengine.b V = com.huawei.hms.ads.f.V();
            if (this.x == null || V == null) {
                return;
            }
            V.V(ObjectWrapper.wrap(this.x), null);
        } catch (Throwable th) {
            ge.I("PPSNativeView", "resumeVideo err: %s", th.getClass().getSimpleName());
        }
    }

    public void setAdContainerSizeMatched(String str) {
        this.B.V(str);
    }

    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        this.u = adFeedbackListener;
    }

    public void setChoiceViewPosition(int i) {
        ge.Code("PPSNativeView", "setChoiceViewPosition option = " + i);
        if (this.S == null) {
            this.L = i;
        } else {
            Code(i);
        }
    }

    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        if (this.b) {
            ge.I("PPSNativeView", "china rom should not call setChoiceViewPosition method");
        } else {
            this.o = dislikeAdListener;
        }
    }

    public void setIsCustomDislikeThisAdEnabled(boolean z) {
        if (this.b) {
            ge.I("PPSNativeView", "china rom should not call this method and isCustomDislikeThisAdEnabled = " + z);
            return;
        }
        this.n = z;
        if (z) {
            ge.Code("PPSNativeView", "dont like default feedback!");
            return;
        }
        ge.Code("PPSNativeView", "like default feedback!");
        ChoicesView choicesView = this.D;
        if (choicesView != null) {
            choicesView.V();
            ge.Code("PPSNativeView", "setCustomLikeBackgroundResource");
        }
        Z();
    }

    public void setOnNativeAdClickListener(b bVar) {
        this.f9415c = bVar;
    }

    public void setOnNativeAdImpressionListener(c cVar) {
        this.f = cVar;
    }

    public void setOnNativeAdStatusChangedListener(d dVar) {
        this.d = dVar;
    }

    public void setOnNativeAdStatusTrackingListener(e eVar) {
        this.e = eVar;
        this.B.Code(eVar);
    }

    public void showAdvertiserInfoDialog(View view, boolean z) {
        if (view == null) {
            ge.I("PPSNativeView", "anchorView is null");
        }
        try {
            if (this.S == null) {
                ge.I("PPSNativeView", "adInfo is null");
                return;
            }
            AdContentData l = this.S.l();
            if (aa.Code(l.aG())) {
                ge.I("PPSNativeView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, l, z);
            }
        } catch (Throwable th) {
            ge.I("PPSNativeView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void showFeedback(View view) {
        com.huawei.openalliance.ad.feedback.a aVar = new com.huawei.openalliance.ad.feedback.a();
        aVar.Code(view);
        aVar.V(this.u);
        aVar.Code(new a(this));
        ep.Code(this.S);
        FeedbackActivity.Code(getContext(), aVar);
    }
}
