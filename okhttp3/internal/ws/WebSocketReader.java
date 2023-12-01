package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/ws/WebSocketReader.class */
final class WebSocketReader {
    final boolean a;
    final BufferedSource b;
    final FrameCallback c;
    boolean d;
    int e;
    long f;
    boolean g;
    boolean h;
    private final Buffer i = new Buffer();
    private final Buffer j = new Buffer();
    private final byte[] k;
    private final Buffer.UnsafeCursor l;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/ws/WebSocketReader$FrameCallback.class */
    public interface FrameCallback {
        void a(int i, String str);

        void a(String str) throws IOException;

        void a(ByteString byteString) throws IOException;

        void b(ByteString byteString);

        void c(ByteString byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.a = z;
        this.b = bufferedSource;
        this.c = frameCallback;
        this.k = z ? null : new byte[4];
        this.l = z ? null : new Buffer.UnsafeCursor();
    }

    /* JADX WARN: Finally extract failed */
    private void b() throws IOException {
        if (this.d) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.b.timeout().timeoutNanos();
        this.b.timeout().clearTimeout();
        try {
            int readByte = this.b.readByte() & 255;
            this.b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            this.e = readByte & 15;
            this.g = (readByte & 128) != 0;
            boolean z = (readByte & 8) != 0;
            this.h = z;
            if (z && !this.g) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z2 = (readByte & 64) != 0;
            boolean z3 = (readByte & 32) != 0;
            boolean z4 = (readByte & 16) != 0;
            if (z2 || z3 || z4) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int readByte2 = this.b.readByte() & 255;
            boolean z5 = (readByte2 & 128) != 0;
            if (z5 == this.a) {
                throw new ProtocolException(this.a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = readByte2 & 127;
            this.f = j;
            if (j == 126) {
                this.f = this.b.readShort() & 65535;
            } else if (j == 127) {
                long readLong = this.b.readLong();
                this.f = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.h && this.f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                this.b.readFully(this.k);
            }
        } catch (Throwable th) {
            this.b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void c() throws IOException {
        String str;
        long j = this.f;
        if (j > 0) {
            this.b.readFully(this.i, j);
            if (!this.a) {
                this.i.readAndWriteUnsafe(this.l);
                this.l.seek(0L);
                WebSocketProtocol.a(this.l, this.k);
                this.l.close();
            }
        }
        switch (this.e) {
            case 8:
                short s = 1005;
                long size = this.i.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.i.readShort();
                    str = this.i.readUtf8();
                    String a = WebSocketProtocol.a(s);
                    if (a != null) {
                        throw new ProtocolException(a);
                    }
                } else {
                    str = "";
                }
                this.c.a(s, str);
                this.d = true;
                return;
            case 9:
                this.c.b(this.i.readByteString());
                return;
            case 10:
                this.c.c(this.i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
        }
    }

    private void d() throws IOException {
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        f();
        if (i == 1) {
            this.c.a(this.j.readUtf8());
        } else {
            this.c.a(this.j.readByteString());
        }
    }

    private void e() throws IOException {
        while (!this.d) {
            b();
            if (!this.h) {
                return;
            }
            c();
        }
    }

    private void f() throws IOException {
        while (!this.d) {
            long j = this.f;
            if (j > 0) {
                this.b.readFully(this.j, j);
                if (!this.a) {
                    this.j.readAndWriteUnsafe(this.l);
                    this.l.seek(this.j.size() - this.f);
                    WebSocketProtocol.a(this.l, this.k);
                    this.l.close();
                }
            }
            if (this.g) {
                return;
            }
            e();
            if (this.e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
            }
        }
        throw new IOException("closed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() throws IOException {
        b();
        if (this.h) {
            c();
        } else {
            d();
        }
    }
}
