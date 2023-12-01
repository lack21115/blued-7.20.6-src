package com.zego.zegoavkit2.videofilter;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videofilter/ZegoVideoFilterFactory.class */
public abstract class ZegoVideoFilterFactory {
    protected abstract ZegoVideoFilter create();

    protected abstract void destroy(ZegoVideoFilter zegoVideoFilter);
}
