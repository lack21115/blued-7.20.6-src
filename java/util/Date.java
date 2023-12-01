package java.util;

import android.text.format.Time;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/util/Date.class */
public class Date implements Serializable, Cloneable, Comparable<Date> {
    private static final int CREATION_YEAR = new Date().getYear();
    private static final long serialVersionUID = 7523967970034938905L;
    private transient long milliseconds;

    public Date() {
        this(System.currentTimeMillis());
    }

    @Deprecated
    public Date(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(false);
        gregorianCalendar.set(i + 1900, i2, i3);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public Date(int i, int i2, int i3, int i4, int i5) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(false);
        gregorianCalendar.set(i + 1900, i2, i3, i4, i5);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public Date(int i, int i2, int i3, int i4, int i5, int i6) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(false);
        gregorianCalendar.set(i + 1900, i2, i3, i4, i5, i6);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    public Date(long j) {
        this.milliseconds = j;
    }

    @Deprecated
    public Date(String str) {
        this.milliseconds = parse(str);
    }

    @Deprecated
    public static long UTC(int i, int i2, int i3, int i4, int i5, int i6) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(false);
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.set(i + 1900, i2, i3, i4, i5, i6);
        return gregorianCalendar.getTimeInMillis();
    }

    private static void appendTwoDigits(StringBuilder sb, int i) {
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    private static int parse(String str, String[] strArr) {
        int length = strArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            if (str.regionMatches(true, 0, strArr[i], 0, length2)) {
                return i;
            }
        }
        return -1;
    }

