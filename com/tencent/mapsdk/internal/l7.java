package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l7.class */
public class l7 extends j7 implements IEmergeAnimation {

    /* renamed from: c  reason: collision with root package name */
    private LatLng f37609c;

    public l7(LatLng latLng) {
        this.f37609c = null;
        if (this.f37563a == null) {
            this.f37563a = new c8(latLng);
        }
        this.f37609c = latLng;
    }

    public LatLng a() {
        return this.f37609c;
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
