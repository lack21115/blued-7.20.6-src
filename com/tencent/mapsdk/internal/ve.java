package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ve.class */
public class ve extends we implements h8 {
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;
    private int g;
    public float h = 1.0f;
    public float i = 1.0f;
    public float j = 1.0f;
    public float k = 0.0f;
    public float l = 0.0f;
    public float m = 0.0f;
    private a n;
    private b o;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ve$a.class */
    public interface a {
        Bitmap a(int i);

        boolean a();

        String b();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ve$b.class */
    public interface b {
        void a(Bitmap bitmap);
    }

    @Override // com.tencent.mapsdk.internal.h8
    public void a(int i, Object obj) {
        if (i == 1) {
            this.h = ((Number) obj).floatValue();
        } else if (i == 2) {
            p5 p5Var = (p5) obj;
            this.i = (float) p5Var.b;
            this.j = (float) p5Var.f23992c;
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            this.m = ((Number) obj).floatValue();
        } else {
            p5 p5Var2 = (p5) obj;
            this.k = (float) p5Var2.b;
            this.l = (float) p5Var2.f23992c;
        }
    }

    public void a(a aVar) {
        synchronized (this) {
            this.n = aVar;
        }
    }

    public void b(int i) {
        this.g = i;
        this.h = 1.0f;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 0.0f;
        this.l = 0.0f;
    }

    public int c() {
        return this.g;
    }
}
