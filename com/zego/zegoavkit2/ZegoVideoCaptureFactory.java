package com.zego.zegoavkit2;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureFactory.class */
public abstract class ZegoVideoCaptureFactory {
    protected abstract ZegoVideoCaptureDevice create(String str);

    protected abstract void destroy(ZegoVideoCaptureDevice zegoVideoCaptureDevice);
}
