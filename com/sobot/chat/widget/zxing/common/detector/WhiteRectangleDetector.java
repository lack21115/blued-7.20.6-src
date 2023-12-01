package com.sobot.chat.widget.zxing.common.detector;

import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.common.BitMatrix;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/detector/WhiteRectangleDetector.class */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        this.width = width;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.leftInit = i5;
        int i6 = i2 + i4;
        this.rightInit = i6;
        int i7 = i3 - i4;
        this.upInit = i7;
        int i8 = i3 + i4;
        this.downInit = i8;
        if (i7 < 0 || i5 < 0 || i8 >= this.height || i6 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        return x < ((float) this.width) / 2.0f ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        for (int i4 = i; i4 <= i2; i4++) {
            if (this.image.get(i3, i4)) {
                return true;
            }
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = round;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= round) {
                return null;
            }
            float f8 = i2;
            int round2 = MathUtils.round((f8 * f6) + f);
            int round3 = MathUtils.round((f8 * f7) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint(round2, round3);
            }
            i = i2 + 1;
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5 = this.leftInit;
        int i6 = this.rightInit;
        int i7 = this.upInit;
        int i8 = this.downInit;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            i = i5;
            i2 = i6;
            i3 = i7;
            i4 = i8;
            z = false;
            if (!z2) {
                break;
            }
            boolean z7 = true;
            boolean z8 = false;
            i2 = i6;
            while (true) {
                if ((z7 || !z3) && i2 < this.width) {
                    boolean containsBlackPoint = containsBlackPoint(i7, i8, i2, false);
                    if (containsBlackPoint) {
                        i2++;
                        z3 = true;
                        z8 = true;
                        z7 = containsBlackPoint;
                    } else {
                        z7 = containsBlackPoint;
                        if (!z3) {
                            i2++;
                            z7 = containsBlackPoint;
                        }
                    }
                }
            }
            if (i2 < this.width) {
                boolean z9 = true;
                boolean z10 = z8;
                int i9 = i8;
                while (true) {
                    if ((z9 || !z4) && i9 < this.height) {
                        boolean containsBlackPoint2 = containsBlackPoint(i5, i2, i9, true);
                        if (containsBlackPoint2) {
                            i9++;
                            z4 = true;
                            z10 = true;
                            z9 = containsBlackPoint2;
                        } else {
                            z9 = containsBlackPoint2;
                            if (!z4) {
                                i9++;
                                z9 = containsBlackPoint2;
                            }
                        }
                    }
                }
                if (i9 < this.height) {
                    boolean z11 = true;
                    boolean z12 = z10;
                    int i10 = i5;
                    while (true) {
                        if ((z11 || !z5) && i10 >= 0) {
                            boolean containsBlackPoint3 = containsBlackPoint(i7, i9, i10, false);
                            if (containsBlackPoint3) {
                                i10--;
                                z5 = true;
                                z12 = true;
                                z11 = containsBlackPoint3;
                            } else {
                                z11 = containsBlackPoint3;
                                if (!z5) {
                                    i10--;
                                    z11 = containsBlackPoint3;
                                }
                            }
                        }
                    }
                    if (i10 >= 0) {
                        boolean z13 = true;
                        boolean z14 = z6;
                        boolean z15 = z12;
                        int i11 = i7;
                        while (true) {
                            if ((z13 || !z14) && i11 >= 0) {
                                boolean containsBlackPoint4 = containsBlackPoint(i10, i2, i11, true);
                                if (containsBlackPoint4) {
                                    i11--;
                                    z15 = true;
                                    z14 = true;
                                    z13 = containsBlackPoint4;
                                } else {
                                    z13 = containsBlackPoint4;
                                    if (!z14) {
                                        i11--;
                                        z13 = containsBlackPoint4;
                                    }
                                }
                            }
                        }
                        i5 = i10;
                        i6 = i2;
                        i7 = i11;
                        i8 = i9;
                        z2 = z15;
                        z6 = z14;
                        if (i11 < 0) {
                            i5 = i10;
                            i7 = i11;
                            i8 = i9;
                            break;
                        }
                    } else {
                        i5 = i10;
                        i8 = i9;
                        break;
                    }
                } else {
                    i8 = i9;
                    break;
                }
            } else {
                break;
            }
        }
        z = true;
        i = i5;
        i3 = i7;
        i4 = i8;
        if (z) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i2 - i;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        int i13 = 1;
        while (true) {
            int i14 = i13;
            if (resultPoint2 != null || i14 >= i12) {
                break;
            }
            resultPoint2 = getBlackPointOnSegment(i, i4 - i14, i + i14, i4);
            i13 = i14 + 1;
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            int i15 = 1;
            while (true) {
                int i16 = i15;
                if (resultPoint3 != null || i16 >= i12) {
                    break;
                }
                resultPoint3 = getBlackPointOnSegment(i, i3 + i16, i + i16, i3);
                i15 = i16 + 1;
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                int i17 = 1;
                while (true) {
                    int i18 = i17;
                    if (resultPoint4 != null || i18 >= i12) {
                        break;
                    }
                    resultPoint4 = getBlackPointOnSegment(i2, i3 + i18, i2 - i18, i3);
                    i17 = i18 + 1;
                }
                if (resultPoint4 != null) {
                    int i19 = 1;
                    while (true) {
                        int i20 = i19;
                        if (resultPoint != null || i20 >= i12) {
                            break;
                        }
                        resultPoint = getBlackPointOnSegment(i2, i4 - i20, i2 - i20, i4);
                        i19 = i20 + 1;
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
