package okhttp3.internal.http2;

import com.alipay.sdk.cons.b;
import com.alipay.sdk.cons.c;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.widget.j;
import com.android.internal.util.cm.QSConstants;
import com.anythink.core.api.ATCustomRuleKeys;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Hpack.class */
public final class Hpack {
    static final Header[] a = {new Header(Header.f, ""), new Header(Header.c, "GET"), new Header(Header.c, GrpcUtil.HTTP_METHOD), new Header(Header.d, BridgeUtil.SPLIT_MARK), new Header(Header.d, "/index.html"), new Header(Header.e, "http"), new Header(Header.e, b.a), new Header(Header.b, "200"), new Header(Header.b, "204"), new Header(Header.b, "206"), new Header(Header.b, "304"), new Header(Header.b, "400"), new Header(Header.b, "404"), new Header(Header.b, "500"), new Header("accept-charset", ""), new Header(GrpcUtil.CONTENT_ACCEPT_ENCODING, "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header(ATCustomRuleKeys.AGE, ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header(GrpcUtil.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header(e.d, ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header(c.f, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(QSConstants.TILE_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header(j.l, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    static final Map<ByteString, Integer> b = a();

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Hpack$Reader.class */
    static final class Reader {
        Header[] a;
        int b;
        int c;
        int d;
        private final List<Header> e;
        private final BufferedSource f;
        private final int g;
        private int h;

        Reader(int i, int i2, Source source) {
            this.e = new ArrayList();
            Header[] headerArr = new Header[8];
            this.a = headerArr;
            this.b = headerArr.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.f = Okio.buffer(source);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Reader(int i, Source source) {
            this(i, i, source);
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int i3 = i;
                int i4 = 0;
                for (int length = this.a.length - 1; length >= this.b && i3 > 0; length--) {
                    i3 -= this.a[length].i;
                    this.d -= this.a[length].i;
                    this.c--;
                    i4++;
                }
                Header[] headerArr = this.a;
                int i5 = this.b;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i4, this.c);
                this.b += i4;
                i2 = i4;
            }
            return i2;
        }

        private void a(int i, Header header) {
            this.e.add(header);
            int i2 = header.i;
            int i3 = i2;
            if (i != -1) {
                i3 = i2 - this.a[c(i)].i;
            }
            int i4 = this.h;
            if (i3 > i4) {
                e();
                return;
            }
            int a = a((this.d + i3) - i4);
            if (i == -1) {
                int i5 = this.c;
                Header[] headerArr = this.a;
                if (i5 + 1 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.b = this.a.length - 1;
                    this.a = headerArr2;
                }
                int i6 = this.b;
                this.b = i6 - 1;
                this.a[i6] = header;
                this.c++;
            } else {
                this.a[i + c(i) + a] = header;
            }
            this.d += i3;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(Hpack.a[i]);
                return;
            }
            int c = c(i - Hpack.a.length);
            if (c >= 0) {
                Header[] headerArr = this.a;
                if (c < headerArr.length) {
                    this.e.add(headerArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.b + 1 + i;
        }

        private void d() {
            int i = this.h;
            int i2 = this.d;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    a(i2 - i);
                }
            }
        }

        private void d(int i) throws IOException {
            this.e.add(new Header(f(i), c()));
        }

        private void e() {
            Arrays.fill(this.a, (Object) null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private void e(int i) throws IOException {
            a(-1, new Header(f(i), c()));
        }

        private ByteString f(int i) throws IOException {
            if (g(i)) {
                return Hpack.a[i].g;
            }
            int c = c(i - Hpack.a.length);
            if (c >= 0) {
                Header[] headerArr = this.a;
                if (c < headerArr.length) {
                    return headerArr[c].g;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void f() throws IOException {
            this.e.add(new Header(Hpack.a(c()), c()));
        }

        private void g() throws IOException {
            a(-1, new Header(Hpack.a(c()), c()));
        }

        private boolean g(int i) {
            return i >= 0 && i <= Hpack.a.length - 1;
        }

        private int h() throws IOException {
            return this.f.readByte() & 255;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int h = h();
                if ((h & 128) == 0) {
                    return i2 + (h << i5);
                }
                i2 += (h & 127) << i5;
                i4 = i5 + 7;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.f.exhausted()) {
                int readByte = this.f.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    b(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    e(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a = a(readByte, 31);
                    this.h = a;
                    if (a < 0 || a > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (readByte == 16 || readByte == 0) {
                    f();
                } else {
                    d(a(readByte, 15) - 1);
                }
            }
        }

        public List<Header> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        ByteString c() throws IOException {
            int h = h();
            boolean z = (h & 128) == 128;
            int a = a(h, 127);
            return z ? ByteString.of(Huffman.a().a(this.f.readByteArray(a))) : this.f.readByteString(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Hpack$Writer.class */
    public static final class Writer {
        int a;
        int b;
        Header[] c;
        int d;
        int e;
        int f;
        private final Buffer g;
        private final boolean h;
        private int i;
        private boolean j;

        Writer(int i, boolean z, Buffer buffer) {
            this.i = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.c = headerArr;
            this.d = headerArr.length - 1;
            this.e = 0;
            this.f = 0;
            this.a = i;
            this.b = i;
            this.h = z;
            this.g = buffer;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            Arrays.fill(this.c, (Object) null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private void a(Header header) {
            int i = header.i;
            int i2 = this.b;
            if (i > i2) {
                a();
                return;
            }
            b((this.f + i) - i2);
            int i3 = this.e;
            Header[] headerArr = this.c;
            if (i3 + 1 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.d = this.c.length - 1;
                this.c = headerArr2;
            }
            int i4 = this.d;
            this.d = i4 - 1;
            this.c[i4] = header;
            this.e++;
            this.f += i;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int i3 = i;
                int i4 = 0;
                for (int length = this.c.length - 1; length >= this.d && i3 > 0; length--) {
                    i3 -= this.c[length].i;
                    this.f -= this.c[length].i;
                    this.e--;
                    i4++;
                }
                Header[] headerArr = this.c;
                int i5 = this.d;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i4, this.e);
                Header[] headerArr2 = this.c;
                int i6 = this.d;
                Arrays.fill(headerArr2, i6 + 1, i6 + 1 + i4, (Object) null);
                this.d += i4;
                i2 = i4;
            }
            return i2;
        }

        private void b() {
            int i = this.b;
            int i2 = this.f;
            if (i < i2) {
                if (i == 0) {
                    a();
                } else {
                    b(i2 - i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.a = i;
            int min = Math.min(i, 16384);
            int i2 = this.b;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.i = Math.min(this.i, min);
            }
            this.j = true;
            this.b = min;
            b();
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.g.writeByte(i | i3);
                return;
            }
            this.g.writeByte(i3 | i2);
            int i4 = i - i2;
            while (true) {
                int i5 = i4;
                if (i5 < 128) {
                    this.g.writeByte(i5);
                    return;
                } else {
                    this.g.writeByte(128 | (i5 & 127));
                    i4 = i5 >>> 7;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<Header> list) throws IOException {
            int i;
            int i2;
            if (this.j) {
                int i3 = this.i;
                if (i3 < this.b) {
                    a(i3, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size) {
                    return;
                }
                Header header = list.get(i5);
                ByteString asciiLowercase = header.g.toAsciiLowercase();
                ByteString byteString = header.h;
                Integer num = Hpack.b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (Util.a(Hpack.a[i - 1].h, byteString)) {
                            i2 = i;
                        } else if (Util.a(Hpack.a[i].h, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                int i6 = i;
                int i7 = i2;
                if (i == -1) {
                    int i8 = this.d + 1;
                    int length = this.c.length;
                    while (true) {
                        i6 = i;
                        i7 = i2;
                        if (i8 >= length) {
                            break;
                        }
                        int i9 = i2;
                        if (Util.a(this.c[i8].g, asciiLowercase)) {
                            if (Util.a(this.c[i8].h, byteString)) {
                                i6 = Hpack.a.length + (i8 - this.d);
                                i7 = i2;
                                break;
                            }
                            i9 = i2;
                            if (i2 == -1) {
                                i9 = (i8 - this.d) + Hpack.a.length;
                            }
                        }
                        i8++;
                        i2 = i9;
                    }
                }
                if (i6 != -1) {
                    a(i6, 127, 128);
                } else if (i7 == -1) {
                    this.g.writeByte(64);
                    a(asciiLowercase);
                    a(byteString);
                    a(header);
                } else if (!asciiLowercase.startsWith(Header.a) || Header.f.equals(asciiLowercase)) {
                    a(i7, 63, 64);
                    a(byteString);
                    a(header);
                } else {
                    a(i7, 15, 0);
                    a(byteString);
                }
                i4 = i5 + 1;
            }
        }

        void a(ByteString byteString) throws IOException {
            if (!this.h || Huffman.a().a(byteString) >= byteString.size()) {
                a(byteString.size(), 127, 0);
                this.g.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.a().a(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            a(readByteString.size(), 127, 128);
            this.g.write(readByteString);
        }
    }

    private Hpack() {
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            int i2 = i;
            Header[] headerArr = a;
            if (i2 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i2].g)) {
                linkedHashMap.put(a[i2].g, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return byteString;
            }
            byte b2 = byteString.getByte(i2);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
            i = i2 + 1;
        }
    }
}
