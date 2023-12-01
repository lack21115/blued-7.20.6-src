package io.grpc.internal;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import io.grpc.InternalServiceProviders;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import java.net.URI;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/DnsNameResolverProvider.class */
public final class DnsNameResolverProvider extends NameResolverProvider {
    private static final String SCHEME = "dns";

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return SCHEME;
    }

    @Override // io.grpc.NameResolverProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.NameResolver.Factory
    public DnsNameResolver newNameResolver(URI uri, NameResolver.Args args) {
        if (SCHEME.equals(uri.getScheme())) {
            String str = (String) Preconditions.checkNotNull(uri.getPath(), "targetPath");
            Preconditions.checkArgument(str.startsWith(BridgeUtil.SPLIT_MARK), "the path component (%s) of the target (%s) must start with '/'", str, uri);
            return new DnsNameResolver(uri.getAuthority(), str.substring(1), args, GrpcUtil.SHARED_CHANNEL_EXECUTOR, Stopwatch.createUnstarted(), InternalServiceProviders.isAndroid(getClass().getClassLoader()));
        }
        return null;
    }

    @Override // io.grpc.NameResolverProvider
    public int priority() {
        return 5;
    }
}
