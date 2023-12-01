package java.util;

import com.amap.api.col.p0003sl.iu;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/util/Scanner.class */
public final class Scanner implements Closeable, Iterator<String> {
    private static final int DEFAULT_RADIX = 10;
    private CharBuffer buffer;
    private int bufferLength;
    private Pattern cachedFloatPattern;
    private Pattern cachedIntegerPattern;
    private int cachedIntegerPatternRadix;
    private int cachedNextIndex;
    private Object cachedNextValue;
    private boolean closed;
    private int currentRadix;
    private DecimalFormat decimalFormat;
    private Pattern delimiter;
    private int findStartIndex;
    private Readable input;
    private boolean inputExhausted;
    private IOException lastIOException;
    private Locale locale;
    private boolean matchSuccessful;
    private Matcher matcher;
    private int preStartIndex;
    private static final Pattern DEFAULT_DELIMITER = Pattern.compile("\\p{javaWhitespace}+");
    private static final Pattern BOOLEAN_PATTERN = Pattern.compile("true|false", 2);
    private static final String NL = "\n|\r\n|\r|\u0085|\u2028|\u2029";
    private static final Pattern LINE_TERMINATOR = Pattern.compile(NL);
    private static final Pattern MULTI_LINE_TERMINATOR = Pattern.compile("(\n|\r\n|\r|\u0085|\u2028|\u2029)+");
    private static final Pattern LINE_PATTERN = Pattern.compile(".*(\n|\r\n|\r|\u0085|\u2028|\u2029)|.+$");
    private static final Pattern ANY_PATTERN = Pattern.compile("(?s).*");

    public Scanner(File file) throws FileNotFoundException {
        this(file, Charset.defaultCharset().name());
    }

