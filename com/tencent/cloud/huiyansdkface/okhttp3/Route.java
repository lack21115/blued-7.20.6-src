package com.tencent.cloud.huiyansdkface.okhttp3;

import com.blued.das.live.LiveProtos;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Route.class */
public final class Route {

    /* renamed from: a  reason: collision with root package name */
    final Address f22207a;
    final Proxy b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f22208c;

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
        this.f22207a = address;
        this.b = proxy;
        this.f22208c = inetSocketAddress;
    }

    public Address address() {
        return this.f22207a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.f22207a.equals(this.f22207a) && route.b.equals(this.b) && route.f22208c.equals(this.f22208c);
        }
        return false;
    }

    public int hashCode() {
        return ((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.f22207a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f22208c.hashCode();
    }

    public Proxy proxy() {
        return this.b;
    }

    public boolean requiresTunnel() {
        return this.f22207a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress socketAddress() {
        return this.f22208c;
    }

    public String toString() {
        return "Route{" + this.f22208c + "}";
    }
}
