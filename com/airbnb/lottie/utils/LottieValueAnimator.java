package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.LottieComposition;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/LottieValueAnimator.class */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition i;
    private float b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4413c = false;
    private long d = 0;
    private float e = 0.0f;
    private int f = 0;
    private float g = -2.14748365E9f;
    private float h = 2.14748365E9f;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f4412a = false;

    private float q() {
        LottieComposition lottieComposition = this.i;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.h()) / Math.abs(this.b);
    }

    private boolean r() {
        return h() < 0.0f;
    }

    private void s() {
        if (this.i == null) {
            return;
        }
        float f = this.e;
        if (f < this.g || f > this.h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(this.e)));
        }
    }

    public void a(float f) {
        a(this.g, f);
    }

    public void a(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        LottieComposition lottieComposition = this.i;
        float f3 = lottieComposition == null ? -3.4028235E38f : lottieComposition.f();
        LottieComposition lottieComposition2 = this.i;
        float g = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.g();
        this.g = MiscUtils.b(f, f3, g);
        this.h = MiscUtils.b(f2, f3, g);
        a((int) MiscUtils.b(this.e, f, f2));
    }

    public void a(int i) {
        float f = i;
        if (this.e == f) {
            return;
        }
        this.e = MiscUtils.b(f, m(), n());
        this.d = System.nanoTime();
        c();
    }

    public void a(LottieComposition lottieComposition) {
        boolean z = this.i == null;
        this.i = lottieComposition;
        if (z) {
            a((int) Math.max(this.g, lottieComposition.f()), (int) Math.min(this.h, lottieComposition.g()));
        } else {
            a((int) lottieComposition.f(), (int) lottieComposition.g());
        }
        float f = this.e;
        this.e = 0.0f;
        a((int) f);
    }

    public void b(float f) {
        this.b = f;
    }

    public void b(int i) {
        a(i, (int) this.h);
    }

    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f4412a = false;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b();
        p();
    }

    public float d() {
        LottieComposition lottieComposition = this.i;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.e - lottieComposition.f()) / (this.i.g() - this.i.f());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        o();
        if (this.i == null || !isRunning()) {
            return;
        }
        float q = ((float) (j - this.d)) / q();
        float f = this.e;
        float f2 = q;
        if (r()) {
            f2 = -q;
        }
        float f3 = f + f2;
        this.e = f3;
        boolean c2 = MiscUtils.c(f3, m(), n());
        this.e = MiscUtils.b(this.e, m(), n());
        this.d = j;
        c();
        if (!c2) {
            if (getRepeatCount() == -1 || this.f < getRepeatCount()) {
                a();
                this.f++;
                if (getRepeatMode() == 2) {
                    this.f4413c = !this.f4413c;
                    g();
                } else {
                    this.e = r() ? n() : m();
                }
                this.d = j;
            } else {
                this.e = n();
                p();
                b(r());
            }
        }
        s();
    }

    public float e() {
        return this.e;
    }

    public void f() {
        this.i = null;
        this.g = -2.14748365E9f;
        this.h = 2.14748365E9f;
    }

    public void g() {
        b(-h());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float m;
        float n;
        float m2;
        if (this.i == null) {
            return 0.0f;
        }
        if (r()) {
            m = n() - this.e;
            n = n();
            m2 = m();
        } else {
            m = this.e - m();
            n = n();
            m2 = m();
        }
        return m / (n - m2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.i;
        if (lottieComposition == null) {
            return 0L;
        }
        return lottieComposition.e();
    }

    public float h() {
        return this.b;
    }

    public void i() {
        this.f4412a = true;
        a(r());
        a((int) (r() ? n() : m()));
        this.d = System.nanoTime();
        this.f = 0;
        o();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f4412a;
    }

    public void j() {
        p();
        b(r());
    }

    public void k() {
        p();
    }

    public void l() {
        this.f4412a = true;
        o();
        this.d = System.nanoTime();
        if (r() && e() == m()) {
            this.e = n();
        } else if (r() || e() != n()) {
        } else {
            this.e = m();
        }
    }

    public float m() {
        LottieComposition lottieComposition = this.i;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.g;
        float f2 = f;
        if (f == -2.14748365E9f) {
            f2 = lottieComposition.f();
        }
        return f2;
    }

    public float n() {
        LottieComposition lottieComposition = this.i;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.h;
        float f2 = f;
        if (f == 2.14748365E9f) {
            f2 = lottieComposition.g();
        }
        return f2;
    }

    protected void o() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void p() {
        c(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f4413c) {
            return;
        }
        this.f4413c = false;
        g();
    }
}
