package com.sina.weibo.sdk.exception;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/exception/WeiboAuthException.class */
public class WeiboAuthException extends WeiboException {
    public static final String DEFAULT_AUTH_ERROR_CODE = "-1";
    public static final String DEFAULT_AUTH_ERROR_DESC = "Unknown Error Description";
    public static final String DEFAULT_AUTH_ERROR_TYPE = "Unknown Error Type";
    private static final long serialVersionUID = 1;
    private final String mErrorCode;
    private final String mErrorType;

    public WeiboAuthException(String str, String str2, String str3) {
        super(str3);
        this.mErrorType = str2;
        this.mErrorCode = str;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorType() {
        return this.mErrorType;
    }
}
