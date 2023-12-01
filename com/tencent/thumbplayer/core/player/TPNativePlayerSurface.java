package com.tencent.thumbplayer.core.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/TPNativePlayerSurface.class */
public class TPNativePlayerSurface extends Surface {
    private ITPNativePlayerSurfaceCallback mSurfaceCallback;

    public TPNativePlayerSurface(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
    }

    public void setTPSurfaceCallback(ITPNativePlayerSurfaceCallback iTPNativePlayerSurfaceCallback) {
        this.mSurfaceCallback = iTPNativePlayerSurfaceCallback;
    }
}
