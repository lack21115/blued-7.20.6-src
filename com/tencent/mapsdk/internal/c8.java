package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.a8;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c8.class */
public class c8 extends a8 {
    private LatLng i;

    public c8(LatLng latLng) {
        this.i = null;
        this.i = latLng;
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(float f, Interpolator interpolator) {
        float interpolation = interpolator.getInterpolation(f);
        a8.b bVar = this.h;
        if (bVar != null) {
            bVar.a(interpolation);
        }
    }

    public LatLng i() {
        return this.i;
    }
}
