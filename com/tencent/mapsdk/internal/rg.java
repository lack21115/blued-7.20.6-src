package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rg.class */
public class rg {

    /* renamed from: a  reason: collision with root package name */
    private pg f37754a;

    public rg(pg pgVar) {
        this.f37754a = pgVar;
    }

    public kg a(TileOverlayOptions tileOverlayOptions) {
        TileProvider tileProvider = tileOverlayOptions.getTileProvider();
        qg qgVar = tileProvider != null ? tileProvider instanceof vg ? new qg(this.f37754a, tileOverlayOptions) : tileProvider instanceof xh ? new sg(this.f37754a, tileOverlayOptions) : new kg(this.f37754a, tileOverlayOptions) : null;
        this.f37754a.a(qgVar);
        return qgVar;
    }
}
