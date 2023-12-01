package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.bm;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/f.class */
public final class f extends com.kwad.components.core.video.a implements bm.a {
    private boolean Dr;
    private View Ru;
    private boolean Rx;
    private final bm gK;
    private final AtomicBoolean mIsViewDetached;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/f$a.class */
    public interface a extends a.c {
        void onVideoPlayError(int i, int i2);
    }

    public f(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.gK = new bm(this);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.Dr = false;
        this.Rx = false;
        this.Ru = this;
    }

    private void onViewAttached() {
        if (this.mIsViewDetached.getAndSet(false)) {
            com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onViewAttached");
            this.gK.sendEmptyMessage(1);
        }
    }

    private void onViewDetached() {
        if (this.mIsViewDetached.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onViewDetached");
        this.gK.removeCallbacksAndMessages(null);
        release();
    }

    private void qy() {
        this.Dr = false;
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (!this.Dr && message.what == 1) {
            if (bl.o(this.Ru, 70)) {
                pZ();
            } else {
                qb();
            }
            this.gK.sendEmptyMessageDelayed(1, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.a
    public final void eU() {
        if (this.Rx) {
            super.eU();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        qy();
        onViewAttached();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        onViewDetached();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        onViewAttached();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.b.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        onViewDetached();
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
    public final void pT() {
        super.pT();
        if (this.nn != null) {
            this.nn.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        if (this.no != null) {
            this.no.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void pZ() {
        super.pZ();
    }

    @Override // com.kwad.components.core.video.a
    public final void qb() {
        super.qb();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.Dr = true;
    }
}
