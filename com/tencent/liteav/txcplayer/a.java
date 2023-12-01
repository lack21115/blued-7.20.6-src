package com.tencent.liteav.txcplayer;

import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/a.class */
public abstract class a implements ITXVCubePlayer {
    private ITXVCubePlayer.b mOnBufferingUpdateListener;
    private ITXVCubePlayer.c mOnCompletionListener;
    private ITXVCubePlayer.d mOnErrorListener;
    private ITXVCubePlayer.a mOnGetTargetState;
    private ITXVCubePlayer.e mOnHLSKeyErrorListener;
    private ITXVCubePlayer.f mOnHevcVideoDecoderErrorListener;
    private ITXVCubePlayer.g mOnInfoListener;
    private ITXVCubePlayer.h mOnPreparedListener;
    private ITXVCubePlayer.i mOnSeekCompleteListener;
    private ITXVCubePlayer.j mOnTimedTextListener;
    private ITXVCubePlayer.k mOnVideoDecoderErrorListener;
    private ITXVCubePlayer.l mOnVideoSizeChangedListener;

    public int getTXCVodVideoViewTargetState() {
        ITXVCubePlayer.a aVar = this.mOnGetTargetState;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public final void notifyHLSKeyError() {
        ITXVCubePlayer.e eVar = this.mOnHLSKeyErrorListener;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void notifyHevcVideoDecoderError() {
        ITXVCubePlayer.f fVar = this.mOnHevcVideoDecoderErrorListener;
        if (fVar != null) {
            fVar.a();
        }
    }

    public final void notifyOnBufferingUpdate(int i) {
    }

    public final void notifyOnCompletion() {
        ITXVCubePlayer.c cVar = this.mOnCompletionListener;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        ITXVCubePlayer.d dVar = this.mOnErrorListener;
        if (dVar != null) {
            dVar.a(i, i2);
            return true;
        }
        return false;
    }

    public final boolean notifyOnInfo(int i, int i2, int i3, Object obj) {
        ITXVCubePlayer.g gVar = this.mOnInfoListener;
        if (gVar != null) {
            gVar.a(i, i2, i3, obj);
            return true;
        }
        return false;
    }

    public final void notifyOnPrepared() {
        ITXVCubePlayer.h hVar = this.mOnPreparedListener;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        ITXVCubePlayer.i iVar = this.mOnSeekCompleteListener;
        if (iVar != null) {
            iVar.a();
        }
    }

    public final void notifyOnTimedText(com.tencent.liteav.txcplayer.d.d dVar) {
    }

    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, int i4, String str) {
        ITXVCubePlayer.l lVar = this.mOnVideoSizeChangedListener;
        if (lVar != null) {
            lVar.a(this, i, i2, str);
        }
    }

    public final void notifyVideoDecoderError() {
        ITXVCubePlayer.k kVar = this.mOnVideoDecoderErrorListener;
        if (kVar != null) {
            kVar.a();
        }
    }

    public void resetListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnTimedTextListener = null;
        this.mOnHLSKeyErrorListener = null;
        this.mOnHevcVideoDecoderErrorListener = null;
        this.mOnVideoDecoderErrorListener = null;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnBufferingUpdateListener(ITXVCubePlayer.b bVar) {
        this.mOnBufferingUpdateListener = bVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnCompletionListener(ITXVCubePlayer.c cVar) {
        this.mOnCompletionListener = cVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnErrorListener(ITXVCubePlayer.d dVar) {
        this.mOnErrorListener = dVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setOnGetTXCVodVideoViewTargetState(ITXVCubePlayer.a aVar) {
        this.mOnGetTargetState = aVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnHLSKeyErrorListener(ITXVCubePlayer.e eVar) {
        this.mOnHLSKeyErrorListener = eVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnHevcVideoDecoderErrorListener(ITXVCubePlayer.f fVar) {
        this.mOnHevcVideoDecoderErrorListener = fVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnInfoListener(ITXVCubePlayer.g gVar) {
        this.mOnInfoListener = gVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnPreparedListener(ITXVCubePlayer.h hVar) {
        this.mOnPreparedListener = hVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnSeekCompleteListener(ITXVCubePlayer.i iVar) {
        this.mOnSeekCompleteListener = iVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnTimedTextListener(ITXVCubePlayer.j jVar) {
        this.mOnTimedTextListener = jVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnVideoDecoderErrorListener(ITXVCubePlayer.k kVar) {
        this.mOnVideoDecoderErrorListener = kVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public final void setOnVideoSizeChangedListener(ITXVCubePlayer.l lVar) {
        this.mOnVideoSizeChangedListener = lVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setPrivateConfig(Map<String, Object> map) {
    }
}
