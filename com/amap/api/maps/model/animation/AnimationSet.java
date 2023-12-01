package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/animation/AnimationSet.class */
public class AnimationSet extends Animation {
    private List<Animation> mAnimations = new ArrayList();
    private boolean shareInterpolator;

    public AnimationSet(boolean z) {
        this.shareInterpolator = false;
        this.glAnimation = new GLAnimationSet(z);
        this.shareInterpolator = z;
    }

    public void addAnimation(Animation animation) {
        this.glAnimation.addAnimation(animation);
        this.mAnimations.add(animation);
    }

    public void cleanAnimation() {
        this.glAnimation.cleanAnimation();
        this.mAnimations.clear();
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "AnimationSet";
    }
}
