package com.anythink.rewardvideo.unitgroup.api;

import android.app.Activity;
import com.anythink.core.api.ATBaseAdAdapter;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/unitgroup/api/CustomRewardVideoAdapter.class */
public abstract class CustomRewardVideoAdapter extends ATBaseAdAdapter {
    public CustomRewardedVideoEventListener mImpressionListener;

    public void clearImpressionListener() {
        this.mImpressionListener = null;
    }

    public final void internalShow(Activity activity, CustomRewardedVideoEventListener customRewardedVideoEventListener) {
        this.mImpressionListener = customRewardedVideoEventListener;
        try {
            show(activity);
        } catch (Throwable th) {
            th.printStackTrace();
            CustomRewardedVideoEventListener customRewardedVideoEventListener2 = this.mImpressionListener;
            if (customRewardedVideoEventListener2 != null) {
                customRewardedVideoEventListener2.onRewardedVideoAdPlayFailed("", "exception, show failed: " + th.getMessage());
            }
        }
    }

    public abstract void show(Activity activity);
}
