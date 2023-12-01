package com.tencent.cloud.huiyansdkface.okhttp3;

import com.alipay.sdk.util.i;
import com.blued.das.live.LiveProtos;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Route.class */
public final class Route {

    /* renamed from: a  reason: collision with root package name */
    final Address f35898a;
    final Proxy b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f35899c;

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
        this.f35898a = address;
        this.b = proxy;
        this.f35899c = inetSocketAddress;
    }

    public Address address() {
        return this.f35898a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.f35898a.equals(this.f35898a) && route.b.equals(this.b) && route.f35899c.equals(this.f35899c);
        }
        return false;
    }

    public int hashCode() {
        return ((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.f35898a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f35899c.hashCode();
    }

    public Proxy proxy() {
        return this.b;
    }

    public boolean requiresTunnel() {
        return this.f35898a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress socketAddress() {
        return this.f35899c;
    }

    public String toString() {
        return "Route{" + this.f35899c + i.d;
    }
}
