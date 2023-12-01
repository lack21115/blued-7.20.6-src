package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.anythink.expressad.foundation.g.f.g.c;
import com.google.common.net.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionSpec;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Handshake;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Version;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Codec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.OkHostnameVerifier;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/RealConnection.class */
public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35935a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f35936c = 1;
    public final List<Reference<StreamAllocation>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final ConnectionPool g;
    private final Route h;
    private Socket i;
    private Socket j;
    private Handshake k;
    private Protocol l;
    private Http2Connection m;
    private BufferedSource n;
    private BufferedSink o;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.g = connectionPool;
        this.h = route;
    }

    private Request a() throws IOException {
        Request build = new Request.Builder().url(this.h.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.h.address().url(), true)).header("Proxy-Connection", c.f7906c).header("User-Agent", Version.userAgent()).build();
        Request authenticate = this.h.address().proxyAuthenticator().authenticate(this.h, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.f35905c).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
        if (authenticate != null) {
            build = authenticate;
        }
        return build;
    }

    private Request a(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        Response build;
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        do {
            Http1Codec http1Codec = new Http1Codec(null, null, this.n, this.o);
            this.n.timeout().timeout(i, TimeUnit.MILLISECONDS);
            this.o.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders.contentLength(build);
            long j = contentLength;
            if (contentLength == -1) {
                j = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(j);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code == 200) {
                if (this.n.buffer().exhausted() && this.o.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            } else {
                request = this.h.address().proxyAuthenticator().authenticate(this.h, build);
                if (request == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
            }
        } while (!"close".equalsIgnoreCase(build.header("Connection")));
        return request;
    }

    private void a(int i) throws IOException {
        this.j.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.j, this.h.address().url().host(), this.n, this.o).listener(this).pingIntervalMillis(i).build();
        this.m = build;
        build.start();
    }

    private void a(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request a2 = a();
        HttpUrl url = a2.url();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 21) {
                return;
            }
            a(i, i2, call, eventListener);
            a2 = a(i2, i3, a2, url);
            if (a2 == null) {
                return;
            }
            Util.closeQuietly(this.i);
            this.i = null;
            this.o = null;
            this.n = null;
            eventListener.connectEnd(call, this.h.socketAddress(), this.h.proxy(), null);
            i4 = i5 + 1;
        }
    }

    private void a(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Proxy proxy = this.h.proxy();
        this.i = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.h.address().socketFactory().createSocket() : new Socket(proxy);
        eventListener.connectStart(call, this.h.socketAddress(), proxy);
        this.i.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.i, this.h.socketAddress(), i);
            try {
                this.n = Okio.buffer(Okio.source(this.i));
                this.o = Okio.buffer(Okio.sink(this.i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        SSLSocket sSLSocket;
        Address address = this.h.address();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                SSLSocket sSLSocket3 = (SSLSocket) address.sslSocketFactory().createSocket(this.i, address.url().host(), address.url().port(), true);
                try {
                    ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket3);
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        Platform.get().configureTlsExtensions(sSLSocket3, address.url().host(), address.protocols());
                    }
                    sSLSocket3.startHandshake();
                    SSLSession session = sSLSocket3.getSession();
                    Handshake handshake = Handshake.get(session);
                    if (!address.hostnameVerifier().verify(address.url().host(), session)) {
                        X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                    }
                    address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                    String str = null;
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(sSLSocket3);
                    }
                    this.j = sSLSocket3;
                    this.n = Okio.buffer(Okio.source(sSLSocket3));
                    this.o = Okio.buffer(Okio.sink(this.j));
                    this.k = handshake;
                    this.l = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                    if (sSLSocket3 != null) {
                        Platform.get().afterHandshake(sSLSocket3);
                    }
                } catch (AssertionError e) {
                    sSLSocket = sSLSocket3;
                    e = e;
                    if (Util.isAndroidGetsocknameError(e)) {
                        SSLSocket sSLSocket4 = sSLSocket;
                        throw new IOException(e);
                    } else {
                        SSLSocket sSLSocket5 = sSLSocket;
                        throw e;
                    }
                } catch (Throwable th) {
                    th = th;
                    sSLSocket2 = sSLSocket3;
                    if (sSLSocket2 != null) {
                        Platform.get().afterHandshake(sSLSocket2);
                    }
                    Util.closeQuietly((Socket) sSLSocket2);
                    throw th;
                }
            } catch (AssertionError e2) {
                e = e2;
                sSLSocket = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.h.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            a(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.k);
            if (this.l == Protocol.HTTP_2) {
                a(i);
            }
        } else if (!this.h.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.j = this.i;
            this.l = Protocol.HTTP_1_1;
        } else {
            this.j = this.i;
            this.l = Protocol.H2_PRIOR_KNOWLEDGE;
            a(i);
        }
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.j = socket;
        realConnection.e = j;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.i);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0 A[Catch: IOException -> 0x0163, TRY_LEAVE, TryCatch #2 {IOException -> 0x0163, blocks: (B:18:0x00b6, B:20:0x00c0), top: B:72:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01da A[EDGE_INSN: B:77:0x01da->B:62:0x01da ?: BREAK  ] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(int r8, int r9, int r10, int r11, boolean r12, com.tencent.cloud.huiyansdkface.okhttp3.Call r13, com.tencent.cloud.huiyansdkface.okhttp3.EventListener r14) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, com.tencent.cloud.huiyansdkface.okhttp3.Call, com.tencent.cloud.huiyansdkface.okhttp3.EventListener):void");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Handshake handshake() {
        return this.k;
    }

    public boolean isEligible(Address address, Route route) {
        if (this.d.size() >= this.f35936c || this.f35935a || !Internal.f35902a.equalsNonHost(this.h.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.m != null && route != null && route.proxy().type() == Proxy.Type.DIRECT && this.h.proxy().type() == Proxy.Type.DIRECT && this.h.socketAddress().equals(route.socketAddress()) && route.address().hostnameVerifier() == OkHostnameVerifier.f36034a && supportsUrl(address.url())) {
            try {
                address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean isHealthy(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.m;
        if (http2Connection != null) {
            return !http2Connection.isShutdown();
        }
        if (z) {
            try {
                int soTimeout = this.j.getSoTimeout();
                try {
                    this.j.setSoTimeout(1);
                    if (this.n.exhausted()) {
                        this.j.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.j.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.j.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException e) {
                return true;
            } catch (IOException e2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.m != null;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        if (this.m != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, this.m);
        }
        this.j.setSoTimeout(chain.readTimeoutMillis());
        this.n.timeout().timeout(chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.o.timeout().timeout(chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.n, this.o);
    }

    public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation streamAllocation) {
        return new RealWebSocket.Streams(true, this.n, this.o) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                StreamAllocation streamAllocation2 = streamAllocation;
                streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1L, null);
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.g) {
            this.f35936c = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Protocol protocol() {
        return this.l;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Route route() {
        return this.h;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Connection
    public Socket socket() {
        return this.j;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.h.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.h.address().url().host())) {
            return true;
        }
        boolean z = false;
        if (this.k != null) {
            z = false;
            if (OkHostnameVerifier.f36034a.verify(httpUrl.host(), (X509Certificate) this.k.peerCertificates().get(0))) {
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.h.address().url().host());
        sb.append(":");
        sb.append(this.h.address().url().port());
        sb.append(", proxy=");
        sb.append(this.h.proxy());
        sb.append(" hostAddress=");
        sb.append(this.h.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.k;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }
}
