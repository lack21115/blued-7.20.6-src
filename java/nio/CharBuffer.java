package java.nio;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/CharBuffer.class */
public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, CharSequence, Appendable, Readable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CharBuffer(int i, long j) {
        super(1, i, j);
    }

    public static CharBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new CharArrayBuffer(new char[i]);
    }

    public static CharBuffer wrap(CharSequence charSequence) {
        return new CharSequenceAdapter(charSequence);
    }

    public static CharBuffer wrap(CharSequence charSequence, int i, int i2) {
        if (i < 0 || i2 < i || i2 > charSequence.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + charSequence.length() + ", start=" + i + ", end=" + i2);
        }
        CharSequenceAdapter charSequenceAdapter = new CharSequenceAdapter(charSequence);
        charSequenceAdapter.position = i;
        charSequenceAdapter.limit = i2;
        return charSequenceAdapter;
    }

    public static CharBuffer wrap(char[] cArr) {
        return wrap(cArr, 0, cArr.length);
    }

    public static CharBuffer wrap(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(cArr);
        charArrayBuffer.position = i;
        charArrayBuffer.limit = i + i2;
        return charArrayBuffer;
    }

    @Override // java.lang.Appendable
    public CharBuffer append(char c) {
        return put(c);
    }

    @Override // java.lang.Appendable
    public CharBuffer append(CharSequence charSequence) {
        return charSequence != null ? put(charSequence.toString()) : put("null");
    }

    @Override // java.lang.Appendable
    public CharBuffer append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "null";
        }
        CharSequence subSequence = charSequence2.subSequence(i, i2);
        CharBuffer charBuffer = this;
        if (subSequence.length() > 0) {
            charBuffer = put(subSequence.toString());
        }
        return charBuffer;
    }

    @Override // java.nio.Buffer
    public final char[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract CharBuffer asReadOnlyBuffer();

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (i < 0 || i >= remaining()) {
            throw new IndexOutOfBoundsException("index=" + i + ", remaining()=" + remaining());
        }
        return get(this.position + i);
    }

    public abstract CharBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(CharBuffer charBuffer) {
        int i = this.position;
        int i2 = charBuffer.position;
        for (int remaining = remaining() < charBuffer.remaining() ? remaining() : charBuffer.remaining(); remaining > 0; remaining--) {
            char c = get(i);
            char c2 = charBuffer.get(i2);
            if (c != c2) {
                return c < c2 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - charBuffer.remaining();
    }

    public abstract CharBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) obj;
            if (remaining() == charBuffer.remaining()) {
                int i = charBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    z = get(i2) == charBuffer.get(i);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public abstract char get();

    public abstract char get(int i);

    public CharBuffer get(char[] cArr) {
        return get(cArr, 0, cArr.length);
    }

    public CharBuffer get(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            cArr[i4] = get();
            i3 = i4 + 1;
        }
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return protectedHasArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    public int hashCode() {
        char c = 0;
        for (int i = this.position; i < this.limit; i++) {
            c += get(i);
        }
        return c;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    @Override // java.lang.CharSequence
    public final int length() {
        return remaining();
    }

    public abstract ByteOrder order();

    abstract char[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract CharBuffer put(char c);

    public abstract CharBuffer put(int i, char c);

    public final CharBuffer put(String str) {
        return put(str, 0, str.length());
    }

    public CharBuffer put(String str, int i, int i2) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (i < 0 || i2 < i || i2 > str.length()) {
            throw new IndexOutOfBoundsException("str.length()=" + str.length() + ", start=" + i + ", end=" + i2);
        }
        if (i2 - i > remaining()) {
            throw new BufferOverflowException();
        }
        while (i < i2) {
            put(str.charAt(i));
            i++;
        }
        return this;
    }

    public CharBuffer put(CharBuffer charBuffer) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (charBuffer == this) {
            throw new IllegalArgumentException("src == this");
        }
        if (charBuffer.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        char[] cArr = new char[charBuffer.remaining()];
        charBuffer.get(cArr);
        put(cArr);
        return this;
    }

    public final CharBuffer put(char[] cArr) {
        return put(cArr, 0, cArr.length);
    }

    public CharBuffer put(char[] cArr, int i, int i2) {
        Arrays.checkOffsetAndCount(cArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(cArr[i4]);
            i3 = i4 + 1;
        }
    }

    @Override // java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        int remaining = remaining();
        if (charBuffer == this) {
            if (remaining == 0) {
                return -1;
            }
            throw new IllegalArgumentException("target == this");
        } else if (remaining == 0) {
            return (this.limit <= 0 || charBuffer.remaining() != 0) ? -1 : 0;
        } else {
            int min = Math.min(charBuffer.remaining(), remaining);
            if (min > 0) {
                char[] cArr = new char[min];
                get(cArr);
                charBuffer.put(cArr);
            }
            return min;
        }
    }

    public abstract CharBuffer slice();

    @Override // java.lang.CharSequence
    public abstract CharBuffer subSequence(int i, int i2);

    @Override // java.nio.Buffer, java.lang.CharSequence
    public String toString() {
        StringBuilder sb = new StringBuilder(this.limit - this.position);
        int i = this.position;
        while (true) {
            int i2 = i;
            if (i2 >= this.limit) {
                return sb.toString();
            }
            sb.append(get(i2));
            i = i2 + 1;
        }
    }
}
