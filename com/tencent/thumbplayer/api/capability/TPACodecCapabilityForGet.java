package com.tencent.thumbplayer.api.capability;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/capability/TPACodecCapabilityForGet.class */
public class TPACodecCapabilityForGet {
    private int maxBitrate;
    private int maxChannels;
    private int maxLevel;
    private int maxProfile;
    private int maxSamplerate;

    public TPACodecCapabilityForGet(int i, int i2, int i3, int i4, int i5) {
        this.maxSamplerate = i;
        this.maxChannels = i2;
        this.maxBitrate = i3;
        this.maxProfile = i4;
        this.maxLevel = i5;
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getMaxChannels() {
        return this.maxChannels;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }

    public int getMaxSamplerate() {
        return this.maxSamplerate;
    }
}
