package com.blued.im.req;

import com.blued.im.req.ReqOuterClass;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc.class */
public final class ReqGrpc {
    private static final int METHODID_DEL_BURN_MSG = 1;
    private static final int METHODID_GET_SESSION_INFO = 0;
    public static final String SERVICE_NAME = "com.blued.im.req.Req";
    private static volatile MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.Response> getDelBurnMsgMethod;
    private static volatile MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.SessionInfoResponse> getGetSessionInfoMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final ReqImplBase serviceImpl;

        MethodHandlers(ReqImplBase reqImplBase, int i) {
            this.serviceImpl = reqImplBase;
            this.methodId = i;
        }

        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                this.serviceImpl.getSessionInfo((ReqOuterClass.Request) req, streamObserver);
            } else if (i != 1) {
                throw new AssertionError();
            } else {
                this.serviceImpl.delBurnMsg((ReqOuterClass.Request) req, streamObserver);
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqBaseDescriptorSupplier.class */
    static abstract class ReqBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        ReqBaseDescriptorSupplier() {
        }

        public Descriptors.FileDescriptor getFileDescriptor() {
            return ReqOuterClass.getDescriptor();
        }

        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Req");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqBlockingStub.class */
    public static final class ReqBlockingStub extends AbstractBlockingStub<ReqBlockingStub> {
        private ReqBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReqBlockingStub m2517build(Channel channel, CallOptions callOptions) {
            return new ReqBlockingStub(channel, callOptions);
        }

        public ReqOuterClass.Response delBurnMsg(ReqOuterClass.Request request) {
            return (ReqOuterClass.Response) ClientCalls.blockingUnaryCall(getChannel(), ReqGrpc.getDelBurnMsgMethod(), getCallOptions(), request);
        }

        public ReqOuterClass.SessionInfoResponse getSessionInfo(ReqOuterClass.Request request) {
            return (ReqOuterClass.SessionInfoResponse) ClientCalls.blockingUnaryCall(getChannel(), ReqGrpc.getGetSessionInfoMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqFileDescriptorSupplier.class */
    public static final class ReqFileDescriptorSupplier extends ReqBaseDescriptorSupplier {
        ReqFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqFutureStub.class */
    public static final class ReqFutureStub extends AbstractFutureStub<ReqFutureStub> {
        private ReqFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReqFutureStub m2518build(Channel channel, CallOptions callOptions) {
            return new ReqFutureStub(channel, callOptions);
        }

        public ListenableFuture<ReqOuterClass.Response> delBurnMsg(ReqOuterClass.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReqGrpc.getDelBurnMsgMethod(), getCallOptions()), request);
        }

        public ListenableFuture<ReqOuterClass.SessionInfoResponse> getSessionInfo(ReqOuterClass.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReqGrpc.getGetSessionInfoMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqImplBase.class */
    public static abstract class ReqImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ReqGrpc.getServiceDescriptor()).addMethod(ReqGrpc.getGetSessionInfoMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(ReqGrpc.getDelBurnMsgMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).build();
        }

        public void delBurnMsg(ReqOuterClass.Request request, StreamObserver<ReqOuterClass.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReqGrpc.getDelBurnMsgMethod(), streamObserver);
        }

        public void getSessionInfo(ReqOuterClass.Request request, StreamObserver<ReqOuterClass.SessionInfoResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(ReqGrpc.getGetSessionInfoMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqMethodDescriptorSupplier.class */
    public static final class ReqMethodDescriptorSupplier extends ReqBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        ReqMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqGrpc$ReqStub.class */
    public static final class ReqStub extends AbstractAsyncStub<ReqStub> {
        private ReqStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: build */
        public ReqStub m2519build(Channel channel, CallOptions callOptions) {
            return new ReqStub(channel, callOptions);
        }

        public void delBurnMsg(ReqOuterClass.Request request, StreamObserver<ReqOuterClass.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReqGrpc.getDelBurnMsgMethod(), getCallOptions()), request, streamObserver);
        }

        public void getSessionInfo(ReqOuterClass.Request request, StreamObserver<ReqOuterClass.SessionInfoResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReqGrpc.getGetSessionInfoMethod(), getCallOptions()), request, streamObserver);
        }
    }

    private ReqGrpc() {
    }

    public static MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.Response> getDelBurnMsgMethod() {
        MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.Response> methodDescriptor;
        MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.Response> methodDescriptor2 = getDelBurnMsgMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReqGrpc.class) {
                try {
                    MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.Response> methodDescriptor3 = getDelBurnMsgMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DelBurnMsg")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReqOuterClass.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReqOuterClass.Response.getDefaultInstance())).setSchemaDescriptor(new ReqMethodDescriptorSupplier("DelBurnMsg")).build();
                        getDelBurnMsgMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.SessionInfoResponse> getGetSessionInfoMethod() {
        MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.SessionInfoResponse> methodDescriptor;
        MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.SessionInfoResponse> methodDescriptor2 = getGetSessionInfoMethod;
        if (methodDescriptor2 == null) {
            synchronized (ReqGrpc.class) {
                try {
                    MethodDescriptor<ReqOuterClass.Request, ReqOuterClass.SessionInfoResponse> methodDescriptor3 = getGetSessionInfoMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "GetSessionInfo")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(ReqOuterClass.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(ReqOuterClass.SessionInfoResponse.getDefaultInstance())).setSchemaDescriptor(new ReqMethodDescriptorSupplier("GetSessionInfo")).build();
                        getGetSessionInfoMethod = methodDescriptor;
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
            synchronized (ReqGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new ReqFileDescriptorSupplier()).addMethod(getGetSessionInfoMethod()).addMethod(getDelBurnMsgMethod()).build();
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

    public static ReqBlockingStub newBlockingStub(Channel channel) {
        return ReqBlockingStub.newStub(new AbstractStub.StubFactory<ReqBlockingStub>() { // from class: com.blued.im.req.ReqGrpc.2
            /* renamed from: newStub */
            public ReqBlockingStub m2515newStub(Channel channel2, CallOptions callOptions) {
                return new ReqBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReqFutureStub newFutureStub(Channel channel) {
        return ReqFutureStub.newStub(new AbstractStub.StubFactory<ReqFutureStub>() { // from class: com.blued.im.req.ReqGrpc.3
            /* renamed from: newStub */
            public ReqFutureStub m2516newStub(Channel channel2, CallOptions callOptions) {
                return new ReqFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReqStub newStub(Channel channel) {
        return ReqStub.newStub(new AbstractStub.StubFactory<ReqStub>() { // from class: com.blued.im.req.ReqGrpc.1
            /* renamed from: newStub */
            public ReqStub m2514newStub(Channel channel2, CallOptions callOptions) {
                return new ReqStub(channel2, callOptions);
            }
        }, channel);
    }
}
