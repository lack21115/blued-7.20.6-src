package com.anythink.interstitial.unitgroup.api;

import android.app.Activity;
import com.anythink.core.api.ATBaseAdAdapter;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/unitgroup/api/CustomInterstitialAdapter.class */
public abstract class CustomInterstitialAdapter extends ATBaseAdAdapter {
    public CustomInterstitialEventListener mImpressListener;

    public void clearImpressionListener() {
        this.mImpressListener = null;
    }

    public final void internalShow(Activity activity, CustomInterstitialEventListener customInterstitialEventListener) {
        this.mImpressListener = customInterstitialEventListener;
        try {
            show(activity);
        } catch (Throwable th) {
            th.printStackTrace();
            CustomInterstitialEventListener customInterstitialEventListener2 = this.mImpressListener;
            if (customInterstitialEventListener2 != null) {
                customInterstitialEventListener2.onInterstitialAdVideoError("", "exception, show failed: " + th.getMessage());
            }
        }
    }

    public abstract void show(Activity activity);
}
