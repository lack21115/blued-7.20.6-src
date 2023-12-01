package javax.xml.datatype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.namespace.QName;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/datatype/Duration.class */
public abstract class Duration {
    private static long getCalendarTimeInMillis(Calendar calendar) {
        return calendar.getTime().getTime();
    }

    private int getFieldValueAsInt(DatatypeConstants.Field field) {
        Number field2 = getField(field);
        if (field2 != null) {
            return field2.intValue();
        }
        return 0;
    }

    private String toString(BigDecimal bigDecimal) {
        StringBuilder sb;
        String bigInteger = bigDecimal.unscaledValue().toString();
        int scale = bigDecimal.scale();
        if (scale == 0) {
            return bigInteger;
        }
        int length = bigInteger.length() - scale;
        if (length == 0) {
            return "0." + bigInteger;
        }
        if (length > 0) {
            sb = new StringBuilder(bigInteger);
            sb.insert(length, '.');
        } else {
            sb = new StringBuilder((3 - length) + bigInteger.length());
            sb.append("0.");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= (-length)) {
                    break;
                }
                sb.append('0');
                i = i2 + 1;
            }
            sb.append(bigInteger);
        }
        return sb.toString();
    }

    public abstract Duration add(Duration duration);

    public abstract void addTo(Calendar calendar);

    public void addTo(Date date) {
        if (date == null) {
            throw new NullPointerException("date == null");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        addTo(gregorianCalendar);
        date.setTime(getCalendarTimeInMillis(gregorianCalendar));
    }

    public abstract int compare(Duration duration);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof Duration) && compare((Duration) obj) == 0;
    }

    public int getDays() {
        return getFieldValueAsInt(DatatypeConstants.DAYS);
    }

    public abstract Number getField(DatatypeConstants.Field field);

    public int getHours() {
        return getFieldValueAsInt(DatatypeConstants.HOURS);
    }

    public int getMinutes() {
        return getFieldValueAsInt(DatatypeConstants.MINUTES);
    }

    public int getMonths() {
        return getFieldValueAsInt(DatatypeConstants.MONTHS);
    }

    public int getSeconds() {
        return getFieldValueAsInt(DatatypeConstants.SECONDS);
    }

    public abstract int getSign();

    public long getTimeInMillis(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        addTo(calendar2);
        return getCalendarTimeInMillis(calendar2) - getCalendarTimeInMillis(calendar);
    }

    public long getTimeInMillis(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        addTo(gregorianCalendar);
        return getCalendarTimeInMillis(gregorianCalendar) - date.getTime();
    }

    public QName getXMLSchemaType() {
        boolean isSet = isSet(DatatypeConstants.YEARS);
        boolean isSet2 = isSet(DatatypeConstants.MONTHS);
        boolean isSet3 = isSet(DatatypeConstants.DAYS);
        boolean isSet4 = isSet(DatatypeConstants.HOURS);
        boolean isSet5 = isSet(DatatypeConstants.MINUTES);
        boolean isSet6 = isSet(DatatypeConstants.SECONDS);
        if (isSet && isSet2 && isSet3 && isSet4 && isSet5 && isSet6) {
            return DatatypeConstants.DURATION;
        }
        if (!isSet && !isSet2 && isSet3 && isSet4 && isSet5 && isSet6) {
            return DatatypeConstants.DURATION_DAYTIME;
        }
        if (!isSet || !isSet2 || isSet3 || isSet4 || isSet5 || isSet6) {
            throw new IllegalStateException("javax.xml.datatype.Duration#getXMLSchemaType(): this Duration does not match one of the XML Schema date/time datatypes: year set = " + isSet + " month set = " + isSet2 + " day set = " + isSet3 + " hour set = " + isSet4 + " minute set = " + isSet5 + " second set = " + isSet6);
        }
        return DatatypeConstants.DURATION_YEARMONTH;
    }

    public int getYears() {
        return getFieldValueAsInt(DatatypeConstants.YEARS);
    }

    public abstract int hashCode();

    public boolean isLongerThan(Duration duration) {
        return compare(duration) == 1;
    }

    public abstract boolean isSet(DatatypeConstants.Field field);

    public boolean isShorterThan(Duration duration) {
        return compare(duration) == -1;
    }

    public Duration multiply(int i) {
        return multiply(BigDecimal.valueOf(i));
    }

    public abstract Duration multiply(BigDecimal bigDecimal);

    public abstract Duration negate();

    public abstract Duration normalizeWith(Calendar calendar);

    public Duration subtract(Duration duration) {
        return add(duration.negate());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getSign() < 0) {
            sb.append('-');
        }
        sb.append('P');
        BigInteger bigInteger = (BigInteger) getField(DatatypeConstants.YEARS);
        if (bigInteger != null) {
            sb.append(bigInteger).append('Y');
        }
        BigInteger bigInteger2 = (BigInteger) getField(DatatypeConstants.MONTHS);
        if (bigInteger2 != null) {
            sb.append(bigInteger2).append('M');
        }
        BigInteger bigInteger3 = (BigInteger) getField(DatatypeConstants.DAYS);
        if (bigInteger3 != null) {
            sb.append(bigInteger3).append('D');
        }
        BigInteger bigInteger4 = (BigInteger) getField(DatatypeConstants.HOURS);
        BigInteger bigInteger5 = (BigInteger) getField(DatatypeConstants.MINUTES);
        BigDecimal bigDecimal = (BigDecimal) getField(DatatypeConstants.SECONDS);
        if (bigInteger4 != null || bigInteger5 != null || bigDecimal != null) {
            sb.append('T');
            if (bigInteger4 != null) {
                sb.append(bigInteger4).append('H');
            }
            if (bigInteger5 != null) {
                sb.append(bigInteger5).append('M');
            }
            if (bigDecimal != null) {
                sb.append(toString(bigDecimal)).append('S');
            }
        }
        return sb.toString();
    }
}
