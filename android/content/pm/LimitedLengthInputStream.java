package android.content.pm;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/LimitedLengthInputStream.class */
public class LimitedLengthInputStream extends FilterInputStream {
    private final long mEnd;
    private long mOffset;

    public LimitedLengthInputStream(InputStream inputStream, long j, long j2) throws IOException {
        super(inputStream);
        if (inputStream == null) {
            throw new IOException("in == null");
        }
        if (j < 0) {
            throw new IOException("offset < 0");
        }
        if (j2 < 0) {
            throw new IOException("length < 0");
        }
        if (j2 > Long.MAX_VALUE - j) {
            throw new IOException("offset + length > Long.MAX_VALUE");
        }
        this.mEnd = j + j2;
        skip(j);
        this.mOffset = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        synchronized (this) {
            if (this.mOffset >= this.mEnd) {
                read = -1;
            } else {
                this.mOffset++;
                read = super.read();
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.mOffset >= this.mEnd) {
            return -1;
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (this.mOffset > Long.MAX_VALUE - i2) {
            throw new IOException("offset out of bounds: " + this.mOffset + " + " + i2);
        }
        int i3 = i2;
        if (this.mOffset + i2 > this.mEnd) {
            i3 = (int) (this.mEnd - this.mOffset);
        }
        int read = super.read(bArr, i, i3);
        this.mOffset += read;
        return read;
    }
}
