package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/AuthRequestParam.class */
public class AuthRequestParam extends BrowserRequestParamBase {
    public static final String EXTRA_KEY_AUTHINFO = "key_authinfo";
    public static final String EXTRA_KEY_LISTENER = "key_listener";
    private AuthInfo mAuthInfo;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;

    public AuthRequestParam(Context context) {
        super(context);
        this.mLaucher = BrowserLauncher.AUTH;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void execRequest(Activity activity, int i) {
        if (i == 3) {
            WeiboAuthListener weiboAuthListener = this.mAuthListener;
            if (weiboAuthListener != null) {
                weiboAuthListener.onCancel();
            }
            WeiboSdkBrowser.closeBrowser(activity, this.mAuthListenerKey, null);
        }
    }

    public AuthInfo getAuthInfo() {
        return this.mAuthInfo;
    }

    public WeiboAuthListener getAuthListener() {
        return this.mAuthListener;
    }

    public String getAuthListenerKey() {
        return this.mAuthListenerKey;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void onCreateRequestParamBundle(Bundle bundle) {
        AuthInfo authInfo = this.mAuthInfo;
        if (authInfo != null) {
            bundle.putBundle(EXTRA_KEY_AUTHINFO, authInfo.getAuthBundle());
        }
        if (this.mAuthListener != null) {
            WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
            String genCallbackKey = weiboCallbackManager.genCallbackKey();
            this.mAuthListenerKey = genCallbackKey;
            weiboCallbackManager.setWeiboAuthListener(genCallbackKey, this.mAuthListener);
            bundle.putString(EXTRA_KEY_LISTENER, this.mAuthListenerKey);
        }
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    protected void onSetupRequestParam(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(EXTRA_KEY_AUTHINFO);
        if (bundle2 != null) {
            this.mAuthInfo = AuthInfo.parseBundleData(this.mContext, bundle2);
        }
        String string = bundle.getString(EXTRA_KEY_LISTENER);
        this.mAuthListenerKey = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
    }

    public void setAuthInfo(AuthInfo authInfo) {
        this.mAuthInfo = authInfo;
    }

    public void setAuthListener(WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
    }
}
