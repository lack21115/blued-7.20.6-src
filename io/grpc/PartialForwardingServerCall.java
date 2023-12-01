package io.grpc;

import com.google.common.base.MoreObjects;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/PartialForwardingServerCall.class */
abstract class PartialForwardingServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        delegate().close(status, metadata);
    }

    protected abstract ServerCall<?, ?> delegate();

    @Override // io.grpc.ServerCall
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return delegate().getAuthority();
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ServerCall
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        delegate().sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String str) {
        delegate().setCompression(str);
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
