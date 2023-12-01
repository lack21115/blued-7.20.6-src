package com.blued.das.tea;

import com.blued.das.tea.TeaProtos;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc.class */
public final class ReportServiceGrpc {
    private static final int METHODID_REPORT = 0;
    public static final String SERVICE_NAME = "com.blued.das.tea.ReportService";
    private static volatile MethodDescriptor<TeaProtos.Request, TeaProtos.Response> getReportMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$MethodHandlers.class */
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
            this.serviceImpl.report((TeaProtos.Request) req, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceBaseDescriptorSupplier.class */
    static abstract class ReportServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ReportServiceBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return TeaProtos.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ReportService");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceBlockingStub.class */
    public static final class ReportServiceBlockingStub extends AbstractBlockingStub<ReportServiceBlockingStub> {
        private ReportServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ReportServiceBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceBlockingStub(channel, callOptions);
        }

        public TeaProtos.Response report(TeaProtos.Request request) {
            return (TeaProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), ReportServiceGrpc.getReportMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceFileDescriptorSupplier.class */
    public static final class ReportServiceFileDescriptorSupplier extends ReportServiceBaseDescriptorSupplier {
        ReportServiceFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceFutureStub.class */
    public static final class ReportServiceFutureStub extends AbstractFutureStub<ReportServiceFutureStub> {
        private ReportServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ReportServiceFutureStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceFutureStub(channel, callOptions);
        }

        public ListenableFuture<TeaProtos.Response> report(TeaProtos.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReportServiceGrpc.getReportMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceImplBase.class */
    public static abstract class ReportServiceImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ReportServiceGrpc.getServiceDescriptor()).addMethod(ReportServiceGrpc.getReportMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void report(TeaProtos.Request request, StreamObserver<TeaProtos.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getReportMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceMethodDescriptorSupplier.class */
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/tea/ReportServiceGrpc$ReportServiceStub.class */
    public static final class ReportServiceStub extends AbstractAsyncStub<ReportServiceStub> {
        private ReportServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ReportServiceStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceStub(channel, callOptions);
        }

        public void report(TeaProtos.Request request, StreamObserver<TeaProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReportServiceGrpc.getReportMethod(), getCallOptions()), request, streamObserver);
        }
    }

    private ReportServiceGrpc() {
    }

    public static MethodDescriptor<TeaProtos.Request, TeaProtos.Response> getReportMethod() {
        MethodDescriptor<TeaProtos.Request, TeaProtos.Response> methodDescriptor;
        MethodDescriptor<TeaProtos.Request, TeaProtos.Response> methodDescriptor2 = getReportMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReportServiceGrpc.class) {
                try {
                    MethodDescriptor<TeaProtos.Request, TeaProtos.Response> methodDescriptor3 = getReportMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Report")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(TeaProtos.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(TeaProtos.Response.getDefaultInstance())).setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("Report")).build();
                        getReportMethod = methodDescriptor;
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
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new ReportServiceFileDescriptorSupplier()).addMethod(getReportMethod()).build();
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
        return (ReportServiceBlockingStub) ReportServiceBlockingStub.newStub(new AbstractStub.StubFactory<ReportServiceBlockingStub>() { // from class: com.blued.das.tea.ReportServiceGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceFutureStub newFutureStub(Channel channel) {
        return (ReportServiceFutureStub) ReportServiceFutureStub.newStub(new AbstractStub.StubFactory<ReportServiceFutureStub>() { // from class: com.blued.das.tea.ReportServiceGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceStub newStub(Channel channel) {
        return (ReportServiceStub) ReportServiceStub.newStub(new AbstractStub.StubFactory<ReportServiceStub>() { // from class: com.blued.das.tea.ReportServiceGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceStub(channel2, callOptions);
            }
        }, channel);
    }
}
