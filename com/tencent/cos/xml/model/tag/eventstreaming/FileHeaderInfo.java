package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/FileHeaderInfo.class */
public enum FileHeaderInfo {
    USE("USE"),
    IGNORE("IGNORE"),
    NONE("NONE");
    
    private final String headerInfo;

    FileHeaderInfo(String str) {
        this.headerInfo = str;
    }

    public static FileHeaderInfo fromValue(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        FileHeaderInfo[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
            }
            FileHeaderInfo fileHeaderInfo = values[i2];
            if (fileHeaderInfo.toString().equals(str)) {
                return fileHeaderInfo;
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.headerInfo;
    }
}
