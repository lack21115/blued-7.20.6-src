package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/amap/api/mapcore/IGLMapEngine.class */
public interface IGLMapEngine {
    void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i);
}
