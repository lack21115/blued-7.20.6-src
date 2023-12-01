package com.ss.android.socialbase.downloader.exception;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/exception/RetryThrowable.class */
public class RetryThrowable extends Throwable {
    private String errorMsg;

    public RetryThrowable(String str) {
        super(str);
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
