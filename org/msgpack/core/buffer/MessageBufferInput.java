package org.msgpack.core.buffer;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/MessageBufferInput.class */
public interface MessageBufferInput extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    MessageBuffer next() throws IOException;
}
