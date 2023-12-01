package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v8.class */
public class v8 implements Cloneable {
    private static final y8<Integer> g = new q8();
    private static final y8<Number> h = new o8();
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f24373c;
    public t8 d;
    private y8 e;
    private Object f;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v8$b.class */
    public static class b extends v8 {
        public p8 i;
        public double j;

        public b(int i, p8 p8Var) {
            super(i);
            this.f24373c = Float.TYPE;
            this.d = p8Var;
            this.i = p8Var;
        }

        public b(int i, double... dArr) {
            super(i);
            a(dArr);
        }

        @Override // com.tencent.mapsdk.internal.v8
        public void a(float f) {
            this.j = this.i.b(f);
        }

        @Override // com.tencent.mapsdk.internal.v8
        public void a(h8 h8Var) {
            if (h8Var != null) {
                h8Var.a(this.b, Double.valueOf(this.j));
            }
        }

        @Override // com.tencent.mapsdk.internal.v8
        public void a(double... dArr) {
            super.a(dArr);
            this.i = (p8) this.d;
        }

        @Override // com.tencent.mapsdk.internal.v8
        public Object b() {
            return Double.valueOf(this.j);
        }

        @Override // com.tencent.mapsdk.internal.v8
        /* renamed from: e */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.i = (p8) bVar.d;
            return bVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v8$c.class */
    public static class c extends v8 {
        public r8 i;
        public int j;

        public c(int i, r8 r8Var) {
            super(i);
            this.f24373c = Integer.TYPE;
            this.d = r8Var;
            this.i = r8Var;
        }

        public c(int i, int... iArr) {
            super(i);
            a(iArr);
        }

        @Override // com.tencent.mapsdk.internal.v8
        public void a(float f) {
            this.j = this.i.b(f);
        }

        @Override // com.tencent.mapsdk.internal.v8
        public void a(h8 h8Var) {
            if (h8Var != null) {
                h8Var.a(this.b, Integer.valueOf(this.j));
            }
        }

        @Override // com.tencent.mapsdk.internal.v8
        public void a(int... iArr) {
            super.a(iArr);
            this.i = (r8) this.d;
        }

        @Override // com.tencent.mapsdk.internal.v8
        public Object b() {
            return Integer.valueOf(this.j);
        }

        @Override // com.tencent.mapsdk.internal.v8
        /* renamed from: e */
        public c clone() {
            c cVar = (c) super.clone();
            cVar.i = (r8) cVar.d;
            return cVar;
        }
    }

    private v8(int i) {
        this.d = null;
        this.b = i;
    }

    public static v8 a(int i, y8<Object> y8Var, Object... objArr) {
        v8 v8Var = new v8(i);
        v8Var.a(objArr);
        v8Var.a(y8Var);
        return v8Var;
    }

    public static v8 a(int i, double... dArr) {
        return new b(i, dArr);
    }

    public static v8 a(int i, int... iArr) {
        return new c(i, iArr);
    }

    public static v8 a(int i, s8... s8VarArr) {
        t8 a2 = t8.a(s8VarArr);
        v8 v8Var = new v8(i);
        v8Var.d = a2;
        return v8Var;
    }

    @Override // 
    /* renamed from: a */
    public v8 clone() {
        try {
            v8 v8Var = (v8) super.clone();
            v8Var.b = this.b;
            v8Var.d = this.d.clone();
            v8Var.e = this.e;
            return v8Var;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void a(float f) {
        this.f = this.d.a(f);
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(h8 h8Var) {
        if (h8Var != null) {
            h8Var.a(this.b, b());
        }
    }

    public void a(y8 y8Var) {
        this.e = y8Var;
        this.d.a(y8Var);
    }

    public void a(double... dArr) {
        this.f24373c = Double.TYPE;
        this.d = t8.a(dArr);
    }

    public void a(int... iArr) {
        this.f24373c = Integer.TYPE;
        this.d = t8.a(iArr);
    }

    public void a(s8... s8VarArr) {
        int length = s8VarArr.length;
        s8[] s8VarArr2 = new s8[Math.max(length, 2)];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.d = new t8(s8VarArr2);
                return;
            } else {
                s8VarArr2[i2] = s8VarArr[i2];
                i = i2 + 1;
            }
        }
    }

    public void a(Object... objArr) {
        this.f24373c = objArr[0].getClass();
        this.d = t8.a(objArr);
    }

    public Object b() {
        return this.f;
    }

    public int c() {
        return this.b;
    }

    public void d() {
        if (this.e == null) {
            Class<?> cls = this.f24373c;
            this.e = cls == Integer.class ? g : cls == Double.class ? h : null;
        }
        y8 y8Var = this.e;
        if (y8Var != null) {
            this.d.a(y8Var);
        }
    }

    public String toString() {
        return this.b + ": " + this.d.toString();
    }
}
