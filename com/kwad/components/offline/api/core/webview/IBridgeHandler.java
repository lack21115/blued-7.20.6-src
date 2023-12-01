package com.kwad.components.offline.api.core.webview;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/webview/IBridgeHandler.class */
public interface IBridgeHandler {
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
