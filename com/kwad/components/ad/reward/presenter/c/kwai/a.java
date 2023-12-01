package com.kwad.components.ad.reward.presenter.c.kwai;

import android.widget.FrameLayout;
import com.kwad.components.ad.i.a;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/kwai/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a implements a.b {
    private FrameLayout df;
    private volatile long uV = 0;
    private volatile boolean uW = false;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.uW = true;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            a.this.uV = j;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.uW = false;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.uW = false;
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            a.this.uV = j2;
            a.this.uW = j - j2 < 800;
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.4
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (a.this.qt.pv || a.this.qt.oT == null) {
                return;
            }
            a.this.qt.oT.az();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.5
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            a.this.qt.mAdOpenInteractionListener.bN();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.uV = 0L;
        this.uW = false;
        AdTemplate adTemplate = this.qt.mAdTemplate;
        com.kwad.components.ad.i.a aVar = this.qt.oT;
        if (aVar != null) {
            this.qt.pq = true;
            aVar.a(this);
            aVar.a(this.mWebCardClickListener);
            aVar.a(this.df, this.qt.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0308a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.3
                @Override // com.kwad.components.ad.i.a.InterfaceC0308a
                public final void V(boolean z) {
                    a.this.qt.pq = z;
                }
            });
            aVar.setActivity(this.qt.getActivity());
            aVar.aG();
            this.qt.b(this.mPlayEndPageListener);
            this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        }
    }

    @Override // com.kwad.components.ad.i.a.b
    public final void in() {
        e.t(this.qt);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.df = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this.mPlayEndPageListener);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
