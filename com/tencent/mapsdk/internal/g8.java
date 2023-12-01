package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.p7;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g8.class */
public class g8 extends p7 {
    private GeoPoint j;
    private GeoPoint k;
    private boolean l = false;

    public g8(GeoPoint geoPoint, GeoPoint geoPoint2) {
        this.j = null;
        this.k = null;
        if (geoPoint != null) {
            this.j = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        }
        if (geoPoint2 != null) {
            this.k = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
        }
    }

    @Override // com.tencent.mapsdk.internal.p7
    public void b(float f) {
        GeoPoint geoPoint = this.k;
        if (geoPoint == null || this.j == null) {
            return;
        }
        int latitudeE6 = geoPoint.getLatitudeE6();
        int latitudeE62 = this.j.getLatitudeE6();
        int longitudeE6 = this.k.getLongitudeE6();
        int longitudeE62 = this.j.getLongitudeE6();
        int latitudeE63 = this.j.getLatitudeE6();
        int i = (int) ((latitudeE6 - latitudeE62) * f);
        int longitudeE63 = this.j.getLongitudeE6();
        int i2 = (int) ((longitudeE6 - longitudeE62) * f);
        p7.b bVar = this.i;
        if (bVar != null) {
            bVar.a(new GeoPoint(latitudeE63 + i, longitudeE63 + i2));
        }
    }
}
