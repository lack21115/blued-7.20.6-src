package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.bm;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/e.class */
public final class e extends a implements bm.a {
    private View Ru;
    private boolean Rv;
    private boolean Rw;
    private final KsAdVideoPlayConfig dZ;
    private final bm gK;
    private final AtomicBoolean mIsViewDetached;

    public e(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.gK = new bm(this);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.Rw = true;
        this.Ru = this;
        this.dZ = ksAdVideoPlayConfig;
    }

    private void onViewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onViewAttached");
            this.gK.sendEmptyMessage(1);
        }
    }

    private boolean qu() {
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
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? ag.isNetworkConnected(this.mContext) : ag.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.a.a.bH(this.mAdInfo)) {
            return ag.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.a.a.bI(this.mAdInfo)) {
            return ag.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (!this.Ql && message.what == 1) {
            if (!bl.o(this.Ru, 30)) {
                qb();
            } else if (!this.Rv) {
                pZ();
            }
            this.gK.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onAttachedToWindow");
        onViewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onDetachedFromWindow");
        onViewDetached();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        onViewAttached();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        onViewDetached();
    }

    public final void onViewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i("FeedVideoPlayerController", "onViewDetached");
        this.gK.removeCallbacksAndMessages(null);
        if (this.Rw) {
            release();
        } else {
            this.anr.pause();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.a
    public final void pZ() {
        if (!this.anr.isIdle()) {
            if (this.anr.isPaused() || this.anr.yr()) {
                qa();
                this.anr.restart();
            }
        } else if (!ag.isNetworkConnected(this.mContext)) {
            pV();
        } else {
            pW();
            if (!this.Ql && !qu() && !this.Qj) {
                pX();
                return;
            }
            qa();
            this.anr.start();
        }
    }

    public final void qt() {
        this.gK.removeCallbacksAndMessages(null);
        if (this.Rw) {
            release();
        } else {
            this.anr.pause();
        }
    }

    public final void qv() {
        this.anr.pause();
        this.Rv = true;
    }

    public final void qw() {
        pZ();
        this.Rv = false;
    }

    public final void qx() {
        this.Rv = false;
    }

    public final void setAutoRelease(boolean z) {
        this.Rw = z;
    }
}
