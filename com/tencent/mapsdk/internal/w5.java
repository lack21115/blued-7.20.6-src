package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w5.class */
public class w5 {

    /* renamed from: a  reason: collision with root package name */
    private x5 f24396a;
    private x5[] b;

    /* renamed from: c  reason: collision with root package name */
    private float f24397c;

    public w5(x5 x5Var, x5[] x5VarArr, float f) {
        this.f24396a = x5Var;
        this.b = x5VarArr;
        this.f24397c = f;
    }

    /* renamed from: a */
    public w5 clone() {
        return new w5(this.f24396a, this.b, this.f24397c);
    }

    public void a(x5 x5Var, x5[] x5VarArr, float f) {
        this.f24396a = x5Var;
        this.b = x5VarArr;
        this.f24397c = f;
    }

    public boolean a(w5 w5Var) {
        x5[] x5VarArr;
        x5 x5Var;
        if (w5Var == null || Float.compare(w5Var.f24397c, this.f24397c) >= 1) {
            return true;
        }
        x5 x5Var2 = this.f24396a;
        if (x5Var2 != null && (x5Var = w5Var.f24396a) != null && xa.a(x5Var2, x5Var) > 50.0d) {
            return true;
        }
        x5[] x5VarArr2 = this.b;
        if (x5VarArr2 == null || (x5VarArr = w5Var.b) == null || x5VarArr2.length != x5VarArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            x5[] x5VarArr3 = this.b;
            if (i2 >= x5VarArr3.length) {
                return false;
            }
            if (xa.a(x5VarArr3[i2], w5Var.b[i2]) > 50.0d) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public x5 b() {
        return this.f24396a;
    }

    public x5[] c() {
        return this.b;
    }

    public float d() {
        return this.f24397c;
    }
}
