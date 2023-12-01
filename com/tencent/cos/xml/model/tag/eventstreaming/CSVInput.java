package com.tencent.cos.xml.model.tag.eventstreaming;

import android.provider.ContactsContract;
import com.alipay.sdk.util.i;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/CSVInput.class */
public class CSVInput implements Serializable, Cloneable {
    private Boolean allowQuotedRecordDelimiter;
    private String comments;
    private String fieldDelimiter;
    private String fileHeaderInfo;
    private String quoteCharacter;
    private String quoteEscapeCharacter;
    private String recordDelimiter;

    public CSVInput(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        this.recordDelimiter = str;
        this.fieldDelimiter = str2;
        this.quoteCharacter = str3;
        this.quoteEscapeCharacter = str4;
        this.allowQuotedRecordDelimiter = bool;
        this.fileHeaderInfo = str5;
        this.comments = str6;
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

    /* renamed from: clone */
    public CSVInput m10187clone() {
        try {
            return (CSVInput) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CSVInput)) {
            return false;
        }
        CSVInput cSVInput = (CSVInput) obj;
        if ((cSVInput.getFileHeaderInfo() == null) ^ (getFileHeaderInfo() == null)) {
            return false;
        }
        if (cSVInput.getFileHeaderInfo() == null || cSVInput.getFileHeaderInfo().equals(getFileHeaderInfo())) {
            if ((cSVInput.getQuoteEscapeCharacterAsString() == null) ^ (getQuoteEscapeCharacterAsString() == null)) {
                return false;
            }
            if (cSVInput.getQuoteEscapeCharacterAsString() == null || cSVInput.getQuoteEscapeCharacterAsString().equals(getQuoteEscapeCharacterAsString())) {
                if ((cSVInput.getCommentsAsString() == null) ^ (getCommentsAsString() == null)) {
                    return false;
                }
                if (cSVInput.getCommentsAsString() == null || cSVInput.getCommentsAsString().equals(getCommentsAsString())) {
                    if ((cSVInput.getRecordDelimiterAsString() == null) ^ (getRecordDelimiterAsString() == null)) {
                        return false;
                    }
                    if (cSVInput.getRecordDelimiterAsString() == null || cSVInput.getRecordDelimiterAsString().equals(getRecordDelimiterAsString())) {
                        if ((cSVInput.getFieldDelimiterAsString() == null) ^ (getFieldDelimiterAsString() == null)) {
                            return false;
                        }
                        if (cSVInput.getFieldDelimiterAsString() == null || cSVInput.getFieldDelimiterAsString().equals(getFieldDelimiterAsString())) {
                            if ((cSVInput.getQuoteCharacterAsString() == null) ^ (getQuoteCharacterAsString() == null)) {
                                return false;
                            }
                            if (cSVInput.getQuoteCharacterAsString() == null || cSVInput.getQuoteCharacterAsString().equals(getQuoteCharacterAsString())) {
                                return cSVInput.getAllowQuotedRecordDelimiter() == null || cSVInput.getAllowQuotedRecordDelimiter().equals(getAllowQuotedRecordDelimiter());
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Boolean getAllowQuotedRecordDelimiter() {
        return this.allowQuotedRecordDelimiter;
    }

    public Character getComments() {
        return stringToChar(this.comments);
    }

    public String getCommentsAsString() {
        return this.comments;
    }

    public Character getFieldDelimiter() {
        return stringToChar(this.fieldDelimiter);
    }

    public String getFieldDelimiterAsString() {
        return this.fieldDelimiter;
    }

    public String getFileHeaderInfo() {
        return this.fileHeaderInfo;
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

    public Character getRecordDelimiter() {
        return stringToChar(this.recordDelimiter);
    }

    public String getRecordDelimiterAsString() {
        return this.recordDelimiter;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = getFileHeaderInfo() == null ? 0 : getFileHeaderInfo().hashCode();
        int hashCode2 = getCommentsAsString() == null ? 0 : getCommentsAsString().hashCode();
        int hashCode3 = getQuoteEscapeCharacterAsString() == null ? 0 : getQuoteEscapeCharacterAsString().hashCode();
        int hashCode4 = getRecordDelimiterAsString() == null ? 0 : getRecordDelimiterAsString().hashCode();
        int hashCode5 = getFieldDelimiterAsString() == null ? 0 : getFieldDelimiterAsString().hashCode();
        int hashCode6 = getQuoteCharacterAsString() != null ? getQuoteCharacterAsString().hashCode() : 0;
        if (getAllowQuotedRecordDelimiter() != null) {
            i = getAllowQuotedRecordDelimiter().hashCode();
        }
        return ((((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }

    public void setAllowQuotedRecordDelimiter(Boolean bool) {
        this.allowQuotedRecordDelimiter = bool;
    }

    public void setComments(Character ch) {
        setComments(charToString(ch));
    }

    public void setComments(String str) {
        validateNotEmpty(str, ContactsContract.StreamItemsColumns.COMMENTS);
        this.comments = str;
    }

    public void setFieldDelimiter(Character ch) {
        setFieldDelimiter(charToString(ch));
    }

    public void setFieldDelimiter(String str) {
        validateNotEmpty(str, "fieldDelimiter");
        this.fieldDelimiter = str;
    }

    public void setFileHeaderInfo(FileHeaderInfo fileHeaderInfo) {
        setFileHeaderInfo(fileHeaderInfo == null ? null : fileHeaderInfo.toString());
    }

    public void setFileHeaderInfo(String str) {
        this.fileHeaderInfo = str;
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
        if (getFileHeaderInfo() != null) {
            sb.append("FileHeaderInfo: ");
            sb.append(getFileHeaderInfo());
            sb.append(",");
        }
        if (getCommentsAsString() != null) {
            sb.append("Comments: ");
            sb.append(getCommentsAsString());
            sb.append(",");
        }
        if (getQuoteEscapeCharacterAsString() != null) {
            sb.append("QuoteEscapeCharacter: ");
            sb.append(getQuoteEscapeCharacterAsString());
            sb.append(",");
        }
        if (getRecordDelimiterAsString() != null) {
            sb.append("RecordDelimiter: ");
            sb.append(getRecordDelimiterAsString());
            sb.append(",");
        }
        if (getFieldDelimiterAsString() != null) {
            sb.append("FieldDelimiter: ");
            sb.append(getFieldDelimiterAsString());
            sb.append(",");
        }
        if (getQuoteCharacterAsString() != null) {
            sb.append("QuoteCharacter: ");
            sb.append(getQuoteCharacterAsString());
        }
        if (getAllowQuotedRecordDelimiter() != null) {
            sb.append("AllowQuotedRecordDelimiter: ");
            sb.append(getAllowQuotedRecordDelimiter());
        }
        sb.append(i.d);
        return sb.toString();
    }

    public CSVInput withAllowQuotedRecordDelimiter(Boolean bool) {
        setAllowQuotedRecordDelimiter(bool);
        return this;
    }

    public CSVInput withComments(Character ch) {
        setComments(ch);
        return this;
    }

    public CSVInput withComments(String str) {
        setComments(str);
        return this;
    }

    public CSVInput withFieldDelimiter(Character ch) {
        setFieldDelimiter(ch);
        return this;
    }

    public CSVInput withFieldDelimiter(String str) {
        setFieldDelimiter(str);
        return this;
    }

    public CSVInput withFileHeaderInfo(FileHeaderInfo fileHeaderInfo) {
        setFileHeaderInfo(fileHeaderInfo);
        return this;
    }

    public CSVInput withFileHeaderInfo(String str) {
        setFileHeaderInfo(str);
        return this;
    }

    public CSVInput withQuoteCharacter(Character ch) {
        setQuoteCharacter(ch);
        return this;
    }

    public CSVInput withQuoteCharacter(String str) {
        setQuoteCharacter(str);
        return this;
    }

    public CSVInput withQuoteEscapeCharacter(Character ch) {
        setQuoteEscapeCharacter(ch);
        return this;
    }

    public CSVInput withQuoteEscapeCharacter(String str) {
        setQuoteEscapeCharacter(str);
        return this;
    }

    public CSVInput withRecordDelimiter(Character ch) {
        setRecordDelimiter(ch);
        return this;
    }

    public CSVInput withRecordDelimiter(String str) {
        setRecordDelimiter(str);
        return this;
    }
}
