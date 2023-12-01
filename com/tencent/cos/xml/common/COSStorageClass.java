package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/COSStorageClass.class */
public enum COSStorageClass {
    STANDARD("STANDARD"),
    STANDARD_IA("STANDARD_IA"),
    ARCHIVE("ARCHIVE"),
    DEEP_ARCHIVE("DEEP_ARCHIVE"),
    INTELLIGENT_TIERING("INTELLIGENT_TIERING"),
    MAZ_STANDARD("MAZ_STANDARD"),
    MAZ_STANDARD_IA("MAZ_STANDARD_IA"),
    MAZ_INTELLIGENT_TIERING("MAZ_INTELLIGENT_TIERING");
    
    private String cosStorageClass;

    COSStorageClass(String str) {
        this.cosStorageClass = str;
    }

    public static COSStorageClass fromString(String str) {
        COSStorageClass[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            COSStorageClass cOSStorageClass = values[i2];
            if (cOSStorageClass.cosStorageClass.equalsIgnoreCase(str)) {
                return cOSStorageClass;
            }
            i = i2 + 1;
        }
    }

    public String getStorageClass() {
        return this.cosStorageClass;
    }
}
