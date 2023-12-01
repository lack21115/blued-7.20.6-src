package com.tencent.cloud.huiyansdkface.okhttp3;

import com.google.common.net.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Response.class */
public final class Response implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final Request f35889a;
    final Protocol b;

    /* renamed from: c  reason: collision with root package name */
    final int f35890c;
    final String d;
    final Handshake e;
    final Headers f;
    final ResponseBody g;
    final Response h;
    final Response i;
    final Response j;
    final long k;
    final long l;
    private volatile CacheControl m;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Response$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Request f35891a;
        Protocol b;

        /* renamed from: c  reason: collision with root package name */
        int f35892c;
        String d;
        Handshake e;
        Headers.Builder f;
        ResponseBody g;
        Response h;
        Response i;
        Response j;
        long k;
        long l;

        public Builder() {
            this.f35892c = -1;
            this.f = new Headers.Builder();
        }

        Builder(Response response) {
            this.f35892c = -1;
            this.f35891a = response.f35889a;
            this.b = response.b;
            this.f35892c = response.f35890c;
            this.d = response.d;
            this.e = response.e;
            this.f = response.f.newBuilder();
            this.g = response.g;
            this.h = response.h;
            this.i = response.i;
            this.j = response.j;
            this.k = response.k;
            this.l = response.l;
        }

        private void a(Response response) {
            if (response.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void a(String str, Response response) {
            if (response.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.j == null) {
            } else {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder addHeader(String str, String str2) {
            this.f.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.g = responseBody;
            return this;
        }

        public Response build() {
            if (this.f35891a != null) {
                if (this.b != null) {
                    if (this.f35892c >= 0) {
                        if (this.d != null) {
                            return new Response(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f35892c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                a("cacheResponse", response);
            }
            this.i = response;
            return this;
        }

        public Builder code(int i) {
            this.f35892c = i;
            return this;
        }

        public Builder handshake(Handshake handshake) {
            this.e = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.f.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f = headers.newBuilder();
            return this;
        }

        public Builder message(String str) {
            this.d = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                a("networkResponse", response);
            }
            this.h = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                a(response);
            }
            this.j = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.l = j;
            return this;
        }

        public Builder removeHeader(String str) {
            this.f.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.f35891a = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.k = j;
            return this;
        }
    }

    Response(Builder builder) {
        this.f35889a = builder.f35891a;
        this.b = builder.b;
        this.f35890c = builder.f35892c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f.build();
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
    }

    public ResponseBody body() {
        return this.g;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f);
        this.m = parse;
        return parse;
    }

    public Response cacheResponse() {
        return this.i;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.f35890c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.f35890c;
    }

    public Handshake handshake() {
        return this.e;
    }

    public String header(String str) {
        return header(str, null);
    }

    public String header(String str, String str2) {
        String str3 = this.f.get(str);
        if (str3 != null) {
            str2 = str3;
        }
        return str2;
    }

    public Headers headers() {
        return this.f;
    }

    public List<String> headers(String str) {
        return this.f.values(str);
    }

    public boolean isRedirect() {
        int i = this.f35890c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.f35890c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.d;
    }

    public Response networkResponse() {
        return this.h;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.g.source();
        source.request(j);
        Buffer m10133clone = source.buffer().m10133clone();
        Buffer buffer = m10133clone;
        if (m10133clone.size() > j) {
            buffer = new Buffer();
            buffer.write(m10133clone, j);
            m10133clone.clear();
        }
        return ResponseBody.create(this.g.contentType(), buffer.size(), buffer);
    }

    public Response priorResponse() {
        return this.j;
    }

    public Protocol protocol() {
        return this.b;
    }

    public long receivedResponseAtMillis() {
        return this.l;
    }

    public Request request() {
        return this.f35889a;
    }

    public long sentRequestAtMillis() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.f35890c + ", message=" + this.d + ", url=" + this.f35889a.url() + '}';
    }
}
