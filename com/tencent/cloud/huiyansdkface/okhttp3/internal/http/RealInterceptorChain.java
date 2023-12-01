package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http/RealInterceptorChain.class */
public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a  reason: collision with root package name */
    private final List<Interceptor> f22261a;
    private final StreamAllocation b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpCodec f22262c;
    private final RealConnection d;
    private final int e;
    private final Request f;
    private final Call g;
    private final EventListener h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f22261a = list;
        this.d = realConnection;
        this.b = streamAllocation;
        this.f22262c = httpCodec;
        this.e = i;
        this.f = request;
        this.g = call;
        this.h = eventListener;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Call call() {
        return this.g;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.i;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Connection connection() {
        return this.d;
    }

    public EventListener eventListener() {
        return this.h;
    }

    public HttpCodec httpStream() {
        return this.f22262c;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        return proceed(request, this.b, this.f22262c, this.d);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.e < this.f22261a.size()) {
            this.l++;
            if (this.f22262c != null && !this.d.supportsUrl(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f22261a.get(this.e - 1) + " must retain the same host and port");
            } else if (this.f22262c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f22261a.get(this.e - 1) + " must call proceed() exactly once");
            } else {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f22261a, streamAllocation, httpCodec, realConnection, this.e + 1, request, this.g, this.h, this.i, this.j, this.k);
                Interceptor interceptor = this.f22261a.get(this.e);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec != null && this.e + 1 < this.f22261a.size() && realInterceptorChain.l != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.body() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            }
        }
        throw new AssertionError();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.j;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Request request() {
        return this.f;
    }

    public StreamAllocation streamAllocation() {
        return this.b;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f22261a, this.b, this.f22262c, this.d, this.e, this.f, this.g, this.h, Util.checkDuration("timeout", i, timeUnit), this.j, this.k);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f22261a, this.b, this.f22262c, this.d, this.e, this.f, this.g, this.h, this.i, Util.checkDuration("timeout", i, timeUnit), this.k);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f22261a, this.b, this.f22262c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, Util.checkDuration("timeout", i, timeUnit));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.k;
    }
}
