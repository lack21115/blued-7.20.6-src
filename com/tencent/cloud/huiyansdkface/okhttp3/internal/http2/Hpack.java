package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import android.net.http.Headers;
import android.provider.Downloads;
import com.baidu.mobads.sdk.internal.ch;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Hpack.class */
public final class Hpack {

    /* renamed from: a  reason: collision with root package name */
    static final Header[] f22281a = {new Header(Header.f, ""), new Header(Header.f22280c, "GET"), new Header(Header.f22280c, "POST"), new Header(Header.d, "/"), new Header(Header.d, "/index.html"), new Header(Header.e, "http"), new Header(Header.e, "https"), new Header(Header.b, BasicPushStatus.SUCCESS_CODE), new Header(Header.b, "204"), new Header(Header.b, "206"), new Header(Header.b, "304"), new Header(Header.b, "400"), new Header(Header.b, ch.b), new Header(Header.b, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header(Headers.ACCEPT_RANGES, ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, ""), new Header("cache-control", ""), new Header(Headers.CONTENT_DISPOSITION, ""), new Header(Headers.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header(Headers.CONTENT_LEN, ""), new Header("content-location", ""), new Header("content-range", ""), new Header(Headers.CONTENT_TYPE, ""), new Header("cookie", ""), new Header("date", ""), new Header(Headers.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header(DownloadUtils.IF_MODIFIED_SINCE, ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header(Headers.PROXY_AUTHENTICATE, ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header(Downloads.Impl.COLUMN_REFERER, ""), new Header(Headers.REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header(Headers.SET_COOKIE, ""), new Header("strict-transport-security", ""), new Header(Headers.TRANSFER_ENCODING, ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header(Headers.WWW_AUTHENTICATE, "")};
    static final Map<ByteString, Integer> b = a();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Hpack$Reader.class */
    static final class Reader {

        /* renamed from: a  reason: collision with root package name */
        Header[] f22282a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f22283c;
        int d;
        private final List<Header> e;
        private final BufferedSource f;
        private final int g;
        private int h;

        Reader(int i, int i2, Source source) {
            this.e = new ArrayList();
            Header[] headerArr = new Header[8];
            this.f22282a = headerArr;
            this.b = headerArr.length - 1;
            this.f22283c = 0;
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
                for (int length = this.f22282a.length - 1; length >= this.b && i3 > 0; length--) {
                    i3 -= this.f22282a[length].i;
                    this.d -= this.f22282a[length].i;
                    this.f22283c--;
                    i4++;
                }
                Header[] headerArr = this.f22282a;
                int i5 = this.b;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i4, this.f22283c);
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
                i3 = i2 - this.f22282a[c(i)].i;
            }
            int i4 = this.h;
            if (i3 > i4) {
                d();
                return;
            }
            int a2 = a((this.d + i3) - i4);
            if (i == -1) {
                int i5 = this.f22283c;
                Header[] headerArr = this.f22282a;
                if (i5 + 1 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.b = this.f22282a.length - 1;
                    this.f22282a = headerArr2;
                }
                int i6 = this.b;
                this.b = i6 - 1;
                this.f22282a[i6] = header;
                this.f22283c++;
            } else {
                this.f22282a[i + c(i) + a2] = header;
            }
            this.d += i3;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(Hpack.f22281a[i]);
                return;
            }
            int c2 = c(i - Hpack.f22281a.length);
            if (c2 >= 0) {
                Header[] headerArr = this.f22282a;
                if (c2 < headerArr.length) {
                    this.e.add(headerArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.b + 1 + i;
        }

        private void c() {
            int i = this.h;
            int i2 = this.d;
            if (i < i2) {
                if (i == 0) {
                    d();
                } else {
                    a(i2 - i);
                }
            }
        }

        private void d() {
            Arrays.fill(this.f22282a, (Object) null);
            this.b = this.f22282a.length - 1;
            this.f22283c = 0;
            this.d = 0;
        }

        private void d(int i) throws IOException {
            this.e.add(new Header(f(i), b()));
        }

        private void e() throws IOException {
            this.e.add(new Header(Hpack.a(b()), b()));
        }

        private void e(int i) throws IOException {
            a(-1, new Header(f(i), b()));
        }

        private ByteString f(int i) throws IOException {
            Header header;
            if (!g(i)) {
                int c2 = c(i - Hpack.f22281a.length);
                if (c2 >= 0) {
                    Header[] headerArr = this.f22282a;
                    if (c2 < headerArr.length) {
                        header = headerArr[c2];
                    }
                }
                throw new IOException("Header index too large " + (i + 1));
            }
            header = Hpack.f22281a[i];
            return header.g;
        }

        private void f() throws IOException {
            a(-1, new Header(Hpack.a(b()), b()));
        }

        private int g() throws IOException {
            return this.f.readByte() & 255;
        }

        private boolean g(int i) {
            return i >= 0 && i <= Hpack.f22281a.length - 1;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int g = g();
                if ((g & 128) == 0) {
                    return i2 + (g << i5);
                }
                i2 += (g & 127) << i5;
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
                    f();
                } else if ((readByte & 64) == 64) {
                    e(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a2 = a(readByte, 31);
                    this.h = a2;
                    if (a2 < 0 || a2 > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    c();
                } else if (readByte == 16 || readByte == 0) {
                    e();
                } else {
                    d(a(readByte, 15) - 1);
                }
            }
        }

        ByteString b() throws IOException {
            int g = g();
            boolean z = (g & 128) == 128;
            int a2 = a(g, 127);
            return z ? ByteString.of(Huffman.get().a(this.f.readByteArray(a2))) : this.f.readByteString(a2);
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Hpack$Writer.class */
    static final class Writer {

        /* renamed from: a  reason: collision with root package name */
        int f22284a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        Header[] f22285c;
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
            this.f22285c = headerArr;
            this.d = headerArr.length - 1;
            this.e = 0;
            this.f = 0;
            this.f22284a = i;
            this.b = i;
            this.h = z;
            this.g = buffer;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            Arrays.fill(this.f22285c, (Object) null);
            this.d = this.f22285c.length - 1;
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
            Header[] headerArr = this.f22285c;
            if (i3 + 1 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.d = this.f22285c.length - 1;
                this.f22285c = headerArr2;
            }
            int i4 = this.d;
            this.d = i4 - 1;
            this.f22285c[i4] = header;
            this.e++;
            this.f += i;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int i3 = i;
                int i4 = 0;
                for (int length = this.f22285c.length - 1; length >= this.d && i3 > 0; length--) {
                    i3 -= this.f22285c[length].i;
                    this.f -= this.f22285c[length].i;
                    this.e--;
                    i4++;
                }
                Header[] headerArr = this.f22285c;
                int i5 = this.d;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i4, this.e);
                Header[] headerArr2 = this.f22285c;
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
            this.f22284a = i;
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
            int i4;
            Buffer buffer;
            if (i < i2) {
                buffer = this.g;
                i4 = i | i3;
            } else {
                this.g.writeByte(i3 | i2);
                int i5 = i - i2;
                while (true) {
                    i4 = i5;
                    if (i4 < 128) {
                        break;
                    }
                    this.g.writeByte(128 | (i4 & 127));
                    i5 = i4 >>> 7;
                }
                buffer = this.g;
            }
            buffer.writeByte(i4);
        }

        void a(ByteString byteString) throws IOException {
            int size;
            int i;
            if (!this.h || Huffman.get().a(byteString) >= byteString.size()) {
                size = byteString.size();
                i = 0;
            } else {
                Buffer buffer = new Buffer();
                Huffman.get().a(byteString, buffer);
                byteString = buffer.readByteString();
                size = byteString.size();
                i = 128;
            }
            a(size, 127, i);
            this.g.write(byteString);
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
                        if (Util.equal(Hpack.f22281a[i - 1].h, byteString)) {
                            i2 = i;
                        } else if (Util.equal(Hpack.f22281a[i].h, byteString)) {
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
                    int length = this.f22285c.length;
                    while (true) {
                        i6 = i;
                        i7 = i2;
                        if (i8 >= length) {
                            break;
                        }
                        int i9 = i2;
                        if (Util.equal(this.f22285c[i8].g, asciiLowercase)) {
                            if (Util.equal(this.f22285c[i8].h, byteString)) {
                                i6 = Hpack.f22281a.length + (i8 - this.d);
                                i7 = i2;
                                break;
                            }
                            i9 = i2;
                            if (i2 == -1) {
                                i9 = (i8 - this.d) + Hpack.f22281a.length;
                            }
                        }
                        i8++;
                        i2 = i9;
                    }
                }
                if (i6 != -1) {
                    a(i6, 127, 128);
                } else {
                    if (i7 == -1) {
                        this.g.writeByte(64);
                        a(asciiLowercase);
                    } else if (!asciiLowercase.startsWith(Header.f22279a) || Header.f.equals(asciiLowercase)) {
                        a(i7, 63, 64);
                    } else {
                        a(i7, 15, 0);
                        a(byteString);
                    }
                    a(byteString);
                    a(header);
                }
                i4 = i5 + 1;
            }
        }
    }

    private Hpack() {
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

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f22281a.length);
        int i = 0;
        while (true) {
            int i2 = i;
            Header[] headerArr = f22281a;
            if (i2 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i2].g)) {
                linkedHashMap.put(f22281a[i2].g, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }
}
