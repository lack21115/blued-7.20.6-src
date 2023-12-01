package com.kwad.components.ad.reward.h;

import com.kwad.components.core.webview.a.kwai.v;
import com.kwad.components.core.webview.jshandler.ai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/o.class */
public final class o extends v implements ai.b {
    private com.kwad.components.core.playable.a oP;

    public o(com.kwad.components.ad.reward.j jVar) {
        com.kwad.components.core.playable.a aVar = jVar.oP;
        this.oP = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ai.b
    public final void a(ai.a aVar) {
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.oP;
        if (aVar != null) {
            aVar.b(this);
            this.oP = null;
        }
    }
}
