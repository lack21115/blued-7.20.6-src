package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/CallServerInterceptor.class */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f43883a;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/CallServerInterceptor$CountingSink.class */
    static final class CountingSink extends ForwardingSink {

        /* renamed from: a  reason: collision with root package name */
        long f43884a;

        CountingSink(Sink sink) {
            super(sink);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            this.f43884a += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.f43883a = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        HttpCodec b = realInterceptorChain.b();
        StreamAllocation a2 = realInterceptorChain.a();
        RealConnection realConnection = (RealConnection) realInterceptorChain.connection();
        Request request = realInterceptorChain.request();
        long currentTimeMillis = System.currentTimeMillis();
        realInterceptorChain.c().requestHeadersStart(realInterceptorChain.call());
        b.a(request);
        realInterceptorChain.c().requestHeadersEnd(realInterceptorChain.call(), request);
        Response.Builder builder = null;
        Response.Builder builder2 = null;
        if (HttpMethod.c(request.method())) {
            builder2 = null;
            if (request.body() != null) {
                if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                    b.a();
                    realInterceptorChain.c().responseHeadersStart(realInterceptorChain.call());
                    builder = b.a(true);
                }
                if (builder == null) {
                    realInterceptorChain.c().requestBodyStart(realInterceptorChain.call());
                    CountingSink countingSink = new CountingSink(b.a(request, request.body().contentLength()));
                    BufferedSink buffer = Okio.buffer(countingSink);
                    request.body().writeTo(buffer);
                    buffer.close();
                    realInterceptorChain.c().requestBodyEnd(realInterceptorChain.call(), countingSink.f43884a);
                    builder2 = builder;
                } else {
                    builder2 = builder;
                    if (!realConnection.b()) {
                        a2.e();
                        builder2 = builder;
                    }
                }
            }
        }
        b.b();
        Response.Builder builder3 = builder2;
        if (builder2 == null) {
            realInterceptorChain.c().responseHeadersStart(realInterceptorChain.call());
            builder3 = b.a(false);
        }
        Response build = builder3.request(request).handshake(a2.c().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        int i = code;
        if (code == 100) {
            build = b.a(false).request(request).handshake(a2.c().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            i = build.code();
        }
        realInterceptorChain.c().responseHeadersEnd(realInterceptorChain.call(), build);
        Response build2 = (this.f43883a && i == 101) ? build.newBuilder().body(Util.f43841c).build() : build.newBuilder().body(b.a(build)).build();
        if ("close".equalsIgnoreCase(build2.request().header("Connection")) || "close".equalsIgnoreCase(build2.header("Connection"))) {
            a2.e();
        }
        if ((i == 204 || i == 205) && build2.body().contentLength() > 0) {
            throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + build2.body().contentLength());
        }
        return build2;
    }
}
