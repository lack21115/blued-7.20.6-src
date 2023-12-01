package com.airbnb.lottie.utils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/MeanCalculator.class */
public class MeanCalculator {

    /* renamed from: a  reason: collision with root package name */
    private float f4414a;
    private int b;

    public void a(float f) {
        float f2 = this.f4414a + f;
        this.f4414a = f2;
        int i = this.b + 1;
        this.b = i;
        if (i == Integer.MAX_VALUE) {
            this.f4414a = f2 / 2.0f;
            this.b = i / 2;
        }
    }
}
