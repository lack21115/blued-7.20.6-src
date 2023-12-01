package com.getui.gtc.dim;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/AllowSysCall.class */
public enum AllowSysCall {
    NOT_ALLOW(0),
    ONLY_ALLOW_FORE_CALL(1),
    ALL_ALLOW(2);
    
    private final int value;

    AllowSysCall(int i) {
        this.value = i;
    }

    public static AllowSysCall valueOf(int i) {
        return i != 0 ? i != 1 ? ALL_ALLOW : ONLY_ALLOW_FORE_CALL : NOT_ALLOW;
    }

    public final int getValue() {
        return this.value;
    }
}
