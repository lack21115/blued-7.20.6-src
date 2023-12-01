package com.tencent.tencentmap.mapsdk.maps.model.transform;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/transform/SphericalMercatorProjection.class */
public class SphericalMercatorProjection {
    public static double EARTH_RADIUS = 6378137.0d;
    public final double mWorldWidth;

    public SphericalMercatorProjection() {
        this.mWorldWidth = EARTH_RADIUS * 6.283185307179586d;
    }

    public SphericalMercatorProjection(double d) {
        this.mWorldWidth = d;
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        double d = latLng.longitude;
        double d2 = d * 0.01745329251994329d;
        double d3 = latLng.latitude * 0.01745329251994329d;
        double d4 = latLng2.longitude * 0.01745329251994329d;
        double d5 = latLng2.latitude * 0.01745329251994329d;
        double sin = Math.sin(d2);
        double sin2 = Math.sin(d3);
        double cos = Math.cos(d2);
        double cos2 = Math.cos(d3);
        double sin3 = Math.sin(d4);
        double sin4 = Math.sin(d5);
        double cos3 = Math.cos(d4);
        double cos4 = Math.cos(d5);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
        return Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * this.mWorldWidth * 3.141592653589793d;
    }

    public LatLng toLatLng(Point point) {
        double d = point.x;
        double d2 = this.mWorldWidth;
        return new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (point.y / d2))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((d / d2) - 0.5d) * 360.0d);
    }

    public Point toPoint(LatLng latLng) {
        double d = latLng.longitude / 360.0d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d);
        double d2 = this.mWorldWidth;
        return new Point((d + 0.5d) * d2, (log + 0.5d) * d2);
    }
}
