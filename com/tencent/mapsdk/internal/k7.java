package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k7.class */
public class k7 extends j7 implements IAnimationSet {
    public k7(boolean z) {
        if (this.f23872a == null) {
            this.f23872a = new b8(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet
    public boolean addAnimation(Animation animation) {
        a8 a8Var;
        a8 a8Var2;
        if (animation == null || !(animation instanceof j7) || (a8Var = ((j7) animation).f23872a) == null || (a8Var2 = this.f23872a) == null) {
            return false;
        }
        ((b8) a8Var2).a(a8Var);
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet
    public void cleanAnimation() {
        a8 a8Var = this.f23872a;
        if (a8Var == null) {
            return;
        }
        ((b8) a8Var).i();
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
