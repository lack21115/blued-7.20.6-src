package com.kwad.components.offline.tk.kwai;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.h;
import com.kwad.sdk.components.i;
import com.kwad.sdk.components.j;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/kwai/c.class */
public final class c implements IOfflineHostActionHandler {
    private final j mHostActionHandler;

    public c(j jVar) {
        this.mHostActionHandler = jVar;
    }

    private com.kwad.sdk.components.g a(final IOfflineTKDialog iOfflineTKDialog) {
        return new com.kwad.sdk.components.g() { // from class: com.kwad.components.offline.tk.kwai.c.2
            @Override // com.kwad.sdk.components.g
            public final void a(i iVar) {
                iOfflineTKDialog.registerJSCallHandler(new e(iVar));
            }

            @Override // com.kwad.sdk.components.g
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.g
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.g
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKDialog.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.g
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.g
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }
        };
    }

    private h a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new h() { // from class: com.kwad.components.offline.tk.kwai.c.1
            @Override // com.kwad.sdk.components.h
            public final void a(i iVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new e(iVar));
            }

            @Override // com.kwad.sdk.components.h
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.h
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.h
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.h
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.h
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.h
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        j jVar = this.mHostActionHandler;
        if (jVar != null) {
            jVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        j jVar = this.mHostActionHandler;
        if (jVar != null) {
            jVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        j jVar = this.mHostActionHandler;
        if (jVar != null) {
            jVar.a(a(iOfflineTKNativeIntent));
        }
    }
}
