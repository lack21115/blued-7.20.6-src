package com.tencent.tencentmap.mapsdk.maps.model;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/AoiLayerOptions.class */
public class AoiLayerOptions {
    private int mMinLevel = -1;
    private int mMaxLevel = -1;

    public int getMaxLevel() {
        return this.mMaxLevel;
    }

    public int getMinLevel() {
        return this.mMinLevel;
    }

    public AoiLayerOptions setDisplayLevel(int i, int i2) {
        if (i < 0 || i2 < 0 || i > i2) {
            Log.w("TencentMapSDK", "设置AoiLayer的显示级别失效，最小级别要小于等于最大级别，并且在[3,20]数值之间。");
            return this;
        }
        int i3 = i;
        if (i < 3) {
            i3 = 3;
        }
        int i4 = i2;
        if (i2 > 20) {
            i4 = 20;
        }
        this.mMinLevel = i3;
        this.mMaxLevel = i4;
        return this;
    }
}
