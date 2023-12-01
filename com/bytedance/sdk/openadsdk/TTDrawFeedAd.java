package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTDrawFeedAd.class */
public interface TTDrawFeedAd extends TTFeedAd {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTDrawFeedAd$DrawVideoListener.class */
    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i);
}
