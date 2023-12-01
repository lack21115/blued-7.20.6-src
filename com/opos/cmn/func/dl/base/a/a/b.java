package com.opos.cmn.func.dl.base.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f11193a = new Object();
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private int f11194c;

    public final a a() {
        synchronized (f11193a) {
            if (this.b != null) {
                a aVar = this.b;
                this.b = aVar.f;
                aVar.f = null;
                this.f11194c--;
                return aVar;
            }
            return new a();
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.d = 0L;
        aVar.f11191a = 0;
        aVar.b = 0;
        aVar.f11192c = 0;
        aVar.f = null;
        synchronized (f11193a) {
            if (this.f11194c < 100) {
                aVar.f = this.b;
                this.b = aVar;
                this.f11194c++;
            }
        }
    }
}
