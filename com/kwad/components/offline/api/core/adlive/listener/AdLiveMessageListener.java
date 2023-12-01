package com.kwad.components.offline.api.core.adlive.listener;

import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/listener/AdLiveMessageListener.class */
public interface AdLiveMessageListener {
    void handleAdLiveMessage(List<AdLiveMessageInfo> list);
}
