package com.qiniu.pili.droid.shortvideo;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLAuthenticationResultCallback.class */
public interface PLAuthenticationResultCallback {
    public static final int Authorized = 1;
    public static final int UnAuthorized = 0;
    public static final int UnCheck = -1;

    void onAuthorizationResult(int i);
}
