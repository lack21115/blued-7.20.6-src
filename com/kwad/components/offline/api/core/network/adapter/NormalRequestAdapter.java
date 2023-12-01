package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.sdk.core.network.o;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/adapter/NormalRequestAdapter.class */
public abstract class NormalRequestAdapter<R extends IOfflineCompoRequest> implements o {
    public abstract R getOfflineCompoRequest();
}
