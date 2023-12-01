package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLBIOSource.class */
final class OpenSSLBIOSource {
    private OpenSSLBIOInputStream source;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLBIOSource$ByteBufferInputStream.class */
    static class ByteBufferInputStream extends InputStream {
        private final ByteBuffer source;

        ByteBufferInputStream(ByteBuffer byteBuffer) {
            this.source = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.source.limit() - this.source.position();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.source.remaining() > 0) {
                return this.source.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int position = this.source.position();
            this.source.get(bArr);
            return this.source.position() - position;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int min = Math.min(this.source.remaining(), i2);
            int position = this.source.position();
            this.source.get(bArr, i, min);
            return this.source.position() - position;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            this.source.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long position = this.source.position();
            this.source.position((int) (j + position));
            return this.source.position() - position;
        }
    }

    private OpenSSLBIOSource(OpenSSLBIOInputStream openSSLBIOInputStream) {
        this.source = openSSLBIOInputStream;
    }

    private void release() {
        synchronized (this) {
            if (this.source != null) {
                NativeCrypto.BIO_free_all(this.source.getBioContext());
                this.source = null;
            }
        }
    }

    static OpenSSLBIOSource wrap(ByteBuffer byteBuffer) {
        return new OpenSSLBIOSource(new OpenSSLBIOInputStream(new ByteBufferInputStream(byteBuffer), false));
    }

    protected void finalize() throws Throwable {
        try {
            release();
        } finally {
            super.finalize();
        }
    }

    long getContext() {
        return this.source.getBioContext();
    }
}
