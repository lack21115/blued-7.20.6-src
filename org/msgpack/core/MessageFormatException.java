package org.msgpack.core;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessageFormatException.class */
public class MessageFormatException extends MessagePackException {
    public MessageFormatException(String str) {
        super(str);
    }

    public MessageFormatException(String str, Throwable th) {
        super(str, th);
    }

    public MessageFormatException(Throwable th) {
        super(th);
    }
}
