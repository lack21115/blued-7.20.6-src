package com.sobot.chat.widget.zxing.qrcode.decoder;

import com.sobot.chat.widget.zxing.qrcode.decoder.Version;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/decoder/DataBlock.class */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        int i;
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i2 = 0;
        for (Version.ECB ecb : eCBlocks) {
            i2 += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i2];
        int i3 = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i4 = 0;
            while (i4 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i3] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i4++;
                i3++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        while (true) {
            i2--;
            if (i2 < 0 || dataBlockArr[i2].codewords.length == length) {
                break;
            }
        }
        int i5 = i2 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i6 = 0;
        for (int i7 = 0; i7 < eCCodewordsPerBlock; i7++) {
            int i8 = 0;
            while (i8 < i3) {
                dataBlockArr[i8].codewords[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        int i9 = i5;
        int i10 = i6;
        while (true) {
            i = i10;
            if (i9 >= i3) {
                break;
            }
            dataBlockArr[i9].codewords[eCCodewordsPerBlock] = bArr[i];
            i9++;
            i10 = i + 1;
        }
        int length2 = dataBlockArr[0].codewords.length;
        int i11 = eCCodewordsPerBlock;
        while (true) {
            int i12 = i11;
            if (i12 >= length2) {
                return dataBlockArr;
            }
            int i13 = 0;
            while (i13 < i3) {
                dataBlockArr[i13].codewords[i13 < i5 ? i12 : i12 + 1] = bArr[i];
                i13++;
                i++;
            }
            i11 = i12 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getCodewords() {
        return this.codewords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
