package com.bytedance.android.livehostapi.platform;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/livehostapi/platform/TokenRefreshCallback.class */
public interface TokenRefreshCallback {
    void onFailed(Throwable th);

    void onSuccess(TokenInfo tokenInfo);
}
