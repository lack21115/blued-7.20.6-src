package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/a.class */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.FA());
        return valueAnimator;
    }
}
