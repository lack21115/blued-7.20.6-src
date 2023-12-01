package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a9.class */
public class a9 {
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 100;
    public static final int o = 101;
    public static final int p = 102;
    public static final int q = 103;
    public static final int r = 104;
    public static final int s = 105;
    public static final int t = 10000;
    public static final int u = 108;
    public static final int v = 109;
    public static final int w = 110;
    public static final int x = 120;

    /* renamed from: a  reason: collision with root package name */
    public int f37291a;
    public double[] b;

    /* renamed from: c  reason: collision with root package name */
    public long f37292c;
    public boolean d;
    public boolean e;
    public Runnable f;
    private j8 g;
    public static final a9 y = new a9(1, null);
    public static final a9 z = new a9(2, null, true);
    public static final a9 A = new a9(104, null);

    public a9() {
        this.f37292c = -1L;
        this.d = false;
    }

    public a9(int i2, double[] dArr) {
        this(i2, dArr, false);
    }

    public a9(int i2, double[] dArr, boolean z2) {
        this.f37292c = -1L;
        this.d = false;
        this.f37291a = i2;
        this.b = dArr;
        this.e = z2;
    }

    public a9(Runnable runnable) {
        this.f37292c = -1L;
        this.d = false;
        this.f37291a = 6;
        this.f = runnable;
    }

    public long a() {
        long j2 = this.f37292c;
        long j3 = 0;
        if (j2 >= 0) {
            return j2;
        }
        if (this.f37291a >= 100) {
            j3 = 20;
        }
        return j3;
    }

    public void a(j8 j8Var) {
        this.g = j8Var;
    }

    public boolean a(d9 d9Var) {
        j8 j8Var = this.g;
        if (j8Var != null) {
            j8Var.onStart();
        }
        boolean d = d();
        d9Var.a(this);
        return d;
    }

    public void b() {
        j8 j8Var = this.g;
        if (j8Var != null) {
            j8Var.onCancel();
        }
    }

    public void c() {
        j8 j8Var = this.g;
        if (j8Var != null) {
            j8Var.onFinish();
        }
    }

    public boolean d() {
        return true;
    }
}
