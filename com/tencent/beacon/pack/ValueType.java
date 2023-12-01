package com.tencent.beacon.pack;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/pack/ValueType.class */
public final class ValueType implements Serializable {
    public static final int BYTE_VAL = 1;
    public static final int MAP_VAL = 0;
    public static final int UNKNOWN_VAL = 2;
    private String t;
    private int value;
    public static final ValueType MAP = new ValueType(0, 0, "MAP");
    public static final ValueType BYTE = new ValueType(1, 1, "BYTE");
    public static final ValueType UNKNOWN = new ValueType(2, 2, "UNKNOWN");
    private static ValueType[] values = new ValueType[3];

    private ValueType(int i, int i2, String str) {
        this.t = str;
        this.value = i2;
        values[i] = this;
    }

    public static ValueType convert(int i) {
        ValueType[] valueTypeArr = values;
        int length = valueTypeArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            ValueType valueType = valueTypeArr[i3];
            if (valueType.value() == i) {
                return valueType;
            }
            i2 = i3 + 1;
        }
    }

    public static ValueType convert(String str) {
        ValueType[] valueTypeArr = values;
        int length = valueTypeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            ValueType valueType = valueTypeArr[i2];
            if (valueType.toString().equals(str)) {
                return valueType;
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        return this.t;
    }

    public int value() {
        return this.value;
    }
}
