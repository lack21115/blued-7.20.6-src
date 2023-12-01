package com.zego.zegoavkit2.playaudiorecorder;

import com.zego.zegoavkit2.entities.ZegoAudioFrame;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/playaudiorecorder/ZegoPlayAudioRecorder.class */
public class ZegoPlayAudioRecorder implements IZegoPlayAudioRecorderCallback {
    private volatile IZegoPlayAudioRecorderCallback playAudioRecorderCallback = null;

    public static void enablePlayAudioRecorder(boolean z, int i, int i2) {
        ZegoPlayAudioRecorderJNI.enablePlayAudioRecorder(z, i, i2);
    }

    @Override // com.zego.zegoavkit2.playaudiorecorder.IZegoPlayAudioRecorderCallback
    public void onPlayAudioRecorder(String str, ZegoAudioFrame zegoAudioFrame) {
        IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback = this.playAudioRecorderCallback;
        if (iZegoPlayAudioRecorderCallback != null) {
            iZegoPlayAudioRecorderCallback.onPlayAudioRecorder(str, zegoAudioFrame);
        }
    }

    public void setPlayAudioRecorderCallback(IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback) {
        this.playAudioRecorderCallback = iZegoPlayAudioRecorderCallback;
        if (iZegoPlayAudioRecorderCallback != null) {
            ZegoPlayAudioRecorderJNI.setPlayAudioRecorderCallback(this);
        } else {
            ZegoPlayAudioRecorderJNI.setPlayAudioRecorderCallback(null);
        }
    }
}
