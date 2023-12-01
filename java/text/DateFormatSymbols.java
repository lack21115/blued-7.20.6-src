package java.text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import libcore.icu.ICU;
import libcore.icu.LocaleData;
import libcore.icu.TimeZoneNames;

/* loaded from: source-2895416-dex2jar.jar:java/text/DateFormatSymbols.class */
public class DateFormatSymbols implements Serializable, Cloneable {
    private static final long serialVersionUID = -5987973545549424702L;
    String[] ampms;
    String[] eras;
    private String localPatternChars;
    private final Locale locale;
    transient LocaleData localeData;
    String[] months;
    String[] shortMonths;
    String[] shortWeekdays;
    String[] weekdays;
    private String[][] zoneStrings;

    public DateFormatSymbols() {
        this(Locale.getDefault());
    }

    public DateFormatSymbols(Locale locale) {
        this.locale = LocaleData.mapInvalidAndNullLocales(locale);
        this.localPatternChars = "GyMdkHmsSEDFwWahKzZLc";
        this.localeData = LocaleData.get(locale);
        this.ampms = this.localeData.amPm;
        this.eras = this.localeData.eras;
        this.months = this.localeData.longMonthNames;
        this.shortMonths = this.localeData.shortMonthNames;
        this.weekdays = this.localeData.longWeekdayNames;
        this.shortWeekdays = this.localeData.shortWeekdayNames;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String[], java.lang.String[][]] */
    private static String[][] clone2dStringArray(String[][] strArr) {
        ?? r0 = new String[strArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return r0;
            }
            r0[i2] = (String[]) strArr[i2].clone();
            i = i2 + 1;
        }
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatSymbolsLocales();
    }

    public static final DateFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static final DateFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return new DateFormatSymbols(locale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Locale locale = this.locale;
        Locale locale2 = locale;
        if (locale == null) {
            locale2 = Locale.getDefault();
        }
        this.localeData = LocaleData.get(locale2);
    }

    private static boolean timeZoneStringsEqual(DateFormatSymbols dateFormatSymbols, DateFormatSymbols dateFormatSymbols2) {
        if (dateFormatSymbols.zoneStrings == null && dateFormatSymbols2.zoneStrings == null && dateFormatSymbols.locale.equals(dateFormatSymbols2.locale)) {
            return true;
        }
        return Arrays.deepEquals(dateFormatSymbols.internalZoneStrings(), dateFormatSymbols2.internalZoneStrings());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        internalZoneStrings();
        objectOutputStream.defaultWriteObject();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateFormatSymbols) {
            DateFormatSymbols dateFormatSymbols = (DateFormatSymbols) obj;
            return this.localPatternChars.equals(dateFormatSymbols.localPatternChars) && Arrays.equals(this.ampms, dateFormatSymbols.ampms) && Arrays.equals(this.eras, dateFormatSymbols.eras) && Arrays.equals(this.months, dateFormatSymbols.months) && Arrays.equals(this.shortMonths, dateFormatSymbols.shortMonths) && Arrays.equals(this.shortWeekdays, dateFormatSymbols.shortWeekdays) && Arrays.equals(this.weekdays, dateFormatSymbols.weekdays) && timeZoneStringsEqual(this, dateFormatSymbols);
        }
        return false;
    }

    public String[] getAmPmStrings() {
        return (String[]) this.ampms.clone();
    }

    public String[] getEras() {
        return (String[]) this.eras.clone();
    }

    public String getLocalPatternChars() {
        return this.localPatternChars;
    }

    public String[] getMonths() {
        return (String[]) this.months.clone();
    }

    public String[] getShortMonths() {
        return (String[]) this.shortMonths.clone();
    }

    public String[] getShortWeekdays() {
        return (String[]) this.shortWeekdays.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTimeZoneDisplayName(TimeZone timeZone, boolean z, int i) {
        if (i == 0 || i == 1) {
            return TimeZoneNames.getDisplayName(internalZoneStrings(), timeZone.getID(), z, i);
        }
        throw new IllegalArgumentException("Bad style: " + i);
    }

    public String[] getWeekdays() {
        return (String[]) this.weekdays.clone();
    }

    public String[][] getZoneStrings() {
        String[][] clone2dStringArray = clone2dStringArray(internalZoneStrings());
        int length = clone2dStringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return clone2dStringArray;
            }
            String[] strArr = clone2dStringArray[i2];
            String str = strArr[0];
            if (strArr[1] == null) {
                strArr[1] = TimeZone.getTimeZone(str).getDisplayName(false, 1, this.locale);
            }
            if (strArr[2] == null) {
                strArr[2] = TimeZone.getTimeZone(str).getDisplayName(false, 0, this.locale);
            }
            if (strArr[3] == null) {
                strArr[3] = TimeZone.getTimeZone(str).getDisplayName(true, 1, this.locale);
            }
            if (strArr[4] == null) {
                strArr[4] = TimeZone.getTimeZone(str).getDisplayName(true, 0, this.locale);
            }
            i = i2 + 1;
        }
    }

    public int hashCode() {
        String[][] internalZoneStrings = internalZoneStrings();
        int hashCode = this.localPatternChars.hashCode();
        String[] strArr = this.ampms;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            hashCode += strArr[i2].hashCode();
            i = i2 + 1;
        }
        String[] strArr2 = this.eras;
        int length2 = strArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            hashCode += strArr2[i4].hashCode();
            i3 = i4 + 1;
        }
        String[] strArr3 = this.months;
        int length3 = strArr3.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                break;
            }
            hashCode += strArr3[i6].hashCode();
            i5 = i6 + 1;
        }
        String[] strArr4 = this.shortMonths;
        int length4 = strArr4.length;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= length4) {
                break;
            }
            hashCode += strArr4[i8].hashCode();
            i7 = i8 + 1;
        }
        String[] strArr5 = this.shortWeekdays;
        int length5 = strArr5.length;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= length5) {
                break;
            }
            hashCode += strArr5[i10].hashCode();
            i9 = i10 + 1;
        }
        String[] strArr6 = this.weekdays;
        int length6 = strArr6.length;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= length6) {
                break;
            }
            hashCode += strArr6[i12].hashCode();
            i11 = i12 + 1;
        }
        int length7 = internalZoneStrings.length;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= length7) {
                return hashCode;
            }
            String[] strArr7 = internalZoneStrings[i14];
            int i15 = 0;
            while (i15 < strArr7.length) {
                int i16 = hashCode;
                if (strArr7[i15] != null) {
                    i16 = hashCode + strArr7[i15].hashCode();
                }
                i15++;
                hashCode = i16;
            }
            i13 = i14 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[][] internalZoneStrings() {
        String[][] strArr;
        synchronized (this) {
            if (this.zoneStrings == null) {
                this.zoneStrings = TimeZoneNames.getZoneStrings(this.locale);
            }
            strArr = this.zoneStrings;
        }
        return strArr;
    }

    public void setAmPmStrings(String[] strArr) {
        this.ampms = (String[]) strArr.clone();
    }

    public void setEras(String[] strArr) {
        this.eras = (String[]) strArr.clone();
    }

    public void setLocalPatternChars(String str) {
        if (str == null) {
            throw new NullPointerException("data == null");
        }
        this.localPatternChars = str;
    }

    public void setMonths(String[] strArr) {
        this.months = (String[]) strArr.clone();
    }

    public void setShortMonths(String[] strArr) {
        this.shortMonths = (String[]) strArr.clone();
    }

    public void setShortWeekdays(String[] strArr) {
        this.shortWeekdays = (String[]) strArr.clone();
    }

    public void setWeekdays(String[] strArr) {
        this.weekdays = (String[]) strArr.clone();
    }

    public void setZoneStrings(String[][] strArr) {
        if (strArr == null) {
            throw new NullPointerException("zoneStrings == null");
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.zoneStrings = clone2dStringArray(strArr);
                return;
            }
            String[] strArr2 = strArr[i2];
            if (strArr2.length < 5) {
                throw new IllegalArgumentException(Arrays.toString(strArr2) + ".length < 5");
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        return getClass().getName() + "[amPmStrings=" + Arrays.toString(this.ampms) + ",eras=" + Arrays.toString(this.eras) + ",localPatternChars=" + this.localPatternChars + ",months=" + Arrays.toString(this.months) + ",shortMonths=" + Arrays.toString(this.shortMonths) + ",shortWeekdays=" + Arrays.toString(this.shortWeekdays) + ",weekdays=" + Arrays.toString(this.weekdays) + ",zoneStrings=[" + Arrays.toString(internalZoneStrings()[0]) + "...]]";
    }
}
