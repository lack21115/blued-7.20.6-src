package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/WidgetRequestParam.class */
public class WidgetRequestParam extends BrowserRequestParamBase {
    public static final String EXTRA_KEY_WIDGET_CALLBACK = "key_widget_callback";
    public static final String REQ_PARAM_ATTENTION_FUID = "fuid";
    public static final String REQ_PARAM_COMMENT_CATEGORY = "category";
    public static final String REQ_PARAM_COMMENT_CONTENT = "content";
    public static final String REQ_PARAM_COMMENT_TOPIC = "q";
    private String mAppKey;
    private String mAppPackage;
    private String mAttentionFuid;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private String mCommentCategory;
    private String mCommentContent;
    private String mCommentTopic;
    private String mHashKey;
    private String mToken;
    private WidgetRequestCallback mWidgetRequestCallback;
    private String mWidgetRequestCallbackKey;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/WidgetRequestParam$WidgetRequestCallback.class */
    public interface WidgetRequestCallback {
        void onWebViewResult(String str);
    }

    public WidgetRequestParam(Context context) {
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
        String aid = Utility.getAid(this.mContext, this.mAppKey);
        if (!TextUtils.isEmpty(aid)) {
            buildUpon.appendQueryParameter("aid", aid);
        }
        if (!TextUtils.isEmpty(this.mAppPackage)) {
            buildUpon.appendQueryParameter("packagename", this.mAppPackage);
        }
        if (!TextUtils.isEmpty(this.mHashKey)) {
            buildUpon.appendQueryParameter("key_hash", this.mHashKey);
        }
        if (!TextUtils.isEmpty(this.mAttentionFuid)) {
            buildUpon.appendQueryParameter(REQ_PARAM_ATTENTION_FUID, this.mAttentionFuid);
        }
        if (!TextUtils.isEmpty(this.mCommentTopic)) {
            buildUpon.appendQueryParameter("q", this.mCommentTopic);
        }
        if (!TextUtils.isEmpty(this.mCommentContent)) {
            buildUpon.appendQueryParameter("content", this.mCommentContent);
        }
        if (!TextUtils.isEmpty(this.mCommentCategory)) {
            buildUpon.appendQueryParameter("category", this.mCommentCategory);
        }
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void execRequest(Activity activity, int i) {
        if (i == 3) {
            WeiboSdkBrowser.closeBrowser(activity, this.mAuthListenerKey, this.mWidgetRequestCallbackKey);
        }
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAttentionFuid() {
        return this.mAttentionFuid;
    }

    public WeiboAuthListener getAuthListener() {
        return this.mAuthListener;
    }

    public String getAuthListenerKey() {
        return this.mAuthListenerKey;
    }

    public String getCommentCategory() {
        return this.mCommentCategory;
    }

    public String getCommentContent() {
        return this.mCommentContent;
    }

    public String getCommentTopic() {
        return this.mCommentTopic;
    }

    public String getToken() {
        return this.mToken;
    }

    public WidgetRequestCallback getWidgetRequestCallback() {
        return this.mWidgetRequestCallback;
    }

    public String getWidgetRequestCallbackKey() {
        return this.mWidgetRequestCallbackKey;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void onCreateRequestParamBundle(Bundle bundle) {
        String packageName = this.mContext.getPackageName();
        this.mAppPackage = packageName;
        if (!TextUtils.isEmpty(packageName)) {
            this.mHashKey = MD5.hexdigest(Utility.getSign(this.mContext, this.mAppPackage));
        }
        bundle.putString("access_token", this.mToken);
        bundle.putString("source", this.mAppKey);
        bundle.putString("packagename", this.mAppPackage);
        bundle.putString("key_hash", this.mHashKey);
        bundle.putString(REQ_PARAM_ATTENTION_FUID, this.mAttentionFuid);
        bundle.putString("q", this.mCommentTopic);
        bundle.putString("content", this.mCommentContent);
        bundle.putString("category", this.mCommentCategory);
        WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
        if (this.mAuthListener != null) {
            String genCallbackKey = weiboCallbackManager.genCallbackKey();
            this.mAuthListenerKey = genCallbackKey;
            weiboCallbackManager.setWeiboAuthListener(genCallbackKey, this.mAuthListener);
            bundle.putString(AuthRequestParam.EXTRA_KEY_LISTENER, this.mAuthListenerKey);
        }
        if (this.mWidgetRequestCallback != null) {
            String genCallbackKey2 = weiboCallbackManager.genCallbackKey();
            this.mWidgetRequestCallbackKey = genCallbackKey2;
            weiboCallbackManager.setWidgetRequestCallback(genCallbackKey2, this.mWidgetRequestCallback);
            bundle.putString(EXTRA_KEY_WIDGET_CALLBACK, this.mWidgetRequestCallbackKey);
        }
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    protected void onSetupRequestParam(Bundle bundle) {
        this.mAppKey = bundle.getString("source");
        this.mAppPackage = bundle.getString("packagename");
        this.mHashKey = bundle.getString("key_hash");
        this.mToken = bundle.getString("access_token");
        this.mAttentionFuid = bundle.getString(REQ_PARAM_ATTENTION_FUID);
        this.mCommentTopic = bundle.getString("q");
        this.mCommentContent = bundle.getString("content");
        this.mCommentCategory = bundle.getString("category");
        String string = bundle.getString(AuthRequestParam.EXTRA_KEY_LISTENER);
        this.mAuthListenerKey = string;
        if (!TextUtils.isEmpty(string)) {
            this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
        }
        String string2 = bundle.getString(EXTRA_KEY_WIDGET_CALLBACK);
        this.mWidgetRequestCallbackKey = string2;
        if (!TextUtils.isEmpty(string2)) {
            this.mWidgetRequestCallback = WeiboCallbackManager.getInstance(this.mContext).getWidgetRequestCallback(this.mWidgetRequestCallbackKey);
        }
        this.mUrl = buildUrl(this.mUrl);
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAttentionFuid(String str) {
        this.mAttentionFuid = str;
    }

    public void setAuthListener(WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
    }

    public void setCommentCategory(String str) {
        this.mCommentCategory = str;
    }

    public void setCommentContent(String str) {
        this.mCommentContent = str;
    }

    public void setCommentTopic(String str) {
        this.mCommentTopic = str;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setWidgetRequestCallback(WidgetRequestCallback widgetRequestCallback) {
        this.mWidgetRequestCallback = widgetRequestCallback;
    }
}
