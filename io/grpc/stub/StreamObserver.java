package io.grpc.stub;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/StreamObserver.class */
public interface StreamObserver<V> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(V v);
}
