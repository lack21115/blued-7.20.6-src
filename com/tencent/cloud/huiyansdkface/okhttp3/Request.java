package com.tencent.cloud.huiyansdkface.okhttp3;

import com.sobot.network.http.SobotOkHttpUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpMethod;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Request.class */
public final class Request {

    /* renamed from: a  reason: collision with root package name */
    final HttpUrl f35881a;
    final String b;

    /* renamed from: c  reason: collision with root package name */
    final Headers f35882c;
    final RequestBody d;
    final Map<Class<?>, Object> e;
    private volatile CacheControl f;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Request$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        HttpUrl f35883a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        Headers.Builder f35884c;
        RequestBody d;
        Map<Class<?>, Object> e;

        public Builder() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.f35884c = new Headers.Builder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Map] */
        Builder(Request request) {
            this.e = Collections.emptyMap();
            this.f35883a = request.f35881a;
            this.b = request.b;
            this.d = request.d;
            this.e = request.e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap(request.e);
            this.f35884c = request.f35882c.newBuilder();
        }

        public Builder addHeader(String str, String str2) {
            this.f35884c.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.f35883a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete() {
            return delete(Util.d);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            this.f35884c.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f35884c = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str != null) {
                if (str.length() != 0) {
                    if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                        this.b = str;
                        this.d = requestBody;
                        return this;
                    } else {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public Builder patch(RequestBody requestBody) {
            return method(SobotOkHttpUtils.METHOD.PATCH, requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.f35884c.removeAll(str);
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            if (cls != null) {
                if (t == null) {
                    this.e.remove(cls);
                    return this;
                }
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
                return this;
            }
            throw new NullPointerException("type == null");
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Object tag() {
            return this.e.get(Object.class);
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.f35883a = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(String str) {
            String str2;
            StringBuilder sb;
            int i;
            if (str != null) {
                if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str2 = str;
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        sb = new StringBuilder();
                        sb.append("https:");
                        i = 4;
                    }
                    return url(HttpUrl.get(str2));
                }
                sb = new StringBuilder();
                sb.append("http:");
                i = 3;
                sb.append(str.substring(i));
                str2 = sb.toString();
                return url(HttpUrl.get(str2));
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(URL url) {
            if (url != null) {
                return url(HttpUrl.get(url.toString()));
            }
            throw new NullPointerException("url == null");
        }
    }

    Request(Builder builder) {
        this.f35881a = builder.f35883a;
        this.b = builder.b;
        this.f35882c = builder.f35884c.build();
        this.d = builder.d;
        this.e = Util.immutableMap(builder.e);
    }

    public RequestBody body() {
        return this.d;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f35882c);
        this.f = parse;
        return parse;
    }

    public String header(String str) {
        return this.f35882c.get(str);
    }

    public Headers headers() {
        return this.f35882c;
    }

    public List<String> headers(String str) {
        return this.f35882c.values(str);
    }

    public boolean isHttps() {
        return this.f35881a.isHttps();
    }

    public String method() {
        return this.b;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Object tag() {
        return tag(Object.class);
    }

    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.e.get(cls));
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.f35881a + ", tags=" + this.e + '}';
    }

    public HttpUrl url() {
        return this.f35881a;
    }
}
