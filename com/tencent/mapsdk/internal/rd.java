package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rd.class */
public class rd extends MarkerInfo implements vc {
    public rd(double d, double d2, String str) {
        super(d, d2, str);
    }

    public rd(LatLng latLng, String str) {
        super(latLng.getLatitude(), latLng.getLongitude(), str);
    }
}
