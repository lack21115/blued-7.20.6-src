package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/b.class */
public class b implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private n f26021a;
    private int b;

    public b(int i, n nVar) {
        this.b = i;
        this.f26021a = nVar;
    }

    @Override // com.opos.mobad.ad.b.a
    public void a() {
        this.f26021a.d(this.b);
    }

    @Override // com.opos.mobad.ad.b.a
    public void a(int i, String str) {
        com.opos.cmn.an.f.a.b("AdDelegateListener", "onChannelFailed =" + this.b + ",code=" + i + ",msg=" + str);
        this.f26021a.a(this.b, i, str);
    }

    @Override // com.opos.mobad.ad.b.a
    public void b() {
        this.f26021a.e(this.b);
    }
}