    @Deprecated
    public static long parse(String str) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        char c2;
        int i9;
        boolean z2;
        int i10;
        int i11;
        char c3;
        if (str == null) {
            throw new IllegalArgumentException("The string argument is null");
        }
        char c4 = 0;
        int i12 = 0;
        int i13 = 0;
        int length = str.length();
        boolean z3 = false;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        boolean z4 = false;
        StringBuilder sb = new StringBuilder();
        while (i13 <= length) {
            char charAt = i13 < length ? str.charAt(i13) : '\r';
            int i22 = i13 + 1;
            int i23 = i12;
            if (charAt == '(') {
                i23 = i12 + 1;
            }
            int i24 = i23;
            char c5 = charAt;
            if (i23 > 0) {
                int i25 = i23;
                if (charAt == ')') {
                    i25 = i23 - 1;
                }
                i12 = i25;
                i13 = i22;
                if (i25 == 0) {
                    c5 = ' ';
                    i24 = i25;
                } else {
                    continue;
                }
            }
            if (('a' <= c5 && c5 <= 'z') || ('A' <= c5 && c5 <= 'Z')) {
                z = true;
            } else if ('0' > c5 || c5 > '9') {
                z = false;
                if (!Character.isSpace(c5)) {
                    z = false;
                    if (",+-:/".indexOf(c5) == -1) {
                        throw parseError(str);
                    }
                }
            } else {
                z = true;
            }
            if (!z3 || z) {
                i3 = i15;
                i4 = i16;
                i5 = i17;
                i6 = i18;
                i7 = i19;
                i8 = i21;
                i13 = i22;
                c2 = c4;
                i9 = i14;
                z2 = z4;
                i10 = i20;
                if (z3) {
                    i3 = i15;
                    i4 = i16;
                    i5 = i17;
                    i6 = i18;
                    i7 = i19;
                    i8 = i21;
                    i13 = i22;
                    c2 = c4;
                    i9 = i14;
                    z2 = z4;
                    i10 = i20;
                    if (!z) {
                        String upperCase = sb.toString().toUpperCase(Locale.US);
                        sb.setLength(0);
                        if (upperCase.length() == 1) {
                            throw parseError(str);
                        }
                        if (upperCase.equals("AM")) {
                            if (i17 != 12) {
                                if (i17 >= 1) {
                                    i3 = i15;
                                    i4 = i16;
                                    i5 = i17;
                                    i6 = i18;
                                    i7 = i19;
                                    i8 = i21;
                                    i13 = i22;
                                    c2 = c4;
                                    i9 = i14;
                                    z2 = z4;
                                    i10 = i20;
                                    if (i17 > 12) {
                                    }
                                }
                                throw parseError(str);
                            }
                            i5 = 0;
                            i3 = i15;
                            i4 = i16;
                            i6 = i18;
                            i7 = i19;
                            i8 = i21;
                            i13 = i22;
                            c2 = c4;
                            i9 = i14;
                            z2 = z4;
                            i10 = i20;
                        } else if (upperCase.equals("PM")) {
                            if (i17 != 12) {
                                if (i17 >= 1) {
                                    i11 = i17;
                                    if (i17 > 12) {
                                    }
                                }
                                throw parseError(str);
                            }
                            i11 = 0;
                            i5 = i11 + 12;
                            i3 = i15;
                            i4 = i16;
                            i6 = i18;
                            i7 = i19;
                            i8 = i21;
                            i13 = i22;
                            c2 = c4;
                            i9 = i14;
                            z2 = z4;
                            i10 = i20;
                        } else {
                            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.US);
                            String[] weekdays = dateFormatSymbols.getWeekdays();
                            String[] months = dateFormatSymbols.getMonths();
                            i3 = i15;
                            i4 = i16;
                            i5 = i17;
                            i6 = i18;
                            i7 = i19;
                            i8 = i21;
                            i13 = i22;
                            c2 = c4;
                            i9 = i14;
                            z2 = z4;
                            i10 = i20;
                            if (parse(upperCase, weekdays) == -1) {
                                i3 = i15;
                                if (i15 == -1) {
                                    int parse = parse(upperCase, months);
                                    i3 = parse;
                                    i4 = i16;
                                    i5 = i17;
                                    i6 = i18;
                                    i7 = i19;
                                    i8 = i21;
                                    i13 = i22;
                                    c2 = c4;
                                    i9 = i14;
                                    z2 = z4;
                                    i10 = i20;
                                    if (parse == -1) {
                                        i3 = parse;
                                    }
                                }
                                if (upperCase.equals("GMT") || upperCase.equals("UT") || upperCase.equals(Time.TIMEZONE_UTC)) {
                                    z2 = true;
                                    i10 = 0;
                                    i4 = i16;
                                    i5 = i17;
                                    i6 = i18;
                                    i7 = i19;
                                    i8 = i21;
                                    i13 = i22;
                                    c2 = c4;
                                    i9 = i14;
                                } else {
                                    i10 = zone(upperCase);
                                    if (i10 == 0) {
                                        throw parseError(str);
                                    }
                                    z2 = true;
                                    i4 = i16;
                                    i5 = i17;
                                    i6 = i18;
                                    i7 = i19;
                                    i8 = i21;
                                    i13 = i22;
                                    c2 = c4;
                                    i9 = i14;
                                }
                            }
                        }
                    }
                }
            } else {
                int parseInt = Integer.parseInt(sb.toString());
                sb.setLength(0);
                if (c4 == '+' || c4 == '-') {
                    if (i20 != 0) {
                        throw parseError(str);
                    }
                    z2 = true;
                    i13 = i22;
                    if (c5 == ':') {
                        i21 = c4 == '-' ? -Integer.parseInt(str.substring(i22, i22 + 2)) : Integer.parseInt(str.substring(i22, i22 + 2));
                        i13 = i22 + 2;
                    }
                    i10 = c4 == '-' ? -parseInt : parseInt;
                    c2 = 0;
                    i9 = i14;
                    i8 = i21;
                    i7 = i19;
                    i6 = i18;
                    i5 = i17;
                    i4 = i16;
                    i3 = i15;
                } else if (parseInt >= 70) {
                    if (i14 != -1 || (!Character.isSpace(c5) && c5 != ',' && c5 != '/' && c5 != '\r')) {
                        throw parseError(str);
                    }
                    i9 = parseInt;
                    i3 = i15;
                    i4 = i16;
                    i5 = i17;
                    i6 = i18;
                    i7 = i19;
                    i8 = i21;
                    i13 = i22;
                    c2 = c4;
                    z2 = z4;
                    i10 = i20;
                } else if (c5 == ':') {
                    if (i17 == -1) {
                        i5 = parseInt;
                        i3 = i15;
                        i4 = i16;
                        i6 = i18;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    } else if (i18 != -1) {
                        throw parseError(str);
                    } else {
                        i6 = parseInt;
                        i3 = i15;
                        i4 = i16;
                        i5 = i17;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    }
                } else if (c5 == '/') {
                    if (i15 == -1) {
                        i3 = parseInt - 1;
                        i4 = i16;
                        i5 = i17;
                        i6 = i18;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    } else if (i16 != -1) {
                        throw parseError(str);
                    } else {
                        i4 = parseInt;
                        i3 = i15;
                        i5 = i17;
                        i6 = i18;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    }
                } else if (Character.isSpace(c5) || c5 == ',' || c5 == '-' || c5 == '\r') {
                    if (i17 != -1 && i18 == -1) {
                        i6 = parseInt;
                        i3 = i15;
                        i4 = i16;
                        i5 = i17;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    } else if (i18 != -1 && i19 == -1) {
                        i7 = parseInt;
                        i3 = i15;
                        i4 = i16;
                        i5 = i17;
                        i6 = i18;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    } else if (i16 == -1) {
                        i4 = parseInt;
                        i3 = i15;
                        i5 = i17;
                        i6 = i18;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        i9 = i14;
                        z2 = z4;
                        i10 = i20;
                    } else if (i14 != -1) {
                        throw parseError(str);
                    } else {
                        i9 = parseInt;
                        i3 = i15;
                        i4 = i16;
                        i5 = i17;
                        i6 = i18;
                        i7 = i19;
                        i8 = i21;
                        i13 = i22;
                        c2 = c4;
                        z2 = z4;
                        i10 = i20;
                    }
                } else if (i14 != -1 || i15 == -1 || i16 == -1) {
                    throw parseError(str);
                } else {
                    i9 = parseInt;
                    i3 = i15;
                    i4 = i16;
                    i5 = i17;
                    i6 = i18;
                    i7 = i19;
                    i8 = i21;
                    i13 = i22;
                    c2 = c4;
                    z2 = z4;
                    i10 = i20;
                }
            }
            if (c5 == '+' || (i9 != -1 && c5 == '-')) {
                c3 = c5;
            } else {
                c3 = c2;
                if (!Character.isSpace(c5)) {
                    c3 = c2;
                    if (c5 != ',') {
                        c3 = c2;
                        if (!z) {
                            c3 = 0;
                        }
                    }
                }
            }
            if (z || z) {
                sb.append(c5);
            }
            i15 = i3;
            i16 = i4;
            i17 = i5;
            i18 = i6;
            i19 = i7;
            i12 = i24;
            i21 = i8;
            c4 = c3;
            z3 = z;
            i14 = i9;
            z4 = z2;
            i20 = i10;
        }
        if (i14 == -1 || i15 == -1 || i16 == -1) {
            throw parseError(str);
        }
        int i26 = i17;
        if (i17 == -1) {
            i26 = 0;
        }
        int i27 = i18;
        if (i18 == -1) {
            i27 = 0;
        }
        int i28 = i19;
        if (i19 == -1) {
            i28 = 0;
        }
        if (i14 < CREATION_YEAR - 80) {
            i = i14 + 2000;
        } else {
            i = i14;
            if (i14 < 100) {
                i = i14 + 1900;
            }
        }
        int i29 = i27 - i21;
        if (z4) {
            if (i20 >= 24 || i20 <= -24) {
                i2 = i26 - (i20 / 100);
                i29 -= i20 % 100;
            } else {
                i2 = i26 - i20;
            }
            return UTC(i - 1900, i15, i16, i2, i29, i28);
        }
        return new Date(i - 1900, i15, i16, i26, i29, i28).getTime();
    }

    private static IllegalArgumentException parseError(String str) {
        throw new IllegalArgumentException("Parse error: " + str);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setTime(objectInputStream.readLong());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(getTime());
    }

    private static int zone(String str) {
        if (str.equals("EST")) {
            return -5;
        }
        if (str.equals("EDT")) {
            return -4;
        }
        if (str.equals("CST")) {
            return -6;
        }
        if (str.equals("CDT")) {
            return -5;
        }
        if (str.equals("MST")) {
            return -7;
        }
        if (str.equals("MDT")) {
            return -6;
        }
        if (str.equals("PST")) {
            return -8;
        }
        return str.equals("PDT") ? -7 : 0;
    }

    public boolean after(Date date) {
        return this.milliseconds > date.milliseconds;
    }

    public boolean before(Date date) {
        return this.milliseconds < date.milliseconds;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Date date) {
        if (this.milliseconds < date.milliseconds) {
            return -1;
        }
        return this.milliseconds == date.milliseconds ? 0 : 1;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Date) && this.milliseconds == ((Date) obj).milliseconds;
        }
        return true;
    }

    @Deprecated
    public int getDate() {
        return new GregorianCalendar(this.milliseconds).get(5);
    }

    @Deprecated
    public int getDay() {
        return new GregorianCalendar(this.milliseconds).get(7) - 1;
    }

    @Deprecated
    public int getHours() {
        return new GregorianCalendar(this.milliseconds).get(11);
    }

    @Deprecated
    public int getMinutes() {
        return new GregorianCalendar(this.milliseconds).get(12);
    }

    @Deprecated
    public int getMonth() {
        return new GregorianCalendar(this.milliseconds).get(2);
    }

    @Deprecated
    public int getSeconds() {
        return new GregorianCalendar(this.milliseconds).get(13);
    }

    public long getTime() {
        return this.milliseconds;
    }

    @Deprecated
    public int getTimezoneOffset() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        return (-(gregorianCalendar.get(15) + gregorianCalendar.get(16))) / 60000;
    }

    @Deprecated
    public int getYear() {
        return new GregorianCalendar(this.milliseconds).get(1) - 1900;
    }

    public int hashCode() {
        return ((int) (this.milliseconds >>> 32)) ^ ((int) this.milliseconds);
    }

    @Deprecated
    public void setDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        gregorianCalendar.set(5, i);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public void setHours(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        gregorianCalendar.set(11, i);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public void setMinutes(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        gregorianCalendar.set(12, i);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public void setMonth(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        gregorianCalendar.set(2, i);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public void setSeconds(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        gregorianCalendar.set(13, i);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    public void setTime(long j) {
        this.milliseconds = j;
    }

    @Deprecated
    public void setYear(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        gregorianCalendar.set(1, i + 1900);
        this.milliseconds = gregorianCalendar.getTimeInMillis();
    }

    @Deprecated
    public String toGMTString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        simpleDateFormat.setTimeZone(timeZone);
        new GregorianCalendar(timeZone).setTimeInMillis(this.milliseconds);
        return simpleDateFormat.format(this);
    }

    @Deprecated
    public String toLocaleString() {
        return DateFormat.getDateTimeInstance().format(this);
    }

    public String toString() {
        LocaleData localeData = LocaleData.get(Locale.US);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.milliseconds);
        TimeZone timeZone = gregorianCalendar.getTimeZone();
        StringBuilder sb = new StringBuilder();
        sb.append(localeData.shortWeekdayNames[gregorianCalendar.get(7)]);
        sb.append(' ');
        sb.append(localeData.shortMonthNames[gregorianCalendar.get(2)]);
        sb.append(' ');
        appendTwoDigits(sb, gregorianCalendar.get(5));
        sb.append(' ');
        appendTwoDigits(sb, gregorianCalendar.get(11));
        sb.append(':');
        appendTwoDigits(sb, gregorianCalendar.get(12));
        sb.append(':');
        appendTwoDigits(sb, gregorianCalendar.get(13));
        sb.append(' ');
        sb.append(timeZone.getDisplayName(timeZone.inDaylightTime(this), 0));
        sb.append(' ');
        sb.append(gregorianCalendar.get(1));
        return sb.toString();
    }
}
