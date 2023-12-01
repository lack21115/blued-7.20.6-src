package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/InfoWindowAnimationManager.class */
public class InfoWindowAnimationManager {

    /* renamed from: a  reason: collision with root package name */
    IInfoWindowManager f5512a;

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f5512a = null;
        this.f5512a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f5512a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f5512a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i) {
        this.f5512a.setInfoWindowBackColor(i);
    }

    public void setInfoWindowBackEnable(boolean z) {
        this.f5512a.setInfoWindowBackEnable(z);
    }

    public void setInfoWindowBackScale(float f, float f2) {
        this.f5512a.setInfoWindowBackScale(f, f2);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f5512a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f5512a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f5512a.startAnimation();
    }
}
