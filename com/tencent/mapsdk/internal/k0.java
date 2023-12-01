package com.tencent.mapsdk.internal;

import android.graphics.Point;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k0.class */
public interface k0 {
    LatLng fromScreenLocation(Point point);

    VisibleRegion getVisibleRegion();

    double metersPerPixel(double d);

    Point toScreenLocation(LatLng latLng);
}
