package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/interfaces/IAMapListener.class */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i, GLMapState gLMapState);

    void afterDrawLabel(int i, GLMapState gLMapState);

    void afterRendererOver(int i, GLMapState gLMapState);

    void beforeDrawLabel(int i, GLMapState gLMapState);

    void onMapBlankClick(double d, double d2);

    void onMapPOIClick(MapPoi mapPoi);
}
