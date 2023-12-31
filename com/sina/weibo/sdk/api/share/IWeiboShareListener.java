package com.sina.weibo.sdk.api.share;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/IWeiboShareListener.class */
public interface IWeiboShareListener {
    void onAuthorizeCancel();

    void onAuthorizeComplete(Oauth2AccessToken oauth2AccessToken);

    void onAuthorizeException(WeiboException weiboException);

    void onTokenError(String str);
}
