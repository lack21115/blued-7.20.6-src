package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/MetaDataDirective.class */
public enum MetaDataDirective {
    COPY("Copy"),
    REPLACED("Replaced");
    
    String directive;

    MetaDataDirective(String str) {
        this.directive = str;
    }

    public static MetaDataDirective fromValue(String str) {
        MetaDataDirective[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            MetaDataDirective metaDataDirective = values[i2];
            if (metaDataDirective.directive.equalsIgnoreCase(str)) {
                return metaDataDirective;
            }
            i = i2 + 1;
        }
    }

    public String getMetaDirective() {
        return this.directive;
    }
}
