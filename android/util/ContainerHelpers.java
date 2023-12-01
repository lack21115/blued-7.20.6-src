package android.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/util/ContainerHelpers.class */
public class ContainerHelpers {
    ContainerHelpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int binarySearch(int[] iArr, int i, int i2) {
        int i3;
        int i4 = i - 1;
        int i5 = 0;
        int i6 = i4;
        while (true) {
            if (i5 > i6) {
                i3 = i5 ^ (-1);
                break;
            }
            int i7 = (i5 + i6) >>> 1;
            int i8 = iArr[i7];
            if (i8 >= i2) {
                i3 = i7;
                if (i8 <= i2) {
                    break;
                }
                i6 = i7 - 1;
            } else {
                i5 = i7 + 1;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int binarySearch(long[] jArr, int i, long j) {
        int i2;
        int i3 = i - 1;
        int i4 = 0;
        int i5 = i3;
        while (true) {
            if (i4 > i5) {
                i2 = i4 ^ (-1);
                break;
            }
            int i6 = (i4 + i5) >>> 1;
            long j2 = jArr[i6];
            if (j2 >= j) {
                i2 = i6;
                if (j2 <= j) {
                    break;
                }
                i5 = i6 - 1;
            } else {
                i4 = i6 + 1;
            }
        }
        return i2;
    }
}
