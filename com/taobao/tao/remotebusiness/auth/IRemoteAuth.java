package com.taobao.tao.remotebusiness.auth;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/auth/IRemoteAuth.class */
public interface IRemoteAuth {
    void authorize(String str, String str2, String str3, boolean z, AuthListener authListener);

    String getAuthToken();

    boolean isAuthInfoValid();

    boolean isAuthorizing();
}
