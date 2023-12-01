package org.msgpack.value;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/ValueType.class */
public enum ValueType {
    NIL(false, false),
    BOOLEAN(false, false),
    INTEGER(true, false),
    FLOAT(true, false),
    STRING(false, true),
    BINARY(false, true),
    ARRAY(false, false),
    MAP(false, false),
    EXTENSION(false, false);
    
    private final boolean numberType;
    private final boolean rawType;

    ValueType(boolean z, boolean z2) {
        this.numberType = z;
        this.rawType = z2;
    }

    public boolean isArrayType() {
        return this == ARRAY;
    }

    public boolean isBinaryType() {
        return this == BINARY;
    }

    public boolean isBooleanType() {
        return this == BOOLEAN;
    }

    public boolean isExtensionType() {
        return this == EXTENSION;
    }

    public boolean isFloatType() {
        return this == FLOAT;
    }

    public boolean isIntegerType() {
        return this == INTEGER;
    }

    public boolean isMapType() {
        return this == MAP;
    }

    public boolean isNilType() {
        return this == NIL;
    }

    public boolean isNumberType() {
        return this.numberType;
    }

    public boolean isRawType() {
        return this.rawType;
    }

    public boolean isStringType() {
        return this == STRING;
    }
}
