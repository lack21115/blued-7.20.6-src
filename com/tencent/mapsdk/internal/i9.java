package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i9.class */
public class i9 implements Interpolator {
    public i9() {
    }

    public i9(Context context, AttributeSet attributeSet) {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f * f;
    }
}
