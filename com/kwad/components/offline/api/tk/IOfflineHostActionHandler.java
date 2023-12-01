package com.kwad.components.offline.api.tk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/IOfflineHostActionHandler.class */
public interface IOfflineHostActionHandler {
    void dismissDialog(IOfflineTKDialog iOfflineTKDialog);

    void showDialog(IOfflineTKDialog iOfflineTKDialog);

    void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent);
}
