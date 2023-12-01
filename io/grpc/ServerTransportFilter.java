package io.grpc;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerTransportFilter.class */
public abstract class ServerTransportFilter {
    public Attributes transportReady(Attributes attributes) {
        return attributes;
    }

    public void transportTerminated(Attributes attributes) {
    }
}
