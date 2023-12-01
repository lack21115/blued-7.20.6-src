package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aw.class */
public class aw implements com.kwad.sdk.core.webview.b.a {
    private a Un;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/aw$a.class */
    public interface a {
        boolean dC();
    }

    public aw(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.j.k.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    public final void a(a aVar) {
        this.Un = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.Un;
        boolean dC = aVar != null ? aVar.dC() : true;
        com.kwad.sdk.core.d.b.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + dC);
        if (dC) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
