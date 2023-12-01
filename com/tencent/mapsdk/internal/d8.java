package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.a8;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d8.class */
public class d8 extends a8 {
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;

    public d8(float f, float f2, float f3, float f4, float f5) {
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.i = f;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.m = f5;
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(float f, Interpolator interpolator) {
        float f2 = this.j;
        float f3 = this.i;
        float interpolation = interpolator.getInterpolation(f);
        float f4 = this.i;
        a8.b bVar = this.h;
        if (bVar != null) {
            bVar.a(f4 + ((f2 - f3) * interpolation), this.k, this.l, this.m);
        }
    }
}
