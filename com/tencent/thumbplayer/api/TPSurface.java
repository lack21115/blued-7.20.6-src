package com.tencent.thumbplayer.api;

import android.graphics.SurfaceTexture;
import com.tencent.thumbplayer.adapter.a.b.c;
import com.tencent.thumbplayer.core.common.TPVideoPacket;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurface;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPSurface.class */
public final class TPSurface extends TPNativePlayerSurface {
    private ITPNativePlayerSurfaceCallback mITPSurfaceCallback;
    private ITPSurfaceListener mPlayerSurfaceListener;

    public TPSurface(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.mPlayerSurfaceListener = null;
        ITPNativePlayerSurfaceCallback iTPNativePlayerSurfaceCallback = new ITPNativePlayerSurfaceCallback() { // from class: com.tencent.thumbplayer.api.TPSurface.1
            @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback
            public void onFlush() {
                ITPSurfaceListener iTPSurfaceListener = TPSurface.this.mPlayerSurfaceListener;
                if (iTPSurfaceListener != null) {
                    iTPSurfaceListener.onFlush();
                }
            }

            @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback
            public void onRenderInfo(TPNativePlayerSurfaceRenderInfo tPNativePlayerSurfaceRenderInfo) {
                ITPSurfaceListener iTPSurfaceListener = TPSurface.this.mPlayerSurfaceListener;
                if (iTPSurfaceListener != null) {
                    iTPSurfaceListener.onRenderInfo(c.a(tPNativePlayerSurfaceRenderInfo));
                }
            }

            @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback
            public void onVideoPacket(TPVideoPacket tPVideoPacket) {
                ITPSurfaceListener iTPSurfaceListener = TPSurface.this.mPlayerSurfaceListener;
                if (iTPSurfaceListener != null) {
                    iTPSurfaceListener.onVideoPacket(c.a(tPVideoPacket));
                }
            }
        };
        this.mITPSurfaceCallback = iTPNativePlayerSurfaceCallback;
        super.setTPSurfaceCallback(iTPNativePlayerSurfaceCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.Surface
    public final void finalize() {
        super.release();
        super.finalize();
    }

    public final void setSurfaceListener(ITPSurfaceListener iTPSurfaceListener) {
        this.mPlayerSurfaceListener = iTPSurfaceListener;
    }
}
