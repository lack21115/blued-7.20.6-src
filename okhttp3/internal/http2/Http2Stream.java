package okhttp3.internal.http2;

import com.android.internal.location.GpsNetInitiatedHandler;
import com.android.org.conscrypt.NativeCrypto;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Stream.class */
public final class Http2Stream {
    static final /* synthetic */ boolean i = !Http2Stream.class.desiredAssertionStatus();
    long b;
    final int c;
    final Http2Connection d;
    final FramingSink e;
    private Header.Listener k;
    private boolean l;
    private final FramingSource m;
    long a = 0;
    private final Deque<Headers> j = new ArrayDeque();
    final StreamTimeout f = new StreamTimeout();
    final StreamTimeout g = new StreamTimeout();
    ErrorCode h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Stream$FramingSink.class */
    public final class FramingSink implements Sink {
        static final /* synthetic */ boolean c = !Http2Stream.class.desiredAssertionStatus();
        boolean a;
        boolean b;
        private final Buffer e = new Buffer();

        FramingSink() {
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.g.enter();
                while (Http2Stream.this.b <= 0 && !this.b && !this.a && Http2Stream.this.h == null) {
                    Http2Stream.this.l();
                }
                Http2Stream.this.g.a();
                Http2Stream.this.k();
                min = Math.min(Http2Stream.this.b, this.e.size());
                Http2Stream.this.b -= min;
            }
            Http2Stream.this.g.enter();
            try {
                Http2Stream.this.d.a(Http2Stream.this.c, z && min == this.e.size(), this.e, min);
            } finally {
                Http2Stream.this.g.a();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (this.a) {
                    return;
                }
                if (!Http2Stream.this.e.b) {
                    if (this.e.size() > 0) {
                        while (this.e.size() > 0) {
                            a(true);
                        }
                    } else {
                        Http2Stream.this.d.a(Http2Stream.this.c, true, (Buffer) null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.a = true;
                }
                Http2Stream.this.d.b();
                Http2Stream.this.j();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.k();
            }
            while (this.e.size() > 0) {
                a(false);
                Http2Stream.this.d.b();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.g;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.e.write(buffer, j);
            while (this.e.size() >= NativeCrypto.SSL_OP_NO_TICKET) {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Stream$FramingSource.class */
    public final class FramingSource implements Source {
        static final /* synthetic */ boolean c = !Http2Stream.class.desiredAssertionStatus();
        boolean a;
        boolean b;
        private final Buffer e = new Buffer();
        private final Buffer f = new Buffer();
        private final long g;

        FramingSource(long j) {
            this.g = j;
        }

        private void a(long j) {
            if (!c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            Http2Stream.this.d.a(j);
        }

        void a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            long j2;
            long j3 = j;
            if (!c) {
                if (Thread.holdsLock(Http2Stream.this)) {
                    throw new AssertionError();
                }
                j3 = j;
            }
            while (j3 > 0) {
                synchronized (Http2Stream.this) {
                    z = this.b;
                    z2 = this.f.size() + j3 > this.g;
                }
                if (z2) {
                    bufferedSource.skip(j3);
                    Http2Stream.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j3);
                    return;
                } else {
                    long read = bufferedSource.read(this.e, j3);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    long j4 = j3 - read;
                    synchronized (Http2Stream.this) {
                        if (this.a) {
                            j2 = this.e.size();
                            this.e.clear();
                        } else {
                            boolean z3 = this.f.size() == 0;
                            this.f.writeAll(this.e);
                            if (z3) {
                                Http2Stream.this.notifyAll();
                            }
                            j2 = 0;
                        }
                    }
                    j3 = j4;
                    if (j2 > 0) {
                        a(j2);
                        j3 = j4;
                    }
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Header.Listener listener;
            ArrayList<Headers> arrayList;
            synchronized (Http2Stream.this) {
                this.a = true;
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
            Http2Stream.this.j();
            if (listener != null) {
                for (Headers headers : arrayList) {
                    listener.a(headers);
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
            throw new okhttp3.internal.http2.StreamResetException(r15);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0168, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(okio.Buffer r8, long r9) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 433
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Http2Stream.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Stream$StreamTimeout.class */
    public class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        public void a() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(GpsNetInitiatedHandler.NI_INTENT_KEY_TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.b(ErrorCode.CANCEL);
            Http2Stream.this.d.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream(int i2, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i2;
        this.d = http2Connection;
        this.b = http2Connection.k.d();
        this.m = new FramingSource(http2Connection.j.d());
        this.e = new FramingSink();
        this.m.b = z2;
        this.e.b = z;
        if (headers != null) {
            this.j.add(headers);
        }
        if (c() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!c() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean d(ErrorCode errorCode) {
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
                this.d.b(this.c);
                return true;
            }
        }
        throw new AssertionError();
    }

    public int a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Header> list) {
        boolean b;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.l = true;
            this.j.add(Util.b(list));
            b = b();
            notifyAll();
        }
        if (b) {
            return;
        }
        this.d.b(this.c);
    }

    public void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.d.b(this.c, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BufferedSource bufferedSource, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(bufferedSource, i2);
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.d.a(this.c, errorCode);
        }
    }

    public boolean b() {
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if ((this.m.b || this.m.a) && (this.e.b || this.e.a)) {
                if (this.l) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ErrorCode errorCode) {
        synchronized (this) {
            if (this.h == null) {
                this.h = errorCode;
                notifyAll();
            }
        }
    }

    public boolean c() {
        return this.d.a == ((this.c & 1) == 1);
    }

    public Headers d() throws IOException {
        Headers removeFirst;
        synchronized (this) {
            this.f.enter();
            while (this.j.isEmpty() && this.h == null) {
                l();
            }
            this.f.a();
            if (this.j.isEmpty()) {
                throw new StreamResetException(this.h);
            }
            removeFirst = this.j.removeFirst();
        }
        return removeFirst;
    }

    public Timeout e() {
        return this.f;
    }

    public Timeout f() {
        return this.g;
    }

    public Source g() {
        return this.m;
    }

    public Sink h() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.b = true;
            b = b();
            notifyAll();
        }
        if (b) {
            return;
        }
        this.d.b(this.c);
    }

    void j() throws IOException {
        boolean z;
        boolean b;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.m.b || !this.m.a || (!this.e.b && !this.e.a)) {
                z = false;
                b = b();
            }
            z = true;
            b = b();
        }
        if (z) {
            a(ErrorCode.CANCEL);
        } else if (b) {
        } else {
            this.d.b(this.c);
        }
    }

    void k() throws IOException {
        if (this.e.a) {
            throw new IOException("stream closed");
        }
        if (this.e.b) {
            throw new IOException("stream finished");
        }
        if (this.h != null) {
            throw new StreamResetException(this.h);
        }
    }

    void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
