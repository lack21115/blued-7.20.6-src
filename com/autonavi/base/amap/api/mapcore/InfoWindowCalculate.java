package com.autonavi.base.amap.api.mapcore;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.FPoint;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/api/mapcore/InfoWindowCalculate.class */
public interface InfoWindowCalculate {
    boolean checkInBounds();

    IPoint getAnchor();

    BitmapDescriptor getBitmapDescriptor();

    FPoint getGeoPosition();

    int getHeight();

    int getInfoWindowOffsetX();

    int getInfoWindowOffsetY();

    int getRealInfoWindowOffsetX();

    int getRealInfoWindowOffsetY();

    LatLng getRealPosition();

    Rect getRect();

    IPoint getScreenPosition();

    int getWidth();

    boolean isContains();

    boolean isDestory();

    boolean isInfoWindowEnable();

    boolean isViewMode();

    void setInfoWindowOffset(int i, int i2) throws RemoteException;

    void setInfoWindowShown(boolean z);
}
