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
    static final ByteString a = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString b = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    RandomAccessFile c;
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
        final /* synthetic */ Relay a;
        private final Timeout b;
        private FileOperator c;
        private long d;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.c == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.c = null;
            synchronized (this.a) {
                this.a.k--;
                if (this.a.k == 0) {
                    randomAccessFile = this.a.c;
                    this.a.c = null;
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
            if (this.c != null) {
                synchronized (this.a) {
                    while (true) {
                        long j3 = this.d;
                        j2 = this.a.g;
                        if (j3 != j2) {
                            long size = j2 - this.a.i.size();
                            if (this.d >= size) {
                                long min = Math.min(j, j2 - this.d);
                                this.a.i.copyTo(buffer, this.d - size, min);
                                this.d += min;
                                return min;
                            }
                            z = true;
                        } else if (!this.a.h) {
                            if (this.a.d == null) {
                                this.a.d = Thread.currentThread();
                                z = true;
                                break;
                            }
                            this.b.waitUntilNotified(this.a);
                        } else {
                            return -1L;
                        }
                    }
                    if (z) {
                        long min2 = Math.min(j, j2 - this.d);
                        this.c.b(this.d + 32, buffer, min2);
                        this.d += min2;
                        return min2;
                    }
                    try {
                        long read = this.a.e.read(this.a.f, this.a.j);
                        if (read == -1) {
                            this.a.a(j2);
                            synchronized (this.a) {
                                this.a.d = null;
                                this.a.notifyAll();
                            }
                            return -1L;
                        }
                        long min3 = Math.min(read, j);
                        this.a.f.copyTo(buffer, 0L, min3);
                        this.d += min3;
                        this.c.a(j2 + 32, this.a.f.clone(), read);
                        synchronized (this.a) {
                            this.a.i.write(this.a.f, read);
                            if (this.a.i.size() > this.a.j) {
                                this.a.i.skip(this.a.i.size() - this.a.j);
                            }
                            this.a.g += read;
                        }
                        synchronized (this.a) {
                            this.a.d = null;
                            this.a.notifyAll();
                        }
                        return min3;
                    } catch (Throwable th) {
                        synchronized (this.a) {
                            this.a.d = null;
                            this.a.notifyAll();
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
        new FileOperator(this.c.getChannel()).a(0L, buffer, 32L);
    }

    private void b(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.l);
        new FileOperator(this.c.getChannel()).a(32 + j, buffer, this.l.size());
    }

    void a(long j) throws IOException {
        b(j);
        this.c.getChannel().force(false);
        a(a, j, this.l.size());
        this.c.getChannel().force(false);
        synchronized (this) {
            this.h = true;
        }
        Util.a(this.e);
        this.e = null;
    }
}
