package io.grpc;

import io.grpc.ServerCall;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerInterceptor.class */
public interface ServerInterceptor {
    <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler);
}
