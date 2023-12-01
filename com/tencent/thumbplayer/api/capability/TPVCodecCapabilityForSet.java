package com.tencent.thumbplayer.api.capability;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/capability/TPVCodecCapabilityForSet.class */
public class TPVCodecCapabilityForSet {
    private int level;
    private int lowerboundHeight;
    private int lowerboundWidth;
    private int profile;
    private int upperboundHeight;
    private int upperboundWidth;

    public TPVCodecCapabilityForSet(int i, int i2) {
        this.upperboundWidth = i;
        this.upperboundHeight = i2;
        this.lowerboundWidth = 0;
        this.lowerboundHeight = 0;
        this.profile = -1;
        this.level = -1;
    }

    public TPVCodecCapabilityForSet(int i, int i2, int i3) {
        this.upperboundWidth = i;
        this.upperboundHeight = i2;
        this.profile = i3;
        this.lowerboundWidth = 0;
        this.lowerboundHeight = 0;
        this.level = -1;
    }

    public TPVCodecCapabilityForSet(int i, int i2, int i3, int i4, int i5, int i6) {
        this.upperboundWidth = i;
        this.upperboundHeight = i2;
        this.lowerboundWidth = i3;
        this.lowerboundHeight = i4;
        this.profile = i5;
        this.level = i6;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLowerboundHeight() {
        return this.lowerboundHeight;
    }

    public int getLowerboundWidth() {
        return this.lowerboundWidth;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getUpperboundHeight() {
        return this.upperboundHeight;
    }

    public int getUpperboundWidth() {
        return this.upperboundWidth;
    }
}
