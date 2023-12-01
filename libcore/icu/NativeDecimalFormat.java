package libcore.icu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeDecimalFormat.class */
public final class NativeDecimalFormat implements Cloneable {
    private static final Format.Field[] ICU4C_FIELD_IDS = {NumberFormat.Field.INTEGER, NumberFormat.Field.FRACTION, NumberFormat.Field.DECIMAL_SEPARATOR, NumberFormat.Field.EXPONENT_SYMBOL, NumberFormat.Field.EXPONENT_SIGN, NumberFormat.Field.EXPONENT, NumberFormat.Field.GROUPING_SEPARATOR, NumberFormat.Field.CURRENCY, NumberFormat.Field.PERCENT, NumberFormat.Field.PERMILLE, NumberFormat.Field.SIGN};
    private static final int UNUM_CURRENCY_CODE = 5;
    private static final int UNUM_CURRENCY_SYMBOL = 8;
    private static final int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
    private static final int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
    private static final int UNUM_DEFAULT_RULESET = 6;
    private static final int UNUM_DIGIT_SYMBOL = 5;
    private static final int UNUM_EXPONENTIAL_SYMBOL = 11;
    private static final int UNUM_FORMAT_SYMBOL_COUNT = 18;
    private static final int UNUM_FORMAT_WIDTH = 13;
    private static final int UNUM_FRACTION_DIGITS = 8;
    private static final int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
    private static final int UNUM_GROUPING_SIZE = 10;
    private static final int UNUM_GROUPING_USED = 1;
    private static final int UNUM_INFINITY_SYMBOL = 14;
    private static final int UNUM_INTEGER_DIGITS = 5;
    private static final int UNUM_INTL_CURRENCY_SYMBOL = 9;
    private static final int UNUM_LENIENT_PARSE = 19;
    private static final int UNUM_MAX_FRACTION_DIGITS = 6;
    private static final int UNUM_MAX_INTEGER_DIGITS = 3;
    private static final int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
    private static final int UNUM_MINUS_SIGN_SYMBOL = 6;
    private static final int UNUM_MIN_FRACTION_DIGITS = 7;
    private static final int UNUM_MIN_INTEGER_DIGITS = 4;
    private static final int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
    private static final int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
    private static final int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
    private static final int UNUM_MULTIPLIER = 9;
    private static final int UNUM_NAN_SYMBOL = 15;
    private static final int UNUM_NEGATIVE_PREFIX = 2;
    private static final int UNUM_NEGATIVE_SUFFIX = 3;
    private static final int UNUM_PADDING_CHARACTER = 4;
    private static final int UNUM_PADDING_POSITION = 14;
    private static final int UNUM_PAD_ESCAPE_SYMBOL = 13;
    private static final int UNUM_PARSE_INT_ONLY = 0;
    private static final int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
    private static final int UNUM_PERCENT_SYMBOL = 3;
    private static final int UNUM_PERMILL_SYMBOL = 12;
    private static final int UNUM_PLUS_SIGN_SYMBOL = 7;
    private static final int UNUM_POSITIVE_PREFIX = 0;
    private static final int UNUM_POSITIVE_SUFFIX = 1;
    private static final int UNUM_PUBLIC_RULESETS = 7;
    private static final int UNUM_ROUNDING_INCREMENT = 12;
    private static final int UNUM_ROUNDING_MODE = 11;
    private static final int UNUM_SECONDARY_GROUPING_SIZE = 15;
    private static final int UNUM_SIGNIFICANT_DIGITS_USED = 16;
    private static final int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
    private static final int UNUM_ZERO_DIGIT_SYMBOL = 4;
    private long address;
    private String lastPattern;
    private boolean negPrefNull;
    private boolean negSuffNull;
    private transient boolean parseBigDecimal;
    private boolean posPrefNull;
    private boolean posSuffNull;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: libcore.icu.NativeDecimalFormat$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeDecimalFormat$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:43:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:45:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006f -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0077 -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007b -> B:47:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x007f -> B:41:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeDecimalFormat$FieldPositionIterator.class */
    public static class FieldPositionIterator {
        private int[] data;
        private int pos;

        private FieldPositionIterator() {
            this.pos = -3;
        }

