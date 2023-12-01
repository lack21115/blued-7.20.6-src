package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.ShareRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/WeiboShareAPIImpl.class */
class WeiboShareAPIImpl implements IWeiboShareAPI {
    private static final String TAG = WeiboShareAPIImpl.class.getName();
    private String mAppKey;
    private Context mContext;
    private Dialog mDownloadConfirmDialog = null;
    private IWeiboDownloadListener mDownloadListener;
    private boolean mNeedDownloadWeibo;
    private WeiboAppManager.WeiboInfo mWeiboInfo;

    public WeiboShareAPIImpl(Context context, String str, boolean z) {
        this.mWeiboInfo = null;
        this.mNeedDownloadWeibo = true;
        this.mContext = context;
        this.mAppKey = str;
        this.mNeedDownloadWeibo = z;
        WeiboAppManager.WeiboInfo weiboInfo = WeiboAppManager.getInstance(context).getWeiboInfo();
        this.mWeiboInfo = weiboInfo;
        if (weiboInfo != null) {
            LogUtil.d(TAG, weiboInfo.toString());
        } else {
            LogUtil.d(TAG, "WeiboInfo is null");
        }
        AidTask.getInstance(context).aidTaskInit(str);
    }

    private WeiboMessage adapterMultiMessage2SingleMessage(WeiboMultiMessage weiboMultiMessage) {
        if (weiboMultiMessage == null) {
            return new WeiboMessage();
        }
        Bundle bundle = new Bundle();
        weiboMultiMessage.toBundle(bundle);
        return new WeiboMessage(bundle);
    }

    private boolean checkEnvironment(boolean z) throws WeiboShareException {
        if (isWeiboAppInstalled()) {
            if (isWeiboAppSupportAPI()) {
                if (ApiUtils.validateWeiboSign(this.mContext, this.mWeiboInfo.getPackageName())) {
                    return true;
                }
                throw new WeiboShareException("Weibo signature is incorrect!");
            }
            throw new WeiboShareException("Weibo do not support share api!");
        } else if (z) {
            Dialog dialog = this.mDownloadConfirmDialog;
            if (dialog == null) {
                Dialog createDownloadConfirmDialog = WeiboDownloader.createDownloadConfirmDialog(this.mContext, this.mDownloadListener);
                this.mDownloadConfirmDialog = createDownloadConfirmDialog;
                createDownloadConfirmDialog.show();
                return false;
            } else if (dialog.isShowing()) {
                return false;
            } else {
                this.mDownloadConfirmDialog.show();
                return false;
            }
        } else {
            throw new WeiboShareException("Weibo is not installed!");
        }
    }

