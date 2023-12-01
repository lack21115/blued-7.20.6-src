package com.tencent.tencentmap.mapsdk.maps.model;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/RotateAnimation.class */
public class RotateAnimation extends BaseAnimation {
    public float mFromDegree;
    public float mPivoteX;
    public float mPivoteY;
    public float mPivoteZ;
    public float mToDegree;

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegree = f;
        this.mToDegree = f2;
        this.mPivoteX = f3;
        this.mPivoteY = f4;
        this.mPivoteZ = f5;
    }
}
