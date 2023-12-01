package com.opos.mobad.service.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/e.class */
public class e implements c<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private int f27391a = 0;

    @Override // com.opos.mobad.service.j.c
    public void a() {
        this.f27391a = 0;
    }

    @Override // com.opos.mobad.service.j.c
    public void a(Integer num) {
        this.f27391a += num.intValue();
    }

    public int b() {
        return this.f27391a;
    }
}
