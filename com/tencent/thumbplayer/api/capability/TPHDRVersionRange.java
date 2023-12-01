package com.tencent.thumbplayer.api.capability;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/capability/TPHDRVersionRange.class */
public class TPHDRVersionRange {
    public int lowerboundAndroidAPILevel;
    public int lowerboundPatchVersion;
    public int lowerboundSystemVersion;
    public int upperboundAndroidAPILevel;
    public int upperboundPatchVersion;
    public int upperboundSystemVersion;

    public TPHDRVersionRange(int i, int i2) {
        this.upperboundAndroidAPILevel = i;
        this.lowerboundAndroidAPILevel = i2;
    }

    public TPHDRVersionRange(int i, int i2, int i3, int i4) {
        this.upperboundSystemVersion = i;
        this.lowerboundSystemVersion = i2;
        this.upperboundPatchVersion = i3;
        this.lowerboundPatchVersion = i4;
    }
}
