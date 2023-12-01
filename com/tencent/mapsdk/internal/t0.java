package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t0.class */
public final class t0 extends v0<h0> implements Circle {
    private h0 g;

    public t0(h0 h0Var) {
        this.g = h0Var;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public boolean contains(LatLng latLng) {
        return x().contains(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public LatLng getCenter() {
        return x().getCenter();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public int getFillColor() {
        return x().getFillColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
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

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public Object getTag() {
        return x().getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public boolean isClickable() {
        return x().isClickable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public void setCenter(LatLng latLng) {
        x().setCenter(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public void setClickable(boolean z) {
        x().setClickable(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public void setFillColor(int i) {
        x().setFillColor(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    @Deprecated
    public void setOptions(CircleOptions circleOptions) {
        x().setOptions(circleOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public void setRadius(double d) {
        x().setRadius(d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public void setStrokeColor(int i) {
        x().setStrokeColor(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public void setStrokeWidth(float f) {
        x().setStrokeWidth(f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public void setTag(Object obj) {
        x().setTag(obj);
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: y */
    public h0 x() {
        return this.g;
    }
}
