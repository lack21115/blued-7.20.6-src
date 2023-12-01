package com.sobot.chat.widget.zxing.qrcode.detector;

import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.ResultPointCallback;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/detector/FinderPatternFinder.class */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private static final EstimatedModuleComparator moduleComparator = new EstimatedModuleComparator();
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/detector/FinderPatternFinder$EstimatedModuleComparator.class */
    public static final class EstimatedModuleComparator implements Serializable, Comparator<FinderPattern> {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean crossCheckDiagonal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i7 = 0;
        while (true) {
            i3 = i7;
            if (i < i3 || i2 < i3 || !this.image.get(i2 - i3, i - i3)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7 = i3 + 1;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (i >= i3 && i2 >= i3 && !this.image.get(i2 - i3, i - i3)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i3++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (i >= i3 && i2 >= i3 && this.image.get(i2 - i3, i - i3)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i3++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i8 = 1;
        while (true) {
            int i9 = i8;
            int i10 = i + i9;
            i4 = i9;
            if (i10 >= height) {
                break;
            }
            int i11 = i2 + i9;
            i4 = i9;
            if (i11 >= width) {
                break;
            }
            i4 = i9;
            if (!this.image.get(i11, i10)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i8 = i9 + 1;
        }
        while (true) {
            int i12 = i + i4;
            if (i12 >= height || (i6 = i2 + i4) >= width || this.image.get(i6, i12)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i4++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i13 = i + i4;
            if (i13 >= height || (i5 = i2 + i4) >= width || !this.image.get(i5, i13)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i4++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = i;
        while (true) {
            i5 = i6;
            if (i5 < 0 || !bitMatrix.get(i5, i2)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6 = i5 - 1;
        }
        int i7 = i5;
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i7 >= 0 && !bitMatrix.get(i7, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i7--;
        }
        float f = Float.NaN;
        if (i7 >= 0) {
            if (crossCheckStateCount[1] > i3) {
                return Float.NaN;
            }
            while (i7 >= 0 && bitMatrix.get(i7, i2) && crossCheckStateCount[0] <= i3) {
                crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                i7--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            while (true) {
                i++;
                if (i >= width || !bitMatrix.get(i, i2)) {
                    break;
                }
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            }
            int i8 = i;
            if (i == width) {
                return Float.NaN;
            }
            while (i8 < width && !bitMatrix.get(i8, i2) && crossCheckStateCount[3] < i3) {
                crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                i8++;
            }
            f = Float.NaN;
            if (i8 != width) {
                if (crossCheckStateCount[3] >= i3) {
                    return Float.NaN;
                }
                while (i8 < width && bitMatrix.get(i8, i2) && crossCheckStateCount[4] < i3) {
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i8++;
                }
                if (crossCheckStateCount[4] >= i3 || Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 >= i4) {
                    return Float.NaN;
                }
                f = Float.NaN;
                if (foundPatternCross(crossCheckStateCount)) {
                    f = centerFromEnd(crossCheckStateCount, i8);
                }
            }
        }
        return f;
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        int i5;
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = i;
        while (true) {
            i5 = i6;
            if (i5 < 0 || !bitMatrix.get(i2, i5)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6 = i5 - 1;
        }
        int i7 = i5;
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i7 >= 0 && !bitMatrix.get(i2, i7) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i7--;
        }
        float f = Float.NaN;
        if (i7 >= 0) {
            if (crossCheckStateCount[1] > i3) {
                return Float.NaN;
            }
            while (i7 >= 0 && bitMatrix.get(i2, i7) && crossCheckStateCount[0] <= i3) {
                crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                i7--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            while (true) {
                i++;
                if (i >= height || !bitMatrix.get(i2, i)) {
                    break;
                }
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            }
            int i8 = i;
            if (i == height) {
                return Float.NaN;
            }
            while (i8 < height && !bitMatrix.get(i2, i8) && crossCheckStateCount[3] < i3) {
                crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                i8++;
            }
            f = Float.NaN;
            if (i8 != height) {
                if (crossCheckStateCount[3] >= i3) {
                    return Float.NaN;
                }
                while (i8 < height && bitMatrix.get(i2, i8) && crossCheckStateCount[4] < i3) {
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i8++;
                }
                if (crossCheckStateCount[4] >= i3 || Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 >= i4 * 2) {
                    return Float.NaN;
                }
                f = Float.NaN;
                if (foundPatternCross(crossCheckStateCount)) {
                    f = centerFromEnd(crossCheckStateCount, i8);
                }
            }
        }
        return f;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        boolean z = false;
        if (Math.abs(f - iArr[0]) < f2) {
            z = false;
            if (Math.abs(f - iArr[1]) < f2) {
                z = false;
                if (Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2) {
                    z = false;
                    if (Math.abs(f - iArr[3]) < f2) {
                        z = false;
                        if (Math.abs(f - iArr[4]) < f2) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    protected static boolean foundPatternDiagonal(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        boolean z = false;
        if (Math.abs(f - iArr[0]) < f2) {
            z = false;
            if (Math.abs(f - iArr[1]) < f2) {
                z = false;
                if (Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2) {
                    z = false;
                    if (Math.abs(f - iArr[3]) < f2) {
                        z = false;
                        if (Math.abs(f - iArr[4]) < f2) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                f2 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / size;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            f += Math.abs(finderPattern2.getEstimatedModuleSize() - f3);
        }
        return f <= f2 * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        if (this.possibleCenters.size() >= 3) {
            this.possibleCenters.sort(moduleComparator);
            double[] dArr = new double[3];
            FinderPattern[] finderPatternArr = new FinderPattern[3];
            int i = 0;
            double d = Double.MAX_VALUE;
            while (i < this.possibleCenters.size() - 2) {
                FinderPattern finderPattern = this.possibleCenters.get(i);
                float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                int i2 = i + 1;
                int i3 = i2;
                double d2 = d;
                while (true) {
                    i = i2;
                    d = d2;
                    if (i3 < this.possibleCenters.size() - 1) {
                        FinderPattern finderPattern2 = this.possibleCenters.get(i3);
                        double squaredDistance = squaredDistance(finderPattern, finderPattern2);
                        int i4 = i3 + 1;
                        int i5 = i4;
                        while (true) {
                            int i6 = i5;
                            double d3 = d2;
                            d2 = d3;
                            i3 = i4;
                            if (i6 < this.possibleCenters.size()) {
                                FinderPattern finderPattern3 = this.possibleCenters.get(i6);
                                if (finderPattern3.getEstimatedModuleSize() > 1.4f * estimatedModuleSize) {
                                    d2 = d3;
                                } else {
                                    dArr[0] = squaredDistance;
                                    dArr[1] = squaredDistance(finderPattern2, finderPattern3);
                                    dArr[2] = squaredDistance(finderPattern, finderPattern3);
                                    Arrays.sort(dArr);
                                    double abs = Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d));
                                    d2 = d3;
                                    if (abs < d3) {
                                        finderPatternArr[0] = finderPattern;
                                        finderPatternArr[1] = finderPattern2;
                                        finderPatternArr[2] = finderPattern3;
                                        d2 = abs;
                                    }
                                }
                                i5 = i6 + 1;
                            }
                        }
                    }
                }
            }
            if (d != Double.MAX_VALUE) {
                return finderPatternArr;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static double squaredDistance(FinderPattern finderPattern, FinderPattern finderPattern2) {
        double x = finderPattern.getX() - finderPattern2.getX();
        double y = finderPattern.getY() - finderPattern2.getY();
        return (x * x) + (y * y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void clearCounts(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        boolean z;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i2 = (height * 3) / 388;
        if (i2 < 3 || z2) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean z3 = false;
        while (true) {
            boolean z4 = z3;
            if (i3 >= height || z4) {
                break;
            }
            clearCounts(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < width) {
                if (this.image.get(i4, i3)) {
                    int i6 = i5;
                    if ((i5 & 1) == 1) {
                        i6 = i5 + 1;
                    }
                    iArr[i6] = iArr[i6] + 1;
                    i5 = i6;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 == 4) {
                    if (!foundPatternCross(iArr)) {
                        shiftCounts2(iArr);
                    } else if (handlePossibleCenter(iArr, i3, i4)) {
                        if (this.hasSkipped) {
                            z = haveMultiplyConfirmedCenters();
                            i = i3;
                        } else {
                            int findRowSkip = findRowSkip();
                            i = i3;
                            z = z4;
                            if (findRowSkip > iArr[2]) {
                                i = i3 + ((findRowSkip - iArr[2]) - 2);
                                i4 = width - 1;
                                z = z4;
                            }
                        }
                        clearCounts(iArr);
                        i2 = 2;
                        i3 = i;
                        z4 = z;
                        i5 = 0;
                    } else {
                        shiftCounts2(iArr);
                    }
                    i5 = 3;
                } else {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                }
                i4++;
            }
            int i7 = i2;
            boolean z5 = z4;
            if (foundPatternCross(iArr)) {
                i7 = i2;
                z5 = z4;
                if (handlePossibleCenter(iArr, i3, width)) {
                    int i8 = iArr[0];
                    i7 = i8;
                    z5 = z4;
                    if (this.hasSkipped) {
                        z5 = haveMultiplyConfirmedCenters();
                        i7 = i8;
                    }
                }
            }
            i3 += i7;
            i2 = i7;
            z3 = z5;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        boolean z;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, centerFromEnd, iArr[2], i3);
        if (Float.isNaN(crossCheckVertical)) {
            return false;
        }
        int i4 = (int) crossCheckVertical;
        float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i4, iArr[2], i3);
        if (Float.isNaN(crossCheckHorizontal) || !crossCheckDiagonal(i4, (int) crossCheckHorizontal)) {
            return false;
        }
        float f = i3 / 7.0f;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            z = false;
            if (i6 >= this.possibleCenters.size()) {
                break;
            }
            FinderPattern finderPattern = this.possibleCenters.get(i6);
            if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                this.possibleCenters.set(i6, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                z = true;
                break;
            }
            i5 = i6 + 1;
        }
        if (z) {
            return true;
        }
        FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
        this.possibleCenters.add(finderPattern2);
        ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(finderPattern2);
            return true;
        }
        return true;
    }

    @Deprecated
    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        return handlePossibleCenter(iArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
