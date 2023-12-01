package com.zego.zegoavkit2.audioencryptdecrypt;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioencryptdecrypt/ZegoAudioEncryptDecryptJNI.class */
final class ZegoAudioEncryptDecryptJNI {
    private static volatile IZegoAudioEncryptDecryptCallback sCallback;

    ZegoAudioEncryptDecryptJNI() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableAudioEncryptDecrypt(boolean z);

    static int onAudioEncryptDecrypt(String str, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2) {
        IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback = sCallback;
        if (iZegoAudioEncryptDecryptCallback != null) {
            return iZegoAudioEncryptDecryptCallback.onAudioEncryptDecrypt(str, byteBuffer, i, byteBuffer2, i2);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZegoAudioEncryptDecryptCallback(IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback) {
        sCallback = iZegoAudioEncryptDecryptCallback;
    }
}
