package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.t4;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x.class */
public class x implements t4 {
    @Override // com.tencent.mapsdk.internal.t4
    public double a(Point point, Point point2) {
        return 0.0d;
    }

    @Override // com.tencent.mapsdk.internal.t4
    public float a(LatLng latLng, LatLng latLng2, int i, int i2, int i3, int i4, LatLng latLng3) {
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.internal.t4
    public GeoPoint a(p5 p5Var) {
        return new GeoPoint();
    }

    @Override // com.tencent.mapsdk.internal.t4
    public p5 a(Context context, LatLng latLng) {
        return new p5();
    }

    @Override // com.tencent.mapsdk.internal.t4
    public p5 a(GeoPoint geoPoint) {
        return new p5();
    }

    @Override // com.tencent.mapsdk.internal.t4
    public x5 a(LatLng latLng) {
        return new x5(0.0d, 0.0d);
    }

    @Override // com.tencent.mapsdk.internal.t4
    public LatLng a(PointF pointF) {
        return new LatLng();
    }

    @Override // com.tencent.mapsdk.internal.t4
    public LatLng a(x5 x5Var) {
        return new LatLng();
    }

    @Override // com.tencent.mapsdk.internal.t4
    public void a(List<? extends Boundable> list, List<GeoPoint> list2, Rect rect, t4.a aVar) {
    }

    @Override // com.tencent.mapsdk.internal.t4
    public LatLng[] a() {
        return new LatLng[4];
    }

    @Override // com.tencent.mapsdk.internal.t4
    public PointF b(LatLng latLng) {
        return new PointF();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public LatLng fromScreenLocation(Point point) {
        return new LatLng();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public VisibleRegion getVisibleRegion() {
        return new VisibleRegion(new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLngBounds(new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float[] glModelMatrix(PointF pointF, float f) {
        return new float[16];
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float glPixelRatio() {
        return 0.0f;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float[] glProjectionMatrix() {
        return new float[16];
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public PointF glVertexForCoordinate(LatLng latLng) {
        return new PointF();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float[] glViewMatrix() {
        return new float[16];
    }

    @Override // com.tencent.mapsdk.internal.t4, com.tencent.tencentmap.mapsdk.maps.Projection
    public double metersPerPixel(double d) {
        return 0.0d;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public Point toScreenLocation(LatLng latLng) {
        return new Point();
    }
}
