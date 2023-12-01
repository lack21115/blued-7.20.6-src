package com.sobot.chat.widget.zxing.datamatrix.detector;

import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import com.sobot.chat.widget.zxing.common.DetectorResult;
import com.sobot.chat.widget.zxing.common.GridSampler;
import com.sobot.chat.widget.zxing.common.detector.WhiteRectangleDetector;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/detector/Detector.class */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[2];
        ResultPoint resultPoint4 = resultPointArr[3];
        int transitionsBetween = transitionsBetween(resultPoint, resultPoint4);
        ResultPoint shiftPoint = shiftPoint(resultPoint, resultPoint2, (transitionsBetween(resultPoint2, resultPoint4) + 1) * 4);
        ResultPoint shiftPoint2 = shiftPoint(resultPoint3, resultPoint2, (transitionsBetween + 1) * 4);
        int transitionsBetween2 = transitionsBetween(shiftPoint, resultPoint4);
        int transitionsBetween3 = transitionsBetween(shiftPoint2, resultPoint4);
        float x = resultPoint4.getX();
        float x2 = resultPoint3.getX();
        float x3 = resultPoint2.getX();
        float f = transitionsBetween2 + 1;
        ResultPoint resultPoint5 = new ResultPoint(x + ((x2 - x3) / f), resultPoint4.getY() + ((resultPoint3.getY() - resultPoint2.getY()) / f));
        float x4 = resultPoint4.getX();
        float x5 = resultPoint.getX();
        float x6 = resultPoint2.getX();
        float f2 = transitionsBetween3 + 1;
        ResultPoint resultPoint6 = new ResultPoint(x4 + ((x5 - x6) / f2), resultPoint4.getY() + ((resultPoint.getY() - resultPoint2.getY()) / f2));
        if (!isValid(resultPoint5)) {
            if (isValid(resultPoint6)) {
                return resultPoint6;
            }
            return null;
        }
        if (isValid(resultPoint6) && transitionsBetween(shiftPoint, resultPoint5) + transitionsBetween(shiftPoint2, resultPoint5) <= transitionsBetween(shiftPoint, resultPoint6) + transitionsBetween(shiftPoint2, resultPoint6)) {
            return resultPoint6;
        }
        return resultPoint5;
    }

    private ResultPoint[] detectSolid1(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[3];
        ResultPoint resultPoint4 = resultPointArr[2];
        int transitionsBetween = transitionsBetween(resultPoint, resultPoint2);
        int transitionsBetween2 = transitionsBetween(resultPoint2, resultPoint3);
        int transitionsBetween3 = transitionsBetween(resultPoint3, resultPoint4);
        int transitionsBetween4 = transitionsBetween(resultPoint4, resultPoint);
        ResultPoint[] resultPointArr2 = {resultPoint4, resultPoint, resultPoint2, resultPoint3};
        int i = transitionsBetween;
        if (transitionsBetween > transitionsBetween2) {
            resultPointArr2[0] = resultPoint;
            resultPointArr2[1] = resultPoint2;
            resultPointArr2[2] = resultPoint3;
            resultPointArr2[3] = resultPoint4;
            i = transitionsBetween2;
        }
        if (i > transitionsBetween3) {
            resultPointArr2[0] = resultPoint2;
            resultPointArr2[1] = resultPoint3;
            resultPointArr2[2] = resultPoint4;
            resultPointArr2[3] = resultPoint;
            i = transitionsBetween3;
        }
        if (i > transitionsBetween4) {
            resultPointArr2[0] = resultPoint3;
            resultPointArr2[1] = resultPoint4;
            resultPointArr2[2] = resultPoint;
            resultPointArr2[3] = resultPoint2;
        }
        return resultPointArr2;
    }

    private ResultPoint[] detectSolid2(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[2];
        ResultPoint resultPoint4 = resultPointArr[3];
        int transitionsBetween = (transitionsBetween(resultPoint, resultPoint4) + 1) * 4;
        if (transitionsBetween(shiftPoint(resultPoint2, resultPoint3, transitionsBetween), resultPoint) < transitionsBetween(shiftPoint(resultPoint3, resultPoint2, transitionsBetween), resultPoint4)) {
            resultPointArr[0] = resultPoint;
            resultPointArr[1] = resultPoint2;
            resultPointArr[2] = resultPoint3;
            resultPointArr[3] = resultPoint4;
            return resultPointArr;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint3;
        resultPointArr[2] = resultPoint4;
        resultPointArr[3] = resultPoint;
        return resultPointArr;
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static ResultPoint moveAway(ResultPoint resultPoint, float f, float f2) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        return new ResultPoint(x < f ? x - 1.0f : x + 1.0f, y < f2 ? y - 1.0f : y + 1.0f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private static ResultPoint shiftPoint(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float f = i + 1;
        return new ResultPoint(resultPoint.getX() + ((resultPoint2.getX() - resultPoint.getX()) / f), resultPoint.getY() + ((resultPoint2.getY() - resultPoint.getY()) / f));
    }

    private ResultPoint[] shiftToModuleCenter(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint = resultPointArr[0];
        ResultPoint resultPoint2 = resultPointArr[1];
        ResultPoint resultPoint3 = resultPointArr[2];
        ResultPoint resultPoint4 = resultPointArr[3];
        int transitionsBetween = transitionsBetween(resultPoint, resultPoint4);
        ResultPoint shiftPoint = shiftPoint(resultPoint, resultPoint2, (transitionsBetween(resultPoint3, resultPoint4) + 1) * 4);
        ResultPoint shiftPoint2 = shiftPoint(resultPoint3, resultPoint2, (transitionsBetween + 1) * 4);
        int transitionsBetween2 = transitionsBetween(shiftPoint, resultPoint4) + 1;
        int transitionsBetween3 = transitionsBetween(shiftPoint2, resultPoint4) + 1;
        int i = transitionsBetween2;
        if ((transitionsBetween2 & 1) == 1) {
            i = transitionsBetween2 + 1;
        }
        int i2 = transitionsBetween3;
        if ((transitionsBetween3 & 1) == 1) {
            i2 = transitionsBetween3 + 1;
        }
        float x = (((resultPoint.getX() + resultPoint2.getX()) + resultPoint3.getX()) + resultPoint4.getX()) / 4.0f;
        float y = (((resultPoint.getY() + resultPoint2.getY()) + resultPoint3.getY()) + resultPoint4.getY()) / 4.0f;
        ResultPoint moveAway = moveAway(resultPoint, x, y);
        ResultPoint moveAway2 = moveAway(resultPoint2, x, y);
        ResultPoint moveAway3 = moveAway(resultPoint3, x, y);
        ResultPoint moveAway4 = moveAway(resultPoint4, x, y);
        int i3 = i2 * 4;
        ResultPoint shiftPoint3 = shiftPoint(moveAway, moveAway2, i3);
        int i4 = i * 4;
        return new ResultPoint[]{shiftPoint(shiftPoint3, moveAway4, i4), shiftPoint(shiftPoint(moveAway2, moveAway, i3), moveAway3, i4), shiftPoint(shiftPoint(moveAway3, moveAway4, i3), moveAway2, i4), shiftPoint(shiftPoint(moveAway4, moveAway3, i3), moveAway, i4)};
    }

    private int transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        int i = x;
        int i2 = y;
        int i3 = x2;
        int i4 = y2;
        if (z) {
            i2 = x;
            i = y;
            i4 = x2;
            i3 = y2;
        }
        int abs = Math.abs(i3 - i);
        int abs2 = Math.abs(i4 - i2);
        int i5 = (-abs) / 2;
        int i6 = i2 < i4 ? 1 : -1;
        int i7 = i < i3 ? 1 : -1;
        boolean z2 = this.image.get(z ? i2 : i, z ? i : i2);
        int i8 = i5;
        int i9 = 0;
        while (i != i3) {
            boolean z3 = this.image.get(z ? i2 : i, z ? i : i2);
            int i10 = i9;
            boolean z4 = z2;
            if (z3 != z2) {
                i10 = i9 + 1;
                z4 = z3;
            }
            int i11 = i8 + abs2;
            int i12 = i2;
            i8 = i11;
            if (i11 > 0) {
                if (i2 == i4) {
                    return i10;
                }
                i12 = i2 + i6;
                i8 = i11 - abs;
            }
            i += i7;
            i2 = i12;
            i9 = i10;
            z2 = z4;
        }
        return i9;
    }

    public DetectorResult detect() throws NotFoundException {
        int i;
        int i2;
        ResultPoint[] detectSolid2 = detectSolid2(detectSolid1(this.rectangleDetector.detect()));
        detectSolid2[3] = correctTopRight(detectSolid2);
        if (detectSolid2[3] != null) {
            ResultPoint[] shiftToModuleCenter = shiftToModuleCenter(detectSolid2);
            ResultPoint resultPoint = shiftToModuleCenter[0];
            ResultPoint resultPoint2 = shiftToModuleCenter[1];
            ResultPoint resultPoint3 = shiftToModuleCenter[2];
            ResultPoint resultPoint4 = shiftToModuleCenter[3];
            int transitionsBetween = transitionsBetween(resultPoint, resultPoint4) + 1;
            int transitionsBetween2 = transitionsBetween(resultPoint3, resultPoint4) + 1;
            int i3 = transitionsBetween;
            if ((transitionsBetween & 1) == 1) {
                i3 = transitionsBetween + 1;
            }
            int i4 = transitionsBetween2;
            if ((transitionsBetween2 & 1) == 1) {
                i4 = transitionsBetween2 + 1;
            }
            if (i3 * 4 >= i4 * 7 || i4 * 4 >= i3 * 7) {
                i = i4;
                i2 = i3;
            } else {
                i2 = Math.max(i3, i4);
                i = i2;
            }
            return new DetectorResult(sampleGrid(this.image, resultPoint, resultPoint2, resultPoint3, resultPoint4, i2, i), new ResultPoint[]{resultPoint, resultPoint2, resultPoint3, resultPoint4});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
