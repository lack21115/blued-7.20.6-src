package com.zego.zegoavkit2.audioprocessing;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoAudioProcessingJNI.class */
final class ZegoAudioProcessingJNI {
    ZegoAudioProcessingJNI() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean enableReverb(boolean z, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean enableSpeechEnhance(boolean z, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean enableVirtualStereo(boolean z, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setAdvancedReverbParam(boolean z, ZegoAudioAdvancedReverbParam zegoAudioAdvancedReverbParam);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setAudioEqualizerGain(int i, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setElectronicEffects(boolean z, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setReverbEchoParam(ZegoReverbEchoParam zegoReverbEchoParam);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setReverbParam(float f, float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setReverbParam2(ZegoAudioReverbParam zegoAudioReverbParam);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setReverbPreset(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setVoiceChangerParam(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setVoicePreset(int i);
}
