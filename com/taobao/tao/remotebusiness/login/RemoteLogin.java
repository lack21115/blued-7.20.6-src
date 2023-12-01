package com.taobao.tao.remotebusiness.login;

import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/login/RemoteLogin.class */
public class RemoteLogin {
    public static final String TAG = "mtop.rb-Login";
    private static IRemoteLogin login;

    public static IRemoteLogin getLogin() {
        if (login == null) {
            DefaultLoginImpl defaultLoginImpl = DefaultLoginImpl.getDefaultLoginImpl();
            login = defaultLoginImpl;
            if (defaultLoginImpl == null) {
                TBSdkLog.d(TAG, "login is null");
                throw new LoginNotImplementException("Login Not Implement!");
            }
        }
        return login;
    }

    public static LoginContext getLoginContext() {
        return getLogin().getLoginContext();
    }

    public static boolean isSessionValid() {
        IRemoteLogin login2 = getLogin();
        if (login2.isLogining()) {
            return false;
        }
        return login2.isSessionValid();
    }

    public static void login(boolean z) {
        login(z, null);
    }

    public static void login(boolean z, Object obj) {
        IRemoteLogin login2 = getLogin();
        if (login2.isLogining()) {
            return;
        }
        TBSdkLog.b(TAG, "call login");
        if (obj != null && (login2 instanceof DefaultLoginImpl)) {
            ((DefaultLoginImpl) login2).setSessionInvalid(obj);
        }
        login2.login(LoginHandler.instance(), z);
        LoginHandler.instance().sendEmptyMessageDelayed(LoginHandler.LOGIN_TIMEOUT, 20000L);
    }

    public static void setLoginImpl(IRemoteLogin iRemoteLogin) {
        login = iRemoteLogin;
    }
}
