package com.opos.mobad.f.a.a;

import java.util.HashMap;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/p.class */
public class p<P> implements com.opos.mobad.ad.c.a<P> {

    /* renamed from: a  reason: collision with root package name */
    private final int f12360a;
    private final n b;

    public p(int i, n nVar) {
        this.f12360a = i;
        this.b = nVar;
    }

    @Override // com.opos.mobad.ad.c.a
    public void a(int i, String str) {
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdFailed adChannel:" + this.f12360a + ", code:" + i + ", msg:" + str);
        this.b.a(this.f12360a, i, str);
    }

    @Override // com.opos.mobad.ad.c.a
    public void a(List<P> list) {
        HashMap<Integer, List<P>> hashMap;
        n nVar = this.b;
        if (nVar instanceof q) {
            hashMap = ((q) nVar).f12361a;
        } else if (!(nVar instanceof r)) {
            com.opos.cmn.an.f.a.a("delegator", "delegator instance error");
            com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f12360a);
            this.b.d(this.f12360a);
        } else {
            hashMap = ((r) nVar).f12362a;
        }
        hashMap.put(Integer.valueOf(this.f12360a), list);
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f12360a);
        this.b.d(this.f12360a);
    }
}
