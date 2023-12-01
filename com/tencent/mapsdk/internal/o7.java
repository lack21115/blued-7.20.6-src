package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o7.class */
public class o7 extends j7 implements ITranslateAnimation {
    public o7(LatLng latLng) {
        GeoPoint from = GeoPoint.from(latLng);
        if (this.f37563a == null) {
            this.f37563a = new f8(from);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setDuration(long j) {
        a8 a8Var = this.f37563a;
        if (a8Var == null) {
            return;
        }
        a8Var.a(j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setInterpolator(Interpolator interpolator) {
        a8 a8Var = this.f37563a;
        if (a8Var == null || interpolator == null) {
            return;
        }
        a8Var.a(interpolator);
    }
}
