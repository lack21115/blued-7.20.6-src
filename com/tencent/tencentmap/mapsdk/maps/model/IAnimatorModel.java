package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/IAnimatorModel.class */
public interface IAnimatorModel {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/IAnimatorModel$IAnimatorEndListener.class */
    public interface IAnimatorEndListener {
        void onAnimatorEnd();
    }

    float getRotation();

    void setPosition(LatLng latLng);

    void setRotation(float f);
}
