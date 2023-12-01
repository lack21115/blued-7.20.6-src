package java.util;

import com.android.ims.ImsReasonInfo;
import java.net.HttpURLConnection;

/* loaded from: source-2895416-dex2jar.jar:java/util/Grego.class */
class Grego {
    private static final int JULIAN_1970_CE = 2440588;
    private static final int JULIAN_1_CE = 1721426;
    public static final long MAX_MILLIS = 183882168921600000L;
    public static final int MILLIS_PER_DAY = 86400000;
    public static final int MILLIS_PER_HOUR = 3600000;
    public static final int MILLIS_PER_MINUTE = 60000;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final long MIN_MILLIS = -184303902528000000L;
    private static final int[] MONTH_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_BEFORE = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, ImsReasonInfo.CODE_SIP_NOT_SUPPORTED, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, ImsReasonInfo.CODE_SIP_REQUEST_TIMEOUT};

    Grego() {
    }

    public static int dayOfWeek(long j) {
        long[] jArr = new long[1];
        floorDivide(5 + j, 7L, jArr);
        int i = (int) jArr[0];
        int i2 = i;
        if (i == 0) {
            i2 = 7;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r9.length < 5) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] dayToFields(long r7, int[] r9) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Grego.dayToFields(long, int[]):int[]");
    }

    public static long fieldsToDay(int i, int i2, int i3) {
        int i4 = i - 1;
        return ((((((((i4 * 365) + floorDivide(i4, 4L)) + 1721423) + floorDivide(i4, 400L)) - floorDivide(i4, 100L)) + 2) + DAYS_BEFORE[(isLeapYear(i) ? 12 : 0) + i2]) + i3) - 2440588;
    }

    public static long floorDivide(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    private static long floorDivide(long j, long j2, long[] jArr) {
        if (j >= 0) {
            jArr[0] = j % j2;
            return j / j2;
        }
        long j3 = ((j + 1) / j2) - 1;
        jArr[0] = j - (j3 * j2);
        return j3;
    }

    public static int getDayOfWeekInMonth(int i, int i2, int i3) {
        int i4;
        int i5 = (i3 + 6) / 7;
        if (i5 == 4) {
            i4 = i5;
            if (i3 + 7 > monthLength(i, i2)) {
                i4 = -1;
            }
        } else {
            i4 = i5;
            if (i5 == 5) {
                return -1;
            }
        }
        return i4;
    }

    public static final boolean isLeapYear(int i) {
        if ((i & 3) == 0) {
            return i % 100 != 0 || i % HttpURLConnection.HTTP_BAD_REQUEST == 0;
        }
        return false;
    }

    public static final int monthLength(int i, int i2) {
        return MONTH_LENGTH[(isLeapYear(i) ? 12 : 0) + i2];
    }

    public static final int previousMonthLength(int i, int i2) {
        if (i2 > 0) {
            return monthLength(i, i2 - 1);
        }
        return 31;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r8.length < 6) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] timeToFields(long r6, int[] r8) {
        /*
            r0 = r8
            if (r0 == 0) goto Ld
            r0 = r8
            r9 = r0
            r0 = r8
            int r0 = r0.length
            r1 = 6
            if (r0 >= r1) goto L12
        Ld:
            r0 = 6
            int[] r0 = new int[r0]
            r9 = r0
        L12:
            r0 = 1
            long[] r0 = new long[r0]
            r8 = r0
            r0 = r6
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
            r2 = r8
            long r0 = floorDivide(r0, r1, r2)
            r1 = r9
            int[] r0 = dayToFields(r0, r1)
            r0 = r9
            r1 = 5
            r2 = r8
            r3 = 0
            r2 = r2[r3]
            int r2 = (int) r2
            r0[r1] = r2
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Grego.timeToFields(long, int[]):int[]");
    }
}
