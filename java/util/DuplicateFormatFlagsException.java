package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/DuplicateFormatFlagsException.class */
public class DuplicateFormatFlagsException extends IllegalFormatException {
    private static final long serialVersionUID = 18890531;
    private final String flags;

    public DuplicateFormatFlagsException(String str) {
        if (str == null) {
            throw new NullPointerException("f == null");
        }
        this.flags = str;
    }

    public String getFlags() {
        return this.flags;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.flags;
    }
}
