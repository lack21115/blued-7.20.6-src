package io.grpc.internal;

import com.google.common.base.Preconditions;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/FixedObjectPool.class */
public final class FixedObjectPool<T> implements ObjectPool<T> {
    private final T object;

    public FixedObjectPool(T t) {
        this.object = (T) Preconditions.checkNotNull(t, "object");
    }

    @Override // io.grpc.internal.ObjectPool
    public T getObject() {
        return this.object;
    }

    @Override // io.grpc.internal.ObjectPool
    public T returnObject(Object obj) {
        return null;
    }
}
