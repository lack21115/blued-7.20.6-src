package com.kwad.components.ad.reward.j;

import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/j/b.class */
public final class b {
    private IAdLivePlayModule eV;
    private a gU;
    private int xD = 0;

    public b(a aVar) {
        this.gU = aVar;
    }

    public final void a(i iVar, AdLivePlayStateListener adLivePlayStateListener) {
        if (!jF()) {
            this.gU.a(iVar);
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.registerAdLivePlayStateListener(adLivePlayStateListener);
        }
    }

    public final void a(IAdLivePlayModule iAdLivePlayModule) {
        this.eV = iAdLivePlayModule;
    }

    public final void b(i iVar, AdLivePlayStateListener adLivePlayStateListener) {
        if (!jF()) {
            this.gU.b(iVar);
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.unRegisterAdLivePlayStateListener(adLivePlayStateListener);
        }
    }

    public final long getPlayDuration() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        return iAdLivePlayModule != null ? iAdLivePlayModule.getPlayDuration() : this.gU.getPlayDuration();
    }

    public final boolean jF() {
        return this.eV != null;
    }

    public final IAdLivePlayModule jG() {
        return this.eV;
    }

    public final a jH() {
        return this.gU;
    }

    public final void pause() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.pause();
        } else {
            this.gU.pause();
        }
    }

    public final void release() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        this.gU.release();
    }

    public final void releaseSync() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        this.gU.releaseSync();
    }

    public final void resume() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.gU.resume();
            return;
        }
        iAdLivePlayModule.resume();
        int i = this.xD;
        if (i > 0) {
            this.eV.setAudioEnabled(i == 2, false);
        }
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.xD = z ? 2 : 1;
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setAudioEnabled(z, z2);
        } else {
            this.gU.setAudioEnabled(z, z2);
        }
    }

    public final void skipToEnd() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.skipToEnd();
        } else {
            this.gU.skipToEnd();
        }
    }
}
