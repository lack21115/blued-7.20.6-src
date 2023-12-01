package com.kwad.components.core.offline.api.kwai;

import android.content.Context;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/api/kwai/a.class */
public interface a extends com.kwad.sdk.components.a {
    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2);

    IAdLiveOfflineView getView(Context context, int i);

    boolean hasLiveCompoReady();
}
