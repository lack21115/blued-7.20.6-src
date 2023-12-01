package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.exception.WeiboException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/RequestListener.class */
public interface RequestListener {
    void onComplete(String str);

    void onWeiboException(WeiboException weiboException);
}
