package com.android.org.conscrypt;

import java.io.ByteArrayOutputStream;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLBIOSink.class */
public final class OpenSSLBIOSink {
    private final ByteArrayOutputStream buffer;
    private final long ctx;
    private int position;

    private OpenSSLBIOSink(ByteArrayOutputStream byteArrayOutputStream) {
        this.ctx = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        this.buffer = byteArrayOutputStream;
    }

    public static OpenSSLBIOSink create() {
        return new OpenSSLBIOSink(new ByteArrayOutputStream());
    }

    public int available() {
        return this.buffer.size() - this.position;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.BIO_free_all(this.ctx);
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.ctx;
    }

    public int position() {
        return this.position;
    }

    public void reset() {
        this.buffer.reset();
        this.position = 0;
    }

    public long skip(long j) {
        int min = Math.min(available(), (int) j);
        this.position += min;
        if (this.position == this.buffer.size()) {
            reset();
        }
        return min;
    }

    public byte[] toByteArray() {
        return this.buffer.toByteArray();
    }
}
