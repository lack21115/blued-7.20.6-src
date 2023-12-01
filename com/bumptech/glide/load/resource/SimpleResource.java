package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/SimpleResource.class */
public class SimpleResource<T> implements Resource<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f20934a;

    public SimpleResource(T t) {
        this.f20934a = (T) Preconditions.a(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<T> a() {
        return (Class<T>) this.f20934a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T f() {
        return this.f20934a;
    }
}
