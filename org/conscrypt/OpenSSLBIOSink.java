package org.conscrypt;

import java.io.ByteArrayOutputStream;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLBIOSink.class */
final class OpenSSLBIOSink {
    private final ByteArrayOutputStream buffer;
    private final long ctx;
    private int position;

    private OpenSSLBIOSink(ByteArrayOutputStream byteArrayOutputStream) {
        this.ctx = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        this.buffer = byteArrayOutputStream;
    }

    static OpenSSLBIOSink create() {
        return new OpenSSLBIOSink(new ByteArrayOutputStream());
    }

    int available() {
        return this.buffer.size() - this.position;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.BIO_free_all(this.ctx);
        } finally {
            super.finalize();
        }
    }

    long getContext() {
        return this.ctx;
    }

    int position() {
        return this.position;
    }

    void reset() {
        this.buffer.reset();
        this.position = 0;
    }

    long skip(long j) {
        int min = Math.min(available(), (int) j);
        int i = this.position + min;
        this.position = i;
        if (i == this.buffer.size()) {
            reset();
        }
        return min;
    }

    byte[] toByteArray() {
        return this.buffer.toByteArray();
    }
}
