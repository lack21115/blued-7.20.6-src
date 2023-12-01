package com.taobao.tao.remotebusiness.auth;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/auth/AuthListener.class */
public interface AuthListener {
    void onAuthCancel(String str, String str2);

    void onAuthFail(String str, String str2);

    void onAuthSuccess();
}
