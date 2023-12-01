package com.amap.api.maps.model;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/AMapGestureListener.class */
public interface AMapGestureListener {
    void onDoubleTap(float f, float f2);

    void onDown(float f, float f2);

    void onFling(float f, float f2);

    void onLongPress(float f, float f2);

    void onMapStable();

    void onScroll(float f, float f2);

    void onSingleTap(float f, float f2);

    void onUp(float f, float f2);
}
