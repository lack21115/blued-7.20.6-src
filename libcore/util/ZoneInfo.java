package libcore.util;

import android.text.format.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import libcore.io.BufferIterator;

/* loaded from: source-2895416-dex2jar.jar:libcore/util/ZoneInfo.class */
public final class ZoneInfo extends TimeZone {
    private static final long MILLISECONDS_PER_400_YEARS = 12622780800000L;
    private static final long MILLISECONDS_PER_DAY = 86400000;
    private static final long UNIX_OFFSET = 62167219200000L;
    private final int mDstSavings;
    private final int mEarliestRawOffset;
    private final byte[] mIsDsts;
    private final int[] mOffsets;
    private int mRawOffset;
    private final int[] mTransitions;
    private final byte[] mTypes;
    private final boolean mUseDst;
    private static final int[] NORMAL = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    private static final int[] LEAP = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:libcore/util/ZoneInfo$CheckedArithmeticException.class */
    public static class CheckedArithmeticException extends Exception {
        private CheckedArithmeticException() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:libcore/util/ZoneInfo$OffsetInterval.class */
    public static class OffsetInterval {
        private final int endWallTimeSeconds;
        private final int isDst;
        private final int startWallTimeSeconds;
        private final int totalOffsetSeconds;

        private OffsetInterval(int i, int i2, int i3, int i4) {
            this.startWallTimeSeconds = i;
            this.endWallTimeSeconds = i2;
            this.isDst = i3;
            this.totalOffsetSeconds = i4;
        }

        public static OffsetInterval create(ZoneInfo zoneInfo, int i) throws CheckedArithmeticException {
            if (i < -1 || i >= zoneInfo.mTransitions.length) {
                return null;
            }
            int i2 = zoneInfo.mRawOffset / 1000;
            if (i == -1) {
                return new OffsetInterval(Integer.MIN_VALUE, ZoneInfo.checkedAdd(zoneInfo.mTransitions[0], i2), 0, i2);
            }
            byte b = zoneInfo.mTypes[i];
            int i3 = zoneInfo.mOffsets[b] + i2;
            return new OffsetInterval(ZoneInfo.checkedAdd(zoneInfo.mTransitions[i], i3), i == zoneInfo.mTransitions.length - 1 ? Integer.MAX_VALUE : ZoneInfo.checkedAdd(zoneInfo.mTransitions[i + 1], i3), zoneInfo.mIsDsts[b], i3);
        }

        public boolean containsWallTime(long j) {
            return j >= ((long) this.startWallTimeSeconds) && j < ((long) this.endWallTimeSeconds);
        }

        public long getEndWallTimeSeconds() {
            return this.endWallTimeSeconds;
        }

        public int getIsDst() {
            return this.isDst;
        }

        public long getStartWallTimeSeconds() {
            return this.startWallTimeSeconds;
        }

