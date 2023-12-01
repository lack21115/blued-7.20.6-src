package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/u.class */
public final class u implements com.kwad.sdk.core.webview.b.a {
    protected b SF;
    protected final com.kwad.sdk.core.webview.b mBridgeContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/u$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/u$b.class */
    public interface b {
        void a(a aVar);
    }

    public u(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    public final void a(b bVar) {
        this.SF = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        b bVar = this.SF;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.width = this.mBridgeContext.LD.getWidth();
            aVar.height = this.mBridgeContext.LD.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
