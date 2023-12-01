package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m7.class */
public class m7 extends j7 implements IRotateAnimation {
    public m7(float f, float f2, float f3, float f4, float f5) {
        if (this.f37563a == null) {
            this.f37563a = new d8(f, f2, f3, f4, f5);
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
