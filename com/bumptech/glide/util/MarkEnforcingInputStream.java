package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/MarkEnforcingInputStream.class */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f21106a;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.f21106a = Integer.MIN_VALUE;
    }

    private long a(long j) {
        int i = this.f21106a;
        if (i == 0) {
            return -1L;
        }
        long j2 = j;
        if (i != Integer.MIN_VALUE) {
            j2 = j;
            if (j > i) {
                j2 = i;
            }
        }
        return j2;
    }

    private void b(long j) {
        int i = this.f21106a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f21106a = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f21106a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            super.mark(i);
            this.f21106a = i;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int a2 = (int) a(i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            super.reset();
            this.f21106a = Integer.MIN_VALUE;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return 0L;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }
}
