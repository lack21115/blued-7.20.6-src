package okhttp3.internal.http2;

import android.net.http.Headers;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.xml.transform.OutputKeys;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Codec.class */
public final class Http2Codec implements HttpCodec {
    private static final List<String> b = Util.a(Headers.CONN_DIRECTIVE, "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, OutputKeys.ENCODING, "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f43915c = Util.a(Headers.CONN_DIRECTIVE, "host", "keep-alive", Headers.PROXY_CONNECTION, "te", Headers.TRANSFER_ENCODING, OutputKeys.ENCODING, "upgrade");

    /* renamed from: a  reason: collision with root package name */
    final StreamAllocation f43916a;
    private final Interceptor.Chain d;
    private final Http2Connection e;
    private Http2Stream f;
    private final Protocol g;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Codec$StreamFinishingSource.class */
    class StreamFinishingSource extends ForwardingSource {

        /* renamed from: a  reason: collision with root package name */
        boolean f43917a;
        long b;

        StreamFinishingSource(Source source) {
            super(source);
            this.f43917a = false;
            this.b = 0L;
        }

        private void a(IOException iOException) {
            if (this.f43917a) {
                return;
            }
            this.f43917a = true;
            Http2Codec.this.f43916a.a(false, Http2Codec.this, this.b, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        @Override // okio.ForwardingSource, okio.Source
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
        this.f43916a = streamAllocation;
        this.e = http2Connection;
        this.g = okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_2;
    }

    public static Response.Builder a(okhttp3.Headers headers, Protocol protocol) throws IOException {
        StatusLine statusLine;
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine2 = null;
        int i = 0;
        while (i < size) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (name.equals(":status")) {
                statusLine = StatusLine.a("HTTP/1.1 " + value);
            } else {
                statusLine = statusLine2;
                if (!f43915c.contains(name)) {
                    Internal.instance.addLenient(builder, name, value);
                    statusLine = statusLine2;
                }
            }
            i++;
            statusLine2 = statusLine;
        }
        if (statusLine2 != null) {
            return new Response.Builder().protocol(protocol).code(statusLine2.b).message(statusLine2.f43895c).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<Header> b(Request request) {
        okhttp3.Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.f43907c, request.method()));
        arrayList.add(new Header(Header.d, RequestLine.a(request.url())));
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

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder a(boolean z) throws IOException {
        Response.Builder a2 = a(this.f.d(), this.g);
        if (z && Internal.instance.code(a2) == 100) {
            return null;
        }
        return a2;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody a(Response response) throws IOException {
        this.f43916a.f43880c.responseBodyStart(this.f43916a.b);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.a(response), Okio.buffer(new StreamFinishingSource(this.f.g())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink a(Request request, long j) {
        return this.f.h();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void a() throws IOException {
        this.e.b();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void a(Request request) throws IOException {
        if (this.f != null) {
            return;
        }
        Http2Stream a2 = this.e.a(b(request), request.body() != null);
        this.f = a2;
        a2.e().timeout(this.d.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f.f().timeout(this.d.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void b() throws IOException {
        this.f.h().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void c() {
        Http2Stream http2Stream = this.f;
        if (http2Stream != null) {
            http2Stream.b(ErrorCode.CANCEL);
        }
    }
}
