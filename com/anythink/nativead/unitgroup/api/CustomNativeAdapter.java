package com.anythink.nativead.unitgroup.api;

import com.anythink.core.api.ATBaseAdAdapter;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/unitgroup/api/CustomNativeAdapter.class */
public abstract class CustomNativeAdapter extends ATBaseAdAdapter {
    public int mRequestNum = 1;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final boolean isAdReady() {
        return false;
    }

    public void setRequestNum(int i) {
        if (i > 0) {
            this.mRequestNum = i;
        }
    }
}
