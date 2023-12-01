package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.ad.g;
import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/r.class */
public class r<T extends com.opos.mobad.ad.b, P extends com.opos.mobad.ad.g> extends i<T> implements o<T, P> {

    /* renamed from: a  reason: collision with root package name */
    final HashMap<Integer, List<P>> f26050a;
    final s d;

    public r(String str, int i, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j, int i2, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(str, i, aVar, list, aVar2, j, i2, aVar3, aVar4);
        this.f26050a = new HashMap<>();
        this.d = new s(list);
    }

    @Override // com.opos.mobad.f.a.a.i
    protected boolean f(int i) {
        return this.f26050a.containsKey(Integer.valueOf(i));
    }

    @Override // com.opos.mobad.f.a.a.o
    public List<P> h() {
        return this.f26050a.remove(Integer.valueOf(j()));
    }

    @Override // com.opos.mobad.f.a.a.i
    protected e.a m() {
        return this.d.a(this.f26050a);
    }
}
