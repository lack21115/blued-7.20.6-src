package java.io;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: source-2895416-dex2jar.jar:java/io/SequenceInputStream.class */
public class SequenceInputStream extends InputStream {
    private Enumeration<? extends InputStream> e;
    private InputStream in;

    public SequenceInputStream(InputStream inputStream, InputStream inputStream2) {
        if (inputStream == null) {
            throw new NullPointerException("s1 == null");
        }
        Vector vector = new Vector(1);
        vector.addElement(inputStream2);
        this.e = vector.elements();
        this.in = inputStream;
    }

    public SequenceInputStream(Enumeration<? extends InputStream> enumeration) {
        this.e = enumeration;
        if (enumeration.hasMoreElements()) {
            this.in = enumeration.nextElement();
            if (this.in == null) {
                throw new NullPointerException("element is null");
            }
        }
    }

    private void nextStream() throws IOException {
        if (this.in != null) {
            this.in.close();
        }
        if (!this.e.hasMoreElements()) {
            this.in = null;
            return;
        }
        this.in = this.e.nextElement();
        if (this.in == null) {
            throw new NullPointerException("element is null");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.e == null || this.in == null) {
            return 0;
        }
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        while (this.in != null) {
            nextStream();
        }
        this.e = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (this.in != null) {
            int read = this.in.read();
            if (read >= 0) {
                return read;
            }
            nextStream();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.in != null) {
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            while (this.in != null) {
                int read = this.in.read(bArr, i, i2);
                i3 = read;
                if (read < 0) {
                    nextStream();
                }
            }
            return -1;
        }
        i3 = -1;
        return i3;
    }
}
