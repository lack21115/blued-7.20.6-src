package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteException;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ConnectionShutdownException;
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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http/RetryAndFollowUpInterceptor.class */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f22265a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile StreamAllocation f22266c;
    private Object d;
    private volatile boolean e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f22265a = okHttpClient;
        this.b = z;
    }

    private int a(Response response, int i) {
        String header = response.header(com.google.common.net.HttpHeaders.RETRY_AFTER);
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
            sSLSocketFactory = this.f22265a.sslSocketFactory();
            hostnameVerifier = this.f22265a.hostnameVerifier();
            certificatePinner = this.f22265a.certificatePinner();
        } else {
            hostnameVerifier = null;
            certificatePinner = null;
            sSLSocketFactory = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.f22265a.dns(), this.f22265a.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f22265a.proxyAuthenticator(), this.f22265a.proxy(), this.f22265a.protocols(), this.f22265a.connectionSpecs(), this.f22265a.proxySelector());
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
                    if ((route != null ? route.proxy() : this.f22265a.proxy()).type() == Proxy.Type.HTTP) {
                        return this.f22265a.proxyAuthenticator().authenticate(route, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (code == 408) {
                    if (this.f22265a.retryOnConnectionFailure() && !(response.request().body() instanceof UnrepeatableRequestBody)) {
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
                return this.f22265a.authenticator().authenticate(route, response);
            }
            if (!this.f22265a.followRedirects() || (header = response.header(com.google.common.net.HttpHeaders.LOCATION)) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (resolve.scheme().equals(response.request().url().scheme()) || this.f22265a.followSslRedirects()) {
                Request.Builder newBuilder = response.request().newBuilder();
                if (HttpMethod.permitsRequestBody(method)) {
                    boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                    if (HttpMethod.redirectsToGet(method)) {
                        newBuilder.method("GET", null);
                    } else {
                        RequestBody requestBody = null;
                        if (redirectsWithBody) {
                            requestBody = response.request().body();
                        }
                        newBuilder.method(method, requestBody);
                    }
                    if (!redirectsWithBody) {
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

    private boolean a(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    private boolean a(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.streamFailed(iOException);
        if (this.f22265a.retryOnConnectionFailure()) {
            return !(z && (request.body() instanceof UnrepeatableRequestBody)) && a(iOException, z) && streamAllocation.hasMoreRoutes();
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

    public void cancel() {
        this.e = true;
        StreamAllocation streamAllocation = this.f22266c;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.f22265a.connectionPool(), a(request.url()), call, eventListener, this.d);
        this.f22266c = streamAllocation;
        Response response2 = null;
        int i = 0;
        Request request2 = request;
        while (!this.e) {
            try {
                try {
                    try {
                        Response proceed = realInterceptorChain.proceed(request2, streamAllocation, null, null);
                        response = proceed;
                        if (response2 != null) {
                            response = proceed.newBuilder().priorResponse(response2.newBuilder().body(null).build()).build();
                        }
                    } catch (RouteException e) {
                        if (!a(e.getLastConnectException(), streamAllocation, false, request2)) {
                            throw e.getFirstConnectException();
                        }
                    }
                } catch (IOException e2) {
                    if (!a(e2, streamAllocation, !(e2 instanceof ConnectionShutdownException), request2)) {
                        throw e2;
                    }
                }
                try {
                    Request a2 = a(response, streamAllocation.route());
                    if (a2 == null) {
                        streamAllocation.release();
                        return response;
                    }
                    Util.closeQuietly(response.body());
                    i++;
                    if (i > 20) {
                        streamAllocation.release();
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    } else if (a2.body() instanceof UnrepeatableRequestBody) {
                        streamAllocation.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", response.code());
                    } else {
                        if (!a(response, a2.url())) {
                            streamAllocation.release();
                            streamAllocation = new StreamAllocation(this.f22265a.connectionPool(), a(a2.url()), call, eventListener, this.d);
                            this.f22266c = streamAllocation;
                        } else if (streamAllocation.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + response + " didn't close its backing stream. Bad interceptor?");
                        }
                        response2 = response;
                        request2 = a2;
                    }
                } catch (IOException e3) {
                    streamAllocation.release();
                    throw e3;
                }
            } catch (Throwable th) {
                streamAllocation.streamFailed(null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.e;
    }

    public void setCallStackTrace(Object obj) {
        this.d = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.f22266c;
    }
}
