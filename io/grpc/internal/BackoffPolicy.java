package io.grpc.internal;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/BackoffPolicy.class */
public interface BackoffPolicy {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/BackoffPolicy$Provider.class */
    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffNanos();
}
