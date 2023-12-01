package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.jshandler.an;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/f/e.class */
public final class e implements j.a {
    private an wi;
    private boolean wj;
    private boolean wk;

    private void iW() {
        an anVar = this.wi;
        if (anVar == null || !this.wk) {
            return;
        }
        if (this.wj) {
            anVar.rd();
            return;
        }
        anVar.qZ();
        this.wi.ra();
        this.wj = true;
    }

    public final void A(j jVar) {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        jVar.b(this);
    }

    public final void a(an anVar) {
        this.wi = anVar;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gb() {
        this.wk = true;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gc() {
        this.wk = true;
        iW();
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gd() {
        this.wk = false;
        an anVar = this.wi;
        if (anVar != null) {
            anVar.re();
        }
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void ge() {
        this.wk = false;
    }

    public final boolean iJ() {
        return this.wk;
    }

    public final void onTkLoadFailed() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
    }

    public final void onTkLoadSuccess() {
        iW();
    }

    public final void z(j jVar) {
        jVar.a(this);
    }
}
