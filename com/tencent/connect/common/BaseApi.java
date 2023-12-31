package com.tencent.connect.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/common/BaseApi.class */
public abstract class BaseApi {
    protected static final String ACTION_CHECK_TOKEN = "action_check_token";
    protected static final String ACTIVITY_AGENT = "com.tencent.open.agent.AgentActivity";
    protected static final String ACTIVITY_ENCRY_TOKEN = "com.tencent.open.agent.EncryTokenActivity";
    protected static final String DEFAULT_PF = "openmobile_android";
    private static final String KEY_REQUEST_CODE = "key_request_code";
    private static final int MSG_COMPLETE = 0;
    protected static final String PARAM_ENCRY_EOKEN = "encry_token";
    protected static final String PLATFORM = "desktop_m_qq";
    protected static final String PREFERENCE_PF = "pfStore";
    private static final String TAG = "openSDK_LOG.BaseApi";
    protected static final String VERSION = "android";
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM = false;
    public static String registerChannel;
    protected ProgressDialog mProgressDialog;
    protected QQAuth mQQAuth;
    public QQToken mToken;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/common/BaseApi$TempRequestListener.class */
    public class TempRequestListener implements IRequestListener {
        private final Handler mHandler;
        private final IUiListener mListener;

        public TempRequestListener(IUiListener iUiListener) {
            this.mListener = iUiListener;
            this.mHandler = new Handler(Global.getContext().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.mListener.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.mListener.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = connectTimeoutException.getMessage();
            obtainMessage.what = -7;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.mHandler.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public BaseApi(QQAuth qQAuth, QQToken qQToken) {
        this.mQQAuth = qQAuth;
        this.mToken = qQToken;
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    private Intent getAssitIntent(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent2.putExtra(SystemUtils.IS_LOGIN, true);
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        return intent2;
    }

    public Bundle composeActivityParams() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.mToken.getAppId());
        if (this.mToken.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.mToken.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.mToken.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = Global.getContext().getSharedPreferences("pfStore", 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + "android" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle composeCGIParams() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.mToken;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.mToken.getAccessToken());
            bundle.putString("oauth_consumer_key", this.mToken.getAppId());
            bundle.putString("openid", this.mToken.getOpenId());
            bundle.putString("appid_for_getting_config", this.mToken.getAppId());
        }
        SharedPreferences sharedPreferences = Global.getContext().getSharedPreferences("pfStore", 0);
        if (!isOEM) {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            return bundle;
        }
        bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + "android" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        return bundle;
    }

    protected Intent getAgentIntent() {
        return getTargetActivityIntent(ACTIVITY_AGENT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getAgentIntentWithTarget(String str) {
        Intent intent = new Intent();
        Intent targetActivityIntent = getTargetActivityIntent(str);
        if (targetActivityIntent == null || targetActivityIntent.getComponent() == null) {
            return null;
        }
        intent.setClassName(targetActivityIntent.getComponent().getPackageName(), ACTIVITY_AGENT);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getCommonDownloadQQUrl(String str) {
        Bundle composeCGIParams = composeCGIParams();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            composeCGIParams.putString("need_version", str);
        }
        sb.append(ServerSetting.NEED_QQ_VERSION_TIPS_URL);
        sb.append(Util.encodeUrl(composeCGIParams));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getTargetActivityIntent(String str) {
        Intent intent = new Intent();
        if (Util.isTablet(Global.getContext())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (SystemUtils.isActivityExist(Global.getContext(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (SystemUtils.isActivityExist(Global.getContext(), intent)) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleDownloadLastestQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c(TAG, "--handleDownloadLastestQQ");
        new TDialog(activity, "", ServerSetting.DOWNLOAD_QQ_URL + Util.encodeUrl(bundle), null, this.mToken).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasActivityForIntent(Intent intent) {
        if (intent != null) {
            return SystemUtils.isActivityExist(Global.getContext(), intent);
        }
        return false;
    }

    public void releaseResource() {
    }

    protected void showProgressDialog(Context context, String str, String str2) {
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = "请稍候";
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = "正在加载...";
        }
        ProgressDialog show = ProgressDialog.show(context, str3, str4);
        this.mProgressDialog = show;
        show.setCancelable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAssistActivity(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        if (z) {
            intent2.putExtra(SystemUtils.IS_QQ_MOBILE_SHARE, true);
        }
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        activity.startActivityForResult(intent2, i);
    }

    protected void startAssistActivity(Activity activity, Bundle bundle, int i, Intent intent) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent2.putExtra(SystemUtils.H5_SHARE_DATA, bundle);
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        activity.startActivityForResult(intent2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAssitActivity(Activity activity, Intent intent, int i) {
        intent.putExtra("key_request_code", i);
        activity.startActivityForResult(getAssitIntent(activity, intent), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAssitActivity(Fragment fragment, Intent intent, int i) {
        intent.putExtra("key_request_code", i);
        fragment.startActivityForResult(getAssitIntent(fragment.getActivity(), intent), i);
    }
}
