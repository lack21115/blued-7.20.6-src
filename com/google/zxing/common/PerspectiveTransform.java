package com.google.zxing.common;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/common/PerspectiveTransform.class */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a11 = f;
        this.a12 = f4;
        this.a13 = f7;
        this.a21 = f2;
        this.a22 = f5;
        this.a23 = f8;
        this.a31 = f3;
        this.a32 = f6;
        this.a33 = f9;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return squareToQuadrilateral(f9, f10, f11, f12, f13, f14, f15, f16).times(quadrilateralToSquare(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return squareToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new PerspectiveTransform(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new PerspectiveTransform((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    PerspectiveTransform buildAdjoint() {
        float f = this.a22;
        float f2 = this.a33;
        float f3 = this.a23;
        float f4 = this.a32;
        float f5 = this.a31;
        float f6 = this.a21;
        float f7 = this.a13;
        float f8 = this.a12;
        float f9 = this.a11;
        return new PerspectiveTransform((f * f2) - (f3 * f4), (f3 * f5) - (f6 * f2), (f6 * f4) - (f * f5), (f7 * f4) - (f8 * f2), (f2 * f9) - (f7 * f5), (f5 * f8) - (f4 * f9), (f8 * f3) - (f7 * f), (f7 * f6) - (f3 * f9), (f9 * f) - (f8 * f6));
    }

    PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        float f = this.a11;
        float f2 = perspectiveTransform.a11;
        float f3 = this.a21;
        float f4 = perspectiveTransform.a12;
        float f5 = this.a31;
        float f6 = perspectiveTransform.a13;
        float f7 = perspectiveTransform.a21;
        float f8 = perspectiveTransform.a22;
        float f9 = perspectiveTransform.a23;
        float f10 = perspectiveTransform.a31;
        float f11 = perspectiveTransform.a32;
        float f12 = perspectiveTransform.a33;
        float f13 = this.a12;
        float f14 = this.a22;
        float f15 = this.a32;
        float f16 = this.a13;
        float f17 = this.a23;
        float f18 = this.a33;
        return new PerspectiveTransform((f * f2) + (f3 * f4) + (f5 * f6), (f * f7) + (f3 * f8) + (f5 * f9), (f * f10) + (f3 * f11) + (f5 * f12), (f13 * f2) + (f14 * f4) + (f15 * f6), (f13 * f7) + (f14 * f8) + (f15 * f9), (f15 * f12) + (f13 * f10) + (f14 * f11), (f6 * f18) + (f2 * f16) + (f4 * f17), (f7 * f16) + (f8 * f17) + (f9 * f18), (f16 * f10) + (f17 * f11) + (f18 * f12));
    }

    public void transformPoints(float[] fArr) {
        int length = fArr.length;
        float f = this.a11;
        float f2 = this.a12;
        float f3 = this.a13;
        float f4 = this.a21;
        float f5 = this.a22;
        float f6 = this.a23;
        float f7 = this.a31;
        float f8 = this.a32;
        float f9 = this.a33;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            float f10 = fArr[i2];
            int i3 = i2 + 1;
            float f11 = fArr[i3];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            fArr[i2] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i3] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
            i = i2 + 2;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            float f = fArr[i2];
            float f2 = fArr2[i2];
            float f3 = (this.a13 * f) + (this.a23 * f2) + this.a33;
            fArr[i2] = (((this.a11 * f) + (this.a21 * f2)) + this.a31) / f3;
            fArr2[i2] = (((this.a12 * f) + (this.a22 * f2)) + this.a32) / f3;
            i = i2 + 1;
        }
    }
}
