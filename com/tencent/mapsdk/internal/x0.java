package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x0.class */
public final class x0 extends v0<q0> implements Polygon {
    public q0 g;

    public x0(q0 q0Var) {
        this.g = q0Var;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public boolean contains(LatLng latLng) {
        return this.g.contains(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public int getFillColor() {
        return this.g.getFillColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public List<LatLng> getPoints() {
        return this.g.getPoints();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public int getStrokeColor() {
        return this.g.getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public float getStrokeWidth() {
        return this.g.getStrokeWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public Object getTag() {
        return this.g.getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public boolean isClickable() {
        q0 q0Var = this.g;
        if (q0Var != null) {
            return q0Var.isClickable();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public void setClickable(boolean z) {
        this.g.setClickable(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public void setFillColor(int i) {
        this.g.setFillColor(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public void setOptions(PolygonOptions polygonOptions) {
        this.g.setOptions(polygonOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public void setPoints(List<LatLng> list) {
        q0 q0Var = this.g;
        if (q0Var == null) {
            return;
        }
        q0Var.setPoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public void setStrokeColor(int i) {
        this.g.setStrokeColor(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public void setStrokeWidth(float f) {
        this.g.setStrokeWidth(f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public void setTag(Object obj) {
        this.g.setTag(obj);
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: y */
    public q0 x() {
        return this.g;
    }
}
