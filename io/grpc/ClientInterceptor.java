package io.grpc;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientInterceptor.class */
public interface ClientInterceptor {
    <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel);
}
