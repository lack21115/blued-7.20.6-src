package com.kwad.components.ad.reward.presenter.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.n;
import com.kwad.components.core.r.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/b/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private List<Integer> cI;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private final g tJ = new g();
    private long mPlayTime = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean tK = true;
    private volatile boolean cJ = false;
    private Runnable tL = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.tJ.qE()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long qG = a.this.tJ.qG();
                int qH = a.this.tJ.qF().qH();
                a.this.qt.a(elapsedRealtime - qG, a.this.tJ.qF().qI(), qH);
            } else if (a.this.tK) {
                a.this.qt.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.m.a.pb().P(a.this.mAdTemplate);
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.b.a.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.hx();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            super.onLivePlayPause();
            a.this.tJ.qD();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            a.this.c(j);
            a.this.mPlayTime = j;
            a.this.tJ.qD();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.mAdTemplate, a.this.qt.mPageEnterTime);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.hQ();
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.b.a.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.tJ.qC();
            a.this.mHandler.removeCallbacks(a.this.tL);
            a.this.mHandler.postDelayed(a.this.tL, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.tJ.qC();
            a.this.mHandler.removeCallbacks(a.this.tL);
            a.this.mHandler.postDelayed(a.this.tL, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.hx();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i, int i2) {
            super.onVideoPlayError(i, i2);
            com.kwad.components.ad.reward.monitor.a.a(a.this.qt.pf, a.this.qt.mAdTemplate, a.this.qt.pB, i, i2);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            a.this.tJ.qD();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.mPlayTime = j2;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            a.this.hQ();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            a.this.tJ.qD();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qt.pf, a.this.mAdTemplate, a.this.qt.mPageEnterTime);
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.tK = false;
        return false;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cJ = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cI) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, this.qt.mReportExtData);
                this.cI.remove(num);
                return;
            }
        }
    }

    private void checkExposure() {
        long j = this.mAdInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || com.kwad.sdk.core.response.a.a.X(this.mAdInfo) <= 5000) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.b.a.4
            @Override // java.lang.Runnable
            public final void run() {
                n.a(1, a.this.qt);
            }
        }, j);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        this.cI = com.kwad.sdk.core.response.a.a.bd(cb);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.mHandler.postDelayed(this.tL, 5000L);
    }

    public final void hQ() {
        com.kwad.sdk.core.report.i iVar;
        this.cJ = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        if (createFromAdInfo != null) {
            iVar = new com.kwad.sdk.core.report.i();
            y.a aVar = new y.a();
            aVar.ajZ = String.valueOf(createFromAdInfo.getValue());
            iVar.a(aVar);
        } else {
            iVar = null;
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        b.pK().a(this.mAdTemplate, null, iVar);
        com.kwad.sdk.core.report.a.g(this.mAdTemplate, this.qt.mReportExtData);
    }

    public final void hx() {
        if (!this.qt.pf || !this.qt.pk) {
            com.kwad.sdk.core.report.a.h(this.mAdTemplate, this.qt.mReportExtData);
        }
        this.tJ.qD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        g.a qF = this.tJ.qF();
        com.kwad.components.core.m.a.pb().a(this.qt.mAdTemplate, this.mPlayTime, qF.qI(), qF.qH());
    }
}
