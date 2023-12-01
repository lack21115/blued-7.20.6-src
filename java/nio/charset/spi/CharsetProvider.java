package java.nio.charset.spi;

import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/spi/CharsetProvider.class */
public abstract class CharsetProvider {
    protected CharsetProvider() {
    }

    public abstract Charset charsetForName(String str);

    public abstract Iterator<Charset> charsets();
}
