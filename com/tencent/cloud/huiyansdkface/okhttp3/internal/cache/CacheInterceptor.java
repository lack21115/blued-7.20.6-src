package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.anythink.expressad.foundation.g.f.g.c;
import com.google.common.net.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheStrategy;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpMethod;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealResponseBody;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/CacheInterceptor.class */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    final InternalCache f22216a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f22216a = internalCache;
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
                Internal.f22211a.addLenient(builder, name, value);
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
                Internal.f22211a.addLenient(builder, name2, headers2.value(i4));
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
            return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), Okio.buffer(new Source() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheInterceptor.1

                /* renamed from: a  reason: collision with root package name */
                boolean f22217a;

                @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f22217a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f22217a = true;
                        cacheRequest.abort();
                    }
                    source.close();
                }

                @Override // com.tencent.cloud.huiyansdkface.okio.Source
                public long read(Buffer buffer2, long j) throws IOException {
                    try {
                        long read = source.read(buffer2, j);
                        if (read != -1) {
                            buffer2.copyTo(buffer.buffer(), buffer2.size() - read, read);
                            buffer.emitCompleteSegments();
                            return read;
                        } else if (this.f22217a) {
                            return -1L;
                        } else {
                            this.f22217a = true;
                            buffer.close();
                            return -1L;
                        }
                    } catch (IOException e) {
                        if (!this.f22217a) {
                            this.f22217a = true;
                            cacheRequest.abort();
                        }
                        throw e;
                    }
                }

                @Override // com.tencent.cloud.huiyansdkface.okio.Source
                public Timeout timeout() {
                    return source.timeout();
                }
            }))).build();
        }
        return response;
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || c.f5066c.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f22216a;
        Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).get();
        Request request = cacheStrategy.f22219a;
        Response response2 = cacheStrategy.b;
        InternalCache internalCache2 = this.f22216a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            Util.closeQuietly(response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.f22214c).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(a(response2)).build();
        }
        try {
            Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
                Util.closeQuietly(response.body());
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response build = response2.newBuilder().headers(a(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(a(response2)).networkResponse(a(proceed)).build();
                    proceed.body().close();
                    this.f22216a.trackConditionalCacheHit();
                    this.f22216a.update(response2, build);
                    return build;
                }
                Util.closeQuietly(response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(a(response2)).networkResponse(a(proceed)).build();
            if (this.f22216a != null) {
                if (com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders.hasBody(build2) && CacheStrategy.isCacheable(build2, request)) {
                    return a(this.f22216a.put(build2), build2);
                }
                if (HttpMethod.invalidatesCache(request.method())) {
                    try {
                        this.f22216a.remove(request);
                    } catch (IOException e) {
                        return build2;
                    }
                }
            }
            return build2;
        } catch (Throwable th) {
            if (response != null) {
                Util.closeQuietly(response.body());
            }
            throw th;
        }
    }
}
