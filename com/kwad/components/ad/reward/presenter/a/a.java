package com.kwad.components.ad.reward.presenter.a;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/a/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private AdLiveHandleClickListener tB = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i) {
            if (i == 1) {
                a.this.qt.a(1, a.this.getContext(), 115, 1);
            } else if (i == 2) {
                a.this.qt.a(1, a.this.getContext(), 117, 1);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.qt.oO != null) {
            this.qt.oO.registerClickListener(this.tB);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.qt.oO != null) {
            this.qt.oO.unRegisterClickListener(this.tB);
        }
    }
}
