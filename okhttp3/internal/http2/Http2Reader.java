package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Reader.class */
public final class Http2Reader implements Closeable {
    static final Logger a = Logger.getLogger(Http2.class.getName());
    final Hpack.Reader b;
    private final BufferedSource c;
    private final ContinuationSource d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Reader$ContinuationSource.class */
    public static final class ContinuationSource implements Source {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final BufferedSource f;

        ContinuationSource(BufferedSource bufferedSource) {
            this.f = bufferedSource;
        }

        private void a() throws IOException {
            int i = this.c;
            int a = Http2Reader.a(this.f);
            this.d = a;
            this.a = a;
            byte readByte = (byte) (this.f.readByte() & 255);
            this.b = (byte) (this.f.readByte() & 255);
            if (Http2Reader.a.isLoggable(Level.FINE)) {
                Http2Reader.a.fine(Http2.a(true, this.c, this.a, readByte, this.b));
            }
            int readInt = this.f.readInt() & Integer.MAX_VALUE;
            this.c = readInt;
            if (readByte != 9) {
                throw Http2.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw Http2.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.d;
                if (i != 0) {
                    long read = this.f.read(buffer, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.d = (int) (this.d - read);
                    return read;
                }
                this.f.skip(this.e);
                this.e = (short) 0;
                if ((this.b & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f.timeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Reader$Handler.class */
    public interface Handler {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<Header> list) throws IOException;

        void a(int i, long j);

        void a(int i, ErrorCode errorCode);

        void a(int i, ErrorCode errorCode, ByteString byteString);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<Header> list);

        void a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void a(boolean z, Settings settings);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.c = bufferedSource;
        this.e = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.d = continuationSource;
        this.b = new Hpack.Reader(4096, continuationSource);
    }

    static int a(int i, byte b, short s) throws IOException {
        int i2 = i;
        if ((b & 8) != 0) {
            i2 = i - 1;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw Http2.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }

    static int a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private List<Header> a(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.d;
        continuationSource.d = i;
        continuationSource.a = i;
        this.d.e = s;
        this.d.b = b;
        this.d.c = i2;
        this.b.a();
        return this.b.b();
    }

    private void a(Handler handler, int i) throws IOException {
        int readInt = this.c.readInt();
        handler.a(i, readInt & Integer.MAX_VALUE, (this.c.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 8) != 0) {
            s = (short) (this.c.readByte() & 255);
        }
        int i3 = i;
        if ((b & 32) != 0) {
            a(handler, i2);
            i3 = i - 5;
        }
        handler.a(z, i2, -1, a(a(i3, b, s), s, b, i2));
    }

    private void b(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = true;
        boolean z2 = (b & 1) != 0;
        if ((b & 32) == 0) {
            z = false;
        }
        if (z) {
            throw Http2.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        if ((b & 8) != 0) {
            s = (short) (this.c.readByte() & 255);
        }
        handler.a(z2, i2, this.c, a(i, b, s));
        this.c.skip(s);
    }

    private void c(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(handler, i2);
    }

    private void d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int readInt = this.c.readInt();
        ErrorCode a2 = ErrorCode.a(readInt);
        if (a2 == null) {
            throw Http2.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        handler.a(i2, a2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        throw okhttp3.internal.http2.Http2.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", java.lang.Integer.valueOf(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(okhttp3.internal.http2.Http2Reader.Handler r7, int r8, byte r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.e(okhttp3.internal.http2.Http2Reader$Handler, int, byte, int):void");
    }

    private void f(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        if ((b & 8) != 0) {
            s = (short) (this.c.readByte() & 255);
        }
        handler.a(i2, this.c.readInt() & Integer.MAX_VALUE, a(a(i - 4, b, s), s, b, i2));
    }

    private void g(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw Http2.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.b("TYPE_PING streamId != 0", new Object[0]);
        }
        int readInt = this.c.readInt();
        int readInt2 = this.c.readInt();
        if ((b & 1) != 0) {
            z = true;
        }
        handler.a(z, readInt, readInt2);
    }

    private void h(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.c.readInt();
        int readInt2 = this.c.readInt();
        int i3 = i - 8;
        ErrorCode a2 = ErrorCode.a(readInt2);
        if (a2 == null) {
            throw Http2.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.c.readByteString(i3);
        }
        handler.a(readInt, a2, byteString);
    }

    private void i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = this.c.readInt() & 2147483647L;
        if (readInt == 0) {
            throw Http2.b("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        handler.a(i2, readInt);
    }

    public void a(Handler handler) throws IOException {
        if (this.e) {
            if (!a(true, handler)) {
                throw Http2.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString readByteString = this.c.readByteString(Http2.a.size());
        if (a.isLoggable(Level.FINE)) {
            a.fine(Util.a("<< CONNECTION %s", readByteString.hex()));
        }
        if (!Http2.a.equals(readByteString)) {
            throw Http2.b("Expected a connection header but was %s", readByteString.utf8());
        }
    }

    public boolean a(boolean z, Handler handler) throws IOException {
        try {
            this.c.require(9L);
            int a2 = a(this.c);
            if (a2 < 0 || a2 > 16384) {
                throw Http2.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte readByte = (byte) (this.c.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.c.readByte() & 255);
                int readInt = this.c.readInt() & Integer.MAX_VALUE;
                if (a.isLoggable(Level.FINE)) {
                    a.fine(Http2.a(true, readInt, a2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        b(handler, a2, readByte2, readInt);
                        return true;
                    case 1:
                        a(handler, a2, readByte2, readInt);
                        return true;
                    case 2:
                        c(handler, a2, readByte2, readInt);
                        return true;
                    case 3:
                        d(handler, a2, readByte2, readInt);
                        return true;
                    case 4:
                        e(handler, a2, readByte2, readInt);
                        return true;
                    case 5:
                        f(handler, a2, readByte2, readInt);
                        return true;
                    case 6:
                        g(handler, a2, readByte2, readInt);
                        return true;
                    case 7:
                        h(handler, a2, readByte2, readInt);
                        return true;
                    case 8:
                        i(handler, a2, readByte2, readInt);
                        return true;
                    default:
                        this.c.skip(a2);
                        return true;
                }
            }
            throw Http2.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException e) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }
}
