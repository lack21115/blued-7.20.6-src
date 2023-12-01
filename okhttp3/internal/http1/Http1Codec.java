package okhttp3.internal.http1;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec.class */
public final class Http1Codec implements HttpCodec {

    /* renamed from: a  reason: collision with root package name */
    final OkHttpClient f43896a;
    final StreamAllocation b;

    /* renamed from: c  reason: collision with root package name */
    final BufferedSource f43897c;
    final BufferedSink d;
    int e = 0;
    private long f = 262144;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec$AbstractSource.class */
    public abstract class AbstractSource implements Source {

        /* renamed from: a  reason: collision with root package name */
        protected final ForwardingTimeout f43898a;
        protected boolean b;

        /* renamed from: c  reason: collision with root package name */
        protected long f43899c;

        private AbstractSource() {
            this.f43898a = new ForwardingTimeout(Http1Codec.this.f43897c.timeout());
            this.f43899c = 0L;
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.e == 6) {
                return;
            }
            if (Http1Codec.this.e != 5) {
                throw new IllegalStateException("state: " + Http1Codec.this.e);
            }
            Http1Codec.this.a(this.f43898a);
            Http1Codec.this.e = 6;
            if (Http1Codec.this.b != null) {
                Http1Codec.this.b.a(!z, Http1Codec.this, this.f43899c, iOException);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = Http1Codec.this.f43897c.read(buffer, j);
                if (read > 0) {
                    this.f43899c += read;
                }
                return read;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f43898a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec$ChunkedSink.class */
    public final class ChunkedSink implements Sink {
        private final ForwardingTimeout b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f43901c;

        ChunkedSink() {
            this.b = new ForwardingTimeout(Http1Codec.this.d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this) {
                if (this.f43901c) {
                    return;
                }
                this.f43901c = true;
                Http1Codec.this.d.writeUtf8("0\r\n\r\n");
                Http1Codec.this.a(this.b);
                Http1Codec.this.e = 3;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (this) {
                if (this.f43901c) {
                    return;
                }
                Http1Codec.this.d.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.b;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f43901c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1Codec.this.d.writeHexadecimalUnsignedLong(j);
            Http1Codec.this.d.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            Http1Codec.this.d.write(buffer, j);
            Http1Codec.this.d.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec$ChunkedSource.class */
    public class ChunkedSource extends AbstractSource {
        private final HttpUrl f;
        private long g;
        private boolean h;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.g = -1L;
            this.h = true;
            this.f = httpUrl;
        }

        private void a() throws IOException {
            if (this.g != -1) {
                Http1Codec.this.f43897c.readUtf8LineStrict();
            }
            try {
                this.g = Http1Codec.this.f43897c.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.f43897c.readUtf8LineStrict().trim();
                if (this.g < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    HttpHeaders.a(Http1Codec.this.f43896a.cookieJar(), this.f, Http1Codec.this.d());
                    a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.h && !Util.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.b = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.h) {
                    long j2 = this.g;
                    if (j2 == 0 || j2 == -1) {
                        a();
                        if (!this.h) {
                            return -1L;
                        }
                    }
                    long read = super.read(buffer, Math.min(j, this.g));
                    if (read != -1) {
                        this.g -= read;
                        return read;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                return -1L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec$FixedLengthSink.class */
    public final class FixedLengthSink implements Sink {
        private final ForwardingTimeout b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f43903c;
        private long d;

        FixedLengthSink(long j) {
            this.b = new ForwardingTimeout(Http1Codec.this.d.timeout());
            this.d = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f43903c) {
                return;
            }
            this.f43903c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1Codec.this.a(this.b);
            Http1Codec.this.e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f43903c) {
                return;
            }
            Http1Codec.this.d.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.b;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f43903c) {
                throw new IllegalStateException("closed");
            }
            Util.a(buffer.size(), 0L, j);
            if (j <= this.d) {
                Http1Codec.this.d.write(buffer, j);
                this.d -= j;
                return;
            }
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec$FixedLengthSource.class */
    public class FixedLengthSource extends AbstractSource {
        private long f;

        FixedLengthSource(long j) throws IOException {
            super();
            this.f = j;
            if (j == 0) {
                a(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f != 0 && !Util.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.b = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else {
                long j2 = this.f;
                if (j2 == 0) {
                    return -1L;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read == -1) {
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                long j3 = this.f - read;
                this.f = j3;
                if (j3 == 0) {
                    a(true, null);
                }
                return read;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http1/Http1Codec$UnknownLengthSource.class */
    public class UnknownLengthSource extends AbstractSource {
        private boolean f;

        UnknownLengthSource() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.f) {
                a(false, null);
            }
            this.b = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f) {
                    return -1L;
                }
                long read = super.read(buffer, j);
                if (read == -1) {
                    this.f = true;
                    a(true, null);
                    return -1L;
                }
                return read;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f43896a = okHttpClient;
        this.b = streamAllocation;
        this.f43897c = bufferedSource;
        this.d = bufferedSink;
    }

    private String g() throws IOException {
        String readUtf8LineStrict = this.f43897c.readUtf8LineStrict(this.f);
        this.f -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder a(boolean z) throws IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            StatusLine a2 = StatusLine.a(g());
            Response.Builder headers = new Response.Builder().protocol(a2.f43894a).code(a2.b).message(a2.f43895c).headers(d());
            if (z && a2.b == 100) {
                return null;
            }
            if (a2.b == 100) {
                this.e = 3;
                return headers;
            }
            this.e = 4;
            return headers;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody a(Response response) throws IOException {
        this.b.f43880c.responseBodyStart(this.b.b);
        String header = response.header("Content-Type");
        if (HttpHeaders.d(response)) {
            if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header("Transfer-Encoding"))) {
                return new RealResponseBody(header, -1L, Okio.buffer(a(response.request().url())));
            }
            long a2 = HttpHeaders.a(response);
            return a2 != -1 ? new RealResponseBody(header, a2, Okio.buffer(b(a2))) : new RealResponseBody(header, -1L, Okio.buffer(f()));
        }
        return new RealResponseBody(header, 0L, Okio.buffer(b(0L)));
    }

    public Sink a(long j) {
        if (this.e == 1) {
            this.e = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink a(Request request, long j) {
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return e();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public Source a(HttpUrl httpUrl) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void a() throws IOException {
        this.d.flush();
    }

    public void a(Headers headers, String str) throws IOException {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.d.writeUtf8(str).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.d.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.d.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.e = 1;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void a(Request request) throws IOException {
        a(request.headers(), RequestLine.a(request, this.b.c().route().proxy().type()));
    }

    void a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public Source b(long j) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void b() throws IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void c() {
        RealConnection c2 = this.b.c();
        if (c2 != null) {
            c2.a();
        }
    }

    public Headers d() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String g = g();
            if (g.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, g);
        }
    }

    public Sink e() {
        if (this.e == 1) {
            this.e = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public Source f() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        StreamAllocation streamAllocation = this.b;
        if (streamAllocation != null) {
            this.e = 5;
            streamAllocation.e();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("streamAllocation == null");
    }
}
