package com.tencent.cos.xml.model.tag.eventstreaming;

import com.alipay.sdk.util.i;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/CSVOutput.class */
public class CSVOutput implements Serializable, Cloneable {
    private String fieldDelimiter;
    private String quoteCharacter;
    private String quoteEscapeCharacter;
    private String quoteFields;
    private String recordDelimiter;

    public CSVOutput(String str, String str2, String str3, String str4, String str5) {
        this.quoteFields = str;
        this.recordDelimiter = str2;
        this.fieldDelimiter = str3;
        this.quoteCharacter = str4;
        this.quoteEscapeCharacter = str5;
    }

    private String charToString(Character ch) {
        if (ch == null) {
            return null;
        }
        return ch.toString();
    }

    private Character stringToChar(String str) {
        if (str == null) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    private void validateNotEmpty(String str, String str2) {
        if ("".equals(str)) {
            throw new IllegalArgumentException(str2 + " must not be empty-string.");
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CSVOutput)) {
            return false;
        }
        CSVOutput cSVOutput = (CSVOutput) obj;
        if ((cSVOutput.getQuoteEscapeCharacterAsString() == null) ^ (getQuoteEscapeCharacterAsString() == null)) {
            return false;
        }
        if (cSVOutput.getQuoteEscapeCharacterAsString() == null || cSVOutput.getQuoteEscapeCharacterAsString().equals(getQuoteEscapeCharacterAsString())) {
            if ((cSVOutput.getQuoteFields() == null) ^ (getQuoteFields() == null)) {
                return false;
            }
            if (cSVOutput.getQuoteFields() == null || cSVOutput.getQuoteFields().equals(getQuoteFields())) {
                if ((cSVOutput.getRecordDelimiterAsString() == null) ^ (getRecordDelimiterAsString() == null)) {
                    return false;
                }
                if (cSVOutput.getRecordDelimiterAsString() == null || cSVOutput.getRecordDelimiterAsString().equals(getRecordDelimiterAsString())) {
                    if ((cSVOutput.getFieldDelimiterAsString() == null) ^ (getFieldDelimiterAsString() == null)) {
                        return false;
                    }
                    if (cSVOutput.getFieldDelimiterAsString() == null || cSVOutput.getFieldDelimiterAsString().equals(getFieldDelimiterAsString())) {
                        if ((cSVOutput.getQuoteCharacterAsString() == null) ^ (getQuoteCharacterAsString() == null)) {
                            return false;
                        }
                        return cSVOutput.getQuoteCharacterAsString() == null || cSVOutput.getQuoteCharacterAsString().equals(getQuoteCharacterAsString());
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Character getFieldDelimiter() {
        return stringToChar(this.fieldDelimiter);
    }

    public String getFieldDelimiterAsString() {
        return this.fieldDelimiter;
    }

    public Character getQuoteCharacter() {
        return stringToChar(this.quoteCharacter);
    }

    public String getQuoteCharacterAsString() {
        return this.quoteCharacter;
    }

    public Character getQuoteEscapeCharacter() {
        return stringToChar(this.quoteEscapeCharacter);
    }

    public String getQuoteEscapeCharacterAsString() {
        return this.quoteEscapeCharacter;
    }

    public String getQuoteFields() {
        return this.quoteFields;
    }

    public Character getRecordDelimiter() {
        return stringToChar(this.recordDelimiter);
    }

    public String getRecordDelimiterAsString() {
        return this.recordDelimiter;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = getQuoteFields() == null ? 0 : getQuoteFields().hashCode();
        int hashCode2 = getQuoteEscapeCharacterAsString() == null ? 0 : getQuoteEscapeCharacterAsString().hashCode();
        int hashCode3 = getRecordDelimiterAsString() == null ? 0 : getRecordDelimiterAsString().hashCode();
        int hashCode4 = getFieldDelimiterAsString() == null ? 0 : getFieldDelimiterAsString().hashCode();
        if (getQuoteCharacterAsString() != null) {
            i = getQuoteCharacterAsString().hashCode();
        }
        return ((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public void setFieldDelimiter(Character ch) {
        setFieldDelimiter(charToString(ch));
    }

    public void setFieldDelimiter(String str) {
        validateNotEmpty(str, "fieldDelimiter");
        this.fieldDelimiter = str;
    }

    public void setQuoteCharacter(Character ch) {
        setQuoteCharacter(charToString(ch));
    }

    public void setQuoteCharacter(String str) {
        validateNotEmpty(str, "quoteCharacter");
        this.quoteCharacter = str;
    }

    public void setQuoteEscapeCharacter(Character ch) {
        setQuoteEscapeCharacter(charToString(ch));
    }

    public void setQuoteEscapeCharacter(String str) {
        validateNotEmpty(str, "quoteEscapeCharacter");
        this.quoteEscapeCharacter = str;
    }

    public void setQuoteFields(QuoteFields quoteFields) {
        setQuoteFields(quoteFields == null ? null : quoteFields.toString());
    }

    public void setQuoteFields(String str) {
        this.quoteFields = str;
    }

    public void setRecordDelimiter(Character ch) {
        setRecordDelimiter(charToString(ch));
    }

    public void setRecordDelimiter(String str) {
        validateNotEmpty(str, "recordDelimiter");
        this.recordDelimiter = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getQuoteFields() != null) {
            sb.append("QuoteFields: ");
            sb.append(getQuoteFields());
            sb.append(",");
        }
        if (getQuoteEscapeCharacter() != null) {
            sb.append("QuoteEscapeCharacter: ");
            sb.append(getQuoteEscapeCharacterAsString());
            sb.append(",");
        }
        if (getRecordDelimiter() != null) {
            sb.append("RecordDelimiter: ");
            sb.append(getRecordDelimiterAsString());
            sb.append(",");
        }
        if (getFieldDelimiter() != null) {
            sb.append("FieldDelimiter: ");
            sb.append(getFieldDelimiterAsString());
            sb.append(",");
        }
        if (getQuoteCharacter() != null) {
            sb.append("QuoteCharacter: ");
            sb.append(getQuoteCharacterAsString());
        }
        sb.append(i.d);
        return sb.toString();
    }

    public CSVOutput withFieldDelimiter(Character ch) {
        setFieldDelimiter(ch);
        return this;
    }

    public CSVOutput withFieldDelimiter(String str) {
        setFieldDelimiter(str);
        return this;
    }

    public CSVOutput withQuoteCharacter(Character ch) {
        setQuoteCharacter(ch);
        return this;
    }

    public CSVOutput withQuoteCharacter(String str) {
        setQuoteCharacter(str);
        return this;
    }

    public CSVOutput withQuoteEscapeCharacter(Character ch) {
        setQuoteEscapeCharacter(ch);
        return this;
    }

    public CSVOutput withQuoteEscapeCharacter(String str) {
        setQuoteEscapeCharacter(str);
        return this;
    }

    public CSVOutput withQuoteFields(QuoteFields quoteFields) {
        setQuoteFields(quoteFields);
        return this;
    }

    public CSVOutput withQuoteFields(String str) {
        setQuoteFields(str);
        return this;
    }

    public CSVOutput withRecordDelimiter(Character ch) {
        setRecordDelimiter(ch);
        return this;
    }

    public CSVOutput withRecordDelimiter(String str) {
        setRecordDelimiter(str);
        return this;
    }
}
