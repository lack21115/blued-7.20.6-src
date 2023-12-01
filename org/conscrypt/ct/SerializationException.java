package org.conscrypt.ct;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ct/SerializationException.class */
public class SerializationException extends Exception {
    private static final long serialVersionUID = -5317873136664833411L;

    public SerializationException() {
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(String str, Throwable th) {
        super(str, th);
    }

    public SerializationException(Throwable th) {
        super(th);
    }
}