    private boolean launchWeiboActivity(Activity activity, String str, String str2, String str3, Bundle bundle, String str4) {
        if (activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
            return false;
        }
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(str);
        String packageName = activity.getPackageName();
        intent.putExtra(WBConstants.Base.SDK_VER, WBConstants.WEIBO_SDK_VERSION_CODE);
        intent.putExtra(WBConstants.Base.APP_PKG, packageName);
        intent.putExtra(WBConstants.Base.APP_KEY, str3);
        intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(activity, packageName)));
        String valueOf = String.valueOf(System.currentTimeMillis());
        intent.putExtra(WBConstants.TRAN, valueOf);
        addEventLog(activity, valueOf, str4);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            String str5 = TAG;
            LogUtil.d(str5, "launchWeiboActivity intent=" + intent + ", extra=" + intent.getExtras());
            activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
            return true;
        } catch (ActivityNotFoundException e) {
            LogUtil.e(TAG, e.getMessage());
            return false;
        }
    }

    private void registerWeiboDownloadListener(IWeiboDownloadListener iWeiboDownloadListener) {
        this.mDownloadListener = iWeiboDownloadListener;
    }

    private void sendBroadcast(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent(str);
        String packageName = context.getPackageName();
        intent.putExtra(WBConstants.Base.SDK_VER, WBConstants.WEIBO_SDK_VERSION_CODE);
        intent.putExtra(WBConstants.Base.APP_PKG, packageName);
        intent.putExtra(WBConstants.Base.APP_KEY, str2);
        intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(context, packageName)));
        if (!TextUtils.isEmpty(str3)) {
            intent.setPackage(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String str4 = TAG;
        LogUtil.d(str4, "intent=" + intent + ", extra=" + intent.getExtras());
        context.sendBroadcast(intent, WBConstants.ACTION_WEIBO_SDK_PERMISSION);
    }

    private boolean startShareWeiboActivity(Activity activity, String str, BaseRequest baseRequest, WeiboAuthListener weiboAuthListener) {
        try {
            WbAppActivator.getInstance(this.mContext, this.mAppKey).activateApp();
            new Bundle();
            String packageName = activity.getPackageName();
            ShareRequestParam shareRequestParam = new ShareRequestParam(activity);
            shareRequestParam.setToken(str);
            shareRequestParam.setAppKey(this.mAppKey);
            shareRequestParam.setAppPackage(packageName);
            shareRequestParam.setBaseRequest(baseRequest);
            shareRequestParam.setSpecifyTitle("微博分享");
            shareRequestParam.setAuthListener(weiboAuthListener);
            Intent intent = new Intent(activity, WeiboSdkBrowser.class);
            intent.putExtras(shareRequestParam.createRequestParamBundle());
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    public void addEventLog(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(WBConstants.ACTION_START_TIME, str);
        try {
            WBAgent.onEvent(context, str2, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public int getWeiboAppSupportAPI() {
        WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
        if (weiboInfo == null || !weiboInfo.isLegal()) {
            return -1;
        }
        return this.mWeiboInfo.getSupportApi();
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request) {
        if (intent == null || request == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(WBConstants.Base.APP_PKG);
        String stringExtra2 = intent.getStringExtra(WBConstants.TRAN);
        if (TextUtils.isEmpty(stringExtra)) {
            LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        } else if (TextUtils.isEmpty(stringExtra2)) {
            LogUtil.e(TAG, "handleWeiboRequest faild intent _weibo_transaction is null");
            request.onRequest(null);
            return false;
        } else if (ApiUtils.validateWeiboSign(this.mContext, stringExtra)) {
            request.onRequest(new ProvideMessageForWeiboRequest(intent.getExtras()));
            return true;
        } else {
            LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response) {
        String stringExtra = intent.getStringExtra(WBConstants.Base.APP_PKG);
        String stringExtra2 = intent.getStringExtra(WBConstants.TRAN);
        if (TextUtils.isEmpty(stringExtra)) {
            LogUtil.e(TAG, "handleWeiboResponse faild appPackage is null");
            return false;
        } else if (!(response instanceof Activity)) {
            LogUtil.e(TAG, "handleWeiboResponse faild handler is not Activity");
            return false;
        } else {
            Activity activity = (Activity) response;
            String callingPackage = activity.getCallingPackage();
            String str = TAG;
            LogUtil.d(str, "handleWeiboResponse getCallingPackage : " + callingPackage);
            if (TextUtils.isEmpty(stringExtra2)) {
                LogUtil.e(TAG, "handleWeiboResponse faild intent _weibo_transaction is null");
                return false;
            } else if (ApiUtils.validateWeiboSign(this.mContext, stringExtra) || stringExtra.equals(activity.getPackageName())) {
                response.onResponse(new SendMessageToWeiboResponse(intent.getExtras()));
                return true;
            } else {
                LogUtil.e(TAG, "handleWeiboResponse faild appPackage validateSign faild");
                return false;
            }
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean isSupportWeiboPay() {
        return getWeiboAppSupportAPI() >= 10353;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean isWeiboAppInstalled() {
        WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
        return weiboInfo != null && weiboInfo.isLegal();
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean isWeiboAppSupportAPI() {
        return getWeiboAppSupportAPI() >= 10350;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean launchWeibo(Activity activity) {
        if (!isWeiboAppInstalled()) {
            LogUtil.e(TAG, "launchWeibo faild WeiboInfo is null");
            return false;
        }
        try {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(this.mWeiboInfo.getPackageName()));
            return true;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            return false;
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean launchWeiboPay(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("rawdata", str);
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, 4);
        bundle.putString(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
        return launchWeiboActivity(activity, WBConstants.ACTIVITY_WEIBO_PAY, this.mWeiboInfo.getPackageName(), this.mAppKey, bundle, WBConstants.ACTION_LOG_TYPE_PAY);
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean launchWeiboPayLogin(Activity activity, String str) {
        if (Utility.isWeiBoVersionSupportNewPay(activity).booleanValue()) {
            if (activity == null) {
                LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("rawdata", str);
            bundle.putInt(WBConstants.COMMAND_TYPE_KEY, 4);
            String valueOf = String.valueOf(System.currentTimeMillis());
            bundle.putString(WBConstants.TRAN, valueOf);
            Intent intent = new Intent();
            intent.setPackage(this.mWeiboInfo.getPackageName());
            intent.setData(Uri.parse(WBPageConstants.Scheme.SDK_DELIVER_SCHEME));
            String packageName = activity.getPackageName();
            intent.putExtra(WBConstants.Base.SDK_VER, WBConstants.WEIBO_SDK_VERSION_CODE);
            intent.putExtra(WBConstants.Base.APP_PKG, packageName);
            intent.putExtra(WBConstants.Base.APP_KEY, this.mAppKey);
            intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
            intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(activity, packageName)));
            intent.putExtra(WBConstants.SDK_REAL_ACTION, WBConstants.ACTIVITY_WEIBO_PAY);
            intent.putExtra(WBConstants.SDK_IS_SCHEME, false);
            intent.putExtra(WBConstants.SDK_REQUESTCODE, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
            intent.putExtra(WBConstants.TRAN, valueOf);
            addEventLog(activity, valueOf, WBConstants.ACTION_LOG_TYPE_PAY);
            intent.putExtras(bundle);
            try {
                String str2 = TAG;
                LogUtil.d(str2, "launchWeiboActivity intent=" + intent + ", extra=" + intent.getExtras());
                activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                return true;
            } catch (ActivityNotFoundException e) {
                LogUtil.e(TAG, e.getMessage());
                return false;
            }
        }
        return launchWeiboPay(activity, str);
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean registerApp() {
        sendBroadcast(this.mContext, WBConstants.ACTION_WEIBO_REGISTER, this.mAppKey, null, null);
        return true;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean sendRequest(Activity activity, BaseRequest baseRequest) {
        int msgType;
        if (baseRequest == null) {
            LogUtil.e(TAG, "sendRequest faild request is null");
            return false;
        }
        try {
            if (checkEnvironment(this.mNeedDownloadWeibo)) {
                if (!baseRequest.check(this.mContext, this.mWeiboInfo, new VersionCheckHandler())) {
                    LogUtil.e(TAG, "sendRequest faild request check faild");
                    return false;
                }
                WbAppActivator.getInstance(this.mContext, this.mAppKey).activateApp();
                Bundle bundle = new Bundle();
                baseRequest.toBundle(bundle);
                if (baseRequest instanceof SendMultiMessageToWeiboRequest) {
                    try {
                        SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = (SendMultiMessageToWeiboRequest) baseRequest;
                        if (sendMultiMessageToWeiboRequest.multiMessage != null && (msgType = sendMultiMessageToWeiboRequest.multiMessage.getMsgType()) != 0) {
                            bundle.putInt(WBConstants.Msg.SHEAR_TYPE, msgType);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return launchWeiboActivity(activity, WBConstants.ACTIVITY_WEIBO, this.mWeiboInfo.getPackageName(), this.mAppKey, bundle, "share");
            }
            return false;
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage());
            return false;
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean sendRequest(Activity activity, BaseRequest baseRequest, AuthInfo authInfo, String str, WeiboAuthListener weiboAuthListener) {
        if (baseRequest == null) {
            LogUtil.e(TAG, "sendRequest faild request is null !");
            return false;
        } else if (isWeiboAppInstalled() && isWeiboAppSupportAPI()) {
            if (getWeiboAppSupportAPI() < 10351 && (baseRequest instanceof SendMultiMessageToWeiboRequest)) {
                SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = (SendMultiMessageToWeiboRequest) baseRequest;
                SendMessageToWeiboRequest sendMessageToWeiboRequest = new SendMessageToWeiboRequest();
                sendMessageToWeiboRequest.packageName = sendMultiMessageToWeiboRequest.packageName;
                sendMessageToWeiboRequest.transaction = sendMultiMessageToWeiboRequest.transaction;
                sendMessageToWeiboRequest.message = adapterMultiMessage2SingleMessage(sendMultiMessageToWeiboRequest.multiMessage);
                return sendRequest(activity, sendMessageToWeiboRequest);
            }
            return sendRequest(activity, baseRequest);
        } else {
            return startShareWeiboActivity(activity, str, baseRequest, weiboAuthListener);
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean sendResponse(BaseResponse baseResponse) {
        if (baseResponse == null) {
            LogUtil.e(TAG, "sendResponse failed response null");
            return false;
        } else if (!baseResponse.check(this.mContext, new VersionCheckHandler())) {
            LogUtil.e(TAG, "sendResponse check fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseResponse.toBundle(bundle);
            sendBroadcast(this.mContext, WBConstants.ACTION_WEIBO_RESPONSE, this.mAppKey, baseResponse.reqPackageName, bundle);
            return true;
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public void shareMessageToWeiyou(Context context, Bundle bundle) {
        Utility.shareMessagetoWeibo(context, WBPageConstants.Scheme.SHARETOWEIYOU, bundle);
    }
}