        /* synthetic */ FieldPositionIterator(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static FieldPositionIterator forFieldPosition(FieldPosition fieldPosition) {
            if (fieldPosition != null) {
                return new FieldPositionIterator();
            }
            return null;
        }

        private void setData(int[] iArr) {
            this.data = iArr;
            this.pos = -3;
        }

        public Format.Field field() {
            return NativeDecimalFormat.ICU4C_FIELD_IDS[this.data[this.pos]];
        }

        public int fieldId() {
            return this.data[this.pos];
        }

        public int limit() {
            return this.data[this.pos + 2];
        }

        public boolean next() {
            if (this.data == null) {
                return false;
            }
            this.pos += 3;
            return this.pos < this.data.length;
        }

        public int start() {
            return this.data[this.pos + 1];
        }
    }

    public NativeDecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols) {
        try {
            this.address = open(str, decimalFormatSymbols.getCurrencySymbol(), decimalFormatSymbols.getDecimalSeparator(), decimalFormatSymbols.getDigit(), decimalFormatSymbols.getExponentSeparator(), decimalFormatSymbols.getGroupingSeparator(), decimalFormatSymbols.getInfinity(), decimalFormatSymbols.getInternationalCurrencySymbol(), decimalFormatSymbols.getMinusSignString(), decimalFormatSymbols.getMonetaryDecimalSeparator(), decimalFormatSymbols.getNaN(), decimalFormatSymbols.getPatternSeparator(), decimalFormatSymbols.getPercentString(), decimalFormatSymbols.getPerMill(), decimalFormatSymbols.getZeroDigit());
            this.lastPattern = str;
        } catch (NullPointerException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw new IllegalArgumentException("syntax error: " + e2.getMessage() + ": " + str);
        }
    }

    public NativeDecimalFormat(String str, LocaleData localeData) {
        this.address = open(str, localeData.currencySymbol, localeData.decimalSeparator, '#', localeData.exponentSeparator, localeData.groupingSeparator, localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign, localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator, localeData.percent, localeData.perMill, localeData.zeroDigit);
        this.lastPattern = str;
    }

    private static void applyPattern(long j, boolean z, String str) {
        try {
            applyPatternImpl(j, z, str);
        } catch (NullPointerException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw new IllegalArgumentException("syntax error: " + e2.getMessage() + ": " + str);
        }
    }

    private static native void applyPatternImpl(long j, boolean z, String str);

    private static native long cloneImpl(long j);

    private static native void close(long j);

    private static native char[] formatDigitList(long j, String str, FieldPositionIterator fieldPositionIterator);

    private static native char[] formatDouble(long j, double d, FieldPositionIterator fieldPositionIterator);

    private static native char[] formatLong(long j, long j2, FieldPositionIterator fieldPositionIterator);

    private static native int getAttribute(long j, int i);

    private static native String getTextAttribute(long j, int i);

    private int makeScalePositive(int i, StringBuilder sb) {
        int i2 = i;
        if (i < 0) {
            int i3 = -i;
            while (true) {
                int i4 = i3;
                if (i4 <= 0) {
                    break;
                }
                sb.append('0');
                i3 = i4 - 1;
            }
            i2 = 0;
        }
        return i2;
    }

    private static native long open(String str, String str2, char c2, char c3, String str3, char c4, String str4, String str5, String str6, char c5, String str7, char c6, String str8, char c7, char c8);

    private static native Number parse(long j, String str, ParsePosition parsePosition, boolean z);

    private static native void setAttribute(long j, int i, int i2);

    private static native void setDecimalFormatSymbols(long j, String str, char c2, char c3, String str2, char c4, String str3, String str4, String str5, char c5, String str6, char c6, String str7, char c7, char c8);

    private static native void setRoundingMode(long j, int i, double d);

    private static native void setSymbol(long j, int i, String str);

    private static native void setTextAttribute(long j, int i, String str);

