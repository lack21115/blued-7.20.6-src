package cn.irisgw.live;

import cn.irisgw.live.LiveChatOuterClass;
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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc.class */
public final class LiveChatGrpc {
    private static final int METHODID_SEND_LIKE = 1;
    private static final int METHODID_SEND_MSG = 0;
    public static final String SERVICE_NAME = "cn.irisgw.live.LiveChat";
    private static volatile MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> getSendLikeMethod;
    private static volatile MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> getSendMsgMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatBaseDescriptorSupplier.class */
    static abstract class LiveChatBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        LiveChatBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return LiveChatOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("LiveChat");
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatBlockingStub.class */
    public static final class LiveChatBlockingStub extends AbstractBlockingStub<LiveChatBlockingStub> {
        private LiveChatBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public LiveChatBlockingStub build(Channel channel, CallOptions callOptions) {
            return new LiveChatBlockingStub(channel, callOptions);
        }

        public LiveChatOuterClass.LiveLikeResponse sendLike(LiveChatOuterClass.LiveLikeRequest liveLikeRequest) {
            return (LiveChatOuterClass.LiveLikeResponse) ClientCalls.blockingUnaryCall(getChannel(), LiveChatGrpc.getSendLikeMethod(), getCallOptions(), liveLikeRequest);
        }

        public LiveChatOuterClass.LiveMsgResponse sendMsg(LiveChatOuterClass.LiveMsgRequest liveMsgRequest) {
            return (LiveChatOuterClass.LiveMsgResponse) ClientCalls.blockingUnaryCall(getChannel(), LiveChatGrpc.getSendMsgMethod(), getCallOptions(), liveMsgRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatFileDescriptorSupplier.class */
    public static final class LiveChatFileDescriptorSupplier extends LiveChatBaseDescriptorSupplier {
        LiveChatFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatFutureStub.class */
    public static final class LiveChatFutureStub extends AbstractFutureStub<LiveChatFutureStub> {
        private LiveChatFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public LiveChatFutureStub build(Channel channel, CallOptions callOptions) {
            return new LiveChatFutureStub(channel, callOptions);
        }

        public ListenableFuture<LiveChatOuterClass.LiveLikeResponse> sendLike(LiveChatOuterClass.LiveLikeRequest liveLikeRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(LiveChatGrpc.getSendLikeMethod(), getCallOptions()), liveLikeRequest);
        }

        public ListenableFuture<LiveChatOuterClass.LiveMsgResponse> sendMsg(LiveChatOuterClass.LiveMsgRequest liveMsgRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(LiveChatGrpc.getSendMsgMethod(), getCallOptions()), liveMsgRequest);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatImplBase.class */
    public static abstract class LiveChatImplBase implements BindableService {
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(LiveChatGrpc.getServiceDescriptor()).addMethod(LiveChatGrpc.getSendMsgMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(LiveChatGrpc.getSendLikeMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).build();
        }

        public void sendLike(LiveChatOuterClass.LiveLikeRequest liveLikeRequest, StreamObserver<LiveChatOuterClass.LiveLikeResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(LiveChatGrpc.getSendLikeMethod(), streamObserver);
        }

        public void sendMsg(LiveChatOuterClass.LiveMsgRequest liveMsgRequest, StreamObserver<LiveChatOuterClass.LiveMsgResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(LiveChatGrpc.getSendMsgMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatMethodDescriptorSupplier.class */
    public static final class LiveChatMethodDescriptorSupplier extends LiveChatBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        LiveChatMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$LiveChatStub.class */
    public static final class LiveChatStub extends AbstractAsyncStub<LiveChatStub> {
        private LiveChatStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public LiveChatStub build(Channel channel, CallOptions callOptions) {
            return new LiveChatStub(channel, callOptions);
        }

        public void sendLike(LiveChatOuterClass.LiveLikeRequest liveLikeRequest, StreamObserver<LiveChatOuterClass.LiveLikeResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(LiveChatGrpc.getSendLikeMethod(), getCallOptions()), liveLikeRequest, streamObserver);
        }

        public void sendMsg(LiveChatOuterClass.LiveMsgRequest liveMsgRequest, StreamObserver<LiveChatOuterClass.LiveMsgResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(LiveChatGrpc.getSendMsgMethod(), getCallOptions()), liveMsgRequest, streamObserver);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveChatGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final LiveChatImplBase serviceImpl;

        MethodHandlers(LiveChatImplBase liveChatImplBase, int i) {
            this.serviceImpl = liveChatImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.BidiStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.ClientStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ServerStreamingMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.UnaryMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                this.serviceImpl.sendMsg((LiveChatOuterClass.LiveMsgRequest) req, streamObserver);
            } else if (i != 1) {
                throw new AssertionError();
            } else {
                this.serviceImpl.sendLike((LiveChatOuterClass.LiveLikeRequest) req, streamObserver);
            }
        }
    }

    private LiveChatGrpc() {
    }

    public static MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> getSendLikeMethod() {
        MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> methodDescriptor;
        MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> methodDescriptor2 = getSendLikeMethod;
        if (methodDescriptor2 == null) {
            synchronized (LiveChatGrpc.class) {
                try {
                    MethodDescriptor<LiveChatOuterClass.LiveLikeRequest, LiveChatOuterClass.LiveLikeResponse> methodDescriptor3 = getSendLikeMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "SendLike")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(LiveChatOuterClass.LiveLikeRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(LiveChatOuterClass.LiveLikeResponse.getDefaultInstance())).setSchemaDescriptor(new LiveChatMethodDescriptorSupplier("SendLike")).build();
                        getSendLikeMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> getSendMsgMethod() {
        MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> methodDescriptor;
        MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> methodDescriptor2 = getSendMsgMethod;
        if (methodDescriptor2 == null) {
            synchronized (LiveChatGrpc.class) {
                try {
                    MethodDescriptor<LiveChatOuterClass.LiveMsgRequest, LiveChatOuterClass.LiveMsgResponse> methodDescriptor3 = getSendMsgMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "SendMsg")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(LiveChatOuterClass.LiveMsgRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(LiveChatOuterClass.LiveMsgResponse.getDefaultInstance())).setSchemaDescriptor(new LiveChatMethodDescriptorSupplier("SendMsg")).build();
                        getSendMsgMethod = methodDescriptor;
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
            synchronized (LiveChatGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new LiveChatFileDescriptorSupplier()).addMethod(getSendMsgMethod()).addMethod(getSendLikeMethod()).build();
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

    public static LiveChatBlockingStub newBlockingStub(Channel channel) {
        return (LiveChatBlockingStub) LiveChatBlockingStub.newStub(new AbstractStub.StubFactory<LiveChatBlockingStub>() { // from class: cn.irisgw.live.LiveChatGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public LiveChatBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new LiveChatBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static LiveChatFutureStub newFutureStub(Channel channel) {
        return (LiveChatFutureStub) LiveChatFutureStub.newStub(new AbstractStub.StubFactory<LiveChatFutureStub>() { // from class: cn.irisgw.live.LiveChatGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public LiveChatFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new LiveChatFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static LiveChatStub newStub(Channel channel) {
        return (LiveChatStub) LiveChatStub.newStub(new AbstractStub.StubFactory<LiveChatStub>() { // from class: cn.irisgw.live.LiveChatGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public LiveChatStub newStub(Channel channel2, CallOptions callOptions) {
                return new LiveChatStub(channel2, callOptions);
            }
        }, channel);
    }
}
