package com.zego.zegoavkit2.audioencryptdecrypt;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioencryptdecrypt/ZegoAudioEncryptDecrypt.class */
public class ZegoAudioEncryptDecrypt implements IZegoAudioEncryptDecryptCallback {
    private volatile IZegoAudioEncryptDecryptCallback mAudioEncryptDecryptCallback = null;

    public static void enableAudioEncryptDecrypt(boolean z) {
        ZegoAudioEncryptDecryptJNI.enableAudioEncryptDecrypt(z);
    }

    @Override // com.zego.zegoavkit2.audioencryptdecrypt.IZegoAudioEncryptDecryptCallback
    public int onAudioEncryptDecrypt(String str, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2) {
        IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback = this.mAudioEncryptDecryptCallback;
        if (iZegoAudioEncryptDecryptCallback != null) {
            return iZegoAudioEncryptDecryptCallback.onAudioEncryptDecrypt(str, byteBuffer, i, byteBuffer2, i2);
        }
        return 0;
    }

    public void setAudioEncryptDecryptCallback(IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback) {
        this.mAudioEncryptDecryptCallback = iZegoAudioEncryptDecryptCallback;
        if (iZegoAudioEncryptDecryptCallback != null) {
            ZegoAudioEncryptDecryptJNI.setZegoAudioEncryptDecryptCallback(this);
        } else {
            ZegoAudioEncryptDecryptJNI.setZegoAudioEncryptDecryptCallback(null);
        }
    }
}
