package java.nio.charset;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/IllegalCharsetNameException.class */
public class IllegalCharsetNameException extends IllegalArgumentException {
    private static final long serialVersionUID = 1457525358470002989L;
    private String charsetName;

    public IllegalCharsetNameException(String str) {
        super(str != null ? str : "null");
        this.charsetName = str;
    }

    public String getCharsetName() {
        return this.charsetName;
    }
}
