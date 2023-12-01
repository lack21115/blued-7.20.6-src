package com.blued.im.private_chat;

import com.blued.im.private_chat.ReceiptOuterClass;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Descriptors;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.ProtoFileDescriptorSupplier;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import io.grpc.protobuf.ProtoServiceDescriptorSupplier;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc.class */
public final class ReceiptGrpc {
    private static final int METHODID_DEL_ALL = 3;
    private static final int METHODID_DEL_MSG = 5;
    private static final int METHODID_DEL_SESSION = 4;
    private static final int METHODID_GOT = 0;
    private static final int METHODID_READ = 1;
    private static final int METHODID_RETRACT = 2;
    public static final String SERVICE_NAME = "com.blued.im.private_chat.Receipt";
    private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelAllMethod;
    private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelMsgMethod;
    private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelSessionMethod;
    private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getGotMethod;
    private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getReadMethod;
    private static volatile MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getRetractMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final ReceiptImplBase serviceImpl;

        MethodHandlers(ReceiptImplBase receiptImplBase, int i) {
            this.serviceImpl = receiptImplBase;
            this.methodId = i;
        }

        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                this.serviceImpl.got((ReceiptOuterClass.ReceiptRequest) req, streamObserver);
            } else if (i == 1) {
                this.serviceImpl.read((ReceiptOuterClass.ReceiptRequest) req, streamObserver);
            } else if (i == 2) {
                this.serviceImpl.retract((ReceiptOuterClass.ReceiptRequest) req, streamObserver);
            } else if (i == 3) {
                this.serviceImpl.delAll((ReceiptOuterClass.ReceiptRequest) req, streamObserver);
            } else if (i == 4) {
                this.serviceImpl.delSession((ReceiptOuterClass.ReceiptRequest) req, streamObserver);
            } else if (i != 5) {
                throw new AssertionError();
            } else {
                this.serviceImpl.delMsg((ReceiptOuterClass.ReceiptRequest) req, streamObserver);
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptBaseDescriptorSupplier.class */
    static abstract class ReceiptBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ReceiptBaseDescriptorSupplier() {
        }

        public Descriptors.FileDescriptor getFileDescriptor() {
            return ReceiptOuterClass.getDescriptor();
        }

        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Receipt");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptBlockingStub.class */
    public static final class ReceiptBlockingStub extends AbstractBlockingStub<ReceiptBlockingStub> {
        private ReceiptBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReceiptBlockingStub m2502build(Channel channel, CallOptions callOptions) {
            return new ReceiptBlockingStub(channel, callOptions);
        }

        public ReceiptOuterClass.ReceiptResponse delAll(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return (ReceiptOuterClass.ReceiptResponse) ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getDelAllMethod(), getCallOptions(), receiptRequest);
        }

        public ReceiptOuterClass.ReceiptResponse delMsg(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return (ReceiptOuterClass.ReceiptResponse) ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getDelMsgMethod(), getCallOptions(), receiptRequest);
        }

        public ReceiptOuterClass.ReceiptResponse delSession(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return (ReceiptOuterClass.ReceiptResponse) ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getDelSessionMethod(), getCallOptions(), receiptRequest);
        }

        public ReceiptOuterClass.ReceiptResponse got(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return (ReceiptOuterClass.ReceiptResponse) ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getGotMethod(), getCallOptions(), receiptRequest);
        }

        public ReceiptOuterClass.ReceiptResponse read(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return (ReceiptOuterClass.ReceiptResponse) ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getReadMethod(), getCallOptions(), receiptRequest);
        }

        public ReceiptOuterClass.ReceiptResponse retract(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return (ReceiptOuterClass.ReceiptResponse) ClientCalls.blockingUnaryCall(getChannel(), ReceiptGrpc.getRetractMethod(), getCallOptions(), receiptRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptFileDescriptorSupplier.class */
    public static final class ReceiptFileDescriptorSupplier extends ReceiptBaseDescriptorSupplier {
        ReceiptFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptFutureStub.class */
    public static final class ReceiptFutureStub extends AbstractFutureStub<ReceiptFutureStub> {
        private ReceiptFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReceiptFutureStub m2503build(Channel channel, CallOptions callOptions) {
            return new ReceiptFutureStub(channel, callOptions);
        }

        public ListenableFuture<ReceiptOuterClass.ReceiptResponse> delAll(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getDelAllMethod(), getCallOptions()), receiptRequest);
        }

        public ListenableFuture<ReceiptOuterClass.ReceiptResponse> delMsg(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getDelMsgMethod(), getCallOptions()), receiptRequest);
        }

        public ListenableFuture<ReceiptOuterClass.ReceiptResponse> delSession(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getDelSessionMethod(), getCallOptions()), receiptRequest);
        }

        public ListenableFuture<ReceiptOuterClass.ReceiptResponse> got(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getGotMethod(), getCallOptions()), receiptRequest);
        }

        public ListenableFuture<ReceiptOuterClass.ReceiptResponse> read(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getReadMethod(), getCallOptions()), receiptRequest);
        }

        public ListenableFuture<ReceiptOuterClass.ReceiptResponse> retract(ReceiptOuterClass.ReceiptRequest receiptRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReceiptGrpc.getRetractMethod(), getCallOptions()), receiptRequest);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptImplBase.class */
    public static abstract class ReceiptImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ReceiptGrpc.getServiceDescriptor()).addMethod(ReceiptGrpc.getGotMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(ReceiptGrpc.getReadMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).addMethod(ReceiptGrpc.getRetractMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 2))).addMethod(ReceiptGrpc.getDelAllMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 3))).addMethod(ReceiptGrpc.getDelSessionMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 4))).addMethod(ReceiptGrpc.getDelMsgMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 5))).build();
        }

        public void delAll(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getDelAllMethod(), streamObserver);
        }

        public void delMsg(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getDelMsgMethod(), streamObserver);
        }

        public void delSession(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getDelSessionMethod(), streamObserver);
        }

        public void got(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getGotMethod(), streamObserver);
        }

        public void read(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getReadMethod(), streamObserver);
        }

        public void retract(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReceiptGrpc.getRetractMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptMethodDescriptorSupplier.class */
    public static final class ReceiptMethodDescriptorSupplier extends ReceiptBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        ReceiptMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptGrpc$ReceiptStub.class */
    public static final class ReceiptStub extends AbstractAsyncStub<ReceiptStub> {
        private ReceiptStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReceiptStub m2504build(Channel channel, CallOptions callOptions) {
            return new ReceiptStub(channel, callOptions);
        }

        public void delAll(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getDelAllMethod(), getCallOptions()), receiptRequest, streamObserver);
        }

        public void delMsg(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getDelMsgMethod(), getCallOptions()), receiptRequest, streamObserver);
        }

        public void delSession(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getDelSessionMethod(), getCallOptions()), receiptRequest, streamObserver);
        }

        public void got(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getGotMethod(), getCallOptions()), receiptRequest, streamObserver);
        }

        public void read(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getReadMethod(), getCallOptions()), receiptRequest, streamObserver);
        }

        public void retract(ReceiptOuterClass.ReceiptRequest receiptRequest, StreamObserver<ReceiptOuterClass.ReceiptResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReceiptGrpc.getRetractMethod(), getCallOptions()), receiptRequest, streamObserver);
        }
    }

    private ReceiptGrpc() {
    }

    public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelAllMethod() {
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor;
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor2 = getDelAllMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor3 = getDelAllMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DelAll")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptResponse.getDefaultInstance())).setSchemaDescriptor(new ReceiptMethodDescriptorSupplier("DelAll")).build();
                        getDelAllMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelMsgMethod() {
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor;
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor2 = getDelMsgMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor3 = getDelMsgMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DelMsg")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptResponse.getDefaultInstance())).setSchemaDescriptor(new ReceiptMethodDescriptorSupplier("DelMsg")).build();
                        getDelMsgMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getDelSessionMethod() {
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor;
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor2 = getDelSessionMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor3 = getDelSessionMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DelSession")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptResponse.getDefaultInstance())).setSchemaDescriptor(new ReceiptMethodDescriptorSupplier("DelSession")).build();
                        getDelSessionMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getGotMethod() {
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor;
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor2 = getGotMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor3 = getGotMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Got")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptResponse.getDefaultInstance())).setSchemaDescriptor(new ReceiptMethodDescriptorSupplier("Got")).build();
                        getGotMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getReadMethod() {
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor;
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor2 = getReadMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor3 = getReadMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Read")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptResponse.getDefaultInstance())).setSchemaDescriptor(new ReceiptMethodDescriptorSupplier("Read")).build();
                        getReadMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> getRetractMethod() {
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor;
        MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor2 = getRetractMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    MethodDescriptor<ReceiptOuterClass.ReceiptRequest, ReceiptOuterClass.ReceiptResponse> methodDescriptor3 = getRetractMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Retract")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReceiptOuterClass.ReceiptResponse.getDefaultInstance())).setSchemaDescriptor(new ReceiptMethodDescriptorSupplier("Retract")).build();
                        getRetractMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2;
        ServiceDescriptor serviceDescriptor3 = serviceDescriptor;
        if (serviceDescriptor3 == null) {
            synchronized (ReceiptGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new ReceiptFileDescriptorSupplier()).addMethod(getGotMethod()).addMethod(getReadMethod()).addMethod(getRetractMethod()).addMethod(getDelAllMethod()).addMethod(getDelSessionMethod()).addMethod(getDelMsgMethod()).build();
                        serviceDescriptor = serviceDescriptor2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return serviceDescriptor2;
        }
        return serviceDescriptor3;
    }

    public static ReceiptBlockingStub newBlockingStub(Channel channel) {
        return ReceiptBlockingStub.newStub(new AbstractStub.StubFactory<ReceiptBlockingStub>() { // from class: com.blued.im.private_chat.ReceiptGrpc.2
            /* renamed from: newStub */
            public ReceiptBlockingStub m2500newStub(Channel channel2, CallOptions callOptions) {
                return new ReceiptBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReceiptFutureStub newFutureStub(Channel channel) {
        return ReceiptFutureStub.newStub(new AbstractStub.StubFactory<ReceiptFutureStub>() { // from class: com.blued.im.private_chat.ReceiptGrpc.3
            /* renamed from: newStub */
            public ReceiptFutureStub m2501newStub(Channel channel2, CallOptions callOptions) {
                return new ReceiptFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReceiptStub newStub(Channel channel) {
        return ReceiptStub.newStub(new AbstractStub.StubFactory<ReceiptStub>() { // from class: com.blued.im.private_chat.ReceiptGrpc.1
            /* renamed from: newStub */
            public ReceiptStub m2499newStub(Channel channel2, CallOptions callOptions) {
                return new ReceiptStub(channel2, callOptions);
            }
        }, channel);
    }
}
