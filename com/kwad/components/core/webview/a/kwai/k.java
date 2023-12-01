package com.kwad.components.core.webview.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/k.class */
public final class k extends v {
    b UI = new b() { // from class: com.kwad.components.core.webview.a.kwai.k.1
        @Override // com.kwad.components.core.webview.a.kwai.k.b
        public final void z(long j) {
            if (k.this.nN != null) {
                a aVar = new a((byte) 0);
                aVar.creativeId = j;
                k.this.nN.a(aVar);
            }
        }
    };
    private com.kwad.sdk.core.webview.b.c nN;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/k$a.class */
    static final class a implements com.kwad.sdk.core.b {
        public long creativeId;

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
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/k$b.class */
    public interface b {
        void z(long j);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
        com.kwad.components.core.d.b.a.a(this.UI);
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.components.core.d.b.a.b(this.UI);
    }
}
