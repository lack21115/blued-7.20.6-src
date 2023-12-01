package com.kwad.components.core.offline.init.kwai;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/kwai/b.class */
final class b implements ICache {
    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int ux = com.kwad.sdk.core.config.d.ux();
        if (ux >= 0) {
            return ux == 0 ? str : com.kwad.sdk.core.videocache.b.a.ba(KsAdSDKImpl.get().getContext()).cS(str);
        }
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
        if (aX == null || !aX.exists()) {
            return null;
        }
        return aX.getAbsolutePath();
    }
}
