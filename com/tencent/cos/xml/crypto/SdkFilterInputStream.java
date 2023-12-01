package com.tencent.cos.xml.crypto;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/SdkFilterInputStream.class */
public class SdkFilterInputStream extends FilterInputStream implements Releasable {
    private volatile boolean aborted;

    /* JADX INFO: Access modifiers changed from: protected */
    public SdkFilterInputStream(InputStream inputStream) {
        super(inputStream);
        this.aborted = false;
    }

    public void abort() {
        if (this.aborted) {
            return;
        }
        this.aborted = true;
        if (this.f42254in instanceof SdkFilterInputStream) {
            ((SdkFilterInputStream) this.f42254in).abort();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void abortIfNeeded() {
        if (Thread.interrupted()) {
            abort();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        abortIfNeeded();
        return this.f42254in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f42254in.close();
        abortIfNeeded();
    }

    protected boolean isAborted() {
        return this.aborted;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            abortIfNeeded();
            this.f42254in.mark(i);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        abortIfNeeded();
        return this.f42254in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        return this.f42254in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        return this.f42254in.read(bArr, i, i2);
    }

    public void release() {
        IOUtils.closeQuietly(this);
        if (this.f42254in instanceof Releasable) {
            ((Releasable) this.f42254in).release();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            abortIfNeeded();
            this.f42254in.reset();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        abortIfNeeded();
        return this.f42254in.skip(j);
    }
}
