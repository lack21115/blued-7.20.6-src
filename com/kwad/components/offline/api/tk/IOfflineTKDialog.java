package com.kwad.components.offline.api.tk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/IOfflineTKDialog.class */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z, String str);

    int getDialogId();

    String getStyleTemplate();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
