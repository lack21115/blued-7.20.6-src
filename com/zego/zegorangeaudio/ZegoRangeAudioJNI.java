package com.zego.zegorangeaudio;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegorangeaudio/ZegoRangeAudioJNI.class */
final class ZegoRangeAudioJNI {
    private static volatile IJniZegoRangeAudioCallback sJniZegoRangeAudioCallback;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegorangeaudio/ZegoRangeAudioJNI$IJniZegoRangeAudioCallback.class */
    interface IJniZegoRangeAudioCallback {
        void onRangAudioMicrophone(int i, int i2);
    }

    ZegoRangeAudioJNI() {
    }

    public static native boolean enableRangeAudioCallback(boolean z);

    public static native void enableRangeAudioMicrophone(boolean z);

    public static native void enableRangeAudioSpeaker(boolean z);

    public static native void enableSpatializer(boolean z);

    public static native boolean initRangeAudio();

    public static native void muteRangeAudioUser(String str, boolean z);

    public static void onRangAudioMicrophone(int i, int i2) {
        IJniZegoRangeAudioCallback iJniZegoRangeAudioCallback = sJniZegoRangeAudioCallback;
        if (iJniZegoRangeAudioCallback != null) {
            iJniZegoRangeAudioCallback.onRangAudioMicrophone(i, i2);
        }
    }

    public static native void setAudioRecvRange(float f);

    public static native void setPositionUpdateFrequency(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean setRangeAudioJNICallback(IJniZegoRangeAudioCallback iJniZegoRangeAudioCallback) {
        sJniZegoRangeAudioCallback = iJniZegoRangeAudioCallback;
        return enableRangeAudioCallback(iJniZegoRangeAudioCallback != null);
    }

    public static native void setRangeAudioMode(int i);

    public static native void setRangeAudioTeamID(String str);

    public static native void setRangeAudioVolume(int i);

    public static native void unInitRangeAudio();

    public static native void updateAudioSource(String str, float[] fArr);

    public static native void updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    public static native void updateStreamPosition(String str, float[] fArr);

    public static native void updateStreamVocalRange(String str, float f);
}
