package com.tencent.map.sdk.comps.vis;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Builder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayerOptionsBuilder.class */
public class VisualLayerOptionsBuilder implements Builder<VisualLayerOptions> {
    public final VisualLayerOptions mLayerOptions;

    public VisualLayerOptionsBuilder(VisualLayerOptions visualLayerOptions) {
        this.mLayerOptions = visualLayerOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Builder
    public VisualLayerOptions build() {
        return this.mLayerOptions;
    }

    public VisualLayerOptionsBuilder setAlpha(float f) {
        this.mLayerOptions.mAlpha = f;
        return this;
    }

    public VisualLayerOptionsBuilder setClickEnable(boolean z) {
        this.mLayerOptions.mClickEnabled = z;
        return this;
    }

    public VisualLayerOptionsBuilder setLevel(int i) {
        this.mLayerOptions.mLevel = i;
        return this;
    }

    public VisualLayerOptionsBuilder setTimeInterval(int i) {
        this.mLayerOptions.mTimeInternal = i;
        return this;
    }

    public VisualLayerOptionsBuilder setZIndex(int i) {
        this.mLayerOptions.mZIndex = i;
        return this;
    }
}
