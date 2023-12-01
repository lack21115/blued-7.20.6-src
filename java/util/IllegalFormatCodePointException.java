package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatCodePointException.class */
public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 19080630;
    private final int c;

    public IllegalFormatCodePointException(int i) {
        this.c = i;
    }

    public int getCodePoint() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return Integer.toHexString(this.c);
    }
}
