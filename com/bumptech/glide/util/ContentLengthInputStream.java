package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ContentLengthInputStream.class */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f7491a;
    private int b;

    private ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.f7491a = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
            return i;
        } else if (this.f7491a - this.b <= 0) {
            return i;
        } else {
            throw new IOException("Failed to read all expected data, expected: " + this.f7491a + ", but read: " + this.b);
        }
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int max;
        synchronized (this) {
            max = (int) Math.max(this.f7491a - this.b, this.in.available());
        }
        return max;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        synchronized (this) {
            read = super.read();
            a(read >= 0 ? 1 : -1);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int a2;
        synchronized (this) {
            a2 = a(super.read(bArr, i, i2));
        }
        return a2;
    }
}
