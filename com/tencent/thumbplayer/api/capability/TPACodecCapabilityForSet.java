package com.tencent.thumbplayer.api.capability;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/capability/TPACodecCapabilityForSet.class */
public class TPACodecCapabilityForSet {
    private int level;
    private int lowerboundBitrate;
    private int lowerboundChannels;
    private int lowerboundSamplerate;
    private int profile;
    private int upperboundBitrate;
    private int upperboundChannels;
    private int upperboundSamplerate;

    public TPACodecCapabilityForSet(int i, int i2, int i3) {
        this.upperboundSamplerate = i;
        this.upperboundChannels = i2;
        this.upperboundBitrate = i3;
        this.lowerboundSamplerate = 0;
        this.lowerboundChannels = 0;
        this.lowerboundBitrate = 0;
        this.profile = 0;
        this.level = 0;
    }

    public TPACodecCapabilityForSet(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.upperboundSamplerate = i;
        this.upperboundChannels = i2;
        this.upperboundBitrate = i3;
        this.lowerboundSamplerate = i4;
        this.lowerboundChannels = i5;
        this.lowerboundBitrate = i6;
        this.profile = i7;
        this.level = i8;
    }

    public int getLevelForSet() {
        return this.level;
    }

    public int getLowerboundBitrate() {
        return this.lowerboundBitrate;
    }

    public int getLowerboundChannels() {
        return this.lowerboundChannels;
    }

    public int getLowerboundSamplerate() {
        return this.lowerboundSamplerate;
    }

    public int getProfileForSet() {
        return this.profile;
    }

    public int getUpperboundBitrate() {
        return this.upperboundBitrate;
    }

    public int getUpperboundChannels() {
        return this.upperboundChannels;
    }

    public int getUpperboundSamplerate() {
        return this.upperboundSamplerate;
    }
}
