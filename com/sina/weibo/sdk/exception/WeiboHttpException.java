package com.sina.weibo.sdk.exception;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/exception/WeiboHttpException.class */
public class WeiboHttpException extends WeiboException {
    private static final long serialVersionUID = 1;
    private final int mStatusCode;

    public WeiboHttpException(String str, int i) {
        super(str);
        this.mStatusCode = i;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
