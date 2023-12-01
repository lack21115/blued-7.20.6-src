package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/animation/TranslateAnimation.class */
public class TranslateAnimation extends Animation {
    private double x;
    private double y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.x = latLng.latitude;
        this.y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "TranslateAnimation";
    }
}
