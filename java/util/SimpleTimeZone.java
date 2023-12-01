package java.util;

import com.huawei.openalliance.ad.constant.bc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamField;

/* loaded from: source-2895416-dex2jar.jar:java/util/SimpleTimeZone.class */
public class SimpleTimeZone extends TimeZone {
    private static final int DOM_MODE = 1;
    private static final int DOW_GE_DOM_MODE = 3;
    private static final int DOW_IN_MONTH_MODE = 2;
    private static final int DOW_LE_DOM_MODE = 4;
    public static final int STANDARD_TIME = 1;
    public static final int UTC_TIME = 2;
    public static final int WALL_TIME = 0;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("dstSavings", Integer.TYPE), new ObjectStreamField("endDay", Integer.TYPE), new ObjectStreamField("endDayOfWeek", Integer.TYPE), new ObjectStreamField(bc.e.Z, Integer.TYPE), new ObjectStreamField("endMonth", Integer.TYPE), new ObjectStreamField("endTime", Integer.TYPE), new ObjectStreamField("monthLength", byte[].class), new ObjectStreamField("rawOffset", Integer.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE), new ObjectStreamField("startDay", Integer.TYPE), new ObjectStreamField("startDayOfWeek", Integer.TYPE), new ObjectStreamField("startMode", Integer.TYPE), new ObjectStreamField("startMonth", Integer.TYPE), new ObjectStreamField("startTime", Integer.TYPE), new ObjectStreamField("startYear", Integer.TYPE), new ObjectStreamField("useDaylight", Boolean.TYPE)};
    private static final long serialVersionUID = -403250971215465050L;
    private int dstSavings;
    private int endDay;
    private int endDayOfWeek;
    private int endMode;
    private int endMonth;
    private int endTime;
    private int rawOffset;
    private int startDay;
    private int startDayOfWeek;
    private int startMode;
    private int startMonth;
    private int startTime;
    private int startYear;
    private boolean useDaylight;

    public SimpleTimeZone(int i, String str) {
        this.dstSavings = 3600000;
        setID(str);
        this.rawOffset = i;
    }

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this(i, str, i2, i3, i4, i5, i6, i7, i8, i9, 3600000);
    }

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this(i, str);
        if (i10 <= 0) {
            throw new IllegalArgumentException("Invalid daylightSavings: " + i10);
        }
        this.dstSavings = i10;
        this.startMonth = i2;
        this.startDay = i3;
        this.startDayOfWeek = i4;
        this.startTime = i5;
        setStartMode();
        this.endMonth = i6;
        this.endDay = i7;
        this.endDayOfWeek = i8;
        this.endTime = i9;
        setEndMode();
    }

    public SimpleTimeZone(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this(i, str, i2, i3, i4, i5, i7, i8, i9, i10, i12);
        this.startMode = i6;
        this.endMode = i11;
    }

    private void checkDay(int i, int i2) {
        if (i2 <= 0 || i2 > GregorianCalendar.DaysInMonth[i]) {
            throw new IllegalArgumentException("Invalid day of month: " + i2);
        }
    }

    private void checkRange(int i, int i2, int i3) {
        if (i < 0 || i > 11) {
            throw new IllegalArgumentException("Invalid month: " + i);
        }
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("Invalid day of week: " + i2);
        }
        if (i3 < 0 || i3 >= 86400000) {
            throw new IllegalArgumentException("Invalid time: " + i3);
        }
    }

    private boolean isLeapYear(int i) {
        if (i <= 1582) {
            return i % 4 == 0;
        } else if (i % 4 == 0) {
            return i % 100 != 0 || i % 400 == 0;
        } else {
            return false;
        }
    }

    private int mod7(int i) {
        int i2 = i % 7;
        int i3 = i2;
        if (i < 0) {
            i3 = i2;
            if (i2 < 0) {
                i3 = i2 + 7;
            }
        }
        return i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.rawOffset = readFields.get("rawOffset", 0);
        this.useDaylight = readFields.get("useDaylight", false);
        if (this.useDaylight) {
            this.endMonth = readFields.get("endMonth", 0);
            this.endTime = readFields.get("endTime", 0);
            this.startMonth = readFields.get("startMonth", 0);
            this.startTime = readFields.get("startTime", 0);
            this.startYear = readFields.get("startYear", 0);
        }
        if (readFields.get("serialVersionOnStream", 0) == 0) {
            if (this.useDaylight) {
                this.endMode = 2;
                this.startMode = 2;
                this.endDay = readFields.get("endDay", 0);
                this.endDayOfWeek = readFields.get("endDayOfWeek", 0) - 1;
                this.startDay = readFields.get("startDay", 0);
                this.startDayOfWeek = readFields.get("startDayOfWeek", 0) - 1;
                return;
            }
            return;
        }
        this.dstSavings = readFields.get("dstSavings", 0);
        if (this.useDaylight) {
            this.endMode = readFields.get(bc.e.Z, 0);
            this.startMode = readFields.get("startMode", 0);
            int readInt = objectInputStream.readInt();
            byte[] bArr = new byte[readInt];
            objectInputStream.readFully(bArr);
            if (readInt >= 4) {
                this.startDay = bArr[0];
                this.startDayOfWeek = bArr[1];
                if (this.startMode != 1) {
                    this.startDayOfWeek--;
                }
                this.endDay = bArr[2];
                this.endDayOfWeek = bArr[3];
                if (this.endMode != 1) {
                    this.endDayOfWeek--;
                }
            }
        }
    }

    private void setEndMode() {
        if (this.endDayOfWeek == 0) {
            this.endMode = 1;
        } else if (this.endDayOfWeek < 0) {
            this.endDayOfWeek = -this.endDayOfWeek;
            if (this.endDay < 0) {
                this.endDay = -this.endDay;
                this.endMode = 4;
            } else {
                this.endMode = 3;
            }
        } else {
            this.endMode = 2;
        }
        this.useDaylight = (this.startDay == 0 || this.endDay == 0) ? false : true;
        if (this.endDay != 0) {
            checkRange(this.endMonth, this.endMode == 1 ? 1 : this.endDayOfWeek, this.endTime);
            if (this.endMode != 2) {
                checkDay(this.endMonth, this.endDay);
            } else if (this.endDay < -5 || this.endDay > 5) {
                throw new IllegalArgumentException("Day of week in month: " + this.endDay);
            }
        }
        if (this.endMode != 1) {
            this.endDayOfWeek--;
        }
    }

    private void setStartMode() {
        if (this.startDayOfWeek == 0) {
            this.startMode = 1;
        } else if (this.startDayOfWeek < 0) {
            this.startDayOfWeek = -this.startDayOfWeek;
            if (this.startDay < 0) {
                this.startDay = -this.startDay;
                this.startMode = 4;
            } else {
                this.startMode = 3;
            }
        } else {
            this.startMode = 2;
        }
        this.useDaylight = (this.startDay == 0 || this.endDay == 0) ? false : true;
        if (this.startDay != 0) {
            checkRange(this.startMonth, this.startMode == 1 ? 1 : this.startDayOfWeek, this.startTime);
            if (this.startMode != 2) {
                checkDay(this.startMonth, this.startDay);
            } else if (this.startDay < -5 || this.startDay > 5) {
                throw new IllegalArgumentException("Day of week in month: " + this.startDay);
            }
        }
        if (this.startMode != 1) {
            this.startDayOfWeek--;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0053, code lost:
        if (r6.endMode != 2) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeObject(java.io.ObjectOutputStream r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.SimpleTimeZone.writeObject(java.io.ObjectOutputStream):void");
    }

    @Override // java.util.TimeZone
    public Object clone() {
        return (SimpleTimeZone) super.clone();
    }

    public boolean equals(Object obj) {
        if (obj instanceof SimpleTimeZone) {
            SimpleTimeZone simpleTimeZone = (SimpleTimeZone) obj;
            if (getID().equals(simpleTimeZone.getID()) && this.rawOffset == simpleTimeZone.rawOffset && this.useDaylight == simpleTimeZone.useDaylight) {
                if (this.useDaylight) {
                    return this.startYear == simpleTimeZone.startYear && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startMode == simpleTimeZone.startMode && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endMode == simpleTimeZone.endMode && this.dstSavings == simpleTimeZone.dstSavings;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.TimeZone
    public int getDSTSavings() {
        if (this.useDaylight) {
            return this.dstSavings;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
        if (r12 < r6.startTime) goto L38;
     */
    @Override // java.util.TimeZone
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getOffset(int r7, int r8, int r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 877
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.SimpleTimeZone.getOffset(int, int, int, int, int, int):int");
    }

    @Override // java.util.TimeZone
    public int getOffset(long j) {
        if (useDaylightTime()) {
            int[] timeToFields = Grego.timeToFields(this.rawOffset + j, null);
            return getOffset(1, timeToFields[0], timeToFields[1], timeToFields[2], timeToFields[3], timeToFields[5]);
        }
        return this.rawOffset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.rawOffset;
    }

    @Override // java.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        boolean z = true;
        if (timeZone instanceof SimpleTimeZone) {
            SimpleTimeZone simpleTimeZone = (SimpleTimeZone) timeZone;
            if (this.useDaylight == simpleTimeZone.useDaylight) {
                if (this.useDaylight) {
                    return this.rawOffset == simpleTimeZone.rawOffset && this.dstSavings == simpleTimeZone.dstSavings && this.startYear == simpleTimeZone.startYear && this.startMonth == simpleTimeZone.startMonth && this.startDay == simpleTimeZone.startDay && this.startMode == simpleTimeZone.startMode && this.startDayOfWeek == simpleTimeZone.startDayOfWeek && this.startTime == simpleTimeZone.startTime && this.endMonth == simpleTimeZone.endMonth && this.endDay == simpleTimeZone.endDay && this.endDayOfWeek == simpleTimeZone.endDayOfWeek && this.endTime == simpleTimeZone.endTime && this.endMode == simpleTimeZone.endMode;
                }
                if (this.rawOffset != simpleTimeZone.rawOffset) {
                    z = false;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i;
        synchronized (this) {
            int hashCode = getID().hashCode() + this.rawOffset;
            i = hashCode;
            if (this.useDaylight) {
                int i2 = this.startYear;
                int i3 = this.startMonth;
                int i4 = this.startDay;
                int i5 = this.startDayOfWeek;
                int i6 = this.startTime;
                int i7 = this.startMode;
                int i8 = this.endMonth;
                int i9 = this.endDay;
                int i10 = this.endDayOfWeek;
                int i11 = this.endTime;
                i = hashCode + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + this.endMode + this.dstSavings;
            }
        }
        return i;
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return useDaylightTime() && getOffset(date.getTime()) != getRawOffset();
    }

    public void setDSTSavings(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("milliseconds <= 0: " + i);
        }
        this.dstSavings = i;
    }

    public void setEndRule(int i, int i2, int i3) {
        this.endMonth = i;
        this.endDay = i2;
        this.endDayOfWeek = 0;
        this.endTime = i3;
        setEndMode();
    }

    public void setEndRule(int i, int i2, int i3, int i4) {
        this.endMonth = i;
        this.endDay = i2;
        this.endDayOfWeek = i3;
        this.endTime = i4;
        setEndMode();
    }

    public void setEndRule(int i, int i2, int i3, int i4, boolean z) {
        this.endMonth = i;
        if (!z) {
            i2 = -i2;
        }
        this.endDay = i2;
        this.endDayOfWeek = -i3;
        this.endTime = i4;
        setEndMode();
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i) {
        this.rawOffset = i;
    }

    public void setStartRule(int i, int i2, int i3) {
        this.startMonth = i;
        this.startDay = i2;
        this.startDayOfWeek = 0;
        this.startTime = i3;
        setStartMode();
    }

    public void setStartRule(int i, int i2, int i3, int i4) {
        this.startMonth = i;
        this.startDay = i2;
        this.startDayOfWeek = i3;
        this.startTime = i4;
        setStartMode();
    }

    public void setStartRule(int i, int i2, int i3, int i4, boolean z) {
        this.startMonth = i;
        if (!z) {
            i2 = -i2;
        }
        this.startDay = i2;
        this.startDayOfWeek = -i3;
        this.startTime = i4;
        setStartMode();
    }

    public void setStartYear(int i) {
        this.startYear = i;
        this.useDaylight = true;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(getClass().getName()).append("[id=").append(getID()).append(",offset=").append(this.rawOffset).append(",dstSavings=").append(this.dstSavings).append(",useDaylight=").append(this.useDaylight).append(",startYear=").append(this.startYear).append(",startMode=").append(this.startMode).append(",startMonth=").append(this.startMonth).append(",startDay=").append(this.startDay).append(",startDayOfWeek=").append((!this.useDaylight || this.startMode == 1) ? 0 : this.startDayOfWeek + 1).append(",startTime=").append(this.startTime).append(",endMode=").append(this.endMode).append(",endMonth=").append(this.endMonth).append(",endDay=").append(this.endDay).append(",endDayOfWeek=");
        int i = 0;
        if (this.useDaylight) {
            i = 0;
            if (this.endMode != 1) {
                i = this.endDayOfWeek + 1;
            }
        }
        return append.append(i).append(",endTime=").append(this.endTime).append("]").toString();
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return this.useDaylight;
    }
}
