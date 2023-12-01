package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.utils.ao;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/kwai/b.class */
public final class b implements IOfflineCompoBridgeHandler {
    private final com.kwad.sdk.core.webview.b.a XJ;

    public b(com.kwad.sdk.core.webview.b.a aVar) {
        ao.checkNotNull(aVar);
        this.XJ = aVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final String getKey() {
        return this.XJ.getKey();
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void handleJsCall(String str, IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.XJ.handleJsCall(str, new a(iOfflineCompoCallBackFunction));
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void onDestroy() {
        this.XJ.onDestroy();
    }
}
