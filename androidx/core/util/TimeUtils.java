package androidx.core.util;

import java.io.PrintWriter;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/TimeUtils.class */
public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2566a = new Object();
    private static char[] b = new char[24];

    private TimeUtils() {
    }

    private static int a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    private static int a(long j, int i) {
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (b.length < i) {
            b = new char[i];
        }
        char[] cArr = b;
        int i7 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i7 == 0) {
            while (i - 1 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i7 > 0) {
            c2 = '+';
        } else {
            c2 = '-';
            j = -j;
        }
        int i8 = (int) (j % 1000);
        int floor = (int) Math.floor(j / 1000);
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            i4 = floor / 60;
            i5 = floor - (i4 * 60);
        } else {
            i4 = 0;
            i5 = floor;
        }
        if (i != 0) {
            int a2 = a(i2, 1, false, 0);
            int a3 = a2 + a(i3, 1, a2 > 0, 2);
            int a4 = a3 + a(i4, 1, a3 > 0, 2);
            int a5 = a4 + a(i5, 1, a4 > 0, 2);
            int a6 = a5 + a(i8, 2, true, a5 > 0 ? 3 : 0) + 1;
            int i9 = 0;
            while (true) {
                i6 = i9;
                if (a6 >= i) {
                    break;
                }
                cArr[i9] = ' ';
                i9++;
                a6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c2;
        int i10 = i6 + 1;
        boolean z = i != 0;
        int a7 = a(cArr, i2, 'd', i10, false, 0);
        int a8 = a(cArr, i3, 'h', a7, a7 != i10, z ? 2 : 0);
        int a9 = a(cArr, i4, 'm', a8, a8 != i10, z ? 2 : 0);
        int a10 = a(cArr, i5, 's', a9, a9 != i10, z ? 2 : 0);
        int a11 = a(cArr, i8, 'm', a10, true, (!z || a10 == i10) ? 0 : 3);
        cArr[a11] = 's';
        return a11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r8 != r11) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r6 > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(char[] r5, int r6, char r7, int r8, boolean r9, int r10) {
        /*
            r0 = r9
            if (r0 != 0) goto Lc
            r0 = r8
            r11 = r0
            r0 = r6
            if (r0 <= 0) goto L91
        Lc:
            r0 = r9
            if (r0 == 0) goto L17
            r0 = r10
            r1 = 3
            if (r0 >= r1) goto L1d
        L17:
            r0 = r6
            r1 = 99
            if (r0 <= r1) goto L3c
        L1d:
            r0 = r6
            r1 = 100
            int r0 = r0 / r1
            r12 = r0
            r0 = r5
            r1 = r8
            r2 = r12
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r11 = r0
            r0 = r6
            r1 = r12
            r2 = 100
            int r1 = r1 * r2
            int r0 = r0 - r1
            r6 = r0
            goto L3f
        L3c:
            r0 = r8
            r11 = r0
        L3f:
            r0 = r9
            if (r0 == 0) goto L4a
            r0 = r10
            r1 = 2
            if (r0 >= r1) goto L5d
        L4a:
            r0 = r6
            r1 = 9
            if (r0 > r1) goto L5d
            r0 = r11
            r12 = r0
            r0 = r6
            r10 = r0
            r0 = r8
            r1 = r11
            if (r0 == r1) goto L79
        L5d:
            r0 = r6
            r1 = 10
            int r0 = r0 / r1
            r8 = r0
            r0 = r5
            r1 = r11
            r2 = r8
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r11
            r1 = 1
            int r0 = r0 + r1
            r12 = r0
            r0 = r6
            r1 = r8
            r2 = 10
            int r1 = r1 * r2
            int r0 = r0 - r1
            r10 = r0
        L79:
            r0 = r5
            r1 = r12
            r2 = r10
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r5
            r1 = r6
            r2 = r7
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r11 = r0
        L91:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.util.TimeUtils.a(char[], int, char, int, boolean, int):int");
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (f2566a) {
            printWriter.print(new String(b, 0, a(j, i)));
        }
    }

    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (f2566a) {
            sb.append(b, 0, a(j, 0));
        }
    }
}
