package java.nio.charset;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/UnsupportedCharsetException.class */
public class UnsupportedCharsetException extends IllegalArgumentException {
    private static final long serialVersionUID = 1490765524727386367L;
    private String charsetName;

    public UnsupportedCharsetException(String str) {
        super(str != null ? str : "null");
        this.charsetName = str;
    }

    public String getCharsetName() {
        return this.charsetName;
    }
}
