package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/UnknownFormatConversionException.class */
public class UnknownFormatConversionException extends IllegalFormatException {
    private static final long serialVersionUID = 19060418;
    private final String s;

    public UnknownFormatConversionException(String str) {
        if (str == null) {
            throw new NullPointerException("s == null");
        }
        this.s = str;
    }

    public String getConversion() {
        return this.s;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Conversion: " + this.s;
    }
}
