package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.NativeAdError;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/listener/INativeAdListener.class */
public interface INativeAdListener {
    void onAdError(NativeAdError nativeAdError, INativeAdData iNativeAdData);

    void onAdFailed(NativeAdError nativeAdError);

    void onAdSuccess(List<INativeAdData> list);
}
