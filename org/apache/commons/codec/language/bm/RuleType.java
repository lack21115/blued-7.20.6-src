package org.apache.commons.codec.language.bm;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/bm/RuleType.class */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");
    
    private final String name;

    RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
