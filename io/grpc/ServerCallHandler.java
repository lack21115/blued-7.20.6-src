package io.grpc;

import io.grpc.ServerCall;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerCallHandler.class */
public interface ServerCallHandler<RequestT, ResponseT> {
    ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> serverCall, Metadata metadata);
}
