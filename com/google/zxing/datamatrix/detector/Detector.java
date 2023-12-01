package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/datamatrix/detector/Detector.class */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/google/zxing/datamatrix/detector/Detector$ResultPointsAndTransitions.class */
    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }

        ResultPoint getFrom() {
            return this.from;
        }

        ResultPoint getTo() {
            return this.to;
        }

        int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/google/zxing/datamatrix/detector/Detector$ResultPointsAndTransitionsComparator.class */
    static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f = i;
        float distance = distance(resultPoint, resultPoint2) / f;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / f;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (!isValid(resultPoint5)) {
            if (isValid(resultPoint6)) {
                return resultPoint6;
            }
            return null;
        }
        if (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
            return resultPoint6;
        }
        return resultPoint5;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        float distance = distance(resultPoint, resultPoint2) / i;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / i2;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (!isValid(resultPoint5)) {
            if (isValid(resultPoint6)) {
                return resultPoint6;
            }
            return null;
        }
        if (isValid(resultPoint6) && Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
            return resultPoint6;
        }
        return resultPoint5;
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(resultPoint, Integer.valueOf(i));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int i;
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i2 = 1;
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        int i3 = x;
        int i4 = y;
        int i5 = x2;
        int i6 = y2;
        if (z) {
            i4 = x;
            i3 = y;
            i6 = x2;
            i5 = y2;
        }
        int abs = Math.abs(i5 - i3);
        int abs2 = Math.abs(i6 - i4);
        int i7 = (-abs) / 2;
        int i8 = i4 < i6 ? 1 : -1;
        if (i3 >= i5) {
            i2 = -1;
        }
        boolean z2 = this.image.get(z ? i4 : i3, z ? i3 : i4);
        int i9 = 0;
        while (true) {
            i = i9;
            if (i3 == i5) {
                break;
            }
            boolean z3 = this.image.get(z ? i4 : i3, z ? i3 : i4);
            int i10 = i9;
            boolean z4 = z2;
            if (z3 != z2) {
                i10 = i9 + 1;
                z4 = z3;
            }
            int i11 = i7 + abs2;
            int i12 = i4;
            i7 = i11;
            if (i11 > 0) {
                i = i10;
                if (i4 == i6) {
                    break;
                }
                i12 = i4 + i8;
                i7 = i11 - abs;
            }
            i3 += i2;
            i4 = i12;
            i9 = i10;
            z2 = z4;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i);
    }

    public DetectorResult detect() throws NotFoundException {
        BitMatrix sampleGrid;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint = detect[0];
        ResultPoint resultPoint2 = detect[1];
        ResultPoint resultPoint3 = detect[2];
        ResultPoint resultPoint4 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint, resultPoint2));
        arrayList.add(transitionsBetween(resultPoint, resultPoint3));
        arrayList.add(transitionsBetween(resultPoint2, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        ResultPoint resultPoint5 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint6 = null;
        ResultPoint resultPoint7 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ResultPoint resultPoint8 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint6 = resultPoint8;
            } else if (resultPoint5 == null) {
                resultPoint5 = resultPoint8;
            } else {
                resultPoint7 = resultPoint8;
            }
        }
        if (resultPoint5 == null || resultPoint6 == null || resultPoint7 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {resultPoint5, resultPoint6, resultPoint7};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint9 = resultPointArr[0];
        ResultPoint resultPoint10 = resultPointArr[1];
        ResultPoint resultPoint11 = resultPointArr[2];
        ResultPoint resultPoint12 = !hashMap.containsKey(resultPoint) ? resultPoint : !hashMap.containsKey(resultPoint2) ? resultPoint2 : !hashMap.containsKey(resultPoint3) ? resultPoint3 : resultPoint4;
        int transitions = transitionsBetween(resultPoint11, resultPoint12).getTransitions();
        int transitions2 = transitionsBetween(resultPoint9, resultPoint12).getTransitions();
        int i = transitions;
        if ((transitions & 1) == 1) {
            i = transitions + 1;
        }
        int i2 = i + 2;
        int i3 = transitions2;
        if ((transitions2 & 1) == 1) {
            i3 = transitions2 + 1;
        }
        int i4 = i3 + 2;
        if (i2 * 4 >= i4 * 7 || i4 * 4 >= i2 * 7) {
            ResultPoint correctTopRightRectangular = correctTopRightRectangular(resultPoint10, resultPoint9, resultPoint11, resultPoint12, i2, i4);
            if (correctTopRightRectangular != null) {
                resultPoint12 = correctTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint11, resultPoint12).getTransitions();
            int transitions4 = transitionsBetween(resultPoint9, resultPoint12).getTransitions();
            int i5 = transitions3;
            if ((transitions3 & 1) == 1) {
                i5 = transitions3 + 1;
            }
            int i6 = transitions4;
            if ((transitions4 & 1) == 1) {
                i6 = transitions4 + 1;
            }
            sampleGrid = sampleGrid(this.image, resultPoint11, resultPoint10, resultPoint9, resultPoint12, i5, i6);
        } else {
            ResultPoint correctTopRight = correctTopRight(resultPoint10, resultPoint9, resultPoint11, resultPoint12, Math.min(i4, i2));
            if (correctTopRight != null) {
                resultPoint12 = correctTopRight;
            }
            int max = Math.max(transitionsBetween(resultPoint11, resultPoint12).getTransitions(), transitionsBetween(resultPoint9, resultPoint12).getTransitions()) + 1;
            int i7 = max;
            if ((max & 1) == 1) {
                i7 = max + 1;
            }
            sampleGrid = sampleGrid(this.image, resultPoint11, resultPoint10, resultPoint9, resultPoint12, i7, i7);
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint11, resultPoint10, resultPoint9, resultPoint12});
    }
}