    public Scanner(File file, String str) throws FileNotFoundException {
        this.buffer = CharBuffer.allocate(1024);
        this.delimiter = DEFAULT_DELIMITER;
        this.currentRadix = 10;
        this.locale = Locale.getDefault();
        this.findStartIndex = 0;
        this.preStartIndex = this.findStartIndex;
        this.bufferLength = 0;
        this.closed = false;
        this.matchSuccessful = false;
        this.inputExhausted = false;
        this.cachedNextValue = null;
        this.cachedNextIndex = -1;
        this.cachedFloatPattern = null;
        this.cachedIntegerPatternRadix = -1;
        this.cachedIntegerPattern = null;
        if (file == null) {
            throw new NullPointerException("src == null");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        if (str == null) {
            throw new IllegalArgumentException("charsetName == null");
        }
        try {
            initialize(new InputStreamReader(fileInputStream, str));
        } catch (UnsupportedEncodingException e) {
            IoUtils.closeQuietly(fileInputStream);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Scanner(InputStream inputStream) {
        this(inputStream, Charset.defaultCharset().name());
    }

    public Scanner(InputStream inputStream, String str) {
        this.buffer = CharBuffer.allocate(1024);
        this.delimiter = DEFAULT_DELIMITER;
        this.currentRadix = 10;
        this.locale = Locale.getDefault();
        this.findStartIndex = 0;
        this.preStartIndex = this.findStartIndex;
        this.bufferLength = 0;
        this.closed = false;
        this.matchSuccessful = false;
        this.inputExhausted = false;
        this.cachedNextValue = null;
        this.cachedNextIndex = -1;
        this.cachedFloatPattern = null;
        this.cachedIntegerPatternRadix = -1;
        this.cachedIntegerPattern = null;
        if (inputStream == null) {
            throw new NullPointerException("src == null");
        }
        try {
            initialize(new InputStreamReader(inputStream, str));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Scanner(Readable readable) {
        this.buffer = CharBuffer.allocate(1024);
        this.delimiter = DEFAULT_DELIMITER;
        this.currentRadix = 10;
        this.locale = Locale.getDefault();
        this.findStartIndex = 0;
        this.preStartIndex = this.findStartIndex;
        this.bufferLength = 0;
        this.closed = false;
        this.matchSuccessful = false;
        this.inputExhausted = false;
        this.cachedNextValue = null;
        this.cachedNextIndex = -1;
        this.cachedFloatPattern = null;
        this.cachedIntegerPatternRadix = -1;
        this.cachedIntegerPattern = null;
        if (readable == null) {
            throw new NullPointerException("src == null");
        }
        initialize(readable);
    }

    public Scanner(String str) {
        this.buffer = CharBuffer.allocate(1024);
        this.delimiter = DEFAULT_DELIMITER;
        this.currentRadix = 10;
        this.locale = Locale.getDefault();
        this.findStartIndex = 0;
        this.preStartIndex = this.findStartIndex;
        this.bufferLength = 0;
        this.closed = false;
        this.matchSuccessful = false;
        this.inputExhausted = false;
        this.cachedNextValue = null;
        this.cachedNextIndex = -1;
        this.cachedFloatPattern = null;
        this.cachedIntegerPatternRadix = -1;
        this.cachedIntegerPattern = null;
        initialize(new StringReader(str));
    }

    public Scanner(ReadableByteChannel readableByteChannel) {
        this(readableByteChannel, Charset.defaultCharset().name());
    }

    public Scanner(ReadableByteChannel readableByteChannel, String str) {
        this.buffer = CharBuffer.allocate(1024);
        this.delimiter = DEFAULT_DELIMITER;
        this.currentRadix = 10;
        this.locale = Locale.getDefault();
        this.findStartIndex = 0;
        this.preStartIndex = this.findStartIndex;
        this.bufferLength = 0;
        this.closed = false;
        this.matchSuccessful = false;
        this.inputExhausted = false;
        this.cachedNextValue = null;
        this.cachedNextIndex = -1;
        this.cachedFloatPattern = null;
        this.cachedIntegerPatternRadix = -1;
        this.cachedIntegerPattern = null;
        if (readableByteChannel == null) {
            throw new NullPointerException("src == null");
        }
        if (str == null) {
            throw new IllegalArgumentException("charsetName == null");
        }
        initialize(Channels.newReader(readableByteChannel, str));
    }

    private String addNegativeSign(String str) {
        return (this.decimalFormat.getNegativePrefix().isEmpty() ? "" : "\\Q" + this.decimalFormat.getNegativePrefix() + "\\E") + str + (this.decimalFormat.getNegativeSuffix().isEmpty() ? "" : "\\Q" + this.decimalFormat.getNegativeSuffix() + "\\E");
    }

    private String addPositiveSign(String str) {
        return (this.decimalFormat.getPositivePrefix().isEmpty() ? "" : "\\Q" + this.decimalFormat.getPositivePrefix() + "\\E") + str + (this.decimalFormat.getPositiveSuffix().isEmpty() ? "" : "\\Q" + this.decimalFormat.getPositiveSuffix() + "\\E");
    }

    private void checkNotNull(Pattern pattern) {
        if (pattern == null) {
            throw new NullPointerException("pattern == null");
        }
    }

    private void checkOpen() {
        if (this.closed) {
            throw new IllegalStateException();
        }
    }

    private void checkRadix(int i) {
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException("Invalid radix: " + i);
        }
    }

    private void expandBuffer() {
        int position = this.buffer.position();
        int capacity = this.buffer.capacity();
        int limit = this.buffer.limit();
        int i = capacity * 2;
        char[] cArr = new char[i];
        System.arraycopy(this.buffer.array(), 0, cArr, 0, limit);
        this.buffer = CharBuffer.wrap(cArr, 0, i);
        this.buffer.position(position);
        this.buffer.limit(limit);
    }

    private int findDelimiterAfter() {
        boolean z = false;
        while (!z) {
            if (this.matcher.find()) {
                z = true;
                if (this.matcher.start() == this.findStartIndex) {
                    z = true;
                    if (this.matcher.start() == this.matcher.end()) {
                        z = false;
                    }
                }
            } else if (this.inputExhausted) {
                return -1;
            } else {
                readMore();
                resetMatcher();
            }
        }
        int start = this.matcher.start();
        this.findStartIndex = start;
        return start;
    }

    private int findPreDelimiter() {
        boolean z = false;
        while (!z) {
            if (this.matcher.find()) {
                z = true;
                if (this.matcher.start() == this.findStartIndex) {
                    z = true;
                    if (this.matcher.end() == this.bufferLength) {
                        z = true;
                        if (!this.inputExhausted) {
                            readMore();
                            resetMatcher();
                            z = false;
                        }
                    }
                }
            } else if (this.inputExhausted) {
                return -1;
            } else {
                readMore();
                resetMatcher();
            }
        }
        int end = this.matcher.end();
        this.findStartIndex = end;
        return end;
    }

    private Pattern getFloatPattern() {
        if (this.decimalFormat == null) {
            this.decimalFormat = (DecimalFormat) NumberFormat.getInstance(this.locale);
        }
        if (this.cachedFloatPattern != null) {
            return this.cachedFloatPattern;
        }
        DecimalFormatSymbols decimalFormatSymbols = this.decimalFormat.getDecimalFormatSymbols();
        String numeral = getNumeral("([0-9]|(\\p{javaDigit}))", "[\\p{javaDigit}&&[^0]]");
        String str = "\\" + decimalFormatSymbols.getDecimalSeparator();
        String str2 = "(" + numeral + "|" + numeral + str + "([0-9]|(\\p{javaDigit}))*+|" + str + "([0-9]|(\\p{javaDigit}))++)";
        String str3 = "([eE][+-]?([0-9]|(\\p{javaDigit}))+)?";
        String str4 = "(([-+]?" + str2 + "(" + str3 + "?))|(" + addPositiveSign(str2) + "(" + str3 + "?))|(" + addNegativeSign(str2) + "(" + str3 + "?)))";
        String str5 = "(NaN|\\Q" + decimalFormatSymbols.getNaN() + "\\E|Infinity|\\Q" + decimalFormatSymbols.getInfinity() + "\\E)";
        this.cachedFloatPattern = Pattern.compile(str4 + "|([-+]?0[xX][0-9a-fA-F]*\\.[0-9a-fA-F]+([pP][-+]?[0-9]+)?)|" + ("((([-+]?(" + str5 + ")))|(" + addPositiveSign(str5) + ")|(" + addNegativeSign(str5) + "))"));
        return this.cachedFloatPattern;
    }

    private Pattern getIntegerPattern(int i) {
        String numeral;
        checkRadix(i);
        if (this.decimalFormat == null) {
            this.decimalFormat = (DecimalFormat) NumberFormat.getInstance(this.locale);
        }
        if (this.cachedIntegerPatternRadix == i) {
            return this.cachedIntegerPattern;
        }
        this.cachedIntegerPatternRadix = i;
        this.cachedIntegerPattern = Pattern.compile("(([-+]?(" + getNumeral("((?i)[" + "0123456789abcdefghijklmnopqrstuvwxyz".substring(0, i) + "]|\\p{javaDigit})", "((?i)[" + "0123456789abcdefghijklmnopqrstuvwxyz".substring(1, i) + "]|([\\p{javaDigit}&&[^0]]))") + ")))|(" + addPositiveSign(numeral) + ")|(" + addNegativeSign(numeral) + ")");
        return this.cachedIntegerPattern;
    }

    private String getNumeral(String str, String str2) {
        return "((" + str + "++)|" + ("(" + str2 + str + "?" + str + "?(" + ("\\" + this.decimalFormat.getDecimalFormatSymbols().getGroupingSeparator()) + str + str + str + ")+)") + ")";
    }

    private void initialize(Readable readable) {
        this.input = readable;
        this.matcher = this.delimiter.matcher("");
        this.matcher.useTransparentBounds(true);
        this.matcher.useAnchoringBounds(false);
    }

    private void prepareForScan() {
        if (this.findStartIndex >= this.buffer.capacity() / 2) {
            int position = this.buffer.position();
            this.buffer.position(this.findStartIndex);
            this.buffer.compact();
            this.buffer.position(position);
            this.bufferLength -= this.findStartIndex;
            this.findStartIndex = 0;
            this.preStartIndex = -1;
            resetMatcher();
        }
        this.preStartIndex = this.findStartIndex;
    }

    private void readMore() {
        int i;
        int position = this.buffer.position();
        int i2 = this.bufferLength;
        if (this.bufferLength >= this.buffer.capacity()) {
            expandBuffer();
        }
        try {
            this.buffer.limit(this.buffer.capacity());
            this.buffer.position(i2);
            do {
                i = this.input.read(this.buffer);
            } while (i == 0);
        } catch (IOException e) {
            this.bufferLength = this.buffer.position();
            i = -1;
            this.lastIOException = e;
        }
        this.buffer.flip();
        this.buffer.position(position);
        if (i == -1) {
            this.inputExhausted = true;
        } else {
            this.bufferLength += i;
        }
    }

    private void recoverPreviousStatus() {
        this.findStartIndex = this.preStartIndex;
    }

    private String removeLocaleInfo(String str, Class<?> cls) {
        DecimalFormatSymbols decimalFormatSymbols = this.decimalFormat.getDecimalFormatSymbols();
        StringBuilder sb = new StringBuilder(str);
        boolean removeLocaleSign = removeLocaleSign(sb);
        char groupingSeparator = decimalFormatSymbols.getGroupingSeparator();
        while (true) {
            int indexOf = sb.indexOf(String.valueOf(groupingSeparator));
            if (indexOf == -1) {
                break;
            }
            sb.delete(indexOf, indexOf + 1);
        }
        int indexOf2 = sb.indexOf(String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
        StringBuilder sb2 = new StringBuilder("");
        if (cls == Integer.TYPE) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sb.length()) {
                    break;
                }
                if (Character.digit(sb.charAt(i2), 36) != -1) {
                    sb2.append(sb.charAt(i2));
                }
                i = i2 + 1;
            }
        } else if (cls != Float.TYPE) {
            throw new AssertionError("Unsupported type: " + cls);
        } else {
            if (!sb.toString().equals(decimalFormatSymbols.getNaN())) {
                if (!sb.toString().equals(decimalFormatSymbols.getInfinity())) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= sb.length()) {
                            break;
                        }
                        if (Character.digit(sb.charAt(i4), 10) != -1) {
                            sb2.append(Character.digit(sb.charAt(i4), 10));
                        }
                        i3 = i4 + 1;
                    }
                } else {
                    sb2.append("Infinity");
                }
            } else {
                sb2.append("NaN");
            }
        }
        StringBuilder sb3 = sb2;
        if (sb2.length() == 0) {
            sb3 = sb;
        }
        if (indexOf2 != -1) {
            sb3.insert(indexOf2, ".");
        }
        if (removeLocaleSign) {
            sb3.insert(0, '-');
        }
        return sb3.toString();
    }

    private String removeLocaleInfoFromFloat(String str) {
        if (str.indexOf(120) == -1 && str.indexOf(88) == -1) {
            int indexOf = str.indexOf(101);
            int i = indexOf;
            if (indexOf == -1) {
                i = str.indexOf(69);
                if (i == -1) {
                    return removeLocaleInfo(str, Float.TYPE);
                }
            }
            String substring = str.substring(0, i);
            return removeLocaleInfo(substring, Float.TYPE) + iu.h + str.substring(i + 1, str.length());
        }
        return str;
    }

    private boolean removeLocaleSign(StringBuilder sb) {
        String positivePrefix = this.decimalFormat.getPositivePrefix();
        String positiveSuffix = this.decimalFormat.getPositiveSuffix();
        String negativePrefix = this.decimalFormat.getNegativePrefix();
        String negativeSuffix = this.decimalFormat.getNegativeSuffix();
        if (sb.indexOf("+") == 0) {
            sb.delete(0, 1);
        }
        if (!positivePrefix.isEmpty() && sb.indexOf(positivePrefix) == 0) {
            sb.delete(0, positivePrefix.length());
        }
        if (!positiveSuffix.isEmpty() && sb.indexOf(positiveSuffix) != -1) {
            sb.delete(sb.length() - positiveSuffix.length(), sb.length());
        }
        boolean z = false;
        if (sb.indexOf("-") == 0) {
            sb.delete(0, 1);
            z = true;
        }
        boolean z2 = z;
        if (!negativePrefix.isEmpty()) {
            z2 = z;
            if (sb.indexOf(negativePrefix) == 0) {
                sb.delete(0, negativePrefix.length());
                z2 = true;
            }
        }
        boolean z3 = z2;
        if (!negativeSuffix.isEmpty()) {
            z3 = z2;
            if (sb.indexOf(negativeSuffix) != -1) {
                sb.delete(sb.length() - negativeSuffix.length(), sb.length());
                z3 = true;
            }
        }
        return z3;
    }

    private void resetMatcher() {
        this.matcher.reset(this.buffer);
        this.matcher.region(this.findStartIndex, this.bufferLength);
    }

    private boolean setHeadTokenRegion(int i) {
        boolean z = false;
        if (i == -1) {
            z = false;
            if (this.preStartIndex != this.bufferLength) {
                int i2 = this.preStartIndex;
                int i3 = this.bufferLength;
                this.findStartIndex = this.bufferLength;
                this.matcher.region(i2, i3);
                z = true;
            }
        }
        boolean z2 = z;
        if (i != -1) {
            z2 = z;
            if (this.preStartIndex != this.matcher.start()) {
                int i4 = this.preStartIndex;
                int start = this.matcher.start();
                this.findStartIndex = this.matcher.start();
                this.matcher.region(i4, start);
                z2 = true;
            }
        }
        return z2;
    }

    private void setLocale(Locale locale) {
        this.locale = locale;
        this.decimalFormat = null;
        this.cachedFloatPattern = null;
        this.cachedIntegerPatternRadix = -1;
        this.cachedIntegerPattern = null;
    }

    private boolean setTokenRegion() {
        this.matcher.usePattern(this.delimiter);
        this.matcher.region(this.findStartIndex, this.bufferLength);
        int findPreDelimiter = findPreDelimiter();
        if (setHeadTokenRegion(findPreDelimiter)) {
            return true;
        }
        int findDelimiterAfter = findDelimiterAfter();
        int i = findDelimiterAfter;
        if (findDelimiterAfter == -1) {
            if (this.findStartIndex == this.bufferLength) {
                return false;
            }
            i = this.bufferLength;
            this.findStartIndex = this.bufferLength;
        }
        this.matcher.region(findPreDelimiter, i);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        if (this.input instanceof Closeable) {
            try {
                ((Closeable) this.input).close();
            } catch (IOException e) {
                this.lastIOException = e;
            }
        }
        this.closed = true;
    }

    public Pattern delimiter() {
        return this.delimiter;
    }

    public String findInLine(String str) {
        return findInLine(Pattern.compile(str));
    }

    public String findInLine(Pattern pattern) {
        checkOpen();
        checkNotNull(pattern);
        int i = 0;
        this.matcher.usePattern(MULTI_LINE_TERMINATOR);
        this.matcher.region(this.findStartIndex, this.bufferLength);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            if (this.matcher.find()) {
                i = this.matcher.start();
                i2 = this.matcher.end() - this.matcher.start();
                z = true;
            } else if (this.inputExhausted) {
                i = this.bufferLength;
                z = true;
            } else {
                readMore();
                resetMatcher();
            }
        }
        this.matcher.usePattern(pattern);
        int limit = this.buffer.limit();
        this.buffer.limit(i + i2);
        this.matcher.region(this.findStartIndex, i + i2);
        if (!this.matcher.find()) {
            this.buffer.limit(limit);
            this.matchSuccessful = false;
            return null;
        }
        this.findStartIndex = this.matcher.end();
        if (i == this.matcher.end()) {
            this.findStartIndex += i2;
        }
        if (i == this.bufferLength || i + i2 != this.matcher.end()) {
            this.matchSuccessful = true;
            this.buffer.limit(limit);
            return this.matcher.group();
        }
        this.buffer.limit(limit);
        this.matchSuccessful = false;
        return null;
    }

    public String findWithinHorizon(String str, int i) {
        return findWithinHorizon(Pattern.compile(str), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String findWithinHorizon(java.util.regex.Pattern r5, int r6) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Scanner.findWithinHorizon(java.util.regex.Pattern, int):java.lang.String");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return hasNext(ANY_PATTERN);
    }

    public boolean hasNext(String str) {
        return hasNext(Pattern.compile(str));
    }

    public boolean hasNext(Pattern pattern) {
        checkOpen();
        checkNotNull(pattern);
        this.matchSuccessful = false;
        prepareForScan();
        if (!setTokenRegion()) {
            recoverPreviousStatus();
            return false;
        }
        this.matcher.usePattern(pattern);
        boolean z = false;
        if (this.matcher.matches()) {
            this.cachedNextIndex = this.findStartIndex;
            this.matchSuccessful = true;
            z = true;
        }
        recoverPreviousStatus();
        return z;
    }

    public boolean hasNextBigDecimal() {
        boolean z = false;
        if (hasNext(getFloatPattern())) {
            try {
                this.cachedNextValue = new BigDecimal(removeLocaleInfoFromFloat(this.matcher.group()));
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextBigInteger() {
        return hasNextBigInteger(this.currentRadix);
    }

    public boolean hasNextBigInteger(int i) {
        boolean z = false;
        if (hasNext(getIntegerPattern(i))) {
            try {
                this.cachedNextValue = new BigInteger(removeLocaleInfo(this.matcher.group(), Integer.TYPE), i);
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextBoolean() {
        return hasNext(BOOLEAN_PATTERN);
    }

    public boolean hasNextByte() {
        return hasNextByte(this.currentRadix);
    }

    public boolean hasNextByte(int i) {
        boolean z = false;
        if (hasNext(getIntegerPattern(i))) {
            try {
                this.cachedNextValue = Byte.valueOf(removeLocaleInfo(this.matcher.group(), Integer.TYPE), i);
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextDouble() {
        boolean z = false;
        if (hasNext(getFloatPattern())) {
            try {
                this.cachedNextValue = Double.valueOf(removeLocaleInfoFromFloat(this.matcher.group()));
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextFloat() {
        boolean z = false;
        if (hasNext(getFloatPattern())) {
            try {
                this.cachedNextValue = Float.valueOf(removeLocaleInfoFromFloat(this.matcher.group()));
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextInt() {
        return hasNextInt(this.currentRadix);
    }

    public boolean hasNextInt(int i) {
        boolean z = false;
        if (hasNext(getIntegerPattern(i))) {
            try {
                this.cachedNextValue = Integer.valueOf(removeLocaleInfo(this.matcher.group(), Integer.TYPE), i);
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextLine() {
        boolean z = false;
        prepareForScan();
        String findWithinHorizon = findWithinHorizon(LINE_PATTERN, 0);
        recoverPreviousStatus();
        if (findWithinHorizon != null) {
            z = true;
        }
        return z;
    }

    public boolean hasNextLong() {
        return hasNextLong(this.currentRadix);
    }

    public boolean hasNextLong(int i) {
        boolean z = false;
        if (hasNext(getIntegerPattern(i))) {
            try {
                this.cachedNextValue = Long.valueOf(removeLocaleInfo(this.matcher.group(), Integer.TYPE), i);
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public boolean hasNextShort() {
        return hasNextShort(this.currentRadix);
    }

    public boolean hasNextShort(int i) {
        boolean z = false;
        if (hasNext(getIntegerPattern(i))) {
            try {
                this.cachedNextValue = Short.valueOf(removeLocaleInfo(this.matcher.group(), Integer.TYPE), i);
                z = true;
            } catch (NumberFormatException e) {
                this.matchSuccessful = false;
                return false;
            }
        }
        return z;
    }

    public IOException ioException() {
        return this.lastIOException;
    }

    public Locale locale() {
        return this.locale;
    }

    public MatchResult match() {
        if (this.matchSuccessful) {
            return this.matcher.toMatchResult();
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public String next() {
        return next(ANY_PATTERN);
    }

    public String next(String str) {
        return next(Pattern.compile(str));
    }

    public String next(Pattern pattern) {
        checkOpen();
        checkNotNull(pattern);
        this.matchSuccessful = false;
        prepareForScan();
        if (!setTokenRegion()) {
            recoverPreviousStatus();
            throw new NoSuchElementException();
        }
        this.matcher.usePattern(pattern);
        if (this.matcher.matches()) {
            this.matchSuccessful = true;
            return this.matcher.group();
        }
        recoverPreviousStatus();
        throw new InputMismatchException();
    }

    public BigDecimal nextBigDecimal() {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof BigDecimal) {
            this.findStartIndex = this.cachedNextIndex;
            return (BigDecimal) obj;
        }
        try {
            return new BigDecimal(removeLocaleInfoFromFloat(next(getFloatPattern())));
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public BigInteger nextBigInteger() {
        return nextBigInteger(this.currentRadix);
    }

    public BigInteger nextBigInteger(int i) {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof BigInteger) {
            this.findStartIndex = this.cachedNextIndex;
            return (BigInteger) obj;
        }
        try {
            return new BigInteger(removeLocaleInfo(next(getIntegerPattern(i)), Integer.TYPE), i);
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public boolean nextBoolean() {
        return Boolean.parseBoolean(next(BOOLEAN_PATTERN));
    }

    public byte nextByte() {
        return nextByte(this.currentRadix);
    }

    public byte nextByte(int i) {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof Byte) {
            this.findStartIndex = this.cachedNextIndex;
            return ((Byte) obj).byteValue();
        }
        try {
            return Byte.parseByte(removeLocaleInfo(next(getIntegerPattern(i)), Integer.TYPE), i);
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public double nextDouble() {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof Double) {
            this.findStartIndex = this.cachedNextIndex;
            return ((Double) obj).doubleValue();
        }
        try {
            return Double.parseDouble(removeLocaleInfoFromFloat(next(getFloatPattern())));
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public float nextFloat() {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof Float) {
            this.findStartIndex = this.cachedNextIndex;
            return ((Float) obj).floatValue();
        }
        try {
            return Float.parseFloat(removeLocaleInfoFromFloat(next(getFloatPattern())));
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public int nextInt() {
        return nextInt(this.currentRadix);
    }

    public int nextInt(int i) {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof Integer) {
            this.findStartIndex = this.cachedNextIndex;
            return ((Integer) obj).intValue();
        }
        try {
            return Integer.parseInt(removeLocaleInfo(next(getIntegerPattern(i)), Integer.TYPE), i);
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public String nextLine() {
        checkOpen();
        this.matcher.usePattern(LINE_PATTERN);
        this.matcher.region(this.findStartIndex, this.bufferLength);
        while (true) {
            if (this.matcher.find()) {
                if (this.inputExhausted || this.matcher.end() != this.bufferLength || this.bufferLength < this.buffer.capacity()) {
                    break;
                }
            } else if (this.inputExhausted) {
                this.matchSuccessful = false;
                throw new NoSuchElementException();
            }
            if (!this.inputExhausted) {
                readMore();
                resetMatcher();
            }
        }
        this.matchSuccessful = true;
        this.findStartIndex = this.matcher.end();
        String group = this.matcher.group();
        String str = group;
        if (group != null) {
            Matcher matcher = LINE_TERMINATOR.matcher(group);
            str = group;
            if (matcher.find()) {
                str = group.substring(0, matcher.start());
            }
        }
        return str;
    }

    public long nextLong() {
        return nextLong(this.currentRadix);
    }

    public long nextLong(int i) {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof Long) {
            this.findStartIndex = this.cachedNextIndex;
            return ((Long) obj).longValue();
        }
        try {
            return Long.parseLong(removeLocaleInfo(next(getIntegerPattern(i)), Integer.TYPE), i);
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public short nextShort() {
        return nextShort(this.currentRadix);
    }

    public short nextShort(int i) {
        checkOpen();
        Object obj = this.cachedNextValue;
        this.cachedNextValue = null;
        if (obj instanceof Short) {
            this.findStartIndex = this.cachedNextIndex;
            return ((Short) obj).shortValue();
        }
        try {
            return Short.parseShort(removeLocaleInfo(next(getIntegerPattern(i)), Integer.TYPE), i);
        } catch (NumberFormatException e) {
            this.matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
    }

    public int radix() {
        return this.currentRadix;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Scanner reset() {
        this.delimiter = DEFAULT_DELIMITER;
        setLocale(Locale.getDefault());
        this.currentRadix = 10;
        return this;
    }

    public Scanner skip(String str) {
        return skip(Pattern.compile(str));
    }

    public Scanner skip(Pattern pattern) {
        checkOpen();
        checkNotNull(pattern);
        this.matcher.usePattern(pattern);
        this.matcher.region(this.findStartIndex, this.bufferLength);
        while (true) {
            if (this.matcher.lookingAt()) {
                if (this.matcher.end() < this.bufferLength || (this.matcher.end() == this.bufferLength && this.inputExhausted)) {
                    this.matchSuccessful = true;
                    this.findStartIndex = this.matcher.end();
                    return this;
                }
            } else if (this.inputExhausted) {
                this.matchSuccessful = false;
                throw new NoSuchElementException();
            }
            if (!this.inputExhausted) {
                readMore();
                resetMatcher();
            }
        }
    }

    public String toString() {
        return getClass().getName() + "[delimiter=" + this.delimiter + ",findStartIndex=" + this.findStartIndex + ",matchSuccessful=" + this.matchSuccessful + ",closed=" + this.closed + "]";
    }

    public Scanner useDelimiter(String str) {
        return useDelimiter(Pattern.compile(str));
    }

    public Scanner useDelimiter(Pattern pattern) {
        this.delimiter = pattern;
        return this;
    }

    public Scanner useLocale(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("l == null");
        }
        setLocale(locale);
        return this;
    }

    public Scanner useRadix(int i) {
        checkRadix(i);
        this.currentRadix = i;
        return this;
    }
}
