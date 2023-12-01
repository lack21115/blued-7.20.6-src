package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/c.class */
public final class c extends com.kwad.components.ad.reward.presenter.a {
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.c.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-bottom-card-v2", c.this.qt.mAdTemplate).equals(str) || j.b("ksad-fullscreen-video-card", c.this.qt.mAdTemplate).equals(str)) {
                c.this.qt.pF = true;
                c.this.qt.oQ.S(true);
            }
        }
    };
    private AdTemplate mAdTemplate;
    private Context mContext;

    public c() {
        a(new f());
        a(new b());
        a(new com.kwad.components.ad.reward.presenter.f.f());
    }

    private void ib() {
        if (com.kwad.components.ad.reward.j.d(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qt.mAdTemplate;
        this.mContext = this.qt.mContext;
        ib();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
    }
}
