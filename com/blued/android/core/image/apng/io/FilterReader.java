package com.blued.android.core.image.apng.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/FilterReader.class */
public class FilterReader implements Reader {

    /* renamed from: a  reason: collision with root package name */
    protected Reader f9551a;

    public FilterReader(Reader reader) {
        this.f9551a = reader;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int available() throws IOException {
        return this.f9551a.available();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int b() {
        return this.f9551a.b();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public void close() throws IOException {
        this.f9551a.close();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public byte n_() throws IOException {
        return this.f9551a.n_();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public InputStream o_() throws IOException {
        reset();
        return this.f9551a.o_();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f9551a.read(bArr, i, i2);
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public void reset() throws IOException {
        this.f9551a.reset();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public long skip(long j) throws IOException {
        return this.f9551a.skip(j);
    }
}
