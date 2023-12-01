package com.qiniu.android.utils;

import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter.class */
public final class FastDatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$CharacterLiteral.class */
    public static class CharacterLiteral implements Rule {
        private final char mValue;

        CharacterLiteral(char c2) {
            this.mValue = c2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$DayInWeekField.class */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = 7;
            int i2 = calendar.get(7);
            NumberRule numberRule = this.mRule;
            if (i2 != 1) {
                i = i2 - 1;
            }
            numberRule.appendTo(appendable, i);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$Iso8601_Rule.class */
    public static class Iso8601_Rule implements Rule {
        final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule getRule(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return ISO8601_HOURS_COLON_MINUTES;
                    }
                    throw new IllegalArgumentException("invalid number of X");
                }
                return ISO8601_HOURS_MINUTES;
            }
            return ISO8601_HOURS;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i == 0) {
                appendable.append("Z");
                return;
            }
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / BaseConstants.Time.HOUR;
            FastDatePrinter.appendDigits(appendable, i2);
            int i3 = this.length;
            if (i3 < 5) {
                return;
            }
            if (i3 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$NumberRule.class */
    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$PaddedNumberField.class */
    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i, this.mSize);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$Rule.class */
    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$StringLiteral.class */
    public static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TextField.class */
    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (i2 < 0) {
                    return i;
                }
                int length2 = this.mValues[i2].length();
                length = i2;
                if (length2 > i) {
                    i = length2;
                    length = i2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TimeZoneNumberRule.class */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                appendable.append('-');
                i = -i;
            } else {
                appendable.append('+');
            }
            int i2 = i / BaseConstants.Time.HOUR;
            FastDatePrinter.appendDigits(appendable, i2);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i / 60000) - (i2 * 60));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TwelveHourField.class */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(10);
            int i2 = i;
            if (i == 0) {
                i2 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i2);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TwentyFourHourField.class */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i) throws IOException {
            this.mRule.appendTo(appendable, i);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i = calendar.get(11);
            int i2 = i;
            if (i == 0) {
                i2 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i2);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TwoDigitMonthField.class */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TwoDigitNumberField.class */
    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int i) {
            this.mField = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 2);
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$TwoDigitYearField.class */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            FastDatePrinter.appendDigits(appendable, i);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$UnpaddedMonthField.class */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, i);
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/FastDatePrinter$UnpaddedNumberField.class */
    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        UnpaddedNumberField(int i) {
            this.mField = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i) throws IOException {
            if (i < 10) {
                appendable.append((char) (i + 48));
            } else if (i < 100) {
                FastDatePrinter.appendDigits(appendable, i);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i, 1);
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i) throws IOException {
        appendable.append((char) ((i / 10) + 48));
        appendable.append((char) ((i % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        if (i < 10000) {
            int i6 = i < 1000 ? i < 100 ? i < 10 ? 1 : 2 : 3 : 4;
            int i7 = i2;
            int i8 = i6;
            while (true) {
                int i9 = i7 - i8;
                if (i9 <= 0) {
                    break;
                }
                appendable.append('0');
                i7 = i9;
                i8 = 1;
            }
            int i10 = i;
            if (i6 != 1) {
                i10 = i;
                if (i6 != 2) {
                    i10 = i;
                    if (i6 != 3) {
                        if (i6 != 4) {
                            return;
                        }
                        appendable.append((char) ((i / 1000) + 48));
                        i10 = i % 1000;
                    }
                    if (i10 >= 100) {
                        appendable.append((char) ((i10 / 100) + 48));
                        i10 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i10 >= 10) {
                    appendable.append((char) ((i10 / 10) + 48));
                    i10 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i10 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i11 = i;
        int i12 = 0;
        while (true) {
            i3 = i12;
            i4 = i2;
            if (i11 == 0) {
                break;
            }
            cArr[i3] = (char) ((i11 % 10) + 48);
            i11 /= 10;
            i12 = i3 + 1;
        }
        while (true) {
            i5 = i3;
            if (i3 >= i4) {
                break;
            }
            appendable.append('0');
            i4--;
        }
        while (true) {
            i5--;
            if (i5 < 0) {
                return;
            }
            appendable.append(cArr[i5]);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b) {
        try {
            Rule[] ruleArr = this.mRules;
            int length = ruleArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return b;
                }
                ruleArr[i2].appendTo(b, calendar);
                i = i2 + 1;
            }
        } catch (IOException e) {
            return b;
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            length--;
            if (length < 0) {
                this.mMaxLengthEstimate = i2;
                return;
            }
            i = i2 + this.mRules[length].estimateLength();
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FastDatePrinter) {
            FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
            boolean z = false;
            if (this.mPattern.equals(fastDatePrinter.mPattern)) {
                z = false;
                if (this.mTimeZone.equals(fastDatePrinter.mTimeZone)) {
                    z = false;
                    if (this.mLocale.equals(fastDatePrinter.mLocale)) {
                        z = true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    public <B extends Appendable> B format(long j, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    public <B extends Appendable> B format(Calendar calendar, B b) {
        Calendar calendar2 = calendar;
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar2 = (Calendar) calendar.clone();
            calendar2.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar2, (Calendar) b);
    }

    public <B extends Appendable> B format(Date date, B b) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (B) applyRules(newCalendar, (Calendar) b);
    }

    public String format(long j) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRulesToString(newCalendar);
    }

    String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    protected List<Rule> parsePattern() {
        Rule selectNumberRule;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            iArr[0] = i2;
            String parseToken = parseToken(this.mPattern, iArr);
            int i3 = iArr[0];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(0);
            switch (charAt) {
                case '\'':
                    String substring = parseToken.substring(1);
                    if (substring.length() == 1) {
                        selectNumberRule = new CharacterLiteral(substring.charAt(0));
                    } else {
                        selectNumberRule = new StringLiteral(substring);
                        continue;
                    }
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'K':
                    selectNumberRule = selectNumberRule(10, length2);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'M':
                    if (length2 >= 4) {
                        selectNumberRule = new TextField(2, months);
                        continue;
                    } else {
                        selectNumberRule = length2 == 3 ? new TextField(2, shortMonths) : length2 == 2 ? TwoDigitMonthField.INSTANCE : UnpaddedMonthField.INSTANCE;
                    }
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'S':
                    selectNumberRule = selectNumberRule(14, length2);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'a':
                    selectNumberRule = new TextField(9, amPmStrings);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'd':
                    selectNumberRule = selectNumberRule(5, length2);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'h':
                    selectNumberRule = new TwelveHourField(selectNumberRule(10, length2));
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'k':
                    selectNumberRule = new TwentyFourHourField(selectNumberRule(11, length2));
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'm':
                    selectNumberRule = selectNumberRule(12, length2);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 's':
                    selectNumberRule = selectNumberRule(13, length2);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'u':
                    selectNumberRule = new DayInWeekField(selectNumberRule(7, length2));
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'w':
                    selectNumberRule = selectNumberRule(3, length2);
                    continue;
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                case 'y':
                    break;
                default:
                    switch (charAt) {
                        case 'D':
                            selectNumberRule = selectNumberRule(6, length2);
                            continue;
                        case 'E':
                            selectNumberRule = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                            break;
                        case 'F':
                            selectNumberRule = selectNumberRule(8, length2);
                            break;
                        case 'G':
                            selectNumberRule = new TextField(0, eras);
                            break;
                        case 'H':
                            selectNumberRule = selectNumberRule(11, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'W':
                                    selectNumberRule = selectNumberRule(4, length2);
                                    break;
                                case 'X':
                                    selectNumberRule = Iso8601_Rule.getRule(length2);
                                    break;
                                case 'Y':
                                    break;
                                case 'Z':
                                    if (length2 != 1) {
                                        if (length2 != 2) {
                                            selectNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
                                            break;
                                        } else {
                                            selectNumberRule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                            break;
                                        }
                                    } else {
                                        selectNumberRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                        break;
                                    }
                                default:
                                    throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                            }
                    }
                    arrayList.add(selectNumberRule);
                    i = i3 + 1;
                    break;
            }
            if (length2 == 2) {
                selectNumberRule = TwoDigitYearField.INSTANCE;
            } else {
                int i4 = length2;
                if (length2 < 4) {
                    i4 = 4;
                }
                selectNumberRule = selectNumberRule(1, i4);
            }
            arrayList.add(selectNumberRule);
            i = i3 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d6, code lost:
        r9 = r8 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String parseToken(java.lang.String r5, int[] r6) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.utils.FastDatePrinter.parseToken(java.lang.String, int[]):java.lang.String");
    }

    protected NumberRule selectNumberRule(int i, int i2) {
        return i2 != 1 ? i2 != 2 ? new PaddedNumberField(i, i2) : new TwoDigitNumberField(i) : new UnpaddedNumberField(i);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }
}
