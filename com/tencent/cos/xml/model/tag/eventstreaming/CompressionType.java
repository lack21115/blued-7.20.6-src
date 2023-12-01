package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/CompressionType.class */
public enum CompressionType {
    NONE("NONE"),
    GZIP("GZIP"),
    BZIP2("BZIP2");
    
    private final String compressionType;

    CompressionType(String str) {
        this.compressionType = str;
    }

    public static CompressionType fromValue(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        CompressionType[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
            }
            CompressionType compressionType = values[i2];
            if (compressionType.toString().equals(str)) {
                return compressionType;
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.compressionType;
    }
}
