package com.huawei.hms.api;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/HuaweiServicesNotAvailableException.class */
public final class HuaweiServicesNotAvailableException extends Exception {
    public final int errorCode;

    public HuaweiServicesNotAvailableException(int i) {
        this.errorCode = i;
    }
}
