package com.kwad.components.ad.fullscreen.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.d;
import com.kwad.components.ad.reward.presenter.f.i;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.q;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/b.class */
public final class b extends com.kwad.components.ad.reward.presenter.a implements f {
    private com.kwad.components.ad.reward.presenter.d.a gA;
    private com.kwad.components.ad.fullscreen.b gu;
    private ViewGroup gv;
    private com.kwad.components.core.j.b gw;
    private q gx;
    private com.kwad.components.ad.reward.presenter.f.b gy;
    private e gz;
    private FrameLayout mPlayLayout;

    public b(com.kwad.components.core.j.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, j jVar) {
        this.gw = bVar;
        this.gu = bVar2;
        this.gv = viewGroup;
        this.qt = jVar;
        bR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private void bR() {
        if (this.gu == null) {
            return;
        }
        bV();
        AdInfo bK = this.gu.bK();
        if (com.kwad.sdk.core.response.a.a.cq(bK) && !com.kwad.sdk.core.response.a.a.cA(bK)) {
            this.qt.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.a.c.a.rn().a(bW());
            bT();
        } else if (!j.a(this.qt)) {
            this.qt.a(RewardRenderResult.DEFAULT);
            bS();
        } else {
            this.qt.a(RewardRenderResult.FULLSCREEN_TK);
            bU();
            com.kwad.components.core.webview.a.c.a.rn().a(bW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS() {
        com.kwad.components.core.webview.a.c.a.rn().b(this.gz);
        AdTemplate adTemplate = this.gu.getAdTemplate();
        AdInfo bK = this.gu.bK();
        boolean z = this.gu.bL() && !ai.DM();
        a(new u(), true);
        if (com.kwad.sdk.core.response.a.a.aH(bK)) {
            a(new com.kwad.components.ad.reward.presenter.c(), true);
        }
        a(new l(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        a(new d(), true);
        if (com.kwad.sdk.core.response.a.b.cH(bK)) {
            a(new i(), true);
        }
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        if (com.kwad.sdk.core.response.a.b.bK(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.b.kwai.f(), true);
        }
        a(new k(), true);
        a(new com.kwad.components.ad.reward.presenter.a.c(), true);
        a(new com.kwad.components.ad.reward.presenter.a.b(), true);
        a(new com.kwad.components.ad.reward.presenter.j(), true);
        a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        a(new c(), true);
        a(new com.kwad.components.ad.reward.presenter.i(), true);
    }

    private void bT() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.gy = bVar;
        a(bVar);
    }

    private void bU() {
        a(new com.kwad.components.ad.fullscreen.b.b.b(), true);
    }

    private void bV() {
        AdTemplate adTemplate = this.gu.getAdTemplate();
        AdInfo bK = this.gu.bK();
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.c.b(adTemplate, false), true);
        q qVar = new q(adTemplate, false, false);
        this.gx = qVar;
        a(qVar, true);
        a(new com.kwad.components.ad.reward.presenter.d(adTemplate, bK, this.gv), true);
        if (com.kwad.sdk.core.response.a.b.dv(bK) && ai.DM()) {
            com.kwad.components.ad.reward.presenter.d.a aVar = new com.kwad.components.ad.reward.presenter.d.a();
            this.gA = aVar;
            a(aVar, true);
        }
    }

    private e bW() {
        if (this.gz == null) {
            final String b = com.kwad.components.core.webview.a.j.b("ksad-fullscreen-video-card", this.gu.getAdTemplate());
            final String b2 = com.kwad.components.core.webview.a.j.b("ksad-live-video-card", this.qt.mAdTemplate);
            this.gz = new e() { // from class: com.kwad.components.ad.fullscreen.b.b.1
                @Override // com.kwad.components.core.webview.a.d.b
                public final void u(String str) {
                    if (b.equals(str) || b2.equals(str)) {
                        j.a(b.this.getContext(), b.this.qt, b.this.mPlayLayout);
                        b.this.bS();
                    }
                }
            };
        }
        return this.gz;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.b(this);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        this.qt.G(true);
    }

    public final boolean bX() {
        q qVar = this.gx;
        if (qVar == null || !qVar.bX()) {
            com.kwad.components.ad.reward.presenter.d.a aVar = this.gA;
            if (aVar == null || aVar.gs() != BackPressHandleResult.HANDLED) {
                com.kwad.components.ad.reward.presenter.f.b bVar = this.gy;
                return bVar != null && bVar.gs() == BackPressHandleResult.HANDLED;
            }
            return true;
        }
        return true;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
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
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gz);
    }
}
