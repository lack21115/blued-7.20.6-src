package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ak.class */
public class ak implements e.b {
    @Override // com.baidu.mobads.sdk.internal.e.b
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADStatusChanged();
        }
    }
}
