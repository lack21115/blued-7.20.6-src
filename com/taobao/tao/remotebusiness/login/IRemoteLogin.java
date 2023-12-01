package com.taobao.tao.remotebusiness.login;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/login/IRemoteLogin.class */
public interface IRemoteLogin {
    LoginContext getLoginContext();

    boolean isLogining();

    boolean isSessionValid();

    void login(onLoginListener onloginlistener, boolean z);
}
