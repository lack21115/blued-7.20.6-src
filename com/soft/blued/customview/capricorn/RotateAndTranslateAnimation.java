package com.soft.blued.customview.capricorn;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/capricorn/RotateAndTranslateAnimation.class */
public class RotateAndTranslateAnimation extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private int f14884a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14885c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;
    private float q;
    private float r;
    private float s;
    private float t;

    public RotateAndTranslateAnimation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f14884a = 0;
        this.b = 0;
        this.f14885c = 0;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 0.0f;
        this.r = 0.0f;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.f14884a = 0;
        this.b = 0;
        this.f14885c = 0;
        this.d = 0;
        this.m = f5;
        this.n = f6;
        this.q = 0.5f;
        this.o = 1;
        this.r = 0.5f;
        this.p = 1;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.m;
        float f3 = f2 + ((this.n - f2) * f);
        if (this.s == 0.0f && this.t == 0.0f) {
            transformation.getMatrix().setRotate(f3);
        } else {
            transformation.getMatrix().setRotate(f3, this.s, this.t);
        }
        float f4 = this.i;
        float f5 = this.k;
        float f6 = this.j;
        float f7 = f4;
        if (f4 != f6) {
            f7 = f4 + ((f6 - f4) * f);
        }
        float f8 = this.k;
        float f9 = this.l;
        if (f8 != f9) {
            f5 = f8 + ((f9 - f8) * f);
        }
        transformation.getMatrix().postTranslate(f7, f5);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.i = resolveSize(this.f14884a, this.e, i, i3);
        this.j = resolveSize(this.b, this.f, i, i3);
        this.k = resolveSize(this.f14885c, this.g, i2, i4);
        this.l = resolveSize(this.d, this.h, i2, i4);
        this.s = resolveSize(this.o, this.q, i, i3);
        this.t = resolveSize(this.p, this.r, i2, i4);
    }
}
