package com.blued.im.sync;

import com.blued.im.sync.SyncOuterClass;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc.class */
public final class SyncGrpc {
    private static final int METHODID_SYNC = 0;
    public static final String SERVICE_NAME = "com.blued.im.sync.Sync";
    private static volatile MethodDescriptor<SyncOuterClass.SyncRequest, SyncOuterClass.SyncResponse> getSyncMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final SyncImplBase serviceImpl;

        MethodHandlers(SyncImplBase syncImplBase, int i) {
            this.serviceImpl = syncImplBase;
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
            this.serviceImpl.sync((SyncOuterClass.SyncRequest) req, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncBaseDescriptorSupplier.class */
    static abstract class SyncBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        SyncBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return SyncOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Sync");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncBlockingStub.class */
    public static final class SyncBlockingStub extends AbstractBlockingStub<SyncBlockingStub> {
        private SyncBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public SyncBlockingStub build(Channel channel, CallOptions callOptions) {
            return new SyncBlockingStub(channel, callOptions);
        }

        public SyncOuterClass.SyncResponse sync(SyncOuterClass.SyncRequest syncRequest) {
            return (SyncOuterClass.SyncResponse) ClientCalls.blockingUnaryCall(getChannel(), SyncGrpc.getSyncMethod(), getCallOptions(), syncRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncFileDescriptorSupplier.class */
    public static final class SyncFileDescriptorSupplier extends SyncBaseDescriptorSupplier {
        SyncFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncFutureStub.class */
    public static final class SyncFutureStub extends AbstractFutureStub<SyncFutureStub> {
        private SyncFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public SyncFutureStub build(Channel channel, CallOptions callOptions) {
            return new SyncFutureStub(channel, callOptions);
        }

        public ListenableFuture<SyncOuterClass.SyncResponse> sync(SyncOuterClass.SyncRequest syncRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(SyncGrpc.getSyncMethod(), getCallOptions()), syncRequest);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncImplBase.class */
    public static abstract class SyncImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(SyncGrpc.getServiceDescriptor()).addMethod(SyncGrpc.getSyncMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void sync(SyncOuterClass.SyncRequest syncRequest, StreamObserver<SyncOuterClass.SyncResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(SyncGrpc.getSyncMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncMethodDescriptorSupplier.class */
    public static final class SyncMethodDescriptorSupplier extends SyncBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        SyncMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncGrpc$SyncStub.class */
    public static final class SyncStub extends AbstractAsyncStub<SyncStub> {
        private SyncStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public SyncStub build(Channel channel, CallOptions callOptions) {
            return new SyncStub(channel, callOptions);
        }

        public void sync(SyncOuterClass.SyncRequest syncRequest, StreamObserver<SyncOuterClass.SyncResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(SyncGrpc.getSyncMethod(), getCallOptions()), syncRequest, streamObserver);
        }
    }

    private SyncGrpc() {
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2;
        ServiceDescriptor serviceDescriptor3 = serviceDescriptor;
        if (serviceDescriptor3 == null) {
            synchronized (SyncGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new SyncFileDescriptorSupplier()).addMethod(getSyncMethod()).build();
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

    public static MethodDescriptor<SyncOuterClass.SyncRequest, SyncOuterClass.SyncResponse> getSyncMethod() {
        MethodDescriptor<SyncOuterClass.SyncRequest, SyncOuterClass.SyncResponse> methodDescriptor;
        MethodDescriptor<SyncOuterClass.SyncRequest, SyncOuterClass.SyncResponse> methodDescriptor2 = getSyncMethod;
        if (methodDescriptor2 == null) {
            synchronized (SyncGrpc.class) {
                try {
                    MethodDescriptor<SyncOuterClass.SyncRequest, SyncOuterClass.SyncResponse> methodDescriptor3 = getSyncMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Sync")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(SyncOuterClass.SyncRequest.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(SyncOuterClass.SyncResponse.getDefaultInstance())).setSchemaDescriptor(new SyncMethodDescriptorSupplier("Sync")).build();
                        getSyncMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static SyncBlockingStub newBlockingStub(Channel channel) {
        return (SyncBlockingStub) SyncBlockingStub.newStub(new AbstractStub.StubFactory<SyncBlockingStub>() { // from class: com.blued.im.sync.SyncGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public SyncBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new SyncBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static SyncFutureStub newFutureStub(Channel channel) {
        return (SyncFutureStub) SyncFutureStub.newStub(new AbstractStub.StubFactory<SyncFutureStub>() { // from class: com.blued.im.sync.SyncGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public SyncFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new SyncFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static SyncStub newStub(Channel channel) {
        return (SyncStub) SyncStub.newStub(new AbstractStub.StubFactory<SyncStub>() { // from class: com.blued.im.sync.SyncGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public SyncStub newStub(Channel channel2, CallOptions callOptions) {
                return new SyncStub(channel2, callOptions);
            }
        }, channel);
    }
}
