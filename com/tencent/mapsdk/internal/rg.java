package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rg.class */
public class rg {

    /* renamed from: a  reason: collision with root package name */
    private pg f24063a;

    public rg(pg pgVar) {
        this.f24063a = pgVar;
    }

    public kg a(TileOverlayOptions tileOverlayOptions) {
        TileProvider tileProvider = tileOverlayOptions.getTileProvider();
        qg qgVar = tileProvider != null ? tileProvider instanceof vg ? new qg(this.f24063a, tileOverlayOptions) : tileProvider instanceof xh ? new sg(this.f24063a, tileOverlayOptions) : new kg(this.f24063a, tileOverlayOptions) : null;
        this.f24063a.a(qgVar);
        return qgVar;
    }
}
