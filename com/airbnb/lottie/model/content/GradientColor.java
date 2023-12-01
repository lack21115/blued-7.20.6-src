package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/GradientColor.class */
public class GradientColor {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f4337a;
    private final int[] b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f4337a = fArr;
        this.b = iArr;
    }

    public void a(GradientColor gradientColor, GradientColor gradientColor2, float f) {
        if (gradientColor.b.length != gradientColor2.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.b.length + " vs " + gradientColor2.b.length + ")");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= gradientColor.b.length) {
                return;
            }
            this.f4337a[i2] = MiscUtils.a(gradientColor.f4337a[i2], gradientColor2.f4337a[i2], f);
            this.b[i2] = GammaEvaluator.a(f, gradientColor.b[i2], gradientColor2.b[i2]);
            i = i2 + 1;
        }
    }

    public float[] a() {
        return this.f4337a;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.b.length;
    }
}
