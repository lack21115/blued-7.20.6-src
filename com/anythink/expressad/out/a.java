package com.anythink.expressad.out;

import android.content.Context;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/out/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, Object> f8066a;
    protected Context b;

    public a() {
    }

    private a(Map<String, Object> map, Context context) {
        this.f8066a = map;
        this.b = context;
    }

    public abstract boolean a();

    public abstract void b();
}
