package com.opos.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/p.class */
class p extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Proxy> f13767a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13768c;
    private final int d;

    p(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) f.a(proxySelector);
        this.f13768c = (String) f.a(str);
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i) {
        ProxySelector.setDefault(new p(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f13768c.equals(uri.getHost()) && this.d == uri.getPort() ? f13767a : this.b.select(uri);
    }
}
