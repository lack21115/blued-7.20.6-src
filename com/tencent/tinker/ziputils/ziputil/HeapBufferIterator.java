package com.tencent.tinker.ziputils.ziputil;

import java.nio.ByteOrder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/HeapBufferIterator.class */
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

    public byte readByte() {
        byte[] bArr = this.buffer;
        int i = this.offset;
        int i2 = this.position;
        byte b = bArr[i + i2];
        this.position = i2 + 1;
        return b;
    }

    public void readByteArray(byte[] bArr, int i, int i2) {
        System.arraycopy((Object) this.buffer, this.offset + this.position, (Object) bArr, i, i2);
        this.position += i2;
    }

    @Override // com.tencent.tinker.ziputils.ziputil.BufferIterator
    public int readInt() {
        int peekInt = Memory.peekInt(this.buffer, this.offset + this.position, this.order);
        this.position += 4;
        return peekInt;
    }

    @Override // com.tencent.tinker.ziputils.ziputil.BufferIterator
    public short readShort() {
        short peekShort = Memory.peekShort(this.buffer, this.offset + this.position, this.order);
        this.position += 2;
        return peekShort;
    }

    @Override // com.tencent.tinker.ziputils.ziputil.BufferIterator
    public void seek(int i) {
        this.position = i;
    }

    @Override // com.tencent.tinker.ziputils.ziputil.BufferIterator
    public void skip(int i) {
        this.position += i;
    }
}
