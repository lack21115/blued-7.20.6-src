package com.sina.weibo.sdk.net.openapi;

import android.content.Context;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/openapi/RefreshTokenApi.class */
public class RefreshTokenApi {
    private static final String REFRESH_TOKEN_URL = "https://api.weibo.com/oauth2/access_token";
    private Context mContext;

    private RefreshTokenApi(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static RefreshTokenApi create(Context context) {
        return new RefreshTokenApi(context);
    }

    public void refreshToken(String str, String str2, RequestListener requestListener) {
        WeiboParameters weiboParameters = new WeiboParameters(str);
        weiboParameters.put("client_id", str);
        weiboParameters.put(WBConstants.AUTH_PARAMS_GRANT_TYPE, Oauth2AccessToken.KEY_REFRESH_TOKEN);
        weiboParameters.put(Oauth2AccessToken.KEY_REFRESH_TOKEN, str2);
        new AsyncWeiboRunner(this.mContext).requestAsync(REFRESH_TOKEN_URL, weiboParameters, "POST", requestListener);
    }
}
