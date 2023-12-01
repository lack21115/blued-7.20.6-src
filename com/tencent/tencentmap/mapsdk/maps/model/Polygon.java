package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/Polygon.class */
public interface Polygon extends Clickable, Fillable, Levelable, Removable, Strokeable, Tagable<Object>, Visible, IOverlay {
    boolean contains(LatLng latLng);

    List<LatLng> getPoints();

    void setOptions(PolygonOptions polygonOptions);

    void setPoints(List<LatLng> list);
}
