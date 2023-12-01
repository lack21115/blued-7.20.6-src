package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/animation/RotateAnimation.class */
public class RotateAnimation extends Animation {
    private float mFromDegrees;
    private float mToDegrees;

    public RotateAnimation(float f, float f2) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f, f2, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f, f2, f3, f4, f5);
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "RotateAnimation";
    }
}
