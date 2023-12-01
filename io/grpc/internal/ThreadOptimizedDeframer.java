package io.grpc.internal;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ThreadOptimizedDeframer.class */
public interface ThreadOptimizedDeframer extends Deframer {
    @Override // io.grpc.internal.Deframer
    void request(int i);
}
