package java.nio.charset;

import org.apache.commons.codec.CharEncoding;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/StandardCharsets.class */
public final class StandardCharsets {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset UTF_16 = Charset.forName(CharEncoding.UTF_16);
    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);
    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);

    private StandardCharsets() {
    }
}
