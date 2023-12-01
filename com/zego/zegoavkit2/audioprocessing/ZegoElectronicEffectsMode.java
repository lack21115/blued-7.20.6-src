package com.zego.zegoavkit2.audioprocessing;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioprocessing/ZegoElectronicEffectsMode.class */
public enum ZegoElectronicEffectsMode {
    MAJOR(0),
    MINOR(1),
    HARMONIC_MINOR(2);
    
    private int mCode;

    ZegoElectronicEffectsMode(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
