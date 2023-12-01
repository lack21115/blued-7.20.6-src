package com.squareup.okhttp;

import com.blued.das.live.LiveProtos;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Route.class */
public final class Route {
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.address = address;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Route) {
            Route route = (Route) obj;
            z = false;
            if (this.address.equals(route.address)) {
                z = false;
                if (this.proxy.equals(route.proxy)) {
                    z = false;
                    if (this.inetSocketAddress.equals(route.inetSocketAddress)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public Address getAddress() {
        return this.address;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public InetSocketAddress getSocketAddress() {
        return this.inetSocketAddress;
    }

    public int hashCode() {
        return ((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }
}
