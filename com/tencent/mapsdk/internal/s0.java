package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s0.class */
public final class s0 extends v0<g0> implements Arc {
    private g0 g;

    public s0(g0 g0Var) {
        this.g = g0Var;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public LatLng getCenter() {
        return x().getCenter();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public int getColor() {
        return x().getColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public double getLength() {
        return x().getLength();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public double getRadius() {
        return x().getRadius();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public int getStrokeColor() {
        return x().getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public float getStrokeWidth() {
        return x().getStrokeWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public float getWidth() {
        return x().getWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public void setColor(int i) {
        x().setColor(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public void setStrokeColor(int i) {
        x().setStrokeColor(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public void setStrokeWidth(float f) {
        x().setStrokeWidth(f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public void setWidth(float f) {
        x().setWidth(f);
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: y */
    public g0 x() {
        return this.g;
    }
}
