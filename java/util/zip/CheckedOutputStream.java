package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/CheckedOutputStream.class */
public class CheckedOutputStream extends FilterOutputStream {
    private final Checksum check;

    public CheckedOutputStream(OutputStream outputStream, Checksum checksum) {
        super(outputStream);
        this.check = checksum;
    }

    public Checksum getChecksum() {
        return this.check;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.check.update(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.check.update(bArr, i, i2);
    }
}
