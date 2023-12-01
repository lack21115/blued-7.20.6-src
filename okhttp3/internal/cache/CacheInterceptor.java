package okhttp3.internal.cache;

import com.anythink.expressad.foundation.g.f.g.c;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/CacheInterceptor.class */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    final InternalCache f43843a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f43843a = internalCache;
    }

    private static Headers a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            String name = headers.name(i2);
            String value = headers.value(i2);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(name) || !value.startsWith("1")) && (b(name) || !a(name) || headers2.get(name) == null)) {
                Internal.instance.addLenient(builder, name, value);
            }
            i = i2 + 1;
        }
        int size2 = headers2.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return builder.build();
            }
            String name2 = headers2.name(i4);
            if (!b(name2) && a(name2)) {
                Internal.instance.addLenient(builder, name2, headers2.value(i4));
            }
            i3 = i4 + 1;
        }
    }

    private static Response a(Response response) {
        Response response2 = response;
        if (response != null) {
            response2 = response;
            if (response.body() != null) {
                response2 = response.newBuilder().body(null).build();
            }
        }
        return response2;
    }

    private Response a(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest != null && (body = cacheRequest.body()) != null) {
            final BufferedSource source = response.body().source();
            final BufferedSink buffer = Okio.buffer(body);
            return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), Okio.buffer(new Source() { // from class: okhttp3.internal.cache.CacheInterceptor.1

                /* renamed from: a  reason: collision with root package name */
                boolean f43844a;

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f43844a && !Util.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f43844a = true;
                        cacheRequest.abort();
                    }
                    source.close();
                }

                @Override // okio.Source
                public long read(Buffer buffer2, long j) throws IOException {
                    try {
                        long read = source.read(buffer2, j);
                        if (read != -1) {
                            buffer2.copyTo(buffer.buffer(), buffer2.size() - read, read);
                            buffer.emitCompleteSegments();
                            return read;
                        } else if (this.f43844a) {
                            return -1L;
                        } else {
                            this.f43844a = true;
                            buffer.close();
                            return -1L;
                        }
                    } catch (IOException e) {
                        if (!this.f43844a) {
                            this.f43844a = true;
                            cacheRequest.abort();
                        }
                        throw e;
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return source.timeout();
                }
            }))).build();
        }
        return response;
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || c.f7906c.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* JADX WARN: Finally extract failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f43843a;
        Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        CacheStrategy a2 = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).a();
        Request request = a2.f43846a;
        Response response2 = a2.b;
        InternalCache internalCache2 = this.f43843a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(a2);
        }
        if (response != null && response2 == null) {
            Util.a(response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.f43841c).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(a(response2)).build();
        }
        try {
            Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
                Util.a(response.body());
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response build = response2.newBuilder().headers(a(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(a(response2)).networkResponse(a(proceed)).build();
                    proceed.body().close();
                    this.f43843a.trackConditionalCacheHit();
                    this.f43843a.update(response2, build);
                    return build;
                }
                Util.a(response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(a(response2)).networkResponse(a(proceed)).build();
            if (this.f43843a != null) {
                if (okhttp3.internal.http.HttpHeaders.d(build2) && CacheStrategy.a(build2, request)) {
                    return a(this.f43843a.put(build2), build2);
                }
                if (HttpMethod.a(request.method())) {
                    try {
                        this.f43843a.remove(request);
                    } catch (IOException e) {
                        return build2;
                    }
                }
            }
            return build2;
        } catch (Throwable th) {
            if (response != null) {
                Util.a(response.body());
            }
            throw th;
        }
    }
}
