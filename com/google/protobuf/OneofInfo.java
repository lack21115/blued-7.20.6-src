package com.google.protobuf;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/OneofInfo.class */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;
    private final int id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
