package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/q.class */
public class q<T extends com.opos.mobad.ad.b, P> extends h<T> implements o<T, P> {

    /* renamed from: a  reason: collision with root package name */
    final HashMap<Integer, List<P>> f12361a;

    public q(String str, int i, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.c<T> cVar, b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, cVar, aVar3);
        this.f12361a = new HashMap<>();
    }

    @Override // com.opos.mobad.f.a.a.h
    protected boolean g(int i) {
        return this.f12361a.containsKey(Integer.valueOf(i));
    }

    @Override // com.opos.mobad.f.a.a.o
    public List<P> h() {
        return this.f12361a.remove(Integer.valueOf(j()));
    }
}
