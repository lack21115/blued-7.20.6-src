package io.grpc;

import io.grpc.Context;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Server.class */
public abstract class Server {
    static final Context.Key<Server> SERVER_CONTEXT_KEY = Context.key("io.grpc.Server");

    public abstract void awaitTermination() throws InterruptedException;

    public abstract boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException;

    public List<ServerServiceDefinition> getImmutableServices() {
        return Collections.emptyList();
    }

    public List<? extends SocketAddress> getListenSockets() {
        throw new UnsupportedOperationException();
    }

    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.emptyList();
    }

    public int getPort() {
        return -1;
    }

    public List<ServerServiceDefinition> getServices() {
        return Collections.emptyList();
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    public abstract Server shutdown();

    public abstract Server shutdownNow();

    public abstract Server start() throws IOException;
}
