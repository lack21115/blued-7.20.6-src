package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/UnknownFormatFlagsException.class */
public class UnknownFormatFlagsException extends IllegalFormatException {
    private static final long serialVersionUID = 19370506;
    private final String flags;

    public UnknownFormatFlagsException(String str) {
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
        return "Flags: " + this.flags;
    }
}
