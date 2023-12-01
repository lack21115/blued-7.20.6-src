package com.kwad.components.ad.reward;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/o.class */
public final class o extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.f, com.kwad.components.ad.reward.g.b, e.a {
    private com.kwad.components.ad.reward.presenter.d.a gA;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.o.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String b = com.kwad.components.core.webview.a.j.b("ksad-neo-video-card", o.this.qt.mAdTemplate);
            String b2 = com.kwad.components.core.webview.a.j.b("ksad-live-video-card", o.this.qt.mAdTemplate);
            com.kwad.sdk.core.d.b.d("RewardPresenter", "onTkLoadFailed, rewardPageTemplateId: " + b + ", templateId: " + str);
            if (TextUtils.equals(b, str) || TextUtils.equals(b2, str)) {
                j.a(o.this.getContext(), o.this.qt, o.this.mPlayLayout);
                o.this.qt.a(RewardRenderResult.DEFAULT);
                o oVar = o.this;
                oVar.a(oVar.gw, o.this.mModel);
            }
        }
    };
    private ViewGroup gv;
    private com.kwad.components.core.j.b gw;
    private com.kwad.components.ad.reward.presenter.q gx;
    private com.kwad.components.ad.reward.presenter.f.b gy;
    private com.kwad.components.ad.reward.model.c mModel;
    private FrameLayout mPlayLayout;
    private j qt;
    private a qu;
    private com.kwad.components.ad.reward.presenter.f.g qv;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/o$a.class */
    public interface a {
        void onUnbind();
    }

    public o(com.kwad.components.core.j.b bVar, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, j jVar) {
        this.gv = viewGroup;
        this.mModel = cVar;
        this.qt = jVar;
        this.gw = bVar;
        jVar.a((e.a) this);
        a(cVar);
        AdInfo bK = cVar.bK();
        boolean z = com.kwad.sdk.core.response.a.a.cq(bK) || j.q(cVar.getAdTemplate());
        boolean z2 = false;
        if (com.kwad.sdk.core.response.a.a.cq(bK)) {
            z2 = false;
            if (!com.kwad.sdk.core.response.a.a.cA(bK)) {
                z2 = true;
            }
        }
        com.kwad.sdk.core.d.b.d("RewardPresenter", "notFullTk: " + z + ", mLoadStrategy: " + this.qt.pI);
        if (z2) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            jVar.a(RewardRenderResult.LIVE_TK);
            bT();
        } else if (z || !this.qt.pI.equals(LoadStrategy.FULL_TK)) {
            jVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        } else {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            jVar.a(RewardRenderResult.NEO_TK);
            gr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.d.f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdTemplate adTemplate = cVar.getAdTemplate();
        AdInfo bK = cVar.bK();
        if (j.h(bK)) {
            a(new com.kwad.components.ad.reward.presenter.f());
        }
        if (com.kwad.sdk.core.response.a.a.aG(bK)) {
            a(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.a.b.cH(bK)) {
            a(new com.kwad.components.ad.reward.presenter.f.i());
        }
        com.kwad.components.ad.reward.presenter.q qVar = new com.kwad.components.ad.reward.presenter.q(adTemplate);
        this.gx = qVar;
        a((Presenter) qVar, true);
        if (com.kwad.sdk.core.response.a.b.dv(bK) && ai.DM()) {
            com.kwad.components.ad.reward.presenter.d.a aVar = new com.kwad.components.ad.reward.presenter.d.a();
            this.gA = aVar;
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.j.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        com.kwad.components.ad.reward.model.c cVar2 = this.mModel;
        if (cVar2 == null) {
            return;
        }
        AdInfo bK = cVar2.bK();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        a((Presenter) new u(), true);
        if (com.kwad.sdk.core.response.a.a.aH(bK)) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.c(), true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.l(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.g(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.kwai.e(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.f.d(), true);
        boolean hk = cVar.hk();
        boolean hl = cVar.hl();
        boolean z = cVar.bL() && !ai.DM();
        if (!hk && !hl && !z) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.m(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.b(bK), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.c.b(adTemplate, true), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.b.a(), true);
        a((Presenter) new t(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.d(adTemplate, bK, this.gv), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.k(), true);
        if (this.qt.pf && com.kwad.components.ad.reward.c.a.b(this.qt.mContext, com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.kwai.a(), true);
        }
        if (com.kwad.sdk.core.response.a.b.bL(adTemplate)) {
            a((Presenter) new s(), true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.c(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.a(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.b(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.j(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.i(), true);
    }

    private void bT() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.gy = bVar;
        a(bVar);
    }

    private void gr() {
        com.kwad.components.ad.reward.presenter.f.g gVar = new com.kwad.components.ad.reward.presenter.f.g();
        this.qv = gVar;
        a(gVar);
    }

    public final void a(a aVar) {
        this.qu = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.b(this);
        com.kwad.components.ad.reward.b.a.gQ().setCallerContext(this.qt);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        this.qt.G(true);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    public final BackPressHandleResult gs() {
        com.kwad.components.ad.reward.presenter.q qVar = this.gx;
        if (qVar == null || !qVar.bX()) {
            com.kwad.components.ad.reward.presenter.d.a aVar = this.gA;
            if (aVar == null || aVar.gs() != BackPressHandleResult.HANDLED) {
                com.kwad.components.ad.reward.presenter.f.b bVar = this.gy;
                if (bVar != null) {
                    return bVar.gs();
                }
                com.kwad.components.ad.reward.presenter.f.g gVar = this.qv;
                return gVar != null ? gVar.gs() : BackPressHandleResult.NOT_HANDLED;
            }
            return BackPressHandleResult.HANDLED;
        }
        return BackPressHandleResult.HANDLED;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final void gt() {
        if (this.qt.fT()) {
            return;
        }
        com.kwad.components.ad.reward.g.a.a(getActivity(), this, this.qt.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void gu() {
        this.qt.mAdOpenInteractionListener.h(false);
        hq();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mPlayLayout = (FrameLayout) this.gv.findViewById(R.id.ksad_reward_play_layout);
        if (RewardRenderResult.DEFAULT.equals(this.qt.fS())) {
            j.a(getContext(), this.qt, this.mPlayLayout);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.gw = null;
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
    }

    @Override // com.kwad.components.ad.reward.g.c, com.kwad.components.core.webview.jshandler.j.a
    public final void onPlayAgainClick(boolean z) {
        this.qt.B(z);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this);
        a aVar = this.qu;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.ad.reward.b.a.gQ().reset();
    }

    public final void r(AdTemplate adTemplate) {
        com.kwad.components.ad.reward.presenter.f.g gVar = this.qv;
        if (gVar != null) {
            gVar.r(adTemplate);
        }
    }
}
