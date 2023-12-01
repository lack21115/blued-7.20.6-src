package java.text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/text/SimpleDateFormat.class */
public class SimpleDateFormat extends DateFormat {
    static final String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";
    private static final int RFC_822_TIMEZONE_FIELD = 18;
    private static final int STAND_ALONE_DAY_OF_WEEK_FIELD = 20;
    private static final int STAND_ALONE_MONTH_FIELD = 19;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("defaultCenturyStart", Date.class), new ObjectStreamField("formatData", DateFormatSymbols.class), new ObjectStreamField("pattern", String.class), new ObjectStreamField("serialVersionOnStream", Integer.TYPE)};
    private static final long serialVersionUID = 4774881970558875024L;
    private transient int creationYear;
    private Date defaultCenturyStart;
    private DateFormatSymbols formatData;
    private String pattern;

    public SimpleDateFormat() {
        this(Locale.getDefault());
        this.pattern = defaultPattern();
        this.formatData = new DateFormatSymbols(Locale.getDefault());
    }

    public SimpleDateFormat(String str) {
        this(str, Locale.getDefault());
    }

    public SimpleDateFormat(String str, DateFormatSymbols dateFormatSymbols) {
        this(Locale.getDefault());
        validatePattern(str);
        this.pattern = str;
        this.formatData = (DateFormatSymbols) dateFormatSymbols.clone();
    }

    public SimpleDateFormat(String str, Locale locale) {
        this(locale);
        validatePattern(str);
        this.pattern = str;
        this.formatData = new DateFormatSymbols(locale);
    }

    private SimpleDateFormat(Locale locale) {
        this.numberFormat = NumberFormat.getInstance(locale);
        this.numberFormat.setParseIntegerOnly(true);
        this.numberFormat.setGroupingUsed(false);
        this.calendar = new GregorianCalendar(locale);
        this.calendar.add(1, -80);
        this.creationYear = this.calendar.get(1);
        this.defaultCenturyStart = this.calendar.getTime();
    }

    private void append(StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldPosition> list, char c, int i) {
        int i2;
        int indexOf = PATTERN_CHARS.indexOf(c);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Unknown pattern character '" + c + "'");
        }
        int length = stringBuffer.length();
        DateFormat.Field field = null;
        switch (indexOf) {
            case 0:
                field = DateFormat.Field.ERA;
                stringBuffer.append(this.formatData.eras[this.calendar.get(0)]);
                i2 = -1;
                break;
            case 1:
                field = DateFormat.Field.YEAR;
                int i3 = this.calendar.get(1);
                if (i != 2) {
                    appendNumber(stringBuffer, i, i3);
                    i2 = -1;
                    break;
                } else {
                    appendNumber(stringBuffer, 2, i3 % 100);
                    i2 = -1;
                    break;
                }
            case 2:
                field = DateFormat.Field.MONTH;
                appendMonth(stringBuffer, i, false);
                i2 = -1;
                break;
            case 3:
                field = DateFormat.Field.DAY_OF_MONTH;
                i2 = 5;
                break;
            case 4:
                field = DateFormat.Field.HOUR_OF_DAY1;
                int i4 = this.calendar.get(11);
                int i5 = i4;
                if (i4 == 0) {
                    i5 = 24;
                }
                appendNumber(stringBuffer, i, i5);
                i2 = -1;
                break;
            case 5:
                field = DateFormat.Field.HOUR_OF_DAY0;
                i2 = 11;
                break;
            case 6:
                field = DateFormat.Field.MINUTE;
                i2 = 12;
                break;
            case 7:
                field = DateFormat.Field.SECOND;
                i2 = 13;
                break;
            case 8:
                field = DateFormat.Field.MILLISECOND;
                appendMilliseconds(stringBuffer, i, this.calendar.get(14));
                i2 = -1;
                break;
            case 9:
                field = DateFormat.Field.DAY_OF_WEEK;
                appendDayOfWeek(stringBuffer, i, false);
                i2 = -1;
                break;
            case 10:
                field = DateFormat.Field.DAY_OF_YEAR;
                i2 = 6;
                break;
            case 11:
                field = DateFormat.Field.DAY_OF_WEEK_IN_MONTH;
                i2 = 8;
                break;
            case 12:
                field = DateFormat.Field.WEEK_OF_YEAR;
                i2 = 3;
                break;
            case 13:
                field = DateFormat.Field.WEEK_OF_MONTH;
                i2 = 4;
                break;
            case 14:
                field = DateFormat.Field.AM_PM;
                stringBuffer.append(this.formatData.ampms[this.calendar.get(9)]);
                i2 = -1;
                break;
            case 15:
                field = DateFormat.Field.HOUR1;
                int i6 = this.calendar.get(10);
                int i7 = i6;
                if (i6 == 0) {
                    i7 = 12;
                }
                appendNumber(stringBuffer, i, i7);
                i2 = -1;
                break;
            case 16:
                field = DateFormat.Field.HOUR0;
                i2 = 10;
                break;
            case 17:
                field = DateFormat.Field.TIME_ZONE;
                appendTimeZone(stringBuffer, i, true);
                i2 = -1;
                break;
            case 18:
                field = DateFormat.Field.TIME_ZONE;
                appendNumericTimeZone(stringBuffer, i, false);
                i2 = -1;
                break;
            case 19:
                field = DateFormat.Field.MONTH;
                appendMonth(stringBuffer, i, true);
                i2 = -1;
                break;
            case 20:
                field = DateFormat.Field.DAY_OF_WEEK;
                appendDayOfWeek(stringBuffer, i, true);
                i2 = -1;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            appendNumber(stringBuffer, i, this.calendar.get(i2));
        }
        if (list != null) {
            FieldPosition fieldPosition2 = new FieldPosition(field);
            fieldPosition2.setBeginIndex(length);
            fieldPosition2.setEndIndex(stringBuffer.length());
            list.add(fieldPosition2);
        } else if ((fieldPosition.getFieldAttribute() == field || (fieldPosition.getFieldAttribute() == null && fieldPosition.getField() == indexOf)) && fieldPosition.getEndIndex() == 0) {
            fieldPosition.setBeginIndex(length);
            fieldPosition.setEndIndex(stringBuffer.length());
        }
    }

    private void appendDayOfWeek(StringBuffer stringBuffer, int i, boolean z) {
        LocaleData localeData = this.formatData.localeData;
        stringBuffer.append((i == 4 ? z ? localeData.longStandAloneWeekdayNames : this.formatData.weekdays : i == 5 ? z ? localeData.tinyStandAloneWeekdayNames : this.formatData.localeData.tinyWeekdayNames : z ? localeData.shortStandAloneWeekdayNames : this.formatData.shortWeekdays)[this.calendar.get(7)]);
    }

    private void appendMilliseconds(StringBuffer stringBuffer, int i, int i2) {
        int i3;
        this.numberFormat.setMinimumIntegerDigits(i > 3 ? 3 : i);
        this.numberFormat.setMaximumIntegerDigits(10);
        if (i == 1) {
            i3 = i2 / 100;
        } else {
            i3 = i2;
            if (i == 2) {
                i3 = i2 / 10;
            }
        }
        FieldPosition fieldPosition = new FieldPosition(0);
        this.numberFormat.format(Integer.valueOf(i3), stringBuffer, fieldPosition);
        if (i > 3) {
            this.numberFormat.setMinimumIntegerDigits(i - 3);
            this.numberFormat.format((Object) 0, stringBuffer, fieldPosition);
        }
    }

    private void appendMonth(StringBuffer stringBuffer, int i, boolean z) {
        int i2 = this.calendar.get(2);
        if (i <= 2) {
            appendNumber(stringBuffer, i, i2 + 1);
            return;
        }
        LocaleData localeData = this.formatData.localeData;
        stringBuffer.append((i == 4 ? z ? localeData.longStandAloneMonthNames : this.formatData.months : i == 5 ? z ? localeData.tinyStandAloneMonthNames : localeData.tinyMonthNames : z ? localeData.shortStandAloneMonthNames : this.formatData.shortMonths)[i2]);
    }

    private void appendNumber(StringBuffer stringBuffer, int i, int i2) {
        int minimumIntegerDigits = this.numberFormat.getMinimumIntegerDigits();
        this.numberFormat.setMinimumIntegerDigits(i);
        this.numberFormat.format(Integer.valueOf(i2), stringBuffer, new FieldPosition(0));
        this.numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r8 >= 4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void appendNumericTimeZone(java.lang.StringBuffer r7, int r8, boolean r9) {
        /*
            r6 = this;
            r0 = 0
            r13 = r0
            r0 = r6
            java.util.Calendar r0 = r0.calendar
            r1 = 15
            int r0 = r0.get(r1)
            r10 = r0
            r0 = r6
            java.util.Calendar r0 = r0.calendar
            r1 = 16
            int r0 = r0.get(r1)
            r11 = r0
            r0 = r9
            if (r0 != 0) goto L22
            r0 = r8
            r1 = 4
            if (r0 != r1) goto L44
        L22:
            r0 = 1
            r12 = r0
        L25:
            r0 = r9
            if (r0 != 0) goto L31
            r0 = r13
            r9 = r0
            r0 = r8
            r1 = 4
            if (r0 < r1) goto L33
        L31:
            r0 = 1
            r9 = r0
        L33:
            r0 = r7
            r1 = r12
            r2 = r9
            r3 = r10
            r4 = r11
            int r3 = r3 + r4
            java.lang.String r1 = java.util.TimeZone.createGmtOffsetString(r1, r2, r3)
            java.lang.StringBuffer r0 = r0.append(r1)
            return
        L44:
            r0 = 0
            r12 = r0
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.appendNumericTimeZone(java.lang.StringBuffer, int, boolean):void");
    }

    private void appendTimeZone(StringBuffer stringBuffer, int i, boolean z) {
        int i2 = 0;
        if (z) {
            TimeZone timeZone = this.calendar.getTimeZone();
            boolean z2 = this.calendar.get(16) != 0;
            if (i >= 4) {
                i2 = 1;
            }
            String timeZoneDisplayName = this.formatData.getTimeZoneDisplayName(timeZone, z2, i2);
            if (timeZoneDisplayName != null) {
                stringBuffer.append(timeZoneDisplayName);
                return;
            }
        }
        appendNumericTimeZone(stringBuffer, i, z);
    }

    private static String convertPattern(String str, String str2, String str3, boolean z) {
        int indexOf;
        if (z || !str2.equals(str3)) {
            boolean z2 = false;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                boolean z3 = z2;
                if (charAt == '\'') {
                    z3 = !z2;
                }
                if (!z3 && (indexOf = str2.indexOf(charAt)) != -1) {
                    sb.append(str3.charAt(indexOf));
                } else if (z && !z3 && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                    throw new IllegalArgumentException("Invalid pattern character '" + charAt + "' in '" + str + "'");
                } else {
                    sb.append(charAt);
                }
                i++;
                z2 = z3;
            }
            if (z2) {
                throw new IllegalArgumentException("Unterminated quote");
            }
            return sb.toString();
        }
        return str;
    }

    private static String defaultPattern() {
        LocaleData localeData = LocaleData.get(Locale.getDefault());
        return localeData.getDateFormat(3) + " " + localeData.getTimeFormat(3);
    }

    private Date error(ParsePosition parsePosition, int i, TimeZone timeZone) {
        parsePosition.setErrorIndex(i);
        this.calendar.setTimeZone(timeZone);
        return null;
    }

    private StringBuffer formatImpl(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldPosition> list) {
        char c;
        boolean z = false;
        char c2 = 65535;
        int i = 0;
        this.calendar.setTime(date);
        if (fieldPosition != null) {
            fieldPosition.setBeginIndex(0);
            fieldPosition.setEndIndex(0);
        }
        int length = this.pattern.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = this.pattern.charAt(i2);
            if (charAt == '\'') {
                int i3 = i;
                if (i > 0) {
                    append(stringBuffer, fieldPosition, list, c2, i);
                    i3 = 0;
                }
                if (c2 == charAt) {
                    stringBuffer.append('\'');
                    c = 65535;
                } else {
                    c = charAt;
                }
                if (z) {
                    z = false;
                    i = i3;
                } else {
                    z = true;
                    i = i3;
                }
            } else if (z || (c2 != charAt && ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')))) {
                int i4 = i;
                if (i > 0) {
                    append(stringBuffer, fieldPosition, list, c2, i);
                    i4 = 0;
                }
                stringBuffer.append(charAt);
                i = i4;
                c = 65535;
            } else if (c2 == charAt) {
                i++;
                c = c2;
            } else {
                if (i > 0) {
                    append(stringBuffer, fieldPosition, list, c2, i);
                }
                c = charAt;
                i = 1;
            }
            i2++;
            c2 = c;
        }
        if (i > 0) {
            append(stringBuffer, fieldPosition, list, c2, i);
        }
        return stringBuffer;
    }

    private AttributedCharacterIterator formatToCharacterIteratorImpl(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        formatImpl(date, stringBuffer, null, arrayList);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        Iterator<FieldPosition> it = arrayList.iterator();
        while (it.hasNext()) {
            FieldPosition next = it.next();
            Format.Field fieldAttribute = next.getFieldAttribute();
            attributedString.addAttribute(fieldAttribute, fieldAttribute, next.getBeginIndex(), next.getEndIndex());
        }
        return attributedString.getIterator();
    }

    private int parse(String str, int i, char c, int i2) {
        int i3;
        int indexOf = PATTERN_CHARS.indexOf(c);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Unknown pattern character '" + c + "'");
        }
        int i4 = 0;
        int i5 = i2;
        if (i2 < 0) {
            i5 = -i2;
            i4 = i5;
        }
        switch (indexOf) {
            case 0:
                return parseText(str, i, this.formatData.eras, 0);
            case 1:
                if (i5 < 3) {
                    ParsePosition parsePosition = new ParsePosition(i);
                    Number parseNumber = parseNumber(i4, str, parsePosition);
                    if (parseNumber == null) {
                        return (-parsePosition.getErrorIndex()) - 1;
                    }
                    int intValue = parseNumber.intValue();
                    int i6 = intValue;
                    if (parsePosition.getIndex() - i == 2) {
                        i6 = intValue;
                        if (intValue >= 0) {
                            int i7 = intValue + ((this.creationYear / 100) * 100);
                            i6 = i7;
                            if (i7 < this.creationYear) {
                                i6 = i7 + 100;
                            }
                        }
                    }
                    this.calendar.set(1, i6);
                    return parsePosition.getIndex();
                }
                i3 = 1;
                break;
            case 2:
                return parseMonth(str, i, i5, i4, false);
            case 3:
                i3 = 5;
                break;
            case 4:
                ParsePosition parsePosition2 = new ParsePosition(i);
                Number parseNumber2 = parseNumber(i4, str, parsePosition2);
                if (parseNumber2 == null) {
                    return (-parsePosition2.getErrorIndex()) - 1;
                }
                int intValue2 = parseNumber2.intValue();
                int i8 = intValue2;
                if (intValue2 == 24) {
                    i8 = 0;
                }
                this.calendar.set(11, i8);
                return parsePosition2.getIndex();
            case 5:
                i3 = 11;
                break;
            case 6:
                i3 = 12;
                break;
            case 7:
                i3 = 13;
                break;
            case 8:
                return parseFractionalSeconds(str, i, i4);
            case 9:
                return parseDayOfWeek(str, i, false);
            case 10:
                i3 = 6;
                break;
            case 11:
                i3 = 8;
                break;
            case 12:
                i3 = 3;
                break;
            case 13:
                i3 = 4;
                break;
            case 14:
                return parseText(str, i, this.formatData.ampms, 9);
            case 15:
                ParsePosition parsePosition3 = new ParsePosition(i);
                Number parseNumber3 = parseNumber(i4, str, parsePosition3);
                if (parseNumber3 == null) {
                    return (-parsePosition3.getErrorIndex()) - 1;
                }
                int intValue3 = parseNumber3.intValue();
                int i9 = intValue3;
                if (intValue3 == 12) {
                    i9 = 0;
                }
                this.calendar.set(10, i9);
                return parsePosition3.getIndex();
            case 16:
                i3 = 10;
                break;
            case 17:
                return parseTimeZone(str, i);
            case 18:
                return parseTimeZone(str, i);
            case 19:
                return parseMonth(str, i, i5, i4, true);
            case 20:
                return parseDayOfWeek(str, i, true);
            default:
                i3 = -1;
                break;
        }
        int i10 = i;
        if (i3 != -1) {
            i10 = parseNumber(i4, str, i, i3, 0);
        }
        return i10;
    }

    private int parseDayOfWeek(String str, int i, boolean z) {
        LocaleData localeData = this.formatData.localeData;
        int parseText = parseText(str, i, z ? localeData.longStandAloneWeekdayNames : this.formatData.weekdays, 7);
        int i2 = parseText;
        if (parseText < 0) {
            i2 = parseText(str, i, z ? localeData.shortStandAloneWeekdayNames : this.formatData.shortWeekdays, 7);
        }
        return i2;
    }

    private int parseFractionalSeconds(String str, int i, int i2) {
        ParsePosition parsePosition = new ParsePosition(i);
        Number parseNumber = parseNumber(i2, str, parsePosition);
        if (parseNumber == null) {
            return (-parsePosition.getErrorIndex()) - 1;
        }
        this.calendar.set(14, (int) ((parseNumber.doubleValue() / Math.pow(10.0d, parsePosition.getIndex() - i)) * 1000.0d));
        return parsePosition.getIndex();
    }

    private int parseMonth(String str, int i, int i2, int i3, boolean z) {
        int i4;
        if (i2 <= 2) {
            i4 = parseNumber(i3, str, i, 2, -1);
        } else {
            LocaleData localeData = this.formatData.localeData;
            int parseText = parseText(str, i, z ? localeData.longStandAloneMonthNames : this.formatData.months, 2);
            i4 = parseText;
            if (parseText < 0) {
                return parseText(str, i, z ? localeData.shortStandAloneMonthNames : this.formatData.shortMonths, 2);
            }
        }
        return i4;
    }

    private int parseNumber(int i, String str, int i2, int i3, int i4) {
        ParsePosition parsePosition = new ParsePosition(i2);
        Number parseNumber = parseNumber(i, str, parsePosition);
        if (parseNumber == null) {
            return (-parsePosition.getErrorIndex()) - 1;
        }
        this.calendar.set(i3, parseNumber.intValue() + i4);
        return parsePosition.getIndex();
    }

    private Number parseNumber(int i, String str, ParsePosition parsePosition) {
        int digit;
        int length = str.length();
        int index = parsePosition.getIndex();
        int i2 = index;
        int i3 = length;
        if (i > 0) {
            i2 = index;
            i3 = length;
            if (i < length - index) {
                i3 = index + i;
                i2 = index;
            }
        }
        while (i2 < i3 && (str.charAt(i2) == ' ' || str.charAt(i2) == '\t')) {
            i2++;
        }
        if (i == 0) {
            parsePosition.setIndex(i2);
            return this.numberFormat.parse(str, parsePosition);
        }
        int i4 = 0;
        while (i2 < i3 && (digit = Character.digit(str.charAt(i2), 10)) != -1) {
            i4 = (i4 * 10) + digit;
            i2++;
        }
        if (i2 == parsePosition.getIndex()) {
            parsePosition.setErrorIndex(i2);
            return null;
        }
        parsePosition.setIndex(i2);
        return Integer.valueOf(i4);
    }

    private int parseText(String str, int i, String[] strArr, int i2) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i7 < strArr.length) {
            String str2 = strArr[i7];
            int length = str2.length();
            if (length == 0) {
                i4 = i6;
                i3 = i5;
            } else if (str.regionMatches(true, i, str2, 0, length)) {
                if (i5 != -1) {
                    i3 = i5;
                    i4 = i6;
                    if (length <= i6) {
                    }
                }
                i3 = i7;
                i4 = length;
            } else {
                i3 = i5;
                i4 = i6;
                if (str2.charAt(length - 1) == '.') {
                    i3 = i5;
                    i4 = i6;
                    if (str.regionMatches(true, i, str2, 0, length - 1)) {
                        if (i5 != -1) {
                            i3 = i5;
                            i4 = i6;
                            if (length - 1 <= i6) {
                            }
                        }
                        i3 = i7;
                        i4 = length - 1;
                    }
                }
            }
            i7++;
            i5 = i3;
            i6 = i4;
        }
        if (i5 != -1) {
            this.calendar.set(i2, i5);
            return i + i6;
        }
        return (-i) - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x016b, code lost:
        if (r10 == 4) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parseTimeZone(java.lang.String r9, int r10) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.parseTimeZone(java.lang.String, int):int");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        set2DigitYearStart(readFields.get("serialVersionOnStream", 0) > 0 ? (Date) readFields.get("defaultCenturyStart", new Date()) : new Date());
        this.formatData = (DateFormatSymbols) readFields.get("formatData", (Object) null);
        this.pattern = (String) readFields.get("pattern", "");
    }

    private void validatePattern(String str) {
        boolean z = false;
        char c = 65535;
        int i = 0;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '\'') {
                int i3 = i;
                if (i > 0) {
                    validatePatternCharacter(c);
                    i3 = 0;
                }
                if (c == charAt) {
                    charAt = 65535;
                }
                if (z) {
                    z = false;
                    i = i3;
                } else {
                    z = true;
                    i = i3;
                }
            } else if (z || (c != charAt && ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')))) {
                int i4 = i;
                if (i > 0) {
                    validatePatternCharacter(c);
                    i4 = 0;
                }
                i = i4;
                charAt = 65535;
            } else if (c == charAt) {
                i++;
                charAt = c;
            } else {
                if (i > 0) {
                    validatePatternCharacter(c);
                }
                i = 1;
            }
            i2++;
            c = charAt;
        }
        if (i > 0) {
            validatePatternCharacter(c);
        }
        if (z) {
            throw new IllegalArgumentException("Unterminated quote");
        }
    }

    private void validatePatternCharacter(char c) {
        if (PATTERN_CHARS.indexOf(c) == -1) {
            throw new IllegalArgumentException("Unknown pattern character '" + c + "'");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("defaultCenturyStart", this.defaultCenturyStart);
        putFields.put("formatData", this.formatData);
        putFields.put("pattern", this.pattern);
        putFields.put("serialVersionOnStream", 1);
        objectOutputStream.writeFields();
    }

    public void applyLocalizedPattern(String str) {
        this.pattern = convertPattern(str, this.formatData.getLocalPatternChars(), PATTERN_CHARS, true);
    }

    public void applyPattern(String str) {
        validatePattern(str);
        this.pattern = str;
    }

    @Override // java.text.DateFormat, java.text.Format
    public Object clone() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) super.clone();
        simpleDateFormat.formatData = (DateFormatSymbols) this.formatData.clone();
        simpleDateFormat.defaultCenturyStart = new Date(this.defaultCenturyStart.getTime());
        return simpleDateFormat;
    }

    @Override // java.text.DateFormat
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleDateFormat) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) obj;
            return super.equals(obj) && this.pattern.equals(simpleDateFormat.pattern) && this.formatData.equals(simpleDateFormat.formatData);
        }
        return false;
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return formatImpl(date, stringBuffer, fieldPosition, null);
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object == null");
        }
        if (obj instanceof Date) {
            return formatToCharacterIteratorImpl((Date) obj);
        }
        if (obj instanceof Number) {
            return formatToCharacterIteratorImpl(new Date(((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("Bad class: " + obj.getClass());
    }

    public Date get2DigitYearStart() {
        return (Date) this.defaultCenturyStart.clone();
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return (DateFormatSymbols) this.formatData.clone();
    }

    @Override // java.text.DateFormat
    public int hashCode() {
        return super.hashCode() + this.pattern.hashCode() + this.formatData.hashCode() + this.creationYear;
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        char c;
        char c2;
        boolean z = false;
        char c3 = 65535;
        int i = 0;
        int index = parsePosition.getIndex();
        int length = str.length();
        this.calendar.clear();
        TimeZone timeZone = this.calendar.getTimeZone();
        int length2 = this.pattern.length();
        int i2 = 0;
        while (i2 < length2) {
            char charAt = this.pattern.charAt(i2);
            if (charAt == '\'') {
                int i3 = i;
                int i4 = index;
                if (i > 0) {
                    i4 = parse(str, index, c3, i);
                    if (i4 < 0) {
                        return error(parsePosition, (-i4) - 1, timeZone);
                    }
                    i3 = 0;
                }
                if (c3 != charAt) {
                    c2 = charAt;
                    index = i4;
                } else if (i4 >= length || str.charAt(i4) != '\'') {
                    return error(parsePosition, i4, timeZone);
                } else {
                    index = i4 + 1;
                    c2 = 65535;
                }
                if (z) {
                    z = false;
                    i = i3;
                    c = c2;
                } else {
                    z = true;
                    c = c2;
                    i = i3;
                }
            } else if (z || (c3 != charAt && ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')))) {
                int i5 = i;
                int i6 = index;
                if (i > 0) {
                    i6 = parse(str, index, c3, i);
                    if (i6 < 0) {
                        return error(parsePosition, (-i6) - 1, timeZone);
                    }
                    i5 = 0;
                }
                if (i6 >= length || str.charAt(i6) != charAt) {
                    return error(parsePosition, i6, timeZone);
                }
                i = i5;
                c = 65535;
                index = i6 + 1;
            } else if (c3 == charAt) {
                i++;
                c = c3;
            } else {
                int i7 = index;
                if (i > 0) {
                    int parse = parse(str, index, c3, -i);
                    i7 = parse;
                    if (parse < 0) {
                        return error(parsePosition, (-parse) - 1, timeZone);
                    }
                }
                c = charAt;
                i = 1;
                index = i7;
            }
            i2++;
            c3 = c;
        }
        int i8 = index;
        if (i > 0) {
            int parse2 = parse(str, index, c3, i);
            i8 = parse2;
            if (parse2 < 0) {
                return error(parsePosition, (-parse2) - 1, timeZone);
            }
        }
        try {
            Date time = this.calendar.getTime();
            parsePosition.setIndex(i8);
            this.calendar.setTimeZone(timeZone);
            return time;
        } catch (IllegalArgumentException e) {
            return error(parsePosition, i8, timeZone);
        }
    }

    public void set2DigitYearStart(Date date) {
        this.defaultCenturyStart = (Date) date.clone();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.defaultCenturyStart);
        this.creationYear = gregorianCalendar.get(1);
    }

    public void setDateFormatSymbols(DateFormatSymbols dateFormatSymbols) {
        this.formatData = (DateFormatSymbols) dateFormatSymbols.clone();
    }

    public String toLocalizedPattern() {
        return convertPattern(this.pattern, PATTERN_CHARS, this.formatData.getLocalPatternChars(), false);
    }

    public String toPattern() {
        return this.pattern;
    }
}
