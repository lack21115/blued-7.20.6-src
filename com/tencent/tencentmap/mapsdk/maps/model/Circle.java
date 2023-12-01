package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/Circle.class */
public interface Circle extends Clickable, Fillable, Levelable, Removable, Strokeable, Tagable, Visible, IOverlay {
    boolean contains(LatLng latLng);

    LatLng getCenter();

    double getRadius();

    void setCenter(LatLng latLng);

    void setOptions(CircleOptions circleOptions);

    void setRadius(double d);
}
