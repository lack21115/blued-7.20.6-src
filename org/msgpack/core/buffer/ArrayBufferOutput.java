package org.msgpack.core.buffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/ArrayBufferOutput.class */
public class ArrayBufferOutput implements MessageBufferOutput {
    private int bufferSize;
    private MessageBuffer lastBuffer;
    private List<MessageBuffer> list;

    public ArrayBufferOutput() {
        this(8192);
    }

    public ArrayBufferOutput(int i) {
        this.bufferSize = i;
        this.list = new ArrayList();
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] bArr, int i, int i2) {
        this.list.add(MessageBuffer.wrap(bArr, i, i2));
    }

    public void clear() {
        this.list.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int getSize() {
        Iterator<MessageBuffer> it = this.list.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = i2 + it.next().size();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int i) {
        MessageBuffer messageBuffer = this.lastBuffer;
        if (messageBuffer == null || messageBuffer.size() <= i) {
            MessageBuffer allocate = MessageBuffer.allocate(Math.max(this.bufferSize, i));
            this.lastBuffer = allocate;
            return allocate;
        }
        return this.lastBuffer;
    }

    public List<MessageBuffer> toBufferList() {
        return new ArrayList(this.list);
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[getSize()];
        Iterator<MessageBuffer> it = this.list.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return bArr;
            }
            MessageBuffer next = it.next();
            next.getBytes(0, bArr, i2, next.size());
            i = i2 + next.size();
        }
    }

    public MessageBuffer toMessageBuffer() {
        return this.list.size() == 1 ? this.list.get(0) : this.list.isEmpty() ? MessageBuffer.allocate(0) : MessageBuffer.wrap(toByteArray());
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] bArr, int i, int i2) {
        MessageBuffer allocate = MessageBuffer.allocate(i2);
        allocate.putBytes(0, bArr, i, i2);
        this.list.add(allocate);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int i) {
        this.list.add(this.lastBuffer.slice(0, i));
        if (this.lastBuffer.size() - i <= this.bufferSize / 4) {
            this.lastBuffer = null;
            return;
        }
        MessageBuffer messageBuffer = this.lastBuffer;
        this.lastBuffer = messageBuffer.slice(i, messageBuffer.size() - i);
    }
}
