package io.grpc.util;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.SerializingExecutor;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/util/TransmitStatusRuntimeExceptionInterceptor.class */
public final class TransmitStatusRuntimeExceptionInterceptor implements ServerInterceptor {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/util/TransmitStatusRuntimeExceptionInterceptor$SerializingServerCall.class */
    static class SerializingServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {
        private static final String ERROR_MSG = "Encountered error during serialized access";
        private boolean closeCalled;
        private final SerializingExecutor serializingExecutor;

        SerializingServerCall(ServerCall<ReqT, RespT> serverCall) {
            super(serverCall);
            this.serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
            this.closeCalled = false;
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void close(final Status status, final Metadata metadata) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.4
                @Override // java.lang.Runnable
                public void run() {
                    if (SerializingServerCall.this.closeCalled) {
                        return;
                    }
                    SerializingServerCall.this.closeCalled = true;
                    SerializingServerCall.super.close(status, metadata);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public Attributes getAttributes() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.9
                @Override // java.lang.Runnable
                public void run() {
                    create.set(SerializingServerCall.super.getAttributes());
                }
            });
            try {
                return (Attributes) create.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        @Nullable
        public String getAuthority() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.10
                @Override // java.lang.Runnable
                public void run() {
                    create.set(SerializingServerCall.super.getAuthority());
                }
            });
            try {
                return (String) create.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isCancelled() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.6
                @Override // java.lang.Runnable
                public void run() {
                    create.set(Boolean.valueOf(SerializingServerCall.super.isCancelled()));
                }
            });
            try {
                return ((Boolean) create.get()).booleanValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isReady() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.5
                @Override // java.lang.Runnable
                public void run() {
                    create.set(Boolean.valueOf(SerializingServerCall.super.isReady()));
                }
            });
            try {
                return ((Boolean) create.get()).booleanValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void request(final int i) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.2
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.request(i);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void sendHeaders(final Metadata metadata) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.3
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.sendHeaders(metadata);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.ServerCall
        public void sendMessage(final RespT respt) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.1
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.sendMessage(respt);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void setCompression(final String str) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.8
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.setCompression(str);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void setMessageCompression(final boolean z) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.7
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.setMessageCompression(z);
                }
            });
        }
    }

    private TransmitStatusRuntimeExceptionInterceptor() {
    }

    public static ServerInterceptor instance() {
        return new TransmitStatusRuntimeExceptionInterceptor();
    }

    @Override // io.grpc.ServerInterceptor
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        final SerializingServerCall serializingServerCall = new SerializingServerCall(serverCall);
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(serverCallHandler.startCall(serializingServerCall, metadata)) { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.1
            private void closeWithException(StatusRuntimeException statusRuntimeException) {
                Metadata trailers = statusRuntimeException.getTrailers();
                Metadata metadata2 = trailers;
                if (trailers == null) {
                    metadata2 = new Metadata();
                }
                serializingServerCall.close(statusRuntimeException.getStatus(), metadata2);
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onCancel() {
                try {
                    super.onCancel();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onComplete() {
                try {
                    super.onComplete();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onHalfClose() {
                try {
                    super.onHalfClose();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                try {
                    super.onMessage(reqt);
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onReady() {
                try {
                    super.onReady();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }
        };
    }
}
