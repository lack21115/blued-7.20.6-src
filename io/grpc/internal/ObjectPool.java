package io.grpc.internal;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ObjectPool.class */
public interface ObjectPool<T> {
    T getObject();

    T returnObject(Object obj);
}
