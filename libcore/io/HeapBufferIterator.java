package libcore.io;

import java.nio.ByteOrder;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/HeapBufferIterator.class */
public final class HeapBufferIterator extends BufferIterator {
    private final byte[] buffer;
    private final int byteCount;
    private final int offset;
    private final ByteOrder order;
    private int position;

    HeapBufferIterator(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        this.buffer = bArr;
        this.offset = i;
        this.byteCount = i2;
        this.order = byteOrder;
    }

    public static BufferIterator iterator(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        return new HeapBufferIterator(bArr, i, i2, byteOrder);
    }

    @Override // libcore.io.BufferIterator
    public byte readByte() {
        byte b = this.buffer[this.offset + this.position];
        this.position++;
        return b;
    }

    @Override // libcore.io.BufferIterator
    public void readByteArray(byte[] bArr, int i, int i2) {
        System.arraycopy(this.buffer, this.offset + this.position, bArr, i, i2);
        this.position += i2;
    }

    @Override // libcore.io.BufferIterator
    public int readInt() {
        int peekInt = Memory.peekInt(this.buffer, this.offset + this.position, this.order);
        this.position += 4;
        return peekInt;
    }

    @Override // libcore.io.BufferIterator
    public void readIntArray(int[] iArr, int i, int i2) {
        int i3 = i2 * 4;
        Memory.unsafeBulkGet(iArr, i, i3, this.buffer, this.offset + this.position, 4, this.order.needsSwap);
        this.position += i3;
    }

    @Override // libcore.io.BufferIterator
    public short readShort() {
        short peekShort = Memory.peekShort(this.buffer, this.offset + this.position, this.order);
        this.position += 2;
        return peekShort;
    }

    @Override // libcore.io.BufferIterator
    public void seek(int i) {
        this.position = i;
    }

    @Override // libcore.io.BufferIterator
    public void skip(int i) {
        this.position += i;
    }
}
