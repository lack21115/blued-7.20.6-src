package com.android.org.conscrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLBIOInputStream.class */
public class OpenSSLBIOInputStream extends FilterInputStream {
    private long ctx;

    public OpenSSLBIOInputStream(InputStream inputStream) {
        super(inputStream);
        this.ctx = NativeCrypto.create_BIO_InputStream(this);
    }

    public long getBioContext() {
        return this.ctx;
    }

    public int gets(byte[] bArr) throws IOException {
        int i;
        if (bArr != null && bArr.length != 0) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i2 >= bArr.length) {
                    break;
                }
                int read = read();
                i = i2;
                if (read == -1) {
                    break;
                } else if (read == 10) {
                    i = i2;
                    if (i2 != 0) {
                        break;
                    }
                } else {
                    bArr[i2] = (byte) read;
                    i2++;
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    public void release() {
        NativeCrypto.BIO_free_all(this.ctx);
    }
}
