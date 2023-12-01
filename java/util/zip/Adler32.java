package java.util.zip;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/Adler32.class */
public class Adler32 implements Checksum {
    private long adler = 1;

    private native long updateByteImpl(int i, long j);

    private native long updateImpl(byte[] bArr, int i, int i2, long j);

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.adler;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.adler = 1L;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        this.adler = updateByteImpl(i, this.adler);
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        this.adler = updateImpl(bArr, i, i2, this.adler);
    }
}