    private static native String toPatternImpl(long j, boolean z);

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r0 > 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int translateFieldId(java.text.FieldPosition r3) {
        /*
            r0 = r3
            int r0 = r0.getField()
            r5 = r0
            r0 = r5
            r1 = -1
            if (r0 < r1) goto L11
            r0 = r5
            r4 = r0
            r0 = r5
            r1 = 1
            if (r0 <= r1) goto L13
        L11:
            r0 = -1
            r4 = r0
        L13:
            r0 = r4
            r6 = r0
            r0 = r4
            r1 = -1
            if (r0 != r1) goto L3f
            r0 = r3
            java.text.Format$Field r0 = r0.getFieldAttribute()
            r3 = r0
            r0 = r4
            r6 = r0
            r0 = r3
            if (r0 == 0) goto L3f
            r0 = 0
            r5 = r0
        L27:
            r0 = r4
            r6 = r0
            r0 = r5
            java.text.Format$Field[] r1 = libcore.icu.NativeDecimalFormat.ICU4C_FIELD_IDS
            int r1 = r1.length
            if (r0 >= r1) goto L3f
            java.text.Format$Field[] r0 = libcore.icu.NativeDecimalFormat.ICU4C_FIELD_IDS
            r1 = r5
            r0 = r0[r1]
            r1 = r3
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L41
            r0 = r5
            r6 = r0
        L3f:
            r0 = r6
            return r0
        L41:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: libcore.icu.NativeDecimalFormat.translateFieldId(java.text.FieldPosition):int");
    }

    private static void updateFieldPosition(FieldPosition fieldPosition, FieldPositionIterator fieldPositionIterator) {
        int translateFieldId = translateFieldId(fieldPosition);
        if (translateFieldId != -1) {
            while (fieldPositionIterator.next()) {
                if (fieldPositionIterator.fieldId() == translateFieldId) {
                    fieldPosition.setBeginIndex(fieldPositionIterator.start());
                    fieldPosition.setEndIndex(fieldPositionIterator.limit());
                    return;
                }
            }
        }
    }

    public void applyLocalizedPattern(String str) {
        applyPattern(this.address, true, str);
        this.lastPattern = null;
    }

    public void applyPattern(String str) {
        if (this.lastPattern == null || !str.equals(this.lastPattern)) {
            applyPattern(this.address, false, str);
            this.lastPattern = str;
        }
    }

    public Object clone() {
        try {
            NativeDecimalFormat nativeDecimalFormat = (NativeDecimalFormat) super.clone();
            nativeDecimalFormat.address = cloneImpl(this.address);
            nativeDecimalFormat.lastPattern = this.lastPattern;
            nativeDecimalFormat.negPrefNull = this.negPrefNull;
            nativeDecimalFormat.negSuffNull = this.negSuffNull;
            nativeDecimalFormat.posPrefNull = this.posPrefNull;
            nativeDecimalFormat.posSuffNull = this.posSuffNull;
            return nativeDecimalFormat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void close() {
        synchronized (this) {
            if (this.address != 0) {
                close(this.address);
                this.address = 0L;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NativeDecimalFormat) {
            NativeDecimalFormat nativeDecimalFormat = (NativeDecimalFormat) obj;
            if (nativeDecimalFormat.address != this.address) {
                return nativeDecimalFormat.toPattern().equals(toPattern()) && nativeDecimalFormat.isDecimalSeparatorAlwaysShown() == isDecimalSeparatorAlwaysShown() && nativeDecimalFormat.getGroupingSize() == getGroupingSize() && nativeDecimalFormat.getMultiplier() == getMultiplier() && nativeDecimalFormat.getNegativePrefix().equals(getNegativePrefix()) && nativeDecimalFormat.getNegativeSuffix().equals(getNegativeSuffix()) && nativeDecimalFormat.getPositivePrefix().equals(getPositivePrefix()) && nativeDecimalFormat.getPositiveSuffix().equals(getPositiveSuffix()) && nativeDecimalFormat.getMaximumIntegerDigits() == getMaximumIntegerDigits() && nativeDecimalFormat.getMaximumFractionDigits() == getMaximumFractionDigits() && nativeDecimalFormat.getMinimumIntegerDigits() == getMinimumIntegerDigits() && nativeDecimalFormat.getMinimumFractionDigits() == getMinimumFractionDigits() && nativeDecimalFormat.isGroupingUsed() == isGroupingUsed();
            }
            return true;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public char[] formatBigDecimal(BigDecimal bigDecimal, FieldPosition fieldPosition) {
        FieldPositionIterator forFieldPosition = FieldPositionIterator.forFieldPosition(fieldPosition);
        char[] formatDigitList = formatDigitList(this.address, bigDecimal.toString(), forFieldPosition);
        if (forFieldPosition != null && fieldPosition != null) {
            updateFieldPosition(fieldPosition, forFieldPosition);
        }
        return formatDigitList;
    }

    public char[] formatBigInteger(BigInteger bigInteger, FieldPosition fieldPosition) {
        FieldPositionIterator forFieldPosition = FieldPositionIterator.forFieldPosition(fieldPosition);
        char[] formatDigitList = formatDigitList(this.address, bigInteger.toString(10), forFieldPosition);
        if (forFieldPosition != null && fieldPosition != null) {
            updateFieldPosition(fieldPosition, forFieldPosition);
        }
        return formatDigitList;
    }

    public char[] formatDouble(double d, FieldPosition fieldPosition) {
        FieldPositionIterator forFieldPosition = FieldPositionIterator.forFieldPosition(fieldPosition);
        char[] formatDouble = formatDouble(this.address, d, forFieldPosition);
        if (forFieldPosition != null && fieldPosition != null) {
            updateFieldPosition(fieldPosition, forFieldPosition);
        }
        return formatDouble;
    }

    public char[] formatLong(long j, FieldPosition fieldPosition) {
        FieldPositionIterator forFieldPosition = FieldPositionIterator.forFieldPosition(fieldPosition);
        char[] formatLong = formatLong(this.address, j, forFieldPosition);
        if (forFieldPosition != null && fieldPosition != null) {
            updateFieldPosition(fieldPosition, forFieldPosition);
        }
        return formatLong;
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        String str;
        if (obj == null) {
            throw new NullPointerException("object == null");
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            FieldPositionIterator fieldPositionIterator = new FieldPositionIterator(null);
            if ((number instanceof BigInteger) || (number instanceof BigDecimal)) {
                str = new String(formatDigitList(this.address, number.toString(), fieldPositionIterator));
            } else if ((number instanceof Double) || (number instanceof Float)) {
                str = new String(formatDouble(this.address, number.doubleValue(), fieldPositionIterator));
            } else {
                str = new String(formatLong(this.address, number.longValue(), fieldPositionIterator));
            }
            AttributedString attributedString = new AttributedString(str);
            while (fieldPositionIterator.next()) {
                Format.Field field = fieldPositionIterator.field();
                attributedString.addAttribute(field, field, fieldPositionIterator.start(), fieldPositionIterator.limit());
            }
            return attributedString.getIterator();
        }
        throw new IllegalArgumentException("object not a Number: " + obj.getClass());
    }

    public int getGroupingSize() {
        if (isGroupingUsed()) {
            return getAttribute(this.address, 10);
        }
        return 0;
    }

    public int getMaximumFractionDigits() {
        return getAttribute(this.address, 6);
    }

    public int getMaximumIntegerDigits() {
        return getAttribute(this.address, 3);
    }

    public int getMinimumFractionDigits() {
        return getAttribute(this.address, 7);
    }

    public int getMinimumIntegerDigits() {
        return getAttribute(this.address, 4);
    }

    public int getMultiplier() {
        return getAttribute(this.address, 9);
    }

    public String getNegativePrefix() {
        if (this.negPrefNull) {
            return null;
        }
        return getTextAttribute(this.address, 2);
    }

    public String getNegativeSuffix() {
        if (this.negSuffNull) {
            return null;
        }
        return getTextAttribute(this.address, 3);
    }

    public String getPositivePrefix() {
        if (this.posPrefNull) {
            return null;
        }
        return getTextAttribute(this.address, 0);
    }

    public String getPositiveSuffix() {
        if (this.posSuffNull) {
            return null;
        }
        return getTextAttribute(this.address, 1);
    }

    public boolean isDecimalSeparatorAlwaysShown() {
        return getAttribute(this.address, 2) != 0;
    }

    public boolean isGroupingUsed() {
        return getAttribute(this.address, 1) != 0;
    }

    public boolean isParseBigDecimal() {
        return this.parseBigDecimal;
    }

    public boolean isParseIntegerOnly() {
        boolean z = false;
        if (getAttribute(this.address, 0) != 0) {
            z = true;
        }
        return z;
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return parse(this.address, str, parsePosition, this.parseBigDecimal);
    }

    public void setCurrency(String str, String str2) {
        setSymbol(this.address, 8, str);
        setSymbol(this.address, 9, str2);
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        setDecimalFormatSymbols(this.address, decimalFormatSymbols.getCurrencySymbol(), decimalFormatSymbols.getDecimalSeparator(), decimalFormatSymbols.getDigit(), decimalFormatSymbols.getExponentSeparator(), decimalFormatSymbols.getGroupingSeparator(), decimalFormatSymbols.getInfinity(), decimalFormatSymbols.getInternationalCurrencySymbol(), decimalFormatSymbols.getMinusSignString(), decimalFormatSymbols.getMonetaryDecimalSeparator(), decimalFormatSymbols.getNaN(), decimalFormatSymbols.getPatternSeparator(), decimalFormatSymbols.getPercentString(), decimalFormatSymbols.getPerMill(), decimalFormatSymbols.getZeroDigit());
    }

    public void setDecimalFormatSymbols(LocaleData localeData) {
        setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator, '#', localeData.exponentSeparator, localeData.groupingSeparator, localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign, localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator, localeData.percent, localeData.perMill, localeData.zeroDigit);
    }

    public void setDecimalSeparatorAlwaysShown(boolean z) {
        setAttribute(this.address, 2, z ? -1 : 0);
    }

    public void setGroupingSize(int i) {
        setAttribute(this.address, 10, i);
    }

    public void setGroupingUsed(boolean z) {
        setAttribute(this.address, 1, z ? -1 : 0);
    }

    public void setMaximumFractionDigits(int i) {
        setAttribute(this.address, 6, i);
    }

    public void setMaximumIntegerDigits(int i) {
        setAttribute(this.address, 3, i);
    }

    public void setMinimumFractionDigits(int i) {
        setAttribute(this.address, 7, i);
    }

    public void setMinimumIntegerDigits(int i) {
        setAttribute(this.address, 4, i);
    }

    public void setMultiplier(int i) {
        setAttribute(this.address, 9, i);
    }

    public void setNegativePrefix(String str) {
        this.negPrefNull = str == null;
        if (this.negPrefNull) {
            return;
        }
        setTextAttribute(this.address, 2, str);
    }

    public void setNegativeSuffix(String str) {
        this.negSuffNull = str == null;
        if (this.negSuffNull) {
            return;
        }
        setTextAttribute(this.address, 3, str);
    }

    public void setParseBigDecimal(boolean z) {
        this.parseBigDecimal = z;
    }

    public void setParseIntegerOnly(boolean z) {
        setAttribute(this.address, 0, z ? -1 : 0);
    }

    public void setPositivePrefix(String str) {
        this.posPrefNull = str == null;
        if (this.posPrefNull) {
            return;
        }
        setTextAttribute(this.address, 0, str);
    }

    public void setPositiveSuffix(String str) {
        this.posSuffNull = str == null;
        if (this.posSuffNull) {
            return;
        }
        setTextAttribute(this.address, 1, str);
    }

    public void setRoundingMode(RoundingMode roundingMode, double d) {
        int i;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 4;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 7;
                break;
            default:
                throw new AssertionError();
        }
        setRoundingMode(this.address, i, d);
    }

    public String toLocalizedPattern() {
        return toPatternImpl(this.address, true);
    }

    public String toPattern() {
        return toPatternImpl(this.address, false);
    }

    public String toString() {
        return getClass().getName() + "[\"" + toPattern() + "\",isDecimalSeparatorAlwaysShown=" + isDecimalSeparatorAlwaysShown() + ",groupingSize=" + getGroupingSize() + ",multiplier=" + getMultiplier() + ",negativePrefix=" + getNegativePrefix() + ",negativeSuffix=" + getNegativeSuffix() + ",positivePrefix=" + getPositivePrefix() + ",positiveSuffix=" + getPositiveSuffix() + ",maxIntegerDigits=" + getMaximumIntegerDigits() + ",maxFractionDigits=" + getMaximumFractionDigits() + ",minIntegerDigits=" + getMinimumIntegerDigits() + ",minFractionDigits=" + getMinimumFractionDigits() + ",grouping=" + isGroupingUsed() + "]";
    }
}
