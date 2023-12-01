package com.taobao.tao.remotebusiness.login;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.xstate.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/login/LoginHandler.class */
public class LoginHandler extends Handler implements onLoginListener {
    public static final int LOGIN_CANCEL = 911103;
    public static final int LOGIN_FAILED = 911102;
    public static final int LOGIN_SUCCESS = 911101;
    public static final int LOGIN_TIMEOUT = 911104;
    private static final String TAG = "mtop.rb-LoginHandler";
    private static LoginHandler mHandler;

    private LoginHandler(Looper looper) {
        super(looper);
    }

    private static void checkXStateSessionInfo() {
        LoginContext loginContext = RemoteLogin.getLoginContext();
        if (loginContext == null) {
            return;
        }
        try {
            if (!StringUtils.a(loginContext.sid) || loginContext.sid.equals(a.a())) {
                return;
            }
            Mtop.a(SDKConfig.a().b()).a(loginContext.sid, loginContext.userId);
            TBSdkLog.b(TAG, "[checkXStateSessionInfo] invoked");
        } catch (Exception e) {
            TBSdkLog.d(TAG, "[checkXStateSessionInfo] error ---" + e.toString());
        }
    }

    public static LoginHandler instance() {
        LoginHandler loginHandler;
        synchronized (LoginHandler.class) {
            try {
                if (mHandler == null) {
                    mHandler = new LoginHandler(Looper.getMainLooper());
                }
                loginHandler = mHandler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return loginHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        TBSdkLog.a(TAG, "The RemoteBusiness handler message received.");
        switch (message.what) {
            case LOGIN_SUCCESS /* 911101 */:
                TBSdkLog.b(TAG, "onReceive: NOTIFY_LOGIN_SUCCESS.");
                checkXStateSessionInfo();
                com.taobao.tao.remotebusiness.a.a();
                break;
            case LOGIN_FAILED /* 911102 */:
                TBSdkLog.b(TAG, "onReceive: NOTIFY_LOGINFAILED.");
                str = "FAIL_SYS_LOGIN_FAIL";
                str2 = "登陆失败";
                com.taobao.tao.remotebusiness.a.a(str, str2);
                break;
            case LOGIN_CANCEL /* 911103 */:
                TBSdkLog.b(TAG, "onReceive: NOTIFY_LOGINCANCEL.");
                str = "FAIL_SYS_LOGIN_CANCEL";
                str2 = "登陆被取消";
                com.taobao.tao.remotebusiness.a.a(str, str2);
                break;
            case LOGIN_TIMEOUT /* 911104 */:
                if (RemoteLogin.isSessionValid()) {
                    TBSdkLog.b(TAG, "Session valid, Broadcast may missed!");
                    checkXStateSessionInfo();
                    com.taobao.tao.remotebusiness.a.a();
                    return;
                }
                return;
            default:
                return;
        }
        removeMessages(LOGIN_TIMEOUT);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginCancel() {
        sendEmptyMessage(LOGIN_CANCEL);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginFail() {
        sendEmptyMessage(LOGIN_FAILED);
    }

    @Override // com.taobao.tao.remotebusiness.login.onLoginListener
    public void onLoginSuccess() {
        sendEmptyMessage(LOGIN_SUCCESS);
    }
}
