package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bu;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/proto/Gender.class */
public enum Gender implements bu {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    private final int value;

    Gender(int i) {
        this.value = i;
    }

    public static Gender findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return UNKNOWN;
            }
            return FEMALE;
        }
        return MALE;
    }

    @Override // com.umeng.analytics.pro.bu
    public int getValue() {
        return this.value;
    }
}
