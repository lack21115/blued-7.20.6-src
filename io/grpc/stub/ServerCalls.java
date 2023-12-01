package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls.class */
public final class ServerCalls {
    static final String MISSING_REQUEST = "Half-closed without a request";
    static final String TOO_MANY_REQUESTS = "Too many requests";

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$BidiStreamingMethod.class */
    public interface BidiStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.ClientStreamingMethod
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$ClientStreamingMethod.class */
    public interface ClientStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
        @Override // 
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$NoopStreamObserver.class */
    static class NoopStreamObserver<V> implements StreamObserver<V> {
        NoopStreamObserver() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(V v) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$ServerCallStreamObserverImpl.class */
    public static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT> {
        final ServerCall<ReqT, RespT> call;
        volatile boolean cancelled;
        private boolean frozen;
        private Runnable onCancelHandler;
        private Runnable onReadyHandler;
        private boolean sentHeaders;
        private boolean autoRequestEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> serverCall) {
            this.call = serverCall;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        @Deprecated
        public void disableAutoInboundFlowControl() {
            disableAutoRequest();
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void disableAutoRequest() {
            Preconditions.checkState(!this.frozen, "Cannot disable auto flow control after initialization");
            this.autoRequestEnabled = false;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public boolean isCancelled() {
            return this.call.isCancelled();
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            if (this.cancelled) {
                if (this.onCancelHandler == null) {
                    throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
                }
                return;
            }
            this.call.close(Status.OK, new Metadata());
            this.completed = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            Metadata trailersFromThrowable = Status.trailersFromThrowable(th);
            Metadata metadata = trailersFromThrowable;
            if (trailersFromThrowable == null) {
                metadata = new Metadata();
            }
            this.call.close(Status.fromThrowable(th), metadata);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(RespT respt) {
            if (this.cancelled) {
                if (this.onCancelHandler == null) {
                    throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
                }
                return;
            }
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            if (!this.sentHeaders) {
                this.call.sendHeaders(new Metadata());
                this.sentHeaders = true;
            }
            this.call.sendMessage(respt);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int i) {
            this.call.request(i);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setCompression(String str) {
            this.call.setCompression(str);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z) {
            this.call.setMessageCompression(z);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setOnCancelHandler(Runnable runnable) {
            Preconditions.checkState(!this.frozen, "Cannot alter onCancelHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onCancelHandler = runnable;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            Preconditions.checkState(!this.frozen, "Cannot alter onReadyHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onReadyHandler = runnable;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$ServerStreamingMethod.class */
    public interface ServerStreamingMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.UnaryMethod
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$StreamingRequestMethod.class */
    interface StreamingRequestMethod<ReqT, RespT> {
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$StreamingServerCallHandler.class */
    static final class StreamingServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final StreamingRequestMethod<ReqT, RespT> method;

        /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$StreamingServerCallHandler$StreamingServerCallListener.class */
        final class StreamingServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean halfClosed = false;
            private final StreamObserver<ReqT> requestObserver;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;

            StreamingServerCallListener(StreamObserver<ReqT> streamObserver, ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl, ServerCall<ReqT, RespT> serverCall) {
                this.requestObserver = streamObserver;
                this.responseObserver = serverCallStreamObserverImpl;
                this.call = serverCall;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                this.responseObserver.cancelled = true;
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                }
                if (this.halfClosed) {
                    return;
                }
                this.requestObserver.onError(Status.CANCELLED.withDescription("cancelled before receiving half close").asRuntimeException());
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                this.halfClosed = true;
                this.requestObserver.onCompleted();
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                this.requestObserver.onNext(reqt);
                if (((ServerCallStreamObserverImpl) this.responseObserver).autoRequestEnabled) {
                    this.call.request(1);
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
                }
            }
        }

        StreamingServerCallHandler(StreamingRequestMethod<ReqT, RespT> streamingRequestMethod) {
            this.method = streamingRequestMethod;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall);
            StreamObserver<ReqT> invoke = this.method.invoke(serverCallStreamObserverImpl);
            serverCallStreamObserverImpl.freeze();
            if (serverCallStreamObserverImpl.autoRequestEnabled) {
                serverCall.request(1);
            }
            return new StreamingServerCallListener(invoke, serverCallStreamObserverImpl, serverCall);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$UnaryMethod.class */
    public interface UnaryMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
        @Override // 
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$UnaryRequestMethod.class */
    public interface UnaryRequestMethod<ReqT, RespT> {
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$UnaryServerCallHandler.class */
    public static final class UnaryServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final UnaryRequestMethod<ReqT, RespT> method;

        /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/ServerCalls$UnaryServerCallHandler$UnaryServerCallListener.class */
        final class UnaryServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean canInvoke = true;
            private ReqT request;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
            private boolean wasReady;

            UnaryServerCallListener(ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl, ServerCall<ReqT, RespT> serverCall) {
                this.call = serverCall;
                this.responseObserver = serverCallStreamObserverImpl;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                this.responseObserver.cancelled = true;
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                if (this.canInvoke) {
                    if (this.request == null) {
                        this.call.close(Status.INTERNAL.withDescription(ServerCalls.MISSING_REQUEST), new Metadata());
                        return;
                    }
                    UnaryServerCallHandler.this.method.invoke(this.request, this.responseObserver);
                    this.request = null;
                    this.responseObserver.freeze();
                    if (this.wasReady) {
                        onReady();
                    }
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                if (this.request == null) {
                    this.request = reqt;
                    return;
                }
                this.call.close(Status.INTERNAL.withDescription(ServerCalls.TOO_MANY_REQUESTS), new Metadata());
                this.canInvoke = false;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                this.wasReady = true;
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
                }
            }
        }

        UnaryServerCallHandler(UnaryRequestMethod<ReqT, RespT> unaryRequestMethod) {
            this.method = unaryRequestMethod;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            Preconditions.checkArgument(serverCall.getMethodDescriptor().getType().clientSendsOneMessage(), "asyncUnaryRequestCall is only for clientSendsOneMessage methods");
            ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall);
            serverCall.request(2);
            return new UnaryServerCallListener(serverCallStreamObserverImpl, serverCall);
        }
    }

    private ServerCalls() {
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> bidiStreamingMethod) {
        return new StreamingServerCallHandler(bidiStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> clientStreamingMethod) {
        return new StreamingServerCallHandler(clientStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> serverStreamingMethod) {
        return new UnaryServerCallHandler(serverStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> unaryMethod) {
        return new UnaryServerCallHandler(unaryMethod);
    }

    public static <T> StreamObserver<T> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        asyncUnimplementedUnaryCall(methodDescriptor, streamObserver);
        return new NoopStreamObserver();
    }

    public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        Preconditions.checkNotNull(methodDescriptor, "methodDescriptor");
        Preconditions.checkNotNull(streamObserver, "responseObserver");
        streamObserver.onError(Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", methodDescriptor.getFullMethodName())).asRuntimeException());
    }
}
