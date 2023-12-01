package org.conscrypt;

import javax.crypto.ShortBufferException;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ShortBufferWithoutStackTraceException.class */
final class ShortBufferWithoutStackTraceException extends ShortBufferException {
    private static final long serialVersionUID = 676150236007842683L;

    public ShortBufferWithoutStackTraceException() {
    }

    public ShortBufferWithoutStackTraceException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        synchronized (this) {
        }
        return this;
    }
}
