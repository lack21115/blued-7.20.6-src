package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.a8;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z7.class */
public class z7 extends a8 {
    private float i;
    private float j;

    public z7(float f, float f2) {
        this.i = 0.0f;
        this.j = 0.0f;
        this.i = f;
        this.j = f2;
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(float f, Interpolator interpolator) {
        float f2 = this.j;
        float f3 = this.i;
        float interpolation = interpolator.getInterpolation(f);
        float f4 = this.i;
        a8.b bVar = this.h;
        if (bVar != null) {
            bVar.setAlpha(f4 + ((f2 - f3) * interpolation));
        }
    }
}
