package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/Buffer.class */
public abstract class Buffer {
    static final int UNSET_MARK = -1;
    final int _elementSizeShift;
    final int capacity;
    final long effectiveDirectAddress;
    int limit;
    int mark = -1;
    int position = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Buffer(int i, int i2, long j) {
        this._elementSizeShift = i;
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i2);
        }
        this.limit = i2;
        this.capacity = i2;
        this.effectiveDirectAddress = j;
    }

    public abstract Object array();

    public abstract int arrayOffset();

    public final int capacity() {
        return this.capacity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkGetBounds(int i, int i2, int i3, int i4) {
        int i5 = i * i4;
        if ((i3 | i4) < 0 || i3 > i2 || i2 - i3 < i4) {
            throw new IndexOutOfBoundsException("offset=" + i3 + ", count=" + i4 + ", length=" + i2);
        }
        if (i5 > remaining()) {
            throw new BufferUnderflowException();
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkIndex(int i) {
        if (i < 0 || i >= this.limit) {
            throw new IndexOutOfBoundsException("index=" + i + ", limit=" + this.limit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkIndex(int i, int i2) {
        if (i < 0 || i > this.limit - i2) {
            throw new IndexOutOfBoundsException("index=" + i + ", limit=" + this.limit + ", size of type=" + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkPutBounds(int i, int i2, int i3, int i4) {
        int i5 = i * i4;
        if ((i3 | i4) < 0 || i3 > i2 || i2 - i3 < i4) {
            throw new IndexOutOfBoundsException("offset=" + i3 + ", count=" + i4 + ", length=" + i2);
        }
        if (i5 > remaining()) {
            throw new BufferOverflowException();
        }
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkStartEndRemaining(int i, int i2) {
        if (i2 < i || i < 0 || i2 > remaining()) {
            throw new IndexOutOfBoundsException("start=" + i + ", end=" + i2 + ", remaining()=" + remaining());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkWritable() {
        if (isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
    }

    public final Buffer clear() {
        this.position = 0;
        this.mark = -1;
        this.limit = this.capacity;
        return this;
    }

    public final Buffer flip() {
        this.limit = this.position;
        this.position = 0;
        this.mark = -1;
        return this;
    }

    public final int getElementSizeShift() {
        return this._elementSizeShift;
    }

    public abstract boolean hasArray();

    public final boolean hasRemaining() {
        return this.position < this.limit;
    }

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public final int limit() {
        return this.limit;
    }

    public final Buffer limit(int i) {
        if (i < 0 || i > this.capacity) {
            throw new IllegalArgumentException("Bad limit (capacity " + this.capacity + "): " + i);
        }
        this.limit = i;
        if (this.position > i) {
            this.position = i;
        }
        if (this.mark != -1 && this.mark > i) {
            this.mark = -1;
        }
        return this;
    }

    public final Buffer mark() {
        this.mark = this.position;
        return this;
    }

    public final int position() {
        return this.position;
    }

    public final Buffer position(int i) {
        positionImpl(i);
        return this;
    }

    void positionImpl(int i) {
        if (i < 0 || i > this.limit) {
            throw new IllegalArgumentException("Bad position (limit " + this.limit + "): " + i);
        }
        this.position = i;
        if (this.mark == -1 || this.mark <= this.position) {
            return;
        }
        this.mark = -1;
    }

    public final int remaining() {
        return this.limit - this.position;
    }

    public final Buffer reset() {
        if (this.mark == -1) {
            throw new InvalidMarkException("Mark not set");
        }
        this.position = this.mark;
        return this;
    }

    public final Buffer rewind() {
        this.position = 0;
        this.mark = -1;
        return this;
    }

    public String toString() {
        return getClass().getName() + "[position=" + this.position + ",limit=" + this.limit + ",capacity=" + this.capacity + "]";
    }
}
