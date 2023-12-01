package com.blued.im.private_chat;

import com.blued.im.private_chat.Chat1V1;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc.class */
public final class HermesChat1v1Grpc {
    private static final int METHODID_CHAT1V1SEND = 0;
    public static final String SERVICE_NAME = "com.blued.im.private_chat.HermesChat1v1";
    private static volatile MethodDescriptor<Chat1V1.Chat1v1Request, Chat1V1.Chat1v1Response> getChat1v1SendMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1BaseDescriptorSupplier.class */
    static abstract class HermesChat1v1BaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        HermesChat1v1BaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return Chat1V1.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("HermesChat1v1");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1BlockingStub.class */
    public static final class HermesChat1v1BlockingStub extends AbstractBlockingStub<HermesChat1v1BlockingStub> {
        private HermesChat1v1BlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public HermesChat1v1BlockingStub build(Channel channel, CallOptions callOptions) {
            return new HermesChat1v1BlockingStub(channel, callOptions);
        }

        public Chat1V1.Chat1v1Response chat1v1Send(Chat1V1.Chat1v1Request chat1v1Request) {
            return (Chat1V1.Chat1v1Response) ClientCalls.blockingUnaryCall(getChannel(), HermesChat1v1Grpc.getChat1v1SendMethod(), getCallOptions(), chat1v1Request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1FileDescriptorSupplier.class */
    public static final class HermesChat1v1FileDescriptorSupplier extends HermesChat1v1BaseDescriptorSupplier {
        HermesChat1v1FileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1FutureStub.class */
    public static final class HermesChat1v1FutureStub extends AbstractFutureStub<HermesChat1v1FutureStub> {
        private HermesChat1v1FutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public HermesChat1v1FutureStub build(Channel channel, CallOptions callOptions) {
            return new HermesChat1v1FutureStub(channel, callOptions);
        }

        public ListenableFuture<Chat1V1.Chat1v1Response> chat1v1Send(Chat1V1.Chat1v1Request chat1v1Request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(HermesChat1v1Grpc.getChat1v1SendMethod(), getCallOptions()), chat1v1Request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1ImplBase.class */
    public static abstract class HermesChat1v1ImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(HermesChat1v1Grpc.getServiceDescriptor()).addMethod(HermesChat1v1Grpc.getChat1v1SendMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void chat1v1Send(Chat1V1.Chat1v1Request chat1v1Request, StreamObserver<Chat1V1.Chat1v1Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(HermesChat1v1Grpc.getChat1v1SendMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1MethodDescriptorSupplier.class */
    public static final class HermesChat1v1MethodDescriptorSupplier extends HermesChat1v1BaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        HermesChat1v1MethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$HermesChat1v1Stub.class */
    public static final class HermesChat1v1Stub extends AbstractAsyncStub<HermesChat1v1Stub> {
        private HermesChat1v1Stub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public HermesChat1v1Stub build(Channel channel, CallOptions callOptions) {
            return new HermesChat1v1Stub(channel, callOptions);
        }

        public void chat1v1Send(Chat1V1.Chat1v1Request chat1v1Request, StreamObserver<Chat1V1.Chat1v1Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(HermesChat1v1Grpc.getChat1v1SendMethod(), getCallOptions()), chat1v1Request, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/HermesChat1v1Grpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final HermesChat1v1ImplBase serviceImpl;

        MethodHandlers(HermesChat1v1ImplBase hermesChat1v1ImplBase, int i) {
            this.serviceImpl = hermesChat1v1ImplBase;
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
            this.serviceImpl.chat1v1Send((Chat1V1.Chat1v1Request) req, streamObserver);
        }
    }

    private HermesChat1v1Grpc() {
    }

    public static MethodDescriptor<Chat1V1.Chat1v1Request, Chat1V1.Chat1v1Response> getChat1v1SendMethod() {
        MethodDescriptor<Chat1V1.Chat1v1Request, Chat1V1.Chat1v1Response> methodDescriptor;
        MethodDescriptor<Chat1V1.Chat1v1Request, Chat1V1.Chat1v1Response> methodDescriptor2 = getChat1v1SendMethod;
        if (methodDescriptor2 == null) {
            synchronized (HermesChat1v1Grpc.class) {
                try {
                    MethodDescriptor<Chat1V1.Chat1v1Request, Chat1V1.Chat1v1Response> methodDescriptor3 = getChat1v1SendMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Chat1v1Send")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(Chat1V1.Chat1v1Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(Chat1V1.Chat1v1Response.getDefaultInstance())).setSchemaDescriptor(new HermesChat1v1MethodDescriptorSupplier("Chat1v1Send")).build();
                        getChat1v1SendMethod = methodDescriptor;
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
            synchronized (HermesChat1v1Grpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new HermesChat1v1FileDescriptorSupplier()).addMethod(getChat1v1SendMethod()).build();
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

    public static HermesChat1v1BlockingStub newBlockingStub(Channel channel) {
        return (HermesChat1v1BlockingStub) HermesChat1v1BlockingStub.newStub(new AbstractStub.StubFactory<HermesChat1v1BlockingStub>() { // from class: com.blued.im.private_chat.HermesChat1v1Grpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public HermesChat1v1BlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new HermesChat1v1BlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static HermesChat1v1FutureStub newFutureStub(Channel channel) {
        return (HermesChat1v1FutureStub) HermesChat1v1FutureStub.newStub(new AbstractStub.StubFactory<HermesChat1v1FutureStub>() { // from class: com.blued.im.private_chat.HermesChat1v1Grpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public HermesChat1v1FutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new HermesChat1v1FutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static HermesChat1v1Stub newStub(Channel channel) {
        return (HermesChat1v1Stub) HermesChat1v1Stub.newStub(new AbstractStub.StubFactory<HermesChat1v1Stub>() { // from class: com.blued.im.private_chat.HermesChat1v1Grpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public HermesChat1v1Stub newStub(Channel channel2, CallOptions callOptions) {
                return new HermesChat1v1Stub(channel2, callOptions);
            }
        }, channel);
    }
}
