package io.grpc;

import java.util.concurrent.Executor;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/CallCredentials.class */
public abstract class CallCredentials {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/CallCredentials$MetadataApplier.class */
    public static abstract class MetadataApplier {
        public abstract void apply(Metadata metadata);

        public abstract void fail(Status status);
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/CallCredentials$RequestInfo.class */
    public static abstract class RequestInfo {
        public abstract String getAuthority();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();

        public abstract SecurityLevel getSecurityLevel();

        public abstract Attributes getTransportAttrs();
    }

    public abstract void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);

    public abstract void thisUsesUnstableApi();
}
