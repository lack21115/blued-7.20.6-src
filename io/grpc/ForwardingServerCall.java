package io.grpc;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ForwardingServerCall.class */
public abstract class ForwardingServerCall<ReqT, RespT> extends PartialForwardingServerCall<ReqT, RespT> {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ForwardingServerCall$SimpleForwardingServerCall.class */
    public static abstract class SimpleForwardingServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
        private final ServerCall<ReqT, RespT> delegate;

        public SimpleForwardingServerCall(ServerCall<ReqT, RespT> serverCall) {
            this.delegate = serverCall;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
            super.close(status, metadata);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        protected ServerCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return super.getAttributes();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ String getAuthority() {
            return super.getAuthority();
        }

        @Override // io.grpc.ServerCall
        public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
            return this.delegate.getMethodDescriptor();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ boolean isReady() {
            return super.isReady();
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void request(int i) {
            super.request(i);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
            super.sendHeaders(metadata);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void setCompression(String str) {
            super.setCompression(str);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
            super.setMessageCompression(z);
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
        super.close(status, metadata);
    }

    @Override // io.grpc.PartialForwardingServerCall
    protected abstract ServerCall<ReqT, RespT> delegate();

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ String getAuthority() {
        return super.getAuthority();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void request(int i) {
        super.request(i);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
        super.sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT respt) {
        delegate().sendMessage(respt);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void setCompression(String str) {
        super.setCompression(str);
    }

    @Override // io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
        super.setMessageCompression(z);
    }

    @Override // io.grpc.PartialForwardingServerCall
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
