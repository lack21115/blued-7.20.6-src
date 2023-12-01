package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.a8;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e8.class */
public class e8 extends a8 {
    private float i;
    private float j;
    private float k;
    private float l;

    public e8(float f, float f2, float f3, float f4) {
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.i = f;
        this.j = f2;
        this.k = f3;
        this.l = f4;
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(float f, Interpolator interpolator) {
        if (f < 0.0f) {
            return;
        }
        float f2 = this.j;
        float f3 = this.i;
        float f4 = this.l;
        float f5 = this.k;
        float interpolation = interpolator.getInterpolation(f);
        float f6 = this.i;
        float f7 = this.k;
        a8.b bVar = this.h;
        if (bVar != null) {
            bVar.setScale(f6 + ((f2 - f3) * interpolation), f7 + ((f4 - f5) * interpolation));
        }
    }
}
