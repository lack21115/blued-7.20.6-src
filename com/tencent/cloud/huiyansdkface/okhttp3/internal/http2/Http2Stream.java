package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Header;
import com.tencent.cloud.huiyansdkface.okio.AsyncTimeout;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Stream.class */
public final class Http2Stream {
    static final /* synthetic */ boolean i = !Http2Stream.class.desiredAssertionStatus();
    long b;

    /* renamed from: c  reason: collision with root package name */
    final int f36003c;
    final Http2Connection d;
    final FramingSink e;
    private Header.Listener k;
    private boolean l;
    private final FramingSource m;

    /* renamed from: a  reason: collision with root package name */
    long f36002a = 0;
    private final Deque<Headers> j = new ArrayDeque();
    final StreamTimeout f = new StreamTimeout();
    final StreamTimeout g = new StreamTimeout();
    ErrorCode h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Stream$FramingSink.class */
    public final class FramingSink implements Sink {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f36004c = !Http2Stream.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        boolean f36005a;
        boolean b;
        private final Buffer e = new Buffer();

        FramingSink() {
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.g.enter();
                while (Http2Stream.this.b <= 0 && !this.b && !this.f36005a && Http2Stream.this.h == null) {
                    Http2Stream.this.d();
                }
                Http2Stream.this.g.exitAndThrowIfTimedOut();
                Http2Stream.this.c();
                min = Math.min(Http2Stream.this.b, this.e.size());
                Http2Stream.this.b -= min;
            }
            Http2Stream.this.g.enter();
            try {
                Http2Stream.this.d.writeData(Http2Stream.this.f36003c, z && min == this.e.size(), this.e, min);
            } finally {
                Http2Stream.this.g.exitAndThrowIfTimedOut();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f36004c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (this.f36005a) {
                    return;
                }
                if (!Http2Stream.this.e.b) {
                    if (this.e.size() > 0) {
                        while (this.e.size() > 0) {
                            a(true);
                        }
                    } else {
                        Http2Stream.this.d.writeData(Http2Stream.this.f36003c, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f36005a = true;
                }
                Http2Stream.this.d.flush();
                Http2Stream.this.b();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!f36004c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.c();
            }
            while (this.e.size() > 0) {
                a(false);
                Http2Stream.this.d.flush();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.g;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!f36004c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.e.write(buffer, j);
            while (this.e.size() >= 16384) {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Stream$FramingSource.class */
    public final class FramingSource implements Source {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f36006c = !Http2Stream.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        boolean f36007a;
        boolean b;
        private final Buffer e = new Buffer();
        private final Buffer f = new Buffer();
        private final long g;

        FramingSource(long j) {
            this.g = j;
        }

        private void a(long j) {
            if (!f36006c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            Http2Stream.this.d.a(j);
        }

        void a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            long j2 = j;
            if (!f36006c) {
                if (Thread.holdsLock(Http2Stream.this)) {
                    throw new AssertionError();
                }
                j2 = j;
            }
            while (j2 > 0) {
                synchronized (Http2Stream.this) {
                    z = this.b;
                    z2 = this.f.size() + j2 > this.g;
                }
                if (z2) {
                    bufferedSource.skip(j2);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j2);
                    return;
                } else {
                    long read = bufferedSource.read(this.e, j2);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    j2 -= read;
                    synchronized (Http2Stream.this) {
                        boolean z3 = this.f.size() == 0;
                        this.f.writeAll(this.e);
                        if (z3) {
                            Http2Stream.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Header.Listener listener;
            ArrayList<Headers> arrayList;
            synchronized (Http2Stream.this) {
                this.f36007a = true;
                size = this.f.size();
                this.f.clear();
                listener = null;
                if (Http2Stream.this.j.isEmpty() || Http2Stream.this.k == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(Http2Stream.this.j);
                    Http2Stream.this.j.clear();
                    listener = Http2Stream.this.k;
                }
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                a(size);
            }
            Http2Stream.this.b();
            if (listener != null) {
                for (Headers headers : arrayList) {
                    listener.onHeaders(headers);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0140, code lost:
            if (r11 == (-1)) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0143, code lost:
            a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x014b, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x014e, code lost:
            if (r15 != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0151, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x015e, code lost:
            throw new com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.StreamResetException(r15);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0168, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(com.tencent.cloud.huiyansdkface.okio.Buffer r8, long r9) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 433
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream.FramingSource.read(com.tencent.cloud.huiyansdkface.okio.Buffer, long):long");
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return Http2Stream.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Stream$StreamTimeout.class */
    public class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream(int i2, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        this.f36003c = i2;
        this.d = http2Connection;
        this.b = http2Connection.l.d();
        this.m = new FramingSource(http2Connection.k.d());
        this.e = new FramingSink();
        this.m.b = z2;
        this.e.b = z;
        if (headers != null) {
            this.j.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean b(ErrorCode errorCode) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.h != null) {
                    return false;
                }
                if (this.m.b && this.e.b) {
                    return false;
                }
                this.h = errorCode;
                notifyAll();
                this.d.b(this.f36003c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        boolean isOpen;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.b = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.d.b(this.f36003c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ErrorCode errorCode) {
        synchronized (this) {
            if (this.h == null) {
                this.h = errorCode;
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BufferedSource bufferedSource, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(bufferedSource, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Header> list) {
        boolean isOpen;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.l = true;
            this.j.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.d.b(this.f36003c);
    }

    void b() throws IOException {
        boolean z;
        boolean isOpen;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.m.b || !this.m.f36007a || (!this.e.b && !this.e.f36005a)) {
                z = false;
                isOpen = isOpen();
            }
            z = true;
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (isOpen) {
        } else {
            this.d.b(this.f36003c);
        }
    }

    void c() throws IOException {
        if (this.e.f36005a) {
            throw new IOException("stream closed");
        }
        if (this.e.b) {
            throw new IOException("stream finished");
        }
        if (this.h != null) {
            throw new StreamResetException(this.h);
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (b(errorCode)) {
            this.d.b(this.f36003c, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (b(errorCode)) {
            this.d.a(this.f36003c, errorCode);
        }
    }

    void d() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Http2Connection getConnection() {
        return this.d;
    }

    public ErrorCode getErrorCode() {
        ErrorCode errorCode;
        synchronized (this) {
            errorCode = this.h;
        }
        return errorCode;
    }

    public int getId() {
        return this.f36003c;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.l && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    public Source getSource() {
        return this.m;
    }

    public boolean isLocallyInitiated() {
        return this.d.f35983a == ((this.f36003c & 1) == 1);
    }

    public boolean isOpen() {
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if ((this.m.b || this.m.f36007a) && (this.e.b || this.e.f36005a)) {
                if (this.l) {
                    return false;
                }
            }
            return true;
        }
    }

    public Timeout readTimeout() {
        return this.f;
    }

    public void setHeadersListener(Header.Listener listener) {
        synchronized (this) {
            this.k = listener;
            if (!this.j.isEmpty() && listener != null) {
                notifyAll();
            }
        }
    }

    public Headers takeHeaders() throws IOException {
        Headers removeFirst;
        synchronized (this) {
            this.f.enter();
            while (this.j.isEmpty() && this.h == null) {
                d();
            }
            this.f.exitAndThrowIfTimedOut();
            if (this.j.isEmpty()) {
                throw new StreamResetException(this.h);
            }
            removeFirst = this.j.removeFirst();
        }
        return removeFirst;
    }

    public void writeHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            this.l = true;
            if (z) {
                z2 = false;
                z3 = false;
            } else {
                this.e.b = true;
                z2 = true;
                z3 = true;
            }
        }
        boolean z5 = z2;
        if (!z2) {
            synchronized (this.d) {
                z4 = this.d.j == 0;
            }
            z5 = z4;
        }
        this.d.a(this.f36003c, z3, list);
        if (z5) {
            this.d.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.g;
    }
}
