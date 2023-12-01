package com.airbnb.lottie.utils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/MeanCalculator.class */
public class MeanCalculator {
    private float a;
    private int b;

    public void a(float f) {
        float f2 = this.a + f;
        this.a = f2;
        int i = this.b + 1;
        this.b = i;
        if (i == Integer.MAX_VALUE) {
            this.a = f2 / 2.0f;
            this.b = i / 2;
        }
    }
}
