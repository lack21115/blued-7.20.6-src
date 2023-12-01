package com.kwad.components.ad.reward.b;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b/e.class */
public final class e implements com.kwad.sdk.core.webview.b.a {
    private String TAG;
    private com.kwad.sdk.core.webview.b.c nN;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b/e$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String ru;
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.d.b.d(str, "create: ");
    }

    private void T(String str) {
        if (TextUtils.isEmpty(str) || this.nN == null) {
            return;
        }
        a aVar = new a();
        aVar.ru = str;
        this.nN.a(aVar);
    }

    public final void gV() {
        com.kwad.sdk.core.d.b.d(this.TAG, "notifyDialogClose: ");
        T("close");
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        String str2 = this.TAG;
        com.kwad.sdk.core.d.b.d(str2, "handleJsCall: " + cVar);
        this.nN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.b.d(this.TAG, "onDestroy: ");
        this.nN = null;
    }
}
