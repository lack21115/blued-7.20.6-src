package com.airbnb.lottie.model;

import android.graphics.PointF;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/CubicCurveData.class */
public class CubicCurveData {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f4313a;
    private final PointF b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f4314c;

    public CubicCurveData() {
        this.f4313a = new PointF();
        this.b = new PointF();
        this.f4314c = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f4313a = pointF;
        this.b = pointF2;
        this.f4314c = pointF3;
    }

    public PointF a() {
        return this.f4313a;
    }

    public void a(float f, float f2) {
        this.f4313a.set(f, f2);
    }

    public PointF b() {
        return this.b;
    }

    public void b(float f, float f2) {
        this.b.set(f, f2);
    }

    public PointF c() {
        return this.f4314c;
    }

    public void c(float f, float f2) {
        this.f4314c.set(f, f2);
    }
}
