package com.kwad.components.ad.e.b;

import android.content.Context;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.l;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/b/a.class */
public final class a extends com.kwad.components.ad.h.a {
    private KsAdVideoPlayConfig dZ;
    private final c dk;
    private boolean eQ;
    private a.b eY;
    private OfflineOnAudioConflictListener eZ;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;
    private b mViewVisibleHelper;
    private boolean nJ;
    private boolean nK;
    private j nL;

    public a(final AdTemplate adTemplate, b bVar, DetailVideoView detailVideoView, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.dk = new c() { // from class: com.kwad.components.ad.e.b.a.3
            @Override // com.kwad.sdk.core.g.c
            public final void onPageInvisible() {
                com.kwad.components.core.h.a.nC().c(a.this.eY);
                a.this.pause();
            }

            @Override // com.kwad.sdk.core.g.c
            public final void onPageVisible() {
                com.kwad.components.core.h.a.nC().a(a.this.getCurrentVoiceItem());
                a.this.resume();
            }
        };
        this.eZ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.e.b.a.5
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.mViewVisibleHelper = bVar;
        this.mAdInfo = d.cb(this.mAdTemplate);
        this.nJ = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bG(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.dZ = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
        this.nL = new j() { // from class: com.kwad.components.ad.e.b.a.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i, int i2) {
                super.onVideoPlayError(i, i2);
                com.kwad.components.core.m.a.pb().b(adTemplate, i, i2);
            }
        };
        this.Gj.c(this.nL);
        aT();
        this.Gj.a(new c.e() { // from class: com.kwad.components.ad.e.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                if (a.this.eZ() && a.this.mViewVisibleHelper.et()) {
                    a.this.Gj.a(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(a.this.mAdTemplate));
                    com.kwad.components.core.h.a.nC().a(a.this.getCurrentVoiceItem());
                    a.this.Gj.start();
                }
            }
        });
    }

    private void aT() {
        this.Gj.a(new b.a(this.mAdTemplate).bs(d.cd(this.mAdTemplate)).bt(f.b(d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).aV(this.hasNoCache).b(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate)).tR(), true, true, this.mDetailVideoView);
        setAudioEnabled(g(this.nJ));
        if (eZ()) {
            this.Gj.prepareAsync();
            com.kwad.components.core.r.a.aj(this.mContext).a(this.eZ);
        }
    }

    static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eZ() {
        if (this.nK) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dZ;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (ag.isWifiConnected(this.mContext)) {
                    return true;
                }
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ag.isMobileConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.a.a.bH(this.mAdInfo) && ag.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bI(this.mAdInfo) && ag.isWifiConnected(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (z) {
            if (this.eY != null) {
                com.kwad.components.core.h.a.nC();
                if (!com.kwad.components.core.h.a.b(this.eY)) {
                    return false;
                }
            }
            if (!com.kwad.sdk.core.config.d.gz()) {
                return !com.kwad.components.core.r.a.aj(this.mContext).pJ() ? com.kwad.components.core.r.a.aj(this.mContext).aL(false) : !com.kwad.components.core.r.a.aj(this.mContext).pI();
            }
            if (!this.eQ) {
                this.eQ = com.kwad.components.core.r.a.aj(this.mContext).aL(true);
            }
            return this.eQ;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.e.b.a.4
                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.g(aVar.nJ));
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.Gj.setAudioEnabled(z);
    }

    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.c(iVar);
    }

    public final void aR() {
        l.cw(this.mAdTemplate);
        if (this.Gj.qe() == null) {
            aT();
        }
        if (eZ() && this.mViewVisibleHelper.et()) {
            this.Gj.a(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate));
            com.kwad.components.core.h.a.nC().a(getCurrentVoiceItem());
            this.Gj.start();
        }
        this.mViewVisibleHelper.a(this.dk);
    }

    public final void aS() {
        l.cu(this.mAdTemplate);
        this.mViewVisibleHelper.b(this.dk);
        this.Gj.release();
        com.kwad.components.core.h.a.nC().c(this.eY);
        com.kwad.components.core.r.a.aj(this.mContext).b(this.eZ);
    }

    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.d(iVar);
    }

    public final void fa() {
        this.nK = true;
        if (this.mViewVisibleHelper.et()) {
            l.cv(this.mAdTemplate);
            this.Gj.a(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate));
            com.kwad.components.core.h.a.nC().a(getCurrentVoiceItem());
            this.Gj.start();
        }
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
    }

    public final void resume() {
        com.kwad.components.core.h.a.nC().a(getCurrentVoiceItem());
        setAudioEnabled(g(this.nJ));
        if (eZ()) {
            this.Gj.resume();
        }
    }
}
