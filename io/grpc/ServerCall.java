package io.grpc;

import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerCall.class */
public abstract class ServerCall<ReqT, RespT> {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerCall$Listener.class */
    public static abstract class Listener<ReqT> {
        public void onCancel() {
        }

        public void onComplete() {
        }

        public void onHalfClose() {
        }

        public void onMessage(ReqT reqt) {
        }

        public void onReady() {
        }
    }

    public abstract void close(Status status, Metadata metadata);

    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @Nullable
    public String getAuthority() {
        return null;
    }

    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();

    public abstract boolean isCancelled();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i);

    public abstract void sendHeaders(Metadata metadata);

    public abstract void sendMessage(RespT respt);

    public void setCompression(String str) {
    }

    public void setMessageCompression(boolean z) {
    }
}
