package com.vivo.push.util;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/VivoPushException.class */
public class VivoPushException extends Exception {
    public static final int REASON_CODE_ACCESS = 10000;
    private int mReasonCode;

    public VivoPushException(int i, String str) {
        super(str);
        this.mReasonCode = i;
    }

    public VivoPushException(String str) {
        this(10000, str);
    }

    public int getCode() {
        return this.mReasonCode;
    }
}
