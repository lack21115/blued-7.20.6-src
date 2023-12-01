package com.anythink.china.api;

import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/api/OaidSDKCallbackListener.class */
public interface OaidSDKCallbackListener extends IIdentifierListener {
    void OnSupport(boolean z, IdSupplier idSupplier);

    void onSupport(IdSupplier idSupplier);
}