        public int getTotalOffsetSeconds() {
            return this.totalOffsetSeconds;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:libcore/util/ZoneInfo$WallTime.class */
    public static class WallTime {
        private final GregorianCalendar calendar = createGregorianCalendar();
        private int gmtOffsetSeconds;
        private int hour;
        private int isDst;
        private int minute;
        private int month;
        private int monthDay;
        private int second;
        private int weekDay;
        private int year;
        private int yearDay;

        public WallTime() {
            this.calendar.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        }

        private void copyFieldsFromCalendar() {
            this.year = this.calendar.get(1);
            this.month = this.calendar.get(2);
            this.monthDay = this.calendar.get(5);
            this.hour = this.calendar.get(11);
            this.minute = this.calendar.get(12);
            this.second = this.calendar.get(13);
            this.weekDay = this.calendar.get(7) - 1;
            this.yearDay = this.calendar.get(6) - 1;
        }

        private void copyFieldsToCalendar() {
            this.calendar.set(1, this.year);
            this.calendar.set(2, this.month);
            this.calendar.set(5, this.monthDay);
            this.calendar.set(11, this.hour);
            this.calendar.set(12, this.minute);
            this.calendar.set(13, this.second);
        }

        private static GregorianCalendar createGregorianCalendar() {
            return new GregorianCalendar(false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
            r0 = r0.getTotalOffsetSeconds();
            r0 = libcore.util.ZoneInfo.checkedSubtract(r10, r0);
            copyFieldsFromCalendar();
            r7.isDst = r0.getIsDst();
            r7.gmtOffsetSeconds = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00fa, code lost:
            return java.lang.Integer.valueOf(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
            if (r15 == false) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Integer doWallTimeSearch(libcore.util.ZoneInfo r8, int r9, int r10, boolean r11) throws libcore.util.ZoneInfo.CheckedArithmeticException {
            /*
                Method dump skipped, instructions count: 400
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: libcore.util.ZoneInfo.WallTime.doWallTimeSearch(libcore.util.ZoneInfo, int, int, boolean):java.lang.Integer");
        }

        private static int findTransitionIndex(ZoneInfo zoneInfo, int i) {
            int binarySearch = Arrays.binarySearch(zoneInfo.mTransitions, i);
            int i2 = binarySearch;
            if (binarySearch < 0) {
                i2 = (binarySearch ^ (-1)) - 1;
            }
            return i2;
        }

        private static int[] getOffsetsOfType(ZoneInfo zoneInfo, int i, int i2) {
            int[] iArr = new int[zoneInfo.mOffsets.length + 1];
            boolean[] zArr = new boolean[zoneInfo.mOffsets.length];
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            int i4 = 0;
            while (true) {
                int i5 = i3 * (-1);
                i3 = i5;
                if (i5 >= 0) {
                    i3 = i5 + 1;
                }
                int i6 = i + i3;
                if (i3 < 0 && i6 < -1) {
                    z2 = true;
                } else if (i3 > 0 && i6 >= zoneInfo.mTypes.length) {
                    z = true;
                } else if (i6 != -1) {
                    byte b = zoneInfo.mTypes[i6];
                    if (!zArr[b]) {
                        if (zoneInfo.mIsDsts[b] == i2) {
                            iArr[i4] = zoneInfo.mOffsets[b];
                            i4++;
                        }
                        zArr[b] = true;
                    }
                } else if (i2 == 0) {
                    iArr[i4] = 0;
                    i4++;
                }
                if (z && z2) {
                    int[] iArr2 = new int[i4];
                    System.arraycopy(iArr, 0, iArr2, 0, i4);
                    return iArr2;
                }
            }
        }

        private Integer tryOffsetAdjustments(ZoneInfo zoneInfo, int i, OffsetInterval offsetInterval, int i2, int i3) throws CheckedArithmeticException {
            int[] offsetsOfType = getOffsetsOfType(zoneInfo, i2, i3);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= offsetsOfType.length) {
                    return null;
                }
                int i6 = zoneInfo.mRawOffset / 1000;
                int i7 = offsetsOfType[i5];
                int totalOffsetSeconds = offsetInterval.getTotalOffsetSeconds();
                int checkedAdd = ZoneInfo.checkedAdd(i, totalOffsetSeconds - (i6 + i7));
                if (offsetInterval.containsWallTime(checkedAdd)) {
                    int checkedSubtract = ZoneInfo.checkedSubtract(checkedAdd, totalOffsetSeconds);
                    this.calendar.setTimeInMillis(checkedAdd * 1000);
                    copyFieldsFromCalendar();
                    this.isDst = offsetInterval.getIsDst();
                    this.gmtOffsetSeconds = totalOffsetSeconds;
                    return Integer.valueOf(checkedSubtract);
                }
                i4 = i5 + 1;
            }
        }

        public int getGmtOffset() {
            return this.gmtOffsetSeconds;
        }

        public int getHour() {
            return this.hour;
        }

        public int getIsDst() {
            return this.isDst;
        }

        public int getMinute() {
            return this.minute;
        }

        public int getMonth() {
            return this.month;
        }

        public int getMonthDay() {
            return this.monthDay;
        }

        public int getSecond() {
            return this.second;
        }

        public int getWeekDay() {
            return this.weekDay;
        }

        public int getYear() {
            return this.year;
        }

        public int getYearDay() {
            return this.yearDay;
        }

        public void localtime(int i, ZoneInfo zoneInfo) {
            byte b;
            try {
                int i2 = zoneInfo.mRawOffset / 1000;
                if (zoneInfo.mTransitions.length == 0) {
                    b = 0;
                } else {
                    int findTransitionIndex = findTransitionIndex(zoneInfo, i);
                    if (findTransitionIndex < 0) {
                        b = 0;
                    } else {
                        byte b2 = zoneInfo.mTypes[findTransitionIndex];
                        i2 += zoneInfo.mOffsets[b2];
                        b = zoneInfo.mIsDsts[b2];
                    }
                }
                this.calendar.setTimeInMillis(ZoneInfo.checkedAdd(i, i2) * 1000);
                copyFieldsFromCalendar();
                this.isDst = b;
                this.gmtOffsetSeconds = i2;
            } catch (CheckedArithmeticException e) {
            }
        }

        public int mktime(ZoneInfo zoneInfo) {
            int i = 1;
            if (this.isDst > 0) {
                this.isDst = 1;
            } else if (this.isDst < 0) {
                this.isDst = -1;
                i = -1;
            } else {
                i = 0;
            }
            this.isDst = i;
            copyFieldsToCalendar();
            long timeInMillis = this.calendar.getTimeInMillis() / 1000;
            if (-2147483648L > timeInMillis || timeInMillis > 2147483647L) {
                return -1;
            }
            int i2 = (int) timeInMillis;
            try {
                int i3 = zoneInfo.mRawOffset / 1000;
                int checkedSubtract = ZoneInfo.checkedSubtract(i2, i3);
                if (zoneInfo.mTransitions.length == 0) {
                    if (this.isDst <= 0) {
                        copyFieldsFromCalendar();
                        this.isDst = 0;
                        this.gmtOffsetSeconds = i3;
                        return checkedSubtract;
                    }
                    return -1;
                }
                int findTransitionIndex = findTransitionIndex(zoneInfo, checkedSubtract);
                if (this.isDst < 0) {
                    Integer doWallTimeSearch = doWallTimeSearch(zoneInfo, findTransitionIndex, i2, true);
                    if (doWallTimeSearch != null) {
                        return doWallTimeSearch.intValue();
                    }
                    return -1;
                }
                Integer doWallTimeSearch2 = doWallTimeSearch(zoneInfo, findTransitionIndex, i2, true);
                Integer num = doWallTimeSearch2;
                if (doWallTimeSearch2 == null) {
                    num = doWallTimeSearch(zoneInfo, findTransitionIndex, i2, false);
                }
                Integer num2 = num;
                if (num == null) {
                    num2 = -1;
                }
                return num2.intValue();
            } catch (CheckedArithmeticException e) {
                return -1;
            }
        }

        public void setGmtOffset(int i) {
            this.gmtOffsetSeconds = i;
        }

        public void setHour(int i) {
            this.hour = i;
        }

        public void setIsDst(int i) {
            this.isDst = i;
        }

        public void setMinute(int i) {
            this.minute = i;
        }

        public void setMonth(int i) {
            this.month = i;
        }

        public void setMonthDay(int i) {
            this.monthDay = i;
        }

        public void setSecond(int i) {
            this.second = i;
        }

        public void setWeekDay(int i) {
            this.weekDay = i;
        }

        public void setYear(int i) {
            this.year = i;
        }

        public void setYearDay(int i) {
            this.yearDay = i;
        }
    }

    private ZoneInfo(String str, int[] iArr, byte[] bArr, int[] iArr2, byte[] bArr2) {
        int i;
        boolean z;
        this.mTransitions = iArr;
        this.mTypes = bArr;
        this.mIsDsts = bArr2;
        setID(str);
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        int length = this.mTransitions.length - 1;
        while (true) {
            if ((!z2 || !z3) && length >= 0) {
                int i4 = this.mTypes[length] & 255;
                boolean z4 = z2;
                int i5 = i2;
                if (!z2) {
                    z4 = z2;
                    i5 = i2;
                    if (this.mIsDsts[i4] == 0) {
                        z4 = true;
                        i5 = length;
                    }
                }
                boolean z5 = z3;
                int i6 = i3;
                if (!z3) {
                    z5 = z3;
                    i6 = i3;
                    if (this.mIsDsts[i4] != 0) {
                        z5 = true;
                        i6 = length;
                    }
                }
                length--;
                z3 = z5;
                z2 = z4;
                i3 = i6;
                i2 = i5;
            }
        }
        if (i2 >= this.mTypes.length) {
            this.mRawOffset = iArr2[0];
        } else {
            this.mRawOffset = iArr2[this.mTypes[i2] & 255];
        }
        if (i3 >= this.mTypes.length) {
            this.mDstSavings = 0;
        } else {
            this.mDstSavings = Math.abs(iArr2[this.mTypes[i2] & 255] - iArr2[this.mTypes[i3] & 255]) * 1000;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            i = -1;
            if (i8 >= this.mTransitions.length) {
                break;
            } else if (this.mIsDsts[this.mTypes[i8] & 255] == 0) {
                i = i8;
                break;
            } else {
                i7 = i8 + 1;
            }
        }
        int i9 = i != -1 ? iArr2[this.mTypes[i] & 255] : this.mRawOffset;
        this.mOffsets = iArr2;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= this.mOffsets.length) {
                break;
            }
            int[] iArr3 = this.mOffsets;
            iArr3[i11] = iArr3[i11] - this.mRawOffset;
            i10 = i11 + 1;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int length2 = this.mTransitions.length;
        while (true) {
            int i12 = length2 - 1;
            z = false;
            if (i12 < 0) {
                break;
            }
            z = false;
            if (this.mTransitions[i12] < currentTimeMillis) {
                break;
            } else if (this.mIsDsts[this.mTypes[i12]] > 0) {
                z = true;
                break;
            } else {
                length2 = i12;
            }
        }
        this.mUseDst = z;
        this.mRawOffset *= 1000;
        this.mEarliestRawOffset = i9 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int checkedAdd(int i, int i2) throws CheckedArithmeticException {
        long j = i + i2;
        if (j != ((int) j)) {
            throw new CheckedArithmeticException();
        }
        return (int) j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int checkedSubtract(int i, int i2) throws CheckedArithmeticException {
        long j = i - i2;
        if (j != ((int) j)) {
            throw new CheckedArithmeticException();
        }
        return (int) j;
    }

    public static ZoneInfo makeTimeZone(String str, BufferIterator bufferIterator) {
        if (bufferIterator.readInt() != 1415211366) {
            return null;
        }
        bufferIterator.skip(28);
        int readInt = bufferIterator.readInt();
        int readInt2 = bufferIterator.readInt();
        bufferIterator.skip(4);
        int[] iArr = new int[readInt];
        bufferIterator.readIntArray(iArr, 0, iArr.length);
        byte[] bArr = new byte[readInt];
        bufferIterator.readByteArray(bArr, 0, bArr.length);
        int[] iArr2 = new int[readInt2];
        byte[] bArr2 = new byte[readInt2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt2) {
                return new ZoneInfo(str, iArr, bArr, iArr2, bArr2);
            }
            iArr2[i2] = bufferIterator.readInt();
            bArr2[i2] = bufferIterator.readByte();
            bufferIterator.skip(1);
            i = i2 + 1;
        }
    }

    @Override // java.util.TimeZone
    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ZoneInfo) {
            ZoneInfo zoneInfo = (ZoneInfo) obj;
            return getID().equals(zoneInfo.getID()) && hasSameRules(zoneInfo);
        }
        return false;
    }

    @Override // java.util.TimeZone
    public int getDSTSavings() {
        if (this.mUseDst) {
            return this.mDstSavings;
        }
        return 0;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i2 % 400;
        long j = ((i2 / 400) * MILLISECONDS_PER_400_YEARS) + (i7 * 31536000000L) + (((i7 + 3) / 4) * 86400000);
        long j2 = j;
        if (i7 > 0) {
            j2 = j - (((i7 - 1) / 100) * 86400000);
        }
        return getOffset(((((j2 + ((i7 == 0 || (i7 % 4 == 0 && i7 % 100 != 0) ? LEAP : NORMAL)[i3] * 86400000)) + ((i4 - 1) * 86400000)) + i6) - this.mRawOffset) - UNIX_OFFSET);
    }

    @Override // java.util.TimeZone
    public int getOffset(long j) {
        int binarySearch = Arrays.binarySearch(this.mTransitions, (int) (j / 1000));
        int i = binarySearch;
        if (binarySearch < 0) {
            int i2 = (binarySearch ^ (-1)) - 1;
            i = i2;
            if (i2 < 0) {
                return this.mEarliestRawOffset;
            }
        }
        return this.mRawOffset + (this.mOffsets[this.mTypes[i] & 255] * 1000);
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.mRawOffset;
    }

    @Override // java.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        boolean z = true;
        if (timeZone instanceof ZoneInfo) {
            ZoneInfo zoneInfo = (ZoneInfo) timeZone;
            if (this.mUseDst == zoneInfo.mUseDst) {
                if (this.mUseDst) {
                    return this.mRawOffset == zoneInfo.mRawOffset && Arrays.equals(this.mOffsets, zoneInfo.mOffsets) && Arrays.equals(this.mIsDsts, zoneInfo.mIsDsts) && Arrays.equals(this.mTypes, zoneInfo.mTypes) && Arrays.equals(this.mTransitions, zoneInfo.mTransitions);
                }
                if (this.mRawOffset != zoneInfo.mRawOffset) {
                    z = false;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getID().hashCode();
        int hashCode2 = Arrays.hashCode(this.mOffsets);
        int hashCode3 = Arrays.hashCode(this.mIsDsts);
        int i = this.mRawOffset;
        int hashCode4 = Arrays.hashCode(this.mTransitions);
        return ((((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + Arrays.hashCode(this.mTypes)) * 31) + (this.mUseDst ? 1231 : 1237);
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        boolean z = true;
        int binarySearch = Arrays.binarySearch(this.mTransitions, (int) (date.getTime() / 1000));
        int i = binarySearch;
        if (binarySearch < 0) {
            int i2 = (binarySearch ^ (-1)) - 1;
            i = i2;
            if (i2 < 0) {
                return false;
            }
        }
        if (this.mIsDsts[this.mTypes[i] & 255] != 1) {
            z = false;
        }
        return z;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i) {
        this.mRawOffset = i;
    }

    public String toString() {
        return getClass().getName() + "[id=\"" + getID() + "\",mRawOffset=" + this.mRawOffset + ",mEarliestRawOffset=" + this.mEarliestRawOffset + ",mUseDst=" + this.mUseDst + ",mDstSavings=" + this.mDstSavings + ",transitions=" + this.mTransitions.length + "]";
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return this.mUseDst;
    }
}
