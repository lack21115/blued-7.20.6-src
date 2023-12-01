package com.sobot.chat.widget.zxing.qrcode.encoder;

import com.sobot.chat.widget.zxing.WriterException;
import com.sobot.chat.widget.zxing.common.BitArray;
import com.sobot.chat.widget.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sobot.chat.widget.zxing.qrcode.decoder.Version;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/encoder/MatrixUtil.class */
final class MatrixUtil {
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i, byteMatrix);
    }

    static int calculateBCHCode(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int findMSBSet = findMSBSet(i2);
        int i3 = i << (findMSBSet - 1);
        while (true) {
            int i4 = i3;
            if (findMSBSet(i4) < findMSBSet) {
                return i4;
            }
            i3 = i4 ^ (i2 << (findMSBSet(i4) - findMSBSet));
        }
    }

    static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    static void embedDataBits(BitArray bitArray, int i, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i2 = 0;
        int i3 = -1;
        while (width > 0) {
            int i4 = width;
            int i5 = height;
            int i6 = i2;
            if (width == 6) {
                i4 = width - 1;
                i6 = i2;
                i5 = height;
            }
            while (i5 >= 0 && i5 < byteMatrix.getHeight()) {
                int i7 = i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i4 - i8;
                    if (isEmpty(byteMatrix.get(i9, i5))) {
                        if (i7 < bitArray.getSize()) {
                            z = bitArray.get(i7);
                            i7++;
                        } else {
                            z = false;
                        }
                        boolean z2 = z;
                        if (i != -1) {
                            z2 = z;
                            if (MaskUtil.getDataMaskBit(i, i9, i5)) {
                                z2 = !z;
                            }
                        }
                        byteMatrix.set(i9, i5, z2);
                    }
                }
                i5 += i3;
                i6 = i7;
            }
            i3 = -i3;
            height = i5 + i3;
            width = i4 - 2;
            i2 = i6;
        }
        if (i2 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + '/' + bitArray.getSize());
    }

    private static void embedHorizontalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 8) {
                return;
            }
            int i5 = i + i4;
            if (!isEmpty(byteMatrix.get(i5, i2))) {
                throw new WriterException();
            }
            byteMatrix.set(i5, i2, 0);
            i3 = i4 + 1;
        }
    }

    private static void embedPositionAdjustmentPattern(int i, int i2, ByteMatrix byteMatrix) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                return;
            }
            int[] iArr = POSITION_ADJUSTMENT_PATTERN[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < 5) {
                    byteMatrix.set(i + i6, i2 + i4, iArr[i6]);
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    private static void embedPositionDetectionPattern(int i, int i2, ByteMatrix byteMatrix) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 7) {
                return;
            }
            int[] iArr = POSITION_DETECTION_PATTERN[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < 7) {
                    byteMatrix.set(i + i6, i2 + i4, iArr[i6]);
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) {
        int i = 8;
        while (true) {
            int i2 = i;
            if (i2 >= byteMatrix.getWidth() - 8) {
                return;
            }
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (isEmpty(byteMatrix.get(i2, 6))) {
                byteMatrix.set(i2, 6, i4);
            }
            if (isEmpty(byteMatrix.get(6, i2))) {
                byteMatrix.set(6, i2, i4);
            }
            i = i3;
        }
    }

    static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i, bitArray);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bitArray.getSize()) {
                return;
            }
            boolean z = bitArray.get((bitArray.getSize() - 1) - i3);
            int[] iArr = TYPE_INFO_COORDINATES[i3];
            byteMatrix.set(iArr[0], iArr[1], z);
            if (i3 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i3) - 1, 8, z);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i3 - 8), z);
            }
            i2 = i3 + 1;
        }
    }

    private static void embedVerticalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 7) {
                return;
            }
            int i5 = i2 + i4;
            if (!isEmpty(byteMatrix.get(i, i5))) {
                throw new WriterException();
            }
            byteMatrix.set(i, i5, 0);
            i3 = i4 + 1;
        }
    }

    static int findMSBSet(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    private static boolean isEmpty(int i) {
        return i == -1;
    }

    static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i, BitArray bitArray) throws WriterException {
        if (!QRCode.isValidMaskPattern(i)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    static void makeVersionInfoBits(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            int i3 = iArr[i2];
            if (i3 >= 0) {
                int length2 = iArr.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < length2) {
                        int i6 = iArr[i5];
                        if (i6 >= 0 && isEmpty(byteMatrix.get(i6, i3))) {
                            embedPositionAdjustmentPattern(i6 - 2, i3 - 2, byteMatrix);
                        }
                        i4 = i5 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 6) {
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < 3) {
                    boolean z = bitArray.get(i);
                    i--;
                    byteMatrix.set(i3, (byteMatrix.getHeight() - 11) + i5, z);
                    byteMatrix.set((byteMatrix.getHeight() - 11) + i5, i3, z);
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }
}
