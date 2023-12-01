package com.kwad.components.ad.draw.a.kwai;

import android.view.View;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/kwai/a.class */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    private List<Integer> cI;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean bY = false;
    private volatile boolean cJ = false;
    private j cK = new j() { // from class: com.kwad.components.ad.draw.a.kwai.a.1
        @Override // com.kwad.sdk.widget.j
        public final void aw() {
            l.cw(a.this.mAdTemplate);
        }
    };
    private i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.draw.a.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            com.kwad.sdk.core.report.a.av(a.this.mAdTemplate);
            if (a.this.bW.bV != null) {
                try {
                    a.this.bW.bV.onVideoPlayEnd();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i, int i2) {
            super.onVideoPlayError(i, i2);
            if (a.this.bW.bV != null) {
                try {
                    a.this.bW.bV.onVideoPlayError();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            if (a.this.bW.bV != null) {
                try {
                    a.this.bW.bV.onVideoPlayPause();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
            a.this.bY = true;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.c(j2);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            a.this.cJ = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.bW.bV != null) {
                a.this.bW.bV.onAdShow();
            }
            if (a.this.bW.bV != null) {
                try {
                    a.this.bW.bV.onVideoPlayStart();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
                a.this.bY = false;
            }
            com.kwad.components.core.r.b.pK().a(a.this.mAdTemplate, null, null);
            com.kwad.sdk.core.report.a.h(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            if (!a.this.bY) {
                if (a.this.cJ) {
                    return;
                }
                a.this.cJ = true;
                com.kwad.components.core.m.a.pb().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                return;
            }
            a.this.bY = false;
            if (a.this.bW.bV != null) {
                try {
                    a.this.bW.bV.onVideoPlayResume();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }
    };

    private void a(j jVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(jVar);
        }
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
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, (JSONObject) null);
                this.cI.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.bW.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        this.cI = com.kwad.sdk.core.response.a.a.bd(cb);
        this.bW.bX.a(this.mVideoPlayStateListener);
        a(this.cK);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.bX.b(this.mVideoPlayStateListener);
        a((j) null);
    }
}
