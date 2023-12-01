package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/kwai/d.class */
public final class d implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.b.g XN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwad.sdk.core.webview.b.g gVar) {
        this.XN = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.b.g gVar = this.XN;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
