package com.zego.zegoavkit2.audioaux;

import com.zego.zegoavkit2.entities.AuxDataEx;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioaux/ZegoAudioAuxJNI.class */
final class ZegoAudioAuxJNI {
    private static volatile IJniZegoAuxCallback sJNIzegoAuxCallback;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioaux/ZegoAudioAuxJNI$IJniZegoAuxCallback.class */
    interface IJniZegoAuxCallback {
        AuxDataEx onAuxCallback(int i);
    }

    ZegoAudioAuxJNI() {
    }

    public static native boolean enableAux(boolean z);

    public static native boolean muteAux(boolean z);

    public static AuxDataEx onAuxCallback(int i) {
        IJniZegoAuxCallback iJniZegoAuxCallback = sJNIzegoAuxCallback;
        if (iJniZegoAuxCallback != null) {
            return iJniZegoAuxCallback.onAuxCallback(i);
        }
        return null;
    }

    public static native void setAuxPlayVolume(int i);

    public static native void setAuxPublishVolume(int i);

    public static native void setAuxVolume(int i);

    public static void setCallback(IJniZegoAuxCallback iJniZegoAuxCallback) {
        sJNIzegoAuxCallback = iJniZegoAuxCallback;
    }
}
