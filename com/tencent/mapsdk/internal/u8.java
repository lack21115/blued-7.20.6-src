package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u8.class */
public final class u8 extends z8 {
    public int M;

    public u8(h8 h8Var) {
        super(h8Var);
    }

    private u8(h8 h8Var, int i) {
        super(h8Var);
        d(i);
    }

    public static u8 a(h8 h8Var, int i, y8 y8Var, Object[] objArr) {
        u8 u8Var = new u8(h8Var, i);
        u8Var.a(objArr);
        u8Var.a(y8Var);
        return u8Var;
    }

    public static u8 a(h8 h8Var, int i, double... dArr) {
        u8 u8Var = new u8(h8Var, i);
        u8Var.a(dArr);
        return u8Var;
    }

    public static u8 a(h8 h8Var, int i, int... iArr) {
        u8 u8Var = new u8(h8Var, i);
        u8Var.a(iArr);
        return u8Var;
    }

    public static u8 b(h8 h8Var, v8... v8VarArr) {
        u8 u8Var = new u8(h8Var);
        u8Var.a(v8VarArr);
        return u8Var;
    }

    @Override // com.tencent.mapsdk.internal.z8, com.tencent.mapsdk.internal.k8
    /* renamed from: E */
    public u8 clone() {
        return (u8) super.clone();
    }

    public int F() {
        return this.M;
    }

    public h8 G() {
        return this.u;
    }

    @Override // com.tencent.mapsdk.internal.z8
    public void a(double... dArr) {
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length == 0) {
            a(v8.a(this.M, dArr));
        } else {
            super.a(dArr);
        }
    }

    @Override // com.tencent.mapsdk.internal.z8
    public void a(int... iArr) {
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length == 0) {
            a(v8.a(this.M, iArr));
        } else {
            super.a(iArr);
        }
    }

    @Override // com.tencent.mapsdk.internal.z8
    public void a(Object... objArr) {
        v8[] v8VarArr = this.s;
        if (v8VarArr == null || v8VarArr.length == 0) {
            a(v8.a(this.M, null, objArr));
        } else {
            super.a(objArr);
        }
    }

    public void d(int i) {
        v8[] v8VarArr = this.s;
        if (v8VarArr != null) {
            v8 v8Var = v8VarArr[0];
            this.t.remove(Integer.valueOf(v8Var.c()));
            this.t.put(Integer.valueOf(i), v8Var);
        }
        this.M = i;
    }

    @Override // com.tencent.mapsdk.internal.z8, com.tencent.mapsdk.internal.k8
    /* renamed from: g */
    public u8 a(long j) {
        super.a(j);
        return this;
    }

    @Override // com.tencent.mapsdk.internal.z8
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.u;
        String str2 = str;
        if (this.s != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                str2 = str;
                if (i2 >= this.s.length) {
                    break;
                }
                str = str + "\n    " + this.s[i2].toString();
                i = i2 + 1;
            }
        }
        return str2;
    }
}
