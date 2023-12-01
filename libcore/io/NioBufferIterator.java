package libcore.io;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/NioBufferIterator.class */
public final class NioBufferIterator extends BufferIterator {
    private final long address;
    private int position;
    private final int size;
    private final boolean swap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NioBufferIterator(long j, int i, boolean z) {
        this.address = j;
        this.size = i;
        this.swap = z;
    }

    @Override // libcore.io.BufferIterator
    public byte readByte() {
        byte peekByte = Memory.peekByte(this.address + this.position);
        this.position++;
        return peekByte;
    }

    @Override // libcore.io.BufferIterator
    public void readByteArray(byte[] bArr, int i, int i2) {
        Memory.peekByteArray(this.address + this.position, bArr, i, i2);
        this.position += i2;
    }

    @Override // libcore.io.BufferIterator
    public int readInt() {
        int peekInt = Memory.peekInt(this.address + this.position, this.swap);
        this.position += 4;
        return peekInt;
    }

    @Override // libcore.io.BufferIterator
    public void readIntArray(int[] iArr, int i, int i2) {
        Memory.peekIntArray(this.address + this.position, iArr, i, i2, this.swap);
        this.position += i2 * 4;
    }

    @Override // libcore.io.BufferIterator
    public short readShort() {
        short peekShort = Memory.peekShort(this.address + this.position, this.swap);
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
