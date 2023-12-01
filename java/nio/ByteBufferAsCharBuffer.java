package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/ByteBufferAsCharBuffer.class */
final class ByteBufferAsCharBuffer extends CharBuffer {
    private final ByteBuffer byteBuffer;

    private ByteBufferAsCharBuffer(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / 2, byteBuffer.effectiveDirectAddress);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ByteBufferAsCharBuffer(slice);
    }

    @Override // java.nio.CharBuffer
    public CharBuffer asReadOnlyBuffer() {
        ByteBufferAsCharBuffer byteBufferAsCharBuffer = new ByteBufferAsCharBuffer(this.byteBuffer.asReadOnlyBuffer());
        byteBufferAsCharBuffer.limit = this.limit;
        byteBufferAsCharBuffer.position = this.position;
        byteBufferAsCharBuffer.mark = this.mark;
        byteBufferAsCharBuffer.byteBuffer.order = this.byteBuffer.order;
        return byteBufferAsCharBuffer;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer compact() {
        if (this.byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        this.byteBuffer.compact();
        this.byteBuffer.clear();
        this.position = this.limit - this.position;
        this.limit = this.capacity;
        this.mark = -1;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer duplicate() {
        ByteBufferAsCharBuffer byteBufferAsCharBuffer = new ByteBufferAsCharBuffer(this.byteBuffer.duplicate().order(this.byteBuffer.order()));
        byteBufferAsCharBuffer.limit = this.limit;
        byteBufferAsCharBuffer.position = this.position;
        byteBufferAsCharBuffer.mark = this.mark;
        return byteBufferAsCharBuffer;
    }

    @Override // java.nio.CharBuffer
    public char get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return byteBuffer.getChar(i * 2);
    }

    @Override // java.nio.CharBuffer
    public char get(int i) {
        checkIndex(i);
        return this.byteBuffer.getChar(i * 2);
    }

    @Override // java.nio.CharBuffer
    public CharBuffer get(char[] cArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).get(cArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).get(cArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public boolean isDirect() {
        return this.byteBuffer.isDirect();
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return this.byteBuffer.isReadOnly();
    }

    @Override // java.nio.CharBuffer
    public ByteOrder order() {
        return this.byteBuffer.order();
    }

    @Override // java.nio.CharBuffer
    char[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.CharBuffer
    int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.nio.CharBuffer
    boolean protectedHasArray() {
        return false;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char c2) {
        if (this.position == this.limit) {
            throw new BufferOverflowException();
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        byteBuffer.putChar(i * 2, c2);
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(int i, char c2) {
        checkIndex(i);
        this.byteBuffer.putChar(i * 2, c2);
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(char[] cArr, int i, int i2) {
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        if (this.byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) this.byteBuffer).put(cArr, i, i2);
        } else {
            ((ByteArrayBuffer) this.byteBuffer).put(cArr, i, i2);
        }
        this.position += i2;
        return this;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer slice() {
        this.byteBuffer.limit(this.limit * 2);
        this.byteBuffer.position(this.position * 2);
        ByteBufferAsCharBuffer byteBufferAsCharBuffer = new ByteBufferAsCharBuffer(this.byteBuffer.slice().order(this.byteBuffer.order()));
        this.byteBuffer.clear();
        return byteBufferAsCharBuffer;
    }

    @Override // java.nio.CharBuffer, java.lang.CharSequence
    public CharBuffer subSequence(int i, int i2) {
        checkStartEndRemaining(i, i2);
        CharBuffer duplicate = duplicate();
        duplicate.limit(this.position + i2);
        duplicate.position(this.position + i);
        return duplicate;
    }
}
