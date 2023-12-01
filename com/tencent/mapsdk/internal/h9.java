package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h9.class */
public class h9 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double d = f / 0.5d;
        return (float) ((d < 1.0d ? Math.pow(d, 3.0d) : Math.pow(d - 2.0d, 3.0d) + 2.0d) * 0.5d);
    }
}
