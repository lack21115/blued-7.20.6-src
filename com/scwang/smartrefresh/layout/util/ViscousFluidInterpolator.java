package com.scwang.smartrefresh.layout.util;

import android.view.animation.Interpolator;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/util/ViscousFluidInterpolator.class */
public class ViscousFluidInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private static final float f14312a;
    private static final float b;

    static {
        float a2 = 1.0f / a(1.0f);
        f14312a = a2;
        b = 1.0f - (a2 * a(1.0f));
    }

    private static float a(float f) {
        float f2 = f * 8.0f;
        return f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float a2 = f14312a * a(f);
        float f2 = a2;
        if (a2 > 0.0f) {
            f2 = a2 + b;
        }
        return f2;
    }
}
