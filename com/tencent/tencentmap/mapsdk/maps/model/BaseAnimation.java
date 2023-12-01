package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/BaseAnimation.class */
public abstract class BaseAnimation implements Animation {
    private AnimationListener mAnimationListener;
    private long mDuration;
    private Interpolator mInterpolator;

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public AnimationListener getAnimationListener() {
        return this.mAnimationListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public long getDuration() {
        return this.mDuration;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setAnimationListener(AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setDuration(long j) {
        this.mDuration = j;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }
}
