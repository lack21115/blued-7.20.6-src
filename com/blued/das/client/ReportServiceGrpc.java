package com.blued.das.client;

import com.blued.das.client.ClientProtos;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc.class */
public final class ReportServiceGrpc {
    private static final int METHODID_BATCH_REPORT = 0;
    public static final String SERVICE_NAME = "com.blued.das.client.ReportService";
    private static volatile MethodDescriptor<ClientProtos.Requests, ClientProtos.Response> getBatchReportMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final ReportServiceImplBase serviceImpl;

        MethodHandlers(ReportServiceImplBase reportServiceImplBase, int i) {
            this.serviceImpl = reportServiceImplBase;
            this.methodId = i;
        }

        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.batchReport((ClientProtos.Requests) req, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceBaseDescriptorSupplier.class */
    static abstract class ReportServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ReportServiceBaseDescriptorSupplier() {
        }

        public Descriptors.FileDescriptor getFileDescriptor() {
            return ClientProtos.getDescriptor();
        }

        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ReportService");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceBlockingStub.class */
    public static final class ReportServiceBlockingStub extends AbstractBlockingStub<ReportServiceBlockingStub> {
        private ReportServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public ClientProtos.Response batchReport(ClientProtos.Requests requests) {
            return (ClientProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), ReportServiceGrpc.getBatchReportMethod(), getCallOptions(), requests);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReportServiceBlockingStub m2109build(Channel channel, CallOptions callOptions) {
            return new ReportServiceBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceFileDescriptorSupplier.class */
    public static final class ReportServiceFileDescriptorSupplier extends ReportServiceBaseDescriptorSupplier {
        ReportServiceFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceFutureStub.class */
    public static final class ReportServiceFutureStub extends AbstractFutureStub<ReportServiceFutureStub> {
        private ReportServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public ListenableFuture<ClientProtos.Response> batchReport(ClientProtos.Requests requests) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReportServiceGrpc.getBatchReportMethod(), getCallOptions()), requests);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReportServiceFutureStub m2110build(Channel channel, CallOptions callOptions) {
            return new ReportServiceFutureStub(channel, callOptions);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceImplBase.class */
    public static abstract class ReportServiceImplBase implements BindableService {
        public void batchReport(ClientProtos.Requests requests, StreamObserver<ClientProtos.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), streamObserver);
        }

        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ReportServiceGrpc.getServiceDescriptor()).addMethod(ReportServiceGrpc.getBatchReportMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceMethodDescriptorSupplier.class */
    public static final class ReportServiceMethodDescriptorSupplier extends ReportServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        ReportServiceMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/ReportServiceGrpc$ReportServiceStub.class */
    public static final class ReportServiceStub extends AbstractAsyncStub<ReportServiceStub> {
        private ReportServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public void batchReport(ClientProtos.Requests requests, StreamObserver<ClientProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReportServiceGrpc.getBatchReportMethod(), getCallOptions()), requests, streamObserver);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReportServiceStub m2111build(Channel channel, CallOptions callOptions) {
            return new ReportServiceStub(channel, callOptions);
        }
    }

    private ReportServiceGrpc() {
    }

    public static MethodDescriptor<ClientProtos.Requests, ClientProtos.Response> getBatchReportMethod() {
        MethodDescriptor<ClientProtos.Requests, ClientProtos.Response> methodDescriptor;
        MethodDescriptor<ClientProtos.Requests, ClientProtos.Response> methodDescriptor2 = getBatchReportMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReportServiceGrpc.class) {
                try {
                    MethodDescriptor<ClientProtos.Requests, ClientProtos.Response> methodDescriptor3 = getBatchReportMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "BatchReport")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ClientProtos.Requests.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ClientProtos.Response.getDefaultInstance())).setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("BatchReport")).build();
                        getBatchReportMethod = methodDescriptor;
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
            synchronized (ReportServiceGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new ReportServiceFileDescriptorSupplier()).addMethod(getBatchReportMethod()).build();
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

    public static ReportServiceBlockingStub newBlockingStub(Channel channel) {
        return ReportServiceBlockingStub.newStub(new AbstractStub.StubFactory<ReportServiceBlockingStub>() { // from class: com.blued.das.client.ReportServiceGrpc.2
            /* renamed from: newStub */
            public ReportServiceBlockingStub m2107newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceFutureStub newFutureStub(Channel channel) {
        return ReportServiceFutureStub.newStub(new AbstractStub.StubFactory<ReportServiceFutureStub>() { // from class: com.blued.das.client.ReportServiceGrpc.3
            /* renamed from: newStub */
            public ReportServiceFutureStub m2108newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceStub newStub(Channel channel) {
        return ReportServiceStub.newStub(new AbstractStub.StubFactory<ReportServiceStub>() { // from class: com.blued.das.client.ReportServiceGrpc.1
            /* renamed from: newStub */
            public ReportServiceStub m2106newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceStub(channel2, callOptions);
            }
        }, channel);
    }
}
