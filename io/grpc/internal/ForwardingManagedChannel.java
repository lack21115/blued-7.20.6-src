package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ForwardingManagedChannel.class */
abstract class ForwardingManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForwardingManagedChannel(ManagedChannel managedChannel) {
        this.delegate = managedChannel;
    }

    public String authority() {
        return this.delegate.authority();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public void enterIdle() {
        this.delegate.enterIdle();
    }

    public ConnectivityState getState(boolean z) {
        return this.delegate.getState(z);
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return this.delegate.newCall(methodDescriptor, callOptions);
    }

    public void notifyWhenStateChanged(ConnectivityState connectivityState, Runnable runnable) {
        this.delegate.notifyWhenStateChanged(connectivityState, runnable);
    }

    public void resetConnectBackoff() {
        this.delegate.resetConnectBackoff();
    }

    public ManagedChannel shutdown() {
        return this.delegate.shutdown();
    }

    public ManagedChannel shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }
}
