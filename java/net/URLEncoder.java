package java.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import libcore.net.UriCodec;

/* loaded from: source-2895416-dex2jar.jar:java/net/URLEncoder.class */
public class URLEncoder {
    static UriCodec ENCODER = new UriCodec() { // from class: java.net.URLEncoder.1
        @Override // libcore.net.UriCodec
        protected boolean isRetained(char c) {
            return " .-*_".indexOf(c) != -1;
        }
    };

    private URLEncoder() {
    }

    @Deprecated
    public static String encode(String str) {
        return ENCODER.encode(str, StandardCharsets.UTF_8);
    }

    public static String encode(String str, String str2) throws UnsupportedEncodingException {
        return ENCODER.encode(str, Charset.forName(str2));
    }
}
