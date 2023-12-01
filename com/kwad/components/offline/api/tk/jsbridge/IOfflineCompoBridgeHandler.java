package com.kwad.components.offline.api.tk.jsbridge;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/jsbridge/IOfflineCompoBridgeHandler.class */
public interface IOfflineCompoBridgeHandler {
    String getKey();

    void handleJsCall(String str, IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
