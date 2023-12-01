package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/pdf417/decoder/PDF417CodewordDecoder.class */
final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = (float[][]) Array.newInstance(Float.TYPE, PDF417Common.SYMBOL_TABLE.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= PDF417Common.SYMBOL_TABLE.length) {
                return;
            }
            int i4 = PDF417Common.SYMBOL_TABLE[i3];
            int i5 = i4 & 1;
            int i6 = 0;
            while (i6 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i4 & 1;
                    if (i == i5) {
                        f += 1.0f;
                        i4 >>= 1;
                    }
                }
                RATIOS_TABLE[i3][(8 - i6) - 1] = f / 17.0f;
                i6++;
                i5 = i;
            }
            i2 = i3 + 1;
        }
    }

    private PDF417CodewordDecoder() {
    }

    private static int getBitValue(int[] iArr) {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return (int) j;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < iArr[i2]) {
                    int i5 = 1;
                    if (i2 % 2 != 0) {
                        i5 = 0;
                    }
                    j = (j << 1) | i5;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    private static int getClosestDecodedValue(int[] iArr) {
        float f;
        int sum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        if (sum > 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 8) {
                    break;
                }
                fArr[i2] = iArr[i2] / sum;
                i = i2 + 1;
            }
        }
        float f2 = Float.MAX_VALUE;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i4 >= fArr2.length) {
                return i3;
            }
            float f3 = 0.0f;
            float[] fArr3 = fArr2[i4];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                f = f3;
                if (i6 >= 8) {
                    break;
                }
                float f4 = fArr3[i6] - fArr[i6];
                f3 += f4 * f4;
                f = f3;
                if (f3 >= f2) {
                    break;
                }
                i5 = i6 + 1;
            }
            float f5 = f2;
            if (f < f2) {
                i3 = PDF417Common.SYMBOL_TABLE[i4];
                f5 = f;
            }
            i4++;
            f2 = f5;
        }
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        return decodedCodewordValue != -1 ? decodedCodewordValue : getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float sum = MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i >= 17) {
                return iArr2;
            }
            int i5 = i2;
            int i6 = i4;
            if (iArr[i4] + i2 <= (sum / 34.0f) + ((i * sum) / 17.0f)) {
                i5 = i2 + iArr[i4];
                i6 = i4 + 1;
            }
            iArr2[i6] = iArr2[i6] + 1;
            i++;
            i2 = i5;
            i3 = i6;
        }
    }
}
