package com.zego.zegoavkit2.audioobserver;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioobserver/IZegoAudioObserverCallback.class */
public interface IZegoAudioObserverCallback {
    void onAudioObserverError(int i);

    void onCapturedAudioData(byte[] bArr, int i, int i2, int i3);

    void onMixAudioData(byte[] bArr, int i, int i2, int i3);

    void onPlaybackAudioData(byte[] bArr, int i, int i2, int i3);
}
