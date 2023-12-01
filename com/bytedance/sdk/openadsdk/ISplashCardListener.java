package com.bytedance.sdk.openadsdk;

import android.app.Activity;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/ISplashCardListener.class */
public interface ISplashCardListener {
    Activity getActivity();

    void onSplashClickEyeClose();

    void onSplashEyeReady();

    void setSupportSplashClickEye(boolean z);
}
