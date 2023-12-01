package com.tencent.cos.xml.crypto;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/LengthCheckInputStream.class */
public class LengthCheckInputStream extends SdkFilterInputStream {
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    private long dataLength;
    private final long expectedLength;
    private final boolean includeSkipped;
    private int markCount;
    private long marked;
    private int resetCount;
    private boolean resetSinceLastMarked;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        this.expectedLength = j;
        this.includeSkipped = z;
    }

    private void checkLength(boolean z) throws IOException {
        if (z) {
            if (this.dataLength == this.expectedLength) {
                return;
            }
            throw new IOException("Data read has a different length than the expected: " + diagnosticInfo());
        } else if (this.dataLength <= this.expectedLength) {
        } else {
            throw new IOException("More data read than expected: " + diagnosticInfo());
        }
    }

    private String diagnosticInfo() {
        return "dataLength=" + this.dataLength + "; expectedLength=" + this.expectedLength + "; includeSkipped=" + this.includeSkipped + "; in.getClass()=" + this.f42254in.getClass() + "; markedSupported=" + markSupported() + "; marked=" + this.marked + "; resetSinceLastMarked=" + this.resetSinceLastMarked + "; markCount=" + this.markCount + "; resetCount=" + this.resetCount;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (markSupported()) {
            super.mark(i);
            this.marked = this.dataLength;
            this.markCount++;
            this.resetSinceLastMarked = false;
        }
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.dataLength++;
        }
        checkLength(read == -1);
        return read;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.dataLength += read >= 0 ? read : 0L;
        checkLength(read == -1);
        return read;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!markSupported()) {
            throw new IOException("mark/reset not supported");
        }
        super.reset();
        this.dataLength = this.marked;
        this.resetCount++;
        this.resetSinceLastMarked = true;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (this.includeSkipped && skip > 0) {
            this.dataLength += skip;
            checkLength(false);
        }
        return skip;
    }
}
