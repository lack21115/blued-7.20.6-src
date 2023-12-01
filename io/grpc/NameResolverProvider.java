package io.grpc;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolverProvider.class */
public abstract class NameResolverProvider extends NameResolver.Factory {
    @Deprecated
    public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = NameResolver.Factory.PARAMS_DEFAULT_PORT;

    @Deprecated
    public static NameResolver.Factory asFactory() {
        return NameResolverRegistry.getDefaultRegistry().asFactory();
    }

    @Deprecated
    public static List<NameResolverProvider> providers() {
        return NameResolverRegistry.getDefaultRegistry().providers();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isAvailable();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int priority();
}
