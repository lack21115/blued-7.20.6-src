package com.anythink.banner.unitgroup.api;

import android.view.View;
import com.anythink.core.api.ATBaseAdAdapter;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/unitgroup/api/CustomBannerAdapter.class */
public abstract class CustomBannerAdapter extends ATBaseAdAdapter {
    public CustomBannerEventListener mImpressionEventListener;

    public abstract View getBannerView();

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return getBannerView() != null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final void releaseLoadResource() {
        super.releaseLoadResource();
    }

    public final void setAdEventListener(CustomBannerEventListener customBannerEventListener) {
        this.mImpressionEventListener = customBannerEventListener;
    }
}
