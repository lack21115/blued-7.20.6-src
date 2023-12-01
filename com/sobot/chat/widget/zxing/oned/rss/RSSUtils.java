package com.sobot.chat.widget.zxing.oned.rss;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/rss/RSSUtils.class */
public final class RSSUtils {
    private RSSUtils() {
    }

    private static int combins(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i - i2;
        int i7 = i6;
        int i8 = i2;
        if (i6 > i2) {
            i8 = i6;
            i7 = i2;
        }
        int i9 = 1;
        int i10 = 1;
        int i11 = i;
        while (true) {
            int i12 = i11;
            i3 = i10;
            i4 = i9;
            if (i12 <= i8) {
                break;
            }
            int i13 = i9 * i12;
            i9 = i13;
            i10 = i3;
            if (i3 <= i7) {
                i9 = i13 / i3;
                i10 = i3 + 1;
            }
            i11 = i12 - 1;
        }
        for (i5 = i3; i5 <= i7; i5++) {
            i4 /= i5;
        }
        return i4;
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int i2;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = i3;
        while (true) {
            int i9 = length - 1;
            if (i5 >= i9) {
                return i6;
            }
            int i10 = 1 << i5;
            int i11 = i7 | i10;
            int i12 = 1;
            while (i12 < iArr[i5]) {
                int i13 = i8 - i12;
                int i14 = length - i5;
                int i15 = i14 - 2;
                int combins = combins(i13 - 1, i15);
                int i16 = combins;
                if (z) {
                    i16 = combins;
                    if (i11 == 0) {
                        int i17 = i14 - 1;
                        i16 = combins;
                        if (i13 - i17 >= i17) {
                            i16 = combins - combins(i13 - i14, i15);
                        }
                    }
                }
                if (i14 - 1 > 1) {
                    int i18 = 0;
                    for (int i19 = i13 - i15; i19 > i; i19--) {
                        i18 += combins((i13 - i19) - 1, i14 - 3);
                    }
                    i2 = i16 - (i18 * (i9 - i5));
                } else {
                    i2 = i16;
                    if (i13 > i) {
                        i2 = i16 - 1;
                    }
                }
                i6 += i2;
                i12++;
                i11 &= i10;
            }
            i8 -= i12;
            i5++;
            i7 = i11;
        }
    }
}
