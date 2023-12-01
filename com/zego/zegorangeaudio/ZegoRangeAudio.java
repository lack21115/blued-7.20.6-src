package com.zego.zegorangeaudio;

import android.os.Handler;
import android.os.Looper;
import com.zego.zegorangeaudio.ZegoRangeAudioJNI;
import com.zego.zegorangeaudio.callback.IZegoRangeAudioCallbcak;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegorangeaudio/ZegoRangeAudio.class */
public class ZegoRangeAudio implements ZegoRangeAudioJNI.IJniZegoRangeAudioCallback {
    private static ZegoRangeAudio instance;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private IZegoRangeAudioCallbcak mZegoRangeAudioCallbcak;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegorangeaudio/ZegoRangeAudio$ZegoRangeAudioMicrophoneState.class */
    public final class ZegoRangeAudioMicrophoneState {
        public static final int Failed = 4;
        public static final int Opening = 1;
        public static final int Success = 2;
        public static final int TempBroken = 3;

        public ZegoRangeAudioMicrophoneState() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegorangeaudio/ZegoRangeAudio$ZegoRangeAudioMode.class */
    public final class ZegoRangeAudioMode {
        public static final int SecreteTeam = 3;
        public static final int Team = 2;
        public static final int World = 1;

        public ZegoRangeAudioMode() {
        }
    }

    private ZegoRangeAudio() {
    }

    public static ZegoRangeAudio getInstance() {
        if (instance == null) {
            instance = new ZegoRangeAudio();
        }
        return instance;
    }

    public void enableMicrophone(boolean z) {
        ZegoRangeAudioJNI.enableRangeAudioMicrophone(z);
    }

    public void enableSpatializer(boolean z) {
        ZegoRangeAudioJNI.enableSpatializer(z);
    }

    public void enableSpeaker(boolean z) {
        ZegoRangeAudioJNI.enableRangeAudioSpeaker(z);
    }

    public boolean init() {
        return ZegoRangeAudioJNI.initRangeAudio();
    }

    public void muteUser(String str, boolean z) {
        ZegoRangeAudioJNI.muteRangeAudioUser(str, z);
    }

    @Override // com.zego.zegorangeaudio.ZegoRangeAudioJNI.IJniZegoRangeAudioCallback
    public void onRangAudioMicrophone(final int i, final int i2) {
        final IZegoRangeAudioCallbcak iZegoRangeAudioCallbcak = this.mZegoRangeAudioCallbcak;
        if (iZegoRangeAudioCallbcak != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegorangeaudio.ZegoRangeAudio.1
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRangeAudioCallbcak.onRangAudioMicrophone(i, i2);
                }
            });
        }
    }

    public void setAudioRecvRange(float f) {
        ZegoRangeAudioJNI.setAudioRecvRange(f);
    }

    public boolean setCallback(IZegoRangeAudioCallbcak iZegoRangeAudioCallbcak) {
        this.mZegoRangeAudioCallbcak = iZegoRangeAudioCallbcak;
        return ZegoRangeAudioJNI.setRangeAudioJNICallback(this);
    }

    public void setMode(int i) {
        ZegoRangeAudioJNI.setRangeAudioMode(i);
    }

    public void setPositionUpdateFrequency(int i) {
        ZegoRangeAudioJNI.setPositionUpdateFrequency(i);
    }

    public void setRangeAudioVolume(int i) {
        ZegoRangeAudioJNI.setRangeAudioVolume(i);
    }

    public void setTeamID(String str) {
        ZegoRangeAudioJNI.setRangeAudioTeamID(str);
    }

    public void unInit() {
        ZegoRangeAudioJNI.unInitRangeAudio();
    }

    public void updateAudioSource(String str, float[] fArr) {
        ZegoRangeAudioJNI.updateAudioSource(str, fArr);
    }

    public void updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        ZegoRangeAudioJNI.updateSelfPosition(fArr, fArr2, fArr3, fArr4);
    }

    public void updateStreamPosition(String str, float[] fArr) {
        ZegoRangeAudioJNI.updateStreamPosition(str, fArr);
    }

    public void updateStreamVocalRange(String str, float f) {
        ZegoRangeAudioJNI.updateStreamVocalRange(str, f);
    }
}
