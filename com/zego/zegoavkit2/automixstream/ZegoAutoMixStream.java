package com.zego.zegoavkit2.automixstream;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/automixstream/ZegoAutoMixStream.class */
public class ZegoAutoMixStream {
    public void setCallback(IZegoAutoMixStreamCallback iZegoAutoMixStreamCallback) {
        ZegoAutoMixStreamJNI.setCallback(iZegoAutoMixStreamCallback);
    }

    public void setSoundLevelCallback(IZegoSoundLevelInAutoMixStreamCallback iZegoSoundLevelInAutoMixStreamCallback) {
        ZegoAutoMixStreamJNI.setSoundLevelCallback(iZegoSoundLevelInAutoMixStreamCallback);
    }

    public int startAutoMixStream(String str, String str2, ZegoAutoMixStreamConfig zegoAutoMixStreamConfig) {
        return ZegoAutoMixStreamJNI.startAutoMixStream(str, str2, zegoAutoMixStreamConfig);
    }

    public int stopAutoMixStream(String str, String str2) {
        return ZegoAutoMixStreamJNI.stopAutoMixStream(str, str2);
    }
}
