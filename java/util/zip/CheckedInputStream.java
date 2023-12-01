package java.util.zip;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/CheckedInputStream.class */
public class CheckedInputStream extends FilterInputStream {
    private final Checksum check;

    public CheckedInputStream(InputStream inputStream, Checksum checksum) {
        super(inputStream);
        this.check = checksum;
    }

    public Checksum getChecksum() {
        return this.check;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.f42254in.read();
        if (read != -1) {
            this.check.update(read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f42254in.read(bArr, i, i2);
        if (read != -1) {
            this.check.update(bArr, i, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return Streams.skipByReading(this, j);
    }
}
