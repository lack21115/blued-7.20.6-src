package io.grpc.stub;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCallStreamObserver.class */
public abstract class ServerCallStreamObserver<V> extends CallStreamObserver<V> {
    public void disableAutoRequest() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isCancelled();

    public abstract void setCompression(String str);

    public abstract void setOnCancelHandler(Runnable runnable);
}
