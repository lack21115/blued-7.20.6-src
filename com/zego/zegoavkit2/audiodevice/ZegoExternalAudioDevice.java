package com.zego.zegoavkit2.audiodevice;

import com.zego.zegoavkit2.entities.ZegoAudioFrame;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audiodevice/ZegoExternalAudioDevice.class */
public class ZegoExternalAudioDevice {

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audiodevice/ZegoExternalAudioDevice$AudioSourceType.class */
    public static final class AudioSourceType {
        public static final int ExternalCapture = 1;
        public static final int None = -1;
        public static final int Player = 2;
        public static final int SameAsMainPublishChannel = 0;
    }

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audiodevice/ZegoExternalAudioDevice$AuxPublishChannelAudioSrcType.class */
    public static final class AuxPublishChannelAudioSrcType {
        public static final int ExternalCapture = 1;
        public static final int None = -1;
        public static final int Player = 2;
        public static final int SameAsMainPublishChannel = 0;
    }

    @Deprecated
    public static native void enableExternalAudioDevice(boolean z);

    public static native boolean onPlaybackAudioFrame(ZegoAudioFrame zegoAudioFrame);

    public static native int onRecordAudioFrame(int i, ZegoAudioFrame zegoAudioFrame);

    public static boolean onRecordAudioFrame(ZegoAudioFrame zegoAudioFrame) {
        boolean z = false;
        if (onRecordAudioFrame(0, zegoAudioFrame) == 0) {
            z = true;
        }
        return z;
    }

    public static native int setAudioSource(int i, int i2);

    @Deprecated
    public static native int setAudioSrcForAuxiliaryPublishChannel(int i);

    public static native int startCapture(int i);

    public static boolean startCapture() {
        boolean z = false;
        if (startCapture(0) == 0) {
            z = true;
        }
        return z;
    }

    public static native boolean startRender();

    public static native int stopCapture(int i);

    public static boolean stopCapture() {
        boolean z = false;
        if (stopCapture(0) == 0) {
            z = true;
        }
        return z;
    }

    public static native boolean stopRender();
}
