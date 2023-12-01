package io.grpc.internal;

import io.grpc.NameResolver;
import java.net.URI;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/OverrideAuthorityNameResolverFactory.class */
final class OverrideAuthorityNameResolverFactory extends NameResolver.Factory {
    private final String authorityOverride;
    private final NameResolver.Factory delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OverrideAuthorityNameResolverFactory(NameResolver.Factory factory, String str) {
        this.delegate = factory;
        this.authorityOverride = str;
    }

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return this.delegate.getDefaultScheme();
    }

    @Override // io.grpc.NameResolver.Factory
    @Nullable
    public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
        NameResolver newNameResolver = this.delegate.newNameResolver(uri, args);
        if (newNameResolver == null) {
            return null;
        }
        return new ForwardingNameResolver(newNameResolver) { // from class: io.grpc.internal.OverrideAuthorityNameResolverFactory.1
            @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
            public String getServiceAuthority() {
                return OverrideAuthorityNameResolverFactory.this.authorityOverride;
            }
        };
    }
}
