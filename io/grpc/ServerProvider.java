package io.grpc;

import io.grpc.ManagedChannelProvider;
import io.grpc.ServiceProviders;
import java.util.Collections;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServerProvider.class */
public abstract class ServerProvider {
    private static final ServerProvider provider = (ServerProvider) ServiceProviders.load(ServerProvider.class, Collections.emptyList(), ServerProvider.class.getClassLoader(), new ServiceProviders.PriorityAccessor<ServerProvider>() { // from class: io.grpc.ServerProvider.1
        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ServerProvider serverProvider) {
            return serverProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ServerProvider serverProvider) {
            return serverProvider.isAvailable();
        }
    });

    public static ServerProvider provider() {
        ServerProvider serverProvider = provider;
        if (serverProvider != null) {
            return serverProvider;
        }
        throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ServerBuilder<?> builderForPort(int i);

    protected abstract boolean isAvailable();

    protected abstract int priority();
}
