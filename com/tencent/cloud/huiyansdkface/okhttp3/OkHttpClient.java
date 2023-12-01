package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.WebSocket;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteDatabase;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.proxy.NullProxySelector;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.OkHostnameVerifier;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/OkHttpClient.class */
public class OkHttpClient implements Call.Factory, WebSocket.Factory, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final List<Protocol> f22179a = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<ConnectionSpec> b = Util.immutableList(ConnectionSpec.b, ConnectionSpec.d);
    final int A;
    final int B;
    final int C;
    final int D;

    /* renamed from: c  reason: collision with root package name */
    final Dispatcher f22180c;
    final Proxy d;
    final List<Protocol> e;
    final List<ConnectionSpec> f;
    final List<Interceptor> g;
    final List<Interceptor> h;
    final EventListener.Factory i;
    final ProxySelector j;
    final CookieJar k;
    final Cache l;
    final InternalCache m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final CertificateChainCleaner p;
    final HostnameVerifier q;
    final CertificatePinner r;
    final Authenticator s;
    final Authenticator t;
    final ConnectionPool u;
    final Dns v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/OkHttpClient$Builder.class */
    public static final class Builder {
        int A;
        int B;

        /* renamed from: a  reason: collision with root package name */
        Dispatcher f22181a;
        Proxy b;

        /* renamed from: c  reason: collision with root package name */
        List<Protocol> f22182c;
        List<ConnectionSpec> d;
        final List<Interceptor> e;
        final List<Interceptor> f;
        EventListener.Factory g;
        ProxySelector h;
        CookieJar i;
        Cache j;
        InternalCache k;
        SocketFactory l;
        SSLSocketFactory m;
        CertificateChainCleaner n;
        HostnameVerifier o;
        CertificatePinner p;
        Authenticator q;
        Authenticator r;
        ConnectionPool s;
        Dns t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public Builder() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f22181a = new Dispatcher();
            this.f22182c = OkHttpClient.f22179a;
            this.d = OkHttpClient.b;
            this.g = EventListener.a(EventListener.f22158a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new NullProxySelector();
            }
            this.i = CookieJar.f22154a;
            this.l = SocketFactory.getDefault();
            this.o = OkHostnameVerifier.f22343a;
            this.p = CertificatePinner.f22134a;
            this.q = Authenticator.f22115a;
            this.r = Authenticator.f22115a;
            this.s = new ConnectionPool();
            this.t = Dns.f22157a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        Builder(OkHttpClient okHttpClient) {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f22181a = okHttpClient.f22180c;
            this.b = okHttpClient.d;
            this.f22182c = okHttpClient.e;
            this.d = okHttpClient.f;
            this.e.addAll(okHttpClient.g);
            this.f.addAll(okHttpClient.h);
            this.g = okHttpClient.i;
            this.h = okHttpClient.j;
            this.i = okHttpClient.k;
            this.k = okHttpClient.m;
            this.j = okHttpClient.l;
            this.l = okHttpClient.n;
            this.m = okHttpClient.o;
            this.n = okHttpClient.p;
            this.o = okHttpClient.q;
            this.p = okHttpClient.r;
            this.q = okHttpClient.s;
            this.r = okHttpClient.t;
            this.s = okHttpClient.u;
            this.t = okHttpClient.v;
            this.u = okHttpClient.w;
            this.v = okHttpClient.x;
            this.w = okHttpClient.y;
            this.x = okHttpClient.z;
            this.y = okHttpClient.A;
            this.z = okHttpClient.B;
            this.A = okHttpClient.C;
            this.B = okHttpClient.D;
        }

        void a(InternalCache internalCache) {
            this.k = internalCache;
            this.j = null;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.f.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator != null) {
                this.r = authenticator;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder cache(Cache cache) {
            this.j = cache;
            this.k = null;
            return this;
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.x = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder callTimeout(Duration duration) {
            this.x = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner != null) {
                this.p = certificatePinner;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.y = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder connectTimeout(Duration duration) {
            this.y = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool != null) {
                this.s = connectionPool;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.d = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar != null) {
                this.i = cookieJar;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher != null) {
                this.f22181a = dispatcher;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns dns) {
            if (dns != null) {
                this.t = dns;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener != null) {
                this.g = EventListener.a(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory != null) {
                this.g = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder followRedirects(boolean z) {
            this.v = z;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.u = z;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public List<Interceptor> interceptors() {
            return this.e;
        }

        public List<Interceptor> networkInterceptors() {
            return this.f;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.B = Util.checkDuration(bh.aX, j, timeUnit);
            return this;
        }

        public Builder pingInterval(Duration duration) {
            this.B = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            } else {
                arrayList.remove(Protocol.SPDY_3);
                this.f22182c = Collections.unmodifiableList(arrayList);
                return this;
            }
        }

        public Builder proxy(Proxy proxy) {
            this.b = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator != null) {
                this.q = authenticator;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            if (proxySelector != null) {
                this.h = proxySelector;
                return this;
            }
            throw new NullPointerException("proxySelector == null");
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.z = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(Duration duration) {
            this.z = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.w = z;
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory != null) {
                this.l = socketFactory;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.m = sSLSocketFactory;
                this.n = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory != null) {
                if (x509TrustManager != null) {
                    this.m = sSLSocketFactory;
                    this.n = CertificateChainCleaner.get(x509TrustManager);
                    return this;
                }
                throw new NullPointerException("trustManager == null");
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.A = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(Duration duration) {
            this.A = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    static {
        Internal.f22211a = new Internal() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                builder.a(str);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.a(str, str2);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.a(sSLSocket, z);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public int code(Response.Builder builder) {
                return builder.f22201c;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.b(realConnection);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.a(address, streamAllocation);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public boolean equalsNonHost(Address address, Address address2) {
                return address.a(address2);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.a(address, streamAllocation, route);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.a(okHttpClient, request, true);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.a(realConnection);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f22144a;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public void setCache(Builder builder, InternalCache internalCache) {
                builder.a(internalCache);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).a();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal
            public IOException timeoutExit(Call call, IOException iOException) {
                return ((RealCall) call).a(iOException);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        boolean z;
        boolean z2;
        CertificateChainCleaner certificateChainCleaner;
        this.f22180c = builder.f22181a;
        this.d = builder.b;
        this.e = builder.f22182c;
        this.f = builder.d;
        this.g = Util.immutableList(builder.e);
        this.h = Util.immutableList(builder.f);
        this.i = builder.g;
        this.j = builder.h;
        this.k = builder.i;
        this.l = builder.j;
        this.m = builder.k;
        this.n = builder.l;
        Iterator<ConnectionSpec> it = this.f.iterator();
        loop0: while (true) {
            while (true) {
                z2 = z;
                if (!it.hasNext()) {
                    break loop0;
                }
                z = z2 || it.next().isTls();
            }
        }
        if (builder.m == null && z2) {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.o = a(platformTrustManager);
            certificateChainCleaner = CertificateChainCleaner.get(platformTrustManager);
        } else {
            this.o = builder.m;
            certificateChainCleaner = builder.n;
        }
        this.p = certificateChainCleaner;
        if (this.o != null) {
            Platform.get().configureSslSocketFactory(this.o);
        }
        this.q = builder.o;
        this.r = builder.p.a(this.p);
        this.s = builder.q;
        this.t = builder.r;
        this.u = builder.s;
        this.v = builder.t;
        this.w = builder.u;
        this.x = builder.v;
        this.y = builder.w;
        this.z = builder.x;
        this.A = builder.y;
        this.B = builder.z;
        this.C = builder.A;
        this.D = builder.B;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        } else if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw Util.assertionError("No System TLS", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalCache a() {
        Cache cache = this.l;
        return cache != null ? cache.f22116a : this.m;
    }

    public Authenticator authenticator() {
        return this.t;
    }

    public Cache cache() {
        return this.l;
    }

    public int callTimeoutMillis() {
        return this.z;
    }

    public CertificatePinner certificatePinner() {
        return this.r;
    }

    public int connectTimeoutMillis() {
        return this.A;
    }

    public ConnectionPool connectionPool() {
        return this.u;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f;
    }

    public CookieJar cookieJar() {
        return this.k;
    }

    public Dispatcher dispatcher() {
        return this.f22180c;
    }

    public Dns dns() {
        return this.v;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.i;
    }

    public boolean followRedirects() {
        return this.x;
    }

    public boolean followSslRedirects() {
        return this.w;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.q;
    }

    public List<Interceptor> interceptors() {
        return this.g;
    }

    public List<Interceptor> networkInterceptors() {
        return this.h;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call.Factory
    public Call newCall(Request request) {
        return RealCall.a(this, request, false);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), this.D);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.D;
    }

    public List<Protocol> protocols() {
        return this.e;
    }

    public Proxy proxy() {
        return this.d;
    }

    public Authenticator proxyAuthenticator() {
        return this.s;
    }

    public ProxySelector proxySelector() {
        return this.j;
    }

    public int readTimeoutMillis() {
        return this.B;
    }

    public boolean retryOnConnectionFailure() {
        return this.y;
    }

    public SocketFactory socketFactory() {
        return this.n;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.o;
    }

    public int writeTimeoutMillis() {
        return this.C;
    }
}
