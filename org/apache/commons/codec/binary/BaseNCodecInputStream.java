package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/binary/BaseNCodecInputStream.class */
public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final boolean doEncode;
    private final byte[] singleByte;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i;
        int read = read(this.singleByte, 0, 1);
        while (true) {
            i = read;
            if (i != 0) {
                break;
            }
            read = read(this.singleByte, 0, 1);
        }
        if (i > 0) {
            byte[] bArr = this.singleByte;
            return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw null;
        }
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 != 0) {
                return i4;
            }
            if (!this.baseNCodec.hasData()) {
                byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                int read = this.f42254in.read(bArr2);
                if (this.doEncode) {
                    this.baseNCodec.encode(bArr2, 0, read);
                } else {
                    this.baseNCodec.decode(bArr2, 0, read);
                }
            }
            i3 = this.baseNCodec.readResults(bArr, i, i2);
        }
    }
}
