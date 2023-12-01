package com.anythink.network.gdt;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATNativePatchAd.class */
public class GDTATNativePatchAd extends GDTATNativeAd {
    /* JADX INFO: Access modifiers changed from: protected */
    public GDTATNativePatchAd(Context context, NativeUnifiedADData nativeUnifiedADData, int i, int i2, int i3) {
        super(context, nativeUnifiedADData, i, i2, i3);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }
}
