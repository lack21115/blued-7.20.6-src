package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sina.sso.RemoteSSO;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.register.mobile.MobileRegisterActivity;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.Utility;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/sso/SsoHandler.class */
public class SsoHandler {
    public static final String AUTH_FAILED_MSG = "auth failed!!!!!";
    public static final String AUTH_FAILED_NOT_INSTALL_MSG = "not install weibo client!!!!!";
    private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
    private static final int REQUEST_CODE_MOBILE_REGISTER = 40000;
    private static final int REQUEST_CODE_SSO_AUTH = 32973;
    private static final String TAG = "Weibo_SSO_login";
    private Activity mAuthActivity;
    private AuthInfo mAuthInfo;
    private WeiboAuthListener mAuthListener;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.sina.weibo.sdk.auth.sso.SsoHandler.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
            try {
                String packageName = asInterface.getPackageName();
                String activityName = asInterface.getActivityName();
                SsoHandler.this.mAuthActivity.getApplicationContext().unbindService(SsoHandler.this.mConnection);
                if (SsoHandler.this.startSingleSignOn(packageName, activityName)) {
                    return;
                }
                SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
        }
    };
    private int mSSOAuthRequestCode;
    private WebAuthHandler mWebAuthHandler;
    private WeiboAppManager.WeiboInfo mWeiboInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/sso/SsoHandler$AuthType.class */
    public enum AuthType {
        ALL,
        SsoOnly,
        WebOnly;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static AuthType[] valuesCustom() {
            AuthType[] valuesCustom = values();
            int length = valuesCustom.length;
            AuthType[] authTypeArr = new AuthType[length];
            System.arraycopy(valuesCustom, 0, authTypeArr, 0, length);
            return authTypeArr;
        }
    }

    public SsoHandler(Activity activity, AuthInfo authInfo) {
        this.mAuthActivity = activity;
        this.mAuthInfo = authInfo;
        this.mWebAuthHandler = new WebAuthHandler(activity, authInfo);
        this.mWeiboInfo = WeiboAppManager.getInstance(activity).getWeiboInfo();
        AidTask.getInstance(this.mAuthActivity).aidTaskInit(authInfo.getAppKey());
    }

    private void authorize(int i, WeiboAuthListener weiboAuthListener, AuthType authType) {
        this.mSSOAuthRequestCode = i;
        this.mAuthListener = weiboAuthListener;
        boolean z = authType == AuthType.SsoOnly;
        if (authType == AuthType.WebOnly) {
            if (weiboAuthListener != null) {
                this.mWebAuthHandler.anthorize(weiboAuthListener);
            }
        } else if (bindRemoteSSOService(this.mAuthActivity.getApplicationContext())) {
        } else {
            if (!z) {
                this.mWebAuthHandler.anthorize(this.mAuthListener);
                return;
            }
            WeiboAuthListener weiboAuthListener2 = this.mAuthListener;
            if (weiboAuthListener2 != null) {
                weiboAuthListener2.onWeiboException(new WeiboException(AUTH_FAILED_NOT_INSTALL_MSG));
            }
        }
    }

    private boolean bindRemoteSSOService(Context context) {
        if (isWeiboAppInstalled()) {
            String packageName = this.mWeiboInfo.getPackageName();
            Intent intent = new Intent(DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME);
            intent.setPackage(packageName);
            return context.bindService(intent, this.mConnection, 1);
        }
        return false;
    }

    public static ComponentName isServiceExisted(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            ComponentName componentName = runningServiceInfo.service;
            if (componentName.getPackageName().equals(str)) {
                String className = componentName.getClassName();
                if (className.equals(String.valueOf(str) + ".business.RemoteSSOService")) {
                    return componentName;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startSingleSignOn(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtras(this.mWebAuthHandler.getAuthInfo().getAuthBundle());
        intent.putExtra(WBConstants.COMMAND_TYPE_KEY, 3);
        String valueOf = String.valueOf(System.currentTimeMillis());
        intent.putExtra(WBConstants.TRAN, valueOf);
        addEventLog(this.mAuthActivity, valueOf, WBConstants.ACTION_LOG_TYPE_SSO);
        intent.putExtra("aid", Utility.getAid(this.mAuthActivity, this.mAuthInfo.getAppKey()));
        if (SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
            String aid = Utility.getAid(this.mAuthActivity, this.mAuthInfo.getAppKey());
            if (!TextUtils.isEmpty(aid)) {
                intent.putExtra("aid", aid);
            }
            try {
                this.mAuthActivity.startActivityForResult(intent, this.mSSOAuthRequestCode);
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
        return false;
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

    public void authorize(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.ALL);
        WbAppActivator.getInstance(this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        LogUtil.d(TAG, "requestCode: " + i + ", resultCode: " + i2 + ", data: " + intent);
        if (i != this.mSSOAuthRequestCode) {
            if (i == REQUEST_CODE_MOBILE_REGISTER) {
                if (i2 == -1) {
                    Bundle extras = intent.getExtras();
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(extras);
                    if (parseAccessToken == null || !parseAccessToken.isSessionValid()) {
                        return;
                    }
                    LogUtil.d(TAG, "Login Success! " + parseAccessToken.toString());
                    this.mAuthListener.onComplete(extras);
                } else if (i2 == 0) {
                    if (intent == null) {
                        LogUtil.d(TAG, "Login canceled by user.");
                        this.mAuthListener.onCancel();
                        return;
                    }
                    LogUtil.d(TAG, "Login failed: " + intent.getStringExtra("error"));
                    String stringExtra = intent.getStringExtra("error");
                    String str = stringExtra;
                    if (stringExtra == null) {
                        str = intent.getStringExtra(PushMessageHelper.ERROR_TYPE);
                    }
                    if (str != null) {
                        this.mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("error_description")));
                    }
                }
            }
        } else if (i2 != -1) {
            if (i2 == 0) {
                if (intent == null) {
                    LogUtil.d(TAG, "Login canceled by user.");
                    this.mAuthListener.onCancel();
                    return;
                }
                LogUtil.d(TAG, "Login failed: " + intent.getStringExtra("error"));
                this.mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
            }
        } else if (SecurityHelper.checkResponseAppLegal(this.mAuthActivity, this.mWeiboInfo, intent)) {
            String stringExtra2 = intent.getStringExtra("error");
            String str2 = stringExtra2;
            if (stringExtra2 == null) {
                str2 = intent.getStringExtra(PushMessageHelper.ERROR_TYPE);
            }
            if (str2 == null) {
                Bundle extras2 = intent.getExtras();
                Oauth2AccessToken parseAccessToken2 = Oauth2AccessToken.parseAccessToken(extras2);
                if (parseAccessToken2 == null || !parseAccessToken2.isSessionValid()) {
                    LogUtil.d(TAG, "Failed to receive access token by SSO");
                    this.mWebAuthHandler.anthorize(this.mAuthListener);
                    return;
                }
                LogUtil.d(TAG, "Login Success! " + parseAccessToken2.toString());
                this.mAuthListener.onComplete(extras2);
            } else if (str2.equals("access_denied") || str2.equals("OAuthAccessDeniedException")) {
                LogUtil.d(TAG, "Login canceled by user.");
                this.mAuthListener.onCancel();
            } else {
                String stringExtra3 = intent.getStringExtra("error_description");
                String str3 = str2;
                if (stringExtra3 != null) {
                    str3 = String.valueOf(str2) + ":" + stringExtra3;
                }
                LogUtil.d(TAG, "Login failed: " + str3);
                this.mAuthListener.onWeiboException(new WeiboDialogException(str3, i2, stringExtra3));
            }
        }
    }

    public void authorizeClientSso(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.SsoOnly);
        WbAppActivator.getInstance(this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
    }

    public void authorizeWeb(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.WebOnly);
        WbAppActivator.getInstance(this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
    }

    public boolean isWeiboAppInstalled() {
        WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
        return weiboInfo != null && weiboInfo.isLegal();
    }

    public void registerOrLoginByMobile(String str, WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
        Intent intent = new Intent(this.mAuthActivity, MobileRegisterActivity.class);
        Bundle authBundle = this.mAuthInfo.getAuthBundle();
        authBundle.putString(MobileRegisterActivity.REGISTER_TITLE, str);
        intent.putExtras(authBundle);
        this.mAuthActivity.startActivityForResult(intent, REQUEST_CODE_MOBILE_REGISTER);
    }
}
