package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn.class */
final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        int rowNumber;
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        Codeword[] codewords = getCodewords();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (imageRowToCodewordIndex >= imageRowToCodewordIndex2) {
                return;
            }
            int i5 = i;
            int i6 = i2;
            int i7 = i4;
            if (codewords[imageRowToCodewordIndex] != null) {
                Codeword codeword = codewords[imageRowToCodewordIndex];
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber2 = codeword.getRowNumber() - i;
                if (rowNumber2 == 0) {
                    i6 = i2 + 1;
                    i5 = i;
                    i7 = i4;
                } else {
                    if (rowNumber2 == 1) {
                        i4 = Math.max(i4, i2);
                        rowNumber = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[imageRowToCodewordIndex] = null;
                        i5 = i;
                        i6 = i2;
                        i7 = i4;
                    } else {
                        rowNumber = codeword.getRowNumber();
                    }
                    i5 = rowNumber;
                    i6 = 1;
                    i7 = i4;
                }
            }
            imageRowToCodewordIndex++;
            i = i5;
            i2 = i6;
            i3 = i7;
        }
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= codewordArr.length) {
                return;
            }
            Codeword codeword = codewordArr[i2];
            if (codewordArr[i2] != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i2] = null;
                } else {
                    int i3 = rowNumber;
                    if (!this.isLeft) {
                        i3 = rowNumber + 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                                codewordArr[i2] = null;
                            }
                        } else if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                            codewordArr[i2] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i2] = null;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void setRowNumbers() {
        Codeword[] codewords = getCodewords();
        int length = codewords.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Codeword codeword = codewords[i2];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        int rowNumber;
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (imageRowToCodewordIndex >= imageRowToCodewordIndex2) {
                return;
            }
            int i5 = i;
            int i6 = i2;
            int i7 = i4;
            if (codewords[imageRowToCodewordIndex] != null) {
                Codeword codeword = codewords[imageRowToCodewordIndex];
                int rowNumber2 = codeword.getRowNumber() - i;
                if (rowNumber2 == 0) {
                    i6 = i2 + 1;
                    i5 = i;
                    i7 = i4;
                } else {
                    if (rowNumber2 == 1) {
                        i4 = Math.max(i4, i2);
                        rowNumber = codeword.getRowNumber();
                    } else if (rowNumber2 < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber2 > imageRowToCodewordIndex) {
                        codewords[imageRowToCodewordIndex] = null;
                        i7 = i4;
                        i6 = i2;
                        i5 = i;
                    } else {
                        int i8 = rowNumber2;
                        if (i4 > 2) {
                            i8 = rowNumber2 * (i4 - 2);
                        }
                        boolean z = i8 >= imageRowToCodewordIndex;
                        int i9 = 1;
                        while (true) {
                            int i10 = i9;
                            if (i10 > i8 || z) {
                                break;
                            }
                            z = codewords[imageRowToCodewordIndex - i10] != null;
                            i9 = i10 + 1;
                        }
                        if (z) {
                            codewords[imageRowToCodewordIndex] = null;
                            i5 = i;
                            i6 = i2;
                            i7 = i4;
                        } else {
                            rowNumber = codeword.getRowNumber();
                        }
                    }
                    i5 = rowNumber;
                    i6 = 1;
                    i7 = i4;
                }
            }
            imageRowToCodewordIndex++;
            i = i5;
            i2 = i6;
            i3 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        int length = codewords.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Codeword codeword = codewords[i2];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                int i3 = rowNumber;
                if (!this.isLeft) {
                    i3 = rowNumber + 2;
                }
                int i4 = i3 % 3;
                if (i4 == 0) {
                    barcodeValue2.setValue((value * 3) + 1);
                } else if (i4 == 1) {
                    barcodeValue4.setValue(value / 3);
                    barcodeValue3.setValue(value % 3);
                } else if (i4 == 2) {
                    barcodeValue.setValue(value + 1);
                }
            }
            i = i2 + 1;
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getRowHeights() {
        int rowNumber;
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int rowCount = barcodeMetadata.getRowCount();
        int[] iArr = new int[rowCount];
        Codeword[] codewords = getCodewords();
        int length = codewords.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return iArr;
            }
            Codeword codeword = codewords[i2];
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLeft() {
        return this.isLeft;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
