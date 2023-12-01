package com.github.mikephil.charting.animation;

import android.animation.ValueAnimator;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/animation/ChartAnimator.class */
public class ChartAnimator {

    /* renamed from: a  reason: collision with root package name */
    protected float f8449a = 1.0f;
    protected float b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f8450c;

    public ChartAnimator() {
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f8450c = animatorUpdateListener;
    }

    public float a() {
        return this.f8449a;
    }

    public float b() {
        return this.b;
    }
}
