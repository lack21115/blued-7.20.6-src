package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/MaskLayerOptions.class */
public class MaskLayerOptions {
    private int mColor = 0;
    private long mAnimationDuration = 0;
    private int mZIndex = 0;

    public MaskLayerOptions animationDuration(long j) {
        this.mAnimationDuration = j;
        return this;
    }

    public MaskLayerOptions color(int i) {
        this.mColor = i;
        return this;
    }

    public long getAnimationDuration() {
        return this.mAnimationDuration;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public MaskLayerOptions zIndex(int i) {
        this.mZIndex = i;
        return this;
    }
}
