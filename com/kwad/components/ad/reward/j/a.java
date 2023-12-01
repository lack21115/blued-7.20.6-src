package com.kwad.components.ad.reward.j;

import android.content.Context;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/j/a.class */
public final class a extends com.kwad.components.ad.h.a implements j.a {
    private boolean li;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nJ;
    private com.kwad.components.core.video.j nL;
    private j qt;
    private final List<InterfaceC0494a> xA;
    private OfflineOnAudioConflictListener xB;
    private String xv;
    private AtomicBoolean xw;
    private boolean xx;
    private boolean xy;
    private final List<h.a> xz;

    /* renamed from: com.kwad.components.ad.reward.j.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/j/a$a.class */
    public interface InterfaceC0494a {
        void iX();
    }

    public a(j jVar, boolean z) {
        super(jVar.mAdTemplate, jVar.oM);
        this.xw = new AtomicBoolean(false);
        this.xx = false;
        this.xy = false;
        this.li = false;
        this.xz = new ArrayList();
        this.xA = new ArrayList();
        this.xB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.j.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.a(a.this, true);
                if (a.this.Gj != null) {
                    a.this.Gj.setAudioEnabled(false);
                }
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
        this.qt = jVar;
        this.mContext = jVar.mContext;
        this.mVideoPlayConfig = jVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.xx = z;
        this.xv = getVideoUrl();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xy = true;
        return true;
    }

    private void aT() {
        if (jE()) {
            return;
        }
        this.Gj.a(new b.a(this.mAdTemplate).bs(this.xv).bt(f.b(d.cc(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate)).tR(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gj.prepareAsync();
    }

    private String getVideoUrl() {
        if (jE()) {
            return "";
        }
        String E = com.kwad.sdk.core.response.a.a.E(d.cb(this.mAdTemplate));
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(E);
        if (aX == null || !aX.exists()) {
            String str = E;
            if (com.kwad.sdk.core.config.d.ux() > 0) {
                str = com.kwad.sdk.core.videocache.b.a.ba(this.mContext).cS(E);
            }
            return str;
        }
        return aX.getAbsolutePath();
    }

    private boolean jE() {
        return com.kwad.sdk.core.response.a.a.cq(d.cb(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.li = true;
    }

    public final void a(InterfaceC0494a interfaceC0494a) {
        this.xA.add(interfaceC0494a);
    }

    public final void a(i iVar) {
        if (iVar == null || this.Gj == null) {
            return;
        }
        this.Gj.c(iVar);
    }

    public final void a(h.a aVar) {
        this.xz.add(aVar);
    }

    public final void b(InterfaceC0494a interfaceC0494a) {
        this.xA.remove(interfaceC0494a);
    }

    public final void b(i iVar) {
        if (iVar == null || this.Gj == null) {
            return;
        }
        this.Gj.d(iVar);
    }

    public final void b(h.a aVar) {
        this.xz.remove(aVar);
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gb() {
        this.xy = false;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gc() {
        if (this.li) {
            return;
        }
        resume();
        if (this.nJ || (com.kwad.components.ad.reward.kwai.b.gz() && this.xy)) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(com.kwad.components.ad.reward.kwai.b.gz());
            if (com.kwad.components.ad.reward.kwai.b.gz() && this.xy) {
                this.xy = false;
                this.nJ = true;
                setAudioEnabled(true, false);
            } else if (this.xx || !com.kwad.components.core.r.a.aj(this.mContext).pI()) {
            } else {
                this.nJ = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gd() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void ge() {
        this.xy = false;
        if (!this.xw.get() || this.Gj == null) {
            return;
        }
        this.Gj.d(this.nL);
        this.Gj.release();
    }

    public final long getPlayDuration() {
        if (!this.xw.get() || this.Gj == null) {
            return 0L;
        }
        return this.Gj.getPlayDuration();
    }

    public final void jB() {
        if (this.xw.get()) {
            return;
        }
        this.xw.set(true);
        aT();
        this.nL = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.j.a.2
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i, int i2) {
                super.onVideoPlayError(i, i2);
                com.kwad.components.core.m.a.pb().b(a.this.mAdTemplate, i, i2);
            }
        };
        this.Gj.c(this.nL);
        this.Gj.a(new c.e() { // from class: com.kwad.components.ad.reward.j.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                com.kwad.sdk.core.b.b.vS();
                if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                    a.this.Gj.start();
                }
            }
        });
        com.kwad.components.core.r.a.aj(this.mContext).a(this.xB);
    }

    public final boolean jC() {
        return this.xx;
    }

    public final void jD() {
        for (InterfaceC0494a interfaceC0494a : this.xA) {
            interfaceC0494a.iX();
        }
    }

    public final void pause() {
        if (!this.xw.get() || this.Gj == null || jE() || j.e(this.qt)) {
            return;
        }
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

    @Override // com.kwad.components.ad.h.a
    public final void releaseSync() {
        super.releaseSync();
        if (this.Gj != null) {
            this.Gj.clear();
            this.Gj.releaseSync();
        }
        com.kwad.components.core.r.a.aj(this.mContext).b(this.xB);
    }

    public final void resume() {
        this.li = false;
        if (!this.xw.get() || this.Gj == null || jE() || j.e(this.qt)) {
            return;
        }
        this.Gj.resume();
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.nJ = z;
        if (!this.xw.get() || this.Gj == null) {
            return;
        }
        if (z && z2) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        this.Gj.setAudioEnabled(z);
    }

    @Deprecated
    public final void skipToEnd() {
        if (!this.xw.get() || this.Gj == null) {
            return;
        }
        this.Gj.onPlayStateChanged(9);
        stop();
    }
}
