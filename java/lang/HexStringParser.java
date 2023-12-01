package java.lang;

import com.android.internal.content.NativeLibraryHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/HexStringParser.class */
public final class HexStringParser {
    private static final String BINARY_EXPONENT = "[pP]([+-]?\\d+)";
    private static final int DOUBLE_EXPONENT_WIDTH = 11;
    private static final int DOUBLE_MANTISSA_WIDTH = 52;
    private static final int FLOAT_EXPONENT_WIDTH = 8;
    private static final int FLOAT_MANTISSA_WIDTH = 23;
    private static final String FLOAT_TYPE_SUFFIX = "[fFdD]?";
    private static final int HEX_RADIX = 16;
    private static final String HEX_SIGNIFICANT = "0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)";
    private static final int MAX_SIGNIFICANT_LENGTH = 15;
    private final long EXPONENT_BASE;
    private final int EXPONENT_WIDTH;
    private final long MANTISSA_MASK;
    private final int MANTISSA_WIDTH;
    private final long MAX_EXPONENT;
    private final long MIN_EXPONENT;
    private String abandonedNumber = "";
    private long exponent;
    private long mantissa;
    private long sign;
    private static final String HEX_PATTERN = "[\\x00-\\x20]*([+-]?)0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)[pP]([+-]?\\d+)[fFdD]?[\\x00-\\x20]*";
    private static final Pattern PATTERN = Pattern.compile(HEX_PATTERN);

    public HexStringParser(int i, int i2) {
        this.EXPONENT_WIDTH = i;
        this.MANTISSA_WIDTH = i2;
        this.EXPONENT_BASE = ((-1) << (i - 1)) ^ (-1);
        this.MAX_EXPONENT = ((-1) << i) ^ (-1);
        this.MIN_EXPONENT = -(this.MANTISSA_WIDTH + 1);
        this.MANTISSA_MASK = ((-1) << i2) ^ (-1);
    }

    private void checkedAddExponent(long j) {
        long j2 = this.exponent + j;
        int signum = Long.signum(this.exponent);
        if (Long.signum(j) * signum <= 0 || Long.signum(j2) * signum >= 0) {
            this.exponent = j2;
        } else {
            this.exponent = signum * Long.MAX_VALUE;
        }
    }

    private int countBitsLength(long j) {
        return 64 - Long.numberOfLeadingZeros(j);
    }

    private void discardTrailingBits(long j) {
        this.abandonedNumber += (this.mantissa & (((-1) << ((int) j)) ^ (-1)));
        this.mantissa >>= (int) j;
    }

    private void fitMantissaInDesiredWidth(int i) {
        int countBitsLength = countBitsLength(this.mantissa);
        if (countBitsLength > i) {
            discardTrailingBits(countBitsLength - i);
        } else {
            this.mantissa <<= i - countBitsLength;
        }
    }

    private String getNormalizedSignificand(String str, String str2) {
        String replaceFirst = (str + str2).replaceFirst("^0+", "");
        String str3 = replaceFirst;
        if (replaceFirst.length() == 0) {
            str3 = "0";
        }
        return str3;
    }

    private int getOffset(String str, String str2) {
        int i;
        int i2 = 0;
        String replaceFirst = str.replaceFirst("^0+", "");
        if (replaceFirst.length() != 0) {
            i2 = (((replaceFirst.length() - 1) * 4) + countBitsLength(Long.parseLong(replaceFirst.substring(0, 1), 16))) - 1;
        } else {
            int i3 = 0;
            while (true) {
                i = i3;
                if (i >= str2.length() || str2.charAt(i) != '0') {
                    break;
                }
                i3 = i + 1;
            }
            if (i != str2.length()) {
                return ((((-i) - 1) * 4) + countBitsLength(Long.parseLong(str2.substring(i, i + 1), 16))) - 1;
            }
        }
        return i2;
    }

    private long parse(String str, boolean z) {
        Matcher matcher = PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new NumberFormatException("Invalid hex " + (z ? "double" : "float") + ":" + str);
        }
        String group = matcher.group(1);
        String group2 = matcher.group(2);
        String group3 = matcher.group(3);
        parseHexSign(group);
        parseExponent(group3);
        parseMantissa(group2);
        this.sign <<= this.MANTISSA_WIDTH + this.EXPONENT_WIDTH;
        this.exponent <<= this.MANTISSA_WIDTH;
        return this.sign | this.exponent | this.mantissa;
    }

    public static double parseDouble(String str) {
        return Double.longBitsToDouble(new HexStringParser(11, 52).parse(str, true));
    }

    private void parseExponent(String str) {
        char charAt = str.charAt(0);
        int i = charAt == '-' ? -1 : 1;
        String str2 = str;
        if (!Character.isDigit(charAt)) {
            str2 = str.substring(1);
        }
        try {
            this.exponent = i * Long.parseLong(str2);
            checkedAddExponent(this.EXPONENT_BASE);
        } catch (NumberFormatException e) {
            this.exponent = i * Long.MAX_VALUE;
        }
    }

    public static float parseFloat(String str) {
        return Float.intBitsToFloat((int) new HexStringParser(8, 23).parse(str, false));
    }

    private void parseHexSign(String str) {
        this.sign = str.equals(NativeLibraryHelper.CLEAR_ABI_OVERRIDE) ? 1L : 0L;
    }

    private void parseMantissa(String str) {
        String[] split = str.split("\\.");
        String str2 = split[0];
        String str3 = split.length > 1 ? split[1] : "";
        String normalizedSignificand = getNormalizedSignificand(str2, str3);
        if (normalizedSignificand.equals("0")) {
            setZero();
            return;
        }
        checkedAddExponent(getOffset(str2, str3));
        if (this.exponent >= this.MAX_EXPONENT) {
            setInfinite();
        } else if (this.exponent <= this.MIN_EXPONENT) {
            setZero();
        } else {
            String str4 = normalizedSignificand;
            if (normalizedSignificand.length() > 15) {
                this.abandonedNumber = normalizedSignificand.substring(15);
                str4 = normalizedSignificand.substring(0, 15);
            }
            this.mantissa = Long.parseLong(str4, 16);
            if (this.exponent >= 1) {
                processNormalNumber();
            } else {
                processSubNormalNumber();
            }
        }
    }

    private void processNormalNumber() {
        fitMantissaInDesiredWidth(this.MANTISSA_WIDTH + 2);
        round();
        this.mantissa &= this.MANTISSA_MASK;
    }

    private void processSubNormalNumber() {
        int i = this.MANTISSA_WIDTH;
        this.exponent = 0L;
        fitMantissaInDesiredWidth(i + 1 + ((int) this.exponent));
        round();
        this.mantissa &= this.MANTISSA_MASK;
    }

    private void round() {
        boolean z = this.abandonedNumber.replaceAll("0+", "").length() > 0;
        int i = (int) (this.mantissa & 1);
        this.mantissa >>= 1;
        int i2 = (int) (this.mantissa & 1);
        if (i == 1) {
            if (z || i2 == 1) {
                int countBitsLength = countBitsLength(this.mantissa);
                this.mantissa++;
                int countBitsLength2 = countBitsLength(this.mantissa);
                if (countBitsLength < this.MANTISSA_WIDTH || countBitsLength2 <= countBitsLength) {
                    return;
                }
                checkedAddExponent(1L);
            }
        }
    }

    private void setInfinite() {
        this.exponent = this.MAX_EXPONENT;
        this.mantissa = 0L;
    }

    private void setZero() {
        this.exponent = 0L;
        this.mantissa = 0L;
    }
}
