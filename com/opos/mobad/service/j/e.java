package com.opos.mobad.service.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/e.class */
public class e implements c<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private int f13703a = 0;

    @Override // com.opos.mobad.service.j.c
    public void a() {
        this.f13703a = 0;
    }

    @Override // com.opos.mobad.service.j.c
    public void a(Integer num) {
        this.f13703a += num.intValue();
    }

    public int b() {
        return this.f13703a;
    }
}
