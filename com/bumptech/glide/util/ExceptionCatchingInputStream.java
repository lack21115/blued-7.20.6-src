package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ExceptionCatchingInputStream.class */
public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<ExceptionCatchingInputStream> f7492a = Util.a(0);
    private InputStream b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f7493c;

    ExceptionCatchingInputStream() {
    }

    public static ExceptionCatchingInputStream a(InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        synchronized (f7492a) {
            poll = f7492a.poll();
        }
        ExceptionCatchingInputStream exceptionCatchingInputStream = poll;
        if (poll == null) {
            exceptionCatchingInputStream = new ExceptionCatchingInputStream();
        }
        exceptionCatchingInputStream.b(inputStream);
        return exceptionCatchingInputStream;
    }

    public IOException a() {
        return this.f7493c;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.b.available();
    }

    public void b() {
        this.f7493c = null;
        this.b = null;
        synchronized (f7492a) {
            f7492a.offer(this);
        }
    }

    void b(InputStream inputStream) {
        this.b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.b.read();
        } catch (IOException e) {
            this.f7493c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.b.read(bArr);
        } catch (IOException e) {
            this.f7493c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f7493c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            this.b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.b.skip(j);
        } catch (IOException e) {
            this.f7493c = e;
            return 0L;
        }
    }
}
