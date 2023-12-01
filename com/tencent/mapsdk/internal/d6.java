package com.tencent.mapsdk.internal;

import android.opengl.Matrix;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d6.class */
public class d6 {

    /* renamed from: a  reason: collision with root package name */
    public float f37388a;
    public float b;

    /* renamed from: c  reason: collision with root package name */
    public float f37389c;
    public float d = 1.0f;

    public d6() {
    }

    public d6(float f, float f2, float f3) {
        this.f37388a = f;
        this.b = f2;
        this.f37389c = f3;
    }

    public d6 a(float[] fArr) {
        float[] fArr2 = new float[4];
        Matrix.multiplyMV(fArr2, 0, fArr, 0, new float[]{this.f37388a, this.b, this.f37389c, this.d}, 0);
        return new d6(fArr2[0] / fArr2[3], fArr2[1] / fArr2[3], fArr2[2] / fArr2[3]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d6) {
            d6 d6Var = (d6) obj;
            boolean z = false;
            if (this.f37388a == d6Var.f37388a) {
                z = false;
                if (this.b == d6Var.b) {
                    z = false;
                    if (this.f37389c == d6Var.f37389c) {
                        z = true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    public String toString() {
        return this.f37388a + "," + this.b + "," + this.f37389c;
    }
}
