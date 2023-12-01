package com.kwad.components.ad.reward.presenter.a;

import android.view.View;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/a/c.class */
public final class c extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.a.c.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            c.this.hv();
        }
    };
    private RewardActionBarControl oQ;
    private n tH;

    /* JADX INFO: Access modifiers changed from: private */
    public void hv() {
        this.oQ.S(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.oQ = this.qt.oQ;
        this.qt.oN.a(null, this.mAdLivePlayStateListener);
        AdTemplate adTemplate = this.qt.mAdTemplate;
        AdInfo cb = d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.cq(cb)) {
            if (this.tH == null) {
                this.tH = new n(this.qt);
            }
            this.tH.a(this.qt.mRootContainer, com.kwad.sdk.core.response.a.a.aX(cb));
            this.tH.b(v.B(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.qt.oQ.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(null, this.mAdLivePlayStateListener);
        this.qt.oQ.b(this);
        n nVar = this.tH;
        if (nVar != null) {
            nVar.onUnbind();
        }
    }
}
