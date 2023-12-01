package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.a.b;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/f/d.class */
public final class d extends c implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private com.kwad.components.core.webview.a.f lH;
    private final com.kwad.components.core.webview.a.d.a pa = new com.kwad.components.core.webview.a.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    };
    private ViewGroup wa;
    private ViewGroup wb;
    private ViewGroup wc;
    private View wd;
    private ViewGroup we;
    private FrameLayout wf;

    private void U(final int i) {
        this.qt.mRootContainer.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // java.lang.Runnable
            public final void run() {
                int iU = d.this.iU();
                int V = d.this.V(i);
                if (d.this.wf != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.wf.getLayoutParams();
                    layoutParams.width = -1;
                    int height = (d.this.qt.mRootContainer.getHeight() - iU) - V;
                    int i2 = height;
                    if (height < 0) {
                        i2 = 0;
                    }
                    layoutParams.topMargin = iU;
                    layoutParams.height = i2;
                    d.this.wf.setLayoutParams(layoutParams);
                }
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int V(int i) {
        ViewGroup viewGroup = this.wb;
        if (viewGroup == null || viewGroup.getHeight() <= 0) {
            ViewGroup viewGroup2 = this.we;
            return (viewGroup2 == null || viewGroup2.getHeight() <= 0) ? i > 0 ? i : com.kwad.sdk.c.kwai.a.a(getContext(), 120.0f) : this.we.getHeight();
        }
        return this.wb.getHeight();
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
            @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UX = com.kwad.components.ad.reward.model.b.cQ();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.a.f eo() {
        return new com.kwad.components.core.webview.a.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iU() {
        ViewGroup viewGroup;
        int height;
        if (this.wa.getHeight() > 0) {
            viewGroup = this.wa;
        } else if (com.kwad.sdk.core.response.a.a.aH(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate)) && (height = ((ViewGroup.MarginLayoutParams) this.wd.getLayoutParams()).topMargin + 0 + this.wd.getHeight()) > 0) {
            return height;
        } else {
            viewGroup = this.wc;
        }
        return viewGroup.getHeight();
    }

    private com.kwad.components.core.webview.a.e iV() {
        return new com.kwad.components.core.webview.a.e() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
            @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(d.this.qt.mAdTemplate);
                int i = 0;
                int aE = com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(cb) : com.kwad.sdk.core.response.a.a.aC(cb);
                if (d.this.qt.pi) {
                    i = aE;
                }
                iVar.rewardTime = i;
                cVar.a(iVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        U(layoutParams != null ? layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + layoutParams.height : layoutParams.height : 0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oQ.a(this);
        this.wf.setVisibility(0);
        U(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean ck() {
        return !this.qt.oN.jF();
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.wf;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-video-middle-card", this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wf = (FrameLayout) findViewById(R.id.ksad_js_middle);
        this.wa = (ViewGroup) findViewById(R.id.ksad_js_top);
        this.wc = (ViewGroup) findViewById(R.id.ksad_play_detail_top_toolbar);
        this.wb = (ViewGroup) findViewById(R.id.ksad_js_bottom);
        this.we = (ViewGroup) findViewById(R.id.ksad_play_web_card_webView);
        this.wd = findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        this.lH = eo();
        this.qt.a(this.pa);
        lVar.c(this.lH);
        lVar.c(iV());
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(d.this.qt.mContext);
            }
        }));
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.jshandler.e(new com.kwad.components.core.webview.jshandler.i() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.jshandler.i
            public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = d.this.qt.mAdTemplate;
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    boolean z = true;
                    boolean z2 = !com.kwad.sdk.core.response.a.a.bv(cb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null);
                    if (!com.kwad.components.ad.reward.j.h(cb) || !com.kwad.sdk.core.c.a.vV() || d.this.qt.mScreenOrientation != 0) {
                        z = false;
                    }
                    eVar.h(z2, z);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.wf.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oQ.b(this);
        this.qt.a((com.kwad.components.core.webview.a.d.a) null);
    }
}
