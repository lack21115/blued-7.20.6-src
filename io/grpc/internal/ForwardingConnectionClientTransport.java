package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ManagedClientTransport;
import java.util.concurrent.Executor;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ForwardingConnectionClientTransport.class */
abstract class ForwardingConnectionClientTransport implements ConnectionClientTransport {
    protected abstract ConnectionClientTransport delegate();

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return delegate().getLogId();
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        return delegate().getStats();
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        return delegate().newStream(methodDescriptor, metadata, callOptions);
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        delegate().ping(pingCallback, executor);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdown(Status status) {
        delegate().shutdown(status);
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdownNow(Status status) {
        delegate().shutdownNow(status);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public Runnable start(ManagedClientTransport.Listener listener) {
        return delegate().start(listener);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
