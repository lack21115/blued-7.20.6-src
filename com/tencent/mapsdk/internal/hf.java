package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hf.class */
public class hf extends AccessibleTouchItem {
    private MapPoi b;

    /* renamed from: c  reason: collision with root package name */
    private yi f37526c;

    public hf(yi yiVar, MapPoi mapPoi) {
        this.b = mapPoi;
        this.f37526c = yiVar;
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public Rect getBounds() {
        p5 a2 = this.f37526c.getMap().getProjection().a(GeoPoint.from(new LatLng(this.b.getLatitude(), this.b.getLongitude())));
        return new Rect((int) (a2.b - (c7.w() * 20.0f)), (int) (a2.f37683c - (c7.w() * 20.0f)), (int) (a2.b + (c7.w() * 20.0f)), (int) (a2.f37683c + (c7.w() * 20.0f)));
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public String getContentDescription() {
        return this.b.getName();
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public void onClick() {
        TencentMap.OnMapPoiClickListener onMapPoiClickListener;
        yi yiVar = this.f37526c;
        if (yiVar == null || (onMapPoiClickListener = yiVar.c0) == null) {
            return;
        }
        MapPoi mapPoi = new MapPoi();
        mapPoi.position = new LatLng(this.b.getLatitude(), this.b.getLongitude());
        mapPoi.name = this.b.getName();
        onMapPoiClickListener.onClicked(mapPoi);
    }
}
