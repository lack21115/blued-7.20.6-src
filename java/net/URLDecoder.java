package java.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import libcore.net.UriCodec;

/* loaded from: source-2895416-dex2jar.jar:java/net/URLDecoder.class */
public class URLDecoder {
    @Deprecated
    public static String decode(String str) {
        return UriCodec.decode(str, true, Charset.defaultCharset(), true);
    }

    public static String decode(String str, String str2) throws UnsupportedEncodingException {
        return UriCodec.decode(str, true, Charset.forName(str2), true);
    }
}
