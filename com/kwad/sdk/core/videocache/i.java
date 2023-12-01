package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ao;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/i.class */
final class i extends ProxySelector {
    private static final List<Proxy> anV = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector anW;
    private final String anX;
    private final int anY;

    private i(ProxySelector proxySelector, String str, int i) {
        this.anW = (ProxySelector) ao.checkNotNull(proxySelector);
        this.anX = ao.eK(str);
        this.anY = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.anW.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.anX.equals(uri.getHost()) && this.anY == uri.getPort() ? anV : this.anW.select(uri);
    }
}
