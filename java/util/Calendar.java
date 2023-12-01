package java.util;

import com.anythink.core.common.c.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/util/Calendar.class */
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    public static final int ALL_STYLES = 0;
    public static final int AM = 0;
    public static final int AM_PM = 9;
    public static final int APRIL = 3;
    public static final int AUGUST = 7;
    public static final int DATE = 5;
    public static final int DAY_OF_MONTH = 5;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    public static final int DAY_OF_YEAR = 6;
    public static final int DECEMBER = 11;
    public static final int DST_OFFSET = 16;
    public static final int ERA = 0;
    public static final int FEBRUARY = 1;
    public static final int FIELD_COUNT = 17;
    public static final int FRIDAY = 6;
    public static final int HOUR = 10;
    public static final int HOUR_OF_DAY = 11;
    public static final int JANUARY = 0;
    public static final int JULY = 6;
    public static final int JUNE = 5;
    public static final int LONG = 2;
    public static final int MARCH = 2;
    public static final int MAY = 4;
    public static final int MILLISECOND = 14;
    public static final int MINUTE = 12;
    public static final int MONDAY = 2;
    public static final int MONTH = 2;
    public static final int NOVEMBER = 10;
    public static final int OCTOBER = 9;
    public static final int PM = 1;
    public static final int SATURDAY = 7;
    public static final int SECOND = 13;
    public static final int SEPTEMBER = 8;
    public static final int SHORT = 1;
    public static final int SUNDAY = 1;
    public static final int THURSDAY = 5;
    public static final int TUESDAY = 3;
    public static final int UNDECIMBER = 12;
    public static final int WEDNESDAY = 4;
    public static final int WEEK_OF_MONTH = 4;
    public static final int WEEK_OF_YEAR = 3;
    public static final int YEAR = 1;
    public static final int ZONE_OFFSET = 15;
    private static final long serialVersionUID = -1807547505821590642L;
    protected boolean areFieldsSet;
    protected int[] fields;
    private int firstDayOfWeek;
    protected boolean[] isSet;
    protected boolean isTimeSet;
    transient int lastDateFieldSet;
    transient int lastTimeFieldSet;
    private boolean lenient;
    private int minimalDaysInFirstWeek;
    protected long time;
    private TimeZone zone;
    private static final String[] FIELD_NAMES = {"ERA", "YEAR", "MONTH", "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR", "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET"};
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("areFieldsSet", Boolean.TYPE), new ObjectStreamField("fields", int[].class), new ObjectStreamField("firstDayOfWeek", Integer.TYPE), new ObjectStreamField("isSet", boolean[].class), new ObjectStreamField("isTimeSet", Boolean.TYPE), new ObjectStreamField("lenient", Boolean.TYPE), new ObjectStreamField("minimalDaysInFirstWeek", Integer.TYPE), new ObjectStreamField("nextStamp", Integer.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE), new ObjectStreamField(g.a.g, Long.TYPE), new ObjectStreamField("zone", TimeZone.class)};

    protected Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar(TimeZone timeZone) {
        this.fields = new int[17];
        this.isSet = new boolean[17];
        this.isTimeSet = false;
        this.areFieldsSet = false;
        setLenient(true);
        setTimeZone(timeZone);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Calendar(TimeZone timeZone, Locale locale) {
        this(timeZone);
        LocaleData localeData = LocaleData.get(LocaleData.mapInvalidAndNullLocales(locale));
        setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
    }

    private static void checkStyle(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("bad style " + i);
        }
    }

    public static Locale[] getAvailableLocales() {
        Locale[] availableCalendarLocales;
        synchronized (Calendar.class) {
            try {
                availableCalendarLocales = ICU.getAvailableCalendarLocales();
            } catch (Throwable th) {
                throw th;
            }
        }
        return availableCalendarLocales;
    }

    private String[] getDisplayNameArray(int i, int i2, Locale locale) {
        if (i < 0 || i >= 17) {
            throw new IllegalArgumentException("bad field " + i);
        }
        checkStyle(i2);
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        switch (i) {
            case 0:
                return dateFormatSymbols.getEras();
            case 2:
                return i2 == 2 ? dateFormatSymbols.getMonths() : dateFormatSymbols.getShortMonths();
            case 7:
                return i2 == 2 ? dateFormatSymbols.getWeekdays() : dateFormatSymbols.getShortWeekdays();
            case 9:
                return dateFormatSymbols.getAmPmStrings();
            default:
                return null;
        }
    }

    public static Calendar getInstance() {
        GregorianCalendar gregorianCalendar;
        synchronized (Calendar.class) {
            try {
                gregorianCalendar = new GregorianCalendar();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gregorianCalendar;
    }

    public static Calendar getInstance(Locale locale) {
        GregorianCalendar gregorianCalendar;
        synchronized (Calendar.class) {
            try {
                gregorianCalendar = new GregorianCalendar(locale);
            } catch (Throwable th) {
                throw th;
            }
        }
        return gregorianCalendar;
    }

    public static Calendar getInstance(TimeZone timeZone) {
        GregorianCalendar gregorianCalendar;
        synchronized (Calendar.class) {
            try {
                gregorianCalendar = new GregorianCalendar(timeZone);
            } catch (Throwable th) {
                throw th;
            }
        }
        return gregorianCalendar;
    }

    public static Calendar getInstance(TimeZone timeZone, Locale locale) {
        GregorianCalendar gregorianCalendar;
        synchronized (Calendar.class) {
            try {
                gregorianCalendar = new GregorianCalendar(timeZone, locale);
            } catch (Throwable th) {
                throw th;
            }
        }
        return gregorianCalendar;
    }

    private static void insertValuesInMap(Map<String, Integer> map, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] != null && !strArr[i2].isEmpty()) {
                map.put(strArr[i2], Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.areFieldsSet = readFields.get("areFieldsSet", false);
        this.fields = (int[]) readFields.get("fields", (Object) null);
        this.firstDayOfWeek = readFields.get("firstDayOfWeek", 1);
        this.isSet = (boolean[]) readFields.get("isSet", (Object) null);
        this.isTimeSet = readFields.get("isTimeSet", false);
        this.lenient = readFields.get("lenient", true);
        this.minimalDaysInFirstWeek = readFields.get("minimalDaysInFirstWeek", 1);
        this.time = readFields.get(g.a.g, 0L);
        this.zone = (TimeZone) readFields.get("zone", (Object) null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        complete();
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("areFieldsSet", this.areFieldsSet);
        putFields.put("fields", this.fields);
        putFields.put("firstDayOfWeek", this.firstDayOfWeek);
        putFields.put("isSet", this.isSet);
        putFields.put("isTimeSet", this.isTimeSet);
        putFields.put("lenient", this.lenient);
        putFields.put("minimalDaysInFirstWeek", this.minimalDaysInFirstWeek);
        putFields.put("nextStamp", 2);
        putFields.put("serialVersionOnStream", 1);
        putFields.put(g.a.g, this.time);
        putFields.put("zone", this.zone);
        objectOutputStream.writeFields();
    }

    public abstract void add(int i, int i2);

    public boolean after(Object obj) {
        return (obj instanceof Calendar) && getTimeInMillis() > ((Calendar) obj).getTimeInMillis();
    }

    public boolean before(Object obj) {
        return (obj instanceof Calendar) && getTimeInMillis() < ((Calendar) obj).getTimeInMillis();
    }

    public final void clear() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 17) {
                this.isTimeSet = false;
                this.areFieldsSet = false;
                return;
            }
            this.fields[i2] = 0;
            this.isSet[i2] = false;
            i = i2 + 1;
        }
    }

    public final void clear(int i) {
        this.fields[i] = 0;
        this.isSet[i] = false;
        this.isTimeSet = false;
        this.areFieldsSet = false;
    }

    public Object clone() {
        try {
            Calendar calendar = (Calendar) super.clone();
            calendar.fields = (int[]) this.fields.clone();
            calendar.isSet = (boolean[]) this.isSet.clone();
            calendar.zone = (TimeZone) this.zone.clone();
            return calendar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Calendar calendar) {
        if (calendar == null) {
            throw new NullPointerException("anotherCalendar == null");
        }
        long timeInMillis = getTimeInMillis();
        long timeInMillis2 = calendar.getTimeInMillis();
        if (timeInMillis > timeInMillis2) {
            return 1;
        }
        return timeInMillis == timeInMillis2 ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void complete() {
        if (!this.isTimeSet) {
            computeTime();
            this.isTimeSet = true;
        }
        if (this.areFieldsSet) {
            return;
        }
        computeFields();
        this.areFieldsSet = true;
    }

    protected abstract void computeFields();

    protected abstract void computeTime();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            return getTimeInMillis() == calendar.getTimeInMillis() && isLenient() == calendar.isLenient() && getFirstDayOfWeek() == calendar.getFirstDayOfWeek() && getMinimalDaysInFirstWeek() == calendar.getMinimalDaysInFirstWeek() && getTimeZone().equals(calendar.getTimeZone());
        }
        return false;
    }

    public int get(int i) {
        complete();
        return this.fields[i];
    }

    public int getActualMaximum(int i) {
        int i2;
        int i3;
        int maximum = getMaximum(i);
        int leastMaximum = getLeastMaximum(i);
        if (maximum == leastMaximum) {
            return leastMaximum;
        }
        complete();
        long j = this.time;
        set(i, leastMaximum);
        do {
            i2 = leastMaximum;
            roll(i, true);
            i3 = get(i);
            leastMaximum = i3;
        } while (i3 > i2);
        this.time = j;
        this.areFieldsSet = false;
        return i2;
    }

    public int getActualMinimum(int i) {
        int i2;
        int i3;
        int minimum = getMinimum(i);
        int greatestMinimum = getGreatestMinimum(i);
        if (minimum == greatestMinimum) {
            return greatestMinimum;
        }
        complete();
        long j = this.time;
        set(i, greatestMinimum);
        do {
            i2 = greatestMinimum;
            roll(i, false);
            i3 = get(i);
            greatestMinimum = i3;
        } while (i3 < i2);
        this.time = j;
        this.areFieldsSet = false;
        return i2;
    }

    public String getDisplayName(int i, int i2, Locale locale) {
        int i3 = i2;
        if (i2 == 0) {
            i3 = 1;
        }
        String[] displayNameArray = getDisplayNameArray(i, i3, locale);
        int i4 = get(i);
        if (displayNameArray != null) {
            return displayNameArray[i4];
        }
        return null;
    }

    public Map<String, Integer> getDisplayNames(int i, int i2, Locale locale) {
        checkStyle(i2);
        complete();
        HashMap hashMap = new HashMap();
        if (i2 == 1 || i2 == 0) {
            insertValuesInMap(hashMap, getDisplayNameArray(i, 1, locale));
        }
        if (i2 == 2 || i2 == 0) {
            insertValuesInMap(hashMap, getDisplayNameArray(i, 2, locale));
        }
        HashMap hashMap2 = hashMap;
        if (hashMap.isEmpty()) {
            hashMap2 = null;
        }
        return hashMap2;
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public abstract int getGreatestMinimum(int i);

    public abstract int getLeastMaximum(int i);

    public abstract int getMaximum(int i);

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    public abstract int getMinimum(int i);

    public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    public long getTimeInMillis() {
        if (!this.isTimeSet) {
            computeTime();
            this.isTimeSet = true;
        }
        return this.time;
    }

    public TimeZone getTimeZone() {
        return this.zone;
    }

    public int hashCode() {
        return (isLenient() ? 1237 : 1231) + getFirstDayOfWeek() + getMinimalDaysInFirstWeek() + getTimeZone().hashCode();
    }

    protected final int internalGet(int i) {
        return this.fields[i];
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final boolean isSet(int i) {
        return this.isSet[i];
    }

    public void roll(int i, int i2) {
        boolean z = i2 >= 0;
        if (!z) {
            i2 = -i2;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            roll(i, z);
            i3 = i4 + 1;
        }
    }

    public abstract void roll(int i, boolean z);

    public void set(int i, int i2) {
        this.fields[i] = i2;
        this.isSet[i] = true;
        this.isTimeSet = false;
        this.areFieldsSet = false;
        if (i > 2 && i < 9) {
            this.lastDateFieldSet = i;
        }
        if (i == 10 || i == 11) {
            this.lastTimeFieldSet = i;
        }
        if (i == 9) {
            this.lastTimeFieldSet = 10;
        }
    }

    public final void set(int i, int i2, int i3) {
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    public final void set(int i, int i2, int i3, int i4, int i5) {
        set(i, i2, i3);
        set(11, i4);
        set(12, i5);
    }

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        set(i, i2, i3, i4, i5);
        set(13, i6);
    }

    public void setFirstDayOfWeek(int i) {
        this.firstDayOfWeek = i;
    }

    public void setLenient(boolean z) {
        this.lenient = z;
    }

    public void setMinimalDaysInFirstWeek(int i) {
        this.minimalDaysInFirstWeek = i;
    }

    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }

    public void setTimeInMillis(long j) {
        if (this.isTimeSet && this.areFieldsSet && this.time == j) {
            return;
        }
        this.time = j;
        this.isTimeSet = true;
        this.areFieldsSet = false;
        complete();
    }

    public void setTimeZone(TimeZone timeZone) {
        this.zone = timeZone;
        this.areFieldsSet = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getName() + "[time=" + (this.isTimeSet ? String.valueOf(this.time) : "?") + ",areFieldsSet=" + this.areFieldsSet + ",lenient=" + this.lenient + ",zone=" + this.zone.getID() + ",firstDayOfWeek=" + this.firstDayOfWeek + ",minimalDaysInFirstWeek=" + this.minimalDaysInFirstWeek);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 17) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(FIELD_NAMES[i2]);
            sb.append('=');
            if (this.isSet[i2]) {
                sb.append(this.fields[i2]);
            } else {
                sb.append('?');
            }
            i = i2 + 1;
        }
    }
}
