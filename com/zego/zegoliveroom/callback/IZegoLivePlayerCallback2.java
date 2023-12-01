package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoPlayStats;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/callback/IZegoLivePlayerCallback2.class */
public interface IZegoLivePlayerCallback2 extends IZegoLivePlayerCallback {
    void onPlayStatsUpdate(ZegoPlayStats zegoPlayStats);

    void onPlayVideoSuperResolutionUpdate(String str, int i, int i2);

    void onRecvRemoteAudioFirstFrame(String str);

    void onRecvRemoteVideoFirstFrame(String str);

    void onRemoteCameraStatusUpdate(String str, int i, int i2);

    void onRemoteMicStatusUpdate(String str, int i, int i2);

    void onRemoteSpeakerStatusUpdate(String str, int i, int i2);

    void onRenderRemoteVideoFirstFrame(String str);

    void onVideoDecoderError(int i, int i2, String str);
}
