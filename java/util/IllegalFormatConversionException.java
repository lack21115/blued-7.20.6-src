package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatConversionException.class */
public class IllegalFormatConversionException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 17000126;
    private final Class<?> arg;

    /* renamed from: c  reason: collision with root package name */
    private final char f42269c;

    public IllegalFormatConversionException(char c2, Class<?> cls) {
        this.f42269c = c2;
        if (cls == null) {
            throw new NullPointerException("arg == null");
        }
        this.arg = cls;
    }

    public Class<?> getArgumentClass() {
        return this.arg;
    }

    public char getConversion() {
        return this.f42269c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "%" + this.f42269c + " can't format " + this.arg.getName() + " arguments";
    }
}
