package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.mvp.Presenter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/a.class */
public class a extends Presenter {
    public com.kwad.components.ad.reward.j qt;

    public final void L(boolean z) {
        com.kwad.sdk.core.report.a.a(this.qt.mAdTemplate, z ? 1 : 153, this.qt.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.qt = (com.kwad.components.ad.reward.j) Bh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hq() {
        this.qt.hq();
    }
}
