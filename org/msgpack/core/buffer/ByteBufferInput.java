package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/ByteBufferInput.class */
public class ByteBufferInput implements MessageBufferInput {
    private ByteBuffer input;
    private boolean isRead = false;

    public ByteBufferInput(ByteBuffer byteBuffer) {
        this.input = ((ByteBuffer) Preconditions.checkNotNull(byteBuffer, "input ByteBuffer is null")).slice();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        if (this.isRead) {
            return null;
        }
        MessageBuffer wrap = MessageBuffer.wrap(this.input);
        this.isRead = true;
        return wrap;
    }

    public ByteBuffer reset(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.input;
        this.input = ((ByteBuffer) Preconditions.checkNotNull(byteBuffer, "input ByteBuffer is null")).slice();
        this.isRead = false;
        return byteBuffer2;
    }
}
