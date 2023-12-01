package com.sobot.chat.widget.zxing.pdf417.detector;

import com.sobot.chat.widget.zxing.BinaryBitmap;
import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/detector/Detector.class */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return;
            }
            resultPointArr[iArr[i2]] = resultPointArr2[i2];
            i = i2 + 1;
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z, blackMatrix);
        BitMatrix bitMatrix = blackMatrix;
        List<ResultPoint[]> list = detect;
        if (detect.isEmpty()) {
            bitMatrix = blackMatrix.m5820clone();
            bitMatrix.rotate180();
            list = detect(z, bitMatrix);
        }
        return new PDF417DetectorResult(bitMatrix, list);
    }

    private static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        int x;
        float y;
        ArrayList<ResultPoint[]> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = 0;
            boolean z2 = false;
            while (i2 < bitMatrix.getHeight()) {
                ResultPoint[] findVertices = findVertices(bitMatrix, i2, i3);
                if (findVertices[0] != null || findVertices[3] != null) {
                    arrayList.add(findVertices);
                    if (!z) {
                        return arrayList;
                    }
                    if (findVertices[2] != null) {
                        x = (int) findVertices[2].getX();
                        y = findVertices[2].getY();
                    } else {
                        x = (int) findVertices[4].getX();
                        y = findVertices[4].getY();
                    }
                    i3 = x;
                    z2 = true;
                    i2 = (int) y;
                } else if (!z2) {
                    return arrayList;
                } else {
                    for (ResultPoint[] resultPointArr : arrayList) {
                        int i4 = i2;
                        if (resultPointArr[1] != null) {
                            i4 = (int) Math.max(i2, resultPointArr[1].getY());
                        }
                        i2 = i4;
                        if (resultPointArr[3] != null) {
                            i2 = Math.max(i4, (int) resultPointArr[3].getY());
                        }
                    }
                    i = i2 + 5;
                }
            }
            return arrayList;
        }
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (!bitMatrix.get(i, i2) || i <= 0 || i5 >= 3) {
                break;
            }
            i--;
            i4 = i5 + 1;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = i;
        int i8 = 0;
        while (i7 < i3) {
            if (bitMatrix.get(i7, i2) != z) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                if (i8 != length - 1) {
                    i8++;
                } else if (patternMatchVariance(iArr2, iArr, 0.8f) < MAX_AVG_VARIANCE) {
                    return new int[]{i6, i7};
                } else {
                    i6 += iArr2[0] + iArr2[1];
                    int i9 = i8 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z = !z;
            }
            i7++;
        }
        if (i8 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i6, i7 - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        while (true) {
            if (i3 >= i) {
                i5 = i3;
                z = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i4, i3, i2, false, iArr, iArr2);
            if (findGuardPattern != null) {
                while (true) {
                    if (i3 <= 0) {
                        break;
                    }
                    i3--;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i4, i3, i2, false, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i3++;
                        break;
                    }
                    findGuardPattern = findGuardPattern2;
                }
                float f = i3;
                resultPointArr[0] = new ResultPoint(findGuardPattern[0], f);
                resultPointArr[1] = new ResultPoint(findGuardPattern[1], f);
                i5 = i3;
                z = true;
            } else {
                i3 += 5;
            }
        }
        int i7 = i5 + 1;
        int i8 = i7;
        if (z) {
            int[] iArr3 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i9 = 0;
            while (i7 < i) {
                int i10 = i9;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr3[0], i7, i2, false, iArr, iArr2);
                if (findGuardPattern3 != null && Math.abs(iArr3[0] - findGuardPattern3[0]) < 5 && Math.abs(iArr3[1] - findGuardPattern3[1]) < 5) {
                    iArr3 = findGuardPattern3;
                    i6 = 0;
                } else if (i10 > 25) {
                    break;
                } else {
                    i6 = i10 + 1;
                }
                i9 = i6;
                i7++;
            }
            i8 = i7 - (i9 + 1);
            float f2 = i8;
            resultPointArr[2] = new ResultPoint(iArr3[0], f2);
            resultPointArr[3] = new ResultPoint(iArr3[1], f2);
        }
        if (i8 - i5 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i2 = (int) resultPointArr[4].getX();
            i = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = 0.0f;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return f4 / f2;
            }
            float f5 = iArr2[i5] * f3;
            float f6 = iArr[i5];
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f * f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
            i4 = i5 + 1;
        }
    }
}
