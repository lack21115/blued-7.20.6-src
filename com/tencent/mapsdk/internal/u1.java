package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u1.class */
public abstract class u1 extends q1 {
    public u1(Context context, TencentMapOptions tencentMapOptions, r1 r1Var) {
        super(context, tencentMapOptions, r1Var);
    }

    @Override // com.tencent.mapsdk.internal.q1
    public void a(Bundle bundle) {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IAlphaAnimation createAlphaAnimation(float f, float f2) {
        return new i7(f, f2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IAnimationSet createAnimationSet(boolean z) {
        return new k7(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IEmergeAnimation createEmergeAnimation(LatLng latLng) {
        return new l7(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder builder) {
        return new y1(builder);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IRotateAnimation createRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        return new m7(f, f2, f3, f4, f5);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public IScaleAnimation createScaleAnimation(float f, float f2, float f3, float f4) {
        return new n7(f, f2, f3, f4);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public ITranslateAnimation createTranslateAnimation(LatLng latLng) {
        return new o7(latLng);
    }

    @Override // com.tencent.mapsdk.internal.q1
    public String y() {
        return "4.5.9.6";
    }
}
