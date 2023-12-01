package org.msgpack.core;

import java.nio.charset.CharacterCodingException;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessageStringCodingException.class */
public class MessageStringCodingException extends MessagePackException {
    public MessageStringCodingException(String str, CharacterCodingException characterCodingException) {
        super(str, characterCodingException);
    }

    public MessageStringCodingException(CharacterCodingException characterCodingException) {
        super(characterCodingException);
    }

    @Override // java.lang.Throwable
    public CharacterCodingException getCause() {
        return (CharacterCodingException) super.getCause();
    }
}
