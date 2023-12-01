package com.sobot.chat.widget.zxing.datamatrix.decoder;

import com.sobot.chat.widget.zxing.ChecksumException;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import com.sobot.chat.widget.zxing.common.DecoderResult;
import com.sobot.chat.widget.zxing.common.reedsolomon.GenericGF;
import com.sobot.chat.widget.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.sobot.chat.widget.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/decoder/Decoder.class */
public final class Decoder {
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

    private void correctErrors(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                try {
                    break;
                } catch (ReedSolomonException e) {
                    throw ChecksumException.getChecksumInstance();
                }
            } else {
                iArr[i3] = bArr[i3] & 255;
                i2 = i3 + 1;
            }
        }
        this.rsDecoder.decode(iArr, bArr.length - i);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                return;
            }
            bArr[i5] = (byte) iArr[i5];
            i4 = i5 + 1;
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws FormatException, ChecksumException {
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), bitMatrixParser.getVersion());
        int i = 0;
        for (DataBlock dataBlock : dataBlocks) {
            i += dataBlock.getNumDataCodewords();
        }
        byte[] bArr = new byte[i];
        int length = dataBlocks.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return DecodedBitStreamParser.decode(bArr);
            }
            DataBlock dataBlock2 = dataBlocks[i3];
            byte[] codewords = dataBlock2.getCodewords();
            int numDataCodewords = dataBlock2.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < numDataCodewords) {
                    bArr[(i5 * length) + i3] = codewords[i5];
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public DecoderResult decode(boolean[][] zArr) throws FormatException, ChecksumException {
        return decode(BitMatrix.parse(zArr));
    }
}
