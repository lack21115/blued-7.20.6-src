package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.network.IIdc;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/kwai/j.class */
public final class j implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.c.sb();
        }
        return "https://" + com.kwad.sdk.core.network.idc.a.wm().C(str, null);
    }
}
