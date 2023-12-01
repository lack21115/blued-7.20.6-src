package com.kwad.components.core.offline.init.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.sdk.components.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/a/a.class */
public final class a implements ILive {
    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2) {
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar == null || !aVar.hasLiveCompoReady()) {
            return null;
        }
        return aVar.getAdLivePlayModule(iAdLiveOfflineView, str, str2);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i) {
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar == null || !aVar.hasLiveCompoReady()) {
            return null;
        }
        return aVar.getView(context, i);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveEndRequest mIAdLiveEndRequest(String str) {
        com.kwad.components.core.offline.api.kwai.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = (com.kwad.components.core.offline.api.kwai.a) c.f(com.kwad.components.core.offline.api.kwai.a.class)) == null || !aVar.hasLiveCompoReady()) {
            return null;
        }
        return aVar.getAdLiveEndRequest(str);
    }
}
