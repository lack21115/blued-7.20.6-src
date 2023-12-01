package org.apache.commons.codec.language.bm;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/NameType.class */
public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");
    
    private final String name;

    NameType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
