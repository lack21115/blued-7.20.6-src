package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.cp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cp.class */
public final class cp {

    /* renamed from: a  reason: collision with root package name */
    private a f4815a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private b f4816c;

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
            if (this.f4815a != null) {
                this.f4815a.a();
                this.f4815a = null;
            }
            if (this.b != null) {
                this.b.a();
                this.b = null;
            }
            if (this.f4816c != null) {
                this.f4816c.a();
                this.f4816c = null;
            }
        }
    }
}
