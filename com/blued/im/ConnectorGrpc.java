package com.blued.im;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Any;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc.class */
public final class ConnectorGrpc {
    private static final int METHODID_CONNECT = 2;
    private static final int METHODID_KICK = 1;
    private static final int METHODID_SEND = 0;
    public static final String SERVICE_NAME = "com.blued.im.Connector";
    private static volatile MethodDescriptor<Any, Any> getConnectMethod;
    private static volatile MethodDescriptor<Any, Any> getKickMethod;
    private static volatile MethodDescriptor<Any, Any> getSendMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorBaseDescriptorSupplier.class */
    static abstract class ConnectorBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ConnectorBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return ConnectorOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Connector");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorBlockingStub.class */
    public static final class ConnectorBlockingStub extends AbstractBlockingStub<ConnectorBlockingStub> {
        private ConnectorBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ConnectorBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ConnectorBlockingStub(channel, callOptions);
        }

        public Any kick(Any any) {
            return (Any) ClientCalls.blockingUnaryCall(getChannel(), ConnectorGrpc.getKickMethod(), getCallOptions(), any);
        }

        public Any send(Any any) {
            return (Any) ClientCalls.blockingUnaryCall(getChannel(), ConnectorGrpc.getSendMethod(), getCallOptions(), any);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorFileDescriptorSupplier.class */
    public static final class ConnectorFileDescriptorSupplier extends ConnectorBaseDescriptorSupplier {
        ConnectorFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorFutureStub.class */
    public static final class ConnectorFutureStub extends AbstractFutureStub<ConnectorFutureStub> {
        private ConnectorFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ConnectorFutureStub build(Channel channel, CallOptions callOptions) {
            return new ConnectorFutureStub(channel, callOptions);
        }

        public ListenableFuture<Any> kick(Any any) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ConnectorGrpc.getKickMethod(), getCallOptions()), any);
        }

        public ListenableFuture<Any> send(Any any) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ConnectorGrpc.getSendMethod(), getCallOptions()), any);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorImplBase.class */
    public static abstract class ConnectorImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ConnectorGrpc.getServiceDescriptor()).addMethod(ConnectorGrpc.getConnectMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 2))).addMethod(ConnectorGrpc.getSendMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(ConnectorGrpc.getKickMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).build();
        }

        public StreamObserver<Any> connect(StreamObserver<Any> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(ConnectorGrpc.getConnectMethod(), streamObserver);
        }

        public void kick(Any any, StreamObserver<Any> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ConnectorGrpc.getKickMethod(), streamObserver);
        }

        public void send(Any any, StreamObserver<Any> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ConnectorGrpc.getSendMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorMethodDescriptorSupplier.class */
    public static final class ConnectorMethodDescriptorSupplier extends ConnectorBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        ConnectorMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$ConnectorStub.class */
    public static final class ConnectorStub extends AbstractAsyncStub<ConnectorStub> {
        private ConnectorStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ConnectorStub build(Channel channel, CallOptions callOptions) {
            return new ConnectorStub(channel, callOptions);
        }

        public StreamObserver<Any> connect(StreamObserver<Any> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(ConnectorGrpc.getConnectMethod(), getCallOptions()), streamObserver);
        }

        public void kick(Any any, StreamObserver<Any> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ConnectorGrpc.getKickMethod(), getCallOptions()), any, streamObserver);
        }

        public void send(Any any, StreamObserver<Any> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ConnectorGrpc.getSendMethod(), getCallOptions()), any, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/ConnectorGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final ConnectorImplBase serviceImpl;

        MethodHandlers(ConnectorImplBase connectorImplBase, int i) {
            this.serviceImpl = connectorImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.BidiStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.ClientStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            if (this.methodId == 2) {
                return (StreamObserver<Req>) this.serviceImpl.connect(streamObserver);
            }
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ServerStreamingMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.UnaryMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                this.serviceImpl.send((Any) req, streamObserver);
            } else if (i != 1) {
                throw new AssertionError();
            } else {
                this.serviceImpl.kick((Any) req, streamObserver);
            }
        }
    }

    private ConnectorGrpc() {
    }

    public static MethodDescriptor<Any, Any> getConnectMethod() {
        MethodDescriptor<Any, Any> methodDescriptor;
        MethodDescriptor<Any, Any> methodDescriptor2 = getConnectMethod;
        if (methodDescriptor2 == null) {
            synchronized (ConnectorGrpc.class) {
                try {
                    MethodDescriptor<Any, Any> methodDescriptor3 = getConnectMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Connect")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("Connect")).build();
                        getConnectMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<Any, Any> getKickMethod() {
        MethodDescriptor<Any, Any> methodDescriptor;
        MethodDescriptor<Any, Any> methodDescriptor2 = getKickMethod;
        if (methodDescriptor2 == null) {
            synchronized (ConnectorGrpc.class) {
                try {
                    MethodDescriptor<Any, Any> methodDescriptor3 = getKickMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Kick")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("Kick")).build();
                        getKickMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<Any, Any> getSendMethod() {
        MethodDescriptor<Any, Any> methodDescriptor;
        MethodDescriptor<Any, Any> methodDescriptor2 = getSendMethod;
        if (methodDescriptor2 == null) {
            synchronized (ConnectorGrpc.class) {
                try {
                    MethodDescriptor<Any, Any> methodDescriptor3 = getSendMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Send")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setSchemaDescriptor(new ConnectorMethodDescriptorSupplier("Send")).build();
                        getSendMethod = methodDescriptor;
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
            synchronized (ConnectorGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new ConnectorFileDescriptorSupplier()).addMethod(getConnectMethod()).addMethod(getSendMethod()).addMethod(getKickMethod()).build();
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

    public static ConnectorBlockingStub newBlockingStub(Channel channel) {
        return (ConnectorBlockingStub) ConnectorBlockingStub.newStub(new AbstractStub.StubFactory<ConnectorBlockingStub>() { // from class: com.blued.im.ConnectorGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ConnectorBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ConnectorBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ConnectorFutureStub newFutureStub(Channel channel) {
        return (ConnectorFutureStub) ConnectorFutureStub.newStub(new AbstractStub.StubFactory<ConnectorFutureStub>() { // from class: com.blued.im.ConnectorGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ConnectorFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ConnectorFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ConnectorStub newStub(Channel channel) {
        return (ConnectorStub) ConnectorStub.newStub(new AbstractStub.StubFactory<ConnectorStub>() { // from class: com.blued.im.ConnectorGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ConnectorStub newStub(Channel channel2, CallOptions callOptions) {
                return new ConnectorStub(channel2, callOptions);
            }
        }, channel);
    }
}
