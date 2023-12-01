package com.qq.e.ads.dfa;

import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/dfa/IGDTApkListener.class */
public interface IGDTApkListener {
    void onApkLoad(GDTApk gDTApk);

    void onError(AdError adError);
}
