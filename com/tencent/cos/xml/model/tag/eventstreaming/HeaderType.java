package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderType.class */
public enum HeaderType {
    TRUE(0),
    FALSE(1),
    BYTE(2),
    SHORT(3),
    INTEGER(4),
    LONG(5),
    BYTE_ARRAY(6),
    STRING(7),
    TIMESTAMP(8),
    UUID(9);
    
    final byte headerTypeId;

    HeaderType(int i) {
        this.headerTypeId = (byte) i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HeaderType fromTypeId(byte b) {
        switch (b) {
            case 0:
                return TRUE;
            case 1:
                return FALSE;
            case 2:
                return BYTE;
            case 3:
                return SHORT;
            case 4:
                return INTEGER;
            case 5:
                return LONG;
            case 6:
                return BYTE_ARRAY;
            case 7:
                return STRING;
            case 8:
                return TIMESTAMP;
            case 9:
                return UUID;
            default:
                throw new IllegalArgumentException("Got unknown headerTypeId " + ((int) b));
        }
    }
}
