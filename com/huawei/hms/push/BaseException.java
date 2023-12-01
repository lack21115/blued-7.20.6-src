package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/BaseException.class */
public class BaseException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final int f22829a;
    private final ErrorEnum b;

    public BaseException(int i) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i);
        this.b = fromCode;
        this.f22829a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f22829a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b.getMessage();
    }
}
