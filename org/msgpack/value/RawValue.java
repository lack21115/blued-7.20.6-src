package org.msgpack.value;

import java.nio.ByteBuffer;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/RawValue.class */
public interface RawValue extends Value {
    byte[] asByteArray();

    ByteBuffer asByteBuffer();

    String asString();

    String toString();
}
