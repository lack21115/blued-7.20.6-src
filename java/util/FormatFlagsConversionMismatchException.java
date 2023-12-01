package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/FormatFlagsConversionMismatchException.class */
public class FormatFlagsConversionMismatchException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 19120414;

    /* renamed from: c  reason: collision with root package name */
    private final char f42267c;
    private final String f;

    public FormatFlagsConversionMismatchException(String str, char c2) {
        if (str == null) {
            throw new NullPointerException("f == null");
        }
        this.f = str;
        this.f42267c = c2;
    }

    public char getConversion() {
        return this.f42267c;
    }

    public String getFlags() {
        return this.f;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "%" + this.f42267c + " does not support '" + this.f + "'";
    }
}
