package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatConversionException.class */
public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 17000126;
    private final Class<?> arg;
    private final char c;

    public IllegalFormatConversionException(char c, Class<?> cls) {
        this.c = c;
        if (cls == null) {
            throw new NullPointerException("arg == null");
        }
        this.arg = cls;
    }

    public Class<?> getArgumentClass() {
        return this.arg;
    }

    public char getConversion() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "%" + this.c + " can't format " + this.arg.getName() + " arguments";
    }
}
