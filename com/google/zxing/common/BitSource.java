package com.google.zxing.common;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/common/BitSource.class */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i) {
        if (i <= 0 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.bitOffset;
        int i3 = 0;
        int i4 = i;
        if (i2 > 0) {
            int i5 = 8 - i2;
            int i6 = i < i5 ? i : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.bytes;
            int i8 = this.byteOffset;
            byte b = bArr[i8];
            i4 = i - i6;
            int i9 = this.bitOffset + i6;
            this.bitOffset = i9;
            if (i9 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i8 + 1;
            }
            i3 = (((255 >> (8 - i6)) << i7) & b) >> i7;
        }
        int i10 = i3;
        if (i4 > 0) {
            while (i4 >= 8) {
                byte[] bArr2 = this.bytes;
                int i11 = this.byteOffset;
                i3 = (bArr2[i11] & 255) | (i3 << 8);
                this.byteOffset = i11 + 1;
                i4 -= 8;
            }
            i10 = i3;
            if (i4 > 0) {
                int i12 = 8 - i4;
                i10 = (i3 << i4) | ((((255 >> i12) << i12) & this.bytes[this.byteOffset]) >> i12);
                this.bitOffset += i4;
            }
        }
        return i10;
    }
}
