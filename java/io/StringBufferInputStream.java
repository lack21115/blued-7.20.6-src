package java.io;

import java.util.Arrays;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:java/io/StringBufferInputStream.class */
public class StringBufferInputStream extends InputStream {
    protected String buffer;
    protected int count;
    protected int pos;

    public StringBufferInputStream(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.buffer = str;
        this.count = str.length();
    }

    @Override // java.io.InputStream
    public int available() {
        int i;
        int i2;
        synchronized (this) {
            i = this.count;
            i2 = this.pos;
        }
        return i - i2;
    }

    @Override // java.io.InputStream
    public int read() {
        int i;
        synchronized (this) {
            if (this.pos < this.count) {
                String str = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                i = str.charAt(i2) & 255;
            } else {
                i = -1;
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        synchronized (this) {
            if (bArr == null) {
                throw new NullPointerException("buffer == null");
            }
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 == 0) {
                i2 = 0;
            } else {
                if (this.count - this.pos < i2) {
                    i2 = this.count - this.pos;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= i2) {
                        break;
                    }
                    bArr[i + i4] = (byte) this.buffer.charAt(this.pos + i4);
                    i3 = i4 + 1;
                }
                this.pos += i2;
            }
        }
        return i2;
    }

    @Override // java.io.InputStream
    public void reset() {
        synchronized (this) {
            this.pos = 0;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int i;
        long j2;
        synchronized (this) {
            if (j <= 0) {
                j2 = 0;
            } else {
                if (this.count - this.pos < j) {
                    i = this.count - this.pos;
                    this.pos = this.count;
                } else {
                    i = (int) j;
                    this.pos = (int) (this.pos + j);
                }
                j2 = i;
            }
        }
        return j2;
    }
}
