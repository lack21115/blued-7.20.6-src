package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Writer.class */
public final class Http2Writer implements Closeable {
    private static final Logger b = Logger.getLogger(Http2.class.getName());

    /* renamed from: a  reason: collision with root package name */
    final Hpack.Writer f43955a;

    /* renamed from: c  reason: collision with root package name */
    private final BufferedSink f43956c;
    private final boolean d;
    private final Buffer e;
    private int f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.f43956c = bufferedSink;
        this.d = z;
        Buffer buffer = new Buffer();
        this.e = buffer;
        this.f43955a = new Hpack.Writer(buffer);
        this.f = 16384;
    }

    private static void a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f, j);
            long j2 = min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f43956c.write(this.e, j2);
        }
    }

    public void a() throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            if (this.d) {
                if (b.isLoggable(Level.FINE)) {
                    b.fine(Util.a(">> CONNECTION %s", Http2.f43913a.hex()));
                }
                this.f43956c.write(Http2.f43913a.toByteArray());
                this.f43956c.flush();
            }
        }
    }

    void a(int i, byte b2, Buffer buffer, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f43956c.write(buffer, i2);
        }
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (b.isLoggable(Level.FINE)) {
            b.fine(Http2.a(false, i, i2, b2, b3));
        }
        int i3 = this.f;
        if (i2 > i3) {
            throw Http2.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw Http2.a("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.f43956c, i2);
        this.f43956c.writeByte(b2 & 255);
        this.f43956c.writeByte(b3 & 255);
        this.f43956c.writeInt(i & Integer.MAX_VALUE);
    }

    public void a(int i, int i2, List<Header> list) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            this.f43955a.a(list);
            long size = this.e.size();
            int min = (int) Math.min(this.f - 4, size);
            long j = min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
            this.f43956c.writeInt(i2 & Integer.MAX_VALUE);
            this.f43956c.write(this.e, j);
            if (i3 > 0) {
                b(i, size - j);
            }
        }
    }

    public void a(int i, long j) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                throw Http2.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            }
            a(i, 4, (byte) 8, (byte) 0);
            this.f43956c.writeInt((int) j);
            this.f43956c.flush();
        }
    }

    public void a(int i, ErrorCode errorCode) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            if (errorCode.l == -1) {
                throw new IllegalArgumentException();
            }
            a(i, 4, (byte) 3, (byte) 0);
            this.f43956c.writeInt(errorCode.l);
            this.f43956c.flush();
        }
    }

    public void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            if (errorCode.l == -1) {
                throw Http2.a("errorCode.httpCode == -1", new Object[0]);
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f43956c.writeInt(i);
            this.f43956c.writeInt(errorCode.l);
            if (bArr.length > 0) {
                this.f43956c.write(bArr);
            }
            this.f43956c.flush();
        }
    }

    public void a(Settings settings) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            this.f = settings.d(this.f);
            if (settings.c() != -1) {
                this.f43955a.a(settings.c());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f43956c.flush();
        }
    }

    public void a(boolean z, int i, int i2) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f43956c.writeInt(i);
            this.f43956c.writeInt(i2);
            this.f43956c.flush();
        }
    }

    public void a(boolean z, int i, int i2, List<Header> list) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            a(z, i, list);
        }
    }

    void a(boolean z, int i, List<Header> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f43955a.a(list);
        long size = this.e.size();
        int min = (int) Math.min(this.f, size);
        long j = min;
        int i2 = (size > j ? 1 : (size == j ? 0 : -1));
        byte b2 = i2 == 0 ? (byte) 4 : (byte) 0;
        byte b3 = b2;
        if (z) {
            b3 = (byte) (b2 | 1);
        }
        a(i, min, (byte) 1, b3);
        this.f43956c.write(this.e, j);
        if (i2 > 0) {
            b(i, size - j);
        }
    }

    public void a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            a(i, b2, buffer, i2);
        }
    }

    public void b() throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            this.f43956c.flush();
        }
    }

    public void b(Settings settings) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            int i = 0;
            a(0, settings.b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.a(i)) {
                    this.f43956c.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f43956c.writeInt(settings.b(i));
                }
                i++;
            }
            this.f43956c.flush();
        }
    }

    public int c() {
        return this.f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.g = true;
            this.f43956c.close();
        }
    }
}
