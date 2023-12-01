package io.grpc.stub;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ClientResponseObserver.class */
public interface ClientResponseObserver<ReqT, RespT> extends StreamObserver<RespT> {
    void beforeStart(ClientCallStreamObserver<ReqT> clientCallStreamObserver);
}
