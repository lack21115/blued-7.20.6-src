package java.text;

import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/text/DateFormat.class */
public abstract class DateFormat extends Format {
    public static final int AM_PM_FIELD = 14;
    public static final int DATE_FIELD = 3;
    public static final int DAY_OF_WEEK_FIELD = 9;
    public static final int DAY_OF_WEEK_IN_MONTH_FIELD = 11;
    public static final int DAY_OF_YEAR_FIELD = 10;
    public static final int DEFAULT = 2;
    public static final int ERA_FIELD = 0;
    public static final int FULL = 0;
    public static final int HOUR0_FIELD = 16;
    public static final int HOUR1_FIELD = 15;
    public static final int HOUR_OF_DAY0_FIELD = 5;
    public static final int HOUR_OF_DAY1_FIELD = 4;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int MILLISECOND_FIELD = 8;
    public static final int MINUTE_FIELD = 6;
    public static final int MONTH_FIELD = 2;
    public static final int SECOND_FIELD = 7;
    public static final int SHORT = 3;
    public static final int TIMEZONE_FIELD = 17;
    public static final int WEEK_OF_MONTH_FIELD = 13;
    public static final int WEEK_OF_YEAR_FIELD = 12;
    public static final int YEAR_FIELD = 1;
    public static Boolean is24Hour;
    private static final long serialVersionUID = 7218322306649953788L;
    protected Calendar calendar;
    protected NumberFormat numberFormat;

    /* loaded from: source-2895416-dex2jar.jar:java/text/DateFormat$Field.class */
    public static class Field extends Format.Field {
        private static final long serialVersionUID = 7441350119349544720L;
        private int calendarField;
        private static Hashtable<Integer, Field> table = new Hashtable<>();
        public static final Field ERA = new Field("era", 0);
        public static final Field YEAR = new Field("year", 1);
        public static final Field MONTH = new Field("month", 2);
        public static final Field HOUR_OF_DAY0 = new Field("hour of day", 11);
        public static final Field HOUR_OF_DAY1 = new Field("hour of day 1", -1);
        public static final Field MINUTE = new Field("minute", 12);
        public static final Field SECOND = new Field("second", 13);
        public static final Field MILLISECOND = new Field("millisecond", 14);
        public static final Field DAY_OF_WEEK = new Field("day of week", 7);
        public static final Field DAY_OF_MONTH = new Field("day of month", 5);
        public static final Field DAY_OF_YEAR = new Field("day of year", 6);
        public static final Field DAY_OF_WEEK_IN_MONTH = new Field("day of week in month", 8);
        public static final Field WEEK_OF_YEAR = new Field("week of year", 3);
        public static final Field WEEK_OF_MONTH = new Field("week of month", 4);
        public static final Field AM_PM = new Field("am pm", 9);
        public static final Field HOUR0 = new Field("hour", 10);
        public static final Field HOUR1 = new Field("hour 1", -1);
        public static final Field TIME_ZONE = new Field("time zone", -1);

        protected Field(String str, int i) {
            super(str);
            this.calendarField = -1;
            this.calendarField = i;
            if (i == -1 || table.get(Integer.valueOf(i)) != null) {
                return;
            }
            table.put(Integer.valueOf(i), this);
        }

        public static Field ofCalendarField(int i) {
            if (i < 0 || i >= 17) {
                throw new IllegalArgumentException("Field out of range: " + i);
            }
            return table.get(Integer.valueOf(i));
        }

        public int getCalendarField() {
            return this.calendarField;
        }
    }

    private static void checkDateStyle(int i) {
        if (i != 3 && i != 2 && i != 1 && i != 0 && i != 2) {
            throw new IllegalArgumentException("Illegal date style: " + i);
        }
    }

    private static void checkTimeStyle(int i) {
        if (i != 3 && i != 2 && i != 1 && i != 0 && i != 2) {
            throw new IllegalArgumentException("Illegal time style: " + i);
        }
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatLocales();
    }

    public static final DateFormat getDateInstance() {
        return getDateInstance(2);
    }

    public static final DateFormat getDateInstance(int i) {
        checkDateStyle(i);
        return getDateInstance(i, Locale.getDefault());
    }

    public static final DateFormat getDateInstance(int i, Locale locale) {
        checkDateStyle(i);
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return new SimpleDateFormat(LocaleData.get(locale).getDateFormat(i), locale);
    }

    public static final DateFormat getDateTimeInstance() {
        return getDateTimeInstance(2, 2);
    }

    public static final DateFormat getDateTimeInstance(int i, int i2) {
        checkTimeStyle(i2);
        checkDateStyle(i);
        return getDateTimeInstance(i, i2, Locale.getDefault());
    }

    public static final DateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        checkTimeStyle(i2);
        checkDateStyle(i);
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        LocaleData localeData = LocaleData.get(locale);
        return new SimpleDateFormat(localeData.getDateFormat(i) + " " + localeData.getTimeFormat(i2), locale);
    }

    public static final DateFormat getInstance() {
        return getDateTimeInstance(3, 3);
    }

    public static final DateFormat getTimeInstance() {
        return getTimeInstance(2);
    }

    public static final DateFormat getTimeInstance(int i) {
        checkTimeStyle(i);
        return getTimeInstance(i, Locale.getDefault());
    }

    public static final DateFormat getTimeInstance(int i, Locale locale) {
        checkTimeStyle(i);
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return new SimpleDateFormat(LocaleData.get(locale).getTimeFormat(i), locale);
    }

    public static final void set24HourTimePref(boolean z) {
        is24Hour = Boolean.valueOf(z);
    }

    @Override // java.text.Format
    public Object clone() {
        DateFormat dateFormat = (DateFormat) super.clone();
        dateFormat.calendar = (Calendar) this.calendar.clone();
        dateFormat.numberFormat = (NumberFormat) this.numberFormat.clone();
        return dateFormat;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateFormat) {
            DateFormat dateFormat = (DateFormat) obj;
            return this.numberFormat.equals(dateFormat.numberFormat) && this.calendar.getTimeZone().equals(dateFormat.calendar.getTimeZone()) && this.calendar.getFirstDayOfWeek() == dateFormat.calendar.getFirstDayOfWeek() && this.calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar.getMinimalDaysInFirstWeek() && this.calendar.isLenient() == dateFormat.calendar.isLenient();
        }
        return false;
    }

    public final String format(Date date) {
        return format(date, new StringBuffer(), new FieldPosition(0)).toString();
    }

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof Number) {
            return format(new Date(((Number) obj).longValue()), stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException("Bad class: " + obj.getClass());
    }

    public abstract StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public Calendar getCalendar() {
        return this.calendar;
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public TimeZone getTimeZone() {
        return this.calendar.getTimeZone();
    }

    public int hashCode() {
        int firstDayOfWeek = this.calendar.getFirstDayOfWeek();
        int minimalDaysInFirstWeek = this.calendar.getMinimalDaysInFirstWeek();
        return (this.calendar.isLenient() ? 1231 : 1237) + this.calendar.getTimeZone().hashCode() + firstDayOfWeek + minimalDaysInFirstWeek + this.numberFormat.hashCode();
    }

    public boolean isLenient() {
        return this.calendar.isLenient();
    }

    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new ParseException("Unparseable date: \"" + str + "\"", parsePosition.getErrorIndex());
        }
        return parse;
    }

    public abstract Date parse(String str, ParsePosition parsePosition);

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setLenient(boolean z) {
        this.calendar.setLenient(z);
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.calendar.setTimeZone(timeZone);
    }
}
