package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.g.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/f.class */
public final class f extends a implements a.InterfaceC0523a {
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qt.mAdTemplate;
        boolean vV = com.kwad.sdk.core.c.a.vV();
        com.kwad.sdk.core.d.b.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + vV);
        if (this.mAdTemplate.mAdScene == null || !vV) {
            return;
        }
        com.kwad.components.core.g.a.a(this.mAdTemplate.mAdScene, this);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0523a
    public final void onError(int i, String str) {
        List<a.InterfaceC0523a> fQ = this.qt.fQ();
        if (fQ != null) {
            for (a.InterfaceC0523a interfaceC0523a : fQ) {
                interfaceC0523a.onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0523a
    public final void onInnerAdLoad(List<com.kwad.components.core.g.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.b.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean aZ = com.kwad.sdk.core.response.a.b.aZ(adTemplate);
        List<a.InterfaceC0523a> fQ = this.qt.fQ();
        if (aZ) {
            com.kwad.sdk.core.c.a.c(com.kwad.sdk.core.response.a.b.aW(adTemplate), com.kwad.sdk.core.response.a.b.aX(adTemplate));
            if (fQ != null) {
                for (a.InterfaceC0523a interfaceC0523a : fQ) {
                    interfaceC0523a.onInnerAdLoad(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0523a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0523a> fQ = this.qt.fQ();
        if (fQ != null) {
            for (a.InterfaceC0523a interfaceC0523a : fQ) {
                interfaceC0523a.onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
