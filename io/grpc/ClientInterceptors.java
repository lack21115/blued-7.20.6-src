package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientInterceptors.class */
public class ClientInterceptors {
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.ClientInterceptors.2
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.ClientInterceptors$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientInterceptors$1.class */
    public class AnonymousClass1 implements ClientInterceptor {
        final /* synthetic */ ClientInterceptor val$interceptor;
        final /* synthetic */ MethodDescriptor.Marshaller val$reqMarshaller;
        final /* synthetic */ MethodDescriptor.Marshaller val$respMarshaller;

        AnonymousClass1(MethodDescriptor.Marshaller marshaller, MethodDescriptor.Marshaller marshaller2, ClientInterceptor clientInterceptor) {
            this.val$reqMarshaller = marshaller;
            this.val$respMarshaller = marshaller2;
            this.val$interceptor = clientInterceptor;
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCall<ReqT, RespT> interceptCall = this.val$interceptor.interceptCall(methodDescriptor.toBuilder(this.val$reqMarshaller, this.val$respMarshaller).build(), callOptions, channel);
            return new PartialForwardingClientCall<ReqT, RespT>() { // from class: io.grpc.ClientInterceptors.1.1
                @Override // io.grpc.PartialForwardingClientCall
                protected ClientCall<?, ?> delegate() {
                    return interceptCall;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.ClientCall
                public void sendMessage(ReqT reqt) {
                    interceptCall.sendMessage(AnonymousClass1.this.val$reqMarshaller.parse(methodDescriptor.getRequestMarshaller().stream(reqt)));
                }

                @Override // io.grpc.ClientCall
                public void start(final ClientCall.Listener<RespT> listener, Metadata metadata) {
                    interceptCall.start(new PartialForwardingClientCallListener<WRespT>() { // from class: io.grpc.ClientInterceptors.1.1.1
                        @Override // io.grpc.PartialForwardingClientCallListener
                        protected ClientCall.Listener<?> delegate() {
                            return listener;
                        }

                        @Override // io.grpc.ClientCall.Listener
                        public void onMessage(WRespT wrespt) {
                            listener.onMessage(methodDescriptor.getResponseMarshaller().parse(AnonymousClass1.this.val$respMarshaller.stream(wrespt)));
                        }
                    }, metadata);
                }
            };
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientInterceptors$CheckedForwardingClientCall.class */
    public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private ClientCall<ReqT, RespT> delegate;

        protected CheckedForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        protected abstract void checkedStart(ClientCall.Listener<RespT> listener, Metadata metadata) throws Exception;

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        protected final ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public final void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
            try {
                checkedStart(listener, metadata);
            } catch (Exception e) {
                this.delegate = ClientInterceptors.NOOP_CALL;
                listener.onClose(Status.fromThrowable(e), new Metadata());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientInterceptors$InterceptorChannel.class */
    public static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        private InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor) {
            this.channel = channel;
            this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
        }

        /* synthetic */ InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor, AnonymousClass1 anonymousClass1) {
            this(channel, clientInterceptor);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return this.interceptor.interceptCall(methodDescriptor, callOptions, this.channel);
        }
    }

    private ClientInterceptors() {
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> list) {
        Preconditions.checkNotNull(channel, "channel");
        for (ClientInterceptor clientInterceptor : list) {
            channel = new InterceptorChannel(channel, clientInterceptor, null);
        }
        return channel;
    }

    public static Channel intercept(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return intercept(channel, Arrays.asList(clientInterceptorArr));
    }

    public static Channel interceptForward(Channel channel, List<? extends ClientInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(channel, arrayList);
    }

    public static Channel interceptForward(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return interceptForward(channel, Arrays.asList(clientInterceptorArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <WReqT, WRespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor clientInterceptor, MethodDescriptor.Marshaller<WReqT> marshaller, MethodDescriptor.Marshaller<WRespT> marshaller2) {
        return new AnonymousClass1(marshaller, marshaller2, clientInterceptor);
    }
}
