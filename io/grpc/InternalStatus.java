package io.grpc;

import io.grpc.Metadata;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/InternalStatus.class */
public final class InternalStatus {
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;

    private InternalStatus() {
    }
}
