package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.n9;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u9.class */
public abstract class u9<D extends n9> implements m9<D>, t9<D> {

    /* renamed from: a  reason: collision with root package name */
    private ReentrantReadWriteLock f38041a = new ReentrantReadWriteLock();

    @Override // com.tencent.mapsdk.internal.t9
    public final boolean a(String str) {
        try {
            this.f38041a.writeLock().lock();
            return remove(str);
        } finally {
            this.f38041a.writeLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.t9
    public final D b(String str, Class<D> cls) {
        try {
            this.f38041a.readLock().lock();
            return a(str, cls);
        } finally {
            this.f38041a.readLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.t9
    public final void b() {
        try {
            this.f38041a.writeLock().lock();
            clear();
        } finally {
            this.f38041a.writeLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.t9
    public final void b(String str, D d) {
        try {
            this.f38041a.writeLock().lock();
            a(str, (String) d);
        } finally {
            this.f38041a.writeLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.t9
    public final long c() {
        try {
            this.f38041a.readLock().lock();
            return getCount();
        } finally {
            this.f38041a.readLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.t9
    public final long e() {
        try {
            this.f38041a.readLock().lock();
            return f();
        } finally {
            this.f38041a.readLock().unlock();
        }
    }

    @Override // com.tencent.mapsdk.internal.t9
    public t9<D> g() {
        return this;
    }
}
