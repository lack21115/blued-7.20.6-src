package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/IllegalFormatCodePointException.class */
public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    private static final long serialVersionUID = 19080630;

    /* renamed from: c  reason: collision with root package name */
    private final int f42268c;

    public IllegalFormatCodePointException(int i) {
        this.f42268c = i;
    }

    public int getCodePoint() {
        return this.f42268c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return Integer.toHexString(this.f42268c);
    }
}
