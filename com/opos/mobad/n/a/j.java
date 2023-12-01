package com.opos.mobad.n.a;

import android.animation.FloatEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/j.class */
public class j implements TypeEvaluator<Float> {

    /* renamed from: a  reason: collision with root package name */
    private TimeInterpolator f26526a;
    private FloatEvaluator b = new FloatEvaluator();

    /* renamed from: c  reason: collision with root package name */
    private float f26527c;
    private float d;

    public j(TimeInterpolator timeInterpolator, float f, float f2) {
        this.f26526a = timeInterpolator;
        this.f26527c = f;
        this.d = f2;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        return this.b.evaluate(this.f26526a.getInterpolation(f), (Number) Float.valueOf(this.f26527c), (Number) Float.valueOf(this.d));
    }
}
