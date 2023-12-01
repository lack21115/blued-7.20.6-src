package java.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.cdo.oaps.ad.OapsKey;
import com.sobot.network.http.model.SobotProgress;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.Format;
import java.util.Currency;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/text/NumberFormat.class */
public abstract class NumberFormat extends Format {
    public static final int FRACTION_FIELD = 1;
    public static final int INTEGER_FIELD = 0;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("groupingUsed", Boolean.TYPE), new ObjectStreamField("maxFractionDigits", Byte.TYPE), new ObjectStreamField("maximumFractionDigits", Integer.TYPE), new ObjectStreamField("maximumIntegerDigits", Integer.TYPE), new ObjectStreamField("maxIntegerDigits", Byte.TYPE), new ObjectStreamField("minFractionDigits", Byte.TYPE), new ObjectStreamField("minimumFractionDigits", Integer.TYPE), new ObjectStreamField("minimumIntegerDigits", Integer.TYPE), new ObjectStreamField("minIntegerDigits", Byte.TYPE), new ObjectStreamField("parseIntegerOnly", Boolean.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE)};
    private static final long serialVersionUID = -2308460125733713944L;
    private boolean groupingUsed = true;
    private boolean parseIntegerOnly = false;
    int maximumIntegerDigits = 40;
    int minimumIntegerDigits = 1;
    int maximumFractionDigits = 3;
    int minimumFractionDigits = 0;

    /* loaded from: source-2895416-dex2jar.jar:java/text/NumberFormat$Field.class */
    public static class Field extends Format.Field {
        private static final long serialVersionUID = 7494728892700160890L;
        public static final Field SIGN = new Field("sign");
        public static final Field INTEGER = new Field(TypedValues.Custom.S_INT);
        public static final Field FRACTION = new Field(SobotProgress.FRACTION);
        public static final Field EXPONENT = new Field("exponent");
        public static final Field EXPONENT_SIGN = new Field("exponent sign");
        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
        public static final Field PERCENT = new Field("percent");
        public static final Field PERMILLE = new Field("per mille");
        public static final Field CURRENCY = new Field(OapsKey.KEY_CURRENCY_CODE);

        protected Field(String str) {
            super(str);
        }
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableNumberFormatLocales();
    }

    public static final NumberFormat getCurrencyInstance() {
        return getCurrencyInstance(Locale.getDefault());
    }

    public static NumberFormat getCurrencyInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return getInstance(LocaleData.get(locale).currencyPattern, locale);
    }

    public static final NumberFormat getInstance() {
        return getNumberInstance();
    }

    private static NumberFormat getInstance(String str, Locale locale) {
        return new DecimalFormat(str, locale);
    }

    public static NumberFormat getInstance(Locale locale) {
        return getNumberInstance(locale);
    }

    public static final NumberFormat getIntegerInstance() {
        return getIntegerInstance(Locale.getDefault());
    }

    public static NumberFormat getIntegerInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        NumberFormat numberFormat = getInstance(LocaleData.get(locale).integerPattern, locale);
        numberFormat.setParseIntegerOnly(true);
        return numberFormat;
    }

    public static final NumberFormat getNumberInstance() {
        return getNumberInstance(Locale.getDefault());
    }

    public static NumberFormat getNumberInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return getInstance(LocaleData.get(locale).numberPattern, locale);
    }

    public static final NumberFormat getPercentInstance() {
        return getPercentInstance(Locale.getDefault());
    }

    public static NumberFormat getPercentInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return getInstance(LocaleData.get(locale).percentPattern, locale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.groupingUsed = readFields.get("groupingUsed", true);
        this.parseIntegerOnly = readFields.get("parseIntegerOnly", false);
        if (readFields.get("serialVersionOnStream", 0) == 0) {
            this.maximumFractionDigits = readFields.get("maxFractionDigits", (byte) 3);
            this.maximumIntegerDigits = readFields.get("maxIntegerDigits", (byte) 40);
            this.minimumFractionDigits = readFields.get("minFractionDigits", (byte) 0);
            this.minimumIntegerDigits = readFields.get("minIntegerDigits", (byte) 1);
        } else {
            this.maximumFractionDigits = readFields.get("maximumFractionDigits", 3);
            this.maximumIntegerDigits = readFields.get("maximumIntegerDigits", 40);
            this.minimumFractionDigits = readFields.get("minimumFractionDigits", 0);
            this.minimumIntegerDigits = readFields.get("minimumIntegerDigits", 1);
        }
        if (this.minimumIntegerDigits > this.maximumIntegerDigits || this.minimumFractionDigits > this.maximumFractionDigits) {
            throw new InvalidObjectException("min digits greater than max digits");
        }
        if (this.minimumIntegerDigits < 0 || this.maximumIntegerDigits < 0 || this.minimumFractionDigits < 0 || this.maximumFractionDigits < 0) {
            throw new InvalidObjectException("min or max digits negative");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("groupingUsed", this.groupingUsed);
        putFields.put("maxFractionDigits", this.maximumFractionDigits < 127 ? (byte) this.maximumFractionDigits : Byte.MAX_VALUE);
        putFields.put("maximumFractionDigits", this.maximumFractionDigits);
        putFields.put("maximumIntegerDigits", this.maximumIntegerDigits);
        putFields.put("maxIntegerDigits", this.maximumIntegerDigits < 127 ? (byte) this.maximumIntegerDigits : Byte.MAX_VALUE);
        putFields.put("minFractionDigits", this.minimumFractionDigits < 127 ? (byte) this.minimumFractionDigits : Byte.MAX_VALUE);
        putFields.put("minimumFractionDigits", this.minimumFractionDigits);
        putFields.put("minimumIntegerDigits", this.minimumIntegerDigits);
        byte b = Byte.MAX_VALUE;
        if (this.minimumIntegerDigits < 127) {
            b = (byte) this.minimumIntegerDigits;
        }
        putFields.put("minIntegerDigits", b);
        putFields.put("parseIntegerOnly", this.parseIntegerOnly);
        putFields.put("serialVersionOnStream", 1);
        objectOutputStream.writeFields();
    }

    @Override // java.text.Format
    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NumberFormat) {
            NumberFormat numberFormat = (NumberFormat) obj;
            return this.groupingUsed == numberFormat.groupingUsed && this.parseIntegerOnly == numberFormat.parseIntegerOnly && this.maximumFractionDigits == numberFormat.maximumFractionDigits && this.maximumIntegerDigits == numberFormat.maximumIntegerDigits && this.minimumFractionDigits == numberFormat.minimumFractionDigits && this.minimumIntegerDigits == numberFormat.minimumIntegerDigits;
        }
        return false;
    }

    public final String format(double d) {
        return format(d, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public final String format(long j) {
        return format(j, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition);

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof BigInteger) && ((BigInteger) obj).bitLength() < 64)) {
            return format(((Number) obj).longValue(), stringBuffer, fieldPosition);
        }
        if (obj instanceof Number) {
            return format(((Number) obj).doubleValue(), stringBuffer, fieldPosition);
        }
        if (obj == null) {
            throw new IllegalArgumentException("Can't format null object");
        }
        throw new IllegalArgumentException("Bad class: " + obj.getClass());
    }

    public Currency getCurrency() {
        throw new UnsupportedOperationException();
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    public RoundingMode getRoundingMode() {
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        int i = 1231;
        int i2 = this.groupingUsed ? 1231 : 1237;
        if (!this.parseIntegerOnly) {
            i = 1237;
        }
        return i2 + i + this.maximumFractionDigits + this.maximumIntegerDigits + this.minimumFractionDigits + this.minimumIntegerDigits;
    }

    public boolean isGroupingUsed() {
        return this.groupingUsed;
    }

    public boolean isParseIntegerOnly() {
        return this.parseIntegerOnly;
    }

    public Number parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Number parse = parse(str, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new ParseException("Unparseable number: \"" + str + "\"", parsePosition.getErrorIndex());
        }
        return parse;
    }

    public abstract Number parse(String str, ParsePosition parsePosition);

    @Override // java.text.Format
    public final Object parseObject(String str, ParsePosition parsePosition) {
        if (parsePosition == null) {
            throw new NullPointerException("position == null");
        }
        try {
            return parse(str, parsePosition);
        } catch (Exception e) {
            return null;
        }
    }

    public void setCurrency(Currency currency) {
        throw new UnsupportedOperationException();
    }

    public void setGroupingUsed(boolean z) {
        this.groupingUsed = z;
    }

    public void setMaximumFractionDigits(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.maximumFractionDigits = i2;
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.minimumFractionDigits = this.maximumFractionDigits;
        }
    }

    public void setMaximumIntegerDigits(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.maximumIntegerDigits = i2;
        if (this.maximumIntegerDigits < this.minimumIntegerDigits) {
            this.minimumIntegerDigits = this.maximumIntegerDigits;
        }
    }

    public void setMinimumFractionDigits(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.minimumFractionDigits = i2;
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.maximumFractionDigits = this.minimumFractionDigits;
        }
    }

    public void setMinimumIntegerDigits(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.minimumIntegerDigits = i2;
        if (this.maximumIntegerDigits < this.minimumIntegerDigits) {
            this.maximumIntegerDigits = this.minimumIntegerDigits;
        }
    }

    public void setParseIntegerOnly(boolean z) {
        this.parseIntegerOnly = z;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        throw new UnsupportedOperationException();
    }
}
