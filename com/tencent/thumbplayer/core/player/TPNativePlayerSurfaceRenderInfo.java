package com.tencent.thumbplayer.core.player;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/TPNativePlayerSurfaceRenderInfo.class */
public class TPNativePlayerSurfaceRenderInfo {
    public int displayWidth = -1;
    public int displayHeight = -1;
    public TPVideoCropInfo videoCropInfo = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/TPNativePlayerSurfaceRenderInfo$TPVideoCropInfo.class */
    public static class TPVideoCropInfo {
        public int width = -1;
        public int height = -1;
        public int cropLeft = -1;
        public int cropRight = -1;
        public int cropTop = -1;
        public int cropBottom = -1;

        public String toString() {
            return "width:" + this.width + ", height:" + this.height + ", cropLeft:" + this.cropLeft + ", cropRight:" + this.cropRight + ", cropTop:" + this.cropTop + ", cropBottom:" + this.cropBottom;
        }
    }
}
