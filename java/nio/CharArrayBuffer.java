package java.nio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/CharArrayBuffer.class */
public final class CharArrayBuffer extends CharBuffer {
    private final int arrayOffset;
    private final char[] backingArray;
    private final boolean isReadOnly;

    private CharArrayBuffer(int i, char[] cArr, int i2, boolean z) {
        super(i, 0L);
        this.backingArray = cArr;
        this.arrayOffset = i2;
        this.isReadOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharArrayBuffer(char[] cArr) {
        this(cArr.length, cArr, 0, false);
    }

    private static CharArrayBuffer copy(CharArrayBuffer charArrayBuffer, int i, boolean z) {
        CharArrayBuffer charArrayBuffer2 = new CharArrayBuffer(charArrayBuffer.capacity(), charArrayBuffer.backingArray, charArrayBuffer.arrayOffset, z);
        charArrayBuffer2.limit = charArrayBuffer.limit;
        charArrayBuffer2.position = charArrayBuffer.position();
        charArrayBuffer2.mark = i;
        return charArrayBuffer2;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer asReadOnlyBuffer() {
        return copy(this, this.mark, true);
    }

    @Override // java.nio.CharBuffer
    public CharBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        System.arraycopy(this.backingArray, this.position + this.arrayOffset, this.backingArray, this.arrayOffset, remaining());
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer duplicate() {
        return copy(this, this.mark, this.isReadOnly);
    }

    @Override // java.nio.CharBuffer
    public final char get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        char[] cArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        return cArr[i + i2];
    }

    @Override // java.nio.CharBuffer
    public final char get(int i) {
        checkIndex(i);
        return this.backingArray[this.arrayOffset + i];
    }

    @Override // java.nio.CharBuffer
    public final CharBuffer get(char[] cArr, int i, int i2) {
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(this.backingArray, this.arrayOffset + this.position, cArr, i, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.nio.CharBuffer
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }

    @Override // java.nio.CharBuffer
    char[] protectedArray() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.backingArray;
    }

    @Override // java.nio.CharBuffer
    int protectedArrayOffset() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.arrayOffset;
    }

    @Override // java.nio.CharBuffer
    boolean protectedHasArray() {
        return !this.isReadOnly;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char c2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        char[] cArr = this.backingArray;
        int i = this.arrayOffset;
        int i2 = this.position;
        this.position = i2 + 1;
        cArr[i + i2] = c2;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(int i, char c2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkIndex(i);
        this.backingArray[this.arrayOffset + i] = c2;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char[] cArr, int i, int i2) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(cArr, i, this.backingArray, this.arrayOffset + this.position, i2);
        this.position += i2;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer slice() {
        return new CharArrayBuffer(remaining(), this.backingArray, this.arrayOffset + this.position, this.isReadOnly);
    }

    @Override // java.nio.CharBuffer, java.lang.CharSequence
    public final CharBuffer subSequence(int i, int i2) {
        checkStartEndRemaining(i, i2);
        CharBuffer duplicate = duplicate();
        duplicate.limit(this.position + i2);
        duplicate.position(this.position + i);
        return duplicate;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer, java.lang.CharSequence
    public final String toString() {
        return String.copyValueOf(this.backingArray, this.arrayOffset + this.position, remaining());
    }
}
