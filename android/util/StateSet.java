package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/StateSet.class */
public class StateSet {
    public static final int[] WILD_CARD = new int[0];
    public static final int[] NOTHING = {0};

    public static String dump(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            switch (iArr[i2]) {
                case 16842908:
                    sb.append("F ");
                    break;
                case 16842909:
                    sb.append("W ");
                    break;
                case 16842910:
                    sb.append("E ");
                    break;
                case 16842913:
                    sb.append("S ");
                    break;
                case 16842919:
                    sb.append("P ");
                    break;
            }
            i = i2 + 1;
        }
    }

    public static boolean isWildCard(int[] iArr) {
        boolean z = false;
        if (iArr.length == 0 || iArr[0] == 0) {
            z = true;
        }
        return z;
    }

    public static boolean stateSetMatches(int[] iArr, int i) {
        int i2;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length || (i2 = iArr[i4]) == 0) {
                return true;
            }
            if (i2 > 0) {
                if (i != i2) {
                    return false;
                }
            } else if (i == (-i2)) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (isWildCard(r3) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean stateSetMatches(int[] r3, int[] r4) {
        /*
            r0 = 0
            r14 = r0
            r0 = r4
            if (r0 != 0) goto L1c
            r0 = r3
            if (r0 == 0) goto L16
            r0 = r14
            r13 = r0
            r0 = r3
            boolean r0 = isWildCard(r0)
            if (r0 == 0) goto L19
        L16:
            r0 = 1
            r13 = r0
        L19:
            r0 = r13
            return r0
        L1c:
            r0 = r3
            int r0 = r0.length
            r11 = r0
            r0 = r4
            int r0 = r0.length
            r12 = r0
            r0 = 0
            r5 = r0
        L26:
            r0 = r5
            r1 = r11
            if (r0 >= r1) goto La3
            r0 = r3
            r1 = r5
            r0 = r0[r1]
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L38
            r0 = 1
            return r0
        L38:
            r0 = r7
            if (r0 <= 0) goto L7b
            r0 = 1
            r6 = r0
        L3f:
            r0 = 0
            r10 = r0
            r0 = 0
            r8 = r0
        L45:
            r0 = r10
            r9 = r0
            r0 = r8
            r1 = r12
            if (r0 >= r1) goto L67
            r0 = r4
            r1 = r8
            r0 = r0[r1]
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L85
            r0 = r14
            r13 = r0
            r0 = r6
            if (r0 != 0) goto L19
            r0 = r10
            r9 = r0
        L67:
            r0 = r6
            if (r0 == 0) goto L74
            r0 = r14
            r13 = r0
            r0 = r9
            if (r0 == 0) goto L19
        L74:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L26
        L7b:
            r0 = 0
            r6 = r0
            r0 = r7
            int r0 = -r0
            r7 = r0
            goto L3f
        L85:
            r0 = r9
            r1 = r7
            if (r0 != r1) goto L9a
            r0 = r14
            r13 = r0
            r0 = r6
            if (r0 == 0) goto L19
            r0 = 1
            r9 = r0
            goto L67
        L9a:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L45
        La3:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.StateSet.stateSetMatches(int[], int[]):boolean");
    }

    public static int[] trimStateSet(int[] iArr, int i) {
        if (iArr.length == i) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }
}
