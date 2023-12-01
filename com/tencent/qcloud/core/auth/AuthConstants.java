package com.tencent.qcloud.core.auth;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/AuthConstants.class */
public class AuthConstants {
    static final int EXPIRE_TIME_RESERVE_IN_SECONDS = 60;
    public static final String Q_AK = "q-ak";
    public static final String Q_HEADER_LIST = "q-header-list";
    public static final String Q_KEY_TIME = "q-key-time";
    public static final String Q_SIGNATURE = "q-signature";
    public static final String Q_SIGN_ALGORITHM = "q-sign-algorithm";
    public static final String Q_SIGN_TIME = "q-sign-time";
    public static final String Q_URL_PARAM_LIST = "q-url-param-list";
    public static final String SHA1 = "sha1";

    private AuthConstants() {
        throw new AssertionError("AuthConstants is static class");
    }
}
