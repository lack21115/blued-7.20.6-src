package com.tencent.thumbplayer.api.capability;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/capability/TPVCodecCapabilityForGet.class */
public class TPVCodecCapabilityForGet {
    private static final int MAX_FRAME_RATE_FOR_LUMA_SAMPLES_DEFAULT = -1;
    private static final int MAX_LEVEL_DEFAULT = -1;
    private static final int MAX_LUMA_SAMPLES_DEFAULT = -1;
    private static final int MAX_PROFILE_DEFAULT = -1;
    public static final TPVCodecCapabilityForGet mDefaultVCodecCapability = new TPVCodecCapabilityForGet(-1, -1, -1, -1);
    private int maxFramerateFormaxLumaSamples;
    private int maxLevel;
    private int maxLumaSamples;
    private int maxProfile;

    public TPVCodecCapabilityForGet(int i, int i2, int i3, int i4) {
        this.maxLumaSamples = i;
        this.maxProfile = i2;
        this.maxLevel = i3;
        this.maxFramerateFormaxLumaSamples = i4;
    }

    public int getMaxFramerateFormaxLumaSamples() {
        return this.maxFramerateFormaxLumaSamples;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxLumaSamples() {
        return this.maxLumaSamples;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }
}
