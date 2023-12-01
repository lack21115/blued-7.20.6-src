package com.getui.gtc.base.http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/GtHttpClient.class */
public class GtHttpClient {
    private final int connectTimeout;
    private final Dispatcher dispatcher;
    private final boolean followRedirects;
    private final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    private final int readTimeout;
    private final boolean retryOnConnectionFailure;
    private final SSLSocketFactory sslSocketFactory;
    private final boolean useCache;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/GtHttpClient$Builder.class */
    public static final class Builder {
        int connectTimeout;
        Dispatcher dispatcher;
        boolean followRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SSLSocketFactory sslSocketFactory;
        boolean useCache;

        public Builder() {
            this.interceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.useCache = false;
            this.connectTimeout = 7000;
            this.readTimeout = 7000;
        }

        Builder(GtHttpClient gtHttpClient) {
            this.interceptors = new ArrayList();
            this.dispatcher = gtHttpClient.dispatcher;
            this.interceptors.addAll(gtHttpClient.interceptors);
            this.sslSocketFactory = gtHttpClient.sslSocketFactory;
            this.hostnameVerifier = gtHttpClient.hostnameVerifier;
            this.followRedirects = gtHttpClient.followRedirects;
            this.retryOnConnectionFailure = gtHttpClient.retryOnConnectionFailure;
            this.useCache = gtHttpClient.useCache;
            this.connectTimeout = gtHttpClient.connectTimeout;
            this.readTimeout = gtHttpClient.readTimeout;
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public final GtHttpClient build() {
            return new GtHttpClient(this);
        }

        public final Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("connectTimeout", j, timeUnit);
            return this;
        }

        public final Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher != null) {
                this.dispatcher = dispatcher;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public final Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.hostnameVerifier = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public final Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("readTimeout", j, timeUnit);
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.sslSocketFactory = sSLSocketFactory;
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public final Builder useCache(boolean z) {
            this.useCache = z;
            return this;
        }
    }

    public GtHttpClient() {
        this(new Builder());
    }

    GtHttpClient(Builder builder) {
        this.dispatcher = builder.dispatcher;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.sslSocketFactory = builder.sslSocketFactory;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.useCache = builder.useCache;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        if (this.interceptors.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        }
    }

    @Deprecated
    public static GtHttpClient getDefaultInstance() {
        return new Builder().build();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public boolean isUseCache() {
        return this.useCache;
    }

    public Call newCall(Request request) {
        return RealCall.newCall(this, request);
    }
}
