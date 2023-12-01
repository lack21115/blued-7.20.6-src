package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.cp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cp.class */
public final class cp {
    private a a;
    private b b;
    private b c;

    /* renamed from: com.amap.api.col.3sl.cp$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cp$a.class */
    public static final class a extends co {
    }

    /* renamed from: com.amap.api.col.3sl.cp$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cp$b.class */
    public static final class b extends co {
    }

    public final void a() {
        synchronized (this) {
            if (this.a != null) {
                this.a.a();
                this.a = null;
            }
            if (this.b != null) {
                this.b.a();
                this.b = null;
            }
            if (this.c != null) {
                this.c.a();
                this.c = null;
            }
        }
    }
}
