package okhttp3.internal.connection;

import com.blued.android.module.common.web.LoaderConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/connection/RealConnection.class */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public boolean a;
    public int b;
    public int c = 1;
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

    private Request a(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        Response build;
        String str = "CONNECT " + Util.a(httpUrl, true) + " HTTP/1.1";
        do {
            Http1Codec http1Codec = new Http1Codec(null, null, this.n, this.o);
            this.n.timeout().timeout(i, TimeUnit.MILLISECONDS);
            this.o.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            http1Codec.a(request.headers(), str);
            http1Codec.b();
            build = http1Codec.a(false).request(request).build();
            long a = HttpHeaders.a(build);
            long j = a;
            if (a == -1) {
                j = 0;
            }
            Source b = http1Codec.b(j);
            Util.b(b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b.close();
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
        } while (!LoaderConstants.CLOSE.equalsIgnoreCase(build.header("Connection")));
        return request;
    }

    private void a(int i) throws IOException {
        this.j.setSoTimeout(0);
        Http2Connection a = new Http2Connection.Builder(true).a(this.j, this.h.address().url().host(), this.n, this.o).a(this).a(i).a();
        this.m = a;
        a.c();
    }

    private void a(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request c = c();
        HttpUrl url = c.url();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 21) {
                return;
            }
            a(i, i2, call, eventListener);
            c = a(i2, i3, c, url);
            if (c == null) {
                return;
            }
            Util.a(this.i);
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
            Platform.e().a(this.i, this.h.socketAddress(), i);
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
                    ConnectionSpec a = connectionSpecSelector.a(sSLSocket3);
                    if (a.supportsTlsExtensions()) {
                        Platform.e().a(sSLSocket3, address.url().host(), address.protocols());
                    }
                    sSLSocket3.startHandshake();
                    SSLSession session = sSLSocket3.getSession();
                    Handshake handshake = Handshake.get(session);
                    if (address.hostnameVerifier().verify(address.url().host(), session)) {
                        address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                        String str = null;
                        if (a.supportsTlsExtensions()) {
                            str = Platform.e().a(sSLSocket3);
                        }
                        this.j = sSLSocket3;
                        this.n = Okio.buffer(Okio.source(sSLSocket3));
                        this.o = Okio.buffer(Okio.sink(this.j));
                        this.k = handshake;
                        this.l = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                        if (sSLSocket3 != null) {
                            Platform.e().b(sSLSocket3);
                            return;
                        }
                        return;
                    }
                    List<Certificate> peerCertificates = handshake.peerCertificates();
                    if (peerCertificates.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.a(x509Certificate));
                } catch (AssertionError e) {
                    sSLSocket = sSLSocket3;
                    e = e;
                    if (Util.a(e)) {
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
                        Platform.e().b(sSLSocket2);
                    }
                    Util.a((Socket) sSLSocket2);
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

    private Request c() throws IOException {
        Request build = new Request.Builder().url(this.h.address().url()).method("CONNECT", null).header("Host", Util.a(this.h.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.a()).build();
        Request authenticate = this.h.address().proxyAuthenticator().authenticate(this.h, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(HttpURLConnection.HTTP_PROXY_AUTH).message("Preemptive Authenticate").body(Util.c).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        if (authenticate != null) {
            build = authenticate;
        }
        return build;
    }

    public HttpCodec a(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        Http2Connection http2Connection = this.m;
        if (http2Connection != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, http2Connection);
        }
        this.j.setSoTimeout(chain.readTimeoutMillis());
        this.n.timeout().timeout(chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.o.timeout().timeout(chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.n, this.o);
    }

    public RealWebSocket.Streams a(final StreamAllocation streamAllocation) {
        return new RealWebSocket.Streams(true, this.n, this.o) { // from class: okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                StreamAllocation streamAllocation2 = streamAllocation;
                streamAllocation2.a(true, streamAllocation2.a(), -1L, null);
            }
        };
    }

    public void a() {
        Util.a(this.i);
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
    public void a(int r8, int r9, int r10, int r11, boolean r12, okhttp3.Call r13, okhttp3.EventListener r14) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.a(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void a(Http2Connection http2Connection) {
        synchronized (this.g) {
            this.c = http2Connection.a();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void a(Http2Stream http2Stream) throws IOException {
        http2Stream.a(ErrorCode.REFUSED_STREAM);
    }

    public boolean a(Address address, @Nullable Route route) {
        if (this.d.size() >= this.c || this.a || !Internal.instance.equalsNonHost(this.h.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.m != null && route != null && route.proxy().type() == Proxy.Type.DIRECT && this.h.proxy().type() == Proxy.Type.DIRECT && this.h.socketAddress().equals(route.socketAddress()) && route.address().hostnameVerifier() == OkHostnameVerifier.a && a(address.url())) {
            try {
                address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException e) {
                return false;
            }
        }
        return false;
    }

    public boolean a(HttpUrl httpUrl) {
        if (httpUrl.port() != this.h.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.h.address().url().host())) {
            return true;
        }
        boolean z = false;
        if (this.k != null) {
            z = false;
            if (OkHostnameVerifier.a.a(httpUrl.host(), (X509Certificate) this.k.peerCertificates().get(0))) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.m;
        if (http2Connection != null) {
            return http2Connection.b(System.nanoTime());
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

    public boolean b() {
        return this.m != null;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.k;
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.l;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.h;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.j;
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
