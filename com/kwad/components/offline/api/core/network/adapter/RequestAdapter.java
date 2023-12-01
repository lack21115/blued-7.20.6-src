package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.sdk.core.network.d;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/adapter/RequestAdapter.class */
public abstract class RequestAdapter<R extends IOfflineCompoRequest> extends d {
    public abstract R getOfflineCompoRequest();
}
