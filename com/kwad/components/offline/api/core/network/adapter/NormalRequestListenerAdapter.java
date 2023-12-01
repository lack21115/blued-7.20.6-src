package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/adapter/NormalRequestListenerAdapter.class */
public class NormalRequestListenerAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements h<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public NormalRequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    public void onError(NormalRequestAdapter<R> normalRequestAdapter, int i, String str) {
        this.mRequestListener.onError(normalRequestAdapter.getOfflineCompoRequest(), i, str);
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onError(g gVar, int i, String str) {
        onError((NormalRequestAdapter) ((NormalRequestAdapter) gVar), i, str);
    }

    public void onStartRequest(NormalRequestAdapter<R> normalRequestAdapter) {
        this.mRequestListener.onStartRequest(normalRequestAdapter.getOfflineCompoRequest());
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onStartRequest(g gVar) {
        onStartRequest((NormalRequestAdapter) ((NormalRequestAdapter) gVar));
    }

    public void onSuccess(NormalRequestAdapter<R> normalRequestAdapter, NormalResultDataAdapter<T> normalResultDataAdapter) {
        this.mRequestListener.onSuccess(normalRequestAdapter.getOfflineCompoRequest(), normalResultDataAdapter.getOfflineCompoResultData());
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
        onSuccess((NormalRequestAdapter) ((NormalRequestAdapter) gVar), (NormalResultDataAdapter) ((NormalResultDataAdapter) baseResultData));
    }
}
