package com.blued.android.core.image.apng.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/ByteBufferReader.class */
public class ByteBufferReader implements Reader {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f9549a;

    public ByteBufferReader(ByteBuffer byteBuffer) {
        this.f9549a = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int available() throws IOException {
        return this.f9549a.limit() - this.f9549a.position();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int b() {
        return this.f9549a.position();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public void close() throws IOException {
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public byte n_() throws IOException {
        return this.f9549a.get();
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public InputStream o_() throws IOException {
        return new ByteArrayInputStream(this.f9549a.array());
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.f9549a.get(bArr, i, i2);
        return i2;
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public void reset() throws IOException {
        this.f9549a.position(0);
    }

    @Override // com.blued.android.core.image.apng.io.Reader
    public long skip(long j) throws IOException {
        ByteBuffer byteBuffer = this.f9549a;
        byteBuffer.position((int) (byteBuffer.position() + j));
        return j;
    }
}
