package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.CacheControl;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/CacheStrategy.class */
public final class CacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final Request f35910a;
    public final Response b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache/CacheStrategy$Factory.class */
    public static class Factory {

        /* renamed from: a  reason: collision with root package name */
        final long f35911a;
        final Request b;

        /* renamed from: c  reason: collision with root package name */
        final Response f35912c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public Factory(long j, Request request, Response response) {
            this.l = -1;
            this.f35911a = j;
            this.b = request;
            this.f35912c = response;
            if (response != null) {
                this.i = response.sentRequestAtMillis();
                this.j = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.d = HttpDate.parse(value);
                        this.e = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.h = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f = HttpDate.parse(value);
                        this.g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.k = value;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(name)) {
                        this.l = com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        private CacheStrategy a() {
            if (this.f35912c == null) {
                return new CacheStrategy(this.b, null);
            }
            if ((!this.b.isHttps() || this.f35912c.handshake() != null) && CacheStrategy.isCacheable(this.f35912c, this.b)) {
                CacheControl cacheControl = this.b.cacheControl();
                if (cacheControl.noCache() || a(this.b)) {
                    return new CacheStrategy(this.b, null);
                }
                CacheControl cacheControl2 = this.f35912c.cacheControl();
                long c2 = c();
                long b = b();
                long j = b;
                if (cacheControl.maxAgeSeconds() != -1) {
                    j = Math.min(b, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
                long j2 = 0;
                if (!cacheControl2.mustRevalidate()) {
                    j2 = 0;
                    if (cacheControl.maxStaleSeconds() != -1) {
                        j2 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                    }
                }
                if (!cacheControl2.noCache()) {
                    long j3 = millis + c2;
                    if (j3 < j2 + j) {
                        Response.Builder newBuilder = this.f35912c.newBuilder();
                        if (j3 >= j) {
                            newBuilder.addHeader(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (c2 > 86400000 && d()) {
                            newBuilder.addHeader(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, newBuilder.build());
                    }
                }
                String str = this.k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f != null) {
                    str = this.g;
                } else if (this.d == null) {
                    return new CacheStrategy(this.b, null);
                } else {
                    str = this.e;
                }
                Headers.Builder newBuilder2 = this.b.headers().newBuilder();
                Internal.f35902a.addLenient(newBuilder2, str2, str);
                return new CacheStrategy(this.b.newBuilder().headers(newBuilder2.build()).build(), this.f35912c);
            }
            return new CacheStrategy(this.b, null);
        }

        private static boolean a(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private long b() {
            CacheControl cacheControl;
            if (this.f35912c.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            long j = 0;
            if (this.h != null) {
                Date date = this.d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    j = time;
                }
                return j;
            }
            long j2 = 0;
            if (this.f != null) {
                j2 = 0;
                if (this.f35912c.request().url().query() == null) {
                    Date date2 = this.d;
                    long time2 = (date2 != null ? date2.getTime() : this.i) - this.f.getTime();
                    j2 = 0;
                    if (time2 > 0) {
                        j2 = time2 / 10;
                    }
                }
            }
            return j2;
        }

        private long c() {
            Date date = this.d;
            long j = 0;
            if (date != null) {
                j = Math.max(0L, this.j - date.getTime());
            }
            long j2 = j;
            if (this.l != -1) {
                j2 = Math.max(j, TimeUnit.SECONDS.toMillis(this.l));
            }
            long j3 = this.j;
            return j2 + (j3 - this.i) + (this.f35911a - j3);
        }

        private boolean d() {
            return this.f35912c.cacheControl().maxAgeSeconds() == -1 && this.h == null;
        }

        public CacheStrategy get() {
            CacheStrategy a2 = a();
            CacheStrategy cacheStrategy = a2;
            if (a2.f35910a != null) {
                cacheStrategy = a2;
                if (this.b.cacheControl().onlyIfCached()) {
                    cacheStrategy = new CacheStrategy(null, null);
                }
            }
            return cacheStrategy;
        }
    }

    CacheStrategy(Request request, Response response) {
        this.f35910a = request;
        this.b = response;
    }

    public static boolean isCacheable(Response response, Request request) {
        int code = response.code();
        if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
            if (code != 307) {
                if (code != 308 && code != 404 && code != 405) {
                    switch (code) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (response.header("Expires") == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                return false;
            }
        }
        boolean z = false;
        if (!response.cacheControl().noStore()) {
            z = false;
            if (!request.cacheControl().noStore()) {
                z = true;
            }
        }
        return z;
    }
}
