package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f9.class */
public class f9 implements Interpolator {
    public f9() {
    }

    public f9(Context context, AttributeSet attributeSet) {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (float) Math.sqrt(1.0f - (f2 * f2));
    }
}
