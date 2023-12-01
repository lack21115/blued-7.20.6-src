package com.zego.zegoliveroom.callback;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/callback/IZegoLivePublisherCallback2.class */
public interface IZegoLivePublisherCallback2 {
    void onCaptureVideoFirstFrame(int i);

    void onCaptureVideoSizeChangedTo(int i, int i2, int i3);

    void onPreviewVideoFirstFrame(int i);

    void onSendLocalAudioFirstFrame(int i);

    void onSendLocalVideoFirstFrame(int i);

    void onVideoEncoderChanged(int i, int i2, int i3);

    void onVideoEncoderError(int i, int i2, int i3);
}
