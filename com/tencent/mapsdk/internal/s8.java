package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s8.class */
public abstract class s8 implements Cloneable {
    public float b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f24308c;
    private Interpolator d = null;
    public boolean e = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s8$a.class */
    public static class a extends s8 {
        public double f;

        public a(float f) {
            this.b = f;
            this.f24308c = Double.TYPE;
        }

        public a(float f, double d) {
            this.b = f;
            this.f = d;
            this.f24308c = Double.TYPE;
            this.e = true;
        }

        @Override // com.tencent.mapsdk.internal.s8
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Double.class) {
                return;
            }
            this.f = ((Double) obj).doubleValue();
            this.e = true;
        }

        @Override // com.tencent.mapsdk.internal.s8
        public Object e() {
            return Double.valueOf(this.f);
        }

        @Override // com.tencent.mapsdk.internal.s8
        /* renamed from: g */
        public a clone() {
            a aVar = new a(b(), this.f);
            aVar.a(c());
            return aVar;
        }

        public double h() {
            return this.f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s8$b.class */
    public static class b extends s8 {
        public int f;

        public b(float f) {
            this.b = f;
            this.f24308c = Integer.TYPE;
        }

        public b(float f, int i) {
            this.b = f;
            this.f = i;
            this.f24308c = Integer.TYPE;
            this.e = true;
        }

        @Override // com.tencent.mapsdk.internal.s8
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f = ((Integer) obj).intValue();
            this.e = true;
        }

        @Override // com.tencent.mapsdk.internal.s8
        public Object e() {
            return Integer.valueOf(this.f);
        }

        @Override // com.tencent.mapsdk.internal.s8
        /* renamed from: g */
        public b clone() {
            b bVar = new b(b(), this.f);
            bVar.a(c());
            return bVar;
        }

        public int h() {
            return this.f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s8$c.class */
    public static class c extends s8 {
        public Object f;

        public c(float f, Object obj) {
            this.b = f;
            this.f = obj;
            boolean z = obj != null;
            this.e = z;
            this.f24308c = z ? obj.getClass() : Object.class;
        }

        @Override // com.tencent.mapsdk.internal.s8
        public void a(Object obj) {
            this.f = obj;
            this.e = obj != null;
        }

        @Override // com.tencent.mapsdk.internal.s8
        public Object e() {
            return this.f;
        }

        @Override // com.tencent.mapsdk.internal.s8
        /* renamed from: g */
        public c clone() {
            c cVar = new c(b(), this.f);
            cVar.a(c());
            return cVar;
        }
    }

    public static s8 a(float f) {
        return new a(f);
    }

    public static s8 a(float f, double d) {
        return new a(f, d);
    }

    public static s8 a(float f, int i) {
        return new b(f, i);
    }

    public static s8 a(float f, Object obj) {
        return new c(f, obj);
    }

    public static s8 b(float f) {
        return new b(f);
    }

    public static s8 c(float f) {
        return new c(f, null);
    }

    @Override // 
    /* renamed from: a */
    public abstract s8 clone();

    public void a(Interpolator interpolator) {
        this.d = interpolator;
    }

    public abstract void a(Object obj);

    public float b() {
        return this.b;
    }

    public Interpolator c() {
        return this.d;
    }

    public Class d() {
        return this.f24308c;
    }

    public void d(float f) {
        this.b = f;
    }

    public abstract Object e();

    public boolean f() {
        return this.e;
    }
}
