package java.io;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: source-2895416-dex2jar.jar:java/io/SequenceInputStream.class */
public class SequenceInputStream extends InputStream {
    private Enumeration<? extends InputStream> e;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f42259in;

    public SequenceInputStream(InputStream inputStream, InputStream inputStream2) {
        if (inputStream == null) {
            throw new NullPointerException("s1 == null");
        }
        Vector vector = new Vector(1);
        vector.addElement(inputStream2);
        this.e = vector.elements();
        this.f42259in = inputStream;
    }

    public SequenceInputStream(Enumeration<? extends InputStream> enumeration) {
        this.e = enumeration;
        if (enumeration.hasMoreElements()) {
            this.f42259in = enumeration.nextElement();
            if (this.f42259in == null) {
                throw new NullPointerException("element is null");
            }
        }
    }

    private void nextStream() throws IOException {
        if (this.f42259in != null) {
            this.f42259in.close();
        }
        if (!this.e.hasMoreElements()) {
            this.f42259in = null;
            return;
        }
        this.f42259in = this.e.nextElement();
        if (this.f42259in == null) {
            throw new NullPointerException("element is null");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.e == null || this.f42259in == null) {
            return 0;
        }
        return this.f42259in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        while (this.f42259in != null) {
            nextStream();
        }
        this.e = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (this.f42259in != null) {
            int read = this.f42259in.read();
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
        if (this.f42259in != null) {
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            while (this.f42259in != null) {
                int read = this.f42259in.read(bArr, i, i2);
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
