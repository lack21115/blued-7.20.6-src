package com.zego.zegoavkit2.mediaside;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediaside/ZegoMediaSideInfoJNI.class */
final class ZegoMediaSideInfoJNI {
    private static volatile IZegoMediaSideCallback sCallback;

    ZegoMediaSideInfoJNI() {
    }

    public static void onMediaSideCallback(String str, ByteBuffer byteBuffer, int i) {
        IZegoMediaSideCallback iZegoMediaSideCallback = sCallback;
        if (iZegoMediaSideCallback != null) {
            iZegoMediaSideCallback.onRecvMediaSideInfo(str, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void sendMediaSideInfo(ByteBuffer byteBuffer, int i, boolean z, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCallback(IZegoMediaSideCallback iZegoMediaSideCallback) {
        sCallback = iZegoMediaSideCallback;
        if (iZegoMediaSideCallback != null) {
            setMediaSideCallback(true);
        } else {
            setMediaSideCallback(false);
        }
    }

    private static native void setMediaSideCallback(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setMediaSideFlags(boolean z, boolean z2, int i, int i2, int i3);
}
