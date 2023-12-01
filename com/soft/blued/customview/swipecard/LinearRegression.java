package com.soft.blued.customview.swipecard;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/LinearRegression.class */
public class LinearRegression {

    /* renamed from: a  reason: collision with root package name */
    private final double f28661a;
    private final double b;

    /* renamed from: c  reason: collision with root package name */
    private final double f28662c;

    public double a() {
        return this.f28661a;
    }

    public double b() {
        return this.b;
    }

    public double c() {
        return this.f28662c;
    }

    public String toString() {
        return ("" + String.format("%.2f N + %.2f", Double.valueOf(b()), Double.valueOf(a()))) + "  (R^2 = " + String.format("%.3f", Double.valueOf(c())) + ")";
    }
}
