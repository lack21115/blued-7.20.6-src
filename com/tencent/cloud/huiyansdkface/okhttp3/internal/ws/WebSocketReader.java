package com.tencent.cloud.huiyansdkface.okhttp3.internal.ws;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/WebSocketReader.class */
final class WebSocketReader {

    /* renamed from: a  reason: collision with root package name */
    final boolean f22354a;
    final BufferedSource b;

    /* renamed from: c  reason: collision with root package name */
    final FrameCallback f22355c;
    boolean d;
    int e;
    long f;
    boolean g;
    boolean h;
    private final Buffer i = new Buffer();
    private final Buffer j = new Buffer();
    private final byte[] k;
    private final Buffer.UnsafeCursor l;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/WebSocketReader$FrameCallback.class */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.f22354a = z;
        this.b = bufferedSource;
        this.f22355c = frameCallback;
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
            if (z5 == this.f22354a) {
                throw new ProtocolException(this.f22354a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
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
            if (!this.f22354a) {
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
                    String a2 = WebSocketProtocol.a(s);
                    if (a2 != null) {
                        throw new ProtocolException(a2);
                    }
                } else {
                    str = "";
                }
                this.f22355c.onReadClose(s, str);
                this.d = true;
                return;
            case 9:
                this.f22355c.onReadPing(this.i.readByteString());
                return;
            case 10:
                this.f22355c.onReadPong(this.i.readByteString());
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
            this.f22355c.onReadMessage(this.j.readUtf8());
        } else {
            this.f22355c.onReadMessage(this.j.readByteString());
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
                if (!this.f22354a) {
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
