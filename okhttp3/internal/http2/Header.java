package okhttp3.internal.http2;

import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Header.class */
public final class Header {
    public static final ByteString a = ByteString.encodeUtf8(":");
    public static final ByteString b = ByteString.encodeUtf8(":status");
    public static final ByteString c = ByteString.encodeUtf8(":method");
    public static final ByteString d = ByteString.encodeUtf8(":path");
    public static final ByteString e = ByteString.encodeUtf8(":scheme");
    public static final ByteString f = ByteString.encodeUtf8(":authority");
    public final ByteString g;
    public final ByteString h;
    final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Header$Listener.class */
    public interface Listener {
        void a(Headers headers);
    }

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.g = byteString;
        this.h = byteString2;
        this.i = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Header) {
            Header header = (Header) obj;
            z = false;
            if (this.g.equals(header.g)) {
                z = false;
                if (this.h.equals(header.h)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return Util.a("%s: %s", this.g.utf8(), this.h.utf8());
    }
}
