package com.google.common.util.concurrent;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/AsyncCallable.class */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
