package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/QuoteFields.class */
public enum QuoteFields {
    ALWAYS("ALWAYS"),
    ASNEEDED("ASNEEDED");
    
    private final String value;

    QuoteFields(String str) {
        this.value = str;
    }

    public static QuoteFields fromValue(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        QuoteFields[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
            }
            QuoteFields quoteFields = values[i2];
            if (quoteFields.toString().equals(str)) {
                return quoteFields;
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
