package com.blued.android.core.image.apng.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/StreamReader.class */
public class StreamReader extends FilterInputStream implements Reader {
    private int a;

    public StreamReader(InputStream inputStream) {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException e) {
        }
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int b() {
        return this.a;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public byte n_() throws IOException {
        byte read = (byte) read();
        this.a++;
        return read;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public InputStream o_() throws IOException {
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.a += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            super.reset();
            this.a = 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        this.a = (int) (this.a + skip);
        return skip;
    }
}
