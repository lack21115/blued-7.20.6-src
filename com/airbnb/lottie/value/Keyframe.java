package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/Keyframe.class */
public class Keyframe<T> {
    public final T a;
    public T b;
    public final Interpolator c;
    public final float d;
    public Float e;
    public PointF f;
    public PointF g;
    private final LottieComposition h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;

    public Keyframe(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.f = null;
        this.g = null;
        this.h = lottieComposition;
        this.a = t;
        this.b = t2;
        this.c = interpolator;
        this.d = f;
        this.e = f2;
    }

    public Keyframe(T t) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = t;
        this.b = t;
        this.c = null;
        this.d = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(float f) {
        return f >= c() && f < d();
    }

    public float c() {
        LottieComposition lottieComposition = this.h;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.d - lottieComposition.f()) / this.h.m();
        }
        return this.m;
    }

    public float d() {
        if (this.h == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.e == null) {
                this.n = 1.0f;
            } else {
                this.n = c() + ((this.e.floatValue() - this.d) / this.h.m());
            }
        }
        return this.n;
    }

    public boolean e() {
        return this.c == null;
    }

    public float f() {
        if (this.i == -3987645.8f) {
            this.i = ((Float) this.a).floatValue();
        }
        return this.i;
    }

    public float g() {
        if (this.j == -3987645.8f) {
            this.j = ((Float) this.b).floatValue();
        }
        return this.j;
    }

    public int h() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.a).intValue();
        }
        return this.k;
    }

    public int i() {
        if (this.l == 784923401) {
            this.l = ((Integer) this.b).intValue();
        }
        return this.l;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.a + ", endValue=" + this.b + ", startFrame=" + this.d + ", endFrame=" + this.e + ", interpolator=" + this.c + '}';
    }
}
