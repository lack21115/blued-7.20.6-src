package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ForwardingNameResolver.class */
abstract class ForwardingNameResolver extends NameResolver {
    private final NameResolver delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForwardingNameResolver(NameResolver nameResolver) {
        Preconditions.checkNotNull(nameResolver, "delegate can not be null");
        this.delegate = nameResolver;
    }

    public String getServiceAuthority() {
        return this.delegate.getServiceAuthority();
    }

    public void refresh() {
        this.delegate.refresh();
    }

    public void shutdown() {
        this.delegate.shutdown();
    }

    public void start(NameResolver.Listener2 listener2) {
        this.delegate.start(listener2);
    }

    @Deprecated
    public void start(NameResolver.Listener listener) {
        this.delegate.start(listener);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }
}
