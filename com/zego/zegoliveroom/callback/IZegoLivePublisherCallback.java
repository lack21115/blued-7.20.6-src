package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/callback/IZegoLivePublisherCallback.class */
public interface IZegoLivePublisherCallback {
    void onCaptureAudioFirstFrame();

    void onCaptureVideoFirstFrame();

    void onCaptureVideoSizeChangedTo(int i, int i2);

    void onJoinLiveRequest(int i, String str, String str2, String str3);

    void onPublishQualityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality);

    void onPublishStateUpdate(int i, String str, HashMap<String, Object> hashMap);
}
