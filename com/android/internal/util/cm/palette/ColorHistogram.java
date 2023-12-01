package com.android.internal.util.cm.palette;

import java.util.Arrays;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/ColorHistogram.class */
final class ColorHistogram {
    private final int[] mColorCounts;
    private final int[] mColors;
    private final int mNumberColors;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorHistogram(int[] iArr) {
        Arrays.sort(iArr);
        this.mNumberColors = countDistinctColors(iArr);
        this.mColors = new int[this.mNumberColors];
        this.mColorCounts = new int[this.mNumberColors];
        countFrequencies(iArr);
    }

    private static int countDistinctColors(int[] iArr) {
        int i;
        if (iArr.length >= 2) {
            int i2 = 1;
            int i3 = iArr[0];
            int i4 = 1;
            while (true) {
                i = i2;
                if (i4 >= iArr.length) {
                    break;
                }
                int i5 = i2;
                int i6 = i3;
                if (iArr[i4] != i3) {
                    i6 = iArr[i4];
                    i5 = i2 + 1;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
        } else {
            i = iArr.length;
        }
        return i;
    }

    private void countFrequencies(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int i = 0;
        int i2 = iArr[0];
        this.mColors[0] = i2;
        this.mColorCounts[0] = 1;
        if (iArr.length == 1) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 >= iArr.length) {
                return;
            }
            if (iArr[i4] == i2) {
                int[] iArr2 = this.mColorCounts;
                iArr2[i] = iArr2[i] + 1;
            } else {
                i2 = iArr[i4];
                i++;
                this.mColors[i] = i2;
                this.mColorCounts[i] = 1;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getColorCounts() {
        return this.mColorCounts;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getColors() {
        return this.mColors;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumberOfColors() {
        return this.mNumberColors;
    }
}
