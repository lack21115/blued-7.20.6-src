package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t4.class */
public interface t4 extends Projection {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t4$a.class */
    public interface a {
        void a(float f, GeoPoint geoPoint, double d);
    }

    double a(Point point, Point point2);

    float a(LatLng latLng, LatLng latLng2, int i, int i2, int i3, int i4, LatLng latLng3);

    GeoPoint a(p5 p5Var);

    p5 a(Context context, LatLng latLng);

    p5 a(GeoPoint geoPoint);

    x5 a(LatLng latLng);

    LatLng a(PointF pointF);

    LatLng a(x5 x5Var);

    void a(List<? extends Boundable> list, List<GeoPoint> list2, Rect rect, a aVar);

    LatLng[] a();

    PointF b(LatLng latLng);

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    double metersPerPixel(double d);
}
