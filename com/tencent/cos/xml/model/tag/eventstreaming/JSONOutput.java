package com.tencent.cos.xml.model.tag.eventstreaming;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/JSONOutput.class */
public class JSONOutput implements Serializable {
    private String recordDelimiter;

    public JSONOutput() {
        this("\n");
    }

    public JSONOutput(String str) {
        this.recordDelimiter = str;
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

    public Character getRecordDelimiter() {
        return stringToChar(this.recordDelimiter);
    }

    public String getRecordDelimiterAsString() {
        return this.recordDelimiter;
    }

    public void setRecordDelimiter(Character ch) {
        setRecordDelimiter(charToString(ch));
    }

    public void setRecordDelimiter(String str) {
        validateNotEmpty(str, "recordDelimiter");
        this.recordDelimiter = str;
    }

    public JSONOutput withRecordDelimiter(Character ch) {
        setRecordDelimiter(ch);
        return this;
    }

    public JSONOutput withRecordDelimiter(String str) {
        setRecordDelimiter(str);
        return this;
    }
}
