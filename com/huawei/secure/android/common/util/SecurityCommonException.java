package com.huawei.secure.android.common.util;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/SecurityCommonException.class */
public class SecurityCommonException extends Exception {

    /* renamed from: c  reason: collision with root package name */
    private static final long f9545c = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f9546a;
    private String b;

    public SecurityCommonException() {
    }

    public SecurityCommonException(String str) {
        super(str);
        this.b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f9546a = str;
        this.b = str2;
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public String getMsgDes() {
        return this.b;
    }

    public String getRetCd() {
        return this.f9546a;
    }
}
