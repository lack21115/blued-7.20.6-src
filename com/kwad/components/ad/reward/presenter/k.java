package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.k.g;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/k.class */
public final class k extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl oQ;
    private com.kwad.components.ad.reward.k.g sf;
    private KsLogoView sh;
    private com.kwad.components.ad.reward.k.k si;
    private boolean sg = false;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            k.this.hv();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            k.this.hv();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hv() {
        if (this.sg) {
            return;
        }
        com.kwad.components.ad.reward.k.g gVar = this.sf;
        if (gVar == null) {
            this.oQ.S(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.k.3
                @Override // com.kwad.components.ad.reward.k.g.a
                public final void hw() {
                    k.this.oQ.S(true);
                }
            }, 500L);
        }
        this.sg = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.k.k kVar = this.si;
        if (kVar != null) {
            kVar.jR();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.oQ = this.qt.oQ;
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        AdTemplate adTemplate = this.qt.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.a.b.bI(adTemplate).displayWeakCard;
        this.qt.C(z);
        if (z) {
            if (this.sf == null) {
                this.sf = new com.kwad.components.ad.reward.k.g(this.qt);
            }
            this.sf.e((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.sf.b(v.B(adTemplate));
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.aI(adTemplate)) {
            if (this.si == null) {
                this.si = new com.kwad.components.ad.reward.k.k(this.qt);
            }
            this.si.f(this.qt.mRootContainer);
            this.si.b(v.B(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), cb, this.sh, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.qt.oQ.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sh = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qt.oQ.b(this);
        com.kwad.components.ad.reward.k.k kVar = this.si;
        if (kVar != null) {
            kVar.onUnbind();
        }
    }
}
