package com.airbnb.lottie.value;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/ScaleXY.class */
public class ScaleXY {
    private float a;
    private float b;

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public ScaleXY(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public float a() {
        return this.a;
    }

    public void a(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public float b() {
        return this.b;
    }

    public boolean b(float f, float f2) {
        return this.a == f && this.b == f2;
    }

    public String toString() {
        return a() + "x" + b();
    }
}
