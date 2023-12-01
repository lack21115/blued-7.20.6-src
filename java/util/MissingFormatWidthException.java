package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/MissingFormatWidthException.class */
public class MissingFormatWidthException extends IllegalFormatException {
    private static final long serialVersionUID = 15560123;
    private final String s;

    public MissingFormatWidthException(String str) {
        if (str == null) {
            throw new NullPointerException("s == null");
        }
        this.s = str;
    }

    public String getFormatSpecifier() {
        return this.s;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.s;
    }
}
