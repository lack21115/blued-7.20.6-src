package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/adapter/RequestListenerAdapter.class */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements h<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    public void onError(RequestAdapter<R> requestAdapter, int i, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onError(g gVar, int i, String str) {
        onError((RequestAdapter) ((RequestAdapter) gVar), i, str);
    }

    public void onStartRequest(RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onStartRequest(g gVar) {
        onStartRequest((RequestAdapter) ((RequestAdapter) gVar));
    }

    public void onSuccess(RequestAdapter<R> requestAdapter, ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
        onSuccess((RequestAdapter) ((RequestAdapter) gVar), (ResultDataAdapter) ((ResultDataAdapter) baseResultData));
    }
}
