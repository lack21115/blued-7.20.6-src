package io.grpc;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/InternalCallOptions.class */
public final class InternalCallOptions {
    private InternalCallOptions() {
    }

    public static Boolean getWaitForReady(CallOptions callOptions) {
        return callOptions.getWaitForReady();
    }
}
