package com.blued.android.share.sina;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/sina/AbsOpenAPI.class */
public abstract class AbsOpenAPI {
    protected static final String API_SERVER = "https://api.weibo.com/2";
    protected static final String HTTPMETHOD_GET = "GET";
    protected static final String HTTPMETHOD_POST = "POST";
    protected static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String TAG = AbsOpenAPI.class.getName();
    protected Oauth2AccessToken mAccessToken;
    protected String mAppKey;
    protected Context mContext;

    public AbsOpenAPI(Context context, String str, Oauth2AccessToken oauth2AccessToken) {
        this.mContext = context;
        this.mAppKey = str;
        this.mAccessToken = oauth2AccessToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        if (this.mAccessToken == null || TextUtils.isEmpty(str) || weiboParameters == null || TextUtils.isEmpty(str2) || requestListener == null) {
            LogUtil.e(TAG, "Argument error!");
            return;
        }
        weiboParameters.put(KEY_ACCESS_TOKEN, this.mAccessToken.getToken());
        new AsyncWeiboRunner(this.mContext).requestAsync(str, weiboParameters, str2, requestListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String requestSync(String str, WeiboParameters weiboParameters, String str2) {
        if (this.mAccessToken == null || TextUtils.isEmpty(str) || weiboParameters == null || TextUtils.isEmpty(str2)) {
            LogUtil.e(TAG, "Argument error!");
            return "";
        }
        weiboParameters.put(KEY_ACCESS_TOKEN, this.mAccessToken.getToken());
        return new AsyncWeiboRunner(this.mContext).request(str, weiboParameters, str2);
    }
}
