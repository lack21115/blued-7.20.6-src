package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/ILive.class */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
