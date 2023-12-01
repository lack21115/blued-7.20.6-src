package com.airbnb.lottie.value;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/value/LottieFrameInfo.class */
public class LottieFrameInfo<T> {
    private float a;
    private float b;
    private T c;
    private T d;
    private float e;
    private float f;
    private float g;

    public LottieFrameInfo<T> a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        this.a = f;
        this.b = f2;
        this.c = t;
        this.d = t2;
        this.e = f3;
        this.f = f4;
        this.g = f5;
        return this;
    }

    public T a() {
        return this.c;
    }

    public T b() {
        return this.d;
    }

    public float c() {
        return this.f;
    }

    public float d() {
        return this.g;
    }
}
