package java.nio.charset;

import com.igexin.push.core.b;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/UnsupportedCharsetException.class */
public class UnsupportedCharsetException extends IllegalArgumentException {
    private static final long serialVersionUID = 1490765524727386367L;
    private String charsetName;

    public UnsupportedCharsetException(String str) {
        super(str != null ? str : b.l);
        this.charsetName = str;
    }

    public String getCharsetName() {
        return this.charsetName;
    }
}
