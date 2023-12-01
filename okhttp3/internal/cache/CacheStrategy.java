package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/CacheStrategy.class */
public final class CacheStrategy {
    @Nullable
    public final Request a;
    @Nullable
    public final Response b;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/CacheStrategy$Factory.class */
    public static class Factory {
        final long a;
        final Request b;
        final Response c;
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
            this.a = j;
            this.b = request;
            this.c = response;
            if (response != null) {
                this.i = response.sentRequestAtMillis();
                this.j = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.d = HttpDate.a(value);
                        this.e = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.h = HttpDate.a(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f = HttpDate.a(value);
                        this.g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.k = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.l = HttpHeaders.b(value, -1);
                    }
                }
            }
        }

        private static boolean a(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private CacheStrategy b() {
            if (this.c == null) {
                return new CacheStrategy(this.b, null);
            }
            if ((!this.b.isHttps() || this.c.handshake() != null) && CacheStrategy.a(this.c, this.b)) {
                CacheControl cacheControl = this.b.cacheControl();
                if (cacheControl.noCache() || a(this.b)) {
                    return new CacheStrategy(this.b, null);
                }
                CacheControl cacheControl2 = this.c.cacheControl();
                long d = d();
                long c = c();
                long j = c;
                if (cacheControl.maxAgeSeconds() != -1) {
                    j = Math.min(c, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
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
                    long j3 = millis + d;
                    if (j3 < j2 + j) {
                        Response.Builder newBuilder = this.c.newBuilder();
                        if (j3 >= j) {
                            newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (d > 86400000 && e()) {
                            newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
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
                Internal.instance.addLenient(newBuilder2, str2, str);
                return new CacheStrategy(this.b.newBuilder().headers(newBuilder2.build()).build(), this.c);
            }
            return new CacheStrategy(this.b, null);
        }

        private long c() {
            CacheControl cacheControl;
            if (this.c.cacheControl().maxAgeSeconds() != -1) {
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
                if (this.c.request().url().query() == null) {
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

        private long d() {
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
            return j2 + (j3 - this.i) + (this.a - j3);
        }

        private boolean e() {
            return this.c.cacheControl().maxAgeSeconds() == -1 && this.h == null;
        }

        public CacheStrategy a() {
            CacheStrategy b = b();
            CacheStrategy cacheStrategy = b;
            if (b.a != null) {
                cacheStrategy = b;
                if (this.b.cacheControl().onlyIfCached()) {
                    cacheStrategy = new CacheStrategy(null, null);
                }
            }
            return cacheStrategy;
        }
    }

    CacheStrategy(Request request, Response response) {
        this.a = request;
        this.b = response;
    }

    public static boolean a(Response response, Request request) {
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
