package javax.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/CipherInputStream.class */
public class CipherInputStream extends FilterInputStream {
    private final Cipher cipher;
    private boolean finished;
    private final byte[] inputBuffer;
    private byte[] outputBuffer;
    private int outputIndex;
    private int outputLength;

    protected CipherInputStream(InputStream inputStream) {
        this(inputStream, new NullCipher());
    }

    public CipherInputStream(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.cipher = cipher;
        int max = Math.max(cipher.getBlockSize(), 1);
        int max2 = Math.max(max, (8192 / max) * max);
        this.inputBuffer = new byte[max2];
        this.outputBuffer = new byte[(max > 1 ? max * 2 : 0) + max2];
    }

    private boolean fillBuffer() throws IOException {
        if (this.finished) {
            return false;
        }
        this.outputIndex = 0;
        this.outputLength = 0;
        while (this.outputLength == 0) {
            int outputSize = this.cipher.getOutputSize(this.inputBuffer.length);
            if (this.outputBuffer == null || this.outputBuffer.length < outputSize) {
                this.outputBuffer = new byte[outputSize];
            }
            int read = this.in.read(this.inputBuffer);
            if (read == -1) {
                try {
                    this.outputLength = this.cipher.doFinal(this.outputBuffer, 0);
                    this.finished = true;
                    return this.outputLength != 0;
                } catch (Exception e) {
                    throw new IOException("Error while finalizing cipher", e);
                }
            }
            try {
                this.outputLength = this.cipher.update(this.inputBuffer, 0, read, this.outputBuffer, 0);
            } catch (ShortBufferException e2) {
                throw new AssertionError(e2);
            }
        }
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.outputLength - this.outputIndex;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
        try {
            this.cipher.doFinal();
        } catch (GeneralSecurityException e) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.in == null) {
            throw new NullPointerException("in == null");
        }
        if (this.outputIndex != this.outputLength || fillBuffer()) {
            byte[] bArr = this.outputBuffer;
            int i = this.outputIndex;
            this.outputIndex = i + 1;
            return bArr[i] & 255;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.in == null) {
            throw new NullPointerException("in == null");
        }
        if (this.outputIndex != this.outputLength || fillBuffer()) {
            int i3 = this.outputLength - this.outputIndex;
            int i4 = i2;
            if (i3 < i2) {
                i4 = i3;
            }
            if (bArr != null) {
                System.arraycopy(this.outputBuffer, this.outputIndex, bArr, i, i4);
            }
            this.outputIndex += i4;
            return i4;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        return Streams.skipByReading(this, j);
    }
}
