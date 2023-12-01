package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/kwai/a.class */
public final class a implements com.kwad.sdk.core.webview.b.c {
    private final IOfflineCompoCallBackFunction XI;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.XI = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.b.c
    public final void a(com.kwad.sdk.core.b bVar) {
        String jSONObject = new com.kwad.sdk.core.webview.b.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.XI;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.c
    public final void onError(int i, String str) {
        String jSONObject = new com.kwad.sdk.core.webview.b.e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.XI;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }
}
