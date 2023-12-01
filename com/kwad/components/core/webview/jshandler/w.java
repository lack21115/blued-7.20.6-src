package com.kwad.components.core.webview.jshandler;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/w.class */
public final class w implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/w$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String playableExtraData;
    }

    public w(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getKsPlayableAdData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        try {
            aVar.playableExtraData = this.mBridgeContext.getAdTemplate().adInfoList.get(0).adStyleInfo.playableExtraData;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
