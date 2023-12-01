package com.tencent.map.sdk.comps.vis;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Options;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayerOptions.class */
public class VisualLayerOptions implements Options<VisualLayerOptions, VisualLayerOptionsBuilder> {
    public String mLayerId;
    public int mZIndex;
    public int mLevel = 1;
    public int mTimeInternal = 0;
    public float mAlpha = 1.0f;
    public boolean mIsVisible = true;
    public boolean mClickEnabled = false;

    public VisualLayerOptions(String str) {
        this.mLayerId = str;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public String getLayerId() {
        return this.mLayerId;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public int getTimeInterval() {
        return this.mTimeInternal;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public boolean isClickEnabled() {
        return this.mClickEnabled;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Options
    public VisualLayerOptionsBuilder newBuilder() {
        return new VisualLayerOptionsBuilder(this);
    }
}
