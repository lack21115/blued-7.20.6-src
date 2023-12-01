package com.sobot.chat.widget.zxing.oned.rss.expanded;

import com.sobot.chat.widget.zxing.common.BitArray;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/rss/expanded/BitArrayBuilder.class */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitArray buildBitArray(List<ExpandedPair> list) {
        int size = (list.size() * 2) - 1;
        int i = size;
        if (list.get(list.size() - 1).getRightChar() == null) {
            i = size - 1;
        }
        BitArray bitArray = new BitArray(i * 12);
        int i2 = 0;
        int value = list.get(0).getRightChar().getValue();
        int i3 = 11;
        while (true) {
            int i4 = i3;
            if (i4 < 0) {
                break;
            }
            if (((1 << i4) & value) != 0) {
                bitArray.set(i2);
            }
            i2++;
            i3 = i4 - 1;
        }
        int i5 = 1;
        while (i5 < list.size()) {
            ExpandedPair expandedPair = list.get(i5);
            int value2 = expandedPair.getLeftChar().getValue();
            int i6 = 11;
            while (true) {
                int i7 = i6;
                if (i7 < 0) {
                    break;
                }
                if (((1 << i7) & value2) != 0) {
                    bitArray.set(i2);
                }
                i2++;
                i6 = i7 - 1;
            }
            int i8 = i2;
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                int i9 = 11;
                while (true) {
                    int i10 = i9;
                    i8 = i2;
                    if (i10 >= 0) {
                        if (((1 << i10) & value3) != 0) {
                            bitArray.set(i2);
                        }
                        i2++;
                        i9 = i10 - 1;
                    }
                }
            }
            i5++;
            i2 = i8;
        }
        return bitArray;
    }
}
