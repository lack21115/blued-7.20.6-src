package cn.irisgw.live;

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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc.class */
public final class LiveConnectorGrpc {
    private static final int METHODID_CONNECT = 0;
    public static final String SERVICE_NAME = "cn.irisgw.live.LiveConnector";
    private static volatile MethodDescriptor<Any, Any> getConnectMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorBaseDescriptorSupplier.class */
    static abstract class LiveConnectorBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        LiveConnectorBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return LiveConnect.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("LiveConnector");
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorBlockingStub.class */
    public static final class LiveConnectorBlockingStub extends AbstractBlockingStub<LiveConnectorBlockingStub> {
        private LiveConnectorBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public LiveConnectorBlockingStub build(Channel channel, CallOptions callOptions) {
            return new LiveConnectorBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorFileDescriptorSupplier.class */
    public static final class LiveConnectorFileDescriptorSupplier extends LiveConnectorBaseDescriptorSupplier {
        LiveConnectorFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorFutureStub.class */
    public static final class LiveConnectorFutureStub extends AbstractFutureStub<LiveConnectorFutureStub> {
        private LiveConnectorFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public LiveConnectorFutureStub build(Channel channel, CallOptions callOptions) {
            return new LiveConnectorFutureStub(channel, callOptions);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorImplBase.class */
    public static abstract class LiveConnectorImplBase implements BindableService {
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(LiveConnectorGrpc.getServiceDescriptor()).addMethod(LiveConnectorGrpc.getConnectMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 0))).build();
        }

        public StreamObserver<Any> connect(StreamObserver<Any> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(LiveConnectorGrpc.getConnectMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorMethodDescriptorSupplier.class */
    public static final class LiveConnectorMethodDescriptorSupplier extends LiveConnectorBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        LiveConnectorMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$LiveConnectorStub.class */
    public static final class LiveConnectorStub extends AbstractAsyncStub<LiveConnectorStub> {
        private LiveConnectorStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public LiveConnectorStub build(Channel channel, CallOptions callOptions) {
            return new LiveConnectorStub(channel, callOptions);
        }

        public StreamObserver<Any> connect(StreamObserver<Any> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(LiveConnectorGrpc.getConnectMethod(), getCallOptions()), streamObserver);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveConnectorGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final LiveConnectorImplBase serviceImpl;

        MethodHandlers(LiveConnectorImplBase liveConnectorImplBase, int i) {
            this.serviceImpl = liveConnectorImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.BidiStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.ClientStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            if (this.methodId == 0) {
                return (StreamObserver<Req>) this.serviceImpl.connect(streamObserver);
            }
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ServerStreamingMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.UnaryMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }

    private LiveConnectorGrpc() {
    }

    public static MethodDescriptor<Any, Any> getConnectMethod() {
        MethodDescriptor<Any, Any> methodDescriptor;
        MethodDescriptor<Any, Any> methodDescriptor2 = getConnectMethod;
        if (methodDescriptor2 == null) {
            synchronized (LiveConnectorGrpc.class) {
                try {
                    MethodDescriptor<Any, Any> methodDescriptor3 = getConnectMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Connect")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(Any.getDefaultInstance())).setSchemaDescriptor(new LiveConnectorMethodDescriptorSupplier("Connect")).build();
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

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2;
        ServiceDescriptor serviceDescriptor3 = serviceDescriptor;
        if (serviceDescriptor3 == null) {
            synchronized (LiveConnectorGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new LiveConnectorFileDescriptorSupplier()).addMethod(getConnectMethod()).build();
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

    public static LiveConnectorBlockingStub newBlockingStub(Channel channel) {
        return (LiveConnectorBlockingStub) LiveConnectorBlockingStub.newStub(new AbstractStub.StubFactory<LiveConnectorBlockingStub>() { // from class: cn.irisgw.live.LiveConnectorGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public LiveConnectorBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new LiveConnectorBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static LiveConnectorFutureStub newFutureStub(Channel channel) {
        return (LiveConnectorFutureStub) LiveConnectorFutureStub.newStub(new AbstractStub.StubFactory<LiveConnectorFutureStub>() { // from class: cn.irisgw.live.LiveConnectorGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public LiveConnectorFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new LiveConnectorFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static LiveConnectorStub newStub(Channel channel) {
        return (LiveConnectorStub) LiveConnectorStub.newStub(new AbstractStub.StubFactory<LiveConnectorStub>() { // from class: cn.irisgw.live.LiveConnectorGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public LiveConnectorStub newStub(Channel channel2, CallOptions callOptions) {
                return new LiveConnectorStub(channel2, callOptions);
            }
        }, channel);
    }
}
