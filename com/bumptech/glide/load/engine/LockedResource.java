package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/LockedResource.class */
public final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.Pool<LockedResource<?>> f7184a = FactoryPools.a(20, new FactoryPools.Factory<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.LockedResource.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: a */
        public LockedResource<?> b() {
            return new LockedResource<>();
        }
    });
    private final StateVerifier b = StateVerifier.a();

    /* renamed from: c  reason: collision with root package name */
    private Resource<Z> f7185c;
    private boolean d;
    private boolean e;

    LockedResource() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Z> LockedResource<Z> a(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.a(f7184a.acquire());
        lockedResource.b(resource);
        return lockedResource;
    }

    private void b(Resource<Z> resource) {
        this.e = false;
        this.d = true;
        this.f7185c = resource;
    }

    private void g() {
        this.f7185c = null;
        f7184a.release(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> a() {
        return this.f7185c.a();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f7185c.b();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        synchronized (this) {
            this.b.b();
            this.e = true;
            if (!this.d) {
                this.f7185c.c();
                g();
            }
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        synchronized (this) {
            this.b.b();
            if (!this.d) {
                throw new IllegalStateException("Already unlocked");
            }
            this.d = false;
            if (this.e) {
                c();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z f() {
        return this.f7185c.f();
    }
}
