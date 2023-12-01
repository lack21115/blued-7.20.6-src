package com.zego.zegoavkit2.playaudiorecorder;

import com.zego.zegoavkit2.entities.ZegoAudioFrame;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/playaudiorecorder/ZegoPlayAudioRecorderJNI.class */
public class ZegoPlayAudioRecorderJNI {
    private static volatile IZegoPlayAudioRecorderCallback sCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enablePlayAudioRecorder(boolean z, int i, int i2);

    static void onPlayAudioRecorder(String str, ZegoAudioFrame zegoAudioFrame) {
        IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback = sCallback;
        if (iZegoPlayAudioRecorderCallback != null) {
            iZegoPlayAudioRecorderCallback.onPlayAudioRecorder(str, zegoAudioFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setPlayAudioRecorderCallback(IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback) {
        sCallback = iZegoPlayAudioRecorderCallback;
    }
}
