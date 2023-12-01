package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatPrecisionException.class */
public class IllegalFormatPrecisionException extends IllegalFormatException {
    private static final long serialVersionUID = 18711008;
    private final int p;

    public IllegalFormatPrecisionException(int i) {
        this.p = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return Integer.toString(this.p);
    }

    public int getPrecision() {
        return this.p;
    }
}
