package com.sobot.chat.widget.zxing.common;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/BitSource.class */
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
        if (i < 1 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.bitOffset;
        int i3 = 0;
        int i4 = i;
        if (i2 > 0) {
            int i5 = 8 - i2;
            int min = Math.min(i, i5);
            int i6 = i5 - min;
            byte[] bArr = this.bytes;
            int i7 = this.byteOffset;
            byte b = bArr[i7];
            i4 = i - min;
            int i8 = this.bitOffset + min;
            this.bitOffset = i8;
            if (i8 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
            i3 = (((255 >> (8 - min)) << i6) & b) >> i6;
        }
        int i9 = i3;
        if (i4 > 0) {
            while (i4 >= 8) {
                byte[] bArr2 = this.bytes;
                int i10 = this.byteOffset;
                i3 = (bArr2[i10] & 255) | (i3 << 8);
                this.byteOffset = i10 + 1;
                i4 -= 8;
            }
            i9 = i3;
            if (i4 > 0) {
                int i11 = 8 - i4;
                i9 = (i3 << i4) | ((((255 >> i11) << i11) & this.bytes[this.byteOffset]) >> i11);
                this.bitOffset += i4;
            }
        }
        return i9;
    }
}
