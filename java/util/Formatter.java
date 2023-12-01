package java.util;

import android.widget.ExpandableListView;
import com.amap.api.col.p0003sl.iu;
import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.nio.charset.Charset;
import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/util/Formatter.class */
public final class Formatter implements Closeable, Flushable {
    private static final char[] ZEROS = {'0', '0', '0', '0', '0', '0', '0', '0', '0'};
    private static final ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() { // from class: java.util.Formatter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public CachedDecimalFormat initialValue() {
            return new CachedDecimalFormat();
        }
    };
    private Object arg;
    private boolean closed;
    private FormatToken formatToken;
    private IOException lastIOException;
    private Locale locale;
    private LocaleData localeData;
    private Appendable out;

    /* loaded from: source-2895416-dex2jar.jar:java/util/Formatter$BigDecimalLayoutForm.class */
    public enum BigDecimalLayoutForm {
        SCIENTIFIC,
        DECIMAL_FLOAT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Formatter$CachedDecimalFormat.class */
    public static class CachedDecimalFormat {
        public LocaleData currentLocaleData;
        public String currentPattern;
        public NativeDecimalFormat decimalFormat;

        public NativeDecimalFormat update(LocaleData localeData, String str) {
            if (this.decimalFormat == null) {
                this.currentPattern = str;
                this.currentLocaleData = localeData;
                this.decimalFormat = new NativeDecimalFormat(this.currentPattern, this.currentLocaleData);
            }
            if (!str.equals(this.currentPattern)) {
                this.decimalFormat.applyPattern(str);
                this.currentPattern = str;
            }
            if (localeData != this.currentLocaleData) {
                this.decimalFormat.setDecimalFormatSymbols(localeData);
                this.currentLocaleData = localeData;
            }
            return this.decimalFormat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Formatter$FormatSpecifierParser.class */
    public static class FormatSpecifierParser {
        private String format;
        private int i;
        private int length;
        private int startIndex;

        FormatSpecifierParser(String str) {
            this.format = str;
            this.length = str.length();
        }

        private char advance() {
            if (this.i >= this.length) {
                throw unknownFormatConversionException();
            }
            String str = this.format;
            int i = this.i;
            this.i = i + 1;
            return str.charAt(i);
        }

        private int failNextInt() {
            while (Character.isDigit(peek())) {
                advance();
            }
            return -1;
        }

        private int nextInt() {
            int i;
            long j = 0;
            while (this.i < this.length && Character.isDigit(this.format.charAt(this.i))) {
                String str = this.format;
                this.i = this.i + 1;
                long charAt = (10 * j) + (str.charAt(i) - '0');
                j = charAt;
                if (charAt > 2147483647L) {
                    return failNextInt();
                }
            }
            return (int) j;
        }

        private FormatToken parseArgumentIndexAndFlags(FormatToken formatToken) {
            int i = this.i;
            int peek = peek();
            if (Character.isDigit(peek)) {
                int nextInt = nextInt();
                if (peek() == 36) {
                    advance();
                    if (nextInt == -1) {
                        throw new MissingFormatArgumentException(getFormatSpecifierText());
                    }
                    formatToken.setArgIndex(Math.max(0, nextInt - 1));
                } else if (peek != 48) {
                    return parseWidth(formatToken, nextInt);
                } else {
                    this.i = i;
                }
            } else if (peek == 60) {
                formatToken.setArgIndex(-2);
                advance();
            }
            while (formatToken.setFlag(peek())) {
                advance();
            }
            int peek2 = peek();
            return Character.isDigit(peek2) ? parseWidth(formatToken, nextInt()) : peek2 == 46 ? parsePrecision(formatToken) : parseConversionType(formatToken);
        }

        private FormatToken parseConversionType(FormatToken formatToken) {
            char advance = advance();
            formatToken.setConversionType(advance);
            if (advance == 't' || advance == 'T') {
                formatToken.setDateSuffix(advance());
            }
            return formatToken;
        }

        private FormatToken parsePrecision(FormatToken formatToken) {
            advance();
            if (Character.isDigit(peek())) {
                formatToken.setPrecision(nextInt());
                return parseConversionType(formatToken);
            }
            throw unknownFormatConversionException();
        }

        private FormatToken parseWidth(FormatToken formatToken, int i) {
            formatToken.setWidth(i);
            return peek() == 46 ? parsePrecision(formatToken) : parseConversionType(formatToken);
        }

        private int peek() {
            if (this.i < this.length) {
                return this.format.charAt(this.i);
            }
            return -1;
        }

        private UnknownFormatConversionException unknownFormatConversionException() {
            throw new UnknownFormatConversionException(getFormatSpecifierText());
        }

        String getFormatSpecifierText() {
            return this.format.substring(this.startIndex, this.i);
        }

        FormatToken parseFormatToken(int i) {
            this.startIndex = i;
            this.i = i;
            return parseArgumentIndexAndFlags(new FormatToken());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Formatter$FormatToken.class */
    public static class FormatToken {
        static final int DEFAULT_PRECISION = 6;
        static final int FLAGS_UNSET = 0;
        static final int FLAG_ZERO = 16;
        static final int LAST_ARGUMENT_INDEX = -2;
        static final int UNSET = -1;
        private int argIndex;
        private char conversionType;
        private char dateSuffix;
        boolean flagComma;
        boolean flagMinus;
        boolean flagParenthesis;
        boolean flagPlus;
        boolean flagSharp;
        boolean flagSpace;
        boolean flagZero;
        private int precision;
        private StringBuilder strFlags;
        private int width;

        private FormatToken() {
            this.argIndex = -1;
            this.conversionType = (char) 65535;
            this.precision = -1;
            this.width = -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0286, code lost:
            if ((r6 instanceof java.math.BigInteger) != false) goto L103;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void checkFlags(java.lang.Object r6) {
            /*
                Method dump skipped, instructions count: 1078
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatToken.checkFlags(java.lang.Object):void");
        }

        int getArgIndex() {
            return this.argIndex;
        }

        char getConversionType() {
            return this.conversionType;
        }

        char getDateSuffix() {
            return this.dateSuffix;
        }

        int getPrecision() {
            return this.precision;
        }

        String getStrFlags() {
            return this.strFlags != null ? this.strFlags.toString() : "";
        }

        int getWidth() {
            return this.width;
        }

        boolean isDefault() {
            return (this.flagComma || this.flagMinus || this.flagParenthesis || this.flagPlus || this.flagSharp || this.flagSpace || this.flagZero || this.width != -1 || this.precision != -1) ? false : true;
        }

        boolean isPrecisionSet() {
            return this.precision != -1;
        }

        boolean requireArgument() {
            return (this.conversionType == '%' || this.conversionType == 'n') ? false : true;
        }

        void setArgIndex(int i) {
            this.argIndex = i;
        }

        void setConversionType(char c2) {
            this.conversionType = c2;
        }

        void setDateSuffix(char c2) {
            this.dateSuffix = c2;
        }

        boolean setFlag(int i) {
            boolean z;
            switch (i) {
                case 32:
                    z = this.flagSpace;
                    this.flagSpace = true;
                    break;
                case 35:
                    z = this.flagSharp;
                    this.flagSharp = true;
                    break;
                case 40:
                    z = this.flagParenthesis;
                    this.flagParenthesis = true;
                    break;
                case 43:
                    z = this.flagPlus;
                    this.flagPlus = true;
                    break;
                case 44:
                    z = this.flagComma;
                    this.flagComma = true;
                    break;
                case 45:
                    z = this.flagMinus;
                    this.flagMinus = true;
                    break;
                case 48:
                    z = this.flagZero;
                    this.flagZero = true;
                    break;
                default:
                    return false;
            }
            if (z) {
                throw new DuplicateFormatFlagsException(String.valueOf(i));
            }
            if (this.strFlags == null) {
                this.strFlags = new StringBuilder(7);
            }
            this.strFlags.append((char) i);
            return true;
        }

        void setPrecision(int i) {
            this.precision = i;
        }

        void setWidth(int i) {
            this.width = i;
        }

        public UnknownFormatConversionException unknownFormatConversionException() {
            if (this.conversionType == 't' || this.conversionType == 'T') {
                throw new UnknownFormatConversionException(String.format("%c%c", Character.valueOf(this.conversionType), Character.valueOf(this.dateSuffix)));
            }
            throw new UnknownFormatConversionException(String.valueOf(this.conversionType));
        }
    }

    public Formatter() {
        this(new StringBuilder(), Locale.getDefault());
    }

    public Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
    }

    public Formatter(File file, String str) throws FileNotFoundException, UnsupportedEncodingException {
        this(file, str, Locale.getDefault());
    }

    public Formatter(File file, String str, Locale locale) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        this.closed = false;
        try {
            FileOutputStream fileOutputStream3 = new FileOutputStream(file);
            try {
                this.out = new BufferedWriter(new OutputStreamWriter(fileOutputStream3, str));
                this.locale = locale;
            } catch (UnsupportedEncodingException e) {
                fileOutputStream2 = fileOutputStream3;
                e = e;
                IoUtils.closeQuietly(fileOutputStream2);
                throw e;
            } catch (RuntimeException e2) {
                fileOutputStream = fileOutputStream3;
                e = e2;
                IoUtils.closeQuietly(fileOutputStream);
                throw e;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            fileOutputStream2 = null;
        } catch (RuntimeException e4) {
            e = e4;
            fileOutputStream = null;
        }
    }

    public Formatter(OutputStream outputStream) {
        this.closed = false;
        this.out = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.defaultCharset()));
        this.locale = Locale.getDefault();
    }

    public Formatter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        this(outputStream, str, Locale.getDefault());
    }

    public Formatter(OutputStream outputStream, String str, Locale locale) throws UnsupportedEncodingException {
        this.closed = false;
        this.out = new BufferedWriter(new OutputStreamWriter(outputStream, str));
        this.locale = locale;
    }

    public Formatter(PrintStream printStream) {
        this.closed = false;
        if (printStream == null) {
            throw new NullPointerException("ps == null");
        }
        this.out = printStream;
        this.locale = Locale.getDefault();
    }

    public Formatter(Appendable appendable) {
        this(appendable, Locale.getDefault());
    }

    public Formatter(Appendable appendable, Locale locale) {
        this.closed = false;
        if (appendable == null) {
            this.out = new StringBuilder();
        } else {
            this.out = appendable;
        }
        this.locale = locale;
    }

    public Formatter(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public Formatter(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(str), str2);
    }

    public Formatter(String str, String str2, Locale locale) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(str), str2, locale);
    }

    public Formatter(Locale locale) {
        this(new StringBuilder(), locale);
    }

    private void appendLocalized(StringBuilder sb, long j, int i) {
        int length = sb.length();
        char c2 = this.localeData.zeroDigit;
        if (c2 == '0') {
            sb.append(j);
        } else {
            sb.append(localizeDigits(Long.toString(j)));
        }
        int length2 = i - (sb.length() - length);
        if (length2 <= 0) {
            return;
        }
        if (c2 == '0') {
            sb.insert(length, ZEROS, 0, length2);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length2) {
                return;
            }
            sb.insert(length, c2);
            i2 = i3 + 1;
        }
    }

    private boolean appendT(StringBuilder sb, char c2, Calendar calendar) {
        switch (c2) {
            case 'A':
                sb.append(this.localeData.longWeekdayNames[calendar.get(7)]);
                return true;
            case 'B':
                sb.append(this.localeData.longMonthNames[calendar.get(2)]);
                return true;
            case 'C':
                appendLocalized(sb, calendar.get(1) / 100, 2);
                return true;
            case 'D':
                appendT(sb, 'm', calendar);
                sb.append('/');
                appendT(sb, 'd', calendar);
                sb.append('/');
                appendT(sb, 'y', calendar);
                return true;
            case 'E':
            case 'G':
            case 'J':
            case 'K':
            case 'O':
            case 'P':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case '[':
            case '\\':
            case ']':
            case '^':
            case '_':
            case '`':
            case 'f':
            case 'g':
            case 'i':
            case 'n':
            case 'o':
            case 'q':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            default:
                return false;
            case 'F':
                appendT(sb, 'Y', calendar);
                sb.append('-');
                appendT(sb, 'm', calendar);
                sb.append('-');
                appendT(sb, 'd', calendar);
                return true;
            case 'H':
                appendLocalized(sb, calendar.get(11), 2);
                return true;
            case 'I':
                appendLocalized(sb, to12Hour(calendar.get(10)), 2);
                return true;
            case 'L':
                appendLocalized(sb, calendar.get(14), 3);
                return true;
            case 'M':
                appendLocalized(sb, calendar.get(12), 2);
                return true;
            case 'N':
                appendLocalized(sb, calendar.get(14) * 1000000, 9);
                return true;
            case 'Q':
                appendLocalized(sb, calendar.getTimeInMillis(), 0);
                return true;
            case 'R':
                appendT(sb, 'H', calendar);
                sb.append(':');
                appendT(sb, 'M', calendar);
                return true;
            case 'S':
                appendLocalized(sb, calendar.get(13), 2);
                return true;
            case 'T':
                appendT(sb, 'H', calendar);
                sb.append(':');
                appendT(sb, 'M', calendar);
                sb.append(':');
                appendT(sb, 'S', calendar);
                return true;
            case 'Y':
                appendLocalized(sb, calendar.get(1), 4);
                return true;
            case 'Z':
                TimeZone timeZone = calendar.getTimeZone();
                sb.append(timeZone.getDisplayName(timeZone.inDaylightTime(calendar.getTime()), 0, this.locale));
                return true;
            case 'a':
                sb.append(this.localeData.shortWeekdayNames[calendar.get(7)]);
                return true;
            case 'b':
            case 'h':
                sb.append(this.localeData.shortMonthNames[calendar.get(2)]);
                return true;
            case 'c':
                appendT(sb, 'a', calendar);
                sb.append(' ');
                appendT(sb, 'b', calendar);
                sb.append(' ');
                appendT(sb, 'd', calendar);
                sb.append(' ');
                appendT(sb, 'T', calendar);
                sb.append(' ');
                appendT(sb, 'Z', calendar);
                sb.append(' ');
                appendT(sb, 'Y', calendar);
                return true;
            case 'd':
                appendLocalized(sb, calendar.get(5), 2);
                return true;
            case 'e':
                appendLocalized(sb, calendar.get(5), 0);
                return true;
            case 'j':
                appendLocalized(sb, calendar.get(6), 3);
                return true;
            case 'k':
                appendLocalized(sb, calendar.get(11), 0);
                return true;
            case 'l':
                appendLocalized(sb, to12Hour(calendar.get(10)), 0);
                return true;
            case 'm':
                appendLocalized(sb, calendar.get(2) + 1, 2);
                return true;
            case 'p':
                sb.append(this.localeData.amPm[calendar.get(9)].toLowerCase(this.locale));
                return true;
            case 'r':
                appendT(sb, 'I', calendar);
                sb.append(':');
                appendT(sb, 'M', calendar);
                sb.append(':');
                appendT(sb, 'S', calendar);
                sb.append(' ');
                sb.append(this.localeData.amPm[calendar.get(9)]);
                return true;
            case 's':
                appendLocalized(sb, calendar.getTimeInMillis() / 1000, 0);
                return true;
            case 'y':
                appendLocalized(sb, calendar.get(1) % 100, 2);
                return true;
            case 'z':
                long j = calendar.get(15) + calendar.get(16);
                char c3 = '+';
                long j2 = j;
                if (j < 0) {
                    c3 = '-';
                    j2 = -j;
                }
                sb.append(c3);
                appendLocalized(sb, j2 / 3600000, 2);
                appendLocalized(sb, (j2 % 3600000) / 60000, 2);
                return true;
        }
    }

    private IllegalFormatConversionException badArgumentType() {
        throw new IllegalFormatConversionException(this.formatToken.getConversionType(), this.arg.getClass());
    }

    private void checkNotClosed() {
        if (this.closed) {
            throw new FormatterClosedException();
        }
    }

    private void doFormat(String str, Object... objArr) {
        int indexOf;
        int argIndex;
        checkNotClosed();
        FormatSpecifierParser formatSpecifierParser = new FormatSpecifierParser(str);
        boolean z = false;
        int length = str.length();
        Object obj = null;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 = indexOf) {
            indexOf = str.indexOf(37, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            if (indexOf > i2) {
                outputCharSequence(str, i2, indexOf);
            }
            if (indexOf < length) {
                FormatToken parseFormatToken = formatSpecifierParser.parseFormatToken(indexOf + 1);
                Object obj2 = null;
                if (parseFormatToken.requireArgument()) {
                    if (parseFormatToken.getArgIndex() == -1) {
                        argIndex = i;
                        i++;
                    } else {
                        argIndex = parseFormatToken.getArgIndex();
                    }
                    obj2 = getArgument(objArr, argIndex, formatSpecifierParser, obj, z);
                    obj = obj2;
                    z = true;
                }
                CharSequence transform = transform(parseFormatToken, obj2);
                if (transform != null) {
                    outputCharSequence(transform, 0, transform.length());
                }
                indexOf = formatSpecifierParser.i;
            }
        }
    }

    private Object getArgument(Object[] objArr, int i, FormatSpecifierParser formatSpecifierParser, Object obj, boolean z) {
        if (i != -2 || z) {
            if (objArr == null) {
                obj = null;
            } else if (i >= objArr.length) {
                throw new MissingFormatArgumentException(formatSpecifierParser.getFormatSpecifierText());
            } else {
                if (i != -2) {
                    return objArr[i];
                }
            }
            return obj;
        }
        throw new MissingFormatArgumentException(SimpleComparison.LESS_THAN_OPERATION);
    }

    private NativeDecimalFormat getDecimalFormat(String str) {
        return cachedDecimalFormat.get().update(this.localeData, str);
    }

    private CharSequence insertGrouping(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length() + (charSequence.length() / 3));
        int length = charSequence.length();
        int i = 0;
        int i2 = length;
        if (charSequence.charAt(0) == '-') {
            i2 = length - 1;
            i = 0 + 1;
            sb.append('-');
        }
        int i3 = i2 % 3;
        int i4 = i3;
        if (i3 == 0) {
            i4 = 3;
        }
        sb.append(charSequence, i, i + i4);
        int i5 = i;
        int i6 = i4;
        while (true) {
            int i7 = i5 + i6;
            if (i7 >= charSequence.length()) {
                return sb;
            }
            sb.append(this.localeData.groupingSeparator);
            sb.append(charSequence, i7, i7 + 3);
            i5 = i7;
            i6 = 3;
        }
    }

    private CharSequence localizeDigits(CharSequence charSequence) {
        int length = charSequence.length();
        char c2 = this.localeData.zeroDigit;
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb;
            }
            char charAt = charSequence.charAt(i2);
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

    private void outputCharSequence(CharSequence charSequence, int i, int i2) {
        try {
            this.out.append(charSequence, i, i2);
        } catch (IOException e) {
            this.lastIOException = e;
        }
    }

    private CharSequence padding(CharSequence charSequence, int i) {
        int i2 = i;
        int width = this.formatToken.getWidth();
        int precision = this.formatToken.getPrecision();
        int length = charSequence.length();
        int i3 = length;
        CharSequence charSequence2 = charSequence;
        if (precision >= 0) {
            i3 = Math.min(length, precision);
            if (charSequence instanceof StringBuilder) {
                ((StringBuilder) charSequence).setLength(i3);
                charSequence2 = charSequence;
            } else {
                charSequence2 = charSequence.subSequence(0, i3);
            }
        }
        int i4 = width;
        if (width > 0) {
            i4 = Math.max(charSequence2.length(), width);
        }
        if (i3 >= i4) {
            return charSequence2;
        }
        char c2 = ' ';
        if (this.formatToken.flagZero) {
            c2 = this.formatToken.getConversionType() == 'd' ? this.localeData.zeroDigit : '0';
        } else {
            i2 = 0;
        }
        char[] cArr = new char[i4 - i3];
        Arrays.fill(cArr, c2);
        boolean z = this.formatToken.flagMinus;
        StringBuilder stringBuilder = toStringBuilder(charSequence2);
        if (z) {
            stringBuilder.append(cArr);
        } else {
            stringBuilder.insert(i2, cArr);
        }
        return stringBuilder;
    }

    private static boolean startsWithMinusSign(CharSequence charSequence, String str) {
        if (charSequence.length() < str.length()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            if (str.charAt(i2) != charSequence.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private int to12Hour(int i) {
        int i2 = i;
        if (i == 0) {
            i2 = 12;
        }
        return i2;
    }

    private StringBuilder toStringBuilder(CharSequence charSequence) {
        return charSequence instanceof StringBuilder ? (StringBuilder) charSequence : new StringBuilder(charSequence);
    }

    private CharSequence transform(FormatToken formatToken, Object obj) {
        String transformFromDateTime;
        String str;
        this.formatToken = formatToken;
        this.arg = obj;
        if (formatToken.isDefault()) {
            switch (formatToken.getConversionType()) {
                case 'd':
                    boolean z = this.localeData.zeroDigit != '0';
                    if ((this.out instanceof StringBuilder) && !z) {
                        if ((this.arg instanceof Integer) || (this.arg instanceof Short) || (this.arg instanceof Byte)) {
                            IntegralToString.appendInt((StringBuilder) this.out, ((Number) this.arg).intValue());
                            return null;
                        } else if (this.arg instanceof Long) {
                            IntegralToString.appendLong((StringBuilder) this.out, ((Long) this.arg).longValue());
                            return null;
                        }
                    }
                    if ((this.arg instanceof Integer) || (this.arg instanceof Long) || (this.arg instanceof Short) || (this.arg instanceof Byte)) {
                        String obj2 = this.arg.toString();
                        str = obj2;
                        if (z) {
                            return localizeDigits(obj2);
                        }
                        return str;
                    }
                    break;
                case 's':
                    if (this.arg == null) {
                        str = b.l;
                        return str;
                    } else if (!(this.arg instanceof Formattable)) {
                        return this.arg.toString();
                    }
                    break;
            }
        }
        this.formatToken.checkFlags(this.arg);
        switch (formatToken.getConversionType()) {
            case '%':
                transformFromDateTime = transformFromPercent();
                break;
            case 'A':
            case 'E':
            case 'G':
            case 'a':
            case 'e':
            case 'f':
            case 'g':
                transformFromDateTime = transformFromFloat();
                break;
            case 'B':
            case 'b':
                transformFromDateTime = transformFromBoolean();
                break;
            case 'C':
            case 'c':
                transformFromDateTime = transformFromCharacter();
                break;
            case 'H':
            case 'h':
                transformFromDateTime = transformFromHashCode();
                break;
            case 'S':
            case 's':
                transformFromDateTime = transformFromString();
                break;
            case 'T':
            case 't':
                transformFromDateTime = transformFromDateTime();
                break;
            case 'X':
            case 'd':
            case 'o':
            case 'x':
                if (this.arg != null && !(this.arg instanceof BigInteger)) {
                    transformFromDateTime = transformFromInteger();
                    break;
                } else {
                    transformFromDateTime = transformFromBigInteger();
                    break;
                }
            case 'n':
                transformFromDateTime = System.lineSeparator();
                break;
            default:
                throw formatToken.unknownFormatConversionException();
        }
        str = transformFromDateTime;
        if (Character.isUpperCase(formatToken.getConversionType())) {
            str = transformFromDateTime;
            if (transformFromDateTime != null) {
                return transformFromDateTime.toString().toUpperCase(this.locale);
            }
        }
        return str;
    }

    private void transformA(StringBuilder sb) {
        if (this.arg instanceof Float) {
            sb.append(Float.toHexString(((Float) this.arg).floatValue()));
        } else if (!(this.arg instanceof Double)) {
            throw badArgumentType();
        } else {
            sb.append(Double.toHexString(((Double) this.arg).doubleValue()));
        }
        if (this.formatToken.isPrecisionSet()) {
            int precision = this.formatToken.getPrecision();
            int i = precision;
            if (precision == 0) {
                i = 1;
            }
            int indexOf = sb.indexOf(".") + 1;
            int indexOf2 = sb.indexOf("p");
            int i2 = indexOf2 - indexOf;
            if (i2 != i) {
                if (i2 >= i) {
                    sb.delete(indexOf + i, indexOf2);
                    return;
                }
                char[] cArr = new char[i - i2];
                Arrays.fill(cArr, '0');
                sb.insert(indexOf2, cArr);
            }
        }
    }

    private void transformE(StringBuilder sb) {
        int precision = this.formatToken.getPrecision();
        String str = "0E+00";
        if (precision > 0) {
            StringBuilder sb2 = new StringBuilder("0.");
            char[] cArr = new char[precision];
            Arrays.fill(cArr, '0');
            sb2.append(cArr);
            sb2.append("E+00");
            str = sb2.toString();
        }
        NativeDecimalFormat decimalFormat = getDecimalFormat(str);
        char[] formatBigDecimal = this.arg instanceof BigDecimal ? decimalFormat.formatBigDecimal((BigDecimal) this.arg, null) : decimalFormat.formatDouble(((Number) this.arg).doubleValue(), null);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= formatBigDecimal.length) {
                break;
            }
            if (formatBigDecimal[i2] == 'E') {
                formatBigDecimal[i2] = 'e';
            }
            i = i2 + 1;
        }
        sb.append(formatBigDecimal);
        if (this.formatToken.flagSharp && precision == 0) {
            sb.insert(sb.indexOf(iu.h), this.localeData.decimalSeparator);
        }
    }

    private void transformF(StringBuilder sb) {
        String str = "0.000000";
        int precision = this.formatToken.getPrecision();
        if (this.formatToken.flagComma || precision != 6) {
            StringBuilder sb2 = new StringBuilder();
            if (this.formatToken.flagComma) {
                sb2.append(',');
                char[] cArr = new char[2];
                Arrays.fill(cArr, '#');
                sb2.append(cArr);
            }
            sb2.append('0');
            if (precision > 0) {
                sb2.append('.');
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= precision) {
                        break;
                    }
                    sb2.append('0');
                    i = i2 + 1;
                }
            }
            str = sb2.toString();
        }
        NativeDecimalFormat decimalFormat = getDecimalFormat(str);
        if (this.arg instanceof BigDecimal) {
            sb.append(decimalFormat.formatBigDecimal((BigDecimal) this.arg, null));
        } else {
            sb.append(decimalFormat.formatDouble(((Number) this.arg).doubleValue(), null));
        }
        if (this.formatToken.flagSharp && precision == 0) {
            sb.append(this.localeData.decimalSeparator);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0111, code lost:
        if (r0 == 'X') goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.CharSequence transformFromBigInteger() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.transformFromBigInteger():java.lang.CharSequence");
    }

    private CharSequence transformFromBoolean() {
        return padding(this.arg instanceof Boolean ? this.arg.toString() : this.arg == null ? "false" : "true", 0);
    }

    private CharSequence transformFromCharacter() {
        if (this.arg == null) {
            return padding(b.l, 0);
        }
        if (this.arg instanceof Character) {
            return padding(String.valueOf(this.arg), 0);
        }
        if ((this.arg instanceof Byte) || (this.arg instanceof Short) || (this.arg instanceof Integer)) {
            int intValue = ((Number) this.arg).intValue();
            if (Character.isValidCodePoint(intValue)) {
                return padding(intValue < 65536 ? String.valueOf((char) intValue) : String.valueOf(Character.toChars(intValue)), 0);
            }
            throw new IllegalFormatCodePointException(intValue);
        }
        throw badArgumentType();
    }

    private CharSequence transformFromDateTime() {
        Date date;
        Calendar calendar;
        if (this.arg == null) {
            return transformFromNull();
        }
        if (this.arg instanceof Calendar) {
            calendar = (Calendar) this.arg;
        } else {
            if (this.arg instanceof Long) {
                date = new Date(((Long) this.arg).longValue());
            } else if (!(this.arg instanceof Date)) {
                throw badArgumentType();
            } else {
                date = (Date) this.arg;
            }
            Calendar calendar2 = Calendar.getInstance(this.locale);
            calendar2.setTime(date);
            calendar = calendar2;
        }
        StringBuilder sb = new StringBuilder();
        if (appendT(sb, this.formatToken.getDateSuffix(), calendar)) {
            return padding(sb, 0);
        }
        throw this.formatToken.unknownFormatConversionException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0181, code lost:
        if (startsWithMinusSign(r0, r5.localeData.minusSign) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x019e, code lost:
        if (r0 == 'A') goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.CharSequence transformFromFloat() {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.transformFromFloat():java.lang.CharSequence");
    }

    private CharSequence transformFromHashCode() {
        return padding(this.arg == null ? b.l : Integer.toHexString(this.arg.hashCode()), 0);
    }

    private CharSequence transformFromInteger() {
        long longValue;
        long j;
        int i;
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        char conversionType = this.formatToken.getConversionType();
        if (this.arg instanceof Long) {
            longValue = ((Long) this.arg).longValue();
        } else if (this.arg instanceof Integer) {
            longValue = ((Integer) this.arg).longValue();
        } else if (this.arg instanceof Short) {
            longValue = ((Short) this.arg).longValue();
        } else if (!(this.arg instanceof Byte)) {
            throw badArgumentType();
        } else {
            longValue = ((Byte) this.arg).longValue();
        }
        if (this.formatToken.flagSharp) {
            if (conversionType == 'o') {
                sb.append("0");
                i2 = 0 + 1;
            } else {
                sb.append("0x");
                i2 = 0 + 2;
            }
        }
        if (conversionType == 'd') {
            CharSequence l = Long.toString(longValue);
            CharSequence charSequence = l;
            if (this.formatToken.flagComma) {
                charSequence = insertGrouping(l);
            }
            CharSequence charSequence2 = charSequence;
            if (this.localeData.zeroDigit != '0') {
                charSequence2 = localizeDigits(charSequence);
            }
            sb.append(charSequence2);
            if (longValue < 0) {
                if (this.formatToken.flagParenthesis) {
                    return wrapParentheses(sb);
                }
                i = i2;
                if (this.formatToken.flagZero) {
                    i = i2 + 1;
                }
            } else if (this.formatToken.flagPlus) {
                sb.insert(0, '+');
                i = i2 + 1;
            } else {
                i = i2;
                if (this.formatToken.flagSpace) {
                    sb.insert(0, ' ');
                    i = i2 + 1;
                }
            }
        } else {
            if (this.arg instanceof Byte) {
                j = longValue & 255;
            } else if (this.arg instanceof Short) {
                j = longValue & 65535;
            } else {
                j = longValue;
                if (this.arg instanceof Integer) {
                    j = longValue & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                }
            }
            if (conversionType == 'o') {
                sb.append(Long.toOctalString(j));
                i = i2;
            } else {
                sb.append(Long.toHexString(j));
                i = i2;
            }
        }
        return padding(sb, i);
    }

    private CharSequence transformFromNull() {
        this.formatToken.flagZero = false;
        return padding(b.l, 0);
    }

    private CharSequence transformFromPercent() {
        return padding("%", 0);
    }

    private CharSequence transformFromSpecialNumber(double d) {
        String str;
        if (Double.isNaN(d)) {
            str = "NaN";
        } else if (d == Double.POSITIVE_INFINITY) {
            str = this.formatToken.flagPlus ? "+Infinity" : this.formatToken.flagSpace ? " Infinity" : "Infinity";
        } else if (d != Double.NEGATIVE_INFINITY) {
            return null;
        } else {
            str = this.formatToken.flagParenthesis ? "(Infinity)" : "-Infinity";
        }
        this.formatToken.setPrecision(-1);
        this.formatToken.flagZero = false;
        return padding(str, 0);
    }

    private CharSequence transformFromString() {
        if (!(this.arg instanceof Formattable)) {
            return padding(this.arg != null ? this.arg.toString() : b.l, 0);
        }
        int i = 0;
        if (this.formatToken.flagMinus) {
            i = 0 | 1;
        }
        int i2 = i;
        if (this.formatToken.flagSharp) {
            i2 = i | 4;
        }
        int i3 = i2;
        if (Character.isUpperCase(this.formatToken.getConversionType())) {
            i3 = i2 | 2;
        }
        ((Formattable) this.arg).formatTo(this, i3, this.formatToken.getWidth(), this.formatToken.getPrecision());
        return null;
    }

    private void transformG(StringBuilder sb) {
        boolean z;
        int precision = this.formatToken.getPrecision();
        int i = precision;
        if (precision == 0) {
            i = 1;
        }
        this.formatToken.setPrecision(i);
        double doubleValue = ((Number) this.arg).doubleValue();
        if (doubleValue == 0.0d) {
            this.formatToken.setPrecision(i - 1);
            transformF(sb);
            return;
        }
        double abs = Math.abs(doubleValue);
        if (Double.isInfinite(abs)) {
            this.formatToken.setPrecision(this.formatToken.getPrecision() - 1);
            transformE(sb);
            return;
        }
        BigDecimal bigDecimal = new BigDecimal(abs, new MathContext(i));
        double doubleValue2 = bigDecimal.doubleValue();
        long longValue = bigDecimal.longValue();
        if (doubleValue2 < 1.0d || doubleValue2 >= Math.pow(10.0d, i)) {
            long longValue2 = bigDecimal.movePointRight(4).longValue();
            z = true;
            if (doubleValue2 >= Math.pow(10.0d, -4.0d)) {
                z = true;
                if (doubleValue2 < 1.0d) {
                    int length = i + (4 - String.valueOf(longValue2).length());
                    int i2 = length;
                    if (String.valueOf(bigDecimal.movePointRight(length + 1).longValue()).length() <= this.formatToken.getPrecision()) {
                        i2 = length + 1;
                    }
                    z = false;
                    if (bigDecimal.movePointRight(i2).longValue() >= Math.pow(10.0d, i2 - 4)) {
                        this.formatToken.setPrecision(i2);
                        z = false;
                    }
                }
            }
        } else {
            z = true;
            if (longValue < Math.pow(10.0d, i)) {
                int length2 = i - String.valueOf(longValue).length();
                int i3 = length2;
                if (length2 < 0) {
                    i3 = 0;
                }
                int i4 = i3;
                if (String.valueOf(Math.round(Math.pow(10.0d, i3 + 1) * doubleValue2)).length() <= this.formatToken.getPrecision()) {
                    i4 = i3 + 1;
                }
                this.formatToken.setPrecision(i4);
                z = false;
            }
        }
        if (!z) {
            transformF(sb);
            return;
        }
        this.formatToken.setPrecision(this.formatToken.getPrecision() - 1);
        transformE(sb);
    }

    private StringBuilder wrapParentheses(StringBuilder sb) {
        sb.setCharAt(0, '(');
        if (!this.formatToken.flagZero) {
            sb.append(')');
            return (StringBuilder) padding(sb, 0);
        }
        this.formatToken.setWidth(this.formatToken.getWidth() - 1);
        StringBuilder sb2 = (StringBuilder) padding(sb, 1);
        sb2.append(')');
        return sb2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            if (this.out instanceof Closeable) {
                ((Closeable) this.out).close();
            }
        } catch (IOException e) {
            this.lastIOException = e;
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        checkNotClosed();
        if (this.out instanceof Flushable) {
            try {
                ((Flushable) this.out).flush();
            } catch (IOException e) {
                this.lastIOException = e;
            }
        }
    }

    public Formatter format(String str, Object... objArr) {
        return format(this.locale, str, objArr);
    }

    public Formatter format(Locale locale, String str, Object... objArr) {
        Locale locale2 = this.locale;
        Locale locale3 = locale;
        if (locale == null) {
            try {
                locale3 = Locale.US;
            } finally {
                this.locale = locale2;
            }
        }
        this.locale = locale3;
        this.localeData = LocaleData.get(this.locale);
        doFormat(str, objArr);
        return this;
    }

    public IOException ioException() {
        return this.lastIOException;
    }

    public Locale locale() {
        checkNotClosed();
        return this.locale;
    }

    public Appendable out() {
        checkNotClosed();
        return this.out;
    }

    public String toString() {
        checkNotClosed();
        return this.out.toString();
    }
}
