package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/MessageBufferBE.class */
public class MessageBufferBE extends MessageBuffer {
    private MessageBufferBE(Object obj, long j, int i) {
        super(obj, j, i);
    }

    MessageBufferBE(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    MessageBufferBE(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public double getDouble(int i) {
        return unsafe.getDouble(this.base, this.address + i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public float getFloat(int i) {
        return unsafe.getFloat(this.base, this.address + i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public int getInt(int i) {
        return unsafe.getInt(this.base, this.address + i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public long getLong(int i) {
        return unsafe.getLong(this.base, this.address + i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public short getShort(int i) {
        return unsafe.getShort(this.base, this.address + i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putDouble(int i, double d) {
        unsafe.putDouble(this.base, this.address + i, d);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putInt(int i, int i2) {
        unsafe.putInt(this.base, this.address + i, i2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putLong(int i, long j) {
        unsafe.putLong(this.base, this.address + i, j);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putShort(int i, short s) {
        unsafe.putShort(this.base, this.address + i, s);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public MessageBufferBE slice(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        Preconditions.checkArgument(i + i2 <= size());
        return new MessageBufferBE(this.base, this.address + i, i2);
    }
}
