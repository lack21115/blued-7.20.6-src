package com.sobot.chat.widget.zxing.datamatrix.decoder;

import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.common.BitMatrix;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/decoder/BitMatrixParser.class */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        BitMatrix extractDataRegion = extractDataRegion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion;
        this.readMappingMatrix = new BitMatrix(extractDataRegion.getWidth(), this.mappingBitMatrix.getHeight());
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i = symbolSizeRows / dataRegionSizeRows;
        int i2 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i2 * dataRegionSizeColumns, i * dataRegionSizeRows);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return bitMatrix2;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < i2) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 < dataRegionSizeRows) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                if (i10 < dataRegionSizeColumns) {
                                    if (bitMatrix.get(((dataRegionSizeColumns + 2) * i6) + 1 + i10, ((dataRegionSizeRows + 2) * i4) + 1 + i8)) {
                                        bitMatrix2.set((i6 * dataRegionSizeColumns) + i10, (i4 * dataRegionSizeRows) + i8);
                                    }
                                    i9 = i10 + 1;
                                }
                            }
                            i7 = i8 + 1;
                        }
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    private int readCorner1(int i, int i2) {
        int i3 = i - 1;
        int i4 = (readModule(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i4;
        if (readModule(i3, 1, i, i2)) {
            i5 = i4 | 1;
        }
        int i6 = i5 << 1;
        int i7 = i6;
        if (readModule(i3, 2, i, i2)) {
            i7 = i6 | 1;
        }
        int i8 = i7 << 1;
        int i9 = i8;
        if (readModule(0, i2 - 2, i, i2)) {
            i9 = i8 | 1;
        }
        int i10 = i9 << 1;
        int i11 = i2 - 1;
        int i12 = i10;
        if (readModule(0, i11, i, i2)) {
            i12 = i10 | 1;
        }
        int i13 = i12 << 1;
        int i14 = i13;
        if (readModule(1, i11, i, i2)) {
            i14 = i13 | 1;
        }
        int i15 = i14 << 1;
        int i16 = i15;
        if (readModule(2, i11, i, i2)) {
            i16 = i15 | 1;
        }
        int i17 = i16 << 1;
        int i18 = i17;
        if (readModule(3, i11, i, i2)) {
            i18 = i17 | 1;
        }
        return i18;
    }

    private int readCorner2(int i, int i2) {
        int i3 = (readModule(i - 3, 0, i, i2) ? 1 : 0) << 1;
        int i4 = i3;
        if (readModule(i - 2, 0, i, i2)) {
            i4 = i3 | 1;
        }
        int i5 = i4 << 1;
        int i6 = i5;
        if (readModule(i - 1, 0, i, i2)) {
            i6 = i5 | 1;
        }
        int i7 = i6 << 1;
        int i8 = i7;
        if (readModule(0, i2 - 4, i, i2)) {
            i8 = i7 | 1;
        }
        int i9 = i8 << 1;
        int i10 = i9;
        if (readModule(0, i2 - 3, i, i2)) {
            i10 = i9 | 1;
        }
        int i11 = i10 << 1;
        int i12 = i11;
        if (readModule(0, i2 - 2, i, i2)) {
            i12 = i11 | 1;
        }
        int i13 = i12 << 1;
        int i14 = i2 - 1;
        int i15 = i13;
        if (readModule(0, i14, i, i2)) {
            i15 = i13 | 1;
        }
        int i16 = i15 << 1;
        int i17 = i16;
        if (readModule(1, i14, i, i2)) {
            i17 = i16 | 1;
        }
        return i17;
    }

    private int readCorner3(int i, int i2) {
        int i3 = i - 1;
        int i4 = (readModule(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        int i6 = i4;
        if (readModule(i3, i5, i, i2)) {
            i6 = i4 | 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 3;
        int i9 = i7;
        if (readModule(0, i8, i, i2)) {
            i9 = i7 | 1;
        }
        int i10 = i9 << 1;
        int i11 = i2 - 2;
        int i12 = i10;
        if (readModule(0, i11, i, i2)) {
            i12 = i10 | 1;
        }
        int i13 = i12 << 1;
        int i14 = i13;
        if (readModule(0, i5, i, i2)) {
            i14 = i13 | 1;
        }
        int i15 = i14 << 1;
        int i16 = i15;
        if (readModule(1, i8, i, i2)) {
            i16 = i15 | 1;
        }
        int i17 = i16 << 1;
        int i18 = i17;
        if (readModule(1, i11, i, i2)) {
            i18 = i17 | 1;
        }
        int i19 = i18 << 1;
        int i20 = i19;
        if (readModule(1, i5, i, i2)) {
            i20 = i19 | 1;
        }
        return i20;
    }

    private int readCorner4(int i, int i2) {
        int i3 = (readModule(i - 3, 0, i, i2) ? 1 : 0) << 1;
        int i4 = i3;
        if (readModule(i - 2, 0, i, i2)) {
            i4 = i3 | 1;
        }
        int i5 = i4 << 1;
        int i6 = i5;
        if (readModule(i - 1, 0, i, i2)) {
            i6 = i5 | 1;
        }
        int i7 = i6 << 1;
        int i8 = i7;
        if (readModule(0, i2 - 2, i, i2)) {
            i8 = i7 | 1;
        }
        int i9 = i8 << 1;
        int i10 = i2 - 1;
        int i11 = i9;
        if (readModule(0, i10, i, i2)) {
            i11 = i9 | 1;
        }
        int i12 = i11 << 1;
        int i13 = i12;
        if (readModule(1, i10, i, i2)) {
            i13 = i12 | 1;
        }
        int i14 = i13 << 1;
        int i15 = i14;
        if (readModule(2, i10, i, i2)) {
            i15 = i14 | 1;
        }
        int i16 = i15 << 1;
        int i17 = i16;
        if (readModule(3, i10, i, i2)) {
            i17 = i16 | 1;
        }
        return i17;
    }

    private boolean readModule(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        if (i < 0) {
            i5 = i + i3;
            i6 = i2 + (4 - ((i3 + 4) & 7));
        }
        int i7 = i5;
        int i8 = i6;
        if (i6 < 0) {
            i8 = i6 + i4;
            i7 = i5 + (4 - ((i4 + 4) & 7));
        }
        this.readMappingMatrix.set(i8, i7);
        return this.mappingBitMatrix.get(i8, i7);
    }

    private int readUtah(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (readModule(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        int i9 = i7;
        if (readModule(i5, i8, i3, i4)) {
            i9 = i7 | 1;
        }
        int i10 = i9 << 1;
        int i11 = i - 1;
        int i12 = i10;
        if (readModule(i11, i6, i3, i4)) {
            i12 = i10 | 1;
        }
        int i13 = i12 << 1;
        int i14 = i13;
        if (readModule(i11, i8, i3, i4)) {
            i14 = i13 | 1;
        }
        int i15 = i14 << 1;
        int i16 = i15;
        if (readModule(i11, i2, i3, i4)) {
            i16 = i15 | 1;
        }
        int i17 = i16 << 1;
        int i18 = i17;
        if (readModule(i, i6, i3, i4)) {
            i18 = i17 | 1;
        }
        int i19 = i18 << 1;
        int i20 = i19;
        if (readModule(i, i8, i3, i4)) {
            i20 = i19 | 1;
        }
        int i21 = i20 << 1;
        int i22 = i21;
        if (readModule(i, i2, i3, i4)) {
            i22 = i21 | 1;
        }
        return i22;
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version getVersion() {
        return this.version;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() throws FormatException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i9 = 0;
        boolean z5 = false;
        int i10 = 0;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i11 = 4;
        while (true) {
            if (i11 == height && i9 == 0 && !z5) {
                bArr[i10] = (byte) readCorner1(height, width);
                i7 = i11 - 2;
                i8 = i9 + 2;
                i4 = i10 + 1;
                z4 = true;
                z3 = z6;
                z2 = z7;
                z = z8;
            } else {
                int i12 = height - 2;
                if (i11 == i12 && i9 == 0 && (width & 3) != 0 && !z6) {
                    bArr[i10] = (byte) readCorner2(height, width);
                    i7 = i11 - 2;
                    i8 = i9 + 2;
                    i4 = i10 + 1;
                    z3 = true;
                    z4 = z5;
                    z2 = z7;
                    z = z8;
                } else if (i11 == height + 4 && i9 == 2 && (width & 7) == 0 && !z7) {
                    bArr[i10] = (byte) readCorner3(height, width);
                    i7 = i11 - 2;
                    i8 = i9 + 2;
                    i4 = i10 + 1;
                    z2 = true;
                    z4 = z5;
                    z3 = z6;
                    z = z8;
                } else {
                    int i13 = i9;
                    int i14 = i10;
                    int i15 = i11;
                    if (i11 == i12) {
                        i13 = i9;
                        i14 = i10;
                        i15 = i11;
                        if (i9 == 0) {
                            i13 = i9;
                            i14 = i10;
                            i15 = i11;
                            if ((width & 7) == 4) {
                                i13 = i9;
                                i14 = i10;
                                i15 = i11;
                                if (!z8) {
                                    bArr[i10] = (byte) readCorner4(height, width);
                                    i7 = i11 - 2;
                                    i8 = i9 + 2;
                                    i4 = i10 + 1;
                                    z = true;
                                    z4 = z5;
                                    z3 = z6;
                                    z2 = z7;
                                }
                            }
                        }
                    }
                    do {
                        i = i14;
                        if (i15 < height) {
                            i = i14;
                            if (i13 >= 0) {
                                i = i14;
                                if (!this.readMappingMatrix.get(i13, i15)) {
                                    bArr[i14] = (byte) readUtah(i15, i13, height, width);
                                    i = i14 + 1;
                                }
                            }
                        }
                        i2 = i15 - 2;
                        i3 = i13 + 2;
                        if (i2 < 0) {
                            break;
                        }
                        i13 = i3;
                        i14 = i;
                        i15 = i2;
                    } while (i3 < width);
                    int i16 = i2 + 1;
                    int i17 = i;
                    int i18 = i3 + 3;
                    do {
                        i4 = i17;
                        if (i16 >= 0) {
                            i4 = i17;
                            if (i18 < width) {
                                i4 = i17;
                                if (!this.readMappingMatrix.get(i18, i16)) {
                                    bArr[i17] = (byte) readUtah(i16, i18, height, width);
                                    i4 = i17 + 1;
                                }
                            }
                        }
                        i5 = i16 + 2;
                        i6 = i18 - 2;
                        if (i5 >= height) {
                            break;
                        }
                        i18 = i6;
                        i17 = i4;
                        i16 = i5;
                    } while (i6 >= 0);
                    i7 = i5 + 3;
                    i8 = i6 + 1;
                    z = z8;
                    z2 = z7;
                    z3 = z6;
                    z4 = z5;
                }
            }
            i9 = i8;
            z5 = z4;
            i10 = i4;
            z6 = z3;
            z7 = z2;
            z8 = z;
            i11 = i7;
            if (i7 >= height) {
                i9 = i8;
                z5 = z4;
                i10 = i4;
                z6 = z3;
                z7 = z2;
                z8 = z;
                i11 = i7;
                if (i8 >= width) {
                    break;
                }
            }
        }
        if (i4 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
