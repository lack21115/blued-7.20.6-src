package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hg.class */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private int f23836a;
    private ri b;

    public hg(ri riVar, GeoPoint[] geoPointArr, PolylineOptions.Text text) {
        this.b = riVar;
        if (riVar == null) {
            return;
        }
        this.f23836a = riVar.a(geoPointArr, text);
    }

    public void a() {
        int i;
        ri riVar = this.b;
        if (riVar == null || (i = this.f23836a) <= 0) {
            return;
        }
        riVar.e(i);
    }

    public void a(PolylineOptions.Text text) {
        int i;
        ri riVar = this.b;
        if (riVar == null || (i = this.f23836a) <= 0) {
            return;
        }
        riVar.a(i, text);
    }
}
