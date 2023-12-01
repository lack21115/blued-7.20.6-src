package com.opos.mobad.model.b;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b/f.class */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, com.opos.mobad.i.a> f26396a;

    public ConcurrentHashMap<String, com.opos.mobad.i.a> a() {
        return this.f26396a;
    }

    public void a(ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMap) {
        this.f26396a = concurrentHashMap;
    }

    public String toString() {
        return "FetchMaterialRequest{downloadRequestMap=" + this.f26396a + '}';
    }
}
