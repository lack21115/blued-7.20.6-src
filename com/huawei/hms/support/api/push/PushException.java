package com.huawei.hms.support.api.push;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/push/PushException.class */
public class PushException extends RuntimeException {
    public static final String EXCEPTION_SEND_FAILED = "send message failed";

    public PushException() {
    }

    public PushException(String str) {
        super(str);
    }

    public PushException(String str, Throwable th) {
        super(str, th);
    }

    public PushException(Throwable th) {
        super(th);
    }
}
