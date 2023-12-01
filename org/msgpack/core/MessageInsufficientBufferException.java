package org.msgpack.core;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessageInsufficientBufferException.class */
public class MessageInsufficientBufferException extends MessagePackException {
    public MessageInsufficientBufferException() {
    }

    public MessageInsufficientBufferException(String str) {
        super(str);
    }

    public MessageInsufficientBufferException(String str, Throwable th) {
        super(str, th);
    }

    public MessageInsufficientBufferException(Throwable th) {
        super(th);
    }
}
