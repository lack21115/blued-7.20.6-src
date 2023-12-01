package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Hpack;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Reader.class */
public final class Http2Reader implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f22307a = Logger.getLogger(Http2.class.getName());
    final Hpack.Reader b;

    /* renamed from: c  reason: collision with root package name */
    private final BufferedSource f22308c;
    private final ContinuationSource d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Reader$ContinuationSource.class */
    public static final class ContinuationSource implements Source {

        /* renamed from: a  reason: collision with root package name */
        int f22309a;
        byte b;

        /* renamed from: c  reason: collision with root package name */
        int f22310c;
        int d;
        short e;
        private final BufferedSource f;

        ContinuationSource(BufferedSource bufferedSource) {
            this.f = bufferedSource;
        }

        private void a() throws IOException {
            int i = this.f22310c;
            int a2 = Http2Reader.a(this.f);
            this.d = a2;
            this.f22309a = a2;
            byte readByte = (byte) (this.f.readByte() & 255);
            this.b = (byte) (this.f.readByte() & 255);
            if (Http2Reader.f22307a.isLoggable(Level.FINE)) {
                Http2Reader.f22307a.fine(Http2.a(true, this.f22310c, this.f22309a, readByte, this.b));
            }
            int readInt = this.f.readInt() & Integer.MAX_VALUE;
            this.f22310c = readInt;
            if (readByte != 9) {
                throw Http2.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw Http2.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
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

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return this.f.timeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Reader$Handler.class */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f22308c = bufferedSource;
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
        continuationSource.f22309a = i;
        this.d.e = s;
        this.d.b = b;
        this.d.f22310c = i2;
        this.b.a();
        return this.b.getAndResetHeaderList();
    }

    private void a(Handler handler, int i) throws IOException {
        int readInt = this.f22308c.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.f22308c.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 8) != 0) {
            s = (short) (this.f22308c.readByte() & 255);
        }
        int i3 = i;
        if ((b & 32) != 0) {
            a(handler, i2);
            i3 = i - 5;
        }
        handler.headers(z, i2, -1, a(a(i3, b, s), s, b, i2));
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
            s = (short) (this.f22308c.readByte() & 255);
        }
        handler.data(z2, i2, this.f22308c, a(i, b, s));
        this.f22308c.skip(s);
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
        int readInt = this.f22308c.readInt();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
        if (fromHttp2 == null) {
            throw Http2.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        handler.rstStream(i2, fromHttp2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        throw com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", java.lang.Integer.valueOf(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler r7, int r8, byte r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.e(com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader$Handler, int, byte, int):void");
    }

    private void f(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw Http2.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        if ((b & 8) != 0) {
            s = (short) (this.f22308c.readByte() & 255);
        }
        handler.pushPromise(i2, this.f22308c.readInt() & Integer.MAX_VALUE, a(a(i - 4, b, s), s, b, i2));
    }

    private void g(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw Http2.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.b("TYPE_PING streamId != 0", new Object[0]);
        }
        int readInt = this.f22308c.readInt();
        int readInt2 = this.f22308c.readInt();
        if ((b & 1) != 0) {
            z = true;
        }
        handler.ping(z, readInt, readInt2);
    }

    private void h(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.f22308c.readInt();
        int readInt2 = this.f22308c.readInt();
        int i3 = i - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw Http2.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.f22308c.readByteString(i3);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    private void i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = this.f22308c.readInt() & 2147483647L;
        if (readInt == 0) {
            throw Http2.b("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        handler.windowUpdate(i2, readInt);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22308c.close();
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.f22308c.require(9L);
            int a2 = a(this.f22308c);
            if (a2 < 0 || a2 > 16384) {
                throw Http2.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte readByte = (byte) (this.f22308c.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f22308c.readByte() & 255);
                int readInt = this.f22308c.readInt() & Integer.MAX_VALUE;
                if (f22307a.isLoggable(Level.FINE)) {
                    f22307a.fine(Http2.a(true, readInt, a2, readByte, readByte2));
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
                        this.f22308c.skip(a2);
                        return true;
                }
            }
            throw Http2.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException e) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.e) {
            if (!nextFrame(true, handler)) {
                throw Http2.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString readByteString = this.f22308c.readByteString(Http2.f22286a.size());
        if (f22307a.isLoggable(Level.FINE)) {
            f22307a.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
        }
        if (!Http2.f22286a.equals(readByteString)) {
            throw Http2.b("Expected a connection header but was %s", readByteString.utf8());
        }
    }
}
