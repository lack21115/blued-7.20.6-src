package com.blued.android.core.image.apng.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/StreamReader.class */
public class StreamReader extends FilterInputStream implements Reader {

    /* renamed from: a  reason: collision with root package name */
    private int f9552a;

    public StreamReader(InputStream inputStream) {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException e) {
        }
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int b() {
        return this.f9552a;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public byte n_() throws IOException {
        byte read = (byte) read();
        this.f9552a++;
        return read;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public InputStream o_() throws IOException {
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.f9552a += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            super.reset();
            this.f9552a = 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        this.f9552a = (int) (this.f9552a + skip);
        return skip;
    }
}
