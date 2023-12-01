package com.zego.zegoavkit2.audioprocessing;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoAudioProcessing.class */
public class ZegoAudioProcessing {

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoAudioProcessing$ZegoVoiceChangerCategory.class */
    public static final class ZegoVoiceChangerCategory {
        public static final float MEN_TO_CHILD = 8.0f;
        public static final float MEN_TO_WOMEN = 4.0f;
        public static final float NONE = 0.0f;
        public static final float WOMEN_TO_CHILD = 6.0f;
        public static final float WOMEN_TO_MEN = -3.0f;
    }

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoAudioProcessing$ZegoVoiceChangerType.class */
    public static final class ZegoVoiceChangerType {
        public static final int AI_ROBOT = 2;
        public static final int CHANGER_OFF = 0;
        public static final int ELUSIVE = 4;
        public static final int FEMALE_FRESH = 6;
        public static final int FOREIGNER = 3;
        public static final int MALE_MAGNETIC = 5;
        public static final int MEN_TO_CHILD = 7;
        public static final int MEN_TO_WOMEN = 8;
        public static final int OPTIMUS_PRIME = 1;
        public static final int WOMEN_TO_CHILD = 9;
        public static final int WOMEN_TO_MEN = 10;
    }

    @Deprecated
    public static boolean enableReverb(boolean z, ZegoAudioReverbMode zegoAudioReverbMode) {
        if (zegoAudioReverbMode == null) {
            return false;
        }
        return ZegoAudioProcessingJNI.enableReverb(z, zegoAudioReverbMode.getCode());
    }

    public static boolean enableSpeechEnhance(boolean z, int i) {
        return ZegoAudioProcessingJNI.enableSpeechEnhance(z, i);
    }

    public static boolean enableVirtualStereo(boolean z, int i) {
        return ZegoAudioProcessingJNI.enableVirtualStereo(z, i);
    }

    public static boolean setAdvancedReverbParam(boolean z, ZegoAudioAdvancedReverbParam zegoAudioAdvancedReverbParam) {
        if (z || zegoAudioAdvancedReverbParam != null) {
            return ZegoAudioProcessingJNI.setAdvancedReverbParam(z, zegoAudioAdvancedReverbParam);
        }
        return false;
    }

    public static boolean setAudioEqualizerGain(int i, float f) {
        return ZegoAudioProcessingJNI.setAudioEqualizerGain(i, f);
    }

    public static boolean setElectronicEffects(boolean z, ZegoElectronicEffectsMode zegoElectronicEffectsMode, int i) {
        return ZegoAudioProcessingJNI.setElectronicEffects(z, zegoElectronicEffectsMode.getCode(), i);
    }

    public static boolean setReverbEchoParam(ZegoReverbEchoParam zegoReverbEchoParam) {
        return ZegoAudioProcessingJNI.setReverbEchoParam(zegoReverbEchoParam);
    }

    public static boolean setReverbParam(float f, float f2) {
        return ZegoAudioProcessingJNI.setReverbParam(f, f2);
    }

    public static boolean setReverbParam(ZegoAudioReverbParam zegoAudioReverbParam) {
        return ZegoAudioProcessingJNI.setReverbParam2(zegoAudioReverbParam);
    }

    public static boolean setReverbPreset(ZegoVoiceReverbType zegoVoiceReverbType) {
        if (zegoVoiceReverbType == null) {
            return false;
        }
        return ZegoAudioProcessingJNI.setReverbPreset(zegoVoiceReverbType.getCode());
    }

    public static boolean setVoiceChangerParam(float f) {
        return ZegoAudioProcessingJNI.setVoiceChangerParam(f);
    }

    @Deprecated
    public static boolean setVoicePreset(int i) {
        return ZegoAudioProcessingJNI.setVoicePreset(i);
    }

    public static boolean setVoicePreset(com.zego.zegoavkit2.audioprocessing.ZegoVoiceChangerType zegoVoiceChangerType) {
        if (zegoVoiceChangerType == null) {
            return false;
        }
        return ZegoAudioProcessingJNI.setVoicePreset(zegoVoiceChangerType.getCode());
    }
}
