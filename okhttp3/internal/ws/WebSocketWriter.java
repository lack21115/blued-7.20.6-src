package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/ws/WebSocketWriter.class */
final class WebSocketWriter {
    final boolean a;
    final Random b;
    final BufferedSink c;
    final Buffer d;
    boolean e;
    final Buffer f = new Buffer();
    final FrameSink g = new FrameSink();
    boolean h;
    private final byte[] i;
    private final Buffer.UnsafeCursor j;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/ws/WebSocketWriter$FrameSink.class */
    final class FrameSink implements Sink {
        int a;
        long b;
        boolean c;
        boolean d;

        FrameSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.a(this.a, webSocketWriter.f.size(), this.c, true);
            this.d = true;
            WebSocketWriter.this.h = false;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.a(this.a, webSocketWriter.f.size(), this.c, false);
            this.c = false;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return WebSocketWriter.this.c.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.f.write(buffer, j);
            boolean z = this.c && this.b != -1 && WebSocketWriter.this.f.size() > this.b - 8192;
            long completeSegmentByteCount = WebSocketWriter.this.f.completeSegmentByteCount();
            if (completeSegmentByteCount <= 0 || z) {
                return;
            }
            WebSocketWriter.this.a(this.a, completeSegmentByteCount, this.c, false);
            this.c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.a = z;
        this.c = bufferedSink;
        this.d = bufferedSink.buffer();
        this.b = random;
        this.i = z ? new byte[4] : null;
        this.j = z ? new Buffer.UnsafeCursor() : null;
    }

    private void b(int i, ByteString byteString) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.d.writeByte(i | 128);
        if (this.a) {
            this.d.writeByte(size | 128);
            this.b.nextBytes(this.i);
            this.d.write(this.i);
            if (size > 0) {
                long size2 = this.d.size();
                this.d.write(byteString);
                this.d.readAndWriteUnsafe(this.j);
                this.j.seek(size2);
                WebSocketProtocol.a(this.j, this.i);
                this.j.close();
            }
        } else {
            this.d.writeByte(size);
            this.d.write(byteString);
        }
        this.c.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sink a(int i, long j) {
        if (this.h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.h = true;
        this.g.a = i;
        this.g.b = j;
        this.g.c = true;
        this.g.d = false;
        return this.g;
    }

    void a(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        int i2 = i;
        if (z2) {
            i2 = i | 128;
        }
        this.d.writeByte(i2);
        int i3 = 0;
        if (this.a) {
            i3 = 128;
        }
        if (j <= 125) {
            this.d.writeByte(((int) j) | i3);
        } else if (j <= 65535) {
            this.d.writeByte(i3 | 126);
            this.d.writeShort((int) j);
        } else {
            this.d.writeByte(i3 | 127);
            this.d.writeLong(j);
        }
        if (this.a) {
            this.b.nextBytes(this.i);
            this.d.write(this.i);
            if (j > 0) {
                long size = this.d.size();
                this.d.write(this.f, j);
                this.d.readAndWriteUnsafe(this.j);
                this.j.seek(size);
                WebSocketProtocol.a(this.j, this.i);
                this.j.close();
            }
        } else {
            this.d.write(this.f, j);
        }
        this.c.emit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                WebSocketProtocol.b(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            b(8, byteString2);
        } finally {
            this.e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ByteString byteString) throws IOException {
        b(9, byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ByteString byteString) throws IOException {
        b(10, byteString);
    }
}
