package com.amap.api.maps.model.particle;

import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/particle/RandomColorBetWeenTwoConstants.class */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {
    private float a;
    private float a1;
    private float b;
    private float b1;
    private float g;
    private float g1;
    private float r;
    private float r1;
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};
    private Random random = new Random();

    public RandomColorBetWeenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.r = f / 255.0f;
        this.g = f2 / 255.0f;
        this.b = f3 / 255.0f;
        this.a = f4 / 255.0f;
        this.r1 = f5 / 255.0f;
        this.g1 = f6 / 255.0f;
        this.b1 = f7 / 255.0f;
        this.a1 = f8 / 255.0f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f = this.r1;
        float f2 = this.r;
        fArr[0] = (nextFloat * (f - f2)) + f2;
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f3 = this.g1;
        float f4 = this.g;
        fArr2[1] = (nextFloat2 * (f3 - f4)) + f4;
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f5 = this.b1;
        float f6 = this.b;
        fArr3[2] = (nextFloat3 * (f5 - f6)) + f6;
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f7 = this.a1;
        float f8 = this.a;
        fArr4[3] = (nextFloat4 * (f7 - f8)) + f8;
        return this.color;
    }
}
