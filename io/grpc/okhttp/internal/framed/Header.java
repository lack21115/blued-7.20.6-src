package io.grpc.okhttp.internal.framed;

import com.blued.das.live.LiveProtos;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/internal/framed/Header.class */
public final class Header {
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(":method");
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(":path");
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
    public static final ByteString TARGET_HOST = ByteString.encodeUtf8(":host");
    public static final ByteString VERSION = ByteString.encodeUtf8(":version");

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Header) {
            Header header = (Header) obj;
            z = false;
            if (this.name.equals(header.name)) {
                z = false;
                if (this.value.equals(header.value)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return ((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.name.utf8(), this.value.utf8());
    }
}
