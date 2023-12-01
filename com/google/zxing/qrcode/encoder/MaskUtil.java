package com.google.zxing.qrcode.encoder;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/qrcode/encoder/MaskUtil.class */
final class MaskUtil {
    private static final int N1 = 3;
    private static final int N2 = 3;
    private static final int N3 = 40;
    private static final int N4 = 10;

    private MaskUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int i;
        byte b;
        int i2;
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= height) {
                return i5;
            }
            byte b2 = -1;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i = i7;
                if (i6 >= width) {
                    break;
                }
                byte b3 = z ? array[i3][i6] : array[i6][i3];
                if (b3 == b2) {
                    i2 = i + 1;
                    b = b2;
                } else {
                    int i8 = i5;
                    if (i >= 5) {
                        i8 = i5 + (i - 5) + 3;
                    }
                    b = b3;
                    i2 = 1;
                    i5 = i8;
                }
                i6++;
                b2 = b;
                i7 = i2;
            }
            int i9 = i5;
            if (i >= 5) {
                i9 = i5 + (i - 5) + 3;
            }
            i3++;
            i4 = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height - 1; i2++) {
            byte[] bArr = array[i2];
            int i3 = 0;
            while (i3 < width - 1) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                int i5 = i;
                if (b == bArr[i4]) {
                    int i6 = i2 + 1;
                    i5 = i;
                    if (b == array[i6][i3]) {
                        i5 = i;
                        if (b == array[i6][i4]) {
                            i5 = i + 1;
                        }
                    }
                }
                i3 = i4;
                i = i5;
            }
        }
        return i * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
        if (isWhiteHorizontal(r0, r10 + 7, r10 + 11) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int applyMaskPenaltyRule3(com.google.zxing.qrcode.encoder.ByteMatrix r6) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule3(com.google.zxing.qrcode.encoder.ByteMatrix):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            byte[] bArr = array[i2];
            int i3 = 0;
            while (i3 < width) {
                int i4 = i;
                if (bArr[i3] == 1) {
                    i4 = i + 1;
                }
                i3++;
                i = i4;
            }
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i << 1) - height2) * 10) / height2) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean getDataMaskBit(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2;
        int i7 = i3;
        int i8 = i3;
        switch (i) {
            case 0:
                i8 = i7 + i6;
                i4 = i8 & 1;
                break;
            case 1:
                i4 = i8 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i7 = i3 / 2;
                i6 = i2 / 3;
                i8 = i7 + i6;
                i4 = i8 & 1;
                break;
            case 5:
                int i9 = i3 * i2;
                i4 = (i9 & 1) + (i9 % 3);
                break;
            case 6:
                int i10 = i3 * i2;
                i5 = (i10 & 1) + (i10 % 3);
                i4 = i5 & 1;
                break;
            case 7:
                i5 = ((i3 * i2) % 3) + ((i3 + i2) & 1);
                i4 = i5 & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
        }
        return i4 == 0;
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
