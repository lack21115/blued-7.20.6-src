package com.kwad.components.offline.api.core.adlive;

import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/adlive/IAdLiveEndRequest.class */
public interface IAdLiveEndRequest {
    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getUrl();

    Map<String, String> getUrlParam();
}
