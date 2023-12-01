package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.CharEncoding;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/Charsets.class */
public final class Charsets {
    public static final Charsets a = new Charsets();
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final Charset g;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.c(forName, "forName(\"UTF-8\")");
        b = forName;
        Charset forName2 = Charset.forName(CharEncoding.UTF_16);
        Intrinsics.c(forName2, "forName(\"UTF-16\")");
        c = forName2;
        Charset forName3 = Charset.forName(CharEncoding.UTF_16BE);
        Intrinsics.c(forName3, "forName(\"UTF-16BE\")");
        d = forName3;
        Charset forName4 = Charset.forName(CharEncoding.UTF_16LE);
        Intrinsics.c(forName4, "forName(\"UTF-16LE\")");
        e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.c(forName5, "forName(\"US-ASCII\")");
        f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.c(forName6, "forName(\"ISO-8859-1\")");
        g = forName6;
    }

    private Charsets() {
    }
}
