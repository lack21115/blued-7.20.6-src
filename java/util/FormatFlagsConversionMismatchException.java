package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/FormatFlagsConversionMismatchException.class */
public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 19120414;
    private final char c;
    private final String f;

    public FormatFlagsConversionMismatchException(String str, char c) {
        if (str == null) {
            throw new NullPointerException("f == null");
        }
        this.f = str;
        this.c = c;
    }

    public char getConversion() {
        return this.c;
    }

    public String getFlags() {
        return this.f;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "%" + this.c + " does not support '" + this.f + "'";
    }
}
