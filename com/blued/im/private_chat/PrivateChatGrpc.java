package com.blued.im.private_chat;

import com.blued.im.private_chat.PrivateChatOuterClass;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc.class */
public final class PrivateChatGrpc {
    private static final int METHODID_SEND = 0;
    public static final String SERVICE_NAME = "com.blued.im.private_chat.PrivateChat";
    private static volatile MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> getSendMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final PrivateChatImplBase serviceImpl;

        MethodHandlers(PrivateChatImplBase privateChatImplBase, int i) {
            this.serviceImpl = privateChatImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.BidiStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.ClientStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ServerStreamingMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.UnaryMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.send((PrivateChatOuterClass.Request) req, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatBaseDescriptorSupplier.class */
    static abstract class PrivateChatBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        PrivateChatBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return PrivateChatOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("PrivateChat");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatBlockingStub.class */
    public static final class PrivateChatBlockingStub extends AbstractBlockingStub<PrivateChatBlockingStub> {
        private PrivateChatBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public PrivateChatBlockingStub build(Channel channel, CallOptions callOptions) {
            return new PrivateChatBlockingStub(channel, callOptions);
        }

        public PrivateChatOuterClass.Response send(PrivateChatOuterClass.Request request) {
            return (PrivateChatOuterClass.Response) ClientCalls.blockingUnaryCall(getChannel(), PrivateChatGrpc.getSendMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatFileDescriptorSupplier.class */
    public static final class PrivateChatFileDescriptorSupplier extends PrivateChatBaseDescriptorSupplier {
        PrivateChatFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatFutureStub.class */
    public static final class PrivateChatFutureStub extends AbstractFutureStub<PrivateChatFutureStub> {
        private PrivateChatFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public PrivateChatFutureStub build(Channel channel, CallOptions callOptions) {
            return new PrivateChatFutureStub(channel, callOptions);
        }

        public ListenableFuture<PrivateChatOuterClass.Response> send(PrivateChatOuterClass.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(PrivateChatGrpc.getSendMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatImplBase.class */
    public static abstract class PrivateChatImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(PrivateChatGrpc.getServiceDescriptor()).addMethod(PrivateChatGrpc.getSendMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void send(PrivateChatOuterClass.Request request, StreamObserver<PrivateChatOuterClass.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(PrivateChatGrpc.getSendMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatMethodDescriptorSupplier.class */
    public static final class PrivateChatMethodDescriptorSupplier extends PrivateChatBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        PrivateChatMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatGrpc$PrivateChatStub.class */
    public static final class PrivateChatStub extends AbstractAsyncStub<PrivateChatStub> {
        private PrivateChatStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public PrivateChatStub build(Channel channel, CallOptions callOptions) {
            return new PrivateChatStub(channel, callOptions);
        }

        public void send(PrivateChatOuterClass.Request request, StreamObserver<PrivateChatOuterClass.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(PrivateChatGrpc.getSendMethod(), getCallOptions()), request, streamObserver);
        }
    }

    private PrivateChatGrpc() {
    }

    public static MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> getSendMethod() {
        MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> methodDescriptor;
        MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> methodDescriptor2 = getSendMethod;
        if (methodDescriptor2 == null) {
            synchronized (PrivateChatGrpc.class) {
                try {
                    MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> methodDescriptor3 = getSendMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Send")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(PrivateChatOuterClass.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(PrivateChatOuterClass.Response.getDefaultInstance())).setSchemaDescriptor(new PrivateChatMethodDescriptorSupplier("Send")).build();
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
            synchronized (PrivateChatGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new PrivateChatFileDescriptorSupplier()).addMethod(getSendMethod()).build();
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

    public static PrivateChatBlockingStub newBlockingStub(Channel channel) {
        return (PrivateChatBlockingStub) PrivateChatBlockingStub.newStub(new AbstractStub.StubFactory<PrivateChatBlockingStub>() { // from class: com.blued.im.private_chat.PrivateChatGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public PrivateChatBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new PrivateChatBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static PrivateChatFutureStub newFutureStub(Channel channel) {
        return (PrivateChatFutureStub) PrivateChatFutureStub.newStub(new AbstractStub.StubFactory<PrivateChatFutureStub>() { // from class: com.blued.im.private_chat.PrivateChatGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public PrivateChatFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new PrivateChatFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static PrivateChatStub newStub(Channel channel) {
        return (PrivateChatStub) PrivateChatStub.newStub(new AbstractStub.StubFactory<PrivateChatStub>() { // from class: com.blued.im.private_chat.PrivateChatGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public PrivateChatStub newStub(Channel channel2, CallOptions callOptions) {
                return new PrivateChatStub(channel2, callOptions);
            }
        }, channel);
    }
}
