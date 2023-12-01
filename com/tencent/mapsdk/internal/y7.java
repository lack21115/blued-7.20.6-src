package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y7.class */
public class y7 implements y8<GeoPoint> {
    @Override // com.tencent.mapsdk.internal.y8
    public GeoPoint a(float f, GeoPoint geoPoint, GeoPoint geoPoint2) {
        return new GeoPoint(geoPoint.getLatitudeE6() + ((int) ((geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6()) * f)), geoPoint.getLongitudeE6() + ((int) (f * (geoPoint2.getLongitudeE6() - geoPoint.getLongitudeE6()))));
    }
}
