package com.sobot.chat.widget.zxing.pdf417.decoder;

import com.sobot.chat.widget.zxing.ChecksumException;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import com.sobot.chat.widget.zxing.common.DecoderResult;
import com.sobot.chat.widget.zxing.common.detector.MathUtils;
import com.sobot.chat.widget.zxing.pdf417.PDF417Common;
import com.sobot.chat.widget.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/decoder/PDF417ScanningDecoder.class */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        int i;
        int i2;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int length = rowHeights.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= length) {
                break;
            }
            int i5 = rowHeights[i3];
            i4 += max - i5;
            if (i5 > 0) {
                i = i4;
                break;
            }
            i3++;
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i6 = i;
        for (int i7 = 0; i6 > 0 && codewords[i7] == null; i7++) {
            i6--;
        }
        int length2 = rowHeights.length - 1;
        int i8 = 0;
        while (true) {
            i2 = i8;
            if (length2 < 0) {
                break;
            }
            i8 += max - rowHeights[length2];
            if (rowHeights[length2] > 0) {
                i2 = i8;
                break;
            }
            length2--;
        }
        int length3 = codewords.length;
        while (true) {
            int i9 = length3 - 1;
            if (i2 <= 0 || codewords[i9] != null) {
                break;
            }
            i2--;
            length3 = i9;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i6, i2, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValue.setValue(barcodeColumnCount);
            }
        } else if (barcodeColumnCount < 1 || barcodeColumnCount > 928) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int adjustCodewordStartColumn(com.sobot.chat.widget.zxing.common.BitMatrix r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            r0 = r8
            if (r0 == 0) goto La
            r0 = -1
            r11 = r0
            goto Ld
        La:
            r0 = 1
            r11 = r0
        Ld:
            r0 = 0
            r12 = r0
            r0 = r9
            r13 = r0
        L14:
            r0 = r12
            r1 = 2
            if (r0 >= r1) goto L64
        L1a:
            r0 = r8
            if (r0 == 0) goto L27
            r0 = r13
            r1 = r6
            if (r0 < r1) goto L52
            goto L2d
        L27:
            r0 = r13
            r1 = r7
            if (r0 >= r1) goto L52
        L2d:
            r0 = r8
            r1 = r5
            r2 = r13
            r3 = r10
            boolean r1 = r1.get(r2, r3)
            if (r0 != r1) goto L52
            r0 = r9
            r1 = r13
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            r1 = 2
            if (r0 <= r1) goto L48
            r0 = r9
            return r0
        L48:
            r0 = r13
            r1 = r11
            int r0 = r0 + r1
            r13 = r0
            goto L1a
        L52:
            r0 = r11
            int r0 = -r0
            r11 = r0
            r0 = r8
            r1 = 1
            r0 = r0 ^ r1
            r8 = r0
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r12 = r0
            goto L14
        L64:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.pdf417.decoder.PDF417ScanningDecoder.adjustCodewordStartColumn(com.sobot.chat.widget.zxing.common.BitMatrix, int, int, boolean, int, int):int");
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 - 2 <= i && i <= i3 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        DetectionResultColumn[] detectionResultColumns;
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= barcodeValueArr.length) {
                break;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < barcodeValueArr[i2].length) {
                    barcodeValueArr[i2][i4] = new BarcodeValue();
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        int i5 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                Codeword[] codewords = detectionResultColumn.getCodewords();
                int length = codewords.length;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < length) {
                        Codeword codeword = codewords[i7];
                        if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                            barcodeValueArr[rowNumber][i5].setValue(codeword.getValue());
                        }
                        i6 = i7 + 1;
                    }
                }
            }
            i5++;
        }
        return barcodeValueArr;
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [int[], int[][]] */
    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= detectionResult.getBarcodeRowCount()) {
                break;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < detectionResult.getBarcodeColumnCount()) {
                    BarcodeValue[] barcodeValueArr = createBarcodeMatrix[i2];
                    int i5 = i4 + 1;
                    int[] value = barcodeValueArr[i5].getValue();
                    int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i2) + i4;
                    if (value.length == 0) {
                        arrayList.add(Integer.valueOf(barcodeColumnCount));
                    } else if (value.length == 1) {
                        iArr[barcodeColumnCount] = value[0];
                    } else {
                        arrayList3.add(Integer.valueOf(barcodeColumnCount));
                        arrayList2.add(value);
                    }
                    i3 = i5;
                }
            }
            i = i2 + 1;
        }
        int size = arrayList2.size();
        ?? r0 = new int[size];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= size) {
                return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), r0);
            }
            r0[i7] = (int[]) arrayList2.get(i7);
            i6 = i7 + 1;
        }
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2;
            if (i3 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                    i4 = i5 + 1;
                } else {
                    try {
                        return decodeCodewords(iArr, i, iArr2);
                    } catch (ChecksumException e) {
                        if (length == 0) {
                            throw ChecksumException.getChecksumInstance();
                        }
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 >= length) {
                                break;
                            } else if (iArr5[i7] < iArr4[i7].length - 1) {
                                iArr5[i7] = iArr5[i7] + 1;
                                break;
                            } else {
                                iArr5[i7] = 0;
                                if (i7 == length - 1) {
                                    throw ChecksumException.getChecksumInstance();
                                }
                                i6 = i7 + 1;
                            }
                        }
                        i2 = i3 - 1;
                    }
                }
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        DetectionResult merge;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn;
        int i3;
        int i4;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
        boolean z = true;
        while (true) {
            boolean z2 = z;
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, i2);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, i2);
            }
            merge = merge(detectionResultRowIndicatorColumn2, detectionResultRowIndicatorColumn3);
            if (merge == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            BoundingBox boundingBox2 = merge.getBoundingBox();
            if (!z2 || boundingBox2 == null || (boundingBox2.getMinY() >= boundingBox.getMinY() && boundingBox2.getMaxY() <= boundingBox.getMaxY())) {
                break;
            }
            boundingBox = boundingBox2;
            z = false;
        }
        merge.setBoundingBox(boundingBox);
        int barcodeColumnCount = merge.getBarcodeColumnCount() + 1;
        merge.setDetectionResultColumn(0, detectionResultRowIndicatorColumn2);
        merge.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn3);
        boolean z3 = detectionResultRowIndicatorColumn2 != null;
        int i5 = i2;
        int i6 = 1;
        int i7 = i;
        while (i6 <= barcodeColumnCount) {
            int i8 = z3 ? i6 : barcodeColumnCount - i6;
            if (merge.getDetectionResultColumn(i8) != null) {
                i3 = i7;
                i4 = i5;
            } else {
                if (i8 == 0 || i8 == barcodeColumnCount) {
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, i8 == 0);
                } else {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                }
                merge.setDetectionResultColumn(i8, detectionResultRowIndicatorColumn);
                int minY = boundingBox.getMinY();
                int i9 = -1;
                while (true) {
                    i3 = i7;
                    i4 = i5;
                    if (minY <= boundingBox.getMaxY()) {
                        int startColumn = getStartColumn(merge, i8, minY, z3);
                        if (startColumn < 0 || startColumn > boundingBox.getMaxX()) {
                            if (i9 == -1) {
                                minY++;
                            } else {
                                startColumn = i9;
                            }
                        }
                        Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z3, startColumn, minY, i7, i5);
                        if (detectCodeword != null) {
                            detectionResultRowIndicatorColumn.setCodeword(minY, detectCodeword);
                            i7 = Math.min(i7, detectCodeword.getWidth());
                            i5 = Math.max(i5, detectCodeword.getWidth());
                            i9 = startColumn;
                        }
                        minY++;
                    }
                }
            }
            i6++;
            i7 = i3;
            i5 = i4;
        }
        return createDecoderResult(merge);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int correctErrors = correctErrors(iArr, iArr2, i2);
            verifyCodewordCount(iArr, i2);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int decodedValue;
        int codeword;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, adjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int sum = MathUtils.sum(moduleBitCount);
        if (z) {
            i7 = adjustCodewordStartColumn + sum;
        } else {
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= moduleBitCount.length / 2) {
                    break;
                }
                int i10 = moduleBitCount[i9];
                moduleBitCount[i9] = moduleBitCount[(moduleBitCount.length - 1) - i9];
                moduleBitCount[(moduleBitCount.length - 1) - i9] = i10;
                i8 = i9 + 1;
            }
            i7 = adjustCodewordStartColumn;
            adjustCodewordStartColumn -= sum;
        }
        if (checkCodewordSkew(sum, i5, i6) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new Codeword(adjustCodewordStartColumn, i7, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        if (detectionResultRowIndicatorColumn2 != null) {
            BarcodeMetadata barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
            if (barcodeMetadata2 == null) {
                return barcodeMetadata;
            }
            if (barcodeMetadata.getColumnCount() != barcodeMetadata2.getColumnCount() && barcodeMetadata.getErrorCorrectionLevel() != barcodeMetadata2.getErrorCorrectionLevel() && barcodeMetadata.getRowCount() != barcodeMetadata2.getRowCount()) {
                return null;
            }
        }
        return barcodeMetadata;
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i3;
            int i5 = i & 1;
            int i6 = i2;
            int i7 = i4;
            if (i5 != i2) {
                i7 = i4 - 1;
                if (i7 < 0) {
                    return iArr;
                }
                i6 = i5;
            }
            iArr[i7] = iArr[i7] + 1;
            i >>= 1;
            i2 = i6;
            i3 = i7;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int getMax(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return i;
            }
            i = Math.max(i, iArr[i3]);
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065 A[EDGE_INSN: B:35:0x0065->B:20:0x0065 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] getModuleBitCount(com.sobot.chat.widget.zxing.common.BitMatrix r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            r0 = 8
            int[] r0 = new int[r0]
            r14 = r0
            r0 = r8
            if (r0 == 0) goto L10
            r0 = 1
            r11 = r0
            goto L13
        L10:
            r0 = -1
            r11 = r0
        L13:
            r0 = 0
            r12 = r0
            r0 = r8
            r13 = r0
        L19:
            r0 = r8
            if (r0 == 0) goto L26
            r0 = r9
            r1 = r7
            if (r0 >= r1) goto L65
            goto L2c
        L26:
            r0 = r9
            r1 = r6
            if (r0 < r1) goto L65
        L2c:
            r0 = r12
            r1 = 8
            if (r0 >= r1) goto L65
            r0 = r5
            r1 = r9
            r2 = r10
            boolean r0 = r0.get(r1, r2)
            r1 = r13
            if (r0 != r1) goto L56
            r0 = r14
            r1 = r12
            r2 = r14
            r3 = r12
            r2 = r2[r3]
            r3 = 1
            int r2 = r2 + r3
            r0[r1] = r2
            r0 = r9
            r1 = r11
            int r0 = r0 + r1
            r9 = r0
            goto L19
        L56:
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r12 = r0
            r0 = r13
            r1 = 1
            r0 = r0 ^ r1
            r13 = r0
            goto L19
        L65:
            r0 = r12
            r1 = 8
            if (r0 == r1) goto L84
            r0 = r8
            if (r0 == 0) goto L72
            r0 = r7
            r6 = r0
        L72:
            r0 = r9
            r1 = r6
            if (r0 != r1) goto L82
            r0 = r12
            r1 = 7
            if (r0 != r1) goto L82
            r0 = r14
            return r0
        L82:
            r0 = 0
            return r0
        L84:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.pdf417.decoder.PDF417ScanningDecoder.getModuleBitCount(com.sobot.chat.widget.zxing.common.BitMatrix, int, int, boolean, int, int):int[]");
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 2) {
                return detectionResultRowIndicatorColumn;
            }
            int i5 = i4 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (true) {
                int i6 = y;
                if (i6 <= boundingBox.getMaxY() && i6 >= boundingBox.getMinY()) {
                    Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, i6, i, i2);
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(i6, detectCodeword);
                        x = z ? detectCodeword.getStartX() : detectCodeword.getEndX();
                    }
                    y = i6 + i5;
                }
            }
            i3 = i4 + 1;
        }
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        Codeword codeword = null;
        int i4 = i - i3;
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codeword = detectionResult.getDetectionResultColumn(i4).getCodeword(i2);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i5 = i;
        int i6 = 0;
        while (true) {
            int i7 = i5 - i3;
            if (!isValidBarcodeColumn(detectionResult, i7)) {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
            Codeword[] codewords = detectionResult.getDetectionResultColumn(i7).getCodewords();
            int length = codewords.length;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < length) {
                    Codeword codeword2 = codewords[i9];
                    if (codeword2 != null) {
                        return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i3 * i6 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                    i8 = i9 + 1;
                }
            }
            i6++;
            i5 = i7;
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= barcodeValueArr.length) {
                    String formatter2 = formatter.toString();
                    formatter.close();
                    return formatter2;
                }
                formatter.format("Row %2d: ", Integer.valueOf(i2));
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= barcodeValueArr[i2].length) {
                        break;
                    }
                    BarcodeValue barcodeValue = barcodeValueArr[i2][i4];
                    if (barcodeValue.getValue().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                    }
                    i3 = i4 + 1;
                }
                formatter.format("%n", new Object[0]);
                i = i2 + 1;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
