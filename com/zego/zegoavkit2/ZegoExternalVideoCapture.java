package com.zego.zegoavkit2;

import com.zego.zegoavkit2.videocapture.ZegoTrafficControlCallback;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoExternalVideoCapture.class */
public final class ZegoExternalVideoCapture {
    public static native boolean setTrafficControlCallback(ZegoTrafficControlCallback zegoTrafficControlCallback, int i);

    public static native boolean setVideoCaptureFactory(ZegoVideoCaptureFactory zegoVideoCaptureFactory, int i);
}
