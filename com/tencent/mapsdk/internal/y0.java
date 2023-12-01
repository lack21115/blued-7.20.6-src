package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y0.class */
public final class y0 extends v0<r0> implements Polyline {
    @Deprecated
    public static final int h = 4;
    @Deprecated
    public static final int i = 3;
    @Deprecated
    public static final int j = 2;
    @Deprecated
    public static final int k = 1;
    @Deprecated
    public static final int l = 6;
    @Deprecated
    public static final int m = 0;
    @Deprecated
    public static final int n = 33;
    @Deprecated
    public static final int o = 19;
    private final r0 g;

    public y0(r0 r0Var) {
        this.g = r0Var;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void addTurnArrow(int i2, int i3) {
        this.g.addTurnArrow(i2, i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void appendPoint(LatLng... latLngArr) {
        this.g.appendPoint(latLngArr);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void appendPoints(List<LatLng> list) {
        this.g.appendPoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void arrowSpacing(int i2) {
        this.g.arrowSpacing(i2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void cleanTurnArrow() {
        this.g.cleanTurnArrow();
    }

    public void d(boolean z) {
        this.g.d(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void eraseColor(int i2) {
        this.g.eraseColor(i2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void eraseTo(int i2, LatLng latLng) {
        this.g.a(i2, latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public int getColor() {
        return this.g.getColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public int[][] getColors() {
        return this.g.getColors();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public List<Integer> getPattern() {
        return this.g.getPattern();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public List<LatLng> getPoints() {
        return this.g.getPoints();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public PolylineOptions getPolylineOptions() {
        return this.g.getPolylineOptions();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public Object getTag() {
        return this.g.getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public PolylineOptions.Text getText() {
        r0 r0Var = this.g;
        if (r0Var == null) {
            return null;
        }
        return r0Var.getText();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public Rect getVisibleRect() {
        return this.g.getVisibleRect();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public float getWidth() {
        return this.g.getWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public boolean isAboveMaskLayer() {
        return this.g.isAboveMaskLayer();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public boolean isClickable() {
        r0 r0Var = this.g;
        if (r0Var != null) {
            return r0Var.isClickable();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public boolean isGradientEnable() {
        return this.g.isGradientEnable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void pattern(List<Integer> list) {
        this.g.pattern(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setAboveMaskLayer(boolean z) {
        this.g.setAboveMaskLayer(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public void setAnimation(Animation animation) {
        this.g.setAnimation(animation);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setArrow(boolean z) {
        this.g.setArrow(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setBorderColors(int[] iArr) {
        this.g.setBorderColors(iArr);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public void setClickable(boolean z) {
        this.g.setClickable(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColor(int i2) {
        this.g.setColor(i2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        this.g.setColorTexture(bitmapDescriptor);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColorTexture(String str) {
        this.g.setColorTexture(BitmapDescriptorFactory.fromAsset(str));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColors(int[] iArr, int[] iArr2) {
        this.g.setColors(iArr, iArr2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setEraseable(boolean z) {
        this.g.setEraseable(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setGradientEnable(boolean z) {
        r0 r0Var = this.g;
        if (r0Var == null) {
            return;
        }
        r0Var.setGradientEnable(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setPoints(List<LatLng> list) {
        this.g.setPoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setPolylineOptions(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return;
        }
        this.g.setPolylineOptions(polylineOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public void setTag(Object obj) {
        this.g.setTag(obj);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setText(PolylineOptions.Text text) {
        r0 r0Var = this.g;
        if (r0Var == null) {
            return;
        }
        r0Var.setText(text);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setWidth(float f) {
        this.g.setWidth(f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline, com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public void startAnimation(Animation animation) {
        this.g.startAnimation(animation);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public boolean startAnimation() {
        r0 r0Var = this.g;
        if (r0Var != null) {
            return r0Var.startAnimation();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: y */
    public r0 x() {
        return this.g;
    }
}
