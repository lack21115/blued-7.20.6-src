package com.sobot.chat.widget.zxing.common;

import com.sobot.chat.widget.zxing.Binarizer;
import com.sobot.chat.widget.zxing.LuminanceSource;
import com.sobot.chat.widget.zxing.NotFoundException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/GlobalHistogramBinarizer.class */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < length) {
            int i6 = i3;
            if (iArr[i2] > i3) {
                i6 = iArr[i2];
                i5 = i2;
            }
            int i7 = i4;
            if (iArr[i2] > i4) {
                i7 = iArr[i2];
            }
            i2++;
            i3 = i6;
            i4 = i7;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 - i5;
            int i12 = iArr[i10] * i11 * i11;
            int i13 = i9;
            if (i12 > i9) {
                i8 = i10;
                i13 = i12;
            }
            i10++;
            i9 = i13;
        }
        if (i5 > i8) {
            i = i5;
        } else {
            i = i8;
            i8 = i5;
        }
        if (i - i8 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = i - 1;
        int i15 = i14;
        int i16 = -1;
        while (true) {
            int i17 = i16;
            if (i14 <= i8) {
                return i15 << 3;
            }
            int i18 = i14 - i8;
            int i19 = i18 * i18 * (i - i14) * (i4 - iArr[i14]);
            int i20 = i17;
            if (i19 > i17) {
                i15 = i14;
                i20 = i19;
            }
            i14--;
            i16 = i20;
        }
    }

    private void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 32) {
                return;
            }
            this.buckets[i3] = 0;
            i2 = i3 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // com.sobot.chat.widget.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            byte[] row = luminanceSource.getRow((height * i2) / 5, this.luminances);
            int i3 = (width * 4) / 5;
            int i4 = width / 5;
            while (true) {
                int i5 = i4;
                if (i5 < i3) {
                    int i6 = (row[i5] & 255) >> 3;
                    iArr[i6] = iArr[i6] + 1;
                    i4 = i5 + 1;
                }
            }
            i = i2 + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= height) {
                return bitMatrix;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 < width) {
                    if ((matrix[(i8 * width) + i10] & 255) < estimateBlackPoint) {
                        bitMatrix.set(i10, i8);
                    }
                    i9 = i10 + 1;
                }
            }
            i7 = i8 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.Binarizer
    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i, this.luminances);
        int[] iArr = this.buckets;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= width) {
                break;
            }
            int i4 = (row[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
            i2 = i3 + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        if (width >= 3) {
            int i5 = 1;
            int i6 = row[0] & 255;
            int i7 = row[1] & 255;
            while (true) {
                int i8 = i7;
                if (i5 >= width - 1) {
                    break;
                }
                int i9 = i5 + 1;
                int i10 = row[i9] & 255;
                if ((((i8 * 4) - i6) - i10) / 2 < estimateBlackPoint) {
                    bitArray.set(i5);
                }
                i6 = i8;
                i5 = i9;
                i7 = i10;
            }
        } else {
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= width) {
                    break;
                }
                if ((row[i12] & 255) < estimateBlackPoint) {
                    bitArray.set(i12);
                }
                i11 = i12 + 1;
            }
        }
        return bitArray;
    }
}
