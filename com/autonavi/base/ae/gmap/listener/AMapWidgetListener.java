package com.autonavi.base.ae.gmap.listener;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/listener/AMapWidgetListener.class */
public interface AMapWidgetListener {
    void invalidateCompassView();

    void invalidateScaleView();

    void invalidateZoomController(float f);

    void setFrontViewVisibility(boolean z);
}
