package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/MissingFormatArgumentException.class */
public class MissingFormatArgumentException extends IllegalFormatException {
    private static final long serialVersionUID = 19190115;
    private final String s;

    public MissingFormatArgumentException(String str) {
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
        return "Format specifier: " + this.s;
    }
}
