package com.zego.zegoavkit2.videorender;

import com.zego.zegoavkit2.entities.VideoFrame;
import com.zego.zegoavkit2.enums.VideoPixelFormat;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videorender/IZegoVideoRenderCallback.class */
public interface IZegoVideoRenderCallback {
    void onVideoRenderCallback(VideoFrame videoFrame, VideoPixelFormat videoPixelFormat, String str);

    void setFlipMode(String str, int i);

    void setRotation(String str, int i);
}
