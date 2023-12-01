package com.huawei.hms.ads.nativead;

import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.bt;
import com.huawei.openalliance.ad.views.NativeVideoView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/c.class */
public class c implements VideoOperator {
    private boolean B;
    private VideoOperator.VideoLifecycleListener Code;
    private bt I;
    private b V;
    private MediaView Z;

    public c(bt btVar) {
        this.B = false;
        this.I = btVar;
        if (btVar != null) {
            this.B = btVar.Z();
        }
    }

    public MediaContent Code() {
        NativeVideoView I;
        b bVar = this.V;
        if (bVar == null || (I = bVar.I()) == null) {
            return null;
        }
        return I.getMediaContent();
    }

    public final void Code(MediaView mediaView) {
        this.Z = mediaView;
        this.V = mediaView.getMediaViewAdapter();
        VideoOperator.VideoLifecycleListener videoLifecycleListener = this.Code;
        if (videoLifecycleListener != null) {
            setVideoLifecycleListener(videoLifecycleListener);
        }
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public float getAspectRatio() {
        bt btVar = this.I;
        if (btVar != null) {
            return btVar.I();
        }
        return 0.0f;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public VideoOperator.VideoLifecycleListener getVideoLifecycleListener() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean hasVideo() {
        bt btVar = this.I;
        return btVar != null && btVar.Code();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean isClickToFullScreenEnabled() {
        return false;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean isCustomizeOperateEnabled() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean isMuted() {
        bt btVar = this.I;
        return btVar != null && btVar.V();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void mute(boolean z) {
        b bVar = this.V;
        if (bVar == null || !this.B) {
            return;
        }
        if (z) {
            bVar.I().C();
        } else {
            bVar.I().F();
        }
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void pause() {
        b bVar;
        if (!this.B || (bVar = this.V) == null) {
            return;
        }
        bVar.I().L();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void play() {
        b bVar;
        if (!this.B || (bVar = this.V) == null) {
            return;
        }
        bVar.I().D();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public final void setVideoLifecycleListener(VideoOperator.VideoLifecycleListener videoLifecycleListener) {
        this.Code = videoLifecycleListener;
        b bVar = this.V;
        if (bVar != null) {
            bVar.Code(videoLifecycleListener);
        }
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void stop() {
        b bVar;
        if (!this.B || (bVar = this.V) == null) {
            return;
        }
        bVar.I().S();
    }
}
