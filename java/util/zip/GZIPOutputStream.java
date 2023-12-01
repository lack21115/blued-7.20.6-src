package java.util.zip;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/GZIPOutputStream.class */
public class GZIPOutputStream extends DeflaterOutputStream {
    protected CRC32 crc;

    public GZIPOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 512, false);
    }

    public GZIPOutputStream(OutputStream outputStream, int i) throws IOException {
        this(outputStream, i, false);
    }

    public GZIPOutputStream(OutputStream outputStream, int i, boolean z) throws IOException {
        super(outputStream, new Deflater(-1, true), i, z);
        this.crc = new CRC32();
        writeShort(GZIPInputStream.GZIP_MAGIC);
        this.out.write(8);
        this.out.write(0);
        writeLong(0L);
        this.out.write(0);
        this.out.write(0);
    }

    public GZIPOutputStream(OutputStream outputStream, boolean z) throws IOException {
        this(outputStream, 512, z);
    }

    private long writeLong(long j) throws IOException {
        int i = (int) j;
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
        this.out.write((i >> 16) & 255);
        this.out.write((i >> 24) & 255);
        return j;
    }

    private int writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
        return i;
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() throws IOException {
        super.finish();
        writeLong(this.crc.getValue());
        writeLong(this.crc.tbytes);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
        this.crc.update(bArr, i, i2);
    }
}
