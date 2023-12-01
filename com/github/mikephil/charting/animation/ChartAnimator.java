package com.github.mikephil.charting.animation;

import android.animation.ValueAnimator;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/animation/ChartAnimator.class */
public class ChartAnimator {

    /* renamed from: a  reason: collision with root package name */
    protected float f22056a = 1.0f;
    protected float b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f22057c;

    public ChartAnimator() {
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f22057c = animatorUpdateListener;
    }

    public float a() {
        return this.f22056a;
    }

    public float b() {
        return this.b;
    }
}
