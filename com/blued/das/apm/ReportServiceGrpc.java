package com.blued.das.apm;

import com.blued.das.apm.ApmProtos;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc.class */
public final class ReportServiceGrpc {
    private static final int METHODID_BATCH_REPORT = 0;
    public static final String SERVICE_NAME = "com.blued.das.apm.ReportService";
    private static volatile MethodDescriptor<ApmProtos.Requests, ApmProtos.Response> getBatchReportMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final ReportServiceImplBase serviceImpl;

        MethodHandlers(ReportServiceImplBase reportServiceImplBase, int i) {
            this.serviceImpl = reportServiceImplBase;
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
            this.serviceImpl.batchReport((ApmProtos.Requests) req, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceBaseDescriptorSupplier.class */
    static abstract class ReportServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ReportServiceBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return ApmProtos.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ReportService");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceBlockingStub.class */
    public static final class ReportServiceBlockingStub extends AbstractBlockingStub<ReportServiceBlockingStub> {
        private ReportServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public ApmProtos.Response batchReport(ApmProtos.Requests requests) {
            return (ApmProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), ReportServiceGrpc.getBatchReportMethod(), getCallOptions(), requests);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ReportServiceBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceBlockingStub(channel, callOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceFileDescriptorSupplier.class */
    public static final class ReportServiceFileDescriptorSupplier extends ReportServiceBaseDescriptorSupplier {
        ReportServiceFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceFutureStub.class */
    public static final class ReportServiceFutureStub extends AbstractFutureStub<ReportServiceFutureStub> {
        private ReportServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public ListenableFuture<ApmProtos.Response> batchReport(ApmProtos.Requests requests) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReportServiceGrpc.getBatchReportMethod(), getCallOptions()), requests);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ReportServiceFutureStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceFutureStub(channel, callOptions);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceImplBase.class */
    public static abstract class ReportServiceImplBase implements BindableService {
        public void batchReport(ApmProtos.Requests requests, StreamObserver<ApmProtos.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), streamObserver);
        }

        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ReportServiceGrpc.getServiceDescriptor()).addMethod(ReportServiceGrpc.getBatchReportMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceMethodDescriptorSupplier.class */
    public static final class ReportServiceMethodDescriptorSupplier extends ReportServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        ReportServiceMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/apm/ReportServiceGrpc$ReportServiceStub.class */
    public static final class ReportServiceStub extends AbstractAsyncStub<ReportServiceStub> {
        private ReportServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public void batchReport(ApmProtos.Requests requests, StreamObserver<ApmProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReportServiceGrpc.getBatchReportMethod(), getCallOptions()), requests, streamObserver);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ReportServiceStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceStub(channel, callOptions);
        }
    }

    private ReportServiceGrpc() {
    }

    public static MethodDescriptor<ApmProtos.Requests, ApmProtos.Response> getBatchReportMethod() {
        MethodDescriptor<ApmProtos.Requests, ApmProtos.Response> methodDescriptor;
        MethodDescriptor<ApmProtos.Requests, ApmProtos.Response> methodDescriptor2 = getBatchReportMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReportServiceGrpc.class) {
                try {
                    MethodDescriptor<ApmProtos.Requests, ApmProtos.Response> methodDescriptor3 = getBatchReportMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "BatchReport")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ApmProtos.Requests.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ApmProtos.Response.getDefaultInstance())).setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("BatchReport")).build();
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
        return (ReportServiceBlockingStub) ReportServiceBlockingStub.newStub(new AbstractStub.StubFactory<ReportServiceBlockingStub>() { // from class: com.blued.das.apm.ReportServiceGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceFutureStub newFutureStub(Channel channel) {
        return (ReportServiceFutureStub) ReportServiceFutureStub.newStub(new AbstractStub.StubFactory<ReportServiceFutureStub>() { // from class: com.blued.das.apm.ReportServiceGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceStub newStub(Channel channel) {
        return (ReportServiceStub) ReportServiceStub.newStub(new AbstractStub.StubFactory<ReportServiceStub>() { // from class: com.blued.das.apm.ReportServiceGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceStub(channel2, callOptions);
            }
        }, channel);
    }
}
