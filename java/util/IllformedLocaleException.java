package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllformedLocaleException.class */
public class IllformedLocaleException extends RuntimeException {
    private final int errorIndex;

    public IllformedLocaleException() {
        this(null, -1);
    }

    public IllformedLocaleException(String str) {
        this(str, -1);
    }

    public IllformedLocaleException(String str, int i) {
        super(str);
        this.errorIndex = i;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }
}
