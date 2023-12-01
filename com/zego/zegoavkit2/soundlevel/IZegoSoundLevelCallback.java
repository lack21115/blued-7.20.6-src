package com.zego.zegoavkit2.soundlevel;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/soundlevel/IZegoSoundLevelCallback.class */
public interface IZegoSoundLevelCallback {
    void onCaptureSoundLevelUpdate(ZegoSoundLevelInfo zegoSoundLevelInfo);

    void onSoundLevelUpdate(ZegoSoundLevelInfo[] zegoSoundLevelInfoArr);
}
