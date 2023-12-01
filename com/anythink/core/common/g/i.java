package com.anythink.core.common.g;

import com.anythink.core.api.AdError;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/i.class */
public interface i {
    void onLoadCanceled(int i);

    void onLoadError(int i, String str, AdError adError);

    void onLoadFinish(int i, Object obj);

    void onLoadStart(int i);
}
