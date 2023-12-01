package java.text;

import com.android.ims.ImsReasonInfo;
import com.android.internal.R;
import com.android.internal.content.NativeLibraryHelper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;
import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;

/* loaded from: source-2895416-dex2jar.jar:java/text/DecimalFormat.class */
public class DecimalFormat extends NumberFormat {
    private static final Double NEGATIVE_ZERO_DOUBLE = new Double(0.0d);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("positivePrefix", String.class), new ObjectStreamField("positiveSuffix", String.class), new ObjectStreamField("negativePrefix", String.class), new ObjectStreamField("negativeSuffix", String.class), new ObjectStreamField("posPrefixPattern", String.class), new ObjectStreamField("posSuffixPattern", String.class), new ObjectStreamField("negPrefixPattern", String.class), new ObjectStreamField("negSuffixPattern", String.class), new ObjectStreamField("multiplier", Integer.TYPE), new ObjectStreamField("groupingSize", Byte.TYPE), new ObjectStreamField("groupingUsed", Boolean.TYPE), new ObjectStreamField("decimalSeparatorAlwaysShown", Boolean.TYPE), new ObjectStreamField("parseBigDecimal", Boolean.TYPE), new ObjectStreamField("roundingMode", RoundingMode.class), new ObjectStreamField("symbols", DecimalFormatSymbols.class), new ObjectStreamField("useExponentialNotation", Boolean.TYPE), new ObjectStreamField("minExponentDigits", Byte.TYPE), new ObjectStreamField("maximumIntegerDigits", Integer.TYPE), new ObjectStreamField("minimumIntegerDigits", Integer.TYPE), new ObjectStreamField("maximumFractionDigits", Integer.TYPE), new ObjectStreamField("minimumFractionDigits", Integer.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE)};
    private static final long serialVersionUID = 864413376551465018L;
    private transient NativeDecimalFormat ndf;
    private transient RoundingMode roundingMode;
    private transient DecimalFormatSymbols symbols;

    public DecimalFormat() {
        this.roundingMode = RoundingMode.HALF_EVEN;
        Locale locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
    }

    public DecimalFormat(String str) {
        this(str, Locale.getDefault());
    }

    public DecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols) {
        this.roundingMode = RoundingMode.HALF_EVEN;
        this.symbols = (DecimalFormatSymbols) decimalFormatSymbols.clone();
        initNative(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecimalFormat(String str, Locale locale) {
        this.roundingMode = RoundingMode.HALF_EVEN;
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(str);
    }

    private void checkBufferAndFieldPosition(StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (stringBuffer == null) {
            throw new NullPointerException("buffer == null");
        }
        if (fieldPosition == null) {
            throw new NullPointerException("position == null");
        }
    }

    private void initNative(String str) {
        try {
            this.ndf = new NativeDecimalFormat(str, this.symbols);
            super.setMaximumFractionDigits(this.ndf.getMaximumFractionDigits());
            super.setMaximumIntegerDigits(this.ndf.getMaximumIntegerDigits());
            super.setMinimumFractionDigits(this.ndf.getMinimumFractionDigits());
            super.setMinimumIntegerDigits(this.ndf.getMinimumIntegerDigits());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(str);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.symbols = (DecimalFormatSymbols) readFields.get("symbols", (Object) null);
        initNative("");
        this.ndf.setPositivePrefix((String) readFields.get("positivePrefix", ""));
        this.ndf.setPositiveSuffix((String) readFields.get("positiveSuffix", ""));
        this.ndf.setNegativePrefix((String) readFields.get("negativePrefix", NativeLibraryHelper.CLEAR_ABI_OVERRIDE));
        this.ndf.setNegativeSuffix((String) readFields.get("negativeSuffix", ""));
        this.ndf.setMultiplier(readFields.get("multiplier", 1));
        this.ndf.setGroupingSize(readFields.get("groupingSize", (byte) 3));
        this.ndf.setGroupingUsed(readFields.get("groupingUsed", true));
        this.ndf.setDecimalSeparatorAlwaysShown(readFields.get("decimalSeparatorAlwaysShown", false));
        setRoundingMode((RoundingMode) readFields.get("roundingMode", RoundingMode.HALF_EVEN));
        int i = readFields.get("maximumIntegerDigits", R.styleable.Theme_lightZ);
        int i2 = readFields.get("minimumIntegerDigits", R.styleable.Theme_lightZ);
        int i3 = readFields.get("maximumFractionDigits", ImsReasonInfo.CODE_SIP_NOT_ACCEPTABLE);
        int i4 = readFields.get("minimumFractionDigits", ImsReasonInfo.CODE_SIP_NOT_ACCEPTABLE);
        this.ndf.setMaximumIntegerDigits(i);
        super.setMaximumIntegerDigits(this.ndf.getMaximumIntegerDigits());
        setMinimumIntegerDigits(i2);
        setMinimumFractionDigits(i4);
        setMaximumFractionDigits(i3);
        setParseBigDecimal(readFields.get("parseBigDecimal", false));
        if (readFields.get("serialVersionOnStream", 0) < 3) {
            setMaximumIntegerDigits(super.getMaximumIntegerDigits());
            setMinimumIntegerDigits(super.getMinimumIntegerDigits());
            setMaximumFractionDigits(super.getMaximumFractionDigits());
            setMinimumFractionDigits(super.getMinimumFractionDigits());
        }
    }

    private void updateFieldsFromNative() {
        this.maximumIntegerDigits = this.ndf.getMaximumIntegerDigits();
        this.minimumIntegerDigits = this.ndf.getMinimumIntegerDigits();
        this.maximumFractionDigits = this.ndf.getMaximumFractionDigits();
        this.minimumFractionDigits = this.ndf.getMinimumFractionDigits();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("positivePrefix", this.ndf.getPositivePrefix());
        putFields.put("positiveSuffix", this.ndf.getPositiveSuffix());
        putFields.put("negativePrefix", this.ndf.getNegativePrefix());
        putFields.put("negativeSuffix", this.ndf.getNegativeSuffix());
        putFields.put("posPrefixPattern", (Object) null);
        putFields.put("posSuffixPattern", (Object) null);
        putFields.put("negPrefixPattern", (Object) null);
        putFields.put("negSuffixPattern", (Object) null);
        putFields.put("multiplier", this.ndf.getMultiplier());
        putFields.put("groupingSize", (byte) this.ndf.getGroupingSize());
        putFields.put("groupingUsed", this.ndf.isGroupingUsed());
        putFields.put("decimalSeparatorAlwaysShown", this.ndf.isDecimalSeparatorAlwaysShown());
        putFields.put("parseBigDecimal", this.ndf.isParseBigDecimal());
        putFields.put("roundingMode", this.roundingMode);
        putFields.put("symbols", this.symbols);
        putFields.put("useExponentialNotation", false);
        putFields.put("minExponentDigits", (byte) 0);
        putFields.put("maximumIntegerDigits", this.ndf.getMaximumIntegerDigits());
        putFields.put("minimumIntegerDigits", this.ndf.getMinimumIntegerDigits());
        putFields.put("maximumFractionDigits", this.ndf.getMaximumFractionDigits());
        putFields.put("minimumFractionDigits", this.ndf.getMinimumFractionDigits());
        putFields.put("serialVersionOnStream", 4);
        objectOutputStream.writeFields();
    }

    public void applyLocalizedPattern(String str) {
        this.ndf.applyLocalizedPattern(str);
        updateFieldsFromNative();
    }

    public void applyPattern(String str) {
        this.ndf.applyPattern(str);
        updateFieldsFromNative();
    }

    @Override // java.text.NumberFormat, java.text.Format
    public Object clone() {
        DecimalFormat decimalFormat = (DecimalFormat) super.clone();
        decimalFormat.ndf = (NativeDecimalFormat) this.ndf.clone();
        decimalFormat.symbols = (DecimalFormatSymbols) this.symbols.clone();
        return decimalFormat;
    }

    @Override // java.text.NumberFormat
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) obj;
            if (this.ndf == null) {
                if (decimalFormat.ndf != null) {
                    return false;
                }
            } else if (!this.ndf.equals(decimalFormat.ndf)) {
                return false;
            }
            return getDecimalFormatSymbols().equals(decimalFormat.getDecimalFormatSymbols());
        }
        return false;
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        checkBufferAndFieldPosition(stringBuffer, fieldPosition);
        stringBuffer.append(this.ndf.formatDouble(d, fieldPosition));
        return stringBuffer;
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        checkBufferAndFieldPosition(stringBuffer, fieldPosition);
        stringBuffer.append(this.ndf.formatLong(j, fieldPosition));
        return stringBuffer;
    }

    @Override // java.text.NumberFormat, java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        checkBufferAndFieldPosition(stringBuffer, fieldPosition);
        if (obj instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) obj;
            stringBuffer.append(bigInteger.bitLength() < 64 ? this.ndf.formatLong(bigInteger.longValue(), fieldPosition) : this.ndf.formatBigInteger(bigInteger, fieldPosition));
            return stringBuffer;
        } else if (obj instanceof BigDecimal) {
            stringBuffer.append(this.ndf.formatBigDecimal((BigDecimal) obj, fieldPosition));
            return stringBuffer;
        } else {
            return super.format(obj, stringBuffer, fieldPosition);
        }
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object == null");
        }
        return this.ndf.formatToCharacterIterator(obj);
    }

    @Override // java.text.NumberFormat
    public Currency getCurrency() {
        return this.symbols.getCurrency();
    }

    public DecimalFormatSymbols getDecimalFormatSymbols() {
        return (DecimalFormatSymbols) this.symbols.clone();
    }

    public int getGroupingSize() {
        return this.ndf.getGroupingSize();
    }

    public int getMultiplier() {
        return this.ndf.getMultiplier();
    }

    public String getNegativePrefix() {
        return this.ndf.getNegativePrefix();
    }

    public String getNegativeSuffix() {
        return this.ndf.getNegativeSuffix();
    }

    public String getPositivePrefix() {
        return this.ndf.getPositivePrefix();
    }

    public String getPositiveSuffix() {
        return this.ndf.getPositiveSuffix();
    }

    @Override // java.text.NumberFormat
    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    @Override // java.text.NumberFormat
    public int hashCode() {
        return getPositivePrefix().hashCode();
    }

    public boolean isDecimalSeparatorAlwaysShown() {
        return this.ndf.isDecimalSeparatorAlwaysShown();
    }

    @Override // java.text.NumberFormat
    public boolean isGroupingUsed() {
        return this.ndf.isGroupingUsed();
    }

    public boolean isParseBigDecimal() {
        return this.ndf.isParseBigDecimal();
    }

    @Override // java.text.NumberFormat
    public boolean isParseIntegerOnly() {
        return this.ndf.isParseIntegerOnly();
    }

    @Override // java.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        Number number;
        Number parse = this.ndf.parse(str, parsePosition);
        if (parse == null) {
            number = null;
        } else if (isParseBigDecimal()) {
            if (parse instanceof Long) {
                return new BigDecimal(parse.longValue());
            }
            if ((parse instanceof Double) && !((Double) parse).isInfinite() && !((Double) parse).isNaN()) {
                return new BigDecimal(parse.toString());
            }
            number = parse;
            if (parse instanceof BigInteger) {
                return new BigDecimal(parse.toString());
            }
        } else if ((parse instanceof BigDecimal) || (parse instanceof BigInteger)) {
            return new Double(parse.doubleValue());
        } else {
            number = parse;
            if (isParseIntegerOnly()) {
                number = parse;
                if (parse.equals(NEGATIVE_ZERO_DOUBLE)) {
                    return 0L;
                }
            }
        }
        return number;
    }

    @Override // java.text.NumberFormat
    public void setCurrency(Currency currency) {
        this.symbols.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        this.ndf.setCurrency(this.symbols.getCurrencySymbol(), currency.getCurrencyCode());
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        if (decimalFormatSymbols != null) {
            this.symbols = (DecimalFormatSymbols) decimalFormatSymbols.clone();
            this.ndf.setDecimalFormatSymbols(this.symbols);
        }
    }

    public void setDecimalSeparatorAlwaysShown(boolean z) {
        this.ndf.setDecimalSeparatorAlwaysShown(z);
    }

    public void setGroupingSize(int i) {
        this.ndf.setGroupingSize(i);
    }

    @Override // java.text.NumberFormat
    public void setGroupingUsed(boolean z) {
        this.ndf.setGroupingUsed(z);
    }

    @Override // java.text.NumberFormat
    public void setMaximumFractionDigits(int i) {
        super.setMaximumFractionDigits(i);
        this.ndf.setMaximumFractionDigits(getMaximumFractionDigits());
        setRoundingMode(this.roundingMode);
    }

    @Override // java.text.NumberFormat
    public void setMaximumIntegerDigits(int i) {
        super.setMaximumIntegerDigits(i);
        this.ndf.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    @Override // java.text.NumberFormat
    public void setMinimumFractionDigits(int i) {
        super.setMinimumFractionDigits(i);
        this.ndf.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    @Override // java.text.NumberFormat
    public void setMinimumIntegerDigits(int i) {
        super.setMinimumIntegerDigits(i);
        this.ndf.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    public void setMultiplier(int i) {
        this.ndf.setMultiplier(i);
    }

    public void setNegativePrefix(String str) {
        this.ndf.setNegativePrefix(str);
    }

    public void setNegativeSuffix(String str) {
        this.ndf.setNegativeSuffix(str);
    }

    public void setParseBigDecimal(boolean z) {
        this.ndf.setParseBigDecimal(z);
    }

    @Override // java.text.NumberFormat
    public void setParseIntegerOnly(boolean z) {
        super.setParseIntegerOnly(z);
        this.ndf.setParseIntegerOnly(z);
    }

    public void setPositivePrefix(String str) {
        this.ndf.setPositivePrefix(str);
    }

    public void setPositiveSuffix(String str) {
        this.ndf.setPositiveSuffix(str);
    }

    @Override // java.text.NumberFormat
    public void setRoundingMode(RoundingMode roundingMode) {
        if (roundingMode == null) {
            throw new NullPointerException("roundingMode == null");
        }
        this.roundingMode = roundingMode;
        this.ndf.setRoundingMode(roundingMode, 0.0d);
    }

    public String toLocalizedPattern() {
        return this.ndf.toLocalizedPattern();
    }

    public String toPattern() {
        return this.ndf.toPattern();
    }

    public String toString() {
        return this.ndf.toString();
    }
}
