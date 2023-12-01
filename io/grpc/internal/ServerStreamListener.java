package io.grpc.internal;

import io.grpc.Status;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerStreamListener.class */
public interface ServerStreamListener extends StreamListener {
    void closed(Status status);

    void halfClosed();
}
