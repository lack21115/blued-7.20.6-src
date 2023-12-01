package com.tencent.tencentmap.mapsdk.maps.model;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/EmergeAnimation.class */
public class EmergeAnimation extends BaseAnimation {
    public LatLng mStartPoint;

    public EmergeAnimation(LatLng latLng) {
        this.mStartPoint = latLng;
    }

    public LatLng getStartPoint() {
        return this.mStartPoint;
    }
}
