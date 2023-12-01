package com.amap.api.maps.model;

import com.amap.api.col.p0003sl.dw;
import com.autonavi.amap.mapcore.DPoint;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/WeightedLatLng.class */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng == null) {
            throw new IllegalArgumentException("latLng can not null");
        }
        this.latLng = latLng;
        this.mPoint = dw.a(latLng);
        if (d >= 0.0d) {
            this.intensity = d;
        } else {
            this.intensity = 1.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.mPoint;
    }
}
