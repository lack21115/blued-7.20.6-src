package com.kwad.components.core.webview.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/e.class */
public final class e extends v {
    private final b UD;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/e$a.class */
    static final class a implements com.kwad.sdk.core.b {
        public int height;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/e$b.class */
    public interface b {
        int iZ();
    }

    public e(b bVar) {
        this.UD = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.UD;
        if (bVar != null) {
            aVar.height = bVar.iZ();
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
