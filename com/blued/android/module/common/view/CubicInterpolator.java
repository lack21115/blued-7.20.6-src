package com.blued.android.module.common.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CubicInterpolator.class */
public class CubicInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    protected PointF f10977a;
    protected PointF b;

    /* renamed from: c  reason: collision with root package name */
    protected PointF f10978c;
    protected PointF d;
    protected PointF e;

    public CubicInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    public CubicInterpolator(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.f10978c = new PointF();
        this.d = new PointF();
        this.e = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.f10977a = pointF;
        this.b = pointF2;
    }

    private float c(float f) {
        return this.e.x + (f * ((this.d.x * 2.0f) + (this.f10978c.x * 3.0f * f)));
    }

    private float d(float f) {
        this.e.x = this.f10977a.x * 3.0f;
        this.d.x = ((this.b.x - this.f10977a.x) * 3.0f) - this.e.x;
        this.f10978c.x = (1.0f - this.e.x) - this.d.x;
        return f * (this.e.x + ((this.d.x + (this.f10978c.x * f)) * f));
    }

    protected float a(float f) {
        this.e.y = this.f10977a.y * 3.0f;
        this.d.y = ((this.b.y - this.f10977a.y) * 3.0f) - this.e.y;
        this.f10978c.y = (1.0f - this.e.y) - this.d.y;
        return f * (this.e.y + ((this.d.y + (this.f10978c.y * f)) * f));
    }

    protected float b(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float d = d(f2) - f;
            if (Math.abs(d) < 0.001d) {
                return f2;
            }
            f2 -= d / c(f2);
        }
        return f2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return a(b(f));
    }
}
