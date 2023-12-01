package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerInterceptors.class */
public final class ServerInterceptors {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerInterceptors$InterceptCallHandler.class */
    public static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        private InterceptCallHandler(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            this.interceptor = (ServerInterceptor) Preconditions.checkNotNull(serverInterceptor, "interceptor");
            this.callHandler = serverCallHandler;
        }

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return new InterceptCallHandler<>(serverInterceptor, serverCallHandler);
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            return this.interceptor.interceptCall(serverCall, metadata, this.callHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerInterceptors$KnownLengthBufferedInputStream.class */
    public static final class KnownLengthBufferedInputStream extends BufferedInputStream implements KnownLength {
        KnownLengthBufferedInputStream(InputStream inputStream) {
            super(inputStream);
        }
    }

    private ServerInterceptors() {
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(serverServiceDefinition, "serviceDef");
        if (list.isEmpty()) {
            return serverServiceDefinition;
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(serverServiceDefinition.getServiceDescriptor());
        for (ServerMethodDefinition<?, ?> serverMethodDefinition : serverServiceDefinition.getMethods()) {
            wrapAndAddMethod(builder, serverMethodDefinition, list);
        }
        return builder.build();
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return intercept(serverServiceDefinition, Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> list) {
        return interceptForward(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(bindableService.bindService(), Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(serverServiceDefinition, arrayList);
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(serverServiceDefinition, Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serverServiceDefinition) {
        return useMarshalledMessages(serverServiceDefinition, new MethodDescriptor.Marshaller<InputStream>() { // from class: io.grpc.ServerInterceptors.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream parse(InputStream inputStream) {
                return inputStream.markSupported() ? inputStream : inputStream instanceof KnownLength ? new KnownLengthBufferedInputStream(inputStream) : new BufferedInputStream(inputStream);
            }

            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream stream(InputStream inputStream) {
                return inputStream;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<T> marshaller) {
        ArrayList<ServerMethodDefinition> arrayList = new ArrayList();
        ArrayList<MethodDescriptor<?, ?>> arrayList2 = new ArrayList();
        for (ServerMethodDefinition<?, ?> serverMethodDefinition : serverServiceDefinition.getMethods()) {
            MethodDescriptor build = serverMethodDefinition.getMethodDescriptor().toBuilder(marshaller, marshaller).build();
            arrayList2.add(build);
            arrayList.add(wrapMethod(serverMethodDefinition, build));
        }
        ServiceDescriptor.Builder schemaDescriptor = ServiceDescriptor.newBuilder(serverServiceDefinition.getServiceDescriptor().getName()).setSchemaDescriptor(serverServiceDefinition.getServiceDescriptor().getSchemaDescriptor());
        for (MethodDescriptor<?, ?> methodDescriptor : arrayList2) {
            schemaDescriptor.addMethod(methodDescriptor);
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(schemaDescriptor.build());
        for (ServerMethodDefinition serverMethodDefinition2 : arrayList) {
            builder.addMethod(serverMethodDefinition2);
        }
        return builder.build();
    }

    private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder builder, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, List<? extends ServerInterceptor> list) {
        ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
        Iterator<? extends ServerInterceptor> it = list.iterator();
        ServerCallHandler<ReqT, RespT> serverCallHandler2 = serverCallHandler;
        while (true) {
            ServerCallHandler<ReqT, RespT> serverCallHandler3 = serverCallHandler2;
            if (!it.hasNext()) {
                builder.addMethod(serverMethodDefinition.withServerCallHandler(serverCallHandler3));
                return;
            }
            serverCallHandler2 = InterceptCallHandler.create(it.next(), serverCallHandler3);
        }
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> serverCallHandler, final MethodDescriptor<OReqT, ORespT> methodDescriptor, final MethodDescriptor<WReqT, WRespT> methodDescriptor2) {
        return new ServerCallHandler<WReqT, WRespT>() { // from class: io.grpc.ServerInterceptors.2
            @Override // io.grpc.ServerCallHandler
            public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> serverCall, Metadata metadata) {
                final ServerCall.Listener startCall = serverCallHandler.startCall(new PartialForwardingServerCall<OReqT, ORespT>() { // from class: io.grpc.ServerInterceptors.2.1
                    @Override // io.grpc.PartialForwardingServerCall
                    protected ServerCall<WReqT, WRespT> delegate() {
                        return serverCall;
                    }

                    @Override // io.grpc.ServerCall
                    public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                        return MethodDescriptor.this;
                    }

                    @Override // io.grpc.ServerCall
                    public void sendMessage(ORespT orespt) {
                        delegate().sendMessage((WRespT) methodDescriptor2.parseResponse(MethodDescriptor.this.streamResponse(orespt)));
                    }
                }, metadata);
                return new PartialForwardingServerCallListener<WReqT>() { // from class: io.grpc.ServerInterceptors.2.2
                    @Override // io.grpc.PartialForwardingServerCallListener
                    protected ServerCall.Listener<OReqT> delegate() {
                        return startCall;
                    }

                    @Override // io.grpc.ServerCall.Listener
                    public void onMessage(WReqT wreqt) {
                        delegate().onMessage(MethodDescriptor.this.parseRequest(methodDescriptor2.streamRequest(wreqt)));
                    }
                };
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> serverMethodDefinition, MethodDescriptor<WReqT, WRespT> methodDescriptor) {
        return ServerMethodDefinition.create(methodDescriptor, wrapHandler(serverMethodDefinition.getServerCallHandler(), serverMethodDefinition.getMethodDescriptor(), methodDescriptor));
    }
}
