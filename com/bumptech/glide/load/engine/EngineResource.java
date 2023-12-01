package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineResource.class */
class EngineResource<Z> implements Resource<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f7176a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Resource<Z> f7177c;
    private final ResourceListener d;
    private final Key e;
    private int f;
    private boolean g;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineResource$ResourceListener.class */
    interface ResourceListener {
        void a(Key key, EngineResource<?> engineResource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource(Resource<Z> resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        this.f7177c = (Resource) Preconditions.a(resource);
        this.f7176a = z;
        this.b = z2;
        this.e = key;
        this.d = (ResourceListener) Preconditions.a(resourceListener);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> a() {
        return this.f7177c.a();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f7177c.b();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        synchronized (this) {
            if (this.f > 0) {
                throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
            }
            if (this.g) {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
            this.g = true;
            if (this.b) {
                this.f7177c.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource<Z> d() {
        return this.f7177c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f7176a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z f() {
        return this.f7177c.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Cannot acquire a recycled resource");
            }
            this.f++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        boolean z;
        synchronized (this) {
            if (this.f <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i = this.f - 1;
            this.f = i;
            if (i != 0) {
                z = false;
            }
        }
        if (z) {
            this.d.a(this.e, this);
        }
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = "EngineResource{isMemoryCacheable=" + this.f7176a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.f7177c + '}';
        }
        return str;
    }
}
