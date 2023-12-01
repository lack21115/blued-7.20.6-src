package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.a8;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f8.class */
public class f8 extends a8 {
    private GeoPoint i = null;
    private GeoPoint j;
    private boolean k;

    public f8(GeoPoint geoPoint) {
        this.j = null;
        this.k = false;
        if (geoPoint != null) {
            this.j = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            this.k = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(float f, Interpolator interpolator) {
        GeoPoint geoPoint = this.j;
        if (geoPoint == null || this.i == null) {
            return;
        }
        int latitudeE6 = geoPoint.getLatitudeE6();
        int latitudeE62 = this.i.getLatitudeE6();
        int longitudeE6 = this.j.getLongitudeE6();
        int longitudeE62 = this.i.getLongitudeE6();
        float interpolation = interpolator.getInterpolation(f);
        int latitudeE63 = this.i.getLatitudeE6() + ((int) ((latitudeE6 - latitudeE62) * interpolation));
        int longitudeE63 = this.i.getLongitudeE6() + ((int) ((longitudeE6 - longitudeE62) * interpolation));
        if (1.0f - f < 1.0E-4d) {
            latitudeE63 = this.j.getLatitudeE6();
            longitudeE63 = this.j.getLongitudeE6();
        }
        a8.b bVar = this.h;
        if (bVar != null) {
            bVar.a(latitudeE63, longitudeE63);
        }
    }

    @Override // com.tencent.mapsdk.internal.a8
    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (super.a((GeoPoint) null, (GeoPoint) null)) {
            if (geoPoint != null) {
                this.i = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            }
            if (this.k || geoPoint2 == null) {
                return true;
            }
            this.j = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
            return true;
        }
        return false;
    }
}
