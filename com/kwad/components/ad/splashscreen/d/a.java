package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/d/a.class */
public final class a extends com.kwad.components.ad.h.a implements c {
    private boolean Ed;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nJ;
    private OfflineOnAudioConflictListener xB;
    private String xv;
    private final List<h.a> xz;

    public a(AdTemplate adTemplate, final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.xz = new ArrayList();
        this.xB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.xz) {
                    for (h.a aVar : a.this.xz) {
                        aVar.onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.xz) {
                    for (h.a aVar : a.this.xz) {
                        aVar.onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String aS = com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(aS);
        if (aX != null && aX.exists()) {
            this.xv = aX.getAbsolutePath();
        }
        this.Gj.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                boolean a2 = bl.a(detailVideoView, 50, true);
                b.d("SplashPlayModule", " onPrepared" + a2);
                if (a2) {
                    a.this.Gj.start();
                }
            }
        });
        com.kwad.components.core.r.a.aj(this.mContext).a(this.xB);
    }

    private void aT() {
        this.Gj.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).bs(this.xv).bt(f.b(d.cc(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate)).tR(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gj.prepareAsync();
    }

    private void resume() {
        this.Gj.resume();
        if (this.nJ && this.Ed) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(false);
            if (com.kwad.components.core.r.a.aj(this.mContext).pI()) {
                this.nJ = false;
                setAudioEnabled(false, false);
            }
        }
    }

    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.c(iVar);
    }

    public final void a(h.a aVar) {
        this.xz.add(aVar);
    }

    public final void aj(boolean z) {
        this.Ed = true;
    }

    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.d(iVar);
    }

    public final void b(h.a aVar) {
        this.xz.remove(aVar);
    }

    public final long getCurrentPosition() {
        return this.Gj.getCurrentPosition();
    }

    public final void lq() {
        if (this.Gj.qe() == null) {
            aT();
        }
        this.Gj.start();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        pause();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        resume();
    }

    public final void pause() {
        this.Gj.pause();
    }

    @Override // com.kwad.components.ad.h.a
    public final void release() {
        super.release();
        if (this.Gj != null) {
            this.Gj.clear();
            this.Gj.release();
        }
        com.kwad.components.core.r.a.aj(this.mContext).b(this.xB);
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.nJ = z;
        if (z && z2) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        this.Gj.setAudioEnabled(z);
    }
}
