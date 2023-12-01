package com.blued.android.core.image.apng.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/FilterReader.class */
public class FilterReader implements Reader {
    protected Reader a;

    public FilterReader(Reader reader) {
        this.a = reader;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int available() throws IOException {
        return this.a.available();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int b() {
        return this.a.b();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public byte n_() throws IOException {
        return this.a.n_();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public InputStream o_() throws IOException {
        reset();
        return this.a.o_();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.a.read(bArr, i, i2);
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public void reset() throws IOException {
        this.a.reset();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public long skip(long j) throws IOException {
        return this.a.skip(j);
    }
}
