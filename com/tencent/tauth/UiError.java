package com.tencent.tauth;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tauth/UiError.class */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int i, String str, String str2) {
        this.errorMessage = str;
        this.errorCode = i;
        this.errorDetail = str2;
    }
}
