package com.autonavi.amap.mapcore.animation;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/amap/mapcore/animation/GLRotateAnimation.class */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    public GLRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromDegrees;
        gLTransformation.rotate = f2 + ((this.mToDegrees - f2) * f);
    }
}
