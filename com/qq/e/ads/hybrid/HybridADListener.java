package com.qq.e.ads.hybrid;

import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/hybrid/HybridADListener.class */
public interface HybridADListener {
    void onClose();

    void onError(AdError adError);

    void onLoadFinished();

    void onPageShow();
}
