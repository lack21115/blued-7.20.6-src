package com.sobot.chat.widget.zxing.qrcode.detector;

import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.ResultPointCallback;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import com.sobot.chat.widget.zxing.common.DetectorResult;
import com.sobot.chat.widget.zxing.common.GridSampler;
import com.sobot.chat.widget.zxing.common.PerspectiveTransform;
import com.sobot.chat.widget.zxing.common.detector.MathUtils;
import com.sobot.chat.widget.zxing.qrcode.decoder.Version;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/detector/Detector.class */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays) ? sizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f)) / 2) + 7;
        int i = round & 3;
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    return round;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            return round - 1;
        }
        return round + 1;
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f;
        float y;
        float f2;
        float f3 = i - 3.5f;
        if (resultPoint4 != null) {
            float x = resultPoint4.getX();
            y = resultPoint4.getY();
            f2 = f3 - 3.0f;
            f = x;
        } else {
            float x2 = resultPoint2.getX();
            float x3 = resultPoint.getX();
            float x4 = resultPoint3.getX();
            f = (x2 - x3) + x4;
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f2 = f3;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f, y, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            i6 = i3;
            i8 = i2;
            i7 = i;
            i5 = i4;
        } else {
            i5 = i3;
            i6 = i4;
            i7 = i2;
            i8 = i;
        }
        int abs = Math.abs(i5 - i8);
        int abs2 = Math.abs(i6 - i7);
        int i10 = (-abs) / 2;
        int i11 = -1;
        int i12 = i8 < i5 ? 1 : -1;
        if (i7 < i6) {
            i11 = 1;
        }
        int i13 = i5 + i12;
        int i14 = i8;
        int i15 = i7;
        int i16 = 0;
        boolean z2 = z;
        while (true) {
            if (i14 == i13) {
                i9 = i16;
                break;
            }
            i9 = i16;
            if ((i16 == 1) == this.image.get(z2 ? i15 : i14, z2 ? i14 : i15)) {
                if (i16 == 2) {
                    return MathUtils.distance(i14, i15, i8, i7);
                }
                i9 = i16 + 1;
            }
            int i17 = i10 + abs2;
            int i18 = i17;
            int i19 = i15;
            if (i17 > 0) {
                if (i15 == i6) {
                    break;
                }
                i19 = i15 + i11;
                i18 = i17 - abs;
            }
            i14 += i12;
            i10 = i18;
            i15 = i19;
            i16 = i9;
        }
        if (i9 == 2) {
            return MathUtils.distance(i13, i6, i8, i7);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else if (i5 >= this.image.getWidth()) {
            f = ((this.image.getWidth() - 1) - i) / (i5 - i);
            i5 = this.image.getWidth() - 1;
        } else {
            f = 1.0f;
        }
        float f3 = i2;
        int i6 = (int) (f3 - ((i4 - i2) * f));
        if (i6 < 0) {
            f2 = f3 / (i2 - i6);
            i6 = 0;
        } else if (i6 >= this.image.getHeight()) {
            f2 = ((this.image.getHeight() - 1) - i2) / (i6 - i2);
            i6 = this.image.getHeight() - 1;
        } else {
            f2 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i, i2, (int) (i + ((i5 - i) * f2)), i6)) - 1.0f;
    }

    protected final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback).find(map));
    }

    protected final AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.image.getWidth() - 1, i + i3) - max;
        float f3 = min;
        float f4 = 3.0f * f;
        if (f3 >= f4) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.image.getHeight() - 1, i2 + i3) - max2;
            if (min2 >= f4) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    protected final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize >= 1.0f) {
            int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion();
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x = topRight.getX();
                float x2 = topLeft.getX();
                float x3 = bottomLeft.getX();
                float y = topRight.getY();
                float y2 = topLeft.getY();
                float y3 = bottomLeft.getY();
                float f = 1.0f - (3.0f / (dimensionForVersion - 7));
                int x4 = (int) (topLeft.getX() + ((((x - x2) + x3) - topLeft.getX()) * f));
                int y4 = (int) (topLeft.getY() + (f * (((y - y2) + y3) - topLeft.getY())));
                int i = 4;
                while (true) {
                    int i2 = i;
                    alignmentPattern = null;
                    if (i2 > 16) {
                        break;
                    }
                    try {
                        alignmentPattern = findAlignmentInRegion(calculateModuleSize, x4, y4, i2);
                        break;
                    } catch (NotFoundException e) {
                        i = i2 << 1;
                    }
                }
            }
            return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension), alignmentPattern == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
