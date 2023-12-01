package com.zego.zegoavkit2.audiovad;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audiovad/ZegoAudioVAD.class */
public class ZegoAudioVAD {
    private long mNativeClient;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audiovad/ZegoAudioVAD$AudioVADType.class */
    public static final class AudioVADType {
        public static final int Noise = 0;
        public static final int Speech = 1;
    }

    public ZegoAudioVAD() {
        this.mNativeClient = 0L;
        this.mNativeClient = createZegoAudioVAD();
    }

    private static native long createZegoAudioVAD();

    private static native void destroyZegoAudioVAD(long j);

    private static native int resetNative(long j);

    private static native int updateNative(long j, ByteBuffer byteBuffer, int i, int i2, int i3);

    public void finalize() {
        destroyZegoAudioVAD(this.mNativeClient);
        this.mNativeClient = 0L;
    }

    public int reset() {
        return resetNative(this.mNativeClient);
    }

    public int update(ByteBuffer byteBuffer, int i, int i2, int i3) {
        return updateNative(this.mNativeClient, byteBuffer, i, i2, i3);
    }
}
