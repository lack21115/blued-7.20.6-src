package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import android.net.http.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RequestLine;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.StatusLine;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Codec.class */
public final class Http2Codec implements HttpCodec {
    private static final List<String> b = Util.immutableList(Headers.CONN_DIRECTIVE, "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f22288c = Util.immutableList(Headers.CONN_DIRECTIVE, "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    final StreamAllocation f22289a;
    private final Interceptor.Chain d;
    private final Http2Connection e;
    private Http2Stream f;
    private final Protocol g;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Codec$StreamFinishingSource.class */
    class StreamFinishingSource extends ForwardingSource {

        /* renamed from: a  reason: collision with root package name */
        boolean f22290a;
        long b;

        StreamFinishingSource(Source source) {
            super(source);
            this.f22290a = false;
            this.b = 0L;
        }

        private void a(IOException iOException) {
            if (this.f22290a) {
                return;
            }
            this.f22290a = true;
            Http2Codec.this.f22289a.streamFinished(false, Http2Codec.this, this.b, iOException);
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSource, com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSource, com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.b += read;
                }
                return read;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.d = chain;
        this.f22289a = streamAllocation;
        this.e = http2Connection;
        this.g = okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_2;
    }

    public static List<Header> http2HeadersList(Request request) {
        com.tencent.cloud.huiyansdkface.okhttp3.Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.f22280c, request.method()));
        arrayList.add(new Header(Header.d, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.f, header));
        }
        arrayList.add(new Header(Header.e, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!b.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(com.tencent.cloud.huiyansdkface.okhttp3.Headers headers, Protocol protocol) throws IOException {
        StatusLine statusLine;
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine2 = null;
        int i = 0;
        while (i < size) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (name.equals(":status")) {
                statusLine = StatusLine.parse("HTTP/1.1 " + value);
            } else {
                statusLine = statusLine2;
                if (!f22288c.contains(name)) {
                    Internal.f22211a.addLenient(builder, name, value);
                    statusLine = statusLine2;
                }
            }
            i++;
            statusLine2 = statusLine;
        }
        if (statusLine2 != null) {
            return new Response.Builder().protocol(protocol).code(statusLine2.b).message(statusLine2.f22268c).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.f;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j) {
        return this.f.getSink();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.f.getSink().close();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.e.flush();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        this.f22289a.f22253c.responseBodyStart(this.f22289a.b);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer(new StreamFinishingSource(this.f.getSource())));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.f.takeHeaders(), this.g);
        if (z && Internal.f22211a.code(readHttp2HeadersList) == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.f != null) {
            return;
        }
        Http2Stream newStream = this.e.newStream(http2HeadersList(request), request.body() != null);
        this.f = newStream;
        newStream.readTimeout().timeout(this.d.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f.writeTimeout().timeout(this.d.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }
}
