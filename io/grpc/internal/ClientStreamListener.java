package io.grpc.internal;

import io.grpc.Metadata;
import io.grpc.Status;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientStreamListener.class */
public interface ClientStreamListener extends StreamListener {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientStreamListener$RpcProgress.class */
    public enum RpcProgress {
        PROCESSED,
        REFUSED,
        DROPPED
    }

    void closed(Status status, Metadata metadata);

    void closed(Status status, RpcProgress rpcProgress, Metadata metadata);

    void headersRead(Metadata metadata);
}
