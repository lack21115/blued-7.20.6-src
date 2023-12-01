package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.g.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.b;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/f/g.class */
public final class g extends a implements com.kwad.components.ad.reward.d.h, a.InterfaceC0353a {
    private com.kwad.components.core.webview.a.f lH;
    private List<com.kwad.components.core.g.c> tb;
    private FrameLayout vJ;
    private FrameLayout wn;
    private FrameLayout wo;
    private FrameLayout wp;
    private boolean vK = false;
    private final com.kwad.components.core.webview.a.d.a pa = new com.kwad.components.core.webview.a.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.g.1
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    };

    private static List<AdTemplate> a(List<com.kwad.components.core.g.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.g.c.i(list));
        return arrayList;
    }

    private void aa(boolean z) {
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.vJ;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
        this.wn.setVisibility(z ? 8 : 0);
        this.wo.setVisibility(z ? 8 : 0);
        FrameLayout frameLayout2 = this.wp;
        int i = 0;
        if (z) {
            i = 8;
        }
        frameLayout2.setVisibility(i);
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.reward.presenter.f.g.6
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
        return new com.kwad.components.core.webview.a.f() { // from class: com.kwad.components.ad.reward.presenter.f.g.5
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        };
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, l lVar) {
        FrameLayout frameLayout;
        if (this.vK || (frameLayout = this.vJ) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (!this.vK) {
            aa(true);
        }
        this.qt.pg = true ^ this.vK;
        this.qt.a((a.InterfaceC0353a) this);
        com.kwad.components.ad.reward.b.ff().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        FrameLayout frameLayout;
        if (this.vK || (frameLayout = this.vJ) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.vJ;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-neo-video-card", this.qt.mAdTemplate);
    }

    public final BackPressHandleResult gs() {
        return this.vM == null ? BackPressHandleResult.NOT_HANDLED : this.vM.gs();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.a.d.b(this.qt.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
            this.qt.mAdOpenInteractionListener.bN();
            return;
        }
        com.kwad.components.core.g.c a2 = com.kwad.components.ad.reward.j.a(this.tb, aVar.creativeId);
        if (a2 != null) {
            this.qt.a(a2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vJ = (FrameLayout) findViewById(R.id.ksad_js_reward_card);
        this.wn = (FrameLayout) findViewById(R.id.ksad_js_top);
        this.wo = (FrameLayout) findViewById(R.id.ksad_js_middle);
        this.wp = (FrameLayout) findViewById(R.id.ksad_js_bottom);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0353a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0353a
    public final void onInnerAdLoad(List<com.kwad.components.core.g.c> list) {
        if (list == null || list.size() == 0 || this.vM == null) {
            return;
        }
        this.tb = list;
        List<AdTemplate> a2 = a(list, this.qt.mAdTemplate);
        com.kwad.sdk.core.webview.b jsBridgeContext = this.vM.getJsBridgeContext();
        if (jsBridgeContext != null) {
            jsBridgeContext.setAdTemplateList(a2);
        }
        com.kwad.components.ad.reward.h.l jj = this.vM.jj();
        if (jj != null) {
            jj.d(a2);
        } else {
            this.vM.e(a2);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.presenter.f.g.2
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.gT());
                g.this.a(bVar2);
            }
        }));
        this.lH = eo();
        this.qt.a(this.pa);
        lVar.c(this.lH);
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.g.3
            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(g.this.qt.mContext);
            }
        }));
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.jshandler.e(new com.kwad.components.core.webview.jshandler.i() { // from class: com.kwad.components.ad.reward.presenter.f.g.4
            @Override // com.kwad.components.core.webview.jshandler.i
            public final void a(com.kwad.components.core.webview.jshandler.e eVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = g.this.qt.mAdTemplate;
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    boolean z = true;
                    boolean z2 = !com.kwad.sdk.core.response.a.a.bv(cb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null);
                    if (!com.kwad.components.ad.reward.j.h(cb) || !com.kwad.sdk.core.c.a.vV() || g.this.qt.mScreenOrientation != 0) {
                        z = false;
                    }
                    eVar.h(z2, z);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0353a
    public final void onRequestResult(int i) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onSkipClick(u uVar) {
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onSkipClick: " + uVar.Vl);
        if (this.qt != null && this.qt.mAdOpenInteractionListener != null) {
            this.qt.mAdOpenInteractionListener.onVideoSkipToEnd(uVar.Vl * 1000);
        }
        com.kwad.components.ad.reward.presenter.e.u(this.qt);
        com.kwad.components.ad.reward.j.a(this.qt.oW, new com.kwad.sdk.e.a<com.kwad.components.ad.reward.h.a>() { // from class: com.kwad.components.ad.reward.presenter.f.g.7
            private static void c(com.kwad.components.ad.reward.h.a aVar) {
                aVar.iH();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.h.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.vK = true;
        this.qt.pg = false;
        aa(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.b((a.InterfaceC0353a) this);
        com.kwad.components.ad.reward.b.ff().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
    }

    public final void r(AdTemplate adTemplate) {
        this.vM.resetAdTemplate(adTemplate);
    }
}
