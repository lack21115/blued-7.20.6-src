package com.tencent.mapsdk.internal;

import android.opengl.Matrix;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d6.class */
public class d6 {

    /* renamed from: a  reason: collision with root package name */
    public float f23697a;
    public float b;

    /* renamed from: c  reason: collision with root package name */
    public float f23698c;
    public float d = 1.0f;

    public d6() {
    }

    public d6(float f, float f2, float f3) {
        this.f23697a = f;
        this.b = f2;
        this.f23698c = f3;
    }

    public d6 a(float[] fArr) {
        float[] fArr2 = new float[4];
        Matrix.multiplyMV(fArr2, 0, fArr, 0, new float[]{this.f23697a, this.b, this.f23698c, this.d}, 0);
        return new d6(fArr2[0] / fArr2[3], fArr2[1] / fArr2[3], fArr2[2] / fArr2[3]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d6) {
            d6 d6Var = (d6) obj;
            boolean z = false;
            if (this.f23697a == d6Var.f23697a) {
                z = false;
                if (this.b == d6Var.b) {
                    z = false;
                    if (this.f23698c == d6Var.f23698c) {
                        z = true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    public String toString() {
        return this.f23697a + "," + this.b + "," + this.f23698c;
    }
}
