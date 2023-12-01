package io.grpc.internal;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerListener.class */
public interface ServerListener {
    void serverShutdown();

    ServerTransportListener transportCreated(ServerTransport serverTransport);
}
