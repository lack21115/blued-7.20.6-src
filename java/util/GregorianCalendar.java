package java.util;

import com.igexin.push.config.c;
import com.sobot.chat.camera.StCameraView;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/util/GregorianCalendar.class */
public class GregorianCalendar extends Calendar {
    public static final int AD = 1;
    public static final int BC = 0;
    private static final long defaultGregorianCutover = -12219292800000L;
    private static final long serialVersionUID = -8125100834729963327L;
    private transient int changeYear;
    private int currentYearSkew;
    private long gregorianCutover;
    private transient int julianSkew;
    private int lastYearSkew;
    static byte[] DaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] DaysInYear = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    private static int[] maximums = {1, 292278994, 11, 53, 6, 31, 366, 7, 6, 1, 11, 23, 59, 59, 999, 50400000, c.L};
    private static int[] minimums = {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -46800000, 0};
    private static int[] leastMaximums = {1, 292269054, 11, 50, 3, 28, 355, 7, 3, 1, 11, 23, 59, 59, 999, 50400000, StCameraView.MEDIA_QUALITY_LOW};

    public GregorianCalendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    public GregorianCalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.gregorianCutover = defaultGregorianCutover;
        this.changeYear = 1582;
        this.julianSkew = (((this.changeYear - 2000) / 400) + julianError()) - ((this.changeYear - 2000) / 100);
        this.currentYearSkew = 10;
        this.lastYearSkew = 0;
        set(i, i2, i3);
    }

    public GregorianCalendar(int i, int i2, int i3, int i4, int i5) {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.gregorianCutover = defaultGregorianCutover;
        this.changeYear = 1582;
        this.julianSkew = (((this.changeYear - 2000) / 400) + julianError()) - ((this.changeYear - 2000) / 100);
        this.currentYearSkew = 10;
        this.lastYearSkew = 0;
        set(i, i2, i3, i4, i5);
    }

    public GregorianCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.gregorianCutover = defaultGregorianCutover;
        this.changeYear = 1582;
        this.julianSkew = (((this.changeYear - 2000) / 400) + julianError()) - ((this.changeYear - 2000) / 100);
        this.currentYearSkew = 10;
        this.lastYearSkew = 0;
        set(i, i2, i3, i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GregorianCalendar(long j) {
        this(false);
        setTimeInMillis(j);
    }

    public GregorianCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
    }

    public GregorianCalendar(TimeZone timeZone) {
        this(timeZone, Locale.getDefault());
    }

    public GregorianCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.gregorianCutover = defaultGregorianCutover;
        this.changeYear = 1582;
        this.julianSkew = (((this.changeYear - 2000) / 400) + julianError()) - ((this.changeYear - 2000) / 100);
        this.currentYearSkew = 10;
        this.lastYearSkew = 0;
        setTimeInMillis(System.currentTimeMillis());
    }

    public GregorianCalendar(boolean z) {
        super(TimeZone.getDefault());
        this.gregorianCutover = defaultGregorianCutover;
        this.changeYear = 1582;
        this.julianSkew = (((this.changeYear - 2000) / 400) + julianError()) - ((this.changeYear - 2000) / 100);
        this.currentYearSkew = 10;
        this.lastYearSkew = 0;
        setFirstDayOfWeek(1);
        setMinimalDaysInFirstWeek(1);
    }

    private int computeYearAndDay(long j, long j2) {
        int i = 1970;
        long j3 = j;
        if (j2 < this.gregorianCutover) {
            j3 = j - this.julianSkew;
            i = 1970;
        }
        while (true) {
            int i2 = (int) (j3 / 365);
            if (i2 == 0) {
                break;
            }
            i += i2;
            j3 = j - daysFromBaseYear(i);
        }
        int i3 = i;
        long j4 = j3;
        if (j3 < 0) {
            i3 = i - 1;
            j4 = j3 + daysInYear(i3);
        }
        this.fields[1] = i3;
        return ((int) j4) + 1;
    }

    private long daysFromBaseYear(long j) {
        if (j < 1970) {
            return j <= ((long) this.changeYear) ? ((j - 1970) * 365) + ((j - 1972) / 4) + this.julianSkew : ((((j - 1970) * 365) + ((j - 1972) / 4)) - ((j - 2000) / 100)) + ((j - 2000) / 400);
        }
        long j2 = ((j - 1970) * 365) + ((j - 1969) / 4);
        return j > ((long) this.changeYear) ? j2 - (((j - 1901) / 100) - ((j - 1601) / 400)) : j == ((long) this.changeYear) ? j2 + this.currentYearSkew : j == ((long) (this.changeYear - 1)) ? j2 + this.lastYearSkew : j2 + this.julianSkew;
    }

    private int daysInMonth() {
        return daysInMonth(isLeapYear(this.fields[1]), this.fields[2]);
    }

    private int daysInMonth(boolean z, int i) {
        return (z && i == 1) ? DaysInMonth[i] + 1 : DaysInMonth[i];
    }

    private int daysInYear(int i) {
        int i2 = isLeapYear(i) ? 366 : 365;
        int i3 = i2;
        if (i == this.changeYear) {
            i3 = i2 - this.currentYearSkew;
        }
        int i4 = i3;
        if (i == this.changeYear - 1) {
            i4 = i3 - this.lastYearSkew;
        }
        return i4;
    }

    private int daysInYear(boolean z, int i) {
        return (!z || i <= 1) ? DaysInYear[i] : DaysInYear[i] + 1;
    }

    private void fullFieldsCalc() {
        int i;
        long j;
        int i2;
        long j2;
        int i3 = (int) (this.time % 86400000);
        long j3 = this.time / 86400000;
        int i4 = i3;
        long j4 = j3;
        if (i3 < 0) {
            i4 = i3 + 86400000;
            j4 = j3 - 1;
        }
        int i5 = i4 + this.fields[15];
        long j5 = j4;
        while (true) {
            long j6 = j5;
            i = i5;
            j = j6;
            if (i5 >= 0) {
                break;
            }
            i5 += 86400000;
            j5 = j6 - 1;
        }
        while (i >= 86400000) {
            i -= 86400000;
            j++;
        }
        int computeYearAndDay = computeYearAndDay(j, this.time + this.fields[15]);
        this.fields[6] = computeYearAndDay;
        int i6 = computeYearAndDay;
        if (this.fields[1] == this.changeYear) {
            i6 = computeYearAndDay;
            if (this.gregorianCutover <= this.time + this.fields[15]) {
                i6 = computeYearAndDay + this.currentYearSkew;
            }
        }
        int i7 = i6 / 32;
        boolean isLeapYear = isLeapYear(this.fields[1]);
        int daysInYear = i6 - daysInYear(isLeapYear, i7);
        int i8 = i7;
        int i9 = daysInYear;
        if (daysInYear > daysInMonth(isLeapYear, i7)) {
            i9 = daysInYear - daysInMonth(isLeapYear, i7);
            i8 = i7 + 1;
        }
        this.fields[7] = mod7(j - 3) + 1;
        int offset = this.fields[1] <= 0 ? 0 : getTimeZone().getOffset(1, this.fields[1], i8, i9, this.fields[7], i);
        int i10 = offset;
        if (this.fields[1] > 0) {
            i10 = offset - this.fields[15];
        }
        this.fields[16] = i10;
        int i11 = i8;
        int i12 = i9;
        int i13 = i;
        long j7 = j;
        boolean z = isLeapYear;
        if (i10 != 0) {
            int i14 = i + i10;
            if (i14 < 0) {
                i2 = i14 + 86400000;
                j2 = j - 1;
            } else {
                i2 = i14;
                j2 = j;
                if (i14 >= 86400000) {
                    i2 = i14 - 86400000;
                    j2 = j + 1;
                }
            }
            i11 = i8;
            i12 = i9;
            i13 = i2;
            j7 = j2;
            z = isLeapYear;
            if (j != j2) {
                int computeYearAndDay2 = computeYearAndDay(j2, (this.time - this.fields[15]) + i10);
                this.fields[6] = computeYearAndDay2;
                int i15 = computeYearAndDay2;
                if (this.fields[1] == this.changeYear) {
                    i15 = computeYearAndDay2;
                    if (this.gregorianCutover <= (this.time - this.fields[15]) + i10) {
                        i15 = computeYearAndDay2 + this.currentYearSkew;
                    }
                }
                int i16 = i15 / 32;
                z = isLeapYear(this.fields[1]);
                int daysInYear2 = i15 - daysInYear(z, i16);
                int i17 = i16;
                int i18 = daysInYear2;
                if (daysInYear2 > daysInMonth(z, i16)) {
                    i18 = daysInYear2 - daysInMonth(z, i16);
                    i17 = i16 + 1;
                }
                this.fields[7] = mod7(j2 - 3) + 1;
                j7 = j2;
                i13 = i2;
                i12 = i18;
                i11 = i17;
            }
        }
        this.fields[14] = i13 % 1000;
        int i19 = i13 / 1000;
        this.fields[13] = i19 % 60;
        int i20 = i19 / 60;
        this.fields[12] = i20 % 60;
        this.fields[11] = (i20 / 60) % 24;
        this.fields[9] = this.fields[11] > 11 ? 1 : 0;
        this.fields[10] = this.fields[11] % 12;
        if (this.fields[1] <= 0) {
            this.fields[0] = 0;
            this.fields[1] = (-this.fields[1]) + 1;
        } else {
            this.fields[0] = 1;
        }
        this.fields[2] = i11;
        this.fields[5] = i12;
        this.fields[8] = ((i12 - 1) / 7) + 1;
        this.fields[4] = (((i12 - 1) + mod7(((j7 - i12) - 2) - (getFirstDayOfWeek() - 1))) / 7) + 1;
        int mod7 = mod7(((j7 - 3) - (this.fields[6] - 1)) - (getFirstDayOfWeek() - 1));
        int i21 = (((this.fields[6] - 1) + mod7) / 7) + (7 - mod7 >= getMinimalDaysInFirstWeek() ? 1 : 0);
        if (i21 == 0) {
            this.fields[3] = 7 - mod7((long) (mod7 - (isLeapYear(this.fields[1] - 1) ? 2 : 1))) >= getMinimalDaysInFirstWeek() ? 53 : 52;
            return;
        }
        if (this.fields[6] < (z ? 367 : 366) - mod7((z ? 2 : 1) + mod7)) {
            this.fields[3] = i21;
            return;
        }
        int[] iArr = this.fields;
        int i22 = i21;
        if (7 - mod7((z ? 2 : 1) + mod7) >= getMinimalDaysInFirstWeek()) {
            i22 = 1;
        }
        iArr[3] = i22;
    }

    private int getOffset(long j) {
        TimeZone timeZone = getTimeZone();
        long j2 = j / 86400000;
        int i = (int) (j % 86400000);
        int i2 = i;
        long j3 = j2;
        if (i < 0) {
            i2 = i + 86400000;
            j3 = j2 - 1;
        }
        long j4 = j3;
        int i3 = 1970;
        long j5 = j4;
        if (j < this.gregorianCutover) {
            j5 = j4 - this.julianSkew;
            i3 = 1970;
        }
        while (true) {
            int i4 = (int) (j5 / 365);
            if (i4 == 0) {
                break;
            }
            i3 += i4;
            j5 = j3 - daysFromBaseYear(i3);
        }
        int i5 = i3;
        long j6 = j5;
        if (j5 < 0) {
            int i6 = i3 - 1;
            long j7 = 365 + j5 + (isLeapYear(i6) ? 1 : 0);
            i5 = i6;
            j6 = j7;
            if (i6 == this.changeYear) {
                i5 = i6;
                j6 = j7;
                if (j < this.gregorianCutover) {
                    j6 = j7 - julianError();
                    i5 = i6;
                }
            }
        }
        if (i5 <= 0) {
            return timeZone.getRawOffset();
        }
        int i7 = ((int) j6) + 1;
        int i8 = i7 / 32;
        boolean isLeapYear = isLeapYear(i5);
        int daysInYear = i7 - daysInYear(isLeapYear, i8);
        int i9 = i8;
        int i10 = daysInYear;
        if (daysInYear > daysInMonth(isLeapYear, i8)) {
            i10 = daysInYear - daysInMonth(isLeapYear, i8);
            i9 = i8 + 1;
        }
        return timeZone.getOffset(1, i5, i9, i10, mod7(j3 - 3) + 1, i2);
    }

    private int julianError() {
        return ((this.changeYear / 100) - (this.changeYear / 400)) - 2;
    }

    private int mod(int i, int i2) {
        int i3 = i % i2;
        int i4 = i3;
        if (i < 0) {
            i4 = i3;
            if (i3 < 0) {
                i4 = i3 + i2;
            }
        }
        return i4;
    }

    private int mod7(long j) {
        int i = (int) (j % 7);
        int i2 = i;
        if (j < 0) {
            i2 = i;
            if (i < 0) {
                i2 = i + 7;
            }
        }
        return i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setGregorianChange(new Date(this.gregorianCutover));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    @Override // java.util.Calendar
    public void add(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= 15) {
            throw new IllegalArgumentException();
        }
        if (i == 0) {
            complete();
            if (this.fields[0] == 1) {
                if (i2 >= 0) {
                    return;
                }
                set(0, 0);
            } else if (i2 <= 0) {
                return;
            } else {
                set(0, 1);
            }
            complete();
        } else if (i == 1 || i == 2) {
            complete();
            int i4 = i2;
            if (i == 2) {
                int i5 = this.fields[2] + i2;
                if (i5 < 0) {
                    i3 = (i5 - 11) / 12;
                    i5 = (i5 % 12) + 12;
                } else {
                    i3 = i5 / 12;
                }
                set(2, i5 % 12);
                i4 = i3;
            }
            set(1, this.fields[1] + i4);
            int daysInMonth = daysInMonth(isLeapYear(this.fields[1]), this.fields[2]);
            if (this.fields[5] > daysInMonth) {
                set(5, daysInMonth);
            }
            complete();
        } else {
            long j = 0;
            getTimeInMillis();
            switch (i) {
                case 3:
                case 4:
                case 8:
                    j = 604800000;
                    break;
                case 5:
                case 6:
                case 7:
                    j = 86400000;
                    break;
                case 9:
                    j = 43200000;
                    break;
                case 10:
                case 11:
                    this.time += i2 * 3600000;
                    break;
                case 12:
                    this.time += i2 * 60000;
                    break;
                case 13:
                    this.time += i2 * 1000;
                    break;
                case 14:
                    this.time += i2;
                    break;
            }
            if (j == 0) {
                this.areFieldsSet = false;
                complete();
                return;
            }
            long j2 = i2 * j;
            int rawOffset = getTimeZone().getRawOffset();
            int offset = getOffset(this.time + rawOffset);
            int offset2 = getOffset(this.time + rawOffset + j2);
            int i6 = offset - offset2;
            long j3 = j2;
            if (getOffset(this.time + rawOffset + j2 + i6) == offset2) {
                j3 = j2 + i6;
            }
            this.time += j3;
            this.areFieldsSet = false;
            complete();
        }
    }

    @Override // java.util.Calendar
    protected void computeFields() {
        TimeZone timeZone = getTimeZone();
        int dSTSavings = timeZone.inDaylightTime(new Date(this.time)) ? timeZone.getDSTSavings() : 0;
        int rawOffset = timeZone.getRawOffset();
        this.fields[16] = dSTSavings;
        this.fields[15] = rawOffset;
        fullFieldsCalc();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 17) {
                return;
            }
            this.isSet[i2] = true;
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x0376, code lost:
        if (r11.lastDateFieldSet == 3) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0409, code lost:
        if (r11.lastDateFieldSet == 8) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0734, code lost:
        if (r11.fields[6] > ((isLeapYear(r13) ? 1 : 0) + 365)) goto L271;
     */
    @Override // java.util.Calendar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void computeTime() {
        /*
            Method dump skipped, instructions count: 1931
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.GregorianCalendar.computeTime():void");
    }

    @Override // java.util.Calendar
    public boolean equals(Object obj) {
        boolean z;
        if (obj instanceof GregorianCalendar) {
            z = true;
            if (obj != this) {
                if (!super.equals(obj)) {
                    return false;
                }
                z = true;
                if (this.gregorianCutover != ((GregorianCalendar) obj).gregorianCutover) {
                    return false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // java.util.Calendar
    public int getActualMaximum(int i) {
        int i2 = maximums[i];
        if (i2 == leastMaximums[i]) {
            return i2;
        }
        complete();
        long j = this.time;
        int i3 = 0;
        switch (i) {
            case 1:
                GregorianCalendar gregorianCalendar = (GregorianCalendar) clone();
                if (get(0) == 1) {
                    gregorianCalendar.setTimeInMillis(Long.MAX_VALUE);
                } else {
                    gregorianCalendar.setTimeInMillis(Long.MIN_VALUE);
                }
                int i4 = gregorianCalendar.get(1);
                gregorianCalendar.set(1, get(1));
                i3 = i4;
                if (gregorianCalendar.before(this)) {
                    i3 = i4 - 1;
                    break;
                }
                break;
            case 2:
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 3:
                set(5, 31);
                set(2, 11);
                int i5 = get(3);
                i3 = i5;
                if (i5 == 1) {
                    set(5, 24);
                    i3 = get(3);
                }
                this.areFieldsSet = false;
                break;
            case 4:
                set(5, daysInMonth());
                i3 = get(4);
                this.areFieldsSet = false;
                break;
            case 5:
                return daysInMonth();
            case 6:
                return daysInYear(this.fields[1]);
            case 8:
                i3 = get(8) + ((daysInMonth() - get(5)) / 7);
                break;
            case 16:
                i3 = getMaximum(16);
                break;
            default:
                i3 = 0;
                break;
        }
        this.time = j;
        return i3;
    }

    @Override // java.util.Calendar
    public int getActualMinimum(int i) {
        return getMinimum(i);
    }

    @Override // java.util.Calendar
    public int getGreatestMinimum(int i) {
        return minimums[i];
    }

    public final Date getGregorianChange() {
        return new Date(this.gregorianCutover);
    }

    @Override // java.util.Calendar
    public int getLeastMaximum(int i) {
        if (this.gregorianCutover == defaultGregorianCutover || i != 3) {
            return leastMaximums[i];
        }
        long j = this.time;
        setTimeInMillis(this.gregorianCutover);
        int actualMaximum = getActualMaximum(i);
        setTimeInMillis(j);
        return actualMaximum;
    }

    @Override // java.util.Calendar
    public int getMaximum(int i) {
        return maximums[i];
    }

    @Override // java.util.Calendar
    public int getMinimum(int i) {
        return minimums[i];
    }

    @Override // java.util.Calendar
    public int hashCode() {
        return super.hashCode() + (((int) (this.gregorianCutover >>> 32)) ^ ((int) this.gregorianCutover));
    }

    public boolean isLeapYear(int i) {
        if (i <= this.changeYear) {
            return i % 4 == 0;
        } else if (i % 4 == 0) {
            return i % 100 != 0 || i % 400 == 0;
        } else {
            return false;
        }
    }

    @Override // java.util.Calendar
    public void roll(int i, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (i < 0 || i >= 15) {
            throw new IllegalArgumentException();
        }
        complete();
        switch (i) {
            case 0:
            case 2:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                set(i, mod(this.fields[i] + i2, maximums[i] + 1));
                if (i == 2 && this.fields[5] > daysInMonth()) {
                    set(5, daysInMonth());
                    i3 = -1;
                    break;
                } else {
                    i3 = -1;
                    if (i == 9) {
                        this.lastTimeFieldSet = 10;
                        i3 = -1;
                        break;
                    }
                }
                break;
            case 1:
                i3 = maximums[i];
                break;
            case 3:
                int daysInYear = daysInYear(this.fields[1]);
                int mod7 = mod7((this.fields[7] - this.fields[6]) - (getFirstDayOfWeek() - 1));
                int i4 = (((daysInYear - 1) + mod7) / 7) + 1;
                int mod = mod((this.fields[i] - 1) + i2, i4) + 1;
                if (mod != i4) {
                    if (mod != 1) {
                        set(i, mod);
                        i3 = -1;
                        break;
                    } else if (((((this.fields[6] - (((this.fields[6] - 1) / 7) * 7)) - 1) + mod7) / 7) + 1 <= 1) {
                        set(i, mod);
                        i3 = -1;
                        break;
                    } else {
                        set(i, 1);
                        i3 = -1;
                        break;
                    }
                } else {
                    int i5 = (mod - this.fields[i]) * 7;
                    if (this.fields[6] > i5 && this.fields[6] + i5 > daysInYear) {
                        set(i, 1);
                        i3 = -1;
                        break;
                    } else {
                        set(i, mod - 1);
                        i3 = -1;
                        break;
                    }
                }
                break;
            case 4:
                int daysInMonth = daysInMonth();
                int mod72 = mod7((this.fields[7] - this.fields[5]) - (getFirstDayOfWeek() - 1));
                int i6 = (((daysInMonth - 1) + mod72) / 7) + 1;
                int mod2 = mod((this.fields[i] - 1) + i2, i6) + 1;
                if (mod2 != i6) {
                    if (mod2 != 1) {
                        set(i, mod2);
                        i3 = -1;
                        break;
                    } else if (((((this.fields[5] - (((this.fields[5] - 1) / 7) * 7)) - 1) + mod72) / 7) + 1 <= 1) {
                        set(i, mod2);
                        i3 = -1;
                        break;
                    } else {
                        set(5, 1);
                        i3 = -1;
                        break;
                    }
                } else if (this.fields[5] + ((mod2 - this.fields[i]) * 7) <= daysInMonth) {
                    set(i, mod2);
                    i3 = -1;
                    break;
                } else {
                    set(5, daysInMonth);
                    i3 = -1;
                    break;
                }
            case 5:
                i3 = daysInMonth();
                break;
            case 6:
                i3 = daysInYear(this.fields[1]);
                break;
            case 7:
                i3 = maximums[i];
                this.lastDateFieldSet = 4;
                break;
            case 8:
                i3 = (((this.fields[5] + (((daysInMonth() - this.fields[5]) / 7) * 7)) - 1) / 7) + 1;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            set(i, mod((this.fields[i] - 1) + i2, i3) + 1);
        }
        complete();
    }

    @Override // java.util.Calendar
    public void roll(int i, boolean z) {
        roll(i, z ? 1 : -1);
    }

    public void setGregorianChange(Date date) {
        this.gregorianCutover = date.getTime();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.setTime(date);
        this.changeYear = gregorianCalendar.get(1);
        if (gregorianCalendar.get(0) == 0) {
            this.changeYear = 1 - this.changeYear;
        }
        this.julianSkew = (((this.changeYear - 2000) / 400) + julianError()) - ((this.changeYear - 2000) / 100);
        int i = gregorianCalendar.get(6);
        if (i < this.julianSkew) {
            this.currentYearSkew = i - 1;
            this.lastYearSkew = (this.julianSkew - i) + 1;
            return;
        }
        this.lastYearSkew = 0;
        this.currentYearSkew = this.julianSkew;
    }
}
