package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/io/CountingInputStream.class */
public final class CountingInputStream extends FilterInputStream {
    private long count;
    private long mark;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.mark = -1L;
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.f42254in.mark(i);
            this.mark = this.count;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.f42254in.read();
        if (read != -1) {
            this.count++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f42254in.read(bArr, i, i2);
        if (read != -1) {
            this.count += read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            if (!this.f42254in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            this.f42254in.reset();
            this.count = this.mark;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f42254in.skip(j);
        this.count += skip;
        return skip;
    }
}
