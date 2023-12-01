package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/RealInterceptorChain.class */
public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a  reason: collision with root package name */
    private final List<Interceptor> f43888a;
    private final StreamAllocation b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpCodec f43889c;
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
        this.f43888a = list;
        this.d = realConnection;
        this.b = streamAllocation;
        this.f43889c = httpCodec;
        this.e = i;
        this.f = request;
        this.g = call;
        this.h = eventListener;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public Response a(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.e < this.f43888a.size()) {
            this.l++;
            if (this.f43889c != null && !this.d.a(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f43888a.get(this.e - 1) + " must retain the same host and port");
            } else if (this.f43889c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f43888a.get(this.e - 1) + " must call proceed() exactly once");
            } else {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f43888a, streamAllocation, httpCodec, realConnection, this.e + 1, request, this.g, this.h, this.i, this.j, this.k);
                Interceptor interceptor = this.f43888a.get(this.e);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec != null && this.e + 1 < this.f43888a.size() && realInterceptorChain.l != 1) {
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

    public StreamAllocation a() {
        return this.b;
    }

    public HttpCodec b() {
        return this.f43889c;
    }

    public EventListener c() {
        return this.h;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.g;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.i;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        return this.d;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        return a(request, this.b, this.f43889c, this.d);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.j;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.f;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f43888a, this.b, this.f43889c, this.d, this.e, this.f, this.g, this.h, Util.a("timeout", i, timeUnit), this.j, this.k);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f43888a, this.b, this.f43889c, this.d, this.e, this.f, this.g, this.h, this.i, Util.a("timeout", i, timeUnit), this.k);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f43888a, this.b, this.f43889c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, Util.a("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.k;
    }
}
