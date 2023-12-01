package com.qq.e.ads.nativ;

import com.qq.e.ads.NativeAbstractAD;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/nativ/NativeADUnifiedListener.class */
public interface NativeADUnifiedListener extends NativeAbstractAD.BasicADListener {
    void onADLoaded(List<NativeUnifiedADData> list);
}
