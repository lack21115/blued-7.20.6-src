package com.zego.zegoavkit2.audioobserver;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioobserver/ZegoAudioObserver.class */
public class ZegoAudioObserver {
    public void setAudioObserverCallback(IZegoAudioObserverCallback iZegoAudioObserverCallback) {
        ZegoAudioObserverJNI.setAudioObserverCallback(iZegoAudioObserverCallback);
    }

    public boolean startAudioObserver(int i, int i2, int i3) {
        return ZegoAudioObserverJNI.startAudioObserver(i, i2, i3);
    }

    public void stopAudioObserver() {
        ZegoAudioObserverJNI.stopAudioObserver();
    }
}
