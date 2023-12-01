package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BinaryBitmap;
import com.sobot.chat.widget.zxing.ChecksumException;
import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.Reader;
import com.sobot.chat.widget.zxing.Result;
import com.sobot.chat.widget.zxing.ResultMetadataType;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/OneDReader.class */
public abstract class OneDReader implements Reader {
    /* JADX WARN: Code restructure failed: missing block: B:85:0x018a, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sobot.chat.widget.zxing.Result doDecode(com.sobot.chat.widget.zxing.BinaryBitmap r9, java.util.Map<com.sobot.chat.widget.zxing.DecodeHintType, ?> r10) throws com.sobot.chat.widget.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.oned.OneDReader.doDecode(com.sobot.chat.widget.zxing.BinaryBitmap, java.util.Map):com.sobot.chat.widget.zxing.Result");
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int i2;
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !bitArray.get(i);
        int i3 = i;
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (i3 >= size) {
                break;
            }
            if (bitArray.get(i3) != z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                i4++;
                if (i4 == length) {
                    i2 = i4;
                    break;
                } else {
                    iArr[i4] = 1;
                    z = !z;
                }
            }
            i3++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i3 != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            int i2 = i - 1;
            i = i2;
            if (bitArray.get(i2) != z) {
                length--;
                z = !z;
                i = i2;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    @Override // com.sobot.chat.widget.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.sobot.chat.widget.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            if ((map != null && map.containsKey(DecodeHintType.TRY_HARDER)) && binaryBitmap.isRotateSupported()) {
                BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                Result doDecode = doDecode(rotateCounterClockwise, map);
                Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
                int i = 270;
                if (resultMetadata != null) {
                    i = 270;
                    if (resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                        i = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
                    }
                }
                doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
                ResultPoint[] resultPoints = doDecode.getResultPoints();
                if (resultPoints != null) {
                    int height = rotateCounterClockwise.getHeight();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= resultPoints.length) {
                            break;
                        }
                        resultPoints[i3] = new ResultPoint((height - resultPoints[i3].getY()) - 1.0f, resultPoints[i3].getX());
                        i2 = i3 + 1;
                    }
                }
                return doDecode;
            }
            throw e;
        }
    }

    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.sobot.chat.widget.zxing.Reader
    public void reset() {
    }
}
