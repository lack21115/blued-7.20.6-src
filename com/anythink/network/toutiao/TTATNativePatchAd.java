package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativePatchAd.class */
public class TTATNativePatchAd extends TTATNativeAd {
    public TTATNativePatchAd(Context context, String str, TTNativeAd tTNativeAd, boolean z, Bitmap bitmap, int i) {
        super(context, str, tTNativeAd, z, bitmap, i);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }

    @Override // com.anythink.network.toutiao.TTATNativeAd
    public void setAdData(boolean z, Bitmap bitmap, int i) {
        super.setAdData(z, bitmap, i);
    }
}
