package com.amap.api.col.p0003sl;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* renamed from: com.amap.api.col.3sl.ak  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ak.class */
public final class ak {
    public static AbstractCameraUpdateMessage a() {
        aj ajVar = new aj();
        ajVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ajVar.amount = 1.0f;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage a(float f) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ahVar.zoom = f;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(float f, float f2) {
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        aiVar.xPixel = f;
        aiVar.yPixel = f2;
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(float f, Point point) {
        aj ajVar = new aj();
        ajVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ajVar.amount = f;
        ajVar.focus = point;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ahVar.geoPoint = new DPoint(point.x, point.y);
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null) {
            if (cameraPosition.target == null) {
                return ahVar;
            }
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(cameraPosition.target.latitude, cameraPosition.target.longitude, 20);
            ahVar.geoPoint = new DPoint(latLongToPixelsDouble.x, latLongToPixelsDouble.y);
            ahVar.zoom = cameraPosition.zoom;
            ahVar.bearing = cameraPosition.bearing;
            ahVar.tilt = cameraPosition.tilt;
            ahVar.cameraPosition = cameraPosition;
        }
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng) {
        return a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng, float f) {
        return a(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i) {
        ag agVar = new ag();
        agVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        agVar.bounds = latLngBounds;
        agVar.paddingLeft = i;
        agVar.paddingRight = i;
        agVar.paddingTop = i;
        agVar.paddingBottom = i;
        return agVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        ag agVar = new ag();
        agVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        agVar.bounds = latLngBounds;
        agVar.paddingLeft = i3;
        agVar.paddingRight = i3;
        agVar.paddingTop = i3;
        agVar.paddingBottom = i3;
        agVar.width = i;
        agVar.height = i2;
        return agVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        ag agVar = new ag();
        agVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        agVar.bounds = latLngBounds;
        agVar.paddingLeft = i;
        agVar.paddingRight = i2;
        agVar.paddingTop = i3;
        agVar.paddingBottom = i4;
        return agVar;
    }

    public static AbstractCameraUpdateMessage b() {
        aj ajVar = new aj();
        ajVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ajVar.amount = -1.0f;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage b(float f) {
        return a(f, (Point) null);
    }

    public static AbstractCameraUpdateMessage b(float f, Point point) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ahVar.geoPoint = new DPoint(point.x, point.y);
        ahVar.bearing = f;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage c() {
        return new ah();
    }

    public static AbstractCameraUpdateMessage c(float f) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ahVar.tilt = f;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage d(float f) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ahVar.bearing = f;
        return ahVar;
    }
}
