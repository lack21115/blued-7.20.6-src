package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/ByteArrayOutputStream.class */
public class ByteArrayOutputStream extends OutputStream {
    protected byte[] buf;
    protected int count;

    public ByteArrayOutputStream() {
        this.buf = new byte[32];
    }

    public ByteArrayOutputStream(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size < 0");
        }
        this.buf = new byte[i];
    }

    private void expand(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] bArr = new byte[(this.count + i) * 2];
        System.arraycopy(this.buf, 0, bArr, 0, this.count);
        this.buf = bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    public void reset() {
        synchronized (this) {
            this.count = 0;
        }
    }

    public int size() {
        return this.count;
    }

    public byte[] toByteArray() {
        byte[] bArr;
        synchronized (this) {
            bArr = new byte[this.count];
            System.arraycopy(this.buf, 0, bArr, 0, this.count);
        }
        return bArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Deprecated
    public String toString(int i) {
        char[] cArr = new char[size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= cArr.length) {
                return new String(cArr);
            }
            cArr[i3] = (char) (((i & 255) << 8) | (this.buf[i3] & 255));
            i2 = i3 + 1;
        }
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.buf, 0, this.count, str);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        synchronized (this) {
            if (this.count == this.buf.length) {
                expand(1);
            }
            byte[] bArr = this.buf;
            int i2 = this.count;
            this.count = i2 + 1;
            bArr[i2] = (byte) i;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        synchronized (this) {
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 != 0) {
                expand(i2);
                System.arraycopy(bArr, i, this.buf, this.count, i2);
                this.count += i2;
            }
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        synchronized (this) {
            outputStream.write(this.buf, 0, this.count);
        }
    }
}
