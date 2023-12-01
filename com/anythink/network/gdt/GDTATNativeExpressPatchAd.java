package com.anythink.network.gdt;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATNativeExpressPatchAd.class */
public class GDTATNativeExpressPatchAd extends GDTATNativeExpressAd {
    /* JADX INFO: Access modifiers changed from: protected */
    public GDTATNativeExpressPatchAd(Context context, String str, int i, int i2, int i3, int i4, int i5, String str2) {
        super(context, str, i, i2, i3, i4, i5, str2);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }
}
