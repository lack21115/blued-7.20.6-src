package java.math;

import android.widget.ExpandableListView;

/* loaded from: source-2895416-dex2jar.jar:java/math/Division.class */
class Division {
    Division() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int divideArrayByInt(int[] iArr, int[] iArr2, int i, int i2) {
        long j;
        long j2 = 0;
        long j3 = i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        while (true) {
            i--;
            if (i < 0) {
                return (int) j2;
            }
            long j4 = (j2 << 32) | (iArr2[i] & ExpandableListView.PACKED_POSITION_VALUE_NULL);
            if (j4 >= 0) {
                j = j4 / j3;
                j2 = j4 % j3;
            } else {
                long j5 = j4 >>> 1;
                long j6 = i2 >>> 1;
                long j7 = j5 / j6;
                long j8 = ((j5 % j6) << 1) + (1 & j4);
                j = j7;
                j2 = j8;
                if ((i2 & 1) != 0) {
                    if (j7 <= j8) {
                        j2 = j8 - j7;
                        j = j7;
                    } else if (j7 - j8 <= j3) {
                        j2 = j8 + (j3 - j7);
                        j = j7 - 1;
                    } else {
                        j2 = j8 + ((j3 << 1) - j7);
                        j = j7 - 2;
                    }
                }
            }
            iArr[i] = (int) (ExpandableListView.PACKED_POSITION_VALUE_NULL & j);
        }
    }
}
