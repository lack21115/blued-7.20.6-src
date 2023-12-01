package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/CipherLiteInputStream.class */
public class CipherLiteInputStream extends SdkFilterInputStream {
    private static final int DEFAULT_IN_BUFFER_SIZE = 512;
    private static final int MAX_RETRY = 1000;
    private byte[] bufin;
    private byte[] bufout;
    private CipherLite cipherLite;
    private int curr_pos;
    private boolean eof;
    private final boolean lastMultiPart;
    private int max_pos;
    private final boolean multipart;

    /* JADX INFO: Access modifiers changed from: protected */
    public CipherLiteInputStream(InputStream inputStream) {
        this(inputStream, CipherLite.Null, 512, false, false);
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite) {
        this(inputStream, cipherLite, 512, false, false);
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int i) {
        this(inputStream, cipherLite, i, false, false);
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int i, boolean z, boolean z2) {
        super(inputStream);
        this.max_pos = -1;
        if (z2 && !z) {
            throw new IllegalArgumentException("lastMultiPart can only be true if multipart is true");
        }
        this.multipart = z;
        this.lastMultiPart = z2;
        this.cipherLite = cipherLite;
        if (i > 0 && i % 512 == 0) {
            this.bufin = new byte[i];
            return;
        }
        throw new IllegalArgumentException("buffsize (" + i + ") must be a positive multiple of 512");
    }

    private int nextChunk() throws IOException {
        abortIfNeeded();
        if (this.eof) {
            return -1;
        }
        this.bufout = null;
        int read = this.in.read(this.bufin);
        int i = 0;
        if (read != -1) {
            byte[] update = this.cipherLite.update(this.bufin, 0, read);
            this.bufout = update;
            this.curr_pos = 0;
            if (update != null) {
                i = update.length;
            }
            this.max_pos = i;
            return i;
        }
        this.eof = true;
        if (!this.multipart || this.lastMultiPart) {
            try {
                byte[] doFinal = this.cipherLite.doFinal();
                this.bufout = doFinal;
                if (doFinal == null) {
                    return -1;
                }
                this.curr_pos = 0;
                int length = doFinal.length;
                this.max_pos = length;
                return length;
            } catch (BadPaddingException e) {
                if (COSCryptoScheme.isAesGcm(this.cipherLite.getCipherAlgorithm())) {
                    throw new SecurityException(e);
                }
                return -1;
            } catch (IllegalBlockSizeException e2) {
                return -1;
            }
        }
        return -1;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() {
        abortIfNeeded();
        return this.max_pos - this.curr_pos;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
        if (!this.multipart && !COSCryptoScheme.isAesGcm(this.cipherLite.getCipherAlgorithm())) {
            try {
                this.cipherLite.doFinal();
            } catch (BadPaddingException | IllegalBlockSizeException e) {
            }
        }
        this.max_pos = 0;
        this.curr_pos = 0;
        abortIfNeeded();
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        abortIfNeeded();
        this.in.mark(i);
        this.cipherLite.mark();
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        abortIfNeeded();
        return this.in.markSupported() && this.cipherLite.markSupported();
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.curr_pos >= this.max_pos) {
            if (this.eof) {
                return -1;
            }
            int i = 0;
            while (i <= 1000) {
                int nextChunk = nextChunk();
                i++;
                if (nextChunk != 0) {
                    if (nextChunk == -1) {
                        return -1;
                    }
                }
            }
            throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        byte[] bArr = this.bufout;
        int i2 = this.curr_pos;
        this.curr_pos = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.curr_pos >= this.max_pos) {
            if (this.eof) {
                return -1;
            }
            int i3 = 0;
            while (i3 <= 1000) {
                int nextChunk = nextChunk();
                i3++;
                if (nextChunk != 0) {
                    if (nextChunk == -1) {
                        return -1;
                    }
                }
            }
            throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        if (i2 <= 0) {
            return 0;
        }
        int i4 = this.max_pos - this.curr_pos;
        if (i2 >= i4) {
            i2 = i4;
        }
        System.arraycopy(this.bufout, this.curr_pos, bArr, i, i2);
        this.curr_pos += i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void renewCipherLite() throws CosXmlClientException {
        this.cipherLite = this.cipherLite.recreate();
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        abortIfNeeded();
        this.in.reset();
        this.cipherLite.reset();
        resetInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void resetInternal() {
        this.max_pos = 0;
        this.curr_pos = 0;
        this.eof = false;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        abortIfNeeded();
        long j2 = this.max_pos - this.curr_pos;
        long j3 = j;
        if (j > j2) {
            j3 = j2;
        }
        if (j3 < 0) {
            return 0L;
        }
        this.curr_pos = (int) (this.curr_pos + j3);
        return j3;
    }
}
