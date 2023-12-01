package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/RetryAndFollowUpInterceptor.class */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private final OkHttpClient a;
    private final boolean b;
    private volatile StreamAllocation c;
    private Object d;
    private volatile boolean e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.a = okHttpClient;
        this.b = z;
    }

    private int a(Response response, int i) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private Address a(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.a.sslSocketFactory();
            hostnameVerifier = this.a.hostnameVerifier();
            certificatePinner = this.a.certificatePinner();
        } else {
            hostnameVerifier = null;
            certificatePinner = null;
            sSLSocketFactory = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.a.dns(), this.a.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.a.proxyAuthenticator(), this.a.proxy(), this.a.protocols(), this.a.connectionSpecs(), this.a.proxySelector());
    }

    private Request a(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            if (code == 307 || code == 308) {
                if (!method.equals("GET") && !method.equals("HEAD")) {
                    return null;
                }
            } else if (code != 401) {
                if (code == 503) {
                    if ((response.priorResponse() == null || response.priorResponse().code() != 503) && a(response, Integer.MAX_VALUE) == 0) {
                        return response.request();
                    }
                    return null;
                } else if (code == 407) {
                    if (route.proxy().type() == Proxy.Type.HTTP) {
                        return this.a.proxyAuthenticator().authenticate(route, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (code == 408) {
                    if (this.a.retryOnConnectionFailure() && !(response.request().body() instanceof UnrepeatableRequestBody)) {
                        if ((response.priorResponse() == null || response.priorResponse().code() != 408) && a(response, 0) <= 0) {
                            return response.request();
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (code) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.a.authenticator().authenticate(route, response);
            }
            if (!this.a.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (resolve.scheme().equals(response.request().url().scheme()) || this.a.followSslRedirects()) {
                Request.Builder newBuilder = response.request().newBuilder();
                if (HttpMethod.c(method)) {
                    boolean d = HttpMethod.d(method);
                    if (HttpMethod.e(method)) {
                        newBuilder.method("GET", null);
                    } else {
                        RequestBody requestBody = null;
                        if (d) {
                            requestBody = response.request().body();
                        }
                        newBuilder.method(method, requestBody);
                    }
                    if (!d) {
                        newBuilder.removeHeader("Transfer-Encoding");
                        newBuilder.removeHeader("Content-Length");
                        newBuilder.removeHeader("Content-Type");
                    }
                }
                if (!a(response, resolve)) {
                    newBuilder.removeHeader("Authorization");
                }
                return newBuilder.url(resolve).build();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    private boolean a(IOException iOException, Request request) {
        return (request.body() instanceof UnrepeatableRequestBody) || (iOException instanceof FileNotFoundException);
    }

    private boolean a(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.a(iOException);
        if (this.a.retryOnConnectionFailure()) {
            return !(z && a(iOException, request)) && a(iOException, z) && streamAllocation.g();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        }
        boolean z2 = false;
        if (iOException instanceof SocketTimeoutException) {
            z2 = false;
            if (!z) {
                z2 = true;
            }
        }
        return z2;
    }

    private boolean a(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    public void a() {
        this.e = true;
        StreamAllocation streamAllocation = this.c;
        if (streamAllocation != null) {
            streamAllocation.f();
        }
    }

    public void a(Object obj) {
        this.d = obj;
    }

    public boolean b() {
        return this.e;
    }

    public StreamAllocation c() {
        return this.c;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener c = realInterceptorChain.c();
        StreamAllocation streamAllocation = new StreamAllocation(this.a.connectionPool(), a(request.url()), call, c, this.d);
        this.c = streamAllocation;
        Response response2 = null;
        int i = 0;
        Request request2 = request;
        while (!this.e) {
            try {
                try {
                    try {
                        Response a = realInterceptorChain.a(request2, streamAllocation, null, null);
                        response = a;
                        if (response2 != null) {
                            response = a.newBuilder().priorResponse(response2.newBuilder().body(null).build()).build();
                        }
                    } catch (RouteException e) {
                        if (!a(e.b(), streamAllocation, false, request2)) {
                            throw e.a();
                        }
                    }
                } catch (IOException e2) {
                    if (!a(e2, streamAllocation, !(e2 instanceof ConnectionShutdownException), request2)) {
                        throw e2;
                    }
                }
                try {
                    Request a2 = a(response, streamAllocation.b());
                    if (a2 == null) {
                        streamAllocation.d();
                        return response;
                    }
                    Util.a(response.body());
                    i++;
                    if (i > 20) {
                        streamAllocation.d();
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    } else if (a2.body() instanceof UnrepeatableRequestBody) {
                        streamAllocation.d();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", response.code());
                    } else {
                        if (!a(response, a2.url())) {
                            streamAllocation.d();
                            streamAllocation = new StreamAllocation(this.a.connectionPool(), a(a2.url()), call, c, this.d);
                            this.c = streamAllocation;
                        } else if (streamAllocation.a() != null) {
                            throw new IllegalStateException("Closing the body of " + response + " didn't close its backing stream. Bad interceptor?");
                        }
                        response2 = response;
                        request2 = a2;
                    }
                } catch (IOException e3) {
                    streamAllocation.d();
                    throw e3;
                }
            } catch (Throwable th) {
                streamAllocation.a((IOException) null);
                streamAllocation.d();
                throw th;
            }
        }
        streamAllocation.d();
        throw new IOException("Canceled");
    }
}
