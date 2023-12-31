package com.sina.weibo.sdk.auth.sso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.AuthRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/sso/WebAuthHandler.class */
public class WebAuthHandler {
    private static final String NETWORK_NOT_AVAILABLE_EN = "Network is not available";
    private static final String NETWORK_NOT_AVAILABLE_ZH_CN = "无法连接到网络，请检查网络配置";
    private static final String NETWORK_NOT_AVAILABLE_ZH_TW = "無法連接到網络，請檢查網络配置";
    private static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    private static final int OBTAIN_AUTH_CODE = 0;
    private static final int OBTAIN_AUTH_TOKEN = 1;
    private static final String TAG = WebAuthHandler.class.getName();
    private AuthInfo mAuthInfo;
    private Context mContext;

    public WebAuthHandler(Context context, AuthInfo authInfo) {
        this.mContext = context;
        this.mAuthInfo = authInfo;
    }

    private void startDialog(WeiboAuthListener weiboAuthListener, int i) {
        if (weiboAuthListener == null) {
            return;
        }
        WeiboParameters weiboParameters = new WeiboParameters(this.mAuthInfo.getAppKey());
        weiboParameters.put("client_id", this.mAuthInfo.getAppKey());
        weiboParameters.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, this.mAuthInfo.getRedirectUrl());
        weiboParameters.put("scope", this.mAuthInfo.getScope());
        weiboParameters.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
        weiboParameters.put("version", WBConstants.WEIBO_SDK_VERSION_CODE);
        String aid = Utility.getAid(this.mContext, this.mAuthInfo.getAppKey());
        if (!TextUtils.isEmpty(aid)) {
            weiboParameters.put("aid", aid);
        }
        if (1 == i) {
            weiboParameters.put("packagename", this.mAuthInfo.getPackageName());
            weiboParameters.put("key_hash", this.mAuthInfo.getKeyHash());
        }
        String str = OAUTH2_BASE_URL + weiboParameters.encodeUrl();
        if (!NetworkHelper.hasInternetPermission(this.mContext)) {
            UIUtils.showAlert(this.mContext, "Error", "Application requires permission to access the Internet");
            return;
        }
        AuthRequestParam authRequestParam = new AuthRequestParam(this.mContext);
        authRequestParam.setAuthInfo(this.mAuthInfo);
        authRequestParam.setAuthListener(weiboAuthListener);
        authRequestParam.setUrl(str);
        authRequestParam.setSpecifyTitle("微博登录");
        Bundle createRequestParamBundle = authRequestParam.createRequestParamBundle();
        Intent intent = new Intent(this.mContext, WeiboSdkBrowser.class);
        intent.putExtras(createRequestParamBundle);
        this.mContext.startActivity(intent);
    }

    public void anthorize(WeiboAuthListener weiboAuthListener) {
        authorize(weiboAuthListener, 1);
    }

    public void authorize(WeiboAuthListener weiboAuthListener, int i) {
        startDialog(weiboAuthListener, i);
    }

    public AuthInfo getAuthInfo() {
        return this.mAuthInfo;
    }
}
