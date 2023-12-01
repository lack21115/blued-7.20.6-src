package com.autonavi.amap.mapcore.interfaces;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/amap/mapcore/interfaces/IMapConfig.class */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean z);

    void setAbroadState(int i);

    void setTerrainEnable(boolean z);
}
