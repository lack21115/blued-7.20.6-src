package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatFlagsException.class */
public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 790824;
    private final String flags;

    public IllegalFormatFlagsException(String str) {
        if (str == null) {
            throw new NullPointerException("flags == null");
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
