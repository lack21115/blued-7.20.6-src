package com.tencent.cos.xml.s3;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/s3/Base64Codec.class */
public class Base64Codec implements Codec {
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private static final int OFFSET_OF_0 = -4;
    private static final int OFFSET_OF_PLUS = -19;
    private static final int OFFSET_OF_SLASH = -16;
    private static final int OFFSET_OF_a = 71;
    private static final byte PAD = 61;
    private final byte[] alphabets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/s3/Base64Codec$LazyHolder.class */
    public static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[123];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 122) {
                    return bArr;
                }
                if (i2 >= 65 && i2 <= 90) {
                    bArr[i2] = (byte) (i2 - 65);
                } else if (i2 >= 48 && i2 <= 57) {
                    bArr[i2] = (byte) (i2 + 4);
                } else if (i2 == 43) {
                    bArr[i2] = (byte) (i2 + 19);
                } else if (i2 == 47) {
                    bArr[i2] = (byte) (i2 + 16);
                } else if (i2 < 97 || i2 > 122) {
                    bArr[i2] = -1;
                } else {
                    bArr[i2] = (byte) (i2 - 71);
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Base64Codec() {
        this.alphabets = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    }

    protected Base64Codec(byte[] bArr) {
        this.alphabets = bArr;
    }

    @Override // com.tencent.cos.xml.s3.Codec
    public byte[] decode(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        if (i % 4 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 4 bytes but found: " + i);
        }
        int i5 = i - 1;
        int i6 = 0;
        while (true) {
            i2 = i6;
            if (i2 >= 2 || i5 <= -1 || bArr[i5] != 61) {
                break;
            }
            i5--;
            i6 = i2 + 1;
        }
        if (i2 != 0) {
            i3 = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new Error("Impossible");
                }
                i3 = 1;
            }
        } else {
            i3 = 3;
        }
        int i7 = ((i / 4) * 3) - (3 - i3);
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i4 = i9;
            if (i4 >= i7 - (i3 % 3)) {
                break;
            }
            decode4bytes(bArr, i8, bArr2, i4);
            i8 += 4;
            i9 = i4 + 3;
        }
        if (i3 < 3) {
            decode1to3bytes(i3, bArr, i8, bArr2, i4);
        }
        return bArr2;
    }

    void decode1to3bytes(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i3 + 1;
        int i5 = i2 + 1;
        int pos = pos(bArr[i2]);
        int i6 = i5 + 1;
        int pos2 = pos(bArr[i5]);
        bArr2[i3] = (byte) ((pos << 2) | ((pos2 >>> 4) & 3));
        if (i == 1) {
            CodecUtils.sanityCheckLastPos(pos2, 15);
            return;
        }
        int pos3 = pos(bArr[i6]);
        bArr2[i4] = (byte) ((15 & (pos3 >>> 2)) | ((pos2 & 15) << 4));
        if (i == 2) {
            CodecUtils.sanityCheckLastPos(pos3, 3);
        } else {
            bArr2[i4 + 1] = (byte) (((pos3 & 3) << 6) | pos(bArr[i6 + 1]));
        }
    }

    void decode4bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        int i4 = i + 1;
        int pos = pos(bArr[i]);
        int i5 = i4 + 1;
        int pos2 = pos(bArr[i4]);
        bArr2[i2] = (byte) ((pos << 2) | ((pos2 >>> 4) & 3));
        int pos3 = pos(bArr[i5]);
        bArr2[i3] = (byte) (((pos2 & 15) << 4) | ((pos3 >>> 2) & 15));
        bArr2[i3 + 1] = (byte) (pos(bArr[i5 + 1]) | ((pos3 & 3) << 6));
    }

    @Override // com.tencent.cos.xml.s3.Codec
    public byte[] encode(byte[] bArr) {
        int i;
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i2 = 0;
        if (length2 != 0) {
            byte[] bArr2 = new byte[(length + 1) * 4];
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= bArr.length - length2) {
                    break;
                }
                encode3bytes(bArr, i2, bArr2, i);
                i2 += 3;
                i3 = i + 4;
            }
            if (length2 == 1) {
                encode1byte(bArr, i2, bArr2, i);
                return bArr2;
            } else if (length2 == 2) {
                encode2bytes(bArr, i2, bArr2, i);
                return bArr2;
            } else {
                throw new IllegalStateException();
            }
        }
        byte[] bArr3 = new byte[length * 4];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i4 >= bArr.length) {
                return bArr3;
            }
            encode3bytes(bArr, i4, bArr3, i6);
            i4 += 3;
            i5 = i6 + 4;
        }
    }

    void encode1byte(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.alphabets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i4 = i3 + 1;
        bArr2[i3] = bArr3[(b & 3) << 4];
        bArr2[i4] = 61;
        bArr2[i4 + 1] = 61;
    }

    void encode2bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.alphabets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i4 = i3 + 1;
        byte b2 = bArr[i + 1];
        bArr2[i3] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        bArr2[i4] = bArr3[(b2 & 15) << 2];
        bArr2[i4 + 1] = 61;
    }

    void encode3bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.alphabets;
        int i4 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i5 = i3 + 1;
        byte b2 = bArr[i4];
        bArr2[i3] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        byte b3 = bArr[i4 + 1];
        bArr2[i5] = bArr3[((b2 & 15) << 2) | ((b3 >>> 6) & 3)];
        bArr2[i5 + 1] = bArr3[b3 & 63];
    }

    protected int pos(byte b) {
        byte b2 = LazyHolder.DECODED[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 64 character: '" + ((char) b) + "'");
    }
}
