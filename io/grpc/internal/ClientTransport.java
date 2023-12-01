package io.grpc.internal;

import io.grpc.CallOptions;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.concurrent.Executor;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientTransport.class */
public interface ClientTransport extends InternalInstrumented<InternalChannelz.SocketStats> {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ClientTransport$PingCallback.class */
    public interface PingCallback {
        void onFailure(Throwable th);

        void onSuccess(long j);
    }

    ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions);

    void ping(PingCallback pingCallback, Executor executor);
}
