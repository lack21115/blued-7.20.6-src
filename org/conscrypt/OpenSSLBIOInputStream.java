package org.conscrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLBIOInputStream.class */
class OpenSSLBIOInputStream extends FilterInputStream {
    private long ctx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLBIOInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.ctx = NativeCrypto.create_BIO_InputStream(this, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getBioContext() {
        return this.ctx;
    }

    int gets(byte[] bArr) throws IOException {
        int i = 0;
        int i2 = 0;
        if (bArr != null) {
            if (bArr.length == 0) {
                return 0;
            }
            while (true) {
                i = i2;
                if (i2 >= bArr.length) {
                    break;
                }
                int read = read();
                if (read == -1) {
                    return i2;
                }
                if (read == 10) {
                    i = i2;
                    if (i2 != 0) {
                        break;
                    }
                } else {
                    bArr[i2] = (byte) read;
                    i2++;
                }
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Invalid bounds");
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (true) {
            int read = super.read(bArr, i + i3, (i2 - i3) - i);
            if (read != -1) {
                int i4 = i3 + read;
                i3 = i4;
                if (i + i4 >= i2) {
                    i3 = i4;
                    break;
                }
            } else {
                break;
            }
        }
        if (i3 == 0) {
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        NativeCrypto.BIO_free_all(this.ctx);
    }
}
