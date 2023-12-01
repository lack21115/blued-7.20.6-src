package com.android.internal.util;

import java.io.IOException;
import java.io.InputStream;
import libcore.io.Streams;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/SizedInputStream.class */
public class SizedInputStream extends InputStream {
    private long mLength;
    private final InputStream mWrapped;

    public SizedInputStream(InputStream inputStream, long j) {
        this.mWrapped = inputStream;
        this.mLength = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.mWrapped.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return Streams.readSingleByte(this);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.mLength <= 0) {
            read = -1;
        } else {
            int i3 = i2;
            if (i2 > this.mLength) {
                i3 = (int) this.mLength;
            }
            read = this.mWrapped.read(bArr, i, i3);
            if (read != -1) {
                this.mLength -= read;
                return read;
            } else if (this.mLength > 0) {
                throw new IOException("Unexpected EOF; expected " + this.mLength + " more bytes");
            }
        }
        return read;
    }
}
