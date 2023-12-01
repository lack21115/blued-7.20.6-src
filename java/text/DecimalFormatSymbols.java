package java.text;

import android.hardware.Camera;
import android.provider.UserDictionary;
import androidx.exifinterface.media.ExifInterface;
import com.blued.das.live.LiveProtos;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/text/DecimalFormatSymbols.class */
public class DecimalFormatSymbols implements Cloneable, Serializable {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("currencySymbol", String.class), new ObjectStreamField("decimalSeparator", Character.TYPE), new ObjectStreamField("digit", Character.TYPE), new ObjectStreamField("exponential", Character.TYPE), new ObjectStreamField("exponentialSeparator", String.class), new ObjectStreamField("groupingSeparator", Character.TYPE), new ObjectStreamField(Camera.Parameters.FOCUS_MODE_INFINITY, String.class), new ObjectStreamField("intlCurrencySymbol", String.class), new ObjectStreamField("minusSign", Character.TYPE), new ObjectStreamField("monetarySeparator", Character.TYPE), new ObjectStreamField("NaN", String.class), new ObjectStreamField("patternSeparator", Character.TYPE), new ObjectStreamField("percent", Character.TYPE), new ObjectStreamField("perMill", Character.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE), new ObjectStreamField("zeroDigit", Character.TYPE), new ObjectStreamField(UserDictionary.Words.LOCALE, Locale.class)};
    private static final long serialVersionUID = 5772796243397350300L;
    private String NaN;
    private transient Currency currency;
    private String currencySymbol;
    private char decimalSeparator;
    private char digit;
    private transient String exponentSeparator;
    private char groupingSeparator;
    private String infinity;
    private String intlCurrencySymbol;
    private transient Locale locale;
    private String minusSign;
    private char monetarySeparator;
    private char patternSeparator;
    private char perMill;
    private String percent;
    private char zeroDigit;

    public DecimalFormatSymbols() {
        this(Locale.getDefault());
    }

    public DecimalFormatSymbols(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        Locale mapInvalidAndNullLocales = LocaleData.mapInvalidAndNullLocales(locale);
        LocaleData localeData = LocaleData.get(mapInvalidAndNullLocales);
        this.zeroDigit = localeData.zeroDigit;
        this.digit = '#';
        this.decimalSeparator = localeData.decimalSeparator;
        this.groupingSeparator = localeData.groupingSeparator;
        this.patternSeparator = localeData.patternSeparator;
        this.percent = localeData.percent;
        this.perMill = localeData.perMill;
        this.monetarySeparator = localeData.monetarySeparator;
        this.minusSign = localeData.minusSign;
        this.infinity = localeData.infinity;
        this.NaN = localeData.NaN;
        this.exponentSeparator = localeData.exponentSeparator;
        this.locale = mapInvalidAndNullLocales;
        try {
            this.currency = Currency.getInstance(mapInvalidAndNullLocales);
            this.currencySymbol = this.currency.getSymbol(mapInvalidAndNullLocales);
            this.intlCurrencySymbol = this.currency.getCurrencyCode();
        } catch (IllegalArgumentException e) {
            this.currency = Currency.getInstance("XXX");
            this.currencySymbol = localeData.currencySymbol;
            this.intlCurrencySymbol = localeData.internationalCurrencySymbol;
        }
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDecimalFormatSymbolsLocales();
    }

    public static DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static DecimalFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return new DecimalFormatSymbols(locale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        int i = readFields.get("serialVersionOnStream", 0);
        this.currencySymbol = (String) readFields.get("currencySymbol", "");
        setDecimalSeparator(readFields.get("decimalSeparator", '.'));
        setDigit(readFields.get("digit", '#'));
        setGroupingSeparator(readFields.get("groupingSeparator", ','));
        this.infinity = (String) readFields.get(Camera.Parameters.FOCUS_MODE_INFINITY, "");
        this.intlCurrencySymbol = (String) readFields.get("intlCurrencySymbol", "");
        setMinusSign(readFields.get("minusSign", '-'));
        this.NaN = (String) readFields.get("NaN", "");
        setPatternSeparator(readFields.get("patternSeparator", ';'));
        setPercent(readFields.get("percent", '%'));
        setPerMill(readFields.get("perMill", (char) 8240));
        setZeroDigit(readFields.get("zeroDigit", '0'));
        this.locale = (Locale) readFields.get(UserDictionary.Words.LOCALE, (Object) null);
        if (i == 0) {
            setMonetaryDecimalSeparator(getDecimalSeparator());
        } else {
            setMonetaryDecimalSeparator(readFields.get("monetarySeparator", '.'));
        }
        if (i == 0) {
            this.exponentSeparator = ExifInterface.LONGITUDE_EAST;
        } else if (i < 3) {
            setExponentSeparator(String.valueOf(readFields.get("exponential", 'E')));
        } else {
            setExponentSeparator((String) readFields.get("exponentialSeparator", ExifInterface.LONGITUDE_EAST));
        }
        try {
            this.currency = Currency.getInstance(this.intlCurrencySymbol);
        } catch (IllegalArgumentException e) {
            this.currency = null;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("currencySymbol", this.currencySymbol);
        putFields.put("decimalSeparator", getDecimalSeparator());
        putFields.put("digit", getDigit());
        putFields.put("exponential", this.exponentSeparator.charAt(0));
        putFields.put("exponentialSeparator", this.exponentSeparator);
        putFields.put("groupingSeparator", getGroupingSeparator());
        putFields.put(Camera.Parameters.FOCUS_MODE_INFINITY, this.infinity);
        putFields.put("intlCurrencySymbol", this.intlCurrencySymbol);
        putFields.put("minusSign", getMinusSign());
        putFields.put("monetarySeparator", getMonetaryDecimalSeparator());
        putFields.put("NaN", this.NaN);
        putFields.put("patternSeparator", getPatternSeparator());
        putFields.put("percent", getPercent());
        putFields.put("perMill", getPerMill());
        putFields.put("serialVersionOnStream", 3);
        putFields.put("zeroDigit", getZeroDigit());
        putFields.put(UserDictionary.Words.LOCALE, this.locale);
        objectOutputStream.writeFields();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecimalFormatSymbols) {
            DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols) obj;
            return this.currency.equals(decimalFormatSymbols.currency) && this.currencySymbol.equals(decimalFormatSymbols.currencySymbol) && this.decimalSeparator == decimalFormatSymbols.decimalSeparator && this.digit == decimalFormatSymbols.digit && this.exponentSeparator.equals(decimalFormatSymbols.exponentSeparator) && this.groupingSeparator == decimalFormatSymbols.groupingSeparator && this.infinity.equals(decimalFormatSymbols.infinity) && this.intlCurrencySymbol.equals(decimalFormatSymbols.intlCurrencySymbol) && this.minusSign.equals(decimalFormatSymbols.minusSign) && this.monetarySeparator == decimalFormatSymbols.monetarySeparator && this.NaN.equals(decimalFormatSymbols.NaN) && this.patternSeparator == decimalFormatSymbols.patternSeparator && this.perMill == decimalFormatSymbols.perMill && this.percent.equals(decimalFormatSymbols.percent) && this.zeroDigit == decimalFormatSymbols.zeroDigit;
        }
        return false;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public char getDigit() {
        return this.digit;
    }

    public String getExponentSeparator() {
        return this.exponentSeparator;
    }

    public char getGroupingSeparator() {
        return this.groupingSeparator;
    }

    public String getInfinity() {
        return this.infinity;
    }

    public String getInternationalCurrencySymbol() {
        return this.intlCurrencySymbol;
    }

    public char getMinusSign() {
        if (this.minusSign.length() == 1) {
            return this.minusSign.charAt(0);
        }
        throw new UnsupportedOperationException("Minus sign spans multiple characters: " + this.minusSign);
    }

    public String getMinusSignString() {
        return this.minusSign;
    }

    public char getMonetaryDecimalSeparator() {
        return this.monetarySeparator;
    }

    public String getNaN() {
        return this.NaN;
    }

    public char getPatternSeparator() {
        return this.patternSeparator;
    }

    public char getPerMill() {
        return this.perMill;
    }

    public char getPercent() {
        if (this.percent.length() == 1) {
            return this.percent.charAt(0);
        }
        throw new UnsupportedOperationException("Percent spans multiple characters: " + this.percent);
    }

    public String getPercentString() {
        return this.percent;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((this.zeroDigit + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.digit) * 31) + this.decimalSeparator) * 31) + this.groupingSeparator) * 31) + this.patternSeparator) * 31) + this.percent.hashCode()) * 31) + this.perMill) * 31) + this.monetarySeparator) * 31) + this.minusSign.hashCode()) * 31) + this.exponentSeparator.hashCode()) * 31) + this.infinity.hashCode()) * 31) + this.NaN.hashCode()) * 31) + this.currencySymbol.hashCode()) * 31) + this.intlCurrencySymbol.hashCode();
    }

    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new NullPointerException("currency == null");
        }
        this.currency = currency;
        this.intlCurrencySymbol = currency.getCurrencyCode();
        this.currencySymbol = currency.getSymbol(this.locale);
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public void setDecimalSeparator(char c2) {
        this.decimalSeparator = c2;
    }

    public void setDigit(char c2) {
        this.digit = c2;
    }

    public void setExponentSeparator(String str) {
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        this.exponentSeparator = str;
    }

    public void setGroupingSeparator(char c2) {
        this.groupingSeparator = c2;
    }

    public void setInfinity(String str) {
        this.infinity = str;
    }

    public void setInternationalCurrencySymbol(String str) {
        if (str == null) {
            this.currency = null;
            this.intlCurrencySymbol = null;
        } else if (str.equals(this.intlCurrencySymbol)) {
        } else {
            try {
                this.currency = Currency.getInstance(str);
                this.currencySymbol = this.currency.getSymbol(this.locale);
            } catch (IllegalArgumentException e) {
                this.currency = null;
            }
            this.intlCurrencySymbol = str;
        }
    }

    public void setMinusSign(char c2) {
        this.minusSign = String.valueOf(c2);
    }

    public void setMonetaryDecimalSeparator(char c2) {
        this.monetarySeparator = c2;
    }

    public void setNaN(String str) {
        this.NaN = str;
    }

    public void setPatternSeparator(char c2) {
        this.patternSeparator = c2;
    }

    public void setPerMill(char c2) {
        this.perMill = c2;
    }

    public void setPercent(char c2) {
        this.percent = String.valueOf(c2);
    }

    public void setZeroDigit(char c2) {
        this.zeroDigit = c2;
    }

    public String toString() {
        return getClass().getName() + "[currency=" + this.currency + ",currencySymbol=" + this.currencySymbol + ",decimalSeparator=" + this.decimalSeparator + ",digit=" + this.digit + ",exponentSeparator=" + this.exponentSeparator + ",groupingSeparator=" + this.groupingSeparator + ",infinity=" + this.infinity + ",intlCurrencySymbol=" + this.intlCurrencySymbol + ",minusSign=" + this.minusSign + ",monetarySeparator=" + this.monetarySeparator + ",NaN=" + this.NaN + ",patternSeparator=" + this.patternSeparator + ",perMill=" + this.perMill + ",percent=" + this.percent + ",zeroDigit=" + this.zeroDigit + "]";
    }
}
