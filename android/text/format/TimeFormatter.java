package android.text.format;

import android.content.res.Resources;
import com.google.android.material.timepicker.TimeModel;
import java.nio.CharBuffer;
import java.util.Locale;
import libcore.icu.LocaleData;
import libcore.util.ZoneInfo;

/* loaded from: source-9557208-dex2jar.jar:android/text/format/TimeFormatter.class */
class TimeFormatter {
    private static final int DAYSPERLYEAR = 366;
    private static final int DAYSPERNYEAR = 365;
    private static final int DAYSPERWEEK = 7;
    private static final int FORCE_LOWER_CASE = -1;
    private static final int HOURSPERDAY = 24;
    private static final int MINSPERHOUR = 60;
    private static final int MONSPERYEAR = 12;
    private static final int SECSPERMIN = 60;
    private static String sDateOnlyFormat;
    private static String sDateTimeFormat;
    private static Locale sLocale;
    private static LocaleData sLocaleData;
    private static String sTimeOnlyFormat;
    private final String dateOnlyFormat;
    private final String dateTimeFormat;
    private final LocaleData localeData;
    private java.util.Formatter numberFormatter;
    private StringBuilder outputBuilder;
    private final String timeOnlyFormat;

    public TimeFormatter() {
        synchronized (TimeFormatter.class) {
            try {
                Locale locale = Locale.getDefault();
                if (sLocale == null || !locale.equals(sLocale)) {
                    sLocale = locale;
                    sLocaleData = LocaleData.get(locale);
                    Resources system = Resources.getSystem();
                    sTimeOnlyFormat = system.getString(17039659);
                    sDateOnlyFormat = system.getString(17039658);
                    sDateTimeFormat = system.getString(17039660);
                }
                this.dateTimeFormat = sDateTimeFormat;
                this.timeOnlyFormat = sTimeOnlyFormat;
                this.dateOnlyFormat = sDateOnlyFormat;
                this.localeData = sLocaleData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean brokenIsLower(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    private static boolean brokenIsUpper(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    private static char brokenToLower(char c2) {
        char c3 = c2;
        if (c2 >= 'A') {
            c3 = c2;
            if (c2 <= 'Z') {
                c3 = (char) ((c2 - 'A') + 97);
            }
        }
        return c3;
    }

    private static char brokenToUpper(char c2) {
        char c3 = c2;
        if (c2 >= 'a') {
            c3 = c2;
            if (c2 <= 'z') {
                c3 = (char) ((c2 - 'a') + 65);
            }
        }
        return c3;
    }

    private void formatInternal(String str, ZoneInfo.WallTime wallTime, ZoneInfo zoneInfo) {
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.remaining() > 0) {
            boolean z = true;
            if (wrap.get(wrap.position()) == '%') {
                z = handleToken(wrap, wallTime, zoneInfo);
            }
            if (z) {
                this.outputBuilder.append(wrap.get(wrap.position()));
            }
            wrap.position(wrap.position() + 1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String getFormat(int i, String str, String str2, String str3, String str4) {
        switch (i) {
            case 45:
                return str3;
            case 48:
                return str4;
            case 95:
                break;
            default:
                str2 = str;
                break;
        }
        return str2;
    }

    private boolean handleToken(CharBuffer charBuffer, ZoneInfo.WallTime wallTime, ZoneInfo zoneInfo) {
        char c2;
        int i;
        char c3 = 0;
        while (charBuffer.remaining() > 1) {
            charBuffer.position(charBuffer.position() + 1);
            char c4 = charBuffer.get(charBuffer.position());
            switch (c4) {
                case '#':
                case '-':
                case '0':
                case '^':
                case '_':
                    c3 = c4;
                    break;
                case '$':
                case '%':
                case '&':
                case '\'':
                case '(':
                case ')':
                case '*':
                case ',':
                case '.':
                case '/':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                case 'J':
                case 'K':
                case 'L':
                case 'N':
                case 'Q':
                case '[':
                case '\\':
                case ']':
                case '`':
                case 'f':
                case 'i':
                case 'o':
                case 'q':
                default:
                    return true;
                case '+':
                    formatInternal("%a %b %e %H:%M:%S %Z %Y", wallTime, zoneInfo);
                    return false;
                case 'A':
                    modifyAndAppend((wallTime.getWeekDay() < 0 || wallTime.getWeekDay() >= 7) ? "?" : this.localeData.longWeekdayNames[wallTime.getWeekDay() + 1], c3);
                    return false;
                case 'B':
                    if (c3 == '-') {
                        modifyAndAppend((wallTime.getMonth() < 0 || wallTime.getMonth() >= 12) ? "?" : this.localeData.longStandAloneMonthNames[wallTime.getMonth()], c3);
                        return false;
                    }
                    modifyAndAppend((wallTime.getMonth() < 0 || wallTime.getMonth() >= 12) ? "?" : this.localeData.longMonthNames[wallTime.getMonth()], c3);
                    return false;
                case 'C':
                    outputYear(wallTime.getYear(), true, false, c3);
                    return false;
                case 'D':
                    formatInternal("%m/%d/%y", wallTime, zoneInfo);
                    return false;
                case 'E':
                case 'O':
                    break;
                case 'F':
                    formatInternal("%Y-%m-%d", wallTime, zoneInfo);
                    return false;
                case 'G':
                case 'V':
                case 'g':
                    int year = wallTime.getYear();
                    int yearDay = wallTime.getYearDay();
                    int weekDay = wallTime.getWeekDay();
                    while (true) {
                        int i2 = isLeap(year) ? 366 : 365;
                        int i3 = (((yearDay + 11) - weekDay) % 7) - 3;
                        int i4 = i3 - (i2 % 7);
                        int i5 = i4;
                        if (i4 < -3) {
                            i5 = i4 + 7;
                        }
                        if (yearDay >= i5 + i2) {
                            year++;
                            i = 1;
                        } else if (yearDay >= i3) {
                            i = ((yearDay - i3) / 7) + 1;
                        } else {
                            int i6 = year - 1;
                            yearDay += isLeap(i6) ? 366 : 365;
                            year = i6;
                        }
                    }
                    if (c4 == 'V') {
                        this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(i));
                        return false;
                    } else if (c4 == 'g') {
                        outputYear(year, false, true, c3);
                        return false;
                    } else {
                        outputYear(year, true, true, c3);
                        return false;
                    }
                case 'H':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getHour()));
                    return false;
                case 'I':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getHour() % 12 != 0 ? wallTime.getHour() % 12 : 12));
                    return false;
                case 'M':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getMinute()));
                    return false;
                case 'P':
                    modifyAndAppend(wallTime.getHour() >= 12 ? this.localeData.amPm[1] : this.localeData.amPm[0], -1);
                    return false;
                case 'R':
                    formatInternal(DateUtils.HOUR_MINUTE_24, wallTime, zoneInfo);
                    return false;
                case 'S':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getSecond()));
                    return false;
                case 'T':
                    formatInternal("%H:%M:%S", wallTime, zoneInfo);
                    return false;
                case 'U':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(((wallTime.getYearDay() + 7) - wallTime.getWeekDay()) / 7));
                    return false;
                case 'W':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(((wallTime.getYearDay() + 7) - (wallTime.getWeekDay() != 0 ? wallTime.getWeekDay() - 1 : 6)) / 7));
                    return false;
                case 'X':
                    formatInternal(this.timeOnlyFormat, wallTime, zoneInfo);
                    return false;
                case 'Y':
                    outputYear(wallTime.getYear(), true, true, c3);
                    return false;
                case 'Z':
                    if (wallTime.getIsDst() < 0) {
                        return false;
                    }
                    modifyAndAppend(zoneInfo.getDisplayName(wallTime.getIsDst() != 0, 0), c3);
                    return false;
                case 'a':
                    modifyAndAppend((wallTime.getWeekDay() < 0 || wallTime.getWeekDay() >= 7) ? "?" : this.localeData.shortWeekdayNames[wallTime.getWeekDay() + 1], c3);
                    return false;
                case 'b':
                case 'h':
                    modifyAndAppend((wallTime.getMonth() < 0 || wallTime.getMonth() >= 12) ? "?" : this.localeData.shortMonthNames[wallTime.getMonth()], c3);
                    return false;
                case 'c':
                    formatInternal(this.dateTimeFormat, wallTime, zoneInfo);
                    return false;
                case 'd':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getMonthDay()));
                    return false;
                case 'e':
                    this.numberFormatter.format(getFormat(c3, "%2d", "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getMonthDay()));
                    return false;
                case 'j':
                    this.numberFormatter.format(getFormat(c3, "%03d", "%3d", TimeModel.NUMBER_FORMAT, "%03d"), Integer.valueOf(wallTime.getYearDay() + 1));
                    return false;
                case 'k':
                    this.numberFormatter.format(getFormat(c3, "%2d", "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getHour()));
                    return false;
                case 'l':
                    this.numberFormatter.format(getFormat(c3, "%2d", "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getHour() % 12 != 0 ? wallTime.getHour() % 12 : 12));
                    return false;
                case 'm':
                    this.numberFormatter.format(getFormat(c3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(wallTime.getMonth() + 1));
                    return false;
                case 'n':
                    this.outputBuilder.append('\n');
                    return false;
                case 'p':
                    modifyAndAppend(wallTime.getHour() >= 12 ? this.localeData.amPm[1] : this.localeData.amPm[0], c3);
                    return false;
                case 'r':
                    formatInternal("%I:%M:%S %p", wallTime, zoneInfo);
                    return false;
                case 's':
                    this.outputBuilder.append(Integer.toString(wallTime.mktime(zoneInfo)));
                    return false;
                case 't':
                    this.outputBuilder.append('\t');
                    return false;
                case 'u':
                    this.numberFormatter.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(wallTime.getWeekDay() == 0 ? 7 : wallTime.getWeekDay()));
                    return false;
                case 'v':
                    formatInternal("%e-%b-%Y", wallTime, zoneInfo);
                    return false;
                case 'w':
                    this.numberFormatter.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(wallTime.getWeekDay()));
                    return false;
                case 'x':
                    formatInternal(this.dateOnlyFormat, wallTime, zoneInfo);
                    return false;
                case 'y':
                    outputYear(wallTime.getYear(), false, true, c3);
                    return false;
                case 'z':
                    if (wallTime.getIsDst() < 0) {
                        return false;
                    }
                    int gmtOffset = wallTime.getGmtOffset();
                    if (gmtOffset < 0) {
                        c2 = '-';
                        gmtOffset = -gmtOffset;
                    } else {
                        c2 = '+';
                    }
                    this.outputBuilder.append(c2);
                    int i7 = gmtOffset / 60;
                    this.numberFormatter.format(getFormat(c3, "%04d", "%4d", TimeModel.NUMBER_FORMAT, "%04d"), Integer.valueOf(((i7 / 60) * 100) + (i7 % 60)));
                    return false;
            }
        }
        return true;
    }

    private static boolean isLeap(int i) {
        if (i % 4 == 0) {
            return i % 100 != 0 || i % 400 == 0;
        }
        return false;
    }

    private String localizeDigits(String str) {
        int length = str.length();
        char c2 = this.localeData.zeroDigit;
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            char c3 = charAt;
            if (charAt >= '0') {
                c3 = charAt;
                if (charAt <= '9') {
                    c3 = (char) (charAt + (c2 - '0'));
                }
            }
            sb.append(c3);
            i = i2 + 1;
        }
    }

    private void modifyAndAppend(CharSequence charSequence, int i) {
        char c2;
        switch (i) {
            case -1:
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= charSequence.length()) {
                        return;
                    }
                    this.outputBuilder.append(brokenToLower(charSequence.charAt(i3)));
                    i2 = i3 + 1;
                }
            case 35:
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= charSequence.length()) {
                        return;
                    }
                    char charAt = charSequence.charAt(i5);
                    if (brokenIsUpper(charAt)) {
                        c2 = brokenToLower(charAt);
                    } else {
                        c2 = charAt;
                        if (brokenIsLower(charAt)) {
                            c2 = brokenToUpper(charAt);
                        }
                    }
                    this.outputBuilder.append(c2);
                    i4 = i5 + 1;
                }
            case 94:
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= charSequence.length()) {
                        return;
                    }
                    this.outputBuilder.append(brokenToUpper(charSequence.charAt(i7)));
                    i6 = i7 + 1;
                }
            default:
                this.outputBuilder.append(charSequence);
                return;
        }
    }

    private void outputYear(int i, boolean z, boolean z2, int i2) {
        int i3;
        int i4;
        int i5 = i % 100;
        int i6 = (i / 100) + (i5 / 100);
        int i7 = i5 % 100;
        if (i7 >= 0 || i6 <= 0) {
            i3 = i6;
            i4 = i7;
            if (i6 < 0) {
                i3 = i6;
                i4 = i7;
                if (i7 > 0) {
                    i4 = i7 - 100;
                    i3 = i6 + 1;
                }
            }
        } else {
            i4 = i7 + 100;
            i3 = i6 - 1;
        }
        if (z) {
            if (i3 != 0 || i4 >= 0) {
                this.numberFormatter.format(getFormat(i2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(i3));
            } else {
                this.outputBuilder.append("-0");
            }
        }
        if (z2) {
            if (i4 < 0) {
                i4 = -i4;
            }
            this.numberFormatter.format(getFormat(i2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, "%2d", TimeModel.NUMBER_FORMAT, TimeModel.ZERO_LEADING_NUMBER_FORMAT), Integer.valueOf(i4));
        }
    }

    public String format(String str, ZoneInfo.WallTime wallTime, ZoneInfo zoneInfo) {
        try {
            StringBuilder sb = new StringBuilder();
            this.outputBuilder = sb;
            this.numberFormatter = new java.util.Formatter(sb, Locale.US);
            formatInternal(str, wallTime, zoneInfo);
            String sb2 = sb.toString();
            String str2 = sb2;
            if (this.localeData.zeroDigit != '0') {
                str2 = localizeDigits(sb2);
            }
            this.outputBuilder = null;
            this.numberFormatter = null;
            return str2;
        } catch (Throwable th) {
            this.outputBuilder = null;
            this.numberFormatter = null;
            throw th;
        }
    }
}
