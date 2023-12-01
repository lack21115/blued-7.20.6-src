package org.apache.commons.codec.binary;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/binary/Base32.class */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private long bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        super(5, 8, i, bArr == null ? 0 : bArr.length);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + "]");
        } else {
            this.encodeSize = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
        }
        this.decodeSize = this.encodeSize - 1;
    }

    public Base32(boolean z) {
        this(0, null, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i, int i2) {
        byte b;
        if (this.eof) {
            return;
        }
        if (i2 < 0) {
            this.eof = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.eof = true;
                break;
            }
            ensureBufferSize(this.decodeSize);
            if (b2 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    this.modulus = (this.modulus + 1) % 8;
                    this.bitWorkArea = (this.bitWorkArea << 5) + b;
                    if (this.modulus == 0) {
                        byte[] bArr3 = this.buffer;
                        int i4 = this.pos;
                        this.pos = i4 + 1;
                        bArr3[i4] = (byte) ((this.bitWorkArea >> 32) & 255);
                        byte[] bArr4 = this.buffer;
                        int i5 = this.pos;
                        this.pos = i5 + 1;
                        bArr4[i5] = (byte) ((this.bitWorkArea >> 24) & 255);
                        byte[] bArr5 = this.buffer;
                        int i6 = this.pos;
                        this.pos = i6 + 1;
                        bArr5[i6] = (byte) ((this.bitWorkArea >> 16) & 255);
                        byte[] bArr6 = this.buffer;
                        int i7 = this.pos;
                        this.pos = i7 + 1;
                        bArr6[i7] = (byte) ((this.bitWorkArea >> 8) & 255);
                        byte[] bArr7 = this.buffer;
                        int i8 = this.pos;
                        this.pos = i8 + 1;
                        bArr7[i8] = (byte) (this.bitWorkArea & 255);
                    }
                }
            }
            i3++;
            i++;
        }
        if (!this.eof || this.modulus < 2) {
            return;
        }
        ensureBufferSize(this.decodeSize);
        switch (this.modulus) {
            case 2:
                byte[] bArr8 = this.buffer;
                int i9 = this.pos;
                this.pos = i9 + 1;
                bArr8[i9] = (byte) ((this.bitWorkArea >> 2) & 255);
                return;
            case 3:
                byte[] bArr9 = this.buffer;
                int i10 = this.pos;
                this.pos = i10 + 1;
                bArr9[i10] = (byte) ((this.bitWorkArea >> 7) & 255);
                return;
            case 4:
                this.bitWorkArea >>= 4;
                byte[] bArr10 = this.buffer;
                int i11 = this.pos;
                this.pos = i11 + 1;
                bArr10[i11] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr11 = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                bArr11[i12] = (byte) (this.bitWorkArea & 255);
                return;
            case 5:
                this.bitWorkArea >>= 1;
                byte[] bArr12 = this.buffer;
                int i13 = this.pos;
                this.pos = i13 + 1;
                bArr12[i13] = (byte) ((this.bitWorkArea >> 16) & 255);
                byte[] bArr13 = this.buffer;
                int i14 = this.pos;
                this.pos = i14 + 1;
                bArr13[i14] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr14 = this.buffer;
                int i15 = this.pos;
                this.pos = i15 + 1;
                bArr14[i15] = (byte) (this.bitWorkArea & 255);
                return;
            case 6:
                this.bitWorkArea >>= 6;
                byte[] bArr15 = this.buffer;
                int i16 = this.pos;
                this.pos = i16 + 1;
                bArr15[i16] = (byte) ((this.bitWorkArea >> 16) & 255);
                byte[] bArr16 = this.buffer;
                int i17 = this.pos;
                this.pos = i17 + 1;
                bArr16[i17] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr17 = this.buffer;
                int i18 = this.pos;
                this.pos = i18 + 1;
                bArr17[i18] = (byte) (this.bitWorkArea & 255);
                return;
            case 7:
                this.bitWorkArea >>= 3;
                byte[] bArr18 = this.buffer;
                int i19 = this.pos;
                this.pos = i19 + 1;
                bArr18[i19] = (byte) ((this.bitWorkArea >> 24) & 255);
                byte[] bArr19 = this.buffer;
                int i20 = this.pos;
                this.pos = i20 + 1;
                bArr19[i20] = (byte) ((this.bitWorkArea >> 16) & 255);
                byte[] bArr20 = this.buffer;
                int i21 = this.pos;
                this.pos = i21 + 1;
                bArr20[i21] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr21 = this.buffer;
                int i22 = this.pos;
                this.pos = i22 + 1;
                bArr21[i22] = (byte) (this.bitWorkArea & 255);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v76, types: [int] */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                ensureBufferSize(this.encodeSize);
                this.modulus = (this.modulus + 1) % 5;
                byte b = bArr[i];
                byte b2 = b;
                if (b < 0) {
                    b2 = b + 256;
                }
                this.bitWorkArea = (this.bitWorkArea << 8) + b2;
                if (this.modulus == 0) {
                    byte[] bArr2 = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    bArr2[i4] = this.encodeTable[((int) (this.bitWorkArea >> 35)) & 31];
                    byte[] bArr3 = this.buffer;
                    int i5 = this.pos;
                    this.pos = i5 + 1;
                    bArr3[i5] = this.encodeTable[((int) (this.bitWorkArea >> 30)) & 31];
                    byte[] bArr4 = this.buffer;
                    int i6 = this.pos;
                    this.pos = i6 + 1;
                    bArr4[i6] = this.encodeTable[((int) (this.bitWorkArea >> 25)) & 31];
                    byte[] bArr5 = this.buffer;
                    int i7 = this.pos;
                    this.pos = i7 + 1;
                    bArr5[i7] = this.encodeTable[((int) (this.bitWorkArea >> 20)) & 31];
                    byte[] bArr6 = this.buffer;
                    int i8 = this.pos;
                    this.pos = i8 + 1;
                    bArr6[i8] = this.encodeTable[((int) (this.bitWorkArea >> 15)) & 31];
                    byte[] bArr7 = this.buffer;
                    int i9 = this.pos;
                    this.pos = i9 + 1;
                    bArr7[i9] = this.encodeTable[((int) (this.bitWorkArea >> 10)) & 31];
                    byte[] bArr8 = this.buffer;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    bArr8[i10] = this.encodeTable[((int) (this.bitWorkArea >> 5)) & 31];
                    byte[] bArr9 = this.buffer;
                    int i11 = this.pos;
                    this.pos = i11 + 1;
                    bArr9[i11] = this.encodeTable[((int) this.bitWorkArea) & 31];
                    this.currentLinePos += 8;
                    if (this.lineLength > 0 && this.lineLength <= this.currentLinePos) {
                        System.arraycopy((Object) this.lineSeparator, 0, (Object) this.buffer, this.pos, this.lineSeparator.length);
                        this.pos += this.lineSeparator.length;
                        this.currentLinePos = 0;
                    }
                }
                i3++;
                i++;
            }
            return;
        }
        this.eof = true;
        if (this.modulus == 0 && this.lineLength == 0) {
            return;
        }
        ensureBufferSize(this.encodeSize);
        int i12 = this.pos;
        int i13 = this.modulus;
        if (i13 == 1) {
            byte[] bArr10 = this.buffer;
            int i14 = this.pos;
            this.pos = i14 + 1;
            bArr10[i14] = this.encodeTable[((int) (this.bitWorkArea >> 3)) & 31];
            byte[] bArr11 = this.buffer;
            int i15 = this.pos;
            this.pos = i15 + 1;
            bArr11[i15] = this.encodeTable[((int) (this.bitWorkArea << 2)) & 31];
            byte[] bArr12 = this.buffer;
            int i16 = this.pos;
            this.pos = i16 + 1;
            bArr12[i16] = 61;
            byte[] bArr13 = this.buffer;
            int i17 = this.pos;
            this.pos = i17 + 1;
            bArr13[i17] = 61;
            byte[] bArr14 = this.buffer;
            int i18 = this.pos;
            this.pos = i18 + 1;
            bArr14[i18] = 61;
            byte[] bArr15 = this.buffer;
            int i19 = this.pos;
            this.pos = i19 + 1;
            bArr15[i19] = 61;
            byte[] bArr16 = this.buffer;
            int i20 = this.pos;
            this.pos = i20 + 1;
            bArr16[i20] = 61;
            byte[] bArr17 = this.buffer;
            int i21 = this.pos;
            this.pos = i21 + 1;
            bArr17[i21] = 61;
        } else if (i13 == 2) {
            byte[] bArr18 = this.buffer;
            int i22 = this.pos;
            this.pos = i22 + 1;
            bArr18[i22] = this.encodeTable[((int) (this.bitWorkArea >> 11)) & 31];
            byte[] bArr19 = this.buffer;
            int i23 = this.pos;
            this.pos = i23 + 1;
            bArr19[i23] = this.encodeTable[((int) (this.bitWorkArea >> 6)) & 31];
            byte[] bArr20 = this.buffer;
            int i24 = this.pos;
            this.pos = i24 + 1;
            bArr20[i24] = this.encodeTable[((int) (this.bitWorkArea >> 1)) & 31];
            byte[] bArr21 = this.buffer;
            int i25 = this.pos;
            this.pos = i25 + 1;
            bArr21[i25] = this.encodeTable[((int) (this.bitWorkArea << 4)) & 31];
            byte[] bArr22 = this.buffer;
            int i26 = this.pos;
            this.pos = i26 + 1;
            bArr22[i26] = 61;
            byte[] bArr23 = this.buffer;
            int i27 = this.pos;
            this.pos = i27 + 1;
            bArr23[i27] = 61;
            byte[] bArr24 = this.buffer;
            int i28 = this.pos;
            this.pos = i28 + 1;
            bArr24[i28] = 61;
            byte[] bArr25 = this.buffer;
            int i29 = this.pos;
            this.pos = i29 + 1;
            bArr25[i29] = 61;
        } else if (i13 == 3) {
            byte[] bArr26 = this.buffer;
            int i30 = this.pos;
            this.pos = i30 + 1;
            bArr26[i30] = this.encodeTable[((int) (this.bitWorkArea >> 19)) & 31];
            byte[] bArr27 = this.buffer;
            int i31 = this.pos;
            this.pos = i31 + 1;
            bArr27[i31] = this.encodeTable[((int) (this.bitWorkArea >> 14)) & 31];
            byte[] bArr28 = this.buffer;
            int i32 = this.pos;
            this.pos = i32 + 1;
            bArr28[i32] = this.encodeTable[((int) (this.bitWorkArea >> 9)) & 31];
            byte[] bArr29 = this.buffer;
            int i33 = this.pos;
            this.pos = i33 + 1;
            bArr29[i33] = this.encodeTable[((int) (this.bitWorkArea >> 4)) & 31];
            byte[] bArr30 = this.buffer;
            int i34 = this.pos;
            this.pos = i34 + 1;
            bArr30[i34] = this.encodeTable[((int) (this.bitWorkArea << 1)) & 31];
            byte[] bArr31 = this.buffer;
            int i35 = this.pos;
            this.pos = i35 + 1;
            bArr31[i35] = 61;
            byte[] bArr32 = this.buffer;
            int i36 = this.pos;
            this.pos = i36 + 1;
            bArr32[i36] = 61;
            byte[] bArr33 = this.buffer;
            int i37 = this.pos;
            this.pos = i37 + 1;
            bArr33[i37] = 61;
        } else if (i13 == 4) {
            byte[] bArr34 = this.buffer;
            int i38 = this.pos;
            this.pos = i38 + 1;
            bArr34[i38] = this.encodeTable[((int) (this.bitWorkArea >> 27)) & 31];
            byte[] bArr35 = this.buffer;
            int i39 = this.pos;
            this.pos = i39 + 1;
            bArr35[i39] = this.encodeTable[((int) (this.bitWorkArea >> 22)) & 31];
            byte[] bArr36 = this.buffer;
            int i40 = this.pos;
            this.pos = i40 + 1;
            bArr36[i40] = this.encodeTable[((int) (this.bitWorkArea >> 17)) & 31];
            byte[] bArr37 = this.buffer;
            int i41 = this.pos;
            this.pos = i41 + 1;
            bArr37[i41] = this.encodeTable[((int) (this.bitWorkArea >> 12)) & 31];
            byte[] bArr38 = this.buffer;
            int i42 = this.pos;
            this.pos = i42 + 1;
            bArr38[i42] = this.encodeTable[((int) (this.bitWorkArea >> 7)) & 31];
            byte[] bArr39 = this.buffer;
            int i43 = this.pos;
            this.pos = i43 + 1;
            bArr39[i43] = this.encodeTable[((int) (this.bitWorkArea >> 2)) & 31];
            byte[] bArr40 = this.buffer;
            int i44 = this.pos;
            this.pos = i44 + 1;
            bArr40[i44] = this.encodeTable[((int) (this.bitWorkArea << 3)) & 31];
            byte[] bArr41 = this.buffer;
            int i45 = this.pos;
            this.pos = i45 + 1;
            bArr41[i45] = 61;
        }
        this.currentLinePos += this.pos - i12;
        if (this.lineLength <= 0 || this.currentLinePos <= 0) {
            return;
        }
        System.arraycopy((Object) this.lineSeparator, 0, (Object) this.buffer, this.pos, this.lineSeparator.length);
        this.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            return b < bArr.length && bArr[b] != -1;
        }
        return false;
    }
}
