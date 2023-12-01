package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/RouteSelector.class */
public final class RouteSelector {

    /* renamed from: a  reason: collision with root package name */
    private final Address f22249a;
    private final RouteDatabase b;

    /* renamed from: c  reason: collision with root package name */
    private final Call f22250c;
    private final EventListener d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<Route> h = new ArrayList();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/RouteSelector$Selection.class */
    public static final class Selection {

        /* renamed from: a  reason: collision with root package name */
        private final List<Route> f22251a;
        private int b = 0;

        Selection(List<Route> list) {
            this.f22251a = list;
        }

        public List<Route> getAll() {
            return new ArrayList(this.f22251a);
        }

        public boolean hasNext() {
            return this.b < this.f22251a.size();
        }

        public Route next() {
            if (hasNext()) {
                List<Route> list = this.f22251a;
                int i = this.b;
                this.b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f22249a = address;
        this.b = routeDatabase;
        this.f22250c = call;
        this.d = eventListener;
        a(address.url(), address.proxy());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> immutableList;
        if (proxy != null) {
            immutableList = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f22249a.proxySelector().select(httpUrl.uri());
            immutableList = (select == null || select.isEmpty()) ? Util.immutableList(Proxy.NO_PROXY) : Util.immutableList(select);
        }
        this.e = immutableList;
        this.f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String host;
        int port;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.f22249a.url().host();
            port = this.f22249a.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            host = a(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (port < 1 || port > 65535) {
            throw new SocketException("No route to " + host + ":" + port + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(host, port));
        } else {
            this.d.dnsStart(this.f22250c, host);
            List<InetAddress> lookup = this.f22249a.dns().lookup(host);
            if (lookup.isEmpty()) {
                throw new UnknownHostException(this.f22249a.dns() + " returned no addresses for " + host);
            }
            this.d.dnsEnd(this.f22250c, host, lookup);
            int size = lookup.size();
            for (int i = 0; i < size; i++) {
                this.g.add(new InetSocketAddress(lookup.get(i), port));
            }
        }
    }

    private boolean a() {
        return this.f < this.e.size();
    }

    private Proxy b() throws IOException {
        if (a()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f22249a.url().host() + "; exhausted proxy configurations: " + this.e);
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.f22249a.proxySelector() != null) {
            this.f22249a.proxySelector().connectFailed(this.f22249a.url().uri(), route.proxy().address(), iOException);
        }
        this.b.failed(route);
    }

    public boolean hasNext() {
        return a() || !this.h.isEmpty();
    }

    public Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (a()) {
                Proxy b = b();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    Route route = new Route(this.f22249a, b, this.g.get(i));
                    if (this.b.shouldPostpone(route)) {
                        this.h.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
