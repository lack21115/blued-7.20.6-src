package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerTransportListener.class */
public interface ServerTransportListener {
    void streamCreated(ServerStream serverStream, String str, Metadata metadata);

    Attributes transportReady(Attributes attributes);

    void transportTerminated();
}
