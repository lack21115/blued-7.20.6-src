package okhttp3.internal.cache2;

import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache2/Relay.class */
final class Relay {

    /* renamed from: a  reason: collision with root package name */
    static final ByteString f43864a = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString b = ByteString.encodeUtf8("OkHttp DIRTY :(\n");

    /* renamed from: c  reason: collision with root package name */
    RandomAccessFile f43865c;
    Thread d;
    Source e;
    final Buffer f;
    long g;
    boolean h;
    final Buffer i;
    final long j;
    int k;
    private final ByteString l;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache2/Relay$RelaySource.class */
    class RelaySource implements Source {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Relay f43866a;
        private final Timeout b;

        /* renamed from: c  reason: collision with root package name */
        private FileOperator f43867c;
        private long d;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f43867c == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f43867c = null;
            synchronized (this.f43866a) {
                this.f43866a.k--;
                if (this.f43866a.k == 0) {
                    randomAccessFile = this.f43866a.f43865c;
                    this.f43866a.f43865c = null;
                }
            }
            if (randomAccessFile != null) {
                Util.a(randomAccessFile);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2;
            boolean z;
            if (this.f43867c != null) {
                synchronized (this.f43866a) {
                    while (true) {
                        long j3 = this.d;
                        j2 = this.f43866a.g;
                        if (j3 != j2) {
                            long size = j2 - this.f43866a.i.size();
                            if (this.d >= size) {
                                long min = Math.min(j, j2 - this.d);
                                this.f43866a.i.copyTo(buffer, this.d - size, min);
                                this.d += min;
                                return min;
                            }
                            z = true;
                        } else if (!this.f43866a.h) {
                            if (this.f43866a.d == null) {
                                this.f43866a.d = Thread.currentThread();
                                z = true;
                                break;
                            }
                            this.b.waitUntilNotified(this.f43866a);
                        } else {
                            return -1L;
                        }
                    }
                    if (z) {
                        long min2 = Math.min(j, j2 - this.d);
                        this.f43867c.b(this.d + 32, buffer, min2);
                        this.d += min2;
                        return min2;
                    }
                    try {
                        long read = this.f43866a.e.read(this.f43866a.f, this.f43866a.j);
                        if (read == -1) {
                            this.f43866a.a(j2);
                            synchronized (this.f43866a) {
                                this.f43866a.d = null;
                                this.f43866a.notifyAll();
                            }
                            return -1L;
                        }
                        long min3 = Math.min(read, j);
                        this.f43866a.f.copyTo(buffer, 0L, min3);
                        this.d += min3;
                        this.f43867c.a(j2 + 32, this.f43866a.f.clone(), read);
                        synchronized (this.f43866a) {
                            this.f43866a.i.write(this.f43866a.f, read);
                            if (this.f43866a.i.size() > this.f43866a.j) {
                                this.f43866a.i.skip(this.f43866a.i.size() - this.f43866a.j);
                            }
                            this.f43866a.g += read;
                        }
                        synchronized (this.f43866a) {
                            this.f43866a.d = null;
                            this.f43866a.notifyAll();
                        }
                        return min3;
                    } catch (Throwable th) {
                        synchronized (this.f43866a) {
                            this.f43866a.d = null;
                            this.f43866a.notifyAll();
                            throw th;
                        }
                    }
                }
            }
            throw new IllegalStateException("closed");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.b;
        }
    }

    private void a(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.f43865c.getChannel()).a(0L, buffer, 32L);
    }

    private void b(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.l);
        new FileOperator(this.f43865c.getChannel()).a(32 + j, buffer, this.l.size());
    }

    void a(long j) throws IOException {
        b(j);
        this.f43865c.getChannel().force(false);
        a(f43864a, j, this.l.size());
        this.f43865c.getChannel().force(false);
        synchronized (this) {
            this.h = true;
        }
        Util.a(this.e);
        this.e = null;
    }
}
