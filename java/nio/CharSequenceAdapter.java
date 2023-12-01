package java.nio;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/CharSequenceAdapter.class */
public final class CharSequenceAdapter extends CharBuffer {
    final CharSequence sequence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequenceAdapter(CharSequence charSequence) {
        super(charSequence.length(), 0L);
        this.sequence = charSequence;
    }

    static CharSequenceAdapter copy(CharSequenceAdapter charSequenceAdapter) {
        CharSequenceAdapter charSequenceAdapter2 = new CharSequenceAdapter(charSequenceAdapter.sequence);
        charSequenceAdapter2.limit = charSequenceAdapter.limit;
        charSequenceAdapter2.position = charSequenceAdapter.position;
        charSequenceAdapter2.mark = charSequenceAdapter.mark;
        return charSequenceAdapter2;
    }

    @Override // java.nio.CharBuffer
    public CharBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @Override // java.nio.CharBuffer
    public CharBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public CharBuffer duplicate() {
        return copy(this);
    }

    @Override // java.nio.CharBuffer
    public char get() {
        if (this.position == this.limit) {
            throw new BufferUnderflowException();
        }
        CharSequence charSequence = this.sequence;
        int i = this.position;
        this.position = i + 1;
        return charSequence.charAt(i);
    }

    @Override // java.nio.CharBuffer
    public char get(int i) {
        checkIndex(i);
        return this.sequence.charAt(i);
    }

    @Override // java.nio.CharBuffer
    public final CharBuffer get(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = this.position + i2;
        this.sequence.toString().getChars(this.position, i3, cArr, i);
        this.position = i3;
        return this;
    }

    @Override // java.nio.CharBuffer, java.nio.Buffer
    public boolean isDirect() {
        return false;
    }

    @Override // java.nio.Buffer
    public boolean isReadOnly() {
        return true;
    }

    @Override // java.nio.CharBuffer
    public ByteOrder order() {
        return ByteOrder.nativeOrder();
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
    public CharBuffer put(char c) {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(int i, char c) {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public CharBuffer put(String str, int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public final CharBuffer put(char[] cArr, int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // java.nio.CharBuffer
    public CharBuffer slice() {
        return new CharSequenceAdapter(this.sequence.subSequence(this.position, this.limit));
    }

    @Override // java.nio.CharBuffer, java.lang.CharSequence
    public CharBuffer subSequence(int i, int i2) {
        checkStartEndRemaining(i, i2);
        CharSequenceAdapter copy = copy(this);
        copy.position = this.position + i;
        copy.limit = this.position + i2;
        return copy;
    }
}
