package com.zego.zegoavkit2.mediaside;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mediaside/ZegoMediaSideInfo.class */
public class ZegoMediaSideInfo {
    private volatile IZegoMediaSideCallback mZegoMediaSideCallback;

    public void sendMediaSideInfo(ByteBuffer byteBuffer, int i, boolean z, int i2) {
        ZegoMediaSideInfoJNI.sendMediaSideInfo(byteBuffer, i, z, i2);
    }

    public void setMediaSideFlags(boolean z, boolean z2, int i) {
        ZegoMediaSideInfoJNI.setMediaSideFlags(z, z2, 0, 0, i);
    }

    public void setMediaSideFlags(boolean z, boolean z2, int i, int i2, int i3) {
        ZegoMediaSideInfoJNI.setMediaSideFlags(z, z2, i, i2, i3);
    }

    public void setZegoMediaSideCallback(IZegoMediaSideCallback iZegoMediaSideCallback) {
        this.mZegoMediaSideCallback = iZegoMediaSideCallback;
        if (iZegoMediaSideCallback != null) {
            ZegoMediaSideInfoJNI.setCallback(new IZegoMediaSideCallback() { // from class: com.zego.zegoavkit2.mediaside.ZegoMediaSideInfo.1
                @Override // com.zego.zegoavkit2.mediaside.IZegoMediaSideCallback
                public void onRecvMediaSideInfo(String str, ByteBuffer byteBuffer, int i) {
                    IZegoMediaSideCallback iZegoMediaSideCallback2 = ZegoMediaSideInfo.this.mZegoMediaSideCallback;
                    if (iZegoMediaSideCallback2 != null) {
                        iZegoMediaSideCallback2.onRecvMediaSideInfo(str, byteBuffer, i);
                    }
                }
            });
        } else {
            ZegoMediaSideInfoJNI.setCallback(null);
        }
    }
}
