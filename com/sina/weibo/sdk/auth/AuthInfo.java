package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.Utility;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/AuthInfo.class */
public class AuthInfo {
    private String mAppKey;
    private String mKeyHash;
    private String mPackageName;
    private String mRedirectUrl;
    private String mScope;

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.mAppKey = "";
        this.mRedirectUrl = "";
        this.mScope = "";
        this.mPackageName = "";
        this.mKeyHash = "";
        this.mAppKey = str;
        this.mRedirectUrl = str2;
        this.mScope = str3;
        String packageName = context.getPackageName();
        this.mPackageName = packageName;
        this.mKeyHash = Utility.getSign(context, packageName);
    }

    public static AuthInfo parseBundleData(Context context, Bundle bundle) {
        return new AuthInfo(context, bundle.getString("appKey"), bundle.getString(WBConstants.SSO_REDIRECT_URL), bundle.getString("scope"));
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public Bundle getAuthBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", this.mAppKey);
        bundle.putString(WBConstants.SSO_REDIRECT_URL, this.mRedirectUrl);
        bundle.putString("scope", this.mScope);
        bundle.putString("packagename", this.mPackageName);
        bundle.putString("key_hash", this.mKeyHash);
        return bundle;
    }

    public String getKeyHash() {
        return this.mKeyHash;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getScope() {
        return this.mScope;
    }
}
