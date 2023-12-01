package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g9.class */
public class g9 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double d = f - 1.0d;
        double d2 = d * d;
        double d3 = d2 * d2;
        return (float) (1.0d - (d3 * d3));
    }
}
