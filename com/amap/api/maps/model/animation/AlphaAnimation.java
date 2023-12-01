package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/animation/AlphaAnimation.class */
public class AlphaAnimation extends Animation {
    private float mFromAlpha;
    private float mToAlpha;

    public AlphaAnimation(float f, float f2) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(f, f2);
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "AlphaAnimation";
    }
}
