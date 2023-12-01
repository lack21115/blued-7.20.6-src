package com.tencent.cloud.huiyansdkface.okhttp3.internal.http1;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealResponseBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RequestLine;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.StatusLine;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ForwardingTimeout;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec.class */
public final class Http1Codec implements HttpCodec {

    /* renamed from: a  reason: collision with root package name */
    final OkHttpClient f35960a;
    final StreamAllocation b;

    /* renamed from: c  reason: collision with root package name */
    final BufferedSource f35961c;
    final BufferedSink d;
    int e = 0;
    private long f = 262144;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec$AbstractSource.class */
    public abstract class AbstractSource implements Source {

        /* renamed from: a  reason: collision with root package name */
        protected final ForwardingTimeout f35962a;
        protected boolean b;

        /* renamed from: c  reason: collision with root package name */
        protected long f35963c;

        private AbstractSource() {
            this.f35962a = new ForwardingTimeout(Http1Codec.this.f35961c.timeout());
            this.f35963c = 0L;
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.e == 6) {
                return;
            }
            if (Http1Codec.this.e != 5) {
                throw new IllegalStateException("state: " + Http1Codec.this.e);
            }
            Http1Codec.this.a(this.f35962a);
            Http1Codec.this.e = 6;
            if (Http1Codec.this.b != null) {
                Http1Codec.this.b.streamFinished(!z, Http1Codec.this, this.f35963c, iOException);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = Http1Codec.this.f35961c.read(buffer, j);
                if (read > 0) {
                    this.f35963c += read;
                }
                return read;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return this.f35962a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec$ChunkedSink.class */
    public final class ChunkedSink implements Sink {
        private final ForwardingTimeout b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f35965c;

        ChunkedSink() {
            this.b = new ForwardingTimeout(Http1Codec.this.d.timeout());
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this) {
                if (this.f35965c) {
                    return;
                }
                this.f35965c = true;
                Http1Codec.this.d.writeUtf8("0\r\n\r\n");
                Http1Codec.this.a(this.b);
                Http1Codec.this.e = 3;
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (this) {
                if (this.f35965c) {
                    return;
                }
                Http1Codec.this.d.flush();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return this.b;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f35965c) {
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
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec$ChunkedSource.class */
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
                Http1Codec.this.f35961c.readUtf8LineStrict();
            }
            try {
                this.g = Http1Codec.this.f35961c.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.f35961c.readUtf8LineStrict().trim();
                if (this.g < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.f35960a.cookieJar(), this.f, Http1Codec.this.readHeaders());
                    a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.h && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.b = true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec.AbstractSource, com.tencent.cloud.huiyansdkface.okio.Source
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
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec$FixedLengthSink.class */
    public final class FixedLengthSink implements Sink {
        private final ForwardingTimeout b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f35967c;
        private long d;

        FixedLengthSink(long j) {
            this.b = new ForwardingTimeout(Http1Codec.this.d.timeout());
            this.d = j;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f35967c) {
                return;
            }
            this.f35967c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1Codec.this.a(this.b);
            Http1Codec.this.e = 3;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f35967c) {
                return;
            }
            Http1Codec.this.d.flush();
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return this.b;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f35967c) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.size(), 0L, j);
            if (j <= this.d) {
                Http1Codec.this.d.write(buffer, j);
                this.d -= j;
                return;
            }
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec$FixedLengthSource.class */
    public class FixedLengthSource extends AbstractSource {
        private long f;

        FixedLengthSource(long j) throws IOException {
            super();
            this.f = j;
            if (j == 0) {
                a(true, null);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.b = true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec.AbstractSource, com.tencent.cloud.huiyansdkface.okio.Source
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
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http1/Http1Codec$UnknownLengthSource.class */
    public class UnknownLengthSource extends AbstractSource {
        private boolean f;

        UnknownLengthSource() {
            super();
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.f) {
                a(false, null);
            }
            this.b = true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http1.Http1Codec.AbstractSource, com.tencent.cloud.huiyansdkface.okio.Source
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
        this.f35960a = okHttpClient;
        this.b = streamAllocation;
        this.f35961c = bufferedSource;
        this.d = bufferedSink;
    }

    private String a() throws IOException {
        String readUtf8LineStrict = this.f35961c.readUtf8LineStrict(this.f);
        this.f -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    void a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void cancel() {
        RealConnection connection = this.b.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j) {
        if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.d.flush();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.d.flush();
    }

    public boolean isClosed() {
        return this.e == 6;
    }

    public Sink newChunkedSink() {
        if (this.e == 1) {
            this.e = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.e == 1) {
            this.e = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.e == 4) {
            this.e = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        StreamAllocation streamAllocation = this.b;
        if (streamAllocation != null) {
            this.e = 5;
            streamAllocation.noNewStreams();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("streamAllocation == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        this.b.f35944c.responseBodyStart(this.b.b);
        String header = response.header("Content-Type");
        if (HttpHeaders.hasBody(response)) {
            if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header("Transfer-Encoding"))) {
                return new RealResponseBody(header, -1L, Okio.buffer(newChunkedSource(response.request().url())));
            }
            long contentLength = HttpHeaders.contentLength(response);
            return contentLength != -1 ? new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength))) : new RealResponseBody(header, -1L, Okio.buffer(newUnknownLengthSource()));
        }
        return new RealResponseBody(header, 0L, Okio.buffer(newFixedLengthSource(0L)));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String a2 = a();
            if (a2.length() == 0) {
                return builder.build();
            }
            Internal.f35902a.addLenient(builder, a2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            StatusLine parse = StatusLine.parse(a());
            Response.Builder headers = new Response.Builder().protocol(parse.f35958a).code(parse.b).message(parse.f35959c).headers(readHeaders());
            if (z && parse.b == 100) {
                return null;
            }
            if (parse.b == 100) {
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

    public void writeRequest(Headers headers, String str) throws IOException {
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

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.b.connection().route().proxy().type()));
    }
}
