package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/GameRequestParam.class */
public class GameRequestParam extends BrowserRequestParamBase {
    private String mAppKey;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private String mToken;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/GameRequestParam$WidgetRequestCallback.class */
    public interface WidgetRequestCallback {
        void onWebViewResult(String str);
    }

    public GameRequestParam(Context context) {
        super(context);
        this.mLaucher = BrowserLauncher.WIDGET;
    }

    private String buildUrl(String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("version", WBConstants.WEIBO_SDK_VERSION_CODE);
        if (!TextUtils.isEmpty(this.mAppKey)) {
            buildUpon.appendQueryParameter("source", this.mAppKey);
        }
        if (!TextUtils.isEmpty(this.mToken)) {
            buildUpon.appendQueryParameter("access_token", this.mToken);
        }
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void execRequest(Activity activity, int i) {
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public WeiboAuthListener getAuthListener() {
        return this.mAuthListener;
    }

    public String getAuthListenerKey() {
        return this.mAuthListenerKey;
    }

    public String getToken() {
        return this.mToken;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void onCreateRequestParamBundle(Bundle bundle) {
        bundle.putString("access_token", this.mToken);
        bundle.putString("source", this.mAppKey);
        WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
        if (this.mAuthListener != null) {
            String genCallbackKey = weiboCallbackManager.genCallbackKey();
            this.mAuthListenerKey = genCallbackKey;
            weiboCallbackManager.setWeiboAuthListener(genCallbackKey, this.mAuthListener);
            bundle.putString(AuthRequestParam.EXTRA_KEY_LISTENER, this.mAuthListenerKey);
        }
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    protected void onSetupRequestParam(Bundle bundle) {
        this.mAppKey = bundle.getString("source");
        this.mToken = bundle.getString("access_token");
        String string = bundle.getString(AuthRequestParam.EXTRA_KEY_LISTENER);
        this.mAuthListenerKey = string;
        if (!TextUtils.isEmpty(string)) {
            this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
        }
        this.mUrl = buildUrl(this.mUrl);
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAuthListener(WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
