package java.sql;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Timestamp.class */
public class Timestamp extends java.util.Date {
    private static final String PADDING = "000000000";
    private static final String TIME_FORMAT_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.*";
    private static final long serialVersionUID = 2745179027874758501L;
    private int nanos;

    @Deprecated
    public Timestamp(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        super(i, i2, i3, i4, i5, i6);
        if (i7 < 0 || i7 > 999999999) {
            throw new IllegalArgumentException("ns out of range: " + i7);
        }
        this.nanos = i7;
    }

    public Timestamp(long j) {
        super(j);
        setTimeImpl(j);
    }

    private static IllegalArgumentException badTimestampString(String str) {
        return new IllegalArgumentException("Timestamp format must be yyyy-MM-dd HH:mm:ss.fffffffff; was '" + str + "'");
    }

    private void format(int i, int i2, StringBuilder sb) {
        String valueOf = String.valueOf(i);
        if (i2 - valueOf.length() > 0) {
            sb.append(PADDING.substring(0, i2 - valueOf.length()));
        }
        sb.append(valueOf);
    }

    private void setTimeImpl(long j) {
        int i = (int) (j % 1000);
        long j2 = j - i;
        int i2 = i;
        long j3 = j2;
        if (i < 0) {
            j3 = j2 - 1000;
            i2 = i + 1000;
        }
        super.setTime(j3);
        setNanos(1000000 * i2);
    }

    public static Timestamp valueOf(String str) throws IllegalArgumentException {
        int i;
        if (str == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        String trim = str.trim();
        if (Pattern.matches(TIME_FORMAT_REGEX, trim)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                java.util.Date parse = simpleDateFormat.parse(trim, parsePosition);
                if (parse == null) {
                    throw badTimestampString(trim);
                }
                int index = parsePosition.getIndex();
                int length = trim.length() - index;
                if (length == 0) {
                    i = 0;
                } else if (length < 2 || length > 10 || trim.charAt(index) != '.') {
                    throw badTimestampString(trim);
                } else {
                    try {
                        int parsePositiveInt = Integer.parsePositiveInt(trim.substring(index + 1));
                        i = parsePositiveInt;
                        if (parsePositiveInt != 0) {
                            int i2 = length - 1;
                            while (true) {
                                int i3 = i2;
                                i = parsePositiveInt;
                                if (i3 >= 9) {
                                    break;
                                }
                                parsePositiveInt *= 10;
                                i2 = i3 + 1;
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw badTimestampString(trim);
                    }
                }
                Timestamp timestamp = new Timestamp(parse.getTime());
                timestamp.setNanos(i);
                return timestamp;
            } catch (Exception e2) {
                throw badTimestampString(trim);
            }
        }
        throw badTimestampString(trim);
    }

    public boolean after(Timestamp timestamp) {
        long time = getTime();
        long time2 = timestamp.getTime();
        if (time > time2) {
            return true;
        }
        return time >= time2 && getNanos() > timestamp.getNanos();
    }

    public boolean before(Timestamp timestamp) {
        long time = getTime();
        long time2 = timestamp.getTime();
        if (time < time2) {
            return true;
        }
        return time <= time2 && getNanos() < timestamp.getNanos();
    }

    public int compareTo(Timestamp timestamp) {
        int compareTo = super.compareTo((java.util.Date) timestamp);
        int i = compareTo;
        if (compareTo == 0) {
            int nanos = getNanos();
            int nanos2 = timestamp.getNanos();
            if (nanos <= nanos2) {
                return nanos == nanos2 ? 0 : -1;
            }
            i = 1;
        }
        return i;
    }

    @Override // java.util.Date, java.lang.Comparable
    public int compareTo(java.util.Date date) throws ClassCastException {
        return compareTo((Timestamp) date);
    }

    @Override // java.util.Date
    public boolean equals(Object obj) {
        if (obj instanceof Timestamp) {
            return equals((Timestamp) obj);
        }
        return false;
    }

    public boolean equals(Timestamp timestamp) {
        return timestamp != null && getTime() == timestamp.getTime() && getNanos() == timestamp.getNanos();
    }

    public int getNanos() {
        return this.nanos;
    }

    @Override // java.util.Date
    public long getTime() {
        return super.getTime() + (this.nanos / 1000000);
    }

    public void setNanos(int i) throws IllegalArgumentException {
        if (i < 0 || i > 999999999) {
            throw new IllegalArgumentException("Value out of range");
        }
        this.nanos = i;
    }

    @Override // java.util.Date
    public void setTime(long j) {
        setTimeImpl(j);
    }

    @Override // java.util.Date
    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        format(getYear() + 1900, 4, sb);
        sb.append('-');
        format(getMonth() + 1, 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);
        sb.append(' ');
        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);
        sb.append('.');
        if (this.nanos == 0) {
            sb.append('0');
        } else {
            format(this.nanos, 9, sb);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
