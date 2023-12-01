package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/rss/expanded/decoders/AI01weightDecoder.class */
public abstract class AI01weightDecoder extends AI01decoder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    protected abstract void addWeightCode(StringBuilder sb, int i);

    protected abstract int checkWeight(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void encodeCompressedWeight(StringBuilder sb, int i, int i2) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, i2);
        addWeightCode(sb, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i3 = 100000;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 5) {
                sb.append(checkWeight);
                return;
            }
            if (checkWeight / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
            i4 = i5 + 1;
        }
    }
}
