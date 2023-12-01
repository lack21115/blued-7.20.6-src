package com.opos.mobad.service.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/g.class */
public class g<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private d<T> f13705a;
    private boolean b = false;

    public g(d<T> dVar) {
        this.f13705a = dVar;
    }

    @Override // com.opos.mobad.service.j.d
    public boolean a(T t) {
        if (this.b) {
            return false;
        }
        boolean a2 = this.f13705a.a(t);
        this.b = a2;
        return a2;
    }
}
