package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q0.class */
public interface q0 extends p0, Polygon {
    void a(PolygonOptions polygonOptions);

    PolygonInfo e();

    GeoPoint getCenter();

    List<GeoPoint> i();

    int p();
}
