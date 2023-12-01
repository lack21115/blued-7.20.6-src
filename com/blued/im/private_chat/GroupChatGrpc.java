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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc.class */
public final class GroupChatGrpc {
    private static final int METHODID_SEND = 0;
    public static final String SERVICE_NAME = "com.blued.im.private_chat.GroupChat";
    private static volatile MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> getSendMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatBaseDescriptorSupplier.class */
    static abstract class GroupChatBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        GroupChatBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return PrivateChatOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("GroupChat");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatBlockingStub.class */
    public static final class GroupChatBlockingStub extends AbstractBlockingStub<GroupChatBlockingStub> {
        private GroupChatBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public GroupChatBlockingStub build(Channel channel, CallOptions callOptions) {
            return new GroupChatBlockingStub(channel, callOptions);
        }

        public PrivateChatOuterClass.Response send(PrivateChatOuterClass.Request request) {
            return (PrivateChatOuterClass.Response) ClientCalls.blockingUnaryCall(getChannel(), GroupChatGrpc.getSendMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatFileDescriptorSupplier.class */
    public static final class GroupChatFileDescriptorSupplier extends GroupChatBaseDescriptorSupplier {
        GroupChatFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatFutureStub.class */
    public static final class GroupChatFutureStub extends AbstractFutureStub<GroupChatFutureStub> {
        private GroupChatFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public GroupChatFutureStub build(Channel channel, CallOptions callOptions) {
            return new GroupChatFutureStub(channel, callOptions);
        }

        public ListenableFuture<PrivateChatOuterClass.Response> send(PrivateChatOuterClass.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(GroupChatGrpc.getSendMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatImplBase.class */
    public static abstract class GroupChatImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(GroupChatGrpc.getServiceDescriptor()).addMethod(GroupChatGrpc.getSendMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void send(PrivateChatOuterClass.Request request, StreamObserver<PrivateChatOuterClass.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(GroupChatGrpc.getSendMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatMethodDescriptorSupplier.class */
    public static final class GroupChatMethodDescriptorSupplier extends GroupChatBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        GroupChatMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$GroupChatStub.class */
    public static final class GroupChatStub extends AbstractAsyncStub<GroupChatStub> {
        private GroupChatStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public GroupChatStub build(Channel channel, CallOptions callOptions) {
            return new GroupChatStub(channel, callOptions);
        }

        public void send(PrivateChatOuterClass.Request request, StreamObserver<PrivateChatOuterClass.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(GroupChatGrpc.getSendMethod(), getCallOptions()), request, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/GroupChatGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final GroupChatImplBase serviceImpl;

        MethodHandlers(GroupChatImplBase groupChatImplBase, int i) {
            this.serviceImpl = groupChatImplBase;
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

    private GroupChatGrpc() {
    }

    public static MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> getSendMethod() {
        MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> methodDescriptor;
        MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> methodDescriptor2 = getSendMethod;
        if (methodDescriptor2 == null) {
            synchronized (GroupChatGrpc.class) {
                try {
                    MethodDescriptor<PrivateChatOuterClass.Request, PrivateChatOuterClass.Response> methodDescriptor3 = getSendMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Send")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(PrivateChatOuterClass.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(PrivateChatOuterClass.Response.getDefaultInstance())).setSchemaDescriptor(new GroupChatMethodDescriptorSupplier("Send")).build();
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
            synchronized (GroupChatGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new GroupChatFileDescriptorSupplier()).addMethod(getSendMethod()).build();
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

    public static GroupChatBlockingStub newBlockingStub(Channel channel) {
        return (GroupChatBlockingStub) GroupChatBlockingStub.newStub(new AbstractStub.StubFactory<GroupChatBlockingStub>() { // from class: com.blued.im.private_chat.GroupChatGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public GroupChatBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new GroupChatBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static GroupChatFutureStub newFutureStub(Channel channel) {
        return (GroupChatFutureStub) GroupChatFutureStub.newStub(new AbstractStub.StubFactory<GroupChatFutureStub>() { // from class: com.blued.im.private_chat.GroupChatGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public GroupChatFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new GroupChatFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static GroupChatStub newStub(Channel channel) {
        return (GroupChatStub) GroupChatStub.newStub(new AbstractStub.StubFactory<GroupChatStub>() { // from class: com.blued.im.private_chat.GroupChatGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public GroupChatStub newStub(Channel channel2, CallOptions callOptions) {
                return new GroupChatStub(channel2, callOptions);
            }
        }, channel);
    }
}
