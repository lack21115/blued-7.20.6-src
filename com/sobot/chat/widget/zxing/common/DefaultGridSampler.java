package com.sobot.chat.widget.zxing.common;

import com.sobot.chat.widget.zxing.NotFoundException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/DefaultGridSampler.class */
public final class DefaultGridSampler extends GridSampler {
    @Override // com.sobot.chat.widget.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException {
        return sampleGrid(bitMatrix, i, i2, PerspectiveTransform.quadrilateralToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // com.sobot.chat.widget.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitMatrix2 = new BitMatrix(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return bitMatrix2;
            }
            float f = i5;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= i3) {
                    break;
                }
                fArr[i7] = (i7 / 2) + 0.5f;
                fArr[i7 + 1] = f + 0.5f;
                i6 = i7 + 2;
            }
            perspectiveTransform.transformPoints(fArr);
            checkAndNudgePoints(bitMatrix, fArr);
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < i3) {
                    try {
                        if (bitMatrix.get((int) fArr[i9], (int) fArr[i9 + 1])) {
                            bitMatrix2.set(i9 / 2, i5);
                        }
                        i8 = i9 + 2;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
            }
            i4 = i5 + 1;
        }
    }
}
