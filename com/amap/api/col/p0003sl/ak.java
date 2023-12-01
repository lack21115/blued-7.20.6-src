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
        ((AbstractCameraUpdateMessage) ajVar).nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ((AbstractCameraUpdateMessage) ajVar).amount = 1.0f;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage a(float f) {
        ah ahVar = new ah();
        ((AbstractCameraUpdateMessage) ahVar).nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ((AbstractCameraUpdateMessage) ahVar).zoom = f;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(float f, float f2) {
        ai aiVar = new ai();
        ((AbstractCameraUpdateMessage) aiVar).nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        ((AbstractCameraUpdateMessage) aiVar).xPixel = f;
        ((AbstractCameraUpdateMessage) aiVar).yPixel = f2;
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(float f, Point point) {
        aj ajVar = new aj();
        ((AbstractCameraUpdateMessage) ajVar).nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ((AbstractCameraUpdateMessage) ajVar).amount = f;
        ((AbstractCameraUpdateMessage) ajVar).focus = point;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        ah ahVar = new ah();
        ((AbstractCameraUpdateMessage) ahVar).nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ((AbstractCameraUpdateMessage) ahVar).geoPoint = new DPoint(point.x, point.y);
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        ah ahVar = new ah();
        ((AbstractCameraUpdateMessage) ahVar).nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null) {
            if (cameraPosition.target == null) {
                return ahVar;
            }
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(cameraPosition.target.latitude, cameraPosition.target.longitude, 20);
            ((AbstractCameraUpdateMessage) ahVar).geoPoint = new DPoint(latLongToPixelsDouble.x, latLongToPixelsDouble.y);
            ((AbstractCameraUpdateMessage) ahVar).zoom = cameraPosition.zoom;
            ((AbstractCameraUpdateMessage) ahVar).bearing = cameraPosition.bearing;
            ((AbstractCameraUpdateMessage) ahVar).tilt = cameraPosition.tilt;
            ((AbstractCameraUpdateMessage) ahVar).cameraPosition = cameraPosition;
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
        ((AbstractCameraUpdateMessage) agVar).nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ((AbstractCameraUpdateMessage) agVar).bounds = latLngBounds;
        ((AbstractCameraUpdateMessage) agVar).paddingLeft = i;
        ((AbstractCameraUpdateMessage) agVar).paddingRight = i;
        ((AbstractCameraUpdateMessage) agVar).paddingTop = i;
        ((AbstractCameraUpdateMessage) agVar).paddingBottom = i;
        return agVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        ag agVar = new ag();
        ((AbstractCameraUpdateMessage) agVar).nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        ((AbstractCameraUpdateMessage) agVar).bounds = latLngBounds;
        ((AbstractCameraUpdateMessage) agVar).paddingLeft = i3;
        ((AbstractCameraUpdateMessage) agVar).paddingRight = i3;
        ((AbstractCameraUpdateMessage) agVar).paddingTop = i3;
        ((AbstractCameraUpdateMessage) agVar).paddingBottom = i3;
        ((AbstractCameraUpdateMessage) agVar).width = i;
        ((AbstractCameraUpdateMessage) agVar).height = i2;
        return agVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        ag agVar = new ag();
        ((AbstractCameraUpdateMessage) agVar).nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ((AbstractCameraUpdateMessage) agVar).bounds = latLngBounds;
        ((AbstractCameraUpdateMessage) agVar).paddingLeft = i;
        ((AbstractCameraUpdateMessage) agVar).paddingRight = i2;
        ((AbstractCameraUpdateMessage) agVar).paddingTop = i3;
        ((AbstractCameraUpdateMessage) agVar).paddingBottom = i4;
        return agVar;
    }

    public static AbstractCameraUpdateMessage b() {
        aj ajVar = new aj();
        ((AbstractCameraUpdateMessage) ajVar).nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        ((AbstractCameraUpdateMessage) ajVar).amount = -1.0f;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage b(float f) {
        return a(f, (Point) null);
    }

    public static AbstractCameraUpdateMessage b(float f, Point point) {
        ah ahVar = new ah();
        ((AbstractCameraUpdateMessage) ahVar).nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ((AbstractCameraUpdateMessage) ahVar).geoPoint = new DPoint(point.x, point.y);
        ((AbstractCameraUpdateMessage) ahVar).bearing = f;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage c() {
        return new ah();
    }

    public static AbstractCameraUpdateMessage c(float f) {
        ah ahVar = new ah();
        ((AbstractCameraUpdateMessage) ahVar).nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ((AbstractCameraUpdateMessage) ahVar).tilt = f;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage d(float f) {
        ah ahVar = new ah();
        ((AbstractCameraUpdateMessage) ahVar).nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        ((AbstractCameraUpdateMessage) ahVar).bearing = f;
        return ahVar;
    }
}
