package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/CompositeReadableBuffer.class */
public class CompositeReadableBuffer extends AbstractReadableBuffer {
    private final Queue<ReadableBuffer> buffers = new ArrayDeque();
    private int readableBytes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/CompositeReadableBuffer$ReadOperation.class */
    public static abstract class ReadOperation {
        IOException ex;
        int value;

        private ReadOperation() {
        }

        final boolean isError() {
            return this.ex != null;
        }

        final void read(ReadableBuffer readableBuffer, int i) {
            try {
                this.value = readInternal(readableBuffer, i);
            } catch (IOException e) {
                this.ex = e;
            }
        }

        abstract int readInternal(ReadableBuffer readableBuffer, int i) throws IOException;
    }

    private void advanceBufferIfNecessary() {
        if (this.buffers.peek().readableBytes() == 0) {
            this.buffers.remove().close();
        }
    }

    private void execute(ReadOperation readOperation, int i) {
        checkReadable(i);
        int i2 = i;
        if (!this.buffers.isEmpty()) {
            advanceBufferIfNecessary();
            i2 = i;
        }
        while (i2 > 0 && !this.buffers.isEmpty()) {
            ReadableBuffer peek = this.buffers.peek();
            int min = Math.min(i2, peek.readableBytes());
            readOperation.read(peek, min);
            if (readOperation.isError()) {
                return;
            }
            i2 -= min;
            this.readableBytes -= min;
            advanceBufferIfNecessary();
        }
        if (i2 > 0) {
            throw new AssertionError("Failed executing read operation");
        }
    }

    public void addBuffer(ReadableBuffer readableBuffer) {
        if (!(readableBuffer instanceof CompositeReadableBuffer)) {
            this.buffers.add(readableBuffer);
            this.readableBytes += readableBuffer.readableBytes();
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = (CompositeReadableBuffer) readableBuffer;
        while (!compositeReadableBuffer.buffers.isEmpty()) {
            this.buffers.add(compositeReadableBuffer.buffers.remove());
        }
        this.readableBytes += compositeReadableBuffer.readableBytes;
        compositeReadableBuffer.readableBytes = 0;
        compositeReadableBuffer.close();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.buffers.isEmpty()) {
            this.buffers.remove().close();
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public CompositeReadableBuffer readBytes(int i) {
        checkReadable(i);
        this.readableBytes -= i;
        CompositeReadableBuffer compositeReadableBuffer = new CompositeReadableBuffer();
        while (i > 0) {
            ReadableBuffer peek = this.buffers.peek();
            if (peek.readableBytes() > i) {
                compositeReadableBuffer.addBuffer(peek.readBytes(i));
                i = 0;
            } else {
                compositeReadableBuffer.addBuffer(this.buffers.poll());
                i -= peek.readableBytes();
            }
        }
        return compositeReadableBuffer;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(final OutputStream outputStream, int i) throws IOException {
        ReadOperation readOperation = new ReadOperation() { // from class: io.grpc.internal.CompositeReadableBuffer.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i2) throws IOException {
                readableBuffer.readBytes(outputStream, i2);
                return 0;
            }
        };
        execute(readOperation, i);
        if (readOperation.isError()) {
            throw readOperation.ex;
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(final ByteBuffer byteBuffer) {
        execute(new ReadOperation() { // from class: io.grpc.internal.CompositeReadableBuffer.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i) {
                int limit = byteBuffer.limit();
                ByteBuffer byteBuffer2 = byteBuffer;
                byteBuffer2.limit(byteBuffer2.position() + i);
                readableBuffer.readBytes(byteBuffer);
                byteBuffer.limit(limit);
                return 0;
            }
        }, byteBuffer.remaining());
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(final byte[] bArr, final int i, int i2) {
        execute(new ReadOperation() { // from class: io.grpc.internal.CompositeReadableBuffer.3
            int currentOffset;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.currentOffset = i;
            }

            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i3) {
                readableBuffer.readBytes(bArr, this.currentOffset, i3);
                this.currentOffset += i3;
                return 0;
            }
        }, i2);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        ReadOperation readOperation = new ReadOperation() { // from class: io.grpc.internal.CompositeReadableBuffer.1
            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            int readInternal(ReadableBuffer readableBuffer, int i) {
                return readableBuffer.readUnsignedByte();
            }
        };
        execute(readOperation, 1);
        return readOperation.value;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        execute(new ReadOperation() { // from class: io.grpc.internal.CompositeReadableBuffer.2
            @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
            public int readInternal(ReadableBuffer readableBuffer, int i2) {
                readableBuffer.skipBytes(i2);
                return 0;
            }
        }, i);
    }
}
