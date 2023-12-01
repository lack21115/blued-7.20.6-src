package com.opos.mobad.f.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/v.class */
public class v extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f26057a;

    public v(String str, int i, long j) {
        super(str, j);
        this.f26057a = 3 == i ? "sdk_bidding" : "sdk_dsp";
    }

    @Override // com.opos.mobad.f.a.a.a
    protected void a(String str, long j, String str2, int i, long j2, String str3) {
        com.opos.mobad.service.i.d.a().a(str, str2, i, j2, str3, this.f26057a, j);
    }

    @Override // com.opos.mobad.f.a.a.a
    protected void b(String str, long j, String str2, int i, long j2, String str3) {
        com.opos.mobad.service.i.d.a().b(str, str2, i, j2, str3, this.f26057a, j);
    }
}
