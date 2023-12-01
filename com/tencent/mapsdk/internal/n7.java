package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n7.class */
public class n7 extends j7 implements IScaleAnimation {
    public n7(float f, float f2, float f3, float f4) {
        if (this.f23872a == null) {
            this.f23872a = new e8(f, f2, f3, f4);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setDuration(long j) {
        a8 a8Var = this.f23872a;
        if (a8Var == null) {
            return;
        }
        a8Var.a(j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setInterpolator(Interpolator interpolator) {
        a8 a8Var = this.f23872a;
        if (a8Var == null || interpolator == null) {
            return;
        }
        a8Var.a(interpolator);
    }
}
