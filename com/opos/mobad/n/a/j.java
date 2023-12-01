package com.opos.mobad.n.a;

import android.animation.FloatEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/j.class */
public class j implements TypeEvaluator<Float> {

    /* renamed from: a  reason: collision with root package name */
    private TimeInterpolator f12838a;
    private FloatEvaluator b = new FloatEvaluator();

    /* renamed from: c  reason: collision with root package name */
    private float f12839c;
    private float d;

    public j(TimeInterpolator timeInterpolator, float f, float f2) {
        this.f12838a = timeInterpolator;
        this.f12839c = f;
        this.d = f2;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Float evaluate(float f, Float f2, Float f3) {
        return this.b.evaluate(this.f12838a.getInterpolation(f), (Number) Float.valueOf(this.f12839c), (Number) Float.valueOf(this.d));
    }
}
