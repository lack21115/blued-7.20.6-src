package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/network/adapter/NetworkingAdapter.class */
public class NetworkingAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> extends m<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final OfflineCompoNetworking<R, T> mOfflineCompoNetworking;

    public NetworkingAdapter(OfflineCompoNetworking<R, T> offlineCompoNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNetworking;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public RequestAdapter<R> createRequest() {
        final R createRequest = this.mOfflineCompoNetworking.createRequest();
        return (RequestAdapter<R>) new RequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter.1
            @Override // com.kwad.sdk.core.network.b
            public boolean encryptDisable() {
                return createRequest.encryptDisable();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public JSONObject getBody() {
                return createRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public Map<String, String> getBodyMap() {
                return createRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public Map<String, String> getHeader() {
                return createRequest.getHeader();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.RequestAdapter
            public R getOfflineCompoRequest() {
                return (R) createRequest;
            }

            @Override // com.kwad.sdk.core.network.b
            public String getRequestHost() {
                return createRequest.getRequestHost();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public String getUrl() {
                return createRequest.getUrl();
            }
        };
    }

    @Override // com.kwad.sdk.core.network.m
    public boolean enableMonitorReport() {
        return this.mOfflineCompoNetworking.enableMonitorReport();
    }

    @Override // com.kwad.sdk.core.network.m
    public boolean isPostByJson() {
        return this.mOfflineCompoNetworking.isPostByJson();
    }

    protected void onResponse(RequestAdapter<R> requestAdapter, c cVar) {
        super.onResponse((NetworkingAdapter<R, T>) requestAdapter, cVar);
        this.mOfflineCompoNetworking.onResponse(requestAdapter.getOfflineCompoRequest(), cVar);
    }

    @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(g gVar, c cVar) {
        onResponse((RequestAdapter) ((RequestAdapter) gVar), cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.m
    public ResultDataAdapter<T> parseData(String str) {
        return new ResultDataAdapter<>(this.mOfflineCompoNetworking.parseData(str));
    }
}
