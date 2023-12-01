package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/maxicode/decoder/Decoder.class */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);

    private void correctErrors(byte[] bArr, int i, int i2, int i3, int i4) throws ChecksumException {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= i5) {
                try {
                    break;
                } catch (ReedSolomonException e) {
                    throw ChecksumException.getChecksumInstance();
                }
            }
            if (i4 == 0 || i8 % 2 == i4 - 1) {
                iArr[i8 / i6] = bArr[i8 + i] & 255;
            }
            i7 = i8 + 1;
        }
        this.rsDecoder.decode(iArr, i3 / i6);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= i2) {
                return;
            }
            if (i4 == 0 || i10 % 2 == i4 - 1) {
                bArr[i10 + i] = (byte) iArr[i10 / i6];
            }
            i9 = i10 + 1;
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] readCodewords = new BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(readCodewords, 0, 10, 10, 0);
        int i = readCodewords[0] & 15;
        if (i == 2 || i == 3 || i == 4) {
            correctErrors(readCodewords, 20, 84, 40, 1);
            correctErrors(readCodewords, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (i != 5) {
            throw FormatException.getFormatInstance();
        } else {
            correctErrors(readCodewords, 20, 68, 56, 1);
            correctErrors(readCodewords, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy((Object) readCodewords, 0, (Object) bArr, 0, 10);
        System.arraycopy((Object) readCodewords, 20, (Object) bArr, 10, bArr.length - 10);
        return DecodedBitStreamParser.decode(bArr, i);
    }
}
