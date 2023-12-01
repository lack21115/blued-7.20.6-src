package com.blued.das.dau;

import com.blued.das.dau.DayActiveUserProtos;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc.class */
public final class ReportServiceGrpc {
    private static final int METHODID_REPORT = 0;
    public static final String SERVICE_NAME = "com.blued.das.dau.ReportService";
    private static volatile MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> getReportMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$MethodHandlers.class */
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
            this.serviceImpl.report((DayActiveUserProtos.Request) req, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceBaseDescriptorSupplier.class */
    static abstract class ReportServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ReportServiceBaseDescriptorSupplier() {
        }

        public Descriptors.FileDescriptor getFileDescriptor() {
            return DayActiveUserProtos.getDescriptor();
        }

        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ReportService");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceBlockingStub.class */
    public static final class ReportServiceBlockingStub extends AbstractBlockingStub<ReportServiceBlockingStub> {
        private ReportServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReportServiceBlockingStub m2185build(Channel channel, CallOptions callOptions) {
            return new ReportServiceBlockingStub(channel, callOptions);
        }

        public DayActiveUserProtos.Response report(DayActiveUserProtos.Request request) {
            return (DayActiveUserProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), ReportServiceGrpc.getReportMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceFileDescriptorSupplier.class */
    public static final class ReportServiceFileDescriptorSupplier extends ReportServiceBaseDescriptorSupplier {
        ReportServiceFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceFutureStub.class */
    public static final class ReportServiceFutureStub extends AbstractFutureStub<ReportServiceFutureStub> {
        private ReportServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReportServiceFutureStub m2186build(Channel channel, CallOptions callOptions) {
            return new ReportServiceFutureStub(channel, callOptions);
        }

        public ListenableFuture<DayActiveUserProtos.Response> report(DayActiveUserProtos.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReportServiceGrpc.getReportMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceImplBase.class */
    public static abstract class ReportServiceImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ReportServiceGrpc.getServiceDescriptor()).addMethod(ReportServiceGrpc.getReportMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void report(DayActiveUserProtos.Request request, StreamObserver<DayActiveUserProtos.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getReportMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceMethodDescriptorSupplier.class */
    public static final class ReportServiceMethodDescriptorSupplier extends ReportServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        ReportServiceMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/ReportServiceGrpc$ReportServiceStub.class */
    public static final class ReportServiceStub extends AbstractAsyncStub<ReportServiceStub> {
        private ReportServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReportServiceStub m2187build(Channel channel, CallOptions callOptions) {
            return new ReportServiceStub(channel, callOptions);
        }

        public void report(DayActiveUserProtos.Request request, StreamObserver<DayActiveUserProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReportServiceGrpc.getReportMethod(), getCallOptions()), request, streamObserver);
        }
    }

    private ReportServiceGrpc() {
    }

    public static MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> getReportMethod() {
        MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> methodDescriptor;
        MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> methodDescriptor2 = getReportMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReportServiceGrpc.class) {
                try {
                    MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> methodDescriptor3 = getReportMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Report")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(DayActiveUserProtos.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(DayActiveUserProtos.Response.getDefaultInstance())).setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("Report")).build();
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
        return ReportServiceBlockingStub.newStub(new AbstractStub.StubFactory<ReportServiceBlockingStub>() { // from class: com.blued.das.dau.ReportServiceGrpc.2
            /* renamed from: newStub */
            public ReportServiceBlockingStub m2183newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceFutureStub newFutureStub(Channel channel) {
        return ReportServiceFutureStub.newStub(new AbstractStub.StubFactory<ReportServiceFutureStub>() { // from class: com.blued.das.dau.ReportServiceGrpc.3
            /* renamed from: newStub */
            public ReportServiceFutureStub m2184newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceStub newStub(Channel channel) {
        return ReportServiceStub.newStub(new AbstractStub.StubFactory<ReportServiceStub>() { // from class: com.blued.das.dau.ReportServiceGrpc.1
            /* renamed from: newStub */
            public ReportServiceStub m2182newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceStub(channel2, callOptions);
            }
        }, channel);
    }
}
