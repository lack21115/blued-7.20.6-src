package com.blued.das.client.abtest;

import com.blued.das.client.abtest.AbClientProtos;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc.class */
public final class AbClientServiceGrpc {
    private static final int METHODID_GET_AB_RESULT = 0;
    public static final String SERVICE_NAME = "com.blued.das.client.abtest.AbClientService";
    private static volatile MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> getGetAbResultMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceBaseDescriptorSupplier.class */
    static abstract class AbClientServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        AbClientServiceBaseDescriptorSupplier() {
        }

        public Descriptors.FileDescriptor getFileDescriptor() {
            return AbClientProtos.getDescriptor();
        }

        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("AbClientService");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceBlockingStub.class */
    public static final class AbClientServiceBlockingStub extends AbstractBlockingStub<AbClientServiceBlockingStub> {
        private AbClientServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public AbClientServiceBlockingStub m2120build(Channel channel, CallOptions callOptions) {
            return new AbClientServiceBlockingStub(channel, callOptions);
        }

        public AbClientProtos.Response getAbResult(AbClientProtos.Request request) {
            return (AbClientProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), AbClientServiceGrpc.getGetAbResultMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceFileDescriptorSupplier.class */
    public static final class AbClientServiceFileDescriptorSupplier extends AbClientServiceBaseDescriptorSupplier {
        AbClientServiceFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceFutureStub.class */
    public static final class AbClientServiceFutureStub extends AbstractFutureStub<AbClientServiceFutureStub> {
        private AbClientServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public AbClientServiceFutureStub m2121build(Channel channel, CallOptions callOptions) {
            return new AbClientServiceFutureStub(channel, callOptions);
        }

        public ListenableFuture<AbClientProtos.Response> getAbResult(AbClientProtos.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(AbClientServiceGrpc.getGetAbResultMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceImplBase.class */
    public static abstract class AbClientServiceImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(AbClientServiceGrpc.getServiceDescriptor()).addMethod(AbClientServiceGrpc.getGetAbResultMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void getAbResult(AbClientProtos.Request request, StreamObserver<AbClientProtos.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(AbClientServiceGrpc.getGetAbResultMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceMethodDescriptorSupplier.class */
    public static final class AbClientServiceMethodDescriptorSupplier extends AbClientServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        AbClientServiceMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$AbClientServiceStub.class */
    public static final class AbClientServiceStub extends AbstractAsyncStub<AbClientServiceStub> {
        private AbClientServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public AbClientServiceStub m2122build(Channel channel, CallOptions callOptions) {
            return new AbClientServiceStub(channel, callOptions);
        }

        public void getAbResult(AbClientProtos.Request request, StreamObserver<AbClientProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(AbClientServiceGrpc.getGetAbResultMethod(), getCallOptions()), request, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/abtest/AbClientServiceGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final AbClientServiceImplBase serviceImpl;

        MethodHandlers(AbClientServiceImplBase abClientServiceImplBase, int i) {
            this.serviceImpl = abClientServiceImplBase;
            this.methodId = i;
        }

        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.getAbResult((AbClientProtos.Request) req, streamObserver);
        }
    }

    private AbClientServiceGrpc() {
    }

    public static MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> getGetAbResultMethod() {
        MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> methodDescriptor;
        MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> methodDescriptor2 = getGetAbResultMethod;
        if (methodDescriptor2 == null) {
            synchronized (AbClientServiceGrpc.class) {
                try {
                    MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> methodDescriptor3 = getGetAbResultMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "getAbResult")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(AbClientProtos.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(AbClientProtos.Response.getDefaultInstance())).setSchemaDescriptor(new AbClientServiceMethodDescriptorSupplier("getAbResult")).build();
                        getGetAbResultMethod = methodDescriptor;
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
            synchronized (AbClientServiceGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new AbClientServiceFileDescriptorSupplier()).addMethod(getGetAbResultMethod()).build();
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

    public static AbClientServiceBlockingStub newBlockingStub(Channel channel) {
        return AbClientServiceBlockingStub.newStub(new AbstractStub.StubFactory<AbClientServiceBlockingStub>() { // from class: com.blued.das.client.abtest.AbClientServiceGrpc.2
            /* renamed from: newStub */
            public AbClientServiceBlockingStub m2118newStub(Channel channel2, CallOptions callOptions) {
                return new AbClientServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static AbClientServiceFutureStub newFutureStub(Channel channel) {
        return AbClientServiceFutureStub.newStub(new AbstractStub.StubFactory<AbClientServiceFutureStub>() { // from class: com.blued.das.client.abtest.AbClientServiceGrpc.3
            /* renamed from: newStub */
            public AbClientServiceFutureStub m2119newStub(Channel channel2, CallOptions callOptions) {
                return new AbClientServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static AbClientServiceStub newStub(Channel channel) {
        return AbClientServiceStub.newStub(new AbstractStub.StubFactory<AbClientServiceStub>() { // from class: com.blued.das.client.abtest.AbClientServiceGrpc.1
            /* renamed from: newStub */
            public AbClientServiceStub m2117newStub(Channel channel2, CallOptions callOptions) {
                return new AbClientServiceStub(channel2, callOptions);
            }
        }, channel);
    }
}
