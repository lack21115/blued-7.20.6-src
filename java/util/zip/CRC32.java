package java.util.zip;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/CRC32.class */
public class CRC32 implements Checksum {
    private long crc = 0;
    long tbytes = 0;

    private native long updateByteImpl(byte b, long j);

    private native long updateImpl(byte[] bArr, int i, int i2, long j);

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.crc;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.crc = 0L;
        this.tbytes = 0L;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        this.crc = updateByteImpl((byte) i, this.crc);
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        this.tbytes += i2;
        this.crc = updateImpl(bArr, i, i2, this.crc);
    }
}
