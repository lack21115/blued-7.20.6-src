package com.zego.zegoavkit2.videorender;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videorender/VideoRenderType.class */
public enum VideoRenderType {
    VIDEO_RENDER_TYPE_NONE(0),
    VIDEO_RENDER_TYPE_RGB(1),
    VIDEO_RENDER_TYPE_YUV(2),
    VIDEO_RENDER_TYPE_ANY(3),
    VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_RGB(4),
    VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_YUV(5);
    
    private int mType;

    VideoRenderType(int i) {
        this.mType = i;
    }

    public static VideoRenderType valueOf(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? VIDEO_RENDER_TYPE_NONE : VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_YUV : VIDEO_RENDER_TYPE_EXTERNAL_INTERNAL_RGB : VIDEO_RENDER_TYPE_ANY : VIDEO_RENDER_TYPE_YUV : VIDEO_RENDER_TYPE_RGB : VIDEO_RENDER_TYPE_NONE;
    }

    public int value() {
        return this.mType;
    }
}
