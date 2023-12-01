package com.sina.weibo.sdk.exception;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/exception/WeiboException.class */
public class WeiboException extends RuntimeException {
    private static final long serialVersionUID = 475022994858770424L;

    public WeiboException() {
    }

    public WeiboException(String str) {
        super(str);
    }

    public WeiboException(String str, Throwable th) {
        super(str, th);
    }

    public WeiboException(Throwable th) {
        super(th);
    }
}
