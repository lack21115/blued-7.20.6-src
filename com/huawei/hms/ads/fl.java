package com.huawei.hms.ads;

import android.view.animation.Interpolator;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fl.class */
public class fl implements Interpolator {
    float B;
    float C;
    float S;
    float Z;

    public fl(float f, float f2, float f3, float f4) {
        this.Z = 0.0f;
        this.B = 0.0f;
        this.C = 0.0f;
        this.S = 0.0f;
        this.Z = f;
        this.B = f2;
        this.C = f3;
        this.S = f4;
        ge.Code("CubicBezierInterpolator", toString());
    }

    private float I(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.Z) + (f3 * f * f * this.C) + (f * f * f);
    }

    protected float Code(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.B) + (f3 * f * f * this.S) + (f * f * f);
    }

    long V(float f) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            int i = (I(((float) j3) * 2.5E-4f) > f ? 1 : (I(((float) j3) * 2.5E-4f) == f ? 0 : -1));
            if (i < 0) {
                j = j3 + 1;
            } else if (i <= 0) {
                return j3;
            } else {
                j2 = j3 - 1;
            }
        }
        return j;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return Code(((float) V(f)) * 2.5E-4f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CubicBezierInterpolator");
        stringBuffer.append("  mControlPoint1x = ");
        stringBuffer.append(this.Z);
        stringBuffer.append(", mControlPoint1y = ");
        stringBuffer.append(this.B);
        stringBuffer.append(", mControlPoint2x = ");
        stringBuffer.append(this.C);
        stringBuffer.append(", mControlPoint2y = ");
        stringBuffer.append(this.S);
        return stringBuffer.toString();
    }
}
