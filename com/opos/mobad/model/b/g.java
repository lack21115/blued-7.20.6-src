package com.opos.mobad.model.b;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/g.class */
public class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, com.opos.mobad.i.b> f12709a = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, com.opos.mobad.i.b> a() {
        return this.f12709a;
    }

    public void a(String str, com.opos.mobad.i.b bVar) {
        this.f12709a.put(str, bVar);
    }

    public String toString() {
        return "FetchMaterialResponse{downloadResponseMap=" + this.f12709a + '}';
    }
}
