package com.tencent.cos.xml.crypto;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/InputSubstream.class */
public final class InputSubstream extends SdkFilterInputStream {
    private static final int MAX_SKIPS = 100;
    private final boolean closeSourceStream;
    private long currentPosition;
    private long markedPosition;
    private final long requestedLength;
    private final long requestedOffset;

    public InputSubstream(InputStream inputStream, long j, long j2, boolean z) {
        super(inputStream);
        this.markedPosition = 0L;
        this.currentPosition = 0L;
        this.requestedLength = j2;
        this.requestedOffset = j;
        this.closeSourceStream = z;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        long j = this.currentPosition;
        long j2 = this.requestedOffset;
        return (int) Math.min(j < j2 ? this.requestedLength : (this.requestedLength + j2) - j, super.available());
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closeSourceStream) {
            super.close();
        }
    }

    InputStream getWrappedInputStream() {
        return this.in;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.markedPosition = this.currentPosition;
            super.mark(i);
        }
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read == -1 ? read : bArr[0];
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            long j = this.currentPosition;
            long j2 = this.requestedOffset;
            if (j >= j2) {
                long j3 = (this.requestedLength + j2) - j;
                if (j3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, (int) Math.min(i2, j3));
                this.currentPosition += read;
                return read;
            }
            long skip = super.skip(j2 - j);
            int i5 = i4;
            if (skip == 0) {
                i5 = i4 + 1;
                if (i5 > 100) {
                    throw new IOException("Unable to position the currentPosition from " + this.currentPosition + " to " + this.requestedOffset);
                }
            }
            this.currentPosition += skip;
            i3 = i5;
        }
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            this.currentPosition = this.markedPosition;
            super.reset();
        }
    }
}
