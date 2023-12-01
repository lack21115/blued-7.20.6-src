package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j9.class */
public class j9 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f * (2.0f - f);
    }
}
