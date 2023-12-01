package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache2;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache2/Relay.class */
final class Relay {

    /* renamed from: a  reason: collision with root package name */
    static final ByteString f22237a = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString b = ByteString.encodeUtf8("OkHttp DIRTY :(\n");

    /* renamed from: c  reason: collision with root package name */
    RandomAccessFile f22238c;
    Thread d;
    Source e;
    long g;
    boolean h;
    final long j;
    int k;
    private final ByteString l;
    final Buffer f = new Buffer();
    final Buffer i = new Buffer();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache2/Relay$RelaySource.class */
    class RelaySource implements Source {
        private final Timeout b = new Timeout();

        /* renamed from: c  reason: collision with root package name */
        private FileOperator f22240c;
        private long d;

        RelaySource() {
            this.f22240c = new FileOperator(Relay.this.f22238c.getChannel());
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f22240c == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f22240c = null;
            synchronized (Relay.this) {
                Relay.this.k--;
                if (Relay.this.k == 0) {
                    randomAccessFile = Relay.this.f22238c;
                    Relay.this.f22238c = null;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2;
            boolean z;
            if (this.f22240c != null) {
                synchronized (Relay.this) {
                    while (true) {
                        long j3 = this.d;
                        j2 = Relay.this.g;
                        if (j3 != j2) {
                            long size = j2 - Relay.this.i.size();
                            if (this.d >= size) {
                                long min = Math.min(j, j2 - this.d);
                                Relay.this.i.copyTo(buffer, this.d - size, min);
                                this.d += min;
                                return min;
                            }
                            z = true;
                        } else if (!Relay.this.h) {
                            if (Relay.this.d == null) {
                                Relay.this.d = Thread.currentThread();
                                z = true;
                                break;
                            }
                            this.b.waitUntilNotified(Relay.this);
                        } else {
                            return -1L;
                        }
                    }
                    if (z) {
                        long min2 = Math.min(j, j2 - this.d);
                        this.f22240c.read(this.d + 32, buffer, min2);
                        this.d += min2;
                        return min2;
                    }
                    try {
                        long read = Relay.this.e.read(Relay.this.f, Relay.this.j);
                        if (read == -1) {
                            Relay.this.a(j2);
                            synchronized (Relay.this) {
                                Relay.this.d = null;
                                Relay.this.notifyAll();
                            }
                            return -1L;
                        }
                        long min3 = Math.min(read, j);
                        Relay.this.f.copyTo(buffer, 0L, min3);
                        this.d += min3;
                        this.f22240c.write(j2 + 32, Relay.this.f.m7090clone(), read);
                        synchronized (Relay.this) {
                            Relay.this.i.write(Relay.this.f, read);
                            if (Relay.this.i.size() > Relay.this.j) {
                                Relay.this.i.skip(Relay.this.i.size() - Relay.this.j);
                            }
                            Relay.this.g += read;
                        }
                        synchronized (Relay.this) {
                            Relay.this.d = null;
                            Relay.this.notifyAll();
                        }
                        return min3;
                    } catch (Throwable th) {
                        synchronized (Relay.this) {
                            Relay.this.d = null;
                            Relay.this.notifyAll();
                            throw th;
                        }
                    }
                }
            }
            throw new IllegalStateException("closed");
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return this.b;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.f22238c = randomAccessFile;
        this.e = source;
        this.h = source == null;
        this.g = j;
        this.l = byteString;
        this.j = j2;
    }

    private void a(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.f22238c.getChannel()).write(0L, buffer, 32L);
    }

    private void b(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.l);
        new FileOperator(this.f22238c.getChannel()).write(32 + j, buffer, this.l.size());
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j);
        randomAccessFile.setLength(0L);
        relay.a(b, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, 32L);
        if (buffer.readByteString(f22237a.size()).equals(f22237a)) {
            long readLong = buffer.readLong();
            long readLong2 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.read(readLong + 32, buffer2, readLong2);
            return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L);
        }
        throw new IOException("unreadable cache file");
    }

    void a(long j) throws IOException {
        b(j);
        this.f22238c.getChannel().force(false);
        a(f22237a, j, this.l.size());
        this.f22238c.getChannel().force(false);
        synchronized (this) {
            this.h = true;
        }
        Util.closeQuietly(this.e);
        this.e = null;
    }

    public ByteString metadata() {
        return this.l;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.f22238c == null) {
                return null;
            }
            this.k++;
            return new RelaySource();
        }
    }
}
