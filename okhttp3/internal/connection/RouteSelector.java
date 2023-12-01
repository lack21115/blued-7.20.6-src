package okhttp3.internal.connection;

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
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RouteSelector.class */
public final class RouteSelector {
    private final Address a;
    private final RouteDatabase b;
    private final Call c;
    private final EventListener d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<Route> h = new ArrayList();

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RouteSelector$Selection.class */
    public static final class Selection {
        private final List<Route> a;
        private int b = 0;

        Selection(List<Route> list) {
            this.a = list;
        }

        public boolean a() {
            return this.b < this.a.size();
        }

        public Route b() {
            if (a()) {
                List<Route> list = this.a;
                int i = this.b;
                this.b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<Route> c() {
            return new ArrayList(this.a);
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.a = address;
        this.b = routeDatabase;
        this.c = call;
        this.d = eventListener;
        a(address.url(), address.proxy());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(Proxy proxy) throws IOException {
        String host;
        int port;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.a.url().host();
            port = this.a.url().port();
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
            this.d.dnsStart(this.c, host);
            List<InetAddress> lookup = this.a.dns().lookup(host);
            if (lookup.isEmpty()) {
                throw new UnknownHostException(this.a.dns() + " returned no addresses for " + host);
            }
            this.d.dnsEnd(this.c, host, lookup);
            int size = lookup.size();
            for (int i = 0; i < size; i++) {
                this.g.add(new InetSocketAddress(lookup.get(i), port));
            }
        }
    }

    private void a(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.a.proxySelector().select(httpUrl.uri());
            this.e = (select == null || select.isEmpty()) ? Util.a(Proxy.NO_PROXY) : Util.a(select);
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.url().host() + "; exhausted proxy configurations: " + this.e);
    }

    public void a(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.a.proxySelector() != null) {
            this.a.proxySelector().connectFailed(this.a.url().uri(), route.proxy().address(), iOException);
        }
        this.b.a(route);
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public Selection b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d = d();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    Route route = new Route(this.a, d, this.g.get(i));
                    if (this.b.c(route)) {
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
