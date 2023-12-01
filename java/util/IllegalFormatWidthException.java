package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatWidthException.class */
public class IllegalFormatWidthException extends IllegalFormatException {
    private static final long serialVersionUID = 16660902;
    private final int w;

    public IllegalFormatWidthException(int i) {
        this.w = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return Integer.toString(this.w);
    }

    public int getWidth() {
        return this.w;
    }
}
